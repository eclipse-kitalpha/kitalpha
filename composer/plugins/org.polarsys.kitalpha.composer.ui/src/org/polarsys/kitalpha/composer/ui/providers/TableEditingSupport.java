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

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;

import org.polarsys.kitalpha.composer.api.Parameter;
import org.polarsys.kitalpha.composer.ui.Activator;

/**
 * Editing support for parameters.
 * 
 
 */
public class TableEditingSupport extends EditingSupport {

	/** The editor. */
	private CellEditor editor;

	/** The viewer to edit. */
	private Viewer viewer;
	
	private ITableEditingListener tableEditingListener;

	public TableEditingSupport(ColumnViewer viewer, ITableEditingListener tableEditingListener) {
		super(viewer);
		this.viewer = viewer;
		this.tableEditingListener = tableEditingListener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
	 */
	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#getCellEditor(java.lang.Object)
	 */
	@Override
	protected CellEditor getCellEditor(Object element) {
		editor = new TextCellEditor((Composite) viewer.getControl());
		return editor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#getValue(java.lang.Object)
	 */
	@Override
	protected Object getValue(Object element) {
		String value = "";
		if (element instanceof Parameter) {
			value = ((Parameter) element).getValue();
		} else {
			Activator.getDefault().warning(
					"Invalid argument in TableEditingSupport.getValue() "
							+ element);
		}
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#setValue(java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	protected void setValue(Object element, Object value) {
		if (element instanceof Parameter && value instanceof String) {
			((Parameter) element).setValue((String) value);
			if (tableEditingListener != null) {
				tableEditingListener.parameterValueChanged();
			}
		} else {
			Activator.getDefault().warning(
					"Invalid argument in TableEditingSupport.setValue() "
							+ element + ", " + value);
		}
		viewer.refresh();

	}

}
