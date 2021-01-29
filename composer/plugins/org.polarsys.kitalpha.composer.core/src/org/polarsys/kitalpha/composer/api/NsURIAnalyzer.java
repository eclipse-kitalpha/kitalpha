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


package org.polarsys.kitalpha.composer.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import org.polarsys.kitalpha.composer.Activator;

/**
 * This type is able to get NsURIs of a model without loading it. (it's very
 * powerful !)
 * 
 * @author Yann Mortier
 */
public class NsURIAnalyzer {

	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator");

	private static final Pattern PATTERN = Pattern
			.compile("(xmlns:.*?=\"(.*?)\")");

	/**
	 * Returns all NsURIs used by the given model.
	 * 
	 * @param file
	 *            the model to analyse.
	 * @return all NsURIs used by the given model.
	 */
	public static Collection<String> getNsURIs(File file) {
		Collection<String> result = new HashSet<String>();

		//
		StringBuilder content = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));
			try {
				String line;
				while ((line = reader.readLine()) != null) {
					content.append(line);
					content.append(LINE_SEPARATOR);
				}
			} finally {
				reader.close();
			}
		} catch (IOException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					"Impossible to read file: " + file.getName(), e);
			Activator.getDefault().getLog().log(status);
		}

		Matcher matcher = PATTERN.matcher(content);
		while (matcher.find()) {
			if (matcher.groupCount() >= 2) {
				result.add(matcher.group(2));
			}
		}

		return result;
	}
}
