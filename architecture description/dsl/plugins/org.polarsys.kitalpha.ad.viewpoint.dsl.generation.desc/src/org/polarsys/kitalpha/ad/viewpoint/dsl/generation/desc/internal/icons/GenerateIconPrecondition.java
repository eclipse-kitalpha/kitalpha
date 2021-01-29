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

package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.internal.icons;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.provider.exception.ViewpointResourceException;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.provider.resourceimpl.GenmodelProviderImpl;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.provider.resourceimpl.ViewpointResourceProviderRegistry;

/**
 * @author Boubekeur Zendagui
 */
public class GenerateIconPrecondition {

	public static boolean generateIcon(){
		GenmodelProviderImpl genmodelProvider = ViewpointResourceProviderRegistry.getInstance().getGenmodelProvider();
		/** If the GenModel provider is not initialized, so GenModel is not available in the workspace */
		if (genmodelProvider == null) {
			return false;
		}
		
		/** If we are here, it means that GenModel exist in the workspace. So we have to check 
		    if the Edit plug-in exists too */ 
		
		try {
			String editPluginName = genmodelProvider.getEditPluginName();
			IProject editPlugin = ResourcesPlugin.getWorkspace().getRoot().getProject(editPluginName);
			return editPlugin.exists();
		} catch (ViewpointResourceException e) {
			return false;
		}
	}
	
}
