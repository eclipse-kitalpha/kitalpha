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
package org.polarsys.kitalpha.model.common.precondition.registry;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

/**
 * @author Faycal Abka
 */
public class RegistryHelper {
	private static Logger LOGGER = Logger.getLogger(RegistryHelper.class);

	/**
	 * Get all extensions for the given extension points
	 * @param extensionPoint
	 * @return All extensions of the extensionPoint
	 */
	public static IExtension[] getAllExtensionsFor(String extensionPoint) {
		IExtensionRegistry regisry = Platform.getExtensionRegistry();

		IExtensionPoint extension = regisry.getExtensionPoint(extensionPoint);

		if (extension == null){
			RuntimeException e = new RuntimeException("MODEL_COMMAND_EXTENSION_CANT_GET");
			LOGGER.error("MODEL_COMMAND_EXTENSION_CANT_GET", e);
			throw e;
		}

		IExtension extensions[] = extension.getExtensions();

		if (extensions.length == 0) {
			return null;
		}
		return extensions;
	}
}
