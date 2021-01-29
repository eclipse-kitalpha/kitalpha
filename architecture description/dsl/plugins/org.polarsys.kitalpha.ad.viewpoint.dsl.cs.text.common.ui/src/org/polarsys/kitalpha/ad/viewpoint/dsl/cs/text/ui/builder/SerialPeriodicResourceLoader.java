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

package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui.builder;

import java.util.Collection;
import java.util.Queue;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.builder.resourceloader.AbstractResourceLoader;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.resources.ResourceHelper;

import com.google.common.collect.Lists;

/**
 * 
 * @author Amine Lajmi
 *
 */
@SuppressWarnings("restriction")
public class SerialPeriodicResourceLoader extends AbstractResourceLoader {

	public SerialPeriodicResourceLoader(IResourceSetProvider resourceSetProvider, Sorter sorter) {
		super(resourceSetProvider, sorter);
	}

	@Override
	public LoadOperation create(final ResourceSet parent, IProject project) {
		
		final Queue<URI> queue = Lists.newLinkedList();
		
			return new CheckedLoadOperation(new LoadOperation() {

				@Override
				public LoadResult next() {
					URI uri = queue.poll();
					try {
						Resource resource = null;
						if (ResourceHelper.hasPeriodicFileExtension(uri)) {
							resource = ResourceHelper.loadResource(uri, parent);
						} else {
							resource = parent.getResource(uri, true);
						}			
						return new LoadResult(resource, uri);
					} catch(WrappedException e) {
						throw new LoadOperationException(uri, e);
					}
				}

				@Override
				public boolean hasNext() {
					return !queue.isEmpty();
				}

				@Override
				public Collection<URI> cancel() {
					return queue;
				}

				@Override
				public void load(Collection<URI> uris) {
					queue.addAll(getSorter().sort(uris));
				}
			});
	}

	@Override
	protected Resource loadResource(URI uri, ResourceSet localResourceSet, ResourceSet parentResourceSet) {
		if (ResourceHelper.hasPeriodicFileExtension(uri)) {
			return ResourceHelper.loadResource(uri, localResourceSet);
		} else {
			return localResourceSet.getResource(uri, true);
		}
	}
}
