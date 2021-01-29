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

package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.build.util;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.core.pde.tools.ConvertProjectOperation;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.pde.internal.core.ClasspathComputer;
import org.eclipse.pde.internal.core.util.CoreUtility;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.internal.editors.text.WorkspaceOperationRunner;

/**
 * 
 * @author Amine Lajmi
 *
 */
@SuppressWarnings("restriction")
public class JavaUtil {
	
	private static final String DEFAULT_SOURCE_FOLDER = "src";
	private static final String DEFAULT_BINARY_FOLDER = "bin";
	
    public static void convertJavaProjectToPlugin(String projectId, IProgressMonitor monitor) throws InvocationException{
    	try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectId);
			WorkspaceOperationRunner runner = new WorkspaceOperationRunner();
			runner.setProgressMonitor(monitor);
			runner.run(false, false, new ConvertProjectOperation(project, false, true));
		} catch (Exception e) {
			throw new InvocationException(e);
		}
    }

	public static void createJavaProject(String projectId, String executionenvirenment, IProgressMonitor monitor)
			throws InvocationException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        org.eclipse.core.resources.IProject project = root.getProject(projectId);
        try {
            if (!project.exists()) {
				CoreUtility.createProject(project, root.getRawLocation(), monitor);
			}
            project.open(monitor);
            CoreUtility.addNatureToProject(project, JavaCore.NATURE_ID, monitor);
            CoreUtility.createFolder(project.getFolder(DEFAULT_SOURCE_FOLDER));
            // set up classpath
            IJavaProject javaProject = JavaCore.create(project);
            // Set output folder
            IPath path = project.getFullPath().append(DEFAULT_BINARY_FOLDER);
            javaProject.setOutputLocation(path, monitor);
            IClasspathEntry[] entries = new IClasspathEntry[3];
            entries[0] = JavaCore.newSourceEntry(project.getProject().getFullPath().append(DEFAULT_SOURCE_FOLDER));
            ClasspathComputer.setComplianceOptions(javaProject, executionenvirenment);
            entries[1] = ClasspathComputer.createJREEntry(executionenvirenment);
            entries[2] = ClasspathComputer.createContainerEntry();
            javaProject.setRawClasspath(entries, monitor);

        } catch (CoreException e) {
            throw new InvocationException(e);
        }
	}
	
	public static IFolder packageToFolder(IProject project, String packageName){
		String folder = JavaUtil.getValidPackageName(DEFAULT_SOURCE_FOLDER+"."+packageName);
		folder = folder.replaceAll("\\.", "/");
		return project.getFolder(new Path(folder));
	}
	
	public static String formatJavaCode(String javaCode){
		CodeFormatter cf = ToolFactory.createCodeFormatter(null);
        TextEdit te = cf.format(CodeFormatter.K_UNKNOWN, javaCode, 0,javaCode.length(),0,null);
        IDocument dc = new Document(javaCode);
        try {
        	te.apply(dc);
        	javaCode = dc.get();
        } catch (MalformedTreeException e) {
                e.printStackTrace();
        } catch (org.eclipse.jface.text.BadLocationException e) {
                e.printStackTrace();
        }
		return javaCode;
	}
	
	public static void writeJavaContent(IFile javaFile, String javaCode){
		String formatedOutput = formatJavaCode(javaCode);
		ByteArrayInputStream outputContent = new ByteArrayInputStream(formatedOutput.getBytes());
		try {
			if (javaFile.exists()) {
				javaFile.setContents(outputContent, true, false, null);
			} else {
				javaFile.create(outputContent, true, null);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	public static String getValidPackageName(String name){
		return name.replaceAll("[^a-zA-Z0-9_.]","").toLowerCase();
	}
	
	public static String getValidClassName(String name){
		String cName = name.replaceAll("[^a-zA-Z0-9_]","");
		return cName.substring(0,1).toUpperCase() + cName.substring(1);
	}
	
	public static IFolder createFolder(String projectName, String folderName){
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		IFolder folder = project.getFolder(folderName);
		if (! folder.exists()){
			try {
				folder.create(true, true, null);
				return folder;
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return folder;
	}
	
	public static void createPackage(String projectName, String packageName){
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		IFolder src = project.getFolder(DEFAULT_SOURCE_FOLDER);
		if (! src.exists()){
			try {
				src.create(true, true, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		Path packageFolderPath = new Path(packageName.replace('.', '/'));
		if (src.getFolder(packageFolderPath).exists()) {
			return;
		}		
		IFolder parent = src;
		for (int i = 0; i < packageFolderPath.segmentCount(); i++) {
			IFolder curFolder = parent.getFolder(packageFolderPath.segment(i));
			if (! curFolder.exists()){
				try {
					curFolder.create(true, true, null);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
			parent = curFolder;
		}		
	}
}
