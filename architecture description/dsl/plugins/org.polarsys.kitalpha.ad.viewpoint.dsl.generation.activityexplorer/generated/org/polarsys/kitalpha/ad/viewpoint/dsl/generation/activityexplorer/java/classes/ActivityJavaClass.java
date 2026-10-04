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

public class ActivityJavaClass extends
		org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.java.abstracts.AbstractActivityExplorerJavaClass {
	protected static String nl;

	public static synchronized ActivityJavaClass create(String lineSeparator) {
		nl = lineSeparator;
		ActivityJavaClass result = new ActivityJavaClass();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "import org.eclipse.amalgam.explorer.activity.ui.api.hyperlinkadapter.AbstractHyperlinkAdapter;"
			+ NL + "import org.eclipse.amalgam.explorer.activity.ui.api.manager.ActivityExplorerManager;" + NL
			+ "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.jface.dialogs.MessageDialog;" + NL
			+ "import org.eclipse.sirius.business.api.session.Session;" + NL + "import org.eclipse.swt.widgets.Shell;"
			+ NL + "import org.eclipse.ui.PlatformUI;" + NL + "import org.eclipse.ui.forms.events.HyperlinkEvent;" + NL
			+ NL;
	protected final String TEXT_2 = NL + "public class ";
	protected final String TEXT_3 = " extends AbstractHyperlinkAdapter {" + NL + "\t" + NL + "\t/**" + NL
			+ "\t * Default constructor" + NL + "\t */" + NL + "\tpublic ";
	protected final String TEXT_4 = "() {" + NL + "\t\tsuper(ActivityExplorerManager.INSTANCE.getRootSemanticModel());"
			+ NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Constructor with parameters" + NL
			+ "\t * @param root the root model element ({@link EObject})" + NL
			+ "\t * @param session the associated {@link Session} with the activity explorer" + NL + "\t */" + NL
			+ "\tpublic ";
	protected final String TEXT_5 = "(EObject root) {" + NL + "\t\tsuper(root);" + NL + "\t}" + NL + "" + NL + "\t\t/*"
			+ NL + "\t * (non-Javadoc)" + NL
			+ "\t * @see org.eclipse.amalgam.explorer.activity.ui.api.hyperlinkadapter.AbstractHyperlinkAdapter#linkPressed(org.eclipse.ui.forms.events.HyperlinkEvent, org.eclipse.emf.ecore.EObject, org.eclipse.sirius.business.api.session.Session)"
			+ NL + "\t */" + NL + "\t@Override" + NL
			+ "\tprotected void linkPressed(HyperlinkEvent event, EObject project_p, Session session) {" + NL
			+ "\t\tShell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();" + NL
			+ "\t\tMessageDialog.openInformation(shell, \"Activity Explorer - ";
	protected final String TEXT_6 = "\", " + NL + "\t\t\t\t\t\t\t\t\t  \"Default implementation for ";
	protected final String TEXT_7 = ".\\n ";
	protected final String TEXT_8 = ".";
	protected final String TEXT_9 = ".java\");" + NL + "\t}" + NL + "}" + NL;
	protected final String TEXT_10 = NL + " ";
	protected final String TEXT_11 = NL;

	public ActivityJavaClass() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Activity) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_11);
		stringBuffer.append(TEXT_11);
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

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Activity parameter = null;

	public void set_parameter(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Activity object) {
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
		classname = JavaNamingConvention.getJavaClassNameFor(namedParameter,
				JavaNamingConvention.JavaUseContext.Activity);
		projectname = (String) ctx.getValue("activity.explorer.project.name");
		packagename = JavaNamingConvention.getJavaPackageNameFor(projectname,
				JavaNamingConvention.JavaUseContext.Activity);
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
		stringBuffer.append(classname);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(classname);
		stringBuffer.append(TEXT_5);
		stringBuffer.append(parameter.getName());
		stringBuffer.append(TEXT_6);
		stringBuffer.append(parameter.getName());
		stringBuffer.append(TEXT_7);
		stringBuffer.append(packagename);
		stringBuffer.append(TEXT_8);
		stringBuffer.append(classname);
		stringBuffer.append(TEXT_9);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genClassCode", stringBuffer.toString());
	}

	protected void method_updateProjectDependecies(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectname);
		PDEUtility.updateRequiredBundles(project, "org.eclipse.ui.forms", new NullProgressMonitor());
		PDEUtility.updateRequiredBundles(project, "org.eclipse.ui", new NullProgressMonitor());
		PDEUtility.updateRequiredBundles(project, "org.eclipse.core.runtime", new NullProgressMonitor());
		PDEUtility.updateRequiredBundles(project, "org.eclipse.amalgam.explorer.activity.ui",
				new NullProgressMonitor());
		PDEUtility.updateRequiredBundles(project, "org.eclipse.emf.ecore", new NullProgressMonitor());
		PDEUtility.updateRequiredBundles(project, "org.eclipse.sirius", new NullProgressMonitor());
		PDEUtility.updateRequiredBundles(project, "org.eclipse.ui.forms", new NullProgressMonitor());
		stringBuffer.append(TEXT_10);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "updateProjectDependecies", stringBuffer.toString());
	}
}