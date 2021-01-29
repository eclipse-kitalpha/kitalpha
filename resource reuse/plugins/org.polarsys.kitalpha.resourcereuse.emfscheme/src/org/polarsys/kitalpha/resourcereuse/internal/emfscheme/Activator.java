/*******************************************************************************
 * Copyright (c) 2016, 2020 Thales Global Services S.A.S.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License 2.0 which is available at
 *  http://www.eclipse.org/legal/epl-2.0
 *  
 *  SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.resourcereuse.internal.emfscheme;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * 
 * @author Xavier DECOOL
 *
 */
public class Activator implements BundleActivator {

	public static final String PLUGIN_ID = "org.polarsys.kitalpha.resourcereuse.emfscheme";
	private static Activator plugin;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		plugin = this;
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		plugin = null;
	}

	public static Activator getDefault() {
		return plugin;
	}

}
