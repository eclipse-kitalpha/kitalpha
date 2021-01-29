/**
 * Copyright (c) 2009, 2020 Thales Corporate Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */

package org.polarsys.kitalpha.ad.viewpoint.emfvalidation.rules;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.polarsys.kitalpha.ad.viewpoint.handlers.IRuleHandler;
import org.polarsys.kitalpha.ad.viewpoint.ui.dialogs.NewElementCreationWizard;
import org.polarsys.kitalpha.ad.viewpoint.ui.integration.rules.RuleProviderWizard;

/**
 * @author Thomas Guiu
 * 
 */
public class EmfValidationRuleProviderWizard implements RuleProviderWizard {

	@Override
	public String getType() {
		return EmfValidationRuleProvider.ID;
	}

	@Override
	public void openWizard(Shell shell, IRuleHandler handler, IProject project) {

		NewElementCreationWizard wizard = new NewEmfValidationRuleCreationWizard(handler);
		wizard.init(PlatformUI.getWorkbench(), new StructuredSelection(new Object[] { project }));
		WizardDialog dialog = new WizardDialog(shell, wizard);
		dialog.open();
	}
}
