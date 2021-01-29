/*******************************************************************************
 * Copyright (c) 2014-2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/

package org.polarsys.kitalpha.ad.af.dsl.generation.desc.task;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.domain.EMFDomain;
import org.polarsys.kitalpha.ad.af.dsl.as.model.afdesc.ArchitectureFramework;
import org.polarsys.kitalpha.ad.af.dsl.generation.desc.internal.Constants;

/**
 * @author Boubekeur Zendagui
 */
public class PrepareAFFeatureCreationTask implements ITaskProduction {

	/**
	 * @see org.eclipse.egf.ftask.producer.invocation.ITaskProduction#preExecute(org.eclipse.egf.ftask.producer.context.ITaskProductionContext, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.eclipse.egf.ftask.producer.invocation.ITaskProduction#doExecute(org.eclipse.egf.ftask.producer.context.ITaskProductionContext, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
		EMFDomain domainModel = productionContext.getInputValue(Constants.CONTRACT_DOMAIN_MODEL, EMFDomain.class);
		String projectId = productionContext.getInputValue(Constants.CONTRACT_PROJECT_NAME, String.class);
		String label = "";
		Object rootDomainElement = domainModel.getContent().get(0);
		if (rootDomainElement != null && rootDomainElement instanceof ArchitectureFramework)
		{
			ArchitectureFramework af = (ArchitectureFramework) rootDomainElement;
			label = af.getName();
		}
		
		List<String> pluginList = new ArrayList<String>();
		pluginList.add(projectId);
		
		productionContext.setOutputValue(Constants.CONTRACT_INCLUDE_PLUGIN_NAME_LIST, pluginList);
		productionContext.setOutputValue(Constants.CONTRACT_FEATURE_NAME, projectId + ".feature");
		productionContext.setOutputValue(Constants.CONTRACT_FEATURE_LABEL, label);
	}

	/**
	 * @see org.eclipse.egf.ftask.producer.invocation.ITaskProduction#postExecute(org.eclipse.egf.ftask.producer.context.ITaskProductionContext, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
		// TODO Auto-generated method stub

	}

}
