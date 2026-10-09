//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.java.abstracts;

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

public class AbstractPredicatedElementJavaClass extends
		org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.java.abstracts.AbstractActivityExplorerJavaClass {
	protected static String nl;

	public static synchronized AbstractPredicatedElementJavaClass create(String lineSeparator) {
		nl = lineSeparator;
		AbstractPredicatedElementJavaClass result = new AbstractPredicatedElementJavaClass();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = " ";
	protected final String TEXT_2 = "import org.eclipse.amalgam.explorer.activity.ui.api.editor.predicates.IPredicate;"
			+ NL;
	protected final String TEXT_3 = "/**" + NL + " * @generated " + NL + " */" + NL + "public class ";
	protected final String TEXT_4 = " implements IPredicate {" + NL + "\t/**" + NL + "\t * Default constructor" + NL
			+ "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
	protected final String TEXT_5 = "() {" + NL + "\t\t// TODO: Auto-generated constructor stub" + NL + "\t}" + NL + ""
			+ NL + "\t/**" + NL + "\t * The predicate implementation" + NL + "\t * @return True if OK, false otherwise."
			+ NL + "\t * @generated " + NL + "\t */" + NL + "\t@Override" + NL + "\tpublic boolean isOk() {" + NL
			+ "\t\t// TODO: implement this method to provide the predicate" + NL
			+ "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\treturn true;" + NL
			+ "\t}" + NL + "}" + NL;
	protected final String TEXT_6 = NL;

	public AbstractPredicatedElementJavaClass() {
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

		if (preCondition(ctx)) {
			ctx.setNode(new Node.Container(currentNode, getClass()));
			orchestration(ctx);
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

		method_setPredicatedElement(new StringBuffer(), ictx);
		super.orchestration(new SuperOrchestrationContext(ictx));

		method_updateProjectDependecies(new StringBuffer(), ictx);

		return null;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.PredicateElement predicatedElement = null;

	public void set_predicatedElement(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.PredicateElement object) {
		this.predicatedElement = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_setPredicatedElement(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setPredicatedElement", stringBuffer.toString());
	}

	protected void method_setParameters(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		// Set the parameters values
		NamedElement namedParameter = (NamedElement) predicatedElement;
		classname = JavaNamingConvention.getJavaClassNameFor(namedParameter,
				JavaNamingConvention.JavaUseContext.Predicate);
		projectname = (String) ctx.getValue("activity.explorer.project.name");
		packagename = JavaNamingConvention.getJavaPackageNameFor(projectname,
				JavaNamingConvention.JavaUseContext.Predicate);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setParameters", stringBuffer.toString());
	}

	protected void method_genImports(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genImports", stringBuffer.toString());
	}

	protected void method_genClassCode(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_3);
		stringBuffer.append(classname);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(classname);
		stringBuffer.append(TEXT_5);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genClassCode", stringBuffer.toString());
	}

	protected void method_updateProjectDependecies(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectname);
		PDEUtility.updateRequiredBundles(project, "org.eclipse.amalgam.explorer.activity.ui",
				new NullProgressMonitor());
		PDEUtility.updateRequiredBundles(project, "org.eclipse.ui", new NullProgressMonitor());
		PDEUtility.updateRequiredBundles(project, "org.eclipse.core.runtime", new NullProgressMonitor());
		PDEUtility.updateRequiredBundles(project, "org.eclipse.amalgam.explorer.activity.ui",
				new NullProgressMonitor());
		PDEUtility.updateRequiredBundles(project, "org.eclipse.emf.ecore", new NullProgressMonitor());
		PDEUtility.updateRequiredBundles(project, "org.eclipse.sirius", new NullProgressMonitor());
		PDEUtility.updateRequiredBundles(project, "org.eclipse.ui.forms", new NullProgressMonitor());
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "updateProjectDependecies", stringBuffer.toString());
	}
}