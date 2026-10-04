//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.doc.gen.business.core.doccontent.sidebar;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class ElementSideBarHeader extends org.polarsys.kitalpha.doc.gen.business.core.generic.ElementGen {
	protected static String nl;

	public static synchronized ElementSideBarHeader create(String lineSeparator) {
		nl = lineSeparator;
		ElementSideBarHeader result = new ElementSideBarHeader();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL
			+ "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" " + NL
			+ "        \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + NL + "        " + NL
			+ "<html xmlns=\"http://www.w3.org/1999/xhtml\">" + NL + "" + NL + "    <head>" + NL
			+ "\t\t<link rel=\"stylesheet\" href=\"../../scripts/jquery-treeview/jquery.treeview.css\" />" + NL
			+ "  \t\t<script src=\"../../scripts/jquery-treeview/lib/jquery-1.11.1.js\" type=\"text/javascript\"></script>"
			+ NL
			+ "  \t\t<script src=\"../../scripts/jquery-treeview/jquery.treeview.js\" type=\"text/javascript\"></script>"
			+ NL + "\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../css/simpletree.css\" />" + NL
			+ "\t\t<meta http-equiv=\"content-type\" content=\"text/html;charset=UTF-8\" />" + NL + "    </head>" + NL
			+ "    " + NL + "    <body style=\"padding:0px; margin:0px;\">" + NL + "\t\t<div style=\"height:30px;\">"
			+ NL + "\t\t\t<div style=\"padding:3px;position:fixed;background-color:#DDE0E3; width:100%;\">" + NL
			+ "\t\t\t\t<div id=\"treecontrol\" style=\"float:left\">" + NL + "\t\t\t\t\t<a href=\"#\">" + NL
			+ "\t\t\t\t\t\t<img src=\"../../img/open.gif\" alt=\"Collapse All\" style=\"border:0px\"/>" + NL
			+ "\t\t\t\t\t</a> " + NL + "\t\t\t\t\t<a href=\"#\">" + NL
			+ "\t\t\t\t\t\t<img src=\"../../img/closed.gif\" alt=\"Expand All\" style=\"border:0px\"/>" + NL
			+ "\t\t\t\t\t</a>" + NL + "\t\t\t\t</div> " + NL
			+ "\t\t\t\t<div style=\"float:right; margin-right:5px; font-size:12px; font-family:Arial\">" + NL
			+ "\t\t\t\t\t<a href=\"searchIndex.html\">Search Index</a> | <a href=\"../modelindex.html\" >Back to Index</a>"
			+ NL + "\t\t\t\t</div>" + NL + "\t\t\t</div>" + NL + "\t\t</div>" + NL
			+ "\t\t<ul id=\"treemenu1\" class=\"treeview\">";
	protected final String TEXT_2 = NL;

	public ElementSideBarHeader() {
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

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.eclipse.emf.ecore.EObject) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(TEXT_2);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_body(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
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

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return parameter.eContainer() == null;
	}
}