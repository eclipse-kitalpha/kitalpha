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
 ******************************************************************************/

package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.extension.constant;

import org.eclipse.osgi.util.NLS;

/**
 * @author Boubekeur Zendagui
 */

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.polarsys.kitalpha.ad.viewpoint.dsl.generation.extension.constant.messages"; //$NON-NLS-1$
	
	public static String Launcher_Extension_Attribut_NotExist;
	
	public static String Contract_ExtensionPointContributions;
	public static String Contract_ExtensionConfigurationElementName;
	public static String Contract_ExtensionFcoreAttributeName;
	public static String Contract_ExtensionPointId;
	public static String Contract_ExtensionFcore;
	public static String Contract_Empty_FactoryComponentsList;
	
	public static String ExtensionSelection_MainPage_Column1;
	public static String ExtensionSelection_MainPage_Column2;
	public static String ExtensionSelection_MainPage_Column3;
	public static String ExtensionSelection_MainPage_Label_Available;
	public static String ExtensionSelection_MainPage_Label_Description;
	public static String ExtensionSelection_MainPage_Name;
	public static String ExtensionSelection_MainPage_Title;

	public static String ExtensionSelection_Wizard_Title;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
