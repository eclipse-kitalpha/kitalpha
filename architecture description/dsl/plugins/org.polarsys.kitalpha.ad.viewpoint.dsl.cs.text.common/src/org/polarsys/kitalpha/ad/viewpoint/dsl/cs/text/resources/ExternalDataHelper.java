/*******************************************************************************
 * Copyright (c) 2014, 2020 Thales Global Services S.A.S.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License 2.0 which is available at
 *  http://www.eclipse.org/legal/epl-2.0
 *  
 *  SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/

package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.resources;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.identifiers.MetamodelIDs;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.registry.DataWorkspaceEPackage;

import com.google.common.collect.Lists;

/**
 *
 * @author Amine Lajmi
 *         Faycal ABKA
 *
 */
public class ExternalDataHelper {

	private static final String MetamodelLoader_ExtensionPoint = "org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.common.externaldataloader";
	private static final String MetamodelLoader_configElement = "externaldataloader";
	private static final String MetamodelLoader_id = "id";
	private static final String NamespacePattern_configElement = "NamespacePattern";
	private static final String NamespacePattern_value = "value";
	private static final String TargetApplication = "target";

	public static final String EMF_TARGET = "EMF";

	private static Map<String, List<Pattern>> metamodelLoaders;
	private static Map<String, List<Pattern>> metamodelLoadersTarget; // <Target, List of nsuri patterns

	private static Map<String, URI> packagesInScopeURIs;

	// <target, scope>
	private static final Map<String, Map<String, URI>> packagesInScopeURIsTarget = Collections.synchronizedMap(new LinkedHashMap<String, Map<String, URI>>());

	private ExternalDataHelper() {}

	public static Map<String, URI> getPackagesInScopeURIs() {
		if ((packagesInScopeURIs != null) && !packagesInScopeURIs.isEmpty()) {
			return packagesInScopeURIs;
		}
		try {
			return lookupPackagesInScopeURis();
		} catch (final CoreException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Map<String, URI> getPackagesInScopeURIs(final String target) {
		if ((packagesInScopeURIsTarget != null) && (packagesInScopeURIsTarget.get(target) != null) && !packagesInScopeURIsTarget.get(target).isEmpty()) {
			return packagesInScopeURIsTarget.get(target);
		}
		try {
			lookupPackagesInScopeURis(); // Initialize the target
			return packagesInScopeURIsTarget.get(target);
		} catch (final CoreException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Map<String, List<Pattern>> getAvailableMetamodelLoaders() {
		if ((metamodelLoaders != null) && !metamodelLoaders.isEmpty()) {
			return metamodelLoaders;
		}
		try {
			return lookupMetamodelLoaders();
		} catch (final CoreException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Map<String, URI> lookupPackagesInScopeURis() throws CoreException {
		packagesInScopeURIs = Collections.synchronizedMap(new LinkedHashMap<String, URI>());
		metamodelLoaders = getAvailableMetamodelLoaders();
		for (Map.Entry<String, List<Pattern>> loaderEntry: metamodelLoaders.entrySet()) {
			final List<Pattern> patternList = loaderEntry.getValue();
			// Delegate finding packages to contributed loaders
			final Map<String, URI> packagesFound = findPackagesInScopeURIs(patternList);
			for (final Map.Entry<String, URI> candidate : packagesFound.entrySet()) {
				if (!packagesInScopeURIs.containsKey(candidate.getKey())) {
					packagesInScopeURIs.put(candidate.getKey(), candidate.getValue());
				}
			}
		}

		// Merge EMF target with others, because EMF is available every time
		for (final String target : metamodelLoadersTarget.keySet()) {
			if (!target.equals("EMF")) {
				merge(EMF_TARGET, target);
			}
		}

		for (Map.Entry<String, List<Pattern>> loaderTargetEntry: metamodelLoadersTarget.entrySet()) {
			final List<Pattern> patternList = loaderTargetEntry.getValue();
			final Map<String, URI> packagesFound = findPackagesInScopeURIs(patternList);

			for (final Map.Entry<String, URI> candidate : packagesFound.entrySet()) {
				final Map<String, URI> targetPatterns = packagesInScopeURIsTarget.get(loaderTargetEntry.getKey());
				if (!targetPatterns.containsKey(candidate)) {
					targetPatterns.put(candidate.getKey(), candidate.getValue());
				}
			}
		}

		return packagesInScopeURIs;
	}

	public static Map<String, List<Pattern>> lookupMetamodelLoaders() throws CoreException {
		metamodelLoaders = new HashMap<>();
		metamodelLoadersTarget = new HashMap<>();
		final IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(MetamodelLoader_ExtensionPoint);
		if (config.length != 0) {
			for (final IConfigurationElement iConfigElement : config) {
				if (iConfigElement.getName().equalsIgnoreCase(MetamodelLoader_configElement)) {
					// Get the loader
					final String loaderId = iConfigElement.getAttribute(MetamodelLoader_id);
					final String target = iConfigElement.getAttribute(TargetApplication);

					final List<Pattern> availablePatterns = Lists.newArrayList();

					packagesInScopeURIsTarget.put(target, Collections.synchronizedMap(new LinkedHashMap<String, URI>()));

					final IConfigurationElement[] patterns = iConfigElement.getChildren();
					// Get the patterns
					for (final IConfigurationElement candidate : patterns) {
						if (candidate.getName().equalsIgnoreCase(NamespacePattern_configElement)) {
							final String value = candidate.getAttribute(NamespacePattern_value);
							final Pattern namespacePattern = Pattern.compile(value);
							availablePatterns.add(namespacePattern);
						}
					}
					metamodelLoaders.put(loaderId, availablePatterns);
					metamodelLoadersTarget.put(target, availablePatterns);
				}
			}
		}
		return metamodelLoaders;
	}

	public static boolean isPackageInScopeURIs(final EPackage ePackage) {
		metamodelLoaders = getAvailableMetamodelLoaders();
		for (final Map.Entry<String, URI> candidatePackage : getPackagesFromRegistry().entrySet()) {
			for (Map.Entry<String, List<Pattern>> loaderEntry: metamodelLoaders.entrySet()) {
				final List<Pattern> patternList = loaderEntry.getValue();
				for (final Pattern candidate : patternList) {
					if (candidate.matcher(candidatePackage.getKey()).matches()) {
						return true;
					}
				}
			}
			if (MetamodelIDs.VPDSL_NAMESPACE_PATTERN.matcher(candidatePackage.getKey()).matches()) {
				return true;
			}
		}
		return false;
	}

	public static Map<String, URI> findPackagesInScopeURIs(final List<Pattern> namespacePatterns) {
		final Map<String, URI> packagesInScopeURIs = Collections.synchronizedMap(new LinkedHashMap<String, URI>());
		for (final Map.Entry<String, URI> entry : getPackagesFromRegistry().entrySet()) {
			for (final Pattern candidate : namespacePatterns) {
				if (candidate.matcher(entry.getKey()).matches()) {
					packagesInScopeURIs.put(entry.getKey(), entry.getValue());
				}
			}
		}
		return packagesInScopeURIs;
	}

	public static Map<String, URI> getPackagesFromRegistry() {
		return EcorePlugin.getEPackageNsURIToGenModelLocationMap(false);
	}

	public static EPackage loadEPackage(final String resourceOrNsURI, final ResourceSet resourceSet) {
		if (resourceSet.getPackageRegistry().containsKey(resourceOrNsURI)) {
			return resourceSet.getPackageRegistry().getEPackage(resourceOrNsURI);
		}
		final URI uri = URI.createURI(resourceOrNsURI);
		try {
			if ("http".equalsIgnoreCase(uri.scheme())) {
				DataWorkspaceEPackage.INSTANCE.initializeDataWorkspaceRegistry(ResourcesPlugin.getWorkspace());
				final EPackage ecoreModel = DataWorkspaceEPackage.INSTANCE.getEPackage(uri.toString());

				if (ecoreModel != null) {
					resourceSet.getResources().add(ecoreModel.eResource());
					return ecoreModel;
				}
			}
			if (uri.fragment() == null) {
				final Resource resource = resourceSet.getResource(uri, true);
				if (resource.getContents().isEmpty()) {
					return null;
				}
				return (EPackage) resource.getContents().get(0);
			}
			return (EPackage) resourceSet.getEObject(uri, true);
		} catch (final RuntimeException ex) {
			if (uri.isPlatformResource()) {
				final String platformString = uri.toPlatformString(true);
				final URI platformPluginURI = ResourceHelper.URIFix.createPlatformPluginURI(platformString, true);
				return loadEPackage(platformPluginURI.toString(), resourceSet);
			}
			return null;
		}
	}

	/**
	 * Merge the values of target1 in the values of target2
	 * @param target1
	 * @param target2
	 */
	private static void merge(final String target1, final String target2) {
		final List<Pattern> patternListTarget1 = metamodelLoadersTarget.get(target1);
		metamodelLoadersTarget.get(target2).addAll(patternListTarget1);
	}
}
