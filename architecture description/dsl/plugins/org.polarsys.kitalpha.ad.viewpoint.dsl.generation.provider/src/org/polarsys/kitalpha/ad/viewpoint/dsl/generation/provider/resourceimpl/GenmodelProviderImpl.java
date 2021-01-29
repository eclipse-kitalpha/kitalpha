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
 ******************************************************************************/

package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.provider.resourceimpl;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.provider.exception.ViewpointResourceException;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.provider.resource.AbstractCoreResourceProvider;

/**
 * @author Boubekeur Zendagui
 */

public class GenmodelProviderImpl extends AbstractCoreResourceProvider{
	private enum PluginKind {
		Model, Edit, Editor, Tests
	}
	
	/**
	 * @return the generated GenModel
	 * @throws ViewpointResourceException
	 */
	public GenModel getGenModel() throws ViewpointResourceException{
		GenModel genModel = null;
		
		EObject rootElement = getRootElement();
		if (rootElement != null)
			genModel = (GenModel) rootElement;
		
		return genModel;
	}
	
	public GenPackage getGenPackage() throws ViewpointResourceException{
		GenPackage genPackage = null;
		
		GenModel genModel = getGenModel();
		if (genModel != null)
			genPackage = genModel.getGenPackages().get(0);
		
		return genPackage;
	}
	
	public String getModelPluginName() throws ViewpointResourceException{
		return getProjectID(PluginKind.Model);
	}
	
	public String getEditPluginName() throws ViewpointResourceException{
		return getProjectID(PluginKind.Edit);
	}
	
	public String getEditorPluginName() throws ViewpointResourceException{
		return getProjectID(PluginKind.Editor);
	}
	
	public String getTestPluginName() throws ViewpointResourceException{
		return getProjectID(PluginKind.Tests);
	}
	
	private String getProjectID(PluginKind kind) throws ViewpointResourceException {
		GenModel genModel = getGenModel();
		if (genModel != null )
		{
			switch (kind) {
			case Model:
				return genModel.getModelPluginID();
			case Edit: 
				return genModel.getEditPluginID();
			case Editor:
				return genModel.getEditorPluginID();
			case Tests:
				return genModel.getTestsPluginID();
			}
		}
		
		throw new ViewpointResourceException(getResourceFileInformations(), ViewpointResourceException.IS_NULL);
	}
	
	
	@Override
	protected void loadResourceFromFile() {
		super.loadResourceFromFile();
		reloadGenModel();
	}
	
	
	@Override
	public void refresh() {
		reloadGenModel();
		super.refresh();
	}
	
	private void reloadGenModel(){
		try {
			GenModel genModel = getGenModel();
			genModel.reconcile();
            genModel.setCanGenerate(true);
            genModel.setValidateModel(true);
            genModel.diagnose();
            genModel.validate();
		} catch (ViewpointResourceException e) {
			e.printStackTrace();
		}
	}

}
