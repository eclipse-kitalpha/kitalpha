//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.explorer.contextual.javaclasses;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.explorer.contextual.category.ContextualExplorerCategoryCompliance;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.explorer.contextual.util.ClassUtils;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.java.JDTUtility;

public class ParentJavaClass extends
		org.polarsys.kitalpha.ad.viewpoint.dsl.generation.explorer.contextual.common.LoopFinishedJavaClassForContextualExplorer {
	protected static String nl;

	public static synchronized ParentJavaClass create(String lineSeparator) {
		nl = lineSeparator;
		ParentJavaClass result = new ParentJavaClass();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "package ";
	protected final String TEXT_2 = ";" + NL + "" + NL + "import java.util.ArrayList;" + NL + "import java.util.List;"
			+ NL + "" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "" + NL
			+ "import org.eclipse.amalgam.explorer.contextual.core.query.IQuery;" + NL + "" + NL + "/**" + NL
			+ " * <!-- begin-user-doc -->" + NL + " * <!-- end-user-doc -->" + NL + " * <p>" + NL + " * </p>" + NL
			+ " *" + NL + " * @generated" + NL + " */" + NL + "public class ";
	protected final String TEXT_3 = " implements IQuery {" + NL + "" + NL + "/**" + NL + "   * <!-- begin-user-doc -->"
			+ NL + "   * <!-- end-user-doc -->" + NL + "   * Default constructor" + NL + "   * @generated" + NL
			+ "   */" + NL + "\tpublic ";
	protected final String TEXT_4 = "() {" + NL + "\t\t// TODO Auto-generated constructor stub" + NL + "\t}" + NL + ""
			+ NL + "   /**" + NL + "    * <!-- begin-user-doc -->" + NL + "    * <!-- end-user-doc -->" + NL
			+ "    * @param object_p: The model element for which the Contextual Explorer extension is generated" + NL
			+ "    * @return List of object to display in the parent category" + NL + "    * @generated" + NL + "    */"
			+ NL + "\tpublic List<Object> compute(Object object_p) {" + NL
			+ "\t\tList<Object> result = new ArrayList<Object>();" + NL + "\t\tEObject eObject = (EObject) object_p;"
			+ NL + "\t\tresult.add(eObject.eContainer());" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "}"
			+ NL;
	protected final String TEXT_5 = NL;

	public ParentJavaClass() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_5);
		stringBuffer.append(TEXT_5);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_genClass(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class parameter = null;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class object) {
		this.parameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_setParameters(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		classname = "ParentQuery";
		String vpClassName = ClassUtils.INSTANCE.getClassInterfaceName(parameter);
		projectname = ClassUtils.INSTANCE.getProjectName();
		packagename = JDTUtility.getValidPackageName(projectname + ".queries" + "." + vpClassName);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setParameters", stringBuffer.toString());
	}

	protected void method_genClass(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(packagename);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(classname);
		stringBuffer.append(TEXT_3);
		stringBuffer.append(classname);
		stringBuffer.append(TEXT_4);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genClass", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return ContextualExplorerCategoryCompliance.parentCategoryCompliance(parameter);
	}
}