//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.java.classes;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.NamedElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.java.JDTUtility;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.helper.pde.PDEUtility;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.internal.JavaNamingConvention;

public class PageJavaClass extends
		org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.java.abstracts.AbstractActivityExplorerJavaClass {
	protected static String nl;

	public static synchronized PageJavaClass create(String lineSeparator) {
		nl = lineSeparator;
		PageJavaClass result = new PageJavaClass();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "import org.polarsys.kitalpha.ad.integration.amalgam.pages.ADActivityExplorerPage;"
			+ NL + NL + NL;
	protected final String TEXT_2 = NL + "public class ";
	protected final String TEXT_3 = " extends ADActivityExplorerPage  {" + NL + "" + NL
			+ "\tprotected String getViewpointID(){" + NL + "\t\treturn \t\"";
	protected final String TEXT_4 = "\"; //$NON-NLS-1$" + NL + "\t}" + NL + "" + NL + "}" + NL;
	protected final String TEXT_5 = NL + NL;
	protected final String TEXT_6 = NL;

	public PageJavaClass() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

		// add initialisation of the pattern variables (declaration has been already done).

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;
		Node.Container currentNode = ctx.getNode();

		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Page) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_6);
		stringBuffer.append(TEXT_6);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_updateProjectDependecies(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Page parameter = null;

	public void set_parameter(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Page object) {
		this.parameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_setParameters(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		// Set the parameters values
		NamedElement namedParameter = (NamedElement) parameter;
		classname = JavaNamingConvention.getJavaClassNameFor(namedParameter, JavaNamingConvention.JavaUseContext.Page);
		projectname = (String) ctx.getValue("activity.explorer.project.name");
		packagename = JavaNamingConvention.getJavaPackageNameFor(projectname, JavaNamingConvention.JavaUseContext.Page);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setParameters", stringBuffer.toString());
	}

	protected void method_genImports(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genImports", stringBuffer.toString());
	}

	protected void method_genClassCode(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_2);
		stringBuffer.append(classname);
		stringBuffer.append(TEXT_3);
		stringBuffer.append(org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.helper.configuration.VpDslConfigurationHelper
				.getRootProjectName(parameter));
		stringBuffer.append(TEXT_4);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genClassCode", stringBuffer.toString());
	}

	protected void method_updateProjectDependecies(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectname);
		NullProgressMonitor npm = new NullProgressMonitor();
		PDEUtility.updateRequiredBundles(project, "org.eclipse.ui.forms", npm);
		PDEUtility.updateRequiredBundles(project, "org.eclipse.ui", npm);
		PDEUtility.updateRequiredBundles(project, "org.eclipse.amalgam.explorer.activity.ui", npm);
		PDEUtility.updateRequiredBundles(project, "org.polarsys.kitalpha.ad.integration.amalgam", npm);
		PDEUtility.updateRequiredBundles(project, "org.eclipse.core.runtime", npm);
		stringBuffer.append(TEXT_5);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "updateProjectDependecies", stringBuffer.toString());
	}
}