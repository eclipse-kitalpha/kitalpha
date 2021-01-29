/*******************************************************************************
 * Copyright (c) 2016, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/

package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.helper.task;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;

public abstract class AbstractProjectUpdateTask implements ITaskProduction {

	protected static final String PORJECT_ID_CONTRACT = "project.id";
	
	protected String projectID;
	
	/**
	 * This method is used to apply a change on the given project. The change kind is not specified there.
	 * It should be implemented by derived tasks.
	 * 
	 * @param project the {@link IProject} on witch a modification will be done 
	 * @param productionContext the current {@link ITaskProductionContext} context
	 * @param monitor an {@link IProgressMonitor}
	 * @throws InvocationException thrown if a problem occurs
	 */
	public abstract void updateProject(IProject project, ITaskProductionContext productionContext, IProgressMonitor monitor)
			throws InvocationException;
	
	@Override
	public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor)
			throws InvocationException {
		projectID = productionContext.getInputValue(PORJECT_ID_CONTRACT, String.class);
	}

	@Override
	public final void doExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
		if (projectID == null)
			return ;
		
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectID);
		if (project.exists())
		{
			updateProject(project, productionContext, monitor);
		}
	}
	
	@Override
	public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
	}
	
	protected String getProjectID(){
		return this.projectID;
	}
}
