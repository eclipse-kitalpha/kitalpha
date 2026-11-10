//Generated with EGF 1.6.3.202110291409
package org.polarsys.kitalpha.doc.gen.ecore.extensions.impl;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.doc.gen.business.ecore.helpers.EcoreFileNameService;
import org.polarsys.kitalpha.doc.gen.business.core.util.EscapeChars;
import org.polarsys.kitalpha.doc.gen.business.core.util.LabelProviderHelper;

public class EDatatypeHTMLSection_JET {
	protected static String nl;

	public static synchronized EDatatypeHTMLSection_JET create(String lineSeparator) {
		nl = lineSeparator;
		EDatatypeHTMLSection_JET result = new EDatatypeHTMLSection_JET();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "<h2>EDataType</h2>";
	protected final String TEXT_3 = NL;
	protected final String TEXT_4 = NL + "<br/>" + NL + "<ul>" + NL + "\t<li>Name : ";
	protected final String TEXT_5 = "</li>" + NL + "\t<li>Instance Class: ";
	protected final String TEXT_6 = "</li>" + NL + "</ul>";

	public EDatatypeHTMLSection_JET() {
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

		stringBuffer.append(TEXT_3);
		stringBuffer.append(TEXT_3);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_content(new StringBuffer(), ictx);

		return null;
	}

	protected org.eclipse.emf.ecore.EDataType element = null;

	public void set_element(org.eclipse.emf.ecore.EDataType object) {
		this.element = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_content(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		element = (EDataType) ctx.getValue(PatternContext.INJECTED_CONTEXT);
		String text = LabelProviderHelper.getText(element);

		stringBuffer.append(TEXT_1);
		if (text != null && !text.isEmpty()) {
			stringBuffer.append(TEXT_2);
			stringBuffer.append(TEXT_3);
			stringBuffer.append(text);
			stringBuffer.append(TEXT_4);
			stringBuffer.append(element.getName());
			stringBuffer.append(TEXT_5);
			stringBuffer.append(element.getInstanceClass().getCanonicalName());
			stringBuffer.append(TEXT_6);
		}
		stringBuffer.append(TEXT_3);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "content", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return ctx.getValue(PatternContext.INJECTED_CONTEXT) instanceof EDataType
				&& !(ctx.getValue(PatternContext.INJECTED_CONTEXT) instanceof EEnum);
	}
}