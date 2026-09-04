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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.natures.PluginProject;
import org.eclipse.pde.internal.core.plugin.PluginElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.polarsys.kitalpha.ad.common.AD_Log;
import org.polarsys.kitalpha.ad.viewpoint.sdk.Messages;
import org.polarsys.kitalpha.ad.viewpoint.sdk.manager.BundleManager;

public class OpenViewsAction implements IMenuCreator, IObjectActionDelegate {
	
	private Shell shell;
	private IProject project;
	private IWorkbenchPage activePage;
	private List<String> viewIds = new ArrayList<String>();
	private SelectionListener listener = new SelectionListener() {

		@Override
		public void widgetSelected(SelectionEvent ee) {
			if (BundleManager.INSTANCE.isManaged(project)) {
				try {
					MenuItem menuItem = (MenuItem) ee.getSource();
					activePage.showView((String) menuItem.getData());
				} catch (Exception e) {
					MessageDialog.openError(shell, Messages.ManageBundle_error_title3, Messages.ManageBundle_error_message);
					AD_Log.getDefault().logError(Messages.ManageBundle_error_title3, e);
				}
			} else {
				MessageDialog.openWarning(shell, "Warning", "Install the bundle first!");
			}

		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			//Nothing to do
		}
	};

	/**
	 * Constructor for Action1.
	 */
	public OpenViewsAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		IWorkbenchPartSite site = targetPart.getSite();
		activePage = site.getWorkbenchWindow().getActivePage();

		shell = site.getShell();
		action.setMenuCreator(this);
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	@Override
	public void run(IAction action) {

		if (BundleManager.INSTANCE.isManaged(project)) {
			if (viewIds.isEmpty()) {
				MessageDialog.openError(shell, Messages.ManageBundle_error_title3, "There is no view to open.");
				return;
			}
			try {
				for (String id : viewIds){
					activePage.showView(id);
				}
			} catch (Exception e) {
				MessageDialog.openError(shell, Messages.ManageBundle_error_title3, Messages.ManageBundle_error_message);
				AD_Log.getDefault().logError(Messages.ManageBundle_error_title3, e);
			}
			return;
		}
		MessageDialog.openWarning(shell, "Warning", "Install the bundle first!");

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
				if (sselect.getFirstElement() instanceof IProject) {
					project = (IProject) sselect.getFirstElement();
				} else if (sselect.getFirstElement() instanceof IJavaProject){
					project = ((IJavaProject) sselect.getFirstElement()).getProject();
				}
			}
		}
		IPluginModelBase findModel = PluginRegistry.findModel(project);
		if (findModel != null) {
			initViewId(findModel);
			if (viewIds.isEmpty()) {
				action.setEnabled(false);
				return;
			}
		}
		if (project == null || BundleManager.INSTANCE.isManaged(project)){
			action.setText("Open viewpoint view");
		} else {
			action.setText("[Not loaded] Open viewpoint view");
		}
		try {
            action.setEnabled(project != null && project.isAccessible() && project.hasNature(PluginProject.NATURE) && BundleManager.INSTANCE.isManaged(project));
		} catch (CoreException e) {
			AD_Log.getDefault().logWarning(e);
		}
	}

	private void initViewId(IPluginModelBase model) {
		viewIds.clear();
		for (IPluginExtension extension : model.getExtensions().getExtensions()) {
			if ("org.eclipse.ui.views".equals(extension.getPoint())) {
				for (IPluginObject children : extension.getChildren()) {
					if (children instanceof PluginElement) {
						PluginElement elt = (PluginElement) children;
						if (elt.getAttribute("resourceId") != null && elt.getAttribute("id") != null) {
							viewIds.add(elt.getAttribute("id").getValue());
						}
					}
				}
			}
		}
	}

	@Override
	public void dispose() {
		//nothing to do
	}

	@Override
	public Menu getMenu(Control parent) {
		return null;
	}

	@Override
	public Menu getMenu(Menu parent) {
		Menu dynamicMenu = new Menu(parent);
		for (String id : viewIds) {
			MenuItem mi = new MenuItem(dynamicMenu, SWT.PUSH);
			mi.setText(id);
			mi.setData(id);
			mi.addSelectionListener(listener);
			mi.setEnabled(activePage.findView(id) == null);
		}
		return dynamicMenu;
	}

}
