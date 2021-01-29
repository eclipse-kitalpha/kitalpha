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
package org.polarsys.kitalpha.model.detachment.ui.action;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.progress.IProgressService;
import org.polarsys.kitalpha.model.common.precondition.exception.InvalidPreconditionException;
import org.polarsys.kitalpha.model.common.precondition.runner.IPreconditionRunner;
import org.polarsys.kitalpha.model.common.precondition.runner.PreconditionRunner;
import org.polarsys.kitalpha.model.common.scrutiny.analyzer.Scrutineer;
import org.polarsys.kitalpha.model.common.scrutiny.registry.ModelScrutinyRegistry;
import org.polarsys.kitalpha.model.detachment.ui.Activator;
import org.polarsys.kitalpha.model.detachment.ui.constants.Constants;
import org.polarsys.kitalpha.model.detachment.ui.editor.DetachmentEditorInput;
import org.polarsys.kitalpha.model.detachment.ui.editor.ModelDetachmentEditor;
import org.polarsys.kitalpha.model.detachment.ui.internal.DetachmentResourceProviderUtil;

/**
 * @author Faycal Abka
 */
public class DetachmentActionHandler extends AbstractHandler {

	
	private final Logger LOGGER = Logger.getLogger(DetachmentActionHandler.class);
	private final IProgressService pMonitorService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getWorkbench().getProgressService();
	private final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	
	private IFile airdIResource;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		IStructuredSelection structuredSelection = (IStructuredSelection)currentSelection;
		Object firstElement = structuredSelection.getFirstElement();
		airdIResource = (IFile)firstElement;
		
		try {
			
			pMonitorService.run(false, false, new IRunnableWithProgress() {

				@Override
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException,
						InterruptedException {
					try {
						exec_preconditions();

						monitor.beginTask("Analyzing of resource: " + airdIResource.getProjectRelativePath(), 2);
						monitor.subTask("Loading : " + airdIResource.getProjectRelativePath());
						Resource resource = DetachmentResourceProviderUtil.getResource(airdIResource);
						
						monitor.worked(1);

						monitor.subTask("Scrutinizing : " + resource.getURI());
						ModelScrutinyRegistry analysis = Scrutineer.startScrutiny(resource);
						monitor.worked(1);
						monitor.done();

						IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
						IEditorPart editor;
						IEditorInput detachmentInput = new DetachmentEditorInput(analysis);
						editor = IDE.openEditor(page, detachmentInput, Constants.EDITOR_ID);
						if (editor != null && editor instanceof ModelDetachmentEditor){
							ModelDetachmentEditor modelDetachmentEditor = (ModelDetachmentEditor) editor;
							modelDetachmentEditor.initAndLaunchDetachmentAction(resource);
						}
					} catch (PartInitException e) {
						LOGGER.error(e.getMessage(), e);
					} catch (InvalidPreconditionException e) {
						handlePreconditionError(e);
					}
				}

				private void handlePreconditionError(InvalidPreconditionException e) {
					final String msg = e.getMessage();
					LOGGER.error(e.getMessage());
					
					Display.getDefault().syncExec(new Runnable() {
						@Override
						public void run() {
							IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, msg, null);
							ErrorDialog.openError(shell, "Detachment Error", "Cannot perform Detach on your model. See the reasons below", status);
						}
					});
				}
			});
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private void exec_preconditions() throws InvalidPreconditionException{
		//Execute preconditions
		@SuppressWarnings("rawtypes")
		IPreconditionRunner preconditionRunner = new PreconditionRunner();
		preconditionRunner.run(airdIResource, new NullProgressMonitor());
	}
}
