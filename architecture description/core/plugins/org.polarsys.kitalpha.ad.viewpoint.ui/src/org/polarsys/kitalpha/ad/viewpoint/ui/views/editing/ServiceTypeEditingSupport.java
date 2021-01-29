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

package org.polarsys.kitalpha.ad.viewpoint.ui.views.editing;

import java.util.Arrays;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.Service;
import org.polarsys.kitalpha.ad.viewpoint.integration.services.Implementations;

/**
 * @author Thomas Guiu
 * 
 */
public class ServiceTypeEditingSupport extends BasicEditingSupport {

	private ComboBoxCellEditor cellEditor;

	public ServiceTypeEditingSupport(TableViewer viewer) {
		super(viewer);
		cellEditor = new ComboBoxCellEditor(viewer.getTable(), new String[0], SWT.READ_ONLY);
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		cellEditor.setItems(Implementations.getAvailableActionLabels());
		return cellEditor;
	}

	@Override
	protected Object getValue(Object element) {
		String type = ((Service) element).getType();
		String label = Implementations.getLabel(type);
		return Arrays.asList(cellEditor.getItems()).indexOf(label);
	}

	@Override
	protected final void doSetValue(Object element, Object value) {
		String val = cellEditor.getItems()[(Integer) value];
		String type = Implementations.getType(val);
		((Service) element).setType(type);
	}

}
