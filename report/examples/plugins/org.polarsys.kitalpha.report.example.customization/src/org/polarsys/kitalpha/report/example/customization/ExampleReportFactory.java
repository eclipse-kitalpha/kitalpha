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

package org.polarsys.kitalpha.report.example.customization;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.kitalpha.report.example.customization.model.CustomEntry;
import org.polarsys.kitalpha.report.example.customization.model.CustomizationFactory;
import org.polarsys.kitalpha.report.model.LogEntry;
import org.polarsys.kitalpha.report.utils.AbstractReportFactory;
import org.polarsys.kitalpha.report.utils.SeverityFactory;

/**
 * @author Thomas Guiu
 * 
 */
public class ExampleReportFactory extends AbstractReportFactory {

	public static final ExampleReportFactory INSTANCE = new ExampleReportFactory("custom.report.example.list");

	public ExampleReportFactory(String listId) {
		super(listId);
	}
	
	public LogEntry logFatalError(String message, String comment, EObject reference) {
		CustomEntry entry = CustomizationFactory.eINSTANCE.createCustomEntry();
		entry.setComment(comment);
		return log(entry, ExampleSeverityFactory.INSTANCE.createFatalError(), message, reference);
	}

	public LogEntry logWarning(String message, EObject reference) {
		CustomEntry entry = CustomizationFactory.eINSTANCE.createCustomEntry();
		return log(entry, SeverityFactory.INSTANCE.createWarning(), message, reference);
	}



}
