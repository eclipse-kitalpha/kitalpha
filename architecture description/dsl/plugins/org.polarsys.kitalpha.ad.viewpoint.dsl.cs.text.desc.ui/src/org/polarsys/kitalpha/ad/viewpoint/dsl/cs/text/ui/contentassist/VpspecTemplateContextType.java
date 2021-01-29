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

package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui.contentassist;

import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateVariable;
import org.eclipse.jface.text.templates.TemplateVariableResolver;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui.callback.VpspecEditorCallback.AspectAddedListener;



/**
 * 
 * @author Amine Lajmi
 *
 */
public class VpspecTemplateContextType extends CommonTemplateContextType implements AspectAddedListener{
	
	private static String currentFile;
	
	@Override
	protected void addDefaultTemplateVariables() {
		super.addDefaultTemplateVariables();
		addResolver(new VpspecTemplateVariableResolver.AspectName());
	}
	
	@Override
	public void resolve(TemplateVariable variable, TemplateContext context) {
		String type= variable.getType();
		TemplateVariableResolver resolver= getResolver(type);
		if (resolver == null) {
			resolver= new VpspecTemplateVariableResolver();
		}
		if (resolver instanceof VpspecTemplateVariableResolver.AspectName) {
			((VpspecTemplateVariableResolver.AspectName)resolver).setFileName(currentFile);
		} 
		super.resolve(variable, context);
	}

	@Override
	public void notifyResolver(String proposal) {
		setCurrentFile(proposal);
	}
	
	private static void setCurrentFile(String currentFile) {
		VpspecTemplateContextType.currentFile = currentFile;
	}
}
