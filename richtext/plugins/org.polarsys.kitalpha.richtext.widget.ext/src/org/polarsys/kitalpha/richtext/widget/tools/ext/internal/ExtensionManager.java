/*******************************************************************************
 * Copyright (c) 2017, 2020 Thales Global Services S.A.S.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License 2.0 which is available at
 *  http://www.eclipse.org/legal/epl-2.0
 *  
 *  SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.richtext.widget.tools.ext.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.polarsys.kitalpha.richtext.widget.tools.ext.intf.OpenLinkStrategy;

/**
 * 
 * @author Faycal Abka
 *
 */
public class ExtensionManager {
	
	private static final String EXTENSION_ID = "org.polarsys.kitalpha.richtext.widget.tools.ext.openLinkStrategy";
	private static final String STRATEG_ATTR = "strategy";
	
	public OpenLinkStrategy getFirstFoundStrategy() {
		
		IConfigurationElement[] contributions = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
		
		if (contributions != null && contributions.length > 0) {
			for (IConfigurationElement c : contributions) {
				try {
					return (OpenLinkStrategy) c.createExecutableExtension(STRATEG_ATTR);
				} catch (CoreException e) {
					Status status = new Status(IStatus.WARNING, Activator.PLUGIN_ID, "Cannot instantiate " + c.getAttribute(STRATEG_ATTR), e);
					Activator.getDefault().getLog().log(status);
				}
			}
		}
		
		return null;
		
	}
	
}
