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

import org.polarsys.kitalpha.composer.internal.allocation.AllocationProviderRegistry;
import org.polarsys.kitalpha.composer.metamodel.allocation.base.Root;

/**
 * Registry of all {@link IAllocationProvider}.
 * 
 * @author Yann Mortier
 */
public interface IAllocationProviderRegistry {

	IAllocationProviderRegistry INSTANCE = new AllocationProviderRegistry();

	/**
	 * Registers the given descriptor into the registry. The invocation has no
	 * effect if the descriptor is already registered.
	 * 
	 * @param descriptor
	 *            the descriptor to register.
	 */
	void register(IAllocationProviderDescriptor descriptor);

	/**
	 * Unregisters the given descriptor from the registry. The invocation has no
	 * effect is the descriptor is not registered.
	 * 
	 * @param descriptor
	 *            the descriptor to unregister.
	 */
	void unregister(IAllocationProviderDescriptor descriptor);

	/**
	 * Returns the best allocation provider for the given element.
	 * 
	 * @param rootAllocation
	 *            the root of the allocation under generation.
	 * @param unknownElement
	 *            an unknown model element (there is no allocation for this
	 *            element.
	 * @return the best allocation provider for the given element.
	 */
	IAllocationProvider getBestProvider(Root rootAllocation,
			EObject unknownElement);

}