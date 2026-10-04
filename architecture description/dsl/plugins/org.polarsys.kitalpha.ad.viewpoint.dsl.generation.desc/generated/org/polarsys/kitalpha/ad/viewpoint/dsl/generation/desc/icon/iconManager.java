//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.icon;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.eclipse.emf.common.util.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.provider.resourceimpl.ViewpointResourceProviderRegistry;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.provider.resourceimpl.GenmodelProviderImpl;

import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.*;
import org.eclipse.ui.actions.*;
import java.lang.reflect.InvocationTargetException;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.log.ViewpointDslLogger;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.internal.icons.GenerateIconPrecondition;

public class iconManager {

	public iconManager() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration((PatternContext) argument);

			}
		}
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		method_setEditProject(new StringBuffer(), ictx);
		method_setVpdslProject(new StringBuffer(), ictx);
		method_setIconName(new StringBuffer(), ictx);
		method_setEditIconFolder(new StringBuffer(), ictx);
		method_setEditIconName(new StringBuffer(), ictx);
		method_CopyIconToEdit(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_setVpdslProject(final StringBuffer out, final PatternContext ctx) throws Exception {
		URI uri = parameter.eResource().getURI();

		if (uri == null)
			return;

		String vpdslProjectName = uri.segment(1);

		vpdslProject = ResourcesPlugin.getWorkspace().getRoot().getProject(vpdslProjectName);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setVpdslProject", out.toString());
	}

	protected void method_setEditProject(final StringBuffer out, final PatternContext ctx) throws Exception {
		GenmodelProviderImpl genmodelProvider = ViewpointResourceProviderRegistry.getInstance().getGenmodelProvider();

		if (genmodelProvider != null) {
			String editProjectName = genmodelProvider.getEditPluginName();
			editProject = ResourcesPlugin.getWorkspace().getRoot().getProject(editProjectName);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setEditProject", out.toString());
	}

	protected void method_setIconName(final StringBuffer out, final PatternContext ctx) throws Exception {
		iconName = parameter.getIcon();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setIconName", out.toString());
	}

	protected void method_CopyIconToEdit(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (editProject != null && editProject.exists()) {
			WorkspaceModifyOperation wo = new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor monitor)
						throws CoreException, InvocationTargetException, InterruptedException {

					IFolder vpIconFolder = vpdslProject.getFolder("icons");

					IFile vpIconFile = vpIconFolder.getFile(iconName);

					if (vpIconFile.exists()) {
						IFile editIconFile = editProject.getFile(editIconFolder + "/" + editIconName + ".gif");

						if (editIconFile.exists())
							editIconFile.setContents(vpIconFile.getContents(), IFile.REPLACE, null);
					} else {
						ViewpointDslLogger.doLogWarning("Unable to find the icon : " + iconName);
					}
				}
			};

			wo.run(null);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "CopyIconToEdit", out.toString());
	}

	protected void method_setEditIconName(final StringBuffer out, final PatternContext ctx) throws Exception {
		/*
		The newIconName depends on the nature of the currentObject
		 If currentObject is a Class then
		 	newIconName = Class.getName()
		 
		 If currentObject is a AbstractAssociation then 
		 	 "Create" + parentClass.getName() + "_" + AbstractFeature.getName() + "_" + (Local/ExternalTarget).getName() + ".gif";
		 */

		editIconName = parameter.getName();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setEditIconName", out.toString());
	}

	protected void method_setEditIconFolder(final StringBuffer out, final PatternContext ctx) throws Exception {
		editIconFolder = "icons/full/obj16";

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setEditIconFolder", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return GenerateIconPrecondition.generateIcon() && parameter.getIcon() != null
				&& parameter.getIcon().trim().length() > 0;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class parameter) {
		this.parameter = parameter;
	}

	protected org.eclipse.core.resources.IProject vpdslProject;

	public void set_vpdslProject(org.eclipse.core.resources.IProject vpdslProject) {
		this.vpdslProject = vpdslProject;
	}

	protected java.lang.String iconName;

	public void set_iconName(java.lang.String iconName) {
		this.iconName = iconName;
	}

	protected java.lang.String editIconName;

	public void set_editIconName(java.lang.String editIconName) {
		this.editIconName = editIconName;
	}

	protected java.lang.String editIconFolder;

	public void set_editIconFolder(java.lang.String editIconFolder) {
		this.editIconFolder = editIconFolder;
	}

	protected org.eclipse.core.resources.IProject editProject;

	public void set_editProject(org.eclipse.core.resources.IProject editProject) {
		this.editProject = editProject;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
