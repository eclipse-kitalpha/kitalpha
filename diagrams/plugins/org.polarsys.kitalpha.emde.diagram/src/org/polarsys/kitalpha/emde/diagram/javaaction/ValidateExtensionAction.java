/*******************************************************************************
 * Copyright (c) 2014, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.emde.diagram.javaaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.polarsys.kitalpha.emde.diagram.Activator;
import org.polarsys.kitalpha.emde.model.ExtensionValidationHelper;

/**
 * @author Thomas Guiu
 * 
 */
public class ValidateExtensionAction extends AbstractEmdeExternalJavaAction {

	@Override
	public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
		try {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			BasicDiagnostic diagnostic = ExtensionValidationHelper.visit(new ArrayList(arg0));
			displayResult(diagnostic);
			

		} catch (CoreException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		}
	}
	
	public static void displayResult(Diagnostic diagnostic) {
		String title = "Validation Result";
		if (diagnostic.getSeverity() == Diagnostic.ERROR) {
			DiagnosticDialog.openProblem(PlatformUI.getWorkbench().getDisplay().getActiveShell(), title, "The extension declaration contains some errors", diagnostic);
		} else {
			MessageDialog.openInformation(PlatformUI.getWorkbench().getDisplay().getActiveShell(), title, "The extension declaration contains no errors");
		}

	}

}
