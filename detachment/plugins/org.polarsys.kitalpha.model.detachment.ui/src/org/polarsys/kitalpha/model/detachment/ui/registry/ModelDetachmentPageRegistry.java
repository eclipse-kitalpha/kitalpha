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
package org.polarsys.kitalpha.model.detachment.ui.registry;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.ui.IEditorPart;
import org.polarsys.kitalpha.model.detachment.ui.constants.Constants;
import org.polarsys.kitalpha.model.detachment.ui.page.AbstractDetachmentFormPage;

/**
 * @author Faycal Abka
 */

public class ModelDetachmentPageRegistry {
	
	private static Logger LOGGER = Logger.getLogger(ModelDetachmentPageRegistry.class);
	
	private Set<AbstractDetachmentFormPage> registry;
	
	public final static ModelDetachmentPageRegistry INSTANCE = new ModelDetachmentPageRegistry();
	
	private ModelDetachmentPageRegistry(){
		this.registry = new HashSet<AbstractDetachmentFormPage>();
	}
	
	
	public Set<AbstractDetachmentFormPage> initRegistry(IEditorPart editor){
		
		dispose();
		
		IExtension[] extensions = RegistryHelper.getAllExtensionsFor(Constants.PAGE_EXTENSION_POINT);
		
		if (extensions != null && extensions.length > 0){
			for (IExtension extension : extensions) {
				for (IConfigurationElement config : extension.getConfigurationElements()){
					if (config.getName().equals(Constants.PAGE_ATTRIBUTE)){
						String pageClass = config.getAttribute(Constants.CLASS_ATTRIBUTE);
						String id = config .getAttribute(Constants.ID_ATTRIBUTE);
						String title = config.getAttribute(Constants.TITLE_ATTRIBUTE);
						String finder_id = config.getAttribute(Constants.SCRUTINIZE_ID);
						
						String contributorID = config.getContributor().getName();
						//TODO handle when return is null, otherwise handle it in newformpageinstancewithparameters() by catching an exception
						Object page = RegistryHelper.newFormPageInstanceWithParameters(contributorID, pageClass, editor, id, title);
						
						AbstractDetachmentFormPage detachmentPage = (AbstractDetachmentFormPage)page;
						detachmentPage.setFinderID(finder_id);
						
						registry.add(detachmentPage);
					}
				}
			}
		} else {
			LOGGER.warn(org.polarsys.kitalpha.model.detachment.ui.Messages.MODEL_DETACHMENT_NO_EXTENSION_FOUND);
		}
		
		return registry;
	}
	
	public void dispose(){
		this.registry.clear();
	}


	public Set<AbstractDetachmentFormPage> getPageRegistry() {
		return this.registry;
	}
}
