//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.java.classes;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.helper.pde.PDEUtility;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.internal.StringHelper;

public class PagePredicateJavaClass extends
		org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.java.abstracts.AbstractPredicatedElementJavaClass {
	protected static String nl;

	public static synchronized PagePredicateJavaClass create(String lineSeparator) {
		nl = lineSeparator;
		PagePredicateJavaClass result = new PagePredicateJavaClass();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "/**" + NL + " * @generated " + NL + " */" + NL + "public class ";
	protected final String TEXT_2 = " implements IPredicate {" + NL + "\t/**" + NL + "\t * Default constructor" + NL
			+ "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
	protected final String TEXT_3 = "() {" + NL + "\t\t// TODO Auto-generated constructor stub" + NL + "\t}" + NL + ""
			+ NL + "\t/**" + NL + "\t * @generated " + NL + "\t */" + NL + "\t@Override" + NL
			+ "\tpublic boolean isOk() {";
	protected final String TEXT_4 = NL + "\t\treturn fileExtensionPredicate() && userPredicate();";
	protected final String TEXT_5 = " return ";
	protected final String TEXT_6 = " userPredicate(); ";
	protected final String TEXT_7 = " fileExtensionPredicate(); ";
	protected final String TEXT_8 = NL + "\t}" + NL;
	protected final String TEXT_9 = "\t" + NL + "\t/**" + NL + "\t * User predicate implementation" + NL
			+ "\t * @return True if OK, false otherwise." + NL + "\t * @generated" + NL + "\t */" + NL
			+ "\tprivate boolean userPredicate(){" + NL
			+ "\t\t// TODO: implement this method to provide the user predicate" + NL
			+ "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\treturn true;" + NL
			+ "\t}";
	protected final String TEXT_10 = "\t" + NL + "\t/**" + NL
			+ "\t * This method check if the extension of the resource file associated with the " + NL
			+ "\t * Sirius session is provided by viewpoint specifier." + NL + "\t * " + NL
			+ "\t * @return True if the current page can be used with the current resource. " + NL + "\t * @generated"
			+ NL + "\t */" + NL + "\tprotected boolean fileExtensionPredicate(){" + NL
			+ "\t\tfinal EObject rootSemanticModel = ActivityExplorerManager.INSTANCE.getRootSemanticModel();" + NL
			+ "\t\tfinal Resource eResource = rootSemanticModel.eResource();" + NL + "\t\tif (null == eResource)" + NL
			+ "\t\t\treturn false;" + NL + "\t\t" + NL + "\t\tfinal URI resourceURI = eResource.getURI();" + NL
			+ "\t\tif (null == resourceURI)" + NL + "\t\t\treturn false;" + NL + "\t\t" + NL
			+ "\t\tfinal List<String> allowedFileExtensions = Arrays.asList(";
	protected final String TEXT_11 = ");" + NL
			+ "\t\tfinal String fileExtension = resourceURI.fileExtension().toLowerCase();" + NL + "\t\t" + NL
			+ "\t\treturn allowedFileExtensions.contains(fileExtension);" + NL + "\t}";
	protected final String TEXT_12 = NL + "}";
	protected final String TEXT_13 = "import org.eclipse.amalgam.explorer.activity.ui.api.editor.predicates.IPredicate;"
			+ NL;
	protected final String TEXT_14 = NL + "import java.util.Arrays;" + NL + "import java.util.List;" + NL + "" + NL
			+ "import org.eclipse.amalgam.explorer.activity.ui.api.manager.ActivityExplorerManager;" + NL + "" + NL
			+ "import org.eclipse.emf.common.util.URI;" + NL + "import org.eclipse.emf.ecore.resource.Resource;" + NL
			+ "import org.eclipse.emf.ecore.EObject;";
	protected final String TEXT_15 = "\t";
	protected final String TEXT_16 = NL;

	public PagePredicateJavaClass() {
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

		stringBuffer.append(TEXT_16);
		stringBuffer.append(TEXT_16);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_initPredicateType(new StringBuffer(), ictx);
		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected java.lang.Boolean genUserPredicate = null;

	public void set_genUserPredicate(java.lang.Boolean object) {
		this.genUserPredicate = object;
	}

	protected java.lang.Boolean genFileExtensionPredicate = null;

	public void set_genFileExtensionPredicate(java.lang.Boolean object) {
		this.genFileExtensionPredicate = object;
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

	protected void method_setPredicatedElement(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		predicatedElement = parameter;
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setPredicatedElement", stringBuffer.toString());
	}

	protected void method_genClassCode(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(classname);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(classname);
		stringBuffer.append(TEXT_3);
		if (genUserPredicate && genFileExtensionPredicate) {
			stringBuffer.append(TEXT_4);
		} else {
			stringBuffer.append(TEXT_5);
			if (genUserPredicate) {
				stringBuffer.append(TEXT_6);
			}
			if (genFileExtensionPredicate) {
				stringBuffer.append(TEXT_7);
			}
		}
		stringBuffer.append(TEXT_8);
		if (genUserPredicate) {
			stringBuffer.append(TEXT_9);
		}
		String s_fileExtensions = parameter.getFileExtensions();
		final String[] extensions = s_fileExtensions.split(",");
		if (genFileExtensionPredicate) {
			stringBuffer.append(TEXT_10);
			stringBuffer.append(StringHelper.arrayToStriong(extensions));
			stringBuffer.append(TEXT_11);
		}
		stringBuffer.append(TEXT_12);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genClassCode", stringBuffer.toString());
	}

	protected void method_genImports(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_13);
		if (genFileExtensionPredicate) {
			stringBuffer.append(TEXT_14);
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genImports", stringBuffer.toString());
	}

	protected void method_initPredicateType(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		genUserPredicate = parameter.isHasPredicate();
		final String modelFileExtension = parameter.getFileExtensions();
		genFileExtensionPredicate = null != modelFileExtension && !modelFileExtension.isEmpty();
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initPredicateType", stringBuffer.toString());
	}

	protected void method_updateProjectDependecies(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		super.method_updateProjectDependecies(stringBuffer, ctx);
		// Add org.eclipse.emf.ecore
		if (genFileExtensionPredicate) {
			stringBuffer.append(TEXT_15);
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectname);
			PDEUtility.updateRequiredBundles(project, "org.eclipse.emf.ecore", new NullProgressMonitor());
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "updateProjectDependecies", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		final String modelFileExtension = parameter.getFileExtensions();
		return parameter.isHasPredicate() || (null != modelFileExtension && !modelFileExtension.isEmpty());
	}
}