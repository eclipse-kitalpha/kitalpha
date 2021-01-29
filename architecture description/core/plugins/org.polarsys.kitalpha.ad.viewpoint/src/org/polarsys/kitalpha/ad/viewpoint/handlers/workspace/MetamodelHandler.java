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

package org.polarsys.kitalpha.ad.viewpoint.handlers.workspace;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.Metamodel;
import org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.Viewpoint;
import org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.tools.model.ViewpointElement;
import org.polarsys.kitalpha.ad.viewpoint.handlers.IMetamodelHandler;
import org.polarsys.kitalpha.ad.viewpoint.handlers.ResourceManager;

/**
 * @author Thomas Guiu
 * 
 */
public class MetamodelHandler extends WorkspaceManager.ElementHandler implements IMetamodelHandler {

	public MetamodelHandler(Viewpoint viewpoint, ResourceManager wsManager) {
		super(viewpoint, wsManager);
	}

	@Override
	public List<ViewpointElement> getElements() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<ViewpointElement> getElementsFromParents() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeMetamodels(List<EPackage> packages) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void addMetamodels(List<EPackage> packages) {
		throw new UnsupportedOperationException();

	}

	@Override
	public Metamodel getMetamodel() {
		return getViewpoint().getMetamodel();
	}

}
