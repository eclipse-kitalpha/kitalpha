/*******************************************************************************
 * Copyright (c) 2016, 2020 Thales Global Services S.A.S.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License 2.0 which is available at
 *  http://www.eclipse.org/legal/epl-2.0
 *  
 *  SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.resourcereuse.emfscheme.utils.services;


import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.session.Session;
import org.polarsys.kitalpha.resourcereuse.emfscheme.ModelReuseURIConverter;

/**
 * 
 * @author Xavier DECOOL
 *
 */
public class SiriusLoaderServices {
		
	/**
	 * Method that load resource in a sirius diagram. If selection is included in a sirius, this method will be called, show ResourceSetLoaderServices
	 * if the resource is included in a ResourceSet
	 * @param session : The session where is stored the resource
	 * @param modelToLoad : List of models to load
	 */
	public static void loadModelsForSiriusSession( final Session session, final List<URI> modelToLoad) {
		
		if (session != null) {
			
			final TransactionalEditingDomain transactionalEditingDomain = session
					.getTransactionalEditingDomain();
			final CommandStack stack = transactionalEditingDomain
					.getCommandStack();

			stack.execute(new RecordingCommand(transactionalEditingDomain) {
				@Override
				protected void doExecute() {
					for (URI modelURI : modelToLoad) {
						ResourceSet resourceSet = transactionalEditingDomain.getResourceSet();
						ModelReuseURIConverter converter = new ModelReuseURIConverter();
						resourceSet.setURIConverter(converter);
						
						session.addSemanticResource(modelURI, new NullProgressMonitor());
					}
				}
			});
		}
	}

	private SiriusLoaderServices() {
		super();
		
	}
	
}
