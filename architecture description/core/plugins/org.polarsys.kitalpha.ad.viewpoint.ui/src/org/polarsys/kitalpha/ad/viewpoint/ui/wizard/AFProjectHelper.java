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

package org.polarsys.kitalpha.ad.viewpoint.ui.wizard;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.pde.internal.core.ClasspathComputer;
import org.eclipse.pde.internal.core.natures.PluginProject;
import org.polarsys.kitalpha.ad.common.ProjectNature;
import org.polarsys.kitalpha.ad.viewpoint.ui.Activator;

/**
 * @author Thomas Guiu
 * 
 */
public class AFProjectHelper {
	
	protected final Set<String> requiredBundles = new HashSet<String>();

	public AFProjectHelper() {
		super();
		requiredBundles.add("org.polarsys.kitalpha.ad.viewpoint.ui");
	}

	public IProject createProject(String name, String vpName, String vpId, String vpuuid, String vpURI, IProgressMonitor monitor) throws CoreException, IOException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
		if (!project.exists()) {
			project.create(monitor);
		}
		project.open(monitor);
		addNatures(project, monitor);
		setupJava(project, monitor);
		IFolder metaFolder = createFolder(project, "META-INF", monitor);
		createFolder(project, "model", monitor);
		createManifest(metaFolder, project.getName(), monitor);
		createBuildProperties(project, monitor);
		createPluginXML(project, vpName, vpId, vpuuid, vpURI, monitor);
		createIcon(project, monitor);

		return project;
	}

	protected void createIcon(IProject project, IProgressMonitor monitor) throws CoreException, IOException {
		URL entry = Activator.getDefault().getBundle().getEntry("icons/view.gif");
		IFolder iconFolder = createFolder(project, "icons", monitor);

		IFile iconFile = iconFolder.getFile(new Path("view.gif"));
		writeFile(entry.openStream(), iconFile, monitor);

	}

	protected void createPluginXML(IProject project, String vpName, String vpId, String vpuuid, String vpURI, IProgressMonitor monitor) throws CoreException {
		IFile xml = project.getFile("plugin.xml");
		StringBuffer contents = new StringBuffer();

		String viewId = vpId + ".view";

		contents.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		contents.append("<?eclipse version=\"3.4\"?>\n");
		contents.append("<plugin>\n");
		contents.append("	<extension\n");
		contents.append("	     point=\"org.eclipse.ui.views\">\n");
		contents.append("	  <view\n");
		contents.append("	        name=\"").append(vpName).append("\"\n");
		contents.append("	        icon=\"icons/view.gif\"\n");
		contents.append("	        category=\"org.polarsys.kitalpha.view.additional.category\"\n");
		contents.append("	        class=\"org.polarsys.kitalpha.ad.viewpoint.ui.views.ViewpointView\"\n");
		contents.append("	        id=\"").append(viewId).append("\"\n");
		contents.append("	        resourceId=\"").append(vpId).append("\"/>\n");
		contents.append("	</extension>\n");

		contents.append("	<extension\n");
		contents.append("	     point=\"org.polarsys.kitalpha.resourcereuse.resources\">\n");
		contents.append("	  <resource\n");
		contents.append("	        domain=\"AF\"\n");
		contents.append("	        id=\"").append(vpId).append("\"\n");
		contents.append("	        tags=\"vp\"\n");
		contents.append("	        name=\"").append(vpName).append("\"\n");
		contents.append("	        path=\"").append(vpURI).append('#').append(vpuuid).append("\"/>\n");
		contents.append("	</extension>\n");

		contents.append("	<extension\n");
		contents.append("	     point=\"org.eclipse.ui.propertiesView\">\n");
		contents.append("	        <excludeSources\n");
		contents.append("	           id=\"").append(viewId).append("\">\n");
		contents.append("	        </excludeSources>\n");
		contents.append("	</extension>\n");

		contents.append("</plugin>\n");

		contents.append("\n");
		ByteArrayInputStream source = new ByteArrayInputStream(contents.toString().getBytes());
		writeFile(source, xml, monitor);
	}

	protected void addNatures(IProject project, IProgressMonitor monitor) throws CoreException {
		IProjectDescription description = project.getDescription();
        String[] newNatures = { JavaCore.NATURE_ID, PluginProject.NATURE, ProjectNature.VP_NATURE };
		description.setNatureIds(newNatures);
		project.setDescription(description, monitor);
	}

	protected void setupJava(IProject project, IProgressMonitor monitor) throws CoreException {
		IFolder srcFolder = createFolder(project, "src", monitor);
		IFolder binFolder = createFolder(project, "bin", monitor);

		IJavaProject javaProject = JavaCore.create(project);
		javaProject.setOutputLocation(binFolder.getFullPath(), monitor);
		IClasspathEntry[] entries = new IClasspathEntry[3];
		String executionEnvironment = "J2SE-1.5";
		ClasspathComputer.setComplianceOptions(javaProject, executionEnvironment);
		entries[0] = ClasspathComputer.createJREEntry(executionEnvironment);
		entries[1] = ClasspathComputer.createContainerEntry();
		entries[2] = JavaCore.newSourceEntry(srcFolder.getFullPath());
		javaProject.setRawClasspath(entries, monitor);
	}

	protected void createManifest(IFolder metaFolder, String name, IProgressMonitor monitor) throws CoreException {
		IFile manifest = metaFolder.getFile("MANIFEST.MF");
		StringBuffer contents = new StringBuffer();
		contents.append("Manifest-Version: 1.0\n");
		contents.append("Bundle-ManifestVersion: 2\n");
		contents.append("Bundle-Name: " + name + "\n");
		contents.append("Bundle-SymbolicName: " + name + ";singleton:=true\n");
		contents.append("Bundle-Version: 1.0.0.qualifier\n");
		contents.append("Bundle-RequiredExecutionEnvironment: J2SE-1.5\n");
		if (!requiredBundles.isEmpty()) {
			Iterator<String> iterator = requiredBundles.iterator();
			contents.append("Require-Bundle: ").append(iterator.next()).append(iterator.hasNext() ? ",\n" : "\n");
			while (iterator.hasNext()) {
				contents.append(" ").append(iterator.next()).append(iterator.hasNext() ? ",\n" : "\n");
			}
		}
		contents.append("\n");
		ByteArrayInputStream source = new ByteArrayInputStream(contents.toString().getBytes());
		writeFile(source, manifest, monitor);
	}

	protected void createBuildProperties(IProject project, IProgressMonitor monitor) throws CoreException {
		IFile buildProperties = project.getFile("build.properties");
		StringBuffer contents = new StringBuffer();
		contents.append("source.. = src/\n");
		contents.append("output.. = bin/\n");
		contents.append("bin.includes = META-INF/,\\\n");
		contents.append("				.,\\\n");
		contents.append("				model/");
		ByteArrayInputStream source = new ByteArrayInputStream(contents.toString().getBytes());
		writeFile(source, buildProperties, monitor);
	}

	protected IFolder createFolder(IProject project, String name, IProgressMonitor monitor) throws CoreException {
		IFolder folder = project.getFolder(name);
		if (!folder.exists()) {
			folder.create(true, true, monitor);
		}
		return folder;
	}

	protected void writeFile(InputStream source, IFile manifest, IProgressMonitor monitor) throws CoreException {
		if (manifest.exists()) {
			manifest.setContents(source, IResource.FORCE | IResource.KEEP_HISTORY, monitor);
		} else {
			manifest.create(source, false, null);
		}
	}

}
