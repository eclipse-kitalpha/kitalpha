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
package org.polarsys.kitalpha.model.common.share.ui.utilities.vp.providers;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.polarsys.kitalpha.model.common.share.ui.utilities.vp.tree.IViewpointTreeDescription;
import org.polarsys.kitalpha.model.common.share.ui.utilities.vp.tree.ViewpointTreeContainer;

/**
 * @author Faycal Abka
 */
public class ViewpointTreeProvider implements ITreeContentProvider  {
	
	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	@Override
	public Object[] getElements(Object inputElement) {
		
		if (inputElement instanceof ViewpointTreeContainer) {
			return ((ViewpointTreeContainer)inputElement).getRoots().toArray();
		}
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof IViewpointTreeDescription){
				IViewpointTreeDescription vpd = (IViewpointTreeDescription)parentElement;
				return vpd.getChildren().toArray();
			}
			return null;
	}

	@Override
	public Object getParent(Object element) {
		
		if (element instanceof IViewpointTreeDescription){
			return ((IViewpointTreeDescription)element).getParents();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof IViewpointTreeDescription) {
			return ((IViewpointTreeDescription)element).hasChildren();
		}
		return false;
	}

}
