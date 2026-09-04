/*******************************************************************************
 * Copyright (c) 2014, 2026 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.polarsys.kitalpha.ad.viewpoint.sdk.actions;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.pde.internal.core.natures.PluginProject;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.polarsys.kitalpha.ad.common.AD_Log;
import org.polarsys.kitalpha.ad.viewpoint.sdk.Messages;
import org.polarsys.kitalpha.ad.viewpoint.sdk.manager.BundleManager;

public class ReloadBundleAction implements IObjectActionDelegate {
	
	private Shell shell;
	private IProject project;

	/**
	 * Constructor for Action1.
	 */
	public ReloadBundleAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	@Override
	public void run(IAction action) {
		if (BundleManager.INSTANCE.isManaged(project)) {
			String name = project.getName();
			try {

				BundleManager.INSTANCE.unLoad(name);
			} catch (Exception e) {
				MessageDialog.openError(shell, Messages.ManageBundle_error_title4, Messages.ManageBundle_error_message);
				AD_Log.getDefault().logError(Messages.ManageBundle_error_title4, e);
			}
			try {
				BundleManager.INSTANCE.load(name);
			} catch (Exception e) {
				MessageDialog.openError(shell, Messages.ManageBundle_error_title5, Messages.ManageBundle_error_message);
				AD_Log.getDefault().logError(Messages.ManageBundle_error_title5, e);
			}
			return;
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		project = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection sselect = (IStructuredSelection) selection;
			if (sselect.size() == 1) {
				if (sselect.getFirstElement() instanceof IProject){
					project = (IProject) sselect.getFirstElement();
				} else if (sselect.getFirstElement() instanceof IJavaProject) {
					project = ((IJavaProject) sselect.getFirstElement()).getProject();
				}
			}
		}
		try {
            action.setEnabled(project != null && project.isAccessible() && project.hasNature(PluginProject.NATURE) && BundleManager.INSTANCE.isManaged(project));
		} catch (CoreException e) {
			AD_Log.getDefault().logWarning(e);
		}
	}

}
