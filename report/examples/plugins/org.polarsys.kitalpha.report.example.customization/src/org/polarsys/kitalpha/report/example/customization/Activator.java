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
 *******************************************************************************/
package org.polarsys.kitalpha.report.example.customization;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.polarsys.kitalpha.report.ui.description.ReportsUI;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin implements IStartup {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.polarsys.kitalpha.examples.report"; //$NON-NLS-1$
	public static final String IMG_SEVERITY_FATAL = "icons/failure.gif";

	public static final String COMMENT_COLUMN_ID = "comment";

	// The shared instance
	private static Activator plugin;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this; // NOSONAR
		ExampleSeverityFactory.INSTANCE.registerSeverities();
		ReportsUI.registerImage(ExampleSeverityFactory.INSTANCE.createFatalError(), getImage(IMG_SEVERITY_FATAL));
		ReportsUI.registerColumnDescription(new CommentColumnDescription("Comment", COMMENT_COLUMN_ID, SWT.LEFT, 80));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null; // NOSONAR
		ReportsUI.unRegisterImage(ExampleSeverityFactory.INSTANCE.createFatalError());
		ReportsUI.unRegisterColumnDescription(COMMENT_COLUMN_ID);
		ExampleSeverityFactory.INSTANCE.unRegisterSeverities();
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	public Image getImage(String path) {
		ImageRegistry imageRegistry = getImageRegistry();
		Image image = imageRegistry.get(path);
		if (image == null) {
			// Create an image descriptor for given id.
			ImageDescriptor imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(getBundle().getSymbolicName(), path);
			// Store the (id, imageDescriptor) rather than (id,image)
			// because with storing (id,image) the getDescriptor method will
			// return null in later usage
			// this way, everything is correctly initialized.
			imageRegistry.put(path, imageDescriptor);
			// Everything is all right at this step, let's get the real image
			image = imageRegistry.get(path);
		}
		return image;
	}

	@Override
	public void earlyStartup() {
		//	not needed
	}

}
