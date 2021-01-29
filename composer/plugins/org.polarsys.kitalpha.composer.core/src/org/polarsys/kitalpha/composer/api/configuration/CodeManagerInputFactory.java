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


package org.polarsys.kitalpha.composer.api.configuration;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.polarsys.kitalpha.composer.internal.configuration.EObjectListInput;
import org.polarsys.kitalpha.composer.internal.configuration.ResourceInput;
import org.polarsys.kitalpha.composer.internal.configuration.ResourceSetInput;
import org.polarsys.kitalpha.composer.internal.configuration.RootEObjectInput;

/**
 * @author Yann Mortier
 * 
 */
public final class CodeManagerInputFactory {

	private CodeManagerInputFactory() {
		// empty.
	}

	public static ICodeManagerInput create(EObject root) {
		return RootEObjectInput.create(root);
	}

	public static ICodeManagerInput create(List<EObject> selectedObjects) {
		return EObjectListInput.create(selectedObjects);
	}

	public static ICodeManagerInput create(Resource resource) {
		return ResourceInput.create(resource);
	}

	public static ICodeManagerInput create(ResourceSet resourceSet) {
		return ResourceSetInput.create(resourceSet);
	}

}
