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
/**
 * Copyright (c) THALES, 2012. All rights reserved.
 */
package org.polarsys.kitalpha.ad.viewpoint.dsl.services.cs.text.wizards.util;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.polarsys.kitalpha.ad.viewpoint.dsl.services.cs.text.preferences.kitalphaPreferences.PreferencesConstants;
import org.polarsys.kitalpha.ad.viewpoint.dsl.services.project.utils.NamesValidityChecker;

/**
 * 
 * @author Amine Lajmi
 *
 */
public class WizardsUtil {
	
	public static final String COPYRIGHT_KITALPHA = "PolarSys";
	
	public static final String GENERATOR_SPECILIZATION_EXTENSION_ID = "org.polarsys.kitalpha.ad.ta.definition"; //$NON-NLS-1$
	
	public static final String GENERATOR_SPECILIZATION_EXTENSION_POINT_NAME = "definition";
	
	public static final String GENERATOR_SPECILIZATION_EXTENSION_POINT_ATTRIBUTE = "name";
	
	private static final String SPACE = " ";
	private static final String QUOTES = "\"";
	
	
	public WizardsUtil() {
	}
	
	
	public static String getInitialSpecContent(String shortName) {
		String fileContent = 
			"/**\n" + 
			" * Copyright (c) " + WizardsUtil.COPYRIGHT_KITALPHA + ", " + getCurrentYear() + ". All rights reserved. \n" +
			" *\n" +
			" *	Viewpoint " + shortName + "\n" +
			" *	@author: " + getCurrentUserName() + "\n" +
			" *	@date: " +  getCurrentDate() + "\n" +
			" *\n" +
			" */\n" +
			"Viewpoint " + shortName + " {\n" +
			"	name: \"" + shortName + "\"\n"+
			"	Data " + shortName + ".data" + "\n"+
			"	Configuration " + shortName + ".conf" + "\n"+
			"}";
		return fileContent;
	}
	
	public static String getInitialBuildContent(String shortName) {

		String projectTargetPlatform = PreferencesConstants.getBuildPreferences(PreferencesConstants.TARGET_PLATFORM_PREF);
		String projectRootFeatures = PreferencesConstants.getBuildPreferences(PreferencesConstants.FEATURES_ROOT_PATH);
		
		String fileContent = 	
			"/**\n" + 
			" * Copyright (c) " + WizardsUtil.COPYRIGHT_KITALPHA + ", " + getCurrentYear() + ". All rights reserved. \n" +
			" *\n" +
			" *	Viewpoint " + shortName + "\n" +
			" *	@author: " + getCurrentUserName() + "\n" +
			" *	@date: " +  getCurrentDate()+"\n" +
			" *\n" +
			" */\n" +
			"Build " + shortName + ".build" + " {\n" +
			"	target-platform: " + "\"" + projectTargetPlatform + "\"" + "\n" +
			"	repository: git " + "\"http://shortName" + "/" + shortName + ".git\"" + "\n" +
			"	features: " + projectRootFeatures +"." + shortName + ".feature" + "\n" +
			"}";
		return fileContent;
	}
	
	public static String getInitialBuildContent(String shortName, String fileName) {
		
		String projectTargetPlatform = "C://eclipse.exe"; 
		String projectRootFeatures = PreferencesConstants.getBuildPreferences(PreferencesConstants.FEATURES_ROOT_PATH);
		
		String fileContent = 	
			"/**\n" + 
			" * Copyright (c) " + WizardsUtil.COPYRIGHT_KITALPHA + ", " + getCurrentYear() + ". All rights reserved. \n" +
			" *\n" +
			" *	Viewpoint " + shortName + "\n" +
			" *	@author: " + getCurrentUserName() + "\n" +
			" *	@date: " +  getCurrentDate()+"\n" +
			" *\n" +
			" */\n" +
			"Build " + fileName + " {\n" +
			"	target-platform: " + "\"" + projectTargetPlatform + "\"" + "\n" +
			"	repository: git " + "\"http://shortName" + "/" + shortName + ".git\"" + "\n" +
			"	features: " + projectRootFeatures + "." + shortName + ".feature" + "\n" +
			"}";
		return fileContent;
	}
	
	public static String getInitialConfigurationContent(String shortName, String targetApplication, String rootProjectName, String nsURI) {
		String fileContent = 	
			"/**\n" + 
			" * Copyright (c) " + WizardsUtil.COPYRIGHT_KITALPHA + ", " + getCurrentYear() + ". All rights reserved. \n" +
			" *\n" +
			" *	Viewpoint " + shortName + "\n" +
			" *	@author: " + getCurrentUserName() + "\n" +
			" *	@date: " +  getCurrentDate()+"\n" +
			" *\n" +
			" */\n" +
			"Configuration " + shortName + ".conf" + " {\n";
		
			if (targetApplication != null && targetApplication.contains(SPACE)){
				fileContent = fileContent + 	"	target " + QUOTES + targetApplication + QUOTES + "\n";
			} else {
				fileContent = fileContent +		"	target " + targetApplication + "\n";
			}
			
			fileContent = fileContent + 	"	project " + rootProjectName + "\n" +
			"	nsuri " + "\"" + nsURI+ "\"" + "\n";
			
			fileContent = fileContent + "\trelease {\n\t\t" +
				"version : 1.0.0.qualifier\n\t\t" +
				"description : \"Viewpoint Description\"\n\t\t" +
				"execution environments : \"JavaSE-1.6\"\n\t" + 
			"}\n";
			
			fileContent += "\tgeneration {\n" +
					"\t\tdata (\n" +
					"\t\t\tModel: true\n" +
					"\t\t\tEdit: true\n" + 
					"\t\t\tEditor: false\n" +
					"\t\t\tTest: false\n" +
					"\t\t\tJavadoc: false\n" +
					"\t\t\tOverwriteEcore: true\n" +
					"\t\t)\n" +
					"\t\tdiagram (\n" +
					"\t\t\tOverwriteOdesign: true\n" +
					"\t\t)\n" +
					"\t\tdocumentation (\n" +
					"\t\t\tEcoreToHtml: false\n" +
					"\t\t)\n" +
					"\t}\n" +
					"}\n";
			
		return fileContent;
	}
	
	public static String getInitialConfigurationContent(String shortName, String fileName, String targetApplication, String rootProjectName, String nsURI) {
		String fileContent = 	
			"/**\n" + 
			" * Copyright (c) " + WizardsUtil.COPYRIGHT_KITALPHA + ", " + getCurrentYear() + ". All rights reserved. \n" +
			" *\n" +
			" *	Viewpoint " + shortName + "\n" +
			" *	@author: " + getCurrentUserName() + "\n" +
			" *	@date: " +  getCurrentDate()+"\n" +
			" *\n" +
			" */\n" +
			"Configuration " + fileName + " {\n";
			if (targetApplication != null && targetApplication.contains(SPACE)){
				fileContent = fileContent + 	"	target " + QUOTES + targetApplication + QUOTES + "\n";
			} else {
				fileContent = fileContent +		"	target " + targetApplication + "\n";
			}

			fileContent = fileContent + 	"	project " + rootProjectName + "\n" +
				"	project " + rootProjectName + "\n" +
				"	nsuri " + "\"" + nsURI+ "\"" + "\n";
			
			fileContent = fileContent + "\trelease {\n\t\t" +
					"version : 1.0.0.qualifier\n\t\t" +
					"description : \"Viewpoint Description\"\n\t\t" +
					"execution environments : \"JavaSE-1.6\"\n\t" + 
					"}\n";
			
			fileContent += "\tgeneration {\n" +
					"\t\tdata (\n" +
					"\t\t\tModel: true\n" +
					"\t\t\tEdit: true\n" + 
					"\t\t\tEditor: false\n" +
					"\t\t\tTest: false\n" +
					"\t\t\tJavadoc: false\n" +
					"\t\t\tOverwriteEcore: true\n" +
					"\t\t)\n" +
					"\t\tdiagram (\n" +
					"\t\t\tOverwriteOdesign: true\n" +
					"\t\t)\n" +
					"\t\tdocumentation (\n" +
					"\t\t\tEcoreToHtml: false\n" +
					"\t\t)\n" +
					"\t}\n" +
					"}\n";
			return fileContent;
	}
	
	public static String getInitialDataContent(String shortName) {
		String fileContent = 	
			"/**\n" + 
			" * Copyright (c) " + WizardsUtil.COPYRIGHT_KITALPHA + ", " + getCurrentYear() + ". All rights reserved. \n" +
			" *\n" +
			" *	Viewpoint " + shortName + "\n" +
			" *	@author: " + getCurrentUserName() + "\n" +
			" *	@date: " +  getCurrentDate()+"\n" +
			" *\n" +
			" */\n" +
			"Data " + shortName + ".data" + " {\n\n" +
			"}";
		return fileContent;
	}
	
	public static String getInitialDataContent(String shortName, String fileName) {
		String fileContent = 	
			"/**\n" + 
			" * Copyright (c) " + WizardsUtil.COPYRIGHT_KITALPHA + ", " + getCurrentYear() + ". All rights reserved. \n" +
			" *\n" +
			" *	Viewpoint " + shortName + "\n" +
			" *	@author: " + getCurrentUserName() + "\n" +
			" *	@date: " +  getCurrentDate()+"\n" +
			" *\n" +
			" */\n" +
			"Data " + fileName + " {\n\n" +
			"}";
		return fileContent;
	}
	
	public static String getInitialDiagramContent(String shortName) {
		String fileContent = 	
			"/**\n" + 
			" * Copyright (c) " + WizardsUtil.COPYRIGHT_KITALPHA + ", " + getCurrentYear() + ". All rights reserved. \n" +
			" *\n" +
			" *	Viewpoint " + shortName + "\n" +
			" *	@author: " + getCurrentUserName() + "\n" +
			" *	@date: " +  getCurrentDate()+"\n" +
			" *\n" +
			" */\n" +
			"Diagrams " + shortName + ".diagram" + " {\n" +
			"}";
		return fileContent;
	}
	
	public static String getInitialDiagramContent(String shortName, String fileName) {
		String fileContent = 	
			"/**\n" + 
			" * Copyright (c) " + WizardsUtil.COPYRIGHT_KITALPHA + ", " + getCurrentYear() + ". All rights reserved. \n" +
			" *\n" +
			" *	Viewpoint " + shortName + "\n" +
			" *	@author: " + getCurrentUserName() + "\n" +
			" *	@date: " +  getCurrentDate()+"\n" +
			" *\n" +
			" */\n" +
			"Diagrams " + fileName + " {\n" +
			"}";
		return fileContent;
	}
	
	public static String getInitialServicesContent(String shortName) {
		String fileContent = 	
			"/**\n" + 
			" * Copyright (c) " + WizardsUtil.COPYRIGHT_KITALPHA + ", " + getCurrentYear() + ". All rights reserved. \n" +
			" *\n" +
			" *	Viewpoint " + shortName + "\n" +
			" *	@author: " + getCurrentUserName() + "\n" +
			" *	@date: " +  getCurrentDate()+"\n" +
			" *\n" +
			" */\n" +
			"Rules " + shortName + ".rules" + " {\n" +
			"}\n\n" +
			"Services " + shortName + ".services" + " {\n" +
			"}";
		return fileContent;
	}
	
	public static String getInitialServicesContent(String shortName, String fileName) {
		String fileContent = 	
			"/**\n" + 
			" * Copyright (c) " + WizardsUtil.COPYRIGHT_KITALPHA + ", " + getCurrentYear() + ". All rights reserved. \n" +
			" *\n" +
			" *	Viewpoint " + shortName + "\n" +
			" *	@author: " + getCurrentUserName() + "\n" +
			" *	@date: " +  getCurrentDate()+"\n" +
			" *\n" +
			" */\n" +
			"Rules " + fileName.substring(0, fileName.indexOf(".")) + ".rules" + " {\n" +
			"}\n\n" +
			"Services " + fileName + " {\n" +
			"}";
		return fileContent;
	}
	
	public static String getInitialUIContent(String shortName) {
		String fileContent = 	
			"/**\n" + 
			" * Copyright (c) " + WizardsUtil.COPYRIGHT_KITALPHA + ", " + getCurrentYear() + ". All rights reserved. \n" +
			" *\n" +
			" *	Viewpoint " + shortName + "\n" +
			" *	@author: " + getCurrentUserName() + "\n" +
			" *	@date: " +  getCurrentDate()+"\n" +
			" *\n" +
			" */\n" +
			"UIDescription " + shortName + " {\n" +
			"	\n" +
			"}";
		return fileContent;
	}
	
	public static String getInitialUIContent(String shortName, String fileName) {
		String fileContent = 	
			"/**\n" + 
			" * Copyright (c) " + WizardsUtil.COPYRIGHT_KITALPHA + ", " + getCurrentYear() + ". All rights reserved. \n" +
			" *\n" +
			" *	Viewpoint " + shortName + "\n" +
			" *	@author: " + getCurrentUserName() + "\n" +
			" *	@date: " +  getCurrentDate()+"\n" +
			" *\n" +
			" */\n" +
			"UIDescription " + fileName + " {\n" +
			"	\n" +
			"}";
		return fileContent;
	}
	
	public static String getInitialActivityExplorerContent(String shortName) {
		String fileContent = 	
			"/**\n" + 
			" * Copyright (c) " + WizardsUtil.COPYRIGHT_KITALPHA + ", " + getCurrentYear() + ". All rights reserved. \n" +
			" *\n" +
			" *	Viewpoint " + shortName + "\n" +
			" *	@author: " + getCurrentUserName() + "\n" +
			" *	@date: " +  getCurrentDate()+"\n" +
			" *\n" +
			" */\n" +
			"activity-explorer " + shortName + ".activityexplorer" + " {\n\n" +
			"}";
		return fileContent;
	}
	
	public static String getInitialActivityExplorerContent(String shortName, String fileName) {
		String fileContent = 	
				"/**\n" + 
				" * Copyright (c) " + WizardsUtil.COPYRIGHT_KITALPHA + ", " + getCurrentYear() + ". All rights reserved. \n" +
				" *\n" +
				" *	Viewpoint " + shortName + "\n" +
				" *	@author: " + getCurrentUserName() + "\n" +
				" *	@date: " +  getCurrentDate()+"\n" +
				" *\n" +
				" */\n" +
				"activity-explorer " + fileName + " {\n\n" +
				"}";
		return fileContent;
	}
	
	public static String getCurrentUserName() {
		return System.getProperty("user.name");
	}

	public static String getCurrentDate() {	
		return DateFormat.getDateInstance(DateFormat.SHORT).format(new java.util.Date());
	}
	
	public static String getCurrentYear(){
		return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	}
	
	public static String[] getSupportedPlatforms() {
		List<String> supportedModelingEnvironment = WizardsUtil.getSupportedModelingEnvironment();
		String[] arrayModelingEnvironment = new String[supportedModelingEnvironment.size()+1];
		arrayModelingEnvironment[0] ="--";
		int i = 1;
		for (String candidate : supportedModelingEnvironment) {
			arrayModelingEnvironment[i] = candidate;
			i++;
		}		
		return arrayModelingEnvironment;
	}

	
	public static List<String> getSupportedModelingEnvironment(){
		IConfigurationElement[] config =Platform.getExtensionRegistry().getConfigurationElementsFor(GENERATOR_SPECILIZATION_EXTENSION_ID);
		List<String> targets = new ArrayList<String>();
		if (config.length != 0){
			for (IConfigurationElement iConfigurationElement : config) {
				if (iConfigurationElement.getName().equals(GENERATOR_SPECILIZATION_EXTENSION_POINT_NAME)){
					targets.add(iConfigurationElement.getAttribute(GENERATOR_SPECILIZATION_EXTENSION_POINT_ATTRIBUTE));
				}
			}
		}
		return targets;
	}
	
	public static boolean isValid(String name, boolean pojectName){
		return NamesValidityChecker.isValid(name, pojectName);
	}
}
