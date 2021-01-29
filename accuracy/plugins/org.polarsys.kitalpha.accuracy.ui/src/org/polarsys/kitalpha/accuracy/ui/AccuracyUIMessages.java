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
package org.polarsys.kitalpha.accuracy.ui;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Messages for Accuracy.
 * 
 * @author Guillaume Gebhart
 */
public class AccuracyUIMessages {

	public static final String ACCURACY_ERROR_APPLYINGCONFIGURATION = "accuracy.error.applyingconfiguration"; //$NON-NLS-1$

	private static final String BUNDLE_NAME = "org.polarsys.kitalpha.accuracy.ui.messages"; //$NON-NLS-1$

	public static final String ACCURACY_CONFIGURATIONAPPLIED_MESSAGE = "accuracy.configurationapplied.message"; //$NON-NLS-1$

	public static final String ACCURACY_CONFIGURATIONAPPLIED_TITLE = "accuracy.configurationapplied.title"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private AccuracyUIMessages() {
		//Empty constructor
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
