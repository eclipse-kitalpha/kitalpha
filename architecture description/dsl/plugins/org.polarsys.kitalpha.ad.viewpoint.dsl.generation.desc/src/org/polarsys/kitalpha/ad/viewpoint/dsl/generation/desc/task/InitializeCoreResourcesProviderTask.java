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

package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.task;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Viewpoint;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.adapter.TaskProductionAdapter;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.manager.VpdslDescriptionModelManager;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.provider.exception.ViewpointResourceProviderException;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.provider.resourceimpl.ViewpointResourceProviderRegistry;

/**
 * @author Boubekeur Zendagui
 */

public class InitializeCoreResourcesProviderTask extends TaskProductionAdapter {

	@Override
	public void doExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
		
		Viewpoint viewpoint = ViewpointResourceProviderRegistry.getInstance().getViewpoint();
		if (viewpoint == null)
		{
			viewpoint = VpdslDescriptionModelManager.INSTANCE.getVpDescriptionElement();
			try {
				ViewpointResourceProviderRegistry.getInstance().setViewpoint(viewpoint);
			} catch (ViewpointResourceProviderException e) {
				try {
					Thread.sleep(2000);
					// initialize ECore provider if it is not initialized yet
					if (! ViewpointResourceProviderRegistry.getInstance().isECoreProviderInitialized()) {
						ViewpointResourceProviderRegistry.getInstance().initializeEcoreProviders();
					}
					// initialize Generation Chain provider if it is not initialized yet
					if (! ViewpointResourceProviderRegistry.getInstance().isGenchainProviderInitialized()) {
						ViewpointResourceProviderRegistry.getInstance().initializeGenchainProviders();
					}
					// initialize GenModel provider if it is not initialized yet
					if (! ViewpointResourceProviderRegistry.getInstance().isGenmodelProviderInitialized()) {
						ViewpointResourceProviderRegistry.getInstance().initializeGenmodelProviders();
					}
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} 
			}
		}
		else
		{
			ViewpointResourceProviderRegistry.getInstance().refresh();
		}
		
	}
}
