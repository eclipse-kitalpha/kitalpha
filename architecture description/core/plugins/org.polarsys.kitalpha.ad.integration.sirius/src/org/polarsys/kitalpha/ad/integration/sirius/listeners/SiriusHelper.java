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

package org.polarsys.kitalpha.ad.integration.sirius.listeners;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.polarsys.kitalpha.ad.integration.sirius.model.SiriusRepresentation;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;
import org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.RepresentationElement;

/**
 * @author Thomas Guiu
 * 
 */
public class SiriusHelper {

	public static ViewpointManager getViewpointManager(Session session) {
		return ViewpointManager.getInstance(session.getTransactionalEditingDomain().getResourceSet());
	}

	public static Session getSession(ResourceSet set) {
		for (Resource r : set.getResources())
		{
			Session session = SessionManager.INSTANCE.getSession(r);
			if (session != null){
				return session;
			}
		}
		return null;
	}

	public static Set<Viewpoint> getViewpoints(org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.Viewpoint vp) {
		Set<Viewpoint> result = new HashSet<Viewpoint>();
		if (vp.getRepresentation() == null){
			return EMPTY_SET;
		}
		for (RepresentationElement elt : vp.getRepresentation().getRepresentations()) {
			if (elt instanceof SiriusRepresentation) {
				SiriusRepresentation siriusElt = (SiriusRepresentation) elt;
				result.addAll(siriusElt.getOdesign().getOwnedViewpoints());
			}
		}
		return result;
	}

	public static final Set<Viewpoint> EMPTY_SET = new HashSet<Viewpoint>();

	private SiriusHelper() {
		super();
		
	}

}
