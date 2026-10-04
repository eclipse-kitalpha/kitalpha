//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.doc.gen.business.ecore.extension.content.impl;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.doc.gen.business.core.util.EscapeChars;

public class EEnumHTMLContent {
	protected static String nl;

	public static synchronized EEnumHTMLContent create(String lineSeparator) {
		nl = lineSeparator;
		EEnumHTMLContent result = new EEnumHTMLContent();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = NL + "<p><strong>Default value :</strong> ";
	protected final String TEXT_2 = "</p>";
	protected final String TEXT_3 = NL + "<h2>Literals</h2>";
	protected final String TEXT_4 = NL;
	protected final String TEXT_5 = NL;

	public EEnumHTMLContent() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;
		Node.Container currentNode = ctx.getNode();

		paramDesc = new IQuery.ParameterDescription("parameter", "http://www.eclipse.org/emf/2002/Ecore#//EEnum");
		queryCtx = new HashMap<String, String>();
		List<Object> parameterList = QueryHelper
				.load(ctx, "org.polarsys.kitalpha.doc.gen.business.ecore.injected.context")
				.execute(paramDesc, queryCtx, ctx);

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.eclipse.emf.ecore.EEnum) parameterParameter;

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

		method_content(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.emf.ecore.EEnum parameter = null;

	public void set_parameter(org.eclipse.emf.ecore.EEnum object) {
		this.parameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_content(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		String outputFolder = ctx.getValue("outputFolder").toString();
		String projectName = ctx.getValue("projectName").toString();

		stringBuffer.append(TEXT_1);
		stringBuffer.append((parameter).getDefaultValue());
		stringBuffer.append(TEXT_2);

		String literalList = org.polarsys.kitalpha.doc.gen.business.ecore.helpers.EEnumContentHelper
				.getLiteralsList(parameter, projectName, outputFolder);
		if (literalList != "") {

			stringBuffer.append(TEXT_3);
			stringBuffer.append(TEXT_4);
			stringBuffer.append(literalList);
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "content", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}