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
package org.polarsys.kitalpha.resourcereuse.helper;

import org.polarsys.kitalpha.resourcereuse.registry.LivePlatformReader;
import org.polarsys.kitalpha.resourcereuse.registry.LiveTargetPlatformReader;
import org.polarsys.kitalpha.resourcereuse.registry.LiveWorkspaceReader;
import org.polarsys.kitalpha.resourcereuse.registry.PlatformReader;
import org.polarsys.kitalpha.resourcereuse.registry.ResourceRegistry;
import org.polarsys.kitalpha.resourcereuse.registry.TargetPlatformReader;
import org.polarsys.kitalpha.resourcereuse.registry.WorkspaceReader;

/**
 * @author Thomas Guiu
 * 
 */
public class ResourceReuse {

	/**
	 * This kind of helper does not work properly :(
	 */
	private static ResourceHelper createLiveHelper() {
		ResourceRegistry platformResources = new LivePlatformReader().readResources();
		ResourceRegistry targetPlatformResources = new LiveTargetPlatformReader().readResources(platformResources);
		return new LiveWorkspaceReader().readResources(targetPlatformResources);
	}

	public static ResourceHelper createHelper() {
		ResourceRegistry platformResources = new PlatformReader().readResources();
		ResourceRegistry targetPlatformResources = new TargetPlatformReader().readResources(platformResources);
		return new WorkspaceReader().readResources(targetPlatformResources);
	}

	public static ResourceHelper createRuntimeHelper() {
		ResourceRegistry platformResources = new PlatformReader().readResources();
		return new TargetPlatformReader().readResources(platformResources);
	}

	public static ResourceHelper createPlatformHelper() {
		return new PlatformReader().readResources();
	}

	public static ResourceHelper createWorkspaceHelper() {
		return new WorkspaceReader().readResources(null);
	}

	private ResourceReuse() {
		super();
	}

}
