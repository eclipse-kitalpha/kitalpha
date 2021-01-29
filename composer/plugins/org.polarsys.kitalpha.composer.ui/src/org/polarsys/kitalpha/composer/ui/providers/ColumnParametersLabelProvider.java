/*******************************************************************************
 * Copyright (c) 2014, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/


package org.polarsys.kitalpha.composer.ui.providers;

import org.eclipse.jface.viewers.ColumnLabelProvider;

import org.polarsys.kitalpha.composer.api.Parameter;
import org.polarsys.kitalpha.composer.ui.Activator;

/**
 * Label provider for the name of a parameter.
 * 
 
 */
public class ColumnParametersLabelProvider extends ColumnLabelProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof Parameter) {
			Parameter entry = (Parameter) element;
			return entry.getName();
		} else {
			//
			// Invalid Argument.
			Activator.getDefault().warning(
					"Invalid argument in ColumnParametersLabelProvider.getText : "
							+ (element != null ? element.getClass().getName()
									: "null"));
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipText(java.lang.Object)
	 */
	@Override
	public String getToolTipText(Object element) {
		if (element instanceof Parameter) {
			return ((Parameter) element).getDescription();
		} else {
			//
			// Invalid Argument.
			Activator.getDefault().warning(
					"Invalid argument in ColumnParametersLabelProvider.getToolTipText : "
							+ (element != null ? element.getClass().getName()
									: "null"));
		}
		return null;
	}

}
