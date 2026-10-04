//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.doc.gen.business.ecore.extension.content.impl;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.doc.gen.business.ecore.helpers.EcoreFileNameService;
import org.polarsys.kitalpha.doc.gen.business.core.util.EscapeChars;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.polarsys.kitalpha.doc.gen.business.core.util.SiriusHelper;
import org.polarsys.kitalpha.doc.gen.business.core.util.DefaultSiriusDiagramHelper;

public class EClassHTMLDescription {
	protected static String nl;

	public static synchronized EClassHTMLDescription create(String lineSeparator) {
		nl = lineSeparator;
		EClassHTMLDescription result = new EClassHTMLDescription();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<div style=\"position: absolute; top: 160px; left: 1%; z-index: 1; width: 98%;\">"
			+ NL + "<p><strong>Description :</strong><br />";
	protected final String TEXT_2 = "</p>" + NL + "<p><strong>Abstract: </strong><br />";
	protected final String TEXT_3 = "</p>" + NL;
	protected final String TEXT_4 = NL;
	protected final String TEXT_5 = NL;

	public EClassHTMLDescription() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;
		Node.Container currentNode = ctx.getNode();

		paramDesc = new IQuery.ParameterDescription("parameter", "http://www.eclipse.org/emf/2002/Ecore#//EClass");
		queryCtx = new HashMap<String, String>();
		List<Object> parameterList = QueryHelper
				.load(ctx, "org.polarsys.kitalpha.doc.gen.business.ecore.injected.context")
				.execute(paramDesc, queryCtx, ctx);

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.eclipse.emf.ecore.EClass) parameterParameter;

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

	protected org.eclipse.emf.ecore.EClass parameter = null;

	public void set_parameter(org.eclipse.emf.ecore.EClass object) {
		this.parameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_content(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(
				org.polarsys.kitalpha.doc.gen.business.ecore.helpers.EcoreModelHelper.getDescription(parameter));
		stringBuffer.append(TEXT_2);
		stringBuffer.append((parameter).isAbstract());
		stringBuffer.append(TEXT_3);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(
				org.polarsys.kitalpha.doc.gen.business.ecore.helpers.EcoreModelHelper.getUsageGuideline(parameter));
		stringBuffer.append(TEXT_4);
		stringBuffer.append(
				org.polarsys.kitalpha.doc.gen.business.ecore.helpers.EcoreModelHelper.getUsedInLevels(parameter));
		stringBuffer.append(TEXT_4);
		stringBuffer.append(
				org.polarsys.kitalpha.doc.gen.business.ecore.helpers.EcoreModelHelper.getUsageExamples(parameter));
		stringBuffer.append(TEXT_4);
		stringBuffer.append(
				org.polarsys.kitalpha.doc.gen.business.ecore.helpers.EcoreModelHelper.getConstraints(parameter));
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "content", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}