//Generated with EGF 1.6.3.202110291409
package org.polarsys.kitalpha.doc.gen.ecore.extensions.impl;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

public class ReplaceFocusDiagram {

	public ReplaceFocusDiagram() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();

		if (preCondition(ctx))
			orchestration((PatternContext) argument);

		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		method_content(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		return null;
	}

	protected void method_content(final StringBuffer out, final PatternContext ctx) throws Exception {
		out.append("<h1 align=\"center\" bgcolor=\"#3311FF\">Focus Diagram Was here</h1>");

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "content", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return ctx.getValue(PatternContext.INJECTED_CONTEXT) instanceof EClass;
	}

}
