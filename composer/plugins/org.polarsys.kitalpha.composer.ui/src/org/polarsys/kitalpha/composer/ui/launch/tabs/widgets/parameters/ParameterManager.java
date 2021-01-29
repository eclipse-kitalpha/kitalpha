/*******************************************************************************
 * Copyright (c) 2014, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/

/**
 * 
 */
package org.polarsys.kitalpha.composer.ui.launch.tabs.widgets.parameters;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

import org.polarsys.kitalpha.cadence.ui.api.dialog.IParameterManager;
import org.polarsys.kitalpha.composer.api.Parameter;
import org.polarsys.kitalpha.composer.api.ParameterError;
import org.polarsys.kitalpha.composer.extension.points.CodeManagerExtensions;
import org.polarsys.kitalpha.composer.extension.points.ParameterizedComposerElement;
import org.polarsys.kitalpha.composer.ui.Activator;
import org.polarsys.kitalpha.composer.ui.launch.tabs.ComposerHelper;

/**
 * @author Guillaume Gebhart
 *
 */
public class ParameterManager implements IParameterManager{

	
	
	@Override
	public String validParameter(Object parameter_p, Object container_p, Map<String,String> parameters_p){
		String result = "";
		
		Parameter param = (Parameter)parameter_p;
		String name = param.getName();
		Map<String, ParameterError> map = validAllParamaters((IConfigurationElement)container_p, parameters_p);
		if(map!= null){
			ParameterError error = map.get(name);
			if(error != null){
				result = formatter(name, error);
			}
		}
		return  result;
		
	}
	
	
	
	private String formatter(String name, ParameterError error) {
		String result = name +":" + error.getReason();
		return result;
	}


	
	
	public Map<String, ParameterError> validAllParamaters(IConfigurationElement element_p, Map<String,String> map){
		Map<String, ParameterError> result = null;
		ParameterizedComposerElement parameterizedComposerElement;
		try {
			parameterizedComposerElement = (ParameterizedComposerElement) element_p.createExecutableExtension(CodeManagerExtensions.ATT_CLASS);
		
		
		 result = parameterizedComposerElement
		.validateParameters(ComposerHelper.buildMapFromString(
				map, parameterizedComposerElement));
		
		} catch (CoreException e) {
			Activator.getDefault().getLog().log(e.getStatus());
		}
		return result;
	}
	
	
	

	@Override
	public String getName(Object o){
		String string = null;
		if (o instanceof Parameter) {
			Parameter parameter = (Parameter)o;
			string = parameter.getName();
		}
		return string;
	}
	
	@Override
	public String getDescription(Object o){
		String string = null;
		
		if (o instanceof Parameter) {
			Parameter parameter = (Parameter)o;
			string = parameter.getDescription();
		}
		return string;
	}
}
