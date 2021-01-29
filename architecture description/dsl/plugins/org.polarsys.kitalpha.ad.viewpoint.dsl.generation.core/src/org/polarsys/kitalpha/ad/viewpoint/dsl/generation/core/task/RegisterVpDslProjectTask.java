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

package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.core.task;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.emf.common.util.URI;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.adapter.TaskProductionAdapter;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.core.utils.GenchainAdditionsManager;

/**
 * @author Boubekeur Zendagui
 */

public class RegisterVpDslProjectTask extends TaskProductionAdapter {

	@Override
	public void doExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
		EMFDomain domainModel = productionContext.getInputValue(VPDESC_MODEL, EMFDomain.class);
		URI uri = domainModel.getUri();
		String vpDslProjectId = uri.segment(1);
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(vpDslProjectId);
		if (project.exists()) {
			GenchainAdditionsManager.INSTANCE.registerPlugin(project.getName());
		}
	}

}
