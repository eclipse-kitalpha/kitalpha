/*******************************************************************************
 * Copyright (c) 2014, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.polarsys.kitalpha.emde.model.edit.provider.helpers;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;
import org.polarsys.kitalpha.emde.extension.i18n.Messages;
import org.polarsys.kitalpha.emde.extension.utils.EMFHelper;
import org.polarsys.kitalpha.emde.extension.utils.ExtensionAnnotationsHelper;
import org.polarsys.kitalpha.emde.model.EmdePackage;

/**
 * @author Xavier Maysonnave
 * 
 */
public final class EMDEHelper {

	public static final EPackage.Registry packageRegistry = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);

	public static final IPath FRAGMENT_PATH = new Path("fragment.xml"); //$NON-NLS-1$

	public static final IPath MANIFEST_PATH = new Path("META-INF/MANIFEST.MF"); //$NON-NLS-1$

	public static final IPath PLUGIN_PATH = new Path("plugin.xml"); //$NON-NLS-1$

	public static Collection<EClass> getExtendedElementEClasses(BasicDiagnostic basicDiagnostic, EClass eClass) {
		Collection<EClass> eClasses = new UniqueEList<EClass>();
		if ((eClass == null) || (eClass.eResource() == null)) {
			return eClasses;
		}
		for (String detail : ExtensionAnnotationsHelper.getExtendedElement(eClass)) {
			URI uri = URI.createURI(detail);
			if (uri.isRelative()) {
				basicDiagnostic.add(new BasicDiagnostic(Diagnostic.ERROR, "org.polarsys.kitalpha.emde", 0, NLS.bind(Messages._UI_GeneratingModelClass_ExtendedElement_Relative_URI_Error, eClass.getName(), detail), null));
			}
			try {
				String fragment = uri.fragment();
				URI nsURI = uri.trimFragment();
				// Try Package Registry
				EClass eClassTmp = getEClassFromPackageRegistry(nsURI, fragment);
				if (eClassTmp != null) {
					eClasses.add(eClassTmp);
					continue;
				}
				// Try namespace URI but load ecore from its genModel (warning
				// expensive operation)
				URI ecoreURI = getPlatformEcoreURIFromGenModel(nsURI);
				// We found something
				if (ecoreURI != null) {
					uri = ecoreURI.appendFragment(fragment);
				}

				// TODO KIT est ce bien utile ? de tout façon on ne peut pas
				// utiliser un resourceSet de cette manier (ie clear à la fin)
				// // Load either from ecore or if not found use the original
				// uri
				// // (probably a 'platform:/' uri scheme)
				// ResourceSet resourceSet = new ResourceSetImpl();
				// try {
				// resourceSet.setURIConverter(new PlatformURIConverter());
				// EObject eObject = resourceSet.getEObject(uri, true);
				// if (eObject instanceof EClass) {
				// eClasses.add((EClass) eObject);
				// }
				// } finally {
				// clear(resourceSet);
				// }
			} catch (WrappedException we) {
				basicDiagnostic.add(new BasicDiagnostic(Diagnostic.ERROR, "org.polarsys.kitalpha.emde", 0, NLS.bind(Messages._UI_GeneratingModelClass_ExtendedElement_URI_Error, eClass.getName(), detail), null));
			} catch (RuntimeException re) {
				basicDiagnostic.add(new BasicDiagnostic(Diagnostic.ERROR, "org.polarsys.kitalpha.emde", 0, NLS.bind(Messages._UI_GeneratingModelClass_ExtendedElement_Resource_Error, eClass.getName(), detail), null));
			}
		}

		return eClasses;
	}

	public static EClass getEClassFromPackageRegistry(URI namespaceURI, String fragment) {
		if (fragment == null) {
			return null;
		}
		int index = fragment.indexOf("//"); //$NON-NLS-1$
		if (index != -1 && fragment.length() > index + 2) {
			fragment = fragment.substring(index + 2);
		}
		// Locate an EClass from the package registry
		EPackage ePackage = packageRegistry.getEPackage(namespaceURI.toString());
		if (ePackage != null) {
			EClassifier eClassifier = ePackage.getEClassifier(fragment);
			if (eClassifier instanceof EClass) {
				return (EClass) eClassifier;
			}
		}
		return null;
	}

	public static URI getPlatformEcoreURIFromGenModel(URI namespaceURI) {
		// First we try if we face a platform runtime namespace URI
		URI genModelURI = EcorePlugin.getEPackageNsURIToGenModelLocationMap().get(namespaceURI.toString());
		if (genModelURI != null) {
			return getEcoreURIFromGenModel(namespaceURI, genModelURI);
		}
		return null;
	}

	public static URI getEcoreURIFromGenModel(URI namespaceURI, URI genModelURI) {
		ResourceSet resourceSet = new ResourceSetImpl();
		try {
			// resourceSet.setURIConverter(new PlatformURIConverter());
			Resource genModelResource = resourceSet.getResource(genModelURI, true);
			EcoreUtil.resolveAll(genModelResource);
			for (Resource resource : resourceSet.getResources()) {
				for (TreeIterator<?> j = new EcoreUtil.ContentTreeIterator<Object>(resource.getContents()) {

					private static final long serialVersionUID = 1L;

					@Override
					protected Iterator<? extends EObject> getEObjectChildren(EObject eObject) {
						return (eObject instanceof EPackage) ? ((EPackage) eObject).getESubpackages().iterator() : Collections.<EObject> emptyList().iterator();
					}
				}; j.hasNext();) {
					Object content = j.next();
					if (content instanceof EPackage) {
						EPackage ePackage = (EPackage) content;

						if (ePackage.getNsURI().toString().equals(namespaceURI.toString())) {
							return resource.getURI();
						}
					}
				}
			}
		} finally {
			clear(resourceSet);
		}

		return null;
	}

	public static Collection<EClass> getExtendedElement(BasicDiagnostic basicDiagnostic, EClass eClass) {
		Collection<EClass> eClasses = new UniqueEList<EClass>(getExtendedElementEClasses(basicDiagnostic, eClass));
		eClasses.addAll(getExtendedElementParentEClasses(basicDiagnostic, eClass));
		return eClasses;
	}

	public static Collection<EClass> getExtendedElementParentEClasses(BasicDiagnostic basicDiagnostic, EClass eClass) {
		Collection<EClass> eClasses = new UniqueEList<EClass>();
		if ((eClass == null) || (eClass.eResource() == null)) {
			return eClasses;
		}
		Collection<EClass> processedClasses = new UniqueEList<EClass>();
		processedClasses.add(eClass);
		return recursiveGetExtendedElementParentEClasses(basicDiagnostic, eClass, eClasses, processedClasses);		
	}
	
	private static Collection<EClass> recursiveGetExtendedElementParentEClasses(BasicDiagnostic basicDiagnostic,EClass eClass, Collection<EClass> alreadyCollectedClasses, Collection<EClass> alreadyProcessedClasses) {
		// Retrieve existing annotations
		List<EClass> eSuperTypes = eClass.getESuperTypes();
		if (!eSuperTypes.isEmpty()) {
			for(EClass eSuperType : eSuperTypes) {
				if (!alreadyProcessedClasses.contains(eSuperType)) {
					alreadyCollectedClasses.add(eSuperType);
					alreadyProcessedClasses.add(eSuperType);
					alreadyCollectedClasses.addAll(getExtendedElementEClasses(basicDiagnostic, eSuperType));
					alreadyCollectedClasses.addAll(recursiveGetExtendedElementParentEClasses(basicDiagnostic, eSuperType, alreadyCollectedClasses,alreadyProcessedClasses));
				}
			}
		}
		return alreadyCollectedClasses;
	}

	public static boolean isExtensibleElement(EClass object) {
		if (isSuperTypeOf(object, EmdePackage.Literals.EXTENSIBLE_ELEMENT)) {
			return true;
		}
		return false;
	}

	public static boolean isPluginProject(IProject project) {
		if (project.isOpen()) {
			return project.exists(MANIFEST_PATH) || project.exists(PLUGIN_PATH) || project.exists(FRAGMENT_PATH);
		}
		return false;
	}

	public static boolean isSuperTypeOf(EClass eClass, EClass type) {
		// Solve eClass against static package
		EClass seClass = (EClass) EMFHelper.solveAgainstStaticPackage(eClass);
		// Solve type against static package
		EClass stype = (EClass) EMFHelper.solveAgainstStaticPackage(type);
		// Current Type
		if (seClass == stype) {
			return true;
		}
		// Super Type
		for (EClass superType : seClass.getEAllSuperTypes()) {
			// Solve superType against static package
			superType = (EClass) EMFHelper.solveAgainstStaticPackage(superType);
			// Compare
			if (superType == stype) {
				return true;
			}
		}
		return false;
	}

	public static void validateExtendedElement(BasicDiagnostic basicDiagnostic, EClass eClass) {
		// Check existing annotations
		Collection<EClass> eClasses = getExtendedElementEClasses(basicDiagnostic, eClass);
		// Nothing to process
		if (eClasses.isEmpty()) {
			return;
		}
		// if annotations are available this EClass should be an Extension
		EClass seClass = (EClass) EMFHelper.solveAgainstStaticPackage(eClass);
		if (!isSuperTypeOf(seClass, EmdePackage.Literals.ELEMENT_EXTENSION)) {
			basicDiagnostic.add(new BasicDiagnostic(Diagnostic.ERROR, "org.polarsys.kitalpha.emde", 0, NLS.bind(Messages._UI_GeneratingModelClass_EMDE_Annotation_ElementExtension_Type_Error, eClass.getName()), null));
			return;
		}
		// Parent ExtendedElement
		Collection<EClass> parentExtendedElements = getExtendedElementParentEClasses(basicDiagnostic, eClass);
		// Deep analysis
		for (EClass extendedElement : eClasses) {
			// each extended element should be an Element
			if (!isSuperTypeOf(extendedElement, EmdePackage.Literals.EXTENSIBLE_ELEMENT)) {
				basicDiagnostic.add(new BasicDiagnostic(Diagnostic.ERROR, "org.polarsys.kitalpha.emde", 0, NLS.bind(Messages._UI_GeneratingModelClass_EMDE_Annotation_Element_Type_Error, eClass.getName(), extendedElement.getName()), null));
			}
			// Flat analysis
			for (EClass innerExtendedElement : eClasses) {
				// Ignore ourself
				if (extendedElement == innerExtendedElement) {
					continue;
				}
				// each extended elements shouldn't be a subtype of each other
				if (isSuperTypeOf(extendedElement, innerExtendedElement)) {
					basicDiagnostic.add(new BasicDiagnostic(Diagnostic.ERROR, "org.polarsys.kitalpha.emde", 0, NLS.bind(Messages._UI_GeneratingModelClass_EMDE_Annotation_Element_SubType_Error, new Object[] { eClass.getName(), innerExtendedElement.getName(), extendedElement.getName() }), null));
				}
			}
			// Parent analysis for each extended elements for top down approach
			// if necessary
			if (!parentExtendedElements.isEmpty()) {
				boolean found = false;
				for (EClass parentExtendedElement : parentExtendedElements) {
					// at least one parentExtendedElement should be a super type
					// of extendedElement
					if (isSuperTypeOf(extendedElement, parentExtendedElement)) {
						found = true;

						break;
					}
				}
				if (!found) {
					basicDiagnostic.add(new BasicDiagnostic(Diagnostic.ERROR, "org.polarsys.kitalpha.emde", 0, NLS.bind(Messages._UI_GeneratingModelClass_EMDE_Annotation_Element_Parent_SubType_Error, new Object[] { eClass.getName(), extendedElement.getName() }), null));
				}
			}
		}
	}

	private static void clear(ResourceSet set) {
		for (Resource r : set.getResources()) {
			r.unload();
		}
		set.getResources().clear();
	}

}
