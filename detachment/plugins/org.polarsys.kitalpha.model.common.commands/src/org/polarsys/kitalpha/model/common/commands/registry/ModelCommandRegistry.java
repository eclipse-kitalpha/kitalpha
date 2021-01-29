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
package org.polarsys.kitalpha.model.common.commands.registry;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.polarsys.kitalpha.model.common.commands.action.ModelCommand;
import org.polarsys.kitalpha.model.common.commands.constants.Constants;

/**
 * @author Faycal Abka
 */
public class ModelCommandRegistry {
	
	private static Logger LOGGER = Logger.getLogger(ModelCommandRegistry.class);
	
	private Map<String, RegistryActionElement> registry;
	
	public final static ModelCommandRegistry INSTANCE = new ModelCommandRegistry();
	
	private ModelCommandRegistry(){
		this.registry = new HashMap<String, RegistryActionElement>();
	}
	
	
	public Map<String, RegistryActionElement> initRegistry(){
		
		dispose();
		
		//Read all extensions
		IExtension [] extensions = RegistryHelper.getAllExtensionsFor(Constants.COMMAND_EXTENSION_POINT);
		
		if (extensions != null && extensions.length > 0){
			for (IExtension extension : extensions) {
				for(IConfigurationElement config: extension.getConfigurationElements()){
					if (config.getName().equals(Constants.COMMAND)){
						String id = config.getAttribute(Constants.COMMAND_ID);
						String finderId = config.getAttribute(Constants.COMMAND_SCRUTINIZE_ID);
						String className = config.getAttribute(Constants.COMMAND_CLASS);
						String workflow = config.getAttribute(Constants.WORKFLOW_ATTR);
						
						try {
							if (className != null && !className.isEmpty()){
								String priorityStr = config.getAttribute(Constants.PRIORITY_ATTR);
								float priority = Float.parseFloat(priorityStr);
								
								Object action = config.createExecutableExtension(Constants.COMMAND_CLASS);
								ModelCommand modelAction = (ModelCommand)action;

								if (finderId != null && !finderId.isEmpty()) {
									modelAction.setModelAnalysisID(finderId);
								}
								
								modelAction.SetWorkflow(WorkflowType.getWorkflowEnumItemFromString(workflow));

								registry.put(id, new RegistryActionElement(priority, modelAction));
							}
						} catch (CoreException e) {
							e.printStackTrace();
							LOGGER.error(e.getMessage(), e);
						}
					}
				}
			}
		}
		
		return registry;
	}
	
	
	public void dispose(){
		this.registry.clear();
	}
	
	
	public static class RegistryActionElement implements Comparable<RegistryActionElement>{
		
		private final float priority;
		private ModelCommand action;
		
		public RegistryActionElement(float priority, ModelCommand action){
			this.priority = priority;
			this.action = action;
		}

		public float getPriority() {
			return priority;
		}

		public ModelCommand getAction() {
			return action;
		}


		@Override
		public int compareTo(RegistryActionElement arg0) {
			
			if (getPriority() - arg0.getPriority() < 0) {
				return 1;
			}
			
			return 0;
		}	
	}
}
