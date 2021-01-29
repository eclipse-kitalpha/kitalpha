/*******************************************************************************
 * Copyright (c) 2015, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/

package org.polarsys.kitalpha.ad.integration.amalgam.pages;

import org.eclipse.amalgam.explorer.activity.ui.api.editor.pages.BasicSessionActivityExplorerPage;
import org.eclipse.amalgam.explorer.activity.ui.api.manager.ActivityExplorerManager;
import org.eclipse.sirius.business.api.session.Session;
import org.polarsys.kitalpha.ad.integration.sirius.listeners.SiriusHelper;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;

/**
 * @author Thomas Guiu
 *
 */
public abstract class ADActivityExplorerPage extends BasicSessionActivityExplorerPage {

	protected abstract String getViewpointID();

	@Override
	public boolean isVisible() {
		if (getEditorInput() != null)
		{
			Session session = ActivityExplorerManager.INSTANCE.getSession();
			if (session != null)
			{
				ViewpointManager instance = SiriusHelper.getViewpointManager(session);
				String vpid = getViewpointID();
				boolean used = instance.isUsed(vpid);
				boolean filtered = instance.isFiltered(vpid);
				return used && !filtered &&  super.isVisible();
			}
		}
		return super.isVisible();
	}
}
