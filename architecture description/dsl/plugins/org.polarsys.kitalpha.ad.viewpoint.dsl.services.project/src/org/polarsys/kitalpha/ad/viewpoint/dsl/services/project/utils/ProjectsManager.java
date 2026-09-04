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

package org.polarsys.kitalpha.ad.viewpoint.dsl.services.project.utils;

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
import org.polarsys.kitalpha.ad.viewpoint.dsl.services.project.nature.ViewpointDslProjectNature;

/**
 * @author Boubekeur Zendagui
 */

@SuppressWarnings("restriction")
public class ProjectsManager {
	
	public static ProjectsManager INSTANCE = new ProjectsManager();
	
	private static final String _JAVA_VERSION = "JavaSE-1.6";
	private static final String _BUNDLE_PROVIDER = "www.polarsys.org";

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
			createPluginProperties(project, project.getName(), vpShortName + " viewpoint description project");
			createManifest(metaFolder, project.getName());
			createBuildProperties(project);
			createPluginXml(project);
		}
		return project;
	}
	
	private static void addNatures(IProject project, IProgressMonitor monitor) throws CoreException {
		IProjectDescription description = project.getDescription();
        String[] projectNatures = { ViewpointDslProjectNature.NATURE_ID, JavaCore.NATURE_ID, PluginProject.NATURE };
		description.setNatureIds(projectNatures);
		project.setDescription(description, monitor);
	}
	
	private static void setupJava(IProject project, IProgressMonitor monitor) throws CoreException {
		IFolder srcFolder = project.getFolder("src");
		if (! srcFolder.exists())
			srcFolder.create(true, true, null);
		
		IFolder binFolder = project.getFolder("bin");
		if (! binFolder.exists()) 
			binFolder.create(true, true, null);
		
		IJavaProject javaProject = JavaCore.create(project);
		javaProject.setOutputLocation(binFolder.getFullPath(), monitor);
		IClasspathEntry[] entries = new IClasspathEntry[3];
		ClasspathComputer.setComplianceOptions(javaProject, _JAVA_VERSION);
		entries[0] = ClasspathComputer.createJREEntry(_JAVA_VERSION);
		entries[1] = ClasspathComputer.createContainerEntry();
		entries[2] = JavaCore.newSourceEntry(srcFolder.getFullPath());
		javaProject.setRawClasspath(entries, monitor);
	}
	
	private static void createManifest(IFolder metaFolder, String id) throws CoreException {
		IFile manifest = metaFolder.getFile("MANIFEST.MF");
		StringBuffer contents = new StringBuffer();
		contents.append("Manifest-Version: 1.0\n");
		contents.append("Bundle-ManifestVersion: 2\n");
		contents.append("Bundle-SymbolicName: " + id + ";singleton:=true\n");
		contents.append("Bundle-Name: %Bundle-Name \n");
		contents.append("Bundle-Vendor: %Bundle-Vendor \n");
		contents.append("Bundle-Version: 1.0.0.qualifier\n");
		contents.append("Bundle-Localization: plugin\n");
		contents.append("Bundle-RequiredExecutionEnvironment: ").append(_JAVA_VERSION).append("\n");
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
		contents.append("				icons/,\\\n");
		contents.append("				plugin.properties,\\\n");
		contents.append("				plugin.xml\n");
		buildProperties.create(new ByteArrayInputStream(contents.toString().getBytes()), false, null);
	}
	
	private static void createPluginProperties(IProject project, String id, String label) throws CoreException {
		IFile pluginProperties = project.getFile("plugin.properties");
		label = label.substring(0, 1).toUpperCase() + label.substring(1, label.length() );
		StringBuffer contents = new StringBuffer();
		contents.append("#Project created with viewpoint dsl reverse engine\n");
		contents.append("#Properties file for "+ id +" \n");
		contents.append("# Manifest Strings \n");
		contents.append("Bundle-Name = ").append(label).append(" \n");
		contents.append("Bundle-Vendor = ").append(_BUNDLE_PROVIDER).append(" \n");
		pluginProperties.create(new ByteArrayInputStream(contents.toString().getBytes()), false, null);
	}
	
	private static void createPluginXml(IProject project) throws CoreException{
		IFile pluginXml = project.getFile("plugin.xml");
		StringBuffer contents = new StringBuffer();
		contents.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		contents.append("<?eclipse version=\"3.4\"?>\n");
		contents.append("<plugin>\n");
		contents.append("</plugin>\n");
		pluginXml.create(new ByteArrayInputStream(contents.toString().getBytes()), false, null);
	}
	
}
