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

package org.polarsys.kitalpha.model.common.commands.contrib.resourcesChecker;

import org.eclipse.osgi.util.NLS;

/**
 * @author Faycal Abka
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.polarsys.kitalpha.model.common.commands.contrib.resourcesChecker.messages"; //$NON-NLS-1$
	
	public static String CHECK_ATTRIBUTE_FILES;

	public static String CHECK_FILE;

	public static String RESOURCE_INACCESSIBLE;

	public static String RESOURCE_READONLY;

	public static String NO_RESOURCESET_ASSOCiATED_TO_RESOURCE;
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
	private Messages() {
	}
}
