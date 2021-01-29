/*******************************************************************************
 * Copyright (c) 2014, 2020 Thales Global Services S.A.S.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License 2.0 which is available at
 *  http://www.eclipse.org/legal/epl-2.0
 *  
 *  SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.model.common.precondition.runner;

import java.util.Deque;

import org.eclipse.core.runtime.IProgressMonitor;
import org.polarsys.kitalpha.model.common.precondition.exception.InvalidPreconditionException;
import org.polarsys.kitalpha.model.common.precondition.interfaces.IPrecondition;
import org.polarsys.kitalpha.model.common.precondition.scheduling.PreconditionStackBuilder;

/**
 * 
 * @author Faycal Abka
 *
 */
@SuppressWarnings("rawtypes")
public class PreconditionRunner<T> implements IPreconditionRunner<T> {
	
	private final PreconditionStackBuilder stackBuilder = new PreconditionStackBuilder();

	@SuppressWarnings("unchecked")
	@Override
	public void run(T type, IProgressMonitor monitor) throws InvalidPreconditionException {
		stackBuilder.buildPreconditionsStack();
		Deque<IPrecondition> stack = stackBuilder.getPreconditionsStack();
		
		while (!stack.isEmpty()){
			IPrecondition precondition = stack.pop();
			precondition.executePrecondition(type, monitor);
		}
		
	}

}
