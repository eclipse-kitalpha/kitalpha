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
package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui;

import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.builderState.IMarkerUpdater;
import org.eclipse.xtext.builder.clustering.ClusteringBuilderState;
import org.eclipse.xtext.builder.impl.XtextBuilder;
import org.eclipse.xtext.builder.resourceloader.IResourceLoader;
import org.eclipse.xtext.ui.resource.UriValidator;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui.builder.PeriodicClusteringBuilderState;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui.builder.PeriodicMarkerUpdater;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui.builder.PeriodicResourceLoaderProvider;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui.builder.PeriodicURIValidator;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui.builder.VpdslXtextBuilder;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

/**
 * 
 * @author Amine Lajmi
 *
 */
@SuppressWarnings("restriction")
public class OverrideSharedModule implements Module {

	public OverrideSharedModule() {
	}
	
	/**
	 * Override Guice shared modules to be able to manage resources with periodic file extensions.
	 */
	@Override
	public void configure(Binder binder) {
		   binder.bind(UriValidator.class).to(PeriodicURIValidator.class);
		   binder.bind(IBuilderState.class).to(PeriodicClusteringBuilderState.class).in(Scopes.SINGLETON);
		   binder.bind(IResourceLoader.class).toProvider(PeriodicResourceLoaderProvider.getSerialLoader());
		   binder.bind(IResourceLoader.class).annotatedWith(Names.named(ClusteringBuilderState.RESOURCELOADER_GLOBAL_INDEX)).toProvider(PeriodicResourceLoaderProvider.getSerialLoader());
		   binder.bind(IResourceLoader.class).annotatedWith(Names.named(ClusteringBuilderState.RESOURCELOADER_CROSS_LINKING)).toProvider(PeriodicResourceLoaderProvider.getSerialLoader());
		   binder.bind(IMarkerUpdater.class).to(PeriodicMarkerUpdater.class);
		   binder.bind(XtextBuilder.class).to(VpdslXtextBuilder.class);
	}
}
