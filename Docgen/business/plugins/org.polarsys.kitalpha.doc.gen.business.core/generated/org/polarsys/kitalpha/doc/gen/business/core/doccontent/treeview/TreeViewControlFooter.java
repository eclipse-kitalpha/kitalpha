//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.doc.gen.business.core.doccontent.treeview;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class TreeViewControlFooter {
	protected static String nl;

	public static synchronized TreeViewControlFooter create(String lineSeparator) {
		nl = lineSeparator;
		TreeViewControlFooter result = new TreeViewControlFooter();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<script type=\"text/javascript\">" + NL + "\t$(\"#";
	protected final String TEXT_2 = "\").treeview({" + NL + "\t collapsed: ";
	protected final String TEXT_3 = "," + NL + "\t animated: \"fast\"," + NL + "\t unique: false," + NL
			+ "\t control: \"#treecontrol\"" + NL + "\t});" + NL + "</script>";
	protected final String TEXT_4 = NL;

	public TreeViewControlFooter() {
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
		List<Object> treeIDList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> collapsedList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {
			for (Object treeIDParameter : treeIDList) {
				for (Object collapsedParameter : collapsedList) {

					this.parameter = (org.eclipse.emf.ecore.EObject) parameterParameter;
					this.treeID = (java.lang.String) treeIDParameter;
					this.collapsed = (java.lang.Boolean) collapsedParameter;

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

		stringBuffer.append(TEXT_4);
		stringBuffer.append(TEXT_4);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_body(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			parameterValues.put("treeID", this.treeID);
			parameterValues.put("collapsed", this.collapsed);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.emf.ecore.EObject parameter = null;

	public void set_parameter(org.eclipse.emf.ecore.EObject object) {
		this.parameter = object;
	}

	protected java.lang.String treeID = null;

	public void set_treeID(java.lang.String object) {
		this.treeID = object;
	}

	protected java.lang.Boolean collapsed = null;

	public void set_collapsed(java.lang.Boolean object) {
		this.collapsed = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		parameters.put("treeID", this.treeID);
		parameters.put("collapsed", this.collapsed);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(treeID);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(collapsed);
		stringBuffer.append(TEXT_3);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}