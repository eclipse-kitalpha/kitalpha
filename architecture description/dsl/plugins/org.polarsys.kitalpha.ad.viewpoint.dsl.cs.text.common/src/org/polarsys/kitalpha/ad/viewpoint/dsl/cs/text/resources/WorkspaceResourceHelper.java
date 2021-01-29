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
package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.resources;

import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

import com.google.common.collect.Lists;

/**
 * @author Faycal Abka
 */
public class WorkspaceResourceHelper {

	public static List<IFile> collectWorkspaceResources(final IWorkspace ws,
			final String extension) {
		final List<IFile> wsResources = Lists.newArrayList();

		final IWorkspaceRoot wsRoot = ws.getRoot();
		try {
			wsRoot.accept(new IResourceVisitor() {
				@Override
				public boolean visit(final IResource resource) throws CoreException {
					if (resource.isAccessible() && (resource instanceof IFile)) {
						final IFile file = (IFile) resource;
						if (isCandidate(file, extension)) {
							wsResources.add(file);
						}
					}
					return true;
				}
			});

		} catch (final CoreException e) {
			e.printStackTrace();
		}

		return wsResources;
	}

	public static List<IFile> collectProjectResources(final String projectName,
			final String extension){

		final List<IFile> projectResources = Lists.newArrayList();

		final IWorkspace ws = ResourcesPlugin.getWorkspace();
		final IProject project = ws.getRoot().getProject(projectName);

		try {
			project.accept(new IResourceVisitor() {

				@Override
				public boolean visit(final IResource resource) throws CoreException {
					if (resource.isAccessible() && (resource instanceof IFile)) {
						final IFile file = (IFile) resource;
						if (isCandidate(file, extension)) {
							projectResources.add(file);
						}
					}
					return true;
				}
			});

		} catch (final CoreException e) {
			e.printStackTrace();
		}

		return projectResources;
	}

	public static List<IContainer> getAllWorkspaceContainers(final IWorkspace ws){
		final List<IContainer> containers = Lists.newArrayList();

		final IWorkspaceRoot root = ws.getRoot();

		try {
			root.accept(new IResourceVisitor() {

				@Override
				public boolean visit(final IResource resource) throws CoreException {
					if (resource.isAccessible() && (resource instanceof IContainer)) {
						final IContainer container = (IContainer) resource;
						containers.add(container);
					}
					return true;
				}
			});

		} catch (final CoreException e) {
			e.printStackTrace();
		}

		return containers;
	}


	public static List<IFile> getAllWorkspaceFiles(final IWorkspace ws){
		final List<IFile> files = Lists.newArrayList();

		final IWorkspaceRoot root = ws.getRoot();

		try {
			root.accept(new IResourceVisitor() {

				@Override
				public boolean visit(final IResource resource) throws CoreException {
					if (resource.isAccessible() && (resource instanceof IFile)) {
						final IFile file = (IFile) resource;
						files.add(file);
					}
					return true;
				}
			});

		} catch (final CoreException e) {
			e.printStackTrace();
		}

		return files;
	}



	private static boolean isCandidate(final IFile file, final String extension){
		return ((extension != null) && !extension.isEmpty() && file.getName().endsWith(extension));
	}

}
