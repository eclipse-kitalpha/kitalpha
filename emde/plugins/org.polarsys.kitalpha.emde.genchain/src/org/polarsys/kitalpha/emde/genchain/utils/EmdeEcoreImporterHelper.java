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
/**
 * 
 */
package org.polarsys.kitalpha.emde.genchain.utils;

import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.common.helper.ObjectHolder;
import org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration;
import org.eclipse.egf.portfolio.genchain.tools.utils.EcoreImporterHelper;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.importer.ecore.EcoreImporter;
import org.eclipse.search.core.text.TextSearchEngine;
import org.eclipse.search.core.text.TextSearchRequestor;
import org.eclipse.search.core.text.TextSearchScope;
import org.eclipse.search.ui.text.FileTextSearchScope;

/**
 * @author Thomas Guiu
 * 
 */
public class EmdeEcoreImporterHelper extends EcoreImporterHelper {

	public static EcoreImporter createEcoreImporter(IPath containterPath, URI ecoreURI, EmfGeneration model) throws Exception {
		  EcoreImporter importer = doCreateEcoreImporter(
		            new EmdeEcoreImporterHelper(), containterPath, ecoreURI, model);
		    importer.getGenModel().setComplianceLevel(GenJDKLevel.JDK50_LITERAL);
		    return importer;
	}

	@Override
	protected void handleMissingGenmodel(ResourceSet resourceSet, GenModel genModel, IPath ecorePath) {
		String fileName = ecorePath.removeFileExtension().addFileExtension("genmodel").lastSegment();

		// look up in the workspace
		TextSearchScope fScope = FileTextSearchScope.newWorkspaceScope(new String[] { fileName }, false);
		final ObjectHolder<IFile> genModelFile = new ObjectHolder<IFile>();
		TextSearchRequestor collector = new TextSearchRequestor() {
			@Override
			public boolean acceptFile(IFile file) throws CoreException {
				genModelFile.object = file;
				return super.acceptFile(file);
			}
		};
		Pattern searchPattern = Pattern.compile("");
		TextSearchEngine.create().search(fScope, collector, searchPattern, null);
		if (genModelFile.object == null) {
			throw new IllegalStateException("Cannot find genmodel for model " + ecorePath);
		}
		URI uri = URI.createPlatformResourceURI(genModelFile.object.getFullPath().toString(), false);
		Resource resource = resourceSet.getResource(uri, true);
		if (resource != null && !resource.getContents().isEmpty()) {
			for (EObject obj : resource.getContents()) {
				genModel.getUsedGenPackages().addAll(((GenModel) obj).getGenPackages());
			}
		} else {
			super.handleMissingGenmodel(resourceSet, genModel, ecorePath);
		}
	}

}
