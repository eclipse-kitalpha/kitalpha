//Generated with EGF 1.6.3.202110291409
package org.polarsys.kitalpha.doc.gen.ecore.extensions.impl;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;
import org.eclipse.emf.common.util.*;
import java.util.*;
import java.util.Map.Entry;

public class EAnnotationHTMLSection_JAVA {

	public EAnnotationHTMLSection_JAVA() {
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
		EClass eClass = (EClass) ctx.getValue(PatternContext.INJECTED_CONTEXT);
		EList<EAnnotation> eAnnotations = eClass.getEAnnotations();

		out.append("<h2>Class Annotations</h2>");
		for (EAnnotation eAnnotation : eAnnotations) {

			EMap<String, String> details = eAnnotation.getDetails();
			String source = eAnnotation.getSource();

			out.append("<b>Source: <i>").append(source).append("</i></b>");
			out.append("<table>");
			for (Entry<String, String> entry : details) {
				out.append("<tr>");
				out.append("<td>").append(entry.getKey()).append("</td><td>").append(entry.getValue()).append("</td>");
				out.append("</tr>");
			}
			out.append("</table>");
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "content", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		EObject tmp = ((EObject) ctx.getValue(PatternContext.INJECTED_CONTEXT));
		return (tmp instanceof EClass) && !((EClass) tmp).getEAnnotations().isEmpty();
	}

}
