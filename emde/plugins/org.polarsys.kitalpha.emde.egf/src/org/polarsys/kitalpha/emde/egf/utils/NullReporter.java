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
/**
 * 
 */
package org.polarsys.kitalpha.emde.egf.utils;

import java.util.Map;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;

/**
 * @author Thomas Guiu
 * 
 */
public class NullReporter implements PatternExecutionReporter {

	@Override
	public void executionFinished(String output, PatternContext context) {
	}

	@Override
	public void loopFinished(String output, String outputWithCallBack, PatternContext context, Map<String, Object> parameterValues) {
	}

}
