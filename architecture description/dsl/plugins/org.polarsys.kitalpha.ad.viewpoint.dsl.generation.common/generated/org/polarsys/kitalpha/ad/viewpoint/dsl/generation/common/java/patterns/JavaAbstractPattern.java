//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.java.patterns;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import java.text.SimpleDateFormat;

public class JavaAbstractPattern {
	protected static String nl;

	public static synchronized JavaAbstractPattern create(String lineSeparator) {
		nl = lineSeparator;
		JavaAbstractPattern result = new JavaAbstractPattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = " ";
	protected final String TEXT_2 = NL + "// Generated on ";
	protected final String TEXT_3 = " by Viewpoint DSL Generator V 0.1" + NL;
	protected final String TEXT_4 = NL + NL;
	protected final String TEXT_5 = NL;

	public JavaAbstractPattern() {
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

		stringBuffer.append(TEXT_5);
		stringBuffer.append(TEXT_5);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_setParameters(new StringBuffer(), ictx);

		method_TransformsfirstLetterToUpperCase(new StringBuffer(), ictx);

		method_setReporterParameters(new StringBuffer(), ictx);

		method_setCopyright(new StringBuffer(), ictx);

		method_genClassHeaderComment(new StringBuffer(), ictx);

		return null;
	}

	protected java.lang.String copyright = null;

	public void set_copyright(java.lang.String object) {
		this.copyright = object;
	}

	protected java.lang.String projectname = null;

	public void set_projectname(java.lang.String object) {
		this.projectname = object;
	}

	protected java.lang.String packagename = null;

	public void set_packagename(java.lang.String object) {
		this.packagename = object;
	}

	protected java.lang.String classname = null;

	public void set_classname(java.lang.String object) {
		this.classname = object;
	}

	protected java.lang.Integer savetime = null;

	public void set_savetime(java.lang.Integer object) {
		this.savetime = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_setParameters(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		// To implement in sub patterns
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setParameters", stringBuffer.toString());
	}

	protected void method_setReporterParameters(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		// Do not change in sub pattern
		ctx.setValue("projectname", projectname);
		ctx.setValue("packagename", packagename);
		ctx.setValue("classname", classname);
		ctx.setValue("savetime", savetime);

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterParameters", stringBuffer.toString());
	}

	protected void method_TransformsfirstLetterToUpperCase(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		char first = Character.toUpperCase(classname.charAt(0));
		classname = first + classname.substring(1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "TransformsfirstLetterToUpperCase", stringBuffer.toString());
	}

	protected void method_setCopyright(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setCopyright", stringBuffer.toString());
	}

	protected void method_genClassHeaderComment(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy 'at' hh:mm:ss z");
		String genTime = sdf.format(cal.getTime());

		stringBuffer.append(TEXT_2);
		stringBuffer.append(genTime);
		stringBuffer.append(TEXT_3);
		if (copyright != null && copyright.trim().length() > 0) {
			stringBuffer.append(copyright);
		}
		stringBuffer.append(TEXT_4);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genClassHeaderComment", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}