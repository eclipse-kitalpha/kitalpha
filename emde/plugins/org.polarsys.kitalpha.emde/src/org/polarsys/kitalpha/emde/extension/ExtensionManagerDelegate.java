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

package org.polarsys.kitalpha.emde.extension;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Thomas Guiu
 *
 */
public abstract class ExtensionManagerDelegate {
	protected final Set<String> managedNsUris = new HashSet<String>();

	public Set<String> getManagedNsUris() {
		return managedNsUris;
	}

	public abstract Boolean isExtensionModelDisabled(EObject eObject);
}
