//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.doc.gen.business.core.generic;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.doc.gen.business.core.util.*;

public class ElementGenerateByPropterty
		extends org.polarsys.kitalpha.doc.gen.business.core.generic.AbstractElementDescription {
	protected static String nl;

	public static synchronized ElementGenerateByPropterty create(String lineSeparator) {
		nl = lineSeparator;
		ElementGenerateByPropterty result = new ElementGenerateByPropterty();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "\t" + NL + NL;
	protected final String TEXT_3 = NL + "<h2>";
	protected final String TEXT_4 = "</h2>" + NL + "<p>";
	protected final String TEXT_5 = "</p>";
	protected final String TEXT_6 = NL;

	public ElementGenerateByPropterty() {
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

		List<Object> propertyList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> titleList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> eObjectList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object propertyParameter : propertyList) {
			for (Object titleParameter : titleList) {
				for (Object eObjectParameter : eObjectList) {

					this.property = (java.lang.String) propertyParameter;
					this.title = (java.lang.String) titleParameter;
					this.eObject = (org.eclipse.emf.ecore.EObject) eObjectParameter;

					if (preCondition(ctx)) {
						ctx.setNode(new Node.Container(currentNode, getClass()));
						orchestration(ctx);
					}

				}
			}
		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_6);
		stringBuffer.append(TEXT_6);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("property", this.property);
			parameterValues.put("title", this.title);
			parameterValues.put("eObject", this.eObject);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected java.lang.String property = null;

	public void set_property(java.lang.String object) {
		this.property = object;
	}

	protected java.lang.String title = null;

	public void set_title(java.lang.String object) {
		this.title = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("property", this.property);
		parameters.put("title", this.title);
		parameters.put("eObject", this.eObject);
		return parameters;
	}

	protected void method_generateDescription(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		EClass eClass = eObject.eClass();
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(property);
		if (eStructuralFeature != null) {
			Object value = eObject.eGet(eStructuralFeature);
			String description = null;
			if (value != null && value.toString().length() > 0) {
				description = value.toString();
			} else {
				description = "No " + property;
			}
			stringBuffer.append(TEXT_1);
			stringBuffer.append(EscapeChars.replaceSpecialCharacters(description));
		}
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "generateDescription", stringBuffer.toString());
	}

	protected void method_openDescription(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		String string = "";
		if (title == null) {
			string = Character.toString(property.charAt(0)).toUpperCase() + property.substring(1);
		}
		stringBuffer.append(TEXT_3);
		stringBuffer.append(string);
		stringBuffer.append(TEXT_4);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "openDescription", stringBuffer.toString());
	}

	protected void method_closeDescription(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_5);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "closeDescription", stringBuffer.toString());
	}
}