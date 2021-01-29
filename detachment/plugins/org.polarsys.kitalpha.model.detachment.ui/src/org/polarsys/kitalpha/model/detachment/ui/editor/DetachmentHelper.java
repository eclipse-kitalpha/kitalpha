/*******************************************************************************
 * Copyright (c) 2016, 2020 Thales Global Services S.A.S.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License 2.0 which is available at
 *  http://www.eclipse.org/legal/epl-2.0
 *  
 *  SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.model.detachment.ui.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.polarsys.kitalpha.model.common.precondition.exception.InvalidPreconditionException;
import org.polarsys.kitalpha.model.common.precondition.runner.IPreconditionRunner;
import org.polarsys.kitalpha.model.common.precondition.runner.PreconditionRunner;
import org.polarsys.kitalpha.model.common.scrutiny.analyzer.Scrutineer;
import org.polarsys.kitalpha.model.common.scrutiny.registry.ModelScrutinyRegistry;
import org.polarsys.kitalpha.model.detachment.ui.constants.Constants;
import org.polarsys.kitalpha.model.detachment.ui.internal.DetachmentResourceProviderUtil;

/**
 * @author Thomas Guiu
 *
 */
public class DetachmentHelper {

	//TODO create Exception for Precondition and throw RuntimeException after catch
	@SuppressWarnings("unchecked")
	public static void checkPreconditions(IFile airdIResource, IProgressMonitor monitor) throws InvalidPreconditionException{
		@SuppressWarnings("rawtypes")
		IPreconditionRunner preconditionRunner = new PreconditionRunner();
		preconditionRunner.run(airdIResource, monitor);
	}
	
	public static void openEditor(IFile airdIResource, IProgressMonitor monitor) throws PartInitException, InvalidPreconditionException {
		checkPreconditions(airdIResource, monitor);
		Resource resource = DetachmentResourceProviderUtil.getResource(airdIResource);

		monitor.subTask("Scrutinizing : " + resource.getURI());
		ModelScrutinyRegistry analysis = Scrutineer.startScrutiny(resource);
		monitor.worked(1);
		monitor.done();
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor;
		editor = IDE.openEditor(page, new DetachmentEditorInput(analysis), Constants.EDITOR_ID);
		if (editor != null && editor instanceof ModelDetachmentEditor){
			ModelDetachmentEditor modelDetachmentEditor = (ModelDetachmentEditor) editor;
			modelDetachmentEditor.initAndLaunchDetachmentAction(resource);
		}
	}
}
