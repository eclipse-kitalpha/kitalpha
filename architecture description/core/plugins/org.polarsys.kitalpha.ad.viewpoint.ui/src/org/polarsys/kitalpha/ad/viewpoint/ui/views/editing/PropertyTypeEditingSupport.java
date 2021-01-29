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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.Property;
import org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.Types;

/**
 * @author Thomas Guiu
 * 
 */
public class PropertyTypeEditingSupport extends BasicEditingSupport {

	private ComboBoxCellEditor cellEditor;

	public PropertyTypeEditingSupport(TableViewer viewer) {
		super(viewer);
		List<String> availableTypes = new ArrayList<String>();
		for (Types type : Types.values()) {
			availableTypes.add(toString(type));
		}
		cellEditor = new ComboBoxCellEditor(viewer.getTable(), availableTypes.toArray(new String[availableTypes.size()]), SWT.READ_ONLY);
	}

	private String toString(Types type) {
		return type.getName();
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return cellEditor;
	}

	@Override
	protected Object getValue(Object element) {
		Types value = ((Property) element).getType();
		return Arrays.asList(cellEditor.getItems()).indexOf(toString(value));
	}

	@Override
	protected final void doSetValue(Object element, Object value) {
		String val = cellEditor.getItems()[(Integer) value];
		((Property) element).setType(Types.getByName(val));
	}

}
