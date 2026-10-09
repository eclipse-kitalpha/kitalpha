//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.emde.egf;

import org.polarsys.kitalpha.emde.egf.utils.*;
import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class HeaderProperties extends org.eclipse.egf.emf.pattern.base.HeaderProperties {
	protected static String nl;

	public static synchronized HeaderProperties create(String lineSeparator) {
		nl = lineSeparator;
		HeaderProperties result = new HeaderProperties();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "#" + NL + "# ";
	protected final String TEXT_2 = NL + "#";
	protected final String TEXT_3 = NL;
	protected final String TEXT_4 = NL;

	public HeaderProperties() {
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

		List<Object> argumentList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object argumentParameter : argumentList) {

			this.argument = (java.lang.Object) argumentParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_4);
		stringBuffer.append(TEXT_4);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("argument", this.argument);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("argument", this.argument);
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		{
			GenBase copyrightHolder = argument instanceof GenBase ? (GenBase) argument
					: argument instanceof Object[] && ((Object[]) argument)[0] instanceof GenBase
							? (GenBase) ((Object[]) argument)[0]
							: null;
			if (copyrightHolder != null && copyrightHolder.hasCopyright()) {
				stringBuffer.append(TEXT_1);
				stringBuffer.append(
						copyrightHolder.getCopyright(copyrightHolder.getGenModel().getIndentation(stringBuffer)));
				stringBuffer.append(TEXT_2);
			}
		}
		stringBuffer.append(TEXT_3);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}
}