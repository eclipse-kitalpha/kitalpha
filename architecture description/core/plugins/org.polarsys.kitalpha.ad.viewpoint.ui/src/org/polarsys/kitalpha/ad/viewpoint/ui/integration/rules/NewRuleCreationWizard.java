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
 *******************************************************************************/
package org.polarsys.kitalpha.ad.viewpoint.ui.integration.rules;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.polarsys.kitalpha.ad.viewpoint.handlers.IRuleHandler;
import org.polarsys.kitalpha.ad.viewpoint.ui.Activator;
import org.polarsys.kitalpha.ad.viewpoint.ui.dialogs.NewElementCreationWizard;
import org.polarsys.kitalpha.ad.viewpoint.utils.ElementHelper;

public abstract class NewRuleCreationWizard extends NewElementCreationWizard {

	protected final IRuleHandler handler;

	public NewRuleCreationWizard(IRuleHandler handler) {
		this.handler = handler;
	}

	@Override
	protected void postFinishPage(final IProgressMonitor monitor) throws InterruptedException, CoreException {
		super.postFinishPage(monitor);
		String id = ElementHelper.computeNewId(handler, getElementName().toLowerCase().replaceAll("\\s", "\\."));
		handler.createRule(id, getType(), getRuleImplementation());
	}

	protected abstract String getRuleImplementation();

	protected abstract String getType();

	@Override
	protected IDialogSettings getDialogSettingSection() {
		return getDialogSettings().getSection(Activator.RULE_PROVIDER_WIZARD_SECTION);
	}

}