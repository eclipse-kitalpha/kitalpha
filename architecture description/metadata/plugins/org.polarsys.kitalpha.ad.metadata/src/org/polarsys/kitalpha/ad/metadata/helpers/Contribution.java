/*******************************************************************************
 * Copyright (c) 2016, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.polarsys.kitalpha.ad.metadata.helpers;

import java.util.List;
import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.polarsys.kitalpha.ad.common.AD_Log;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class Contribution {
	
	public abstract void update(ResourceSet context);

	public void postUpdate(ResourceSet context) {
		
	}
	
	public void preUpdate(ResourceSet context) {
		
	}
	
	public static List<Contribution> getContributions () {
		List<Contribution> result = new ArrayList<>();
		for (IConfigurationElement elt : Platform.getExtensionRegistry().getConfigurationElementsFor("org.polarsys.kitalpha.ad.metadata.contribution")) {
			try {
				result.add((Contribution) elt.createExecutableExtension("class"));
			} catch (CoreException e) {
				AD_Log.getDefault().logError(e);
			}
		}
		return result;
	}

}