/*******************************************************************************
 * Copyright (c) 2014, 2026 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/

package org.polarsys.kitalpha.ad.af.dsl.servicies.project.ui.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.pde.internal.core.ClasspathComputer;
import org.eclipse.pde.internal.core.natures.PluginProject;

/**
 * @author Boubekeur Zendagui
 */

@SuppressWarnings("restriction")
public class ProjectsManager {
	
	public static ProjectsManager INSTANCE = new ProjectsManager();

	public static IProject createProject(String vpProjectName, String vpShortName,IProgressMonitor monitor) throws CoreException, IOException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(vpProjectName);
		if (!project.exists()) {
			project.create(monitor);
			project.open(monitor);
			addNatures(project, monitor);
			setupJava(project, monitor);
			IFolder metaFolder = project.getFolder("META-INF");
			metaFolder.create(true, true, monitor);
			IFolder modelFolder = project.getFolder("model");
			modelFolder.create(true, true, monitor);
			IFolder iconFolder = project.getFolder("icons");
			iconFolder.create(true, true, monitor);
			createManifest(metaFolder, project.getName());
			createBuildProperties(project);
		}
		return project;
	}
	
	private static void addNatures(IProject project, IProgressMonitor monitor) throws CoreException {
		IProjectDescription description = project.getDescription();
        String[] projectNatures = { /* DslVpProjectNature.NATURE_ID, */ JavaCore.NATURE_ID, PluginProject.NATURE };
		description.setNatureIds(projectNatures);
		project.setDescription(description, monitor);
	}
	
	private static void setupJava(IProject project, IProgressMonitor monitor) throws CoreException {
		IFolder srcFolder = project.getFolder("src");
		srcFolder.create(true, true, null);
		IFolder binFolder = project.getFolder("bin");
		if (!binFolder.exists()) {
			binFolder.create(true, true, null);
		}
		IJavaProject javaProject = JavaCore.create(project);
		javaProject.setOutputLocation(binFolder.getFullPath(), monitor);
		IClasspathEntry[] entries = new IClasspathEntry[3];
		String executionEnvironment = "JavaSE-1.6";
		ClasspathComputer.setComplianceOptions(javaProject, executionEnvironment);
		entries[0] = ClasspathComputer.createJREEntry(executionEnvironment);
		entries[1] = ClasspathComputer.createContainerEntry();
		entries[2] = JavaCore.newSourceEntry(srcFolder.getFullPath());
		javaProject.setRawClasspath(entries, monitor);
	}
	
	private static void createManifest(IFolder metaFolder, String name) throws CoreException {
		IFile manifest = metaFolder.getFile("MANIFEST.MF");
		StringBuffer contents = new StringBuffer();
		contents.append("Manifest-Version: 1.0\n");
		contents.append("Bundle-ManifestVersion: 2\n");
		contents.append("Bundle-Name: " + name + "\n");
		contents.append("Bundle-SymbolicName: " + name + ";singleton:=true\n");
		contents.append("Bundle-Version: 1.0.0.qualifier\n");
		contents.append("Bundle-RequiredExecutionEnvironment: JavaSE-1.6\n");
		contents.append("Bundle-Vendor: Polarsys \n");
		contents.append("Require-Bundle: org.polarsys.kitalpha.resourcereuse\n");
		manifest.create(new ByteArrayInputStream(contents.toString().getBytes()), false, null);
	}

	private static void createBuildProperties(IProject project) throws CoreException {
		IFile buildProperties = project.getFile("build.properties");
		StringBuffer contents = new StringBuffer();
		contents.append("source.. = src/\n");
		contents.append("output.. = bin/\n");
		contents.append("bin.includes = META-INF/,\\\n");
		contents.append("				.,\\\n");
		contents.append("				model/,\\\n");
		contents.append("				plugin.xml\n");
		buildProperties.create(new ByteArrayInputStream(contents.toString().getBytes()), false, null);
	}
	
}
