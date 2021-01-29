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
package org.polarsys.kitalpha.cadence.core.api;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

import org.polarsys.kitalpha.cadence.core.internal.CadenceExtensions;





/**
 * 
 * This class allows to get activities, workflows, etc... contributing
 * at the Cadence extensions points. 
 * @author Guillaume Gebhart
 *
 */

public class CadenceRegistry {



	
	 public static IConfigurationElement[] getAllWorkflowElement(String workflowId) {
		 return CadenceExtensions.getAllWorkflowElement(workflowId);
		
	 }
	 
	 public static IConfigurationElement[] getWorkflowElementParameters(String workflowId,String workflowElementId) {
		IConfigurationElement config = CadenceExtensions.getWorkflowElement(workflowId, workflowElementId);
		 return CadenceExtensions.getWorkflowElementParameters(config);
	 }
	 
	 public static IConfigurationElement[] getActivitiesConfigList(String workflowId, String workflowElementId) {
		 return CadenceExtensions.getActivitiesForWorkflowElement(workflowId, workflowElementId);
		
	 }
	 
	 public static IConfigurationElement getActivity(String id) {
		 return CadenceExtensions.getActivityConfigElement(id);
		
	 }
	 
	 public static boolean isMultiple(IConfigurationElement element){
			
			 return Boolean.parseBoolean(element.getAttribute(CadenceExtensions.ATT_MULTIPLE_ACTIVTY));
		 }
	 
	 public static String getDescription(IConfigurationElement element){
		IConfigurationElement[] children =  element.getChildren(CadenceExtensions.ATT_DESCRIPTION);
		String res = ""; //$NON-NLS-1$
		if(children != null) {
			res = children[0].getValue();
		}
		return res;
	 }
	 
	 public static String getIdentifier(IConfigurationElement element){
		 return element.getAttribute(CadenceExtensions.ATT_IDENTIFIER);
	 }
	 
	 public static String getName(IConfigurationElement element){
		 return element.getAttribute(CadenceExtensions.ATT_NAME);
	 } 
	 
	 public static String getOrderNumber(IConfigurationElement element){
		 return element.getAttribute(CadenceExtensions.ATT_ORDER_NUMBER);
	 } 
	 
	 public static IActivity getIActivityClass(IConfigurationElement element){
			
		 IActivity activity = null;
		 if(element!= null){
		 try {
				activity = (IActivity)element.createExecutableExtension(CadenceExtensions.ATT_ACTIVITY_CLASS);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 return activity;
	 }
	 
	 
	 
	 public static IActivity getIActivityClassFromId(String id){
		 IConfigurationElement config = CadenceExtensions.getActivityConfigElement(id);
		 return getIActivityClass(config);
		
	 }
	 
}
