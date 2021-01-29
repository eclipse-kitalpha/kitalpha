/*******************************************************************************
 * Copyright (c) 2016, 2020 THALES GLOBAL SERVICES.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales - initial API and implementation
 *******************************************************************************/

package org.polarsys.kitalpha.ad.integration.sirius.listeners;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManagerListener.Stub;
import org.polarsys.kitalpha.ad.metadata.helpers.MetadataHelper;

/**
 * This listener ensures the metadata resource is created (if needed) when a session is opened.
 * 
 * @author Thomas Guiu
 * 
 */
public class MetadataResourceListener extends Stub {

	@Override
	public void notifyAddSession(final Session session) {
		RecordingCommand command = new RecordingCommand(session.getTransactionalEditingDomain()) {

			@Override
			protected void doExecute() {
				Resource resource = MetadataHelper.getViewpointMetadata(session.getTransactionalEditingDomain().getResourceSet()).initMetadataStorage();
				if (resource != null)
				{
					resource.setModified(true);
					session.addSemanticResource(resource.getURI(), new NullProgressMonitor());
				}
				
			}
		};
		session.getTransactionalEditingDomain().getCommandStack().execute(command);
	}

}
