//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.doc.gen.business.core.index;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class GeneralIndexBuilder {
	protected static String nl;

	public static synchronized GeneralIndexBuilder create(String lineSeparator) {
		nl = lineSeparator;
		GeneralIndexBuilder result = new GeneralIndexBuilder();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL
			+ "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" " + NL
			+ "        \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + NL
			+ "<html xmlns=\"http://www.w3.org/1999/xhtml\">" + NL + "" + NL + "    <head>" + NL
			+ "\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/generalindex.css\" />" + NL + "    </head>"
			+ NL + "    " + NL + "    <body>" + NL + "    <ul class=\"generalIndex\">";
	protected final String TEXT_2 = NL + "\t\t<li>" + NL
			+ "\t\t\t<div style=\"float:left; margin-left:5px; font-size:12px; font-family:Arial\">" + NL
			+ "\t\t\t\t<a href=\"";
	protected final String TEXT_3 = "/index.html\" target=\"_top\">";
	protected final String TEXT_4 = "</a>" + NL + "\t\t\t</div>" + NL + "\t\t</li>";
	protected final String TEXT_5 = NL;
	protected final String TEXT_6 = "\t</ul>" + NL + "    </body>" + NL + "</html>";
	protected final String TEXT_7 = " ";
	protected final String TEXT_8 = NL;

	public GeneralIndexBuilder() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

		fileName = "index";

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

		stringBuffer.append(TEXT_8);
		stringBuffer.append(TEXT_8);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_setContextVariable(new StringBuffer(), ictx);

		method_htmlHeader(new StringBuffer(), ictx);

		method_content(new StringBuffer(), ictx);

		method_htmlFooter(new StringBuffer(), ictx);

		return null;
	}

	protected java.lang.String fileName = null;

	public void set_fileName(java.lang.String object) {
		this.fileName = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_htmlHeader(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "htmlHeader", stringBuffer.toString());
	}

	protected void method_content(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		List<String> domainList = (List<String>) ctx.getValue("domainList");
		for (String domain : domainList) {

			stringBuffer.append(TEXT_2);
			stringBuffer.append(domain);
			stringBuffer.append(TEXT_3);
			stringBuffer.append(domain);
			stringBuffer.append(TEXT_4);
		}
		stringBuffer.append(TEXT_5);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "content", stringBuffer.toString());
	}

	protected void method_htmlFooter(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_6);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "htmlFooter", stringBuffer.toString());
	}

	protected void method_setContextVariable(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		ctx.setValue("fileName", "modelindex");
		stringBuffer.append(TEXT_7);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setContextVariable", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}