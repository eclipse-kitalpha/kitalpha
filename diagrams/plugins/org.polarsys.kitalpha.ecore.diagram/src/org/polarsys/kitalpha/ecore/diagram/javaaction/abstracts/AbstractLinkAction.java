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

package org.polarsys.kitalpha.ecore.diagram.javaaction.abstracts;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.diagram.DEdge;

public abstract class AbstractLinkAction extends AbstractFocusExternalJavaAction {

	@Override
	protected void run(Collection<? extends EObject> context, Map<String, Object> parameters) {
		Set<EObject> targetSet = getTargetSet(parameters);
		RecordingCommand command = getCommand((TransactionalEditingDomain) editingDomain, targetSet);
		editingDomain.getCommandStack().execute(command);
	}

	@SuppressWarnings("unchecked")
	private Set<EObject> getTargetSet(Map<String, Object> parameters) {
		Collection<EReference> refs = (Collection<EReference>) parameters.get(ELEMENT);
		Collection<EObject> focusedObjects = (Collection<EObject>) parameters.get(VIEW_ELEMENT);
		Collection<EObject> result = new UniqueEList<EObject>();
		for (EObject o : focusedObjects) 
		{
			DEdge dEdge = (DEdge) o;
			if (dEdge != null && refs.contains(dEdge.getTarget())) {
				result.add(dEdge);
			}
		}
		return new HashSet<EObject>(result);
	}

}
