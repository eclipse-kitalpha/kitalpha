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


package org.polarsys.kitalpha.composer.api.allocation;

import org.eclipse.emf.ecore.EObject;

import org.polarsys.kitalpha.composer.metamodel.allocation.base.Root;

/**
 * Defines a types that is able to provide an allocation for a model element.
 * 
 * @author Yann Mortier
 */
public interface IAllocationProvider {

	/**
	 * Returns an allocation referencing the given model element.
	 * 
	 * @param modelElement
	 *            the model element from which we want to have an allocation
	 *            model.
	 * @return an allocation referencing the given model element.
	 */
	Root getAllocation(EObject modelElement);

	/**
	 * Returns <code>true</code> if this provider is able to get an allocation
	 * for the given unknown element considering the given allocation model
	 * element.
	 * 
	 * @param rootAllocation
	 *            the root of the allocation under generation.
	 * @param unknownElement
	 *            an unknown model element (there is no allocation for this
	 *            element.
	 * @return <code>true</code> if this provider is able to get an allocation
	 *         for the given unknown element considering the original allocation
	 *         model.
	 */
	boolean provides(Root rootAllocation, EObject unknownElement);

}
