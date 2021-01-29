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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionListener;
import org.eclipse.sirius.business.api.session.SessionManagerListener.Stub;
import org.polarsys.kitalpha.ad.metadata.helpers.MetadataHelper;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager.Listener2;
import org.polarsys.kitalpha.resourcereuse.model.Resource;

/**
 * This listener ensures the metadata resource is added to the session sementic resources. 
 * 
 * @author Thomas Guiu
 * 
 */
public class RegisterMetadataListener  extends Stub {
	private final class MyListener implements Listener2 {
		private final Session session;

		private MyListener(Session session) {
			this.session = session;
		}

		@Override
		public void handleReferencing(Resource vp) {
			registerMetadataResource(session);
		}

		@Override
		public void handleUnReferencing(Resource vp) {
			//nothing to do
		}

		@Override
		public void handleActivation(Resource vp) {
			//nothing to do
		}

		@Override
		public void handleInactivation(Resource vp) {
			//nothing to do		
		}

		@Override
		public int hashCode() {
			return session.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof MyListener && session.equals(((MyListener)obj).session);
		}

	}

	@Override
	public void notify(Session session, int notification) {
		super.notify(session, notification);
		if (session != null && SessionListener.OPENED == notification) {
			ViewpointManager vpmgr = ViewpointManager.getInstance(session.getTransactionalEditingDomain().getResourceSet());
			vpmgr.addListener(new MyListener(session));
		} 
		else if (session != null && SessionListener.CLOSING == notification) {
			ViewpointManager vpmgr = ViewpointManager.getInstance(session.getTransactionalEditingDomain().getResourceSet());
			vpmgr.removeListener(new MyListener(session));
		}
	}

	protected void handleOpenSession(final Session session) {
		//nothing to do
	}

	protected void registerMetadataResource(final Session session) {
		ResourceSet resourceSet = session.getTransactionalEditingDomain().getResourceSet();
		final URI expectedMetadataStorageURI = MetadataHelper.getViewpointMetadata(resourceSet).getExpectedMetadataStorageURI();
		RecordingCommand command = new RecordingCommand(session.getTransactionalEditingDomain()) {

			@Override
			protected void doExecute() {
				session.addSemanticResource(expectedMetadataStorageURI, new NullProgressMonitor());
			}
		};
		session.getTransactionalEditingDomain().getCommandStack().execute(command);
	}

}
