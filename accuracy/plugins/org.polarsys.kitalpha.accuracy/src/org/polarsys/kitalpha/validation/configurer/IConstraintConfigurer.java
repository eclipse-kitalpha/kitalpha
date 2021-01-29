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
package org.polarsys.kitalpha.validation.configurer;

import java.util.Properties;

import org.polarsys.kitalpha.validation.internal.configurer.ConstraintConfigurer;

/**
 * Service that is able to activate/deactivate constraints from a
 * {@link Properties} object.
 * 
 * @author THALESGROUP
 */
public interface IConstraintConfigurer {

	/** The default instance. */
	IConstraintConfigurer INSTANCE = new ConstraintConfigurer();

	/**
	 * Activates/deactivates model constraints corresponding to the given
	 * {@link Properties} object.
	 * 
	 * @param properties
	 *            the properties.
	 * @throws ConfigurerException
	 *             if the properties are not valid.
	 */
	void configure(Properties properties) throws ConfigurerException;

}
