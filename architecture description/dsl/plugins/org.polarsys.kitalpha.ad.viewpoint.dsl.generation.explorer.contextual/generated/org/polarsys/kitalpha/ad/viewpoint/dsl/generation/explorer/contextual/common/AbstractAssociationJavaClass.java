//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.explorer.contextual.common;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.java.JDTUtility;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.explorer.contextual.util.ClassUtils;

public class AbstractAssociationJavaClass extends
		org.polarsys.kitalpha.ad.viewpoint.dsl.generation.explorer.contextual.common.LoopFinishedJavaClassForContextualExplorer {
	protected static String nl;

	public static synchronized AbstractAssociationJavaClass create(String lineSeparator) {
		nl = lineSeparator;
		AbstractAssociationJavaClass result = new AbstractAssociationJavaClass();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "package ";
	protected final String TEXT_2 = ";";
	protected final String TEXT_3 = "import java.util.ArrayList;" + NL + "import java.util.List;" + NL + "" + NL
			+ "import org.eclipse.emf.ecore.EObject;" + NL + "" + NL
			+ "import org.eclipse.amalgam.explorer.contextual.core.query.IQuery; ";
	protected final String TEXT_4 = "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * <!-- end-user-doc -->" + NL
			+ " * <p>" + NL + " * </p>" + NL + " *" + NL + " * @generated" + NL + " */" + NL + "public class ";
	protected final String TEXT_5 = " implements IQuery {" + NL + "" + NL + "/**" + NL + "   * <!-- begin-user-doc -->"
			+ NL + "   * <!-- end-user-doc -->" + NL + "   * Default constructor" + NL + "   * @generated" + NL
			+ "   */" + NL + "\tpublic ";
	protected final String TEXT_6 = "() {" + NL + "\t\t// TODO Auto-generated constructor stub" + NL + "\t}";
	protected final String TEXT_7 = "}";
	protected final String TEXT_8 = NL;

	public AbstractAssociationJavaClass() {
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

		stringBuffer.append(TEXT_8);
		stringBuffer.append(TEXT_8);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_setJavaClassName(new StringBuffer(), ictx);

		method_setConcernedVPClass(new StringBuffer(), ictx);

		method_setLocalVariableValues(new StringBuffer(), ictx);
		super.orchestration(new SuperOrchestrationContext(ictx));

		method_genPackage(new StringBuffer(), ictx);

		method_genDefaultImport(new StringBuffer(), ictx);

		method_genSemanticImoprt(new StringBuffer(), ictx);

		method_getClassHeader(new StringBuffer(), ictx);

		method_genClassMethods(new StringBuffer(), ictx);

		method_genClassEnd(new StringBuffer(), ictx);

		return null;
	}

	protected java.lang.String vpClassName = null;

	public void set_vpClassName(java.lang.String object) {
		this.vpClassName = object;
	}

	protected java.lang.String vpClassInterfaceFullyQualifiedName = null;

	public void set_vpClassInterfaceFullyQualifiedName(java.lang.String object) {
		this.vpClassInterfaceFullyQualifiedName = object;
	}

	protected java.lang.String vpAssociationGetterName = null;

	public void set_vpAssociationGetterName(java.lang.String object) {
		this.vpAssociationGetterName = object;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class vpClass = null;

	public void set_vpClass(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class object) {
		this.vpClass = object;
	}

	protected java.lang.String javaClassName = null;

	public void set_javaClassName(java.lang.String object) {
		this.javaClassName = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_setJavaClassName(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setJavaClassName", stringBuffer.toString());
	}

	protected void method_setConcernedVPClass(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setConcernedVPClass", stringBuffer.toString());
	}

	protected void method_setLocalVariableValues(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		Assert.isNotNull(vpClass, "Class in null");
		vpClassName = ClassUtils.INSTANCE.getClassInterfaceName(vpClass);
		vpClassInterfaceFullyQualifiedName = ClassUtils.INSTANCE.getClassInterfaceFullyQualifiedName(vpClass);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setLocalVariableValues", stringBuffer.toString());
	}

	protected void method_setParameters(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		classname = javaClassName;
		projectname = ClassUtils.INSTANCE.getProjectName();
		packagename = JDTUtility.getValidPackageName(projectname + ".queries" + "." + vpClassName);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setParameters", stringBuffer.toString());
	}

	protected void method_genPackage(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(packagename);
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genPackage", stringBuffer.toString());
	}

	protected void method_genDefaultImport(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_3);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genDefaultImport", stringBuffer.toString());
	}

	protected void method_genSemanticImoprt(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genSemanticImoprt", stringBuffer.toString());
	}

	protected void method_getClassHeader(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_4);
		stringBuffer.append(classname);
		stringBuffer.append(TEXT_5);
		stringBuffer.append(classname);
		stringBuffer.append(TEXT_6);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getClassHeader", stringBuffer.toString());
	}

	protected void method_genClassMethods(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		// To be implemented in patterns that inherits from this pattern
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genClassMethods", stringBuffer.toString());
	}

	protected void method_genClassEnd(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_7);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genClassEnd", stringBuffer.toString());
	}
}