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

package org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.helper.extension;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.helper.configuration.VpDslConfigurationHelper;

/**
 * @author Boubekeur Zendagui
 */

public class ExtensionManager {
	
	private final static String diagram_filter_extension_point = 
					"org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.helper.diagramfilter"; //$NON-NLS-N$

	/**
	 * @param anyModelElement Element element of viewpoint description model
	 * @return No null list containing all declared target application extensions
	 */
	public static List<String> getDiagramFilters(EObject anyModelElement){
		// Load available extension for a given TargetApplication
		String modelTargetApplication = VpDslConfigurationHelper.getTargetApplication(anyModelElement);
		IConfigurationElement[] config =Platform.getExtensionRegistry().getConfigurationElementsFor(diagram_filter_extension_point);
		
		List<String> result = new ArrayList<String>();
		if (config.length != 0)
		{
			for (IConfigurationElement iConfigurationElement : config) 
			{
				if (iConfigurationElement.getName().equals("Filter"))
				{
					String tApplication = iConfigurationElement.getAttribute("TargetApplication");
					if (tApplication.trim().equalsIgnoreCase(modelTargetApplication.trim()))
						result.add(iConfigurationElement.getAttribute("ModelFileExtension"));
				}
			}
		}
		
		return result;
	}
}
