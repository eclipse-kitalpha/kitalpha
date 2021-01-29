/*******************************************************************************
 * Copyright (c) 2017, 2018, 2019 Thales Global Services S.A.S.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License 2.0 which is available at
 *  http://www.eclipse.org/legal/epl-2.0
 *  
 *  SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.richtext.widget.tools.dialogs;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;

/**
 * Dialog to select from tree element with filtering option
 *
 */
public class FilteredElementTreeSelectionDialog extends ElementTreeSelectionDialog {

  public FilteredElementTreeSelectionDialog(Shell parent, ILabelProvider labelProvider,
      ITreeContentProvider contentProvider) {
    super(parent, labelProvider, contentProvider);
  }

  @Override
  protected TreeViewer doCreateTreeViewer(Composite parent, int style) {
    FilteredTree filterTree = new FilteredTree(parent, style, new PatternFilter(), true);

    filterTree.setQuickSelectionMode(true);

    return filterTree.getViewer();
  }

}
