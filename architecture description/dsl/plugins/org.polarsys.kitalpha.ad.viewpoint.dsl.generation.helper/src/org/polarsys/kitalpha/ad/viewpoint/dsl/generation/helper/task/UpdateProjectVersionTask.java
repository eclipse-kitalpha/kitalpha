/*******************************************************************************
 * Copyright (c) 2016, 2026 Thales Global Services S.A.S.
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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.pde.internal.core.ICoreConstants;
import org.eclipse.pde.internal.core.natures.PluginProject;
import org.eclipse.pde.internal.ui.util.PDEModelUtility;
import org.osgi.framework.Constants;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.helper.pde.operation.BundleModelModification;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.helper.pde.operation.FeatureModelModification;

/**
 * @author Boubekeur Zendagui
 */

@SuppressWarnings("restriction")
public class UpdateProjectVersionTask extends AbstractProjectUpdateTask {
	
	/** Lock object used to handle multiple invocation of version update on different projects **/
	private static final Object bundleLock = new Object();
	private static final Object featureLock = new Object();
	
	/** Contracts related to version changing **/
	protected static final String PORJECT_VERSION_CONTRACT = "project.version";
	protected static final String PORJECT_ID_SUFFIX_CONTRACT = "project.id.suffix";
	
	/*
	 * (non-Javadoc)
	 * @see org.polarsys.kitalpha.ad.viewpoint.dsl.generation.helper.task.AbstractProjectUpdateTask#preExecute(org.eclipse.egf.ftask.producer.context.ITaskProductionContext, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
		super.preExecute(productionContext, monitor);
		final String projectIDSuffix = productionContext.getInputValue(PORJECT_ID_SUFFIX_CONTRACT, String.class);
		if (projectIDSuffix != null && ! projectIDSuffix.isEmpty())
		{
			projectID = projectID + "." + projectIDSuffix;
		}
	}

	/**
	 * This method apply an update of the version number of a Plug-in or Feature projects.
	 */
	@Override
	public void updateProject(IProject project, ITaskProductionContext productionContext, IProgressMonitor monitor) 
			throws InvocationException {
		final String version = productionContext.getInputValue(PORJECT_VERSION_CONTRACT, String.class);
		Assert.isNotNull(version, "Version contract should have a value"); //$NON-NLS-1$
		boolean featureProject = false;
		try {
            featureProject = project.hasNature(PluginProject.NATURE);
		} catch (CoreException e) {
			throw new InvocationException(e);
		}
		
		if (featureProject)
		{
			updateFeatureVersion(project, version, monitor);
		}
		else
		{
			updatePluginVersion(project, version, monitor);
		}
	}
	
	/**
	 * Update the version on a feature project
	 * @param project the {@link IProject} of the feature project
	 * @param version the new version
	 * @param monitor an {@link IProgressMonitor}
	 * @throws InvocationException thrown if any problem occurs when changing the version
	 */
	private void updateFeatureVersion(IProject project, String version, IProgressMonitor monitor) throws InvocationException{
		synchronized (featureLock) 
		{
			try {
				FeatureModelModification operation = new FeatureModelModification(project);
				operation.setFeatureVersion(version);
				operation.run(monitor);
			} catch (InvocationTargetException e) {
				throw new InvocationException(e);
			} catch (InterruptedException e) {
				throw new InvocationException(e);
			} catch (CoreException e) {
				throw new InvocationException(e);
			}
		
		}
	}
	/**
	 * Update the version on a plug-in project
	 * @param project the {@link IProject} of the plug-in project
	 * @param version the new version
	 * @param monitor an {@link IProgressMonitor}
	 */
	private void updatePluginVersion(IProject project, String version, IProgressMonitor monitor){
		synchronized (bundleLock) 
		{
			IFile manifest = project.getFile(ICoreConstants.BUNDLE_FILENAME_DESCRIPTOR);
			if (manifest == null || ! manifest.exists())
			{
				throw new IllegalArgumentException("The Manifest file doesn't exists");
			}
			else
			{
				BundleModelModification operation = new BundleModelModification(manifest, Constants.BUNDLE_VERSION, version);
				PDEModelUtility.modifyModel(operation, monitor);
			}
		}
	}
}
