//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.doc.gen.business.core.doccontent;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.doc.gen.business.core.branding.DocumentationBrandingData;

public class ElementDocContent extends org.polarsys.kitalpha.doc.gen.business.core.generic.ElementGen {
	protected static String nl;

	public static synchronized ElementDocContent create(String lineSeparator) {
		nl = lineSeparator;
		ElementDocContent result = new ElementDocContent();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL
			+ "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"" + NL
			+ "    \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">" + NL
			+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">" + NL + "" + NL + "\t<head>"
			+ NL + "\t\t<meta name=\"copyright\" content=\"";
	protected final String TEXT_2 = "\" />" + NL
			+ "\t\t<meta http-equiv=\"content-type\" content=\"text/html;charset=UTF-8\" />" + NL
			+ "\t\t<meta http-equiv=\"Content-Style-Type\" content=\"text/css\" />" + NL + "" + NL + "\t\t<title>";
	protected final String TEXT_3 = "</title>" + NL
			+ "\t\t<link rel=\"stylesheet\" href=\"../../scripts/jquery-treeview/jquery.treeview.css\" />" + NL
			+ "  \t\t<script src=\"../../scripts/jquery-treeview/lib/jquery-1.11.1.js\" type=\"text/javascript\"></script>"
			+ NL
			+ "  \t\t<script src=\"../../scripts/jquery-treeview/jquery.treeview.js\" type=\"text/javascript\"></script>"
			+ NL + "\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../css/simpletree.css\" />\t\t" + NL
			+ "\t\t<link title=\"default\" rel=\"stylesheet\" type=\"text/css\" media=\"screen, projection\" href=\"../../css/content.css\"></link>"
			+ NL + "\t\t" + NL + "\t\t<script type=\"text/javascript\">" + NL
			+ "if(parent.location.href == self.location.href) {" + NL + "window.location.href = 'index.html?";
	protected final String TEXT_4 = "';" + NL + "}" + NL + "</script>" + NL + "\t</head>" + NL + "\t" + NL + "\t<body>"
			+ NL + "\t";
	protected final String TEXT_5 = "\t</body>" + NL + "</html>" + NL;
	protected final String TEXT_6 = "<div id=\"content\">" + NL;
	protected final String TEXT_7 = " </div>";
	protected final String TEXT_8 = NL;

	public ElementDocContent() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

		title = "";
		copyright = (String) DocumentationBrandingData.getInstance().getData("copyright");
		fileName = "default";

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

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_setContext(new StringBuffer(), ictx);

		method_setReporterContext(new StringBuffer(), ictx);

		method_docHeader(new StringBuffer(), ictx);

		method_startContent(new StringBuffer(), ictx);

		method_preContentExtension(new StringBuffer(), ictx);

		method_content(new StringBuffer(), ictx);

		method_postContentExtension(new StringBuffer(), ictx);

		method_endContent(new StringBuffer(), ictx);

		method_docFooter(new StringBuffer(), ictx);

		return null;
	}

	protected java.lang.String title = null;

	public void set_title(java.lang.String object) {
		this.title = object;
	}

	protected java.lang.String copyright = null;

	public void set_copyright(java.lang.String object) {
		this.copyright = object;
	}

	protected java.lang.String fileName = null;

	public void set_fileName(java.lang.String object) {
		this.fileName = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_setReporterContext(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		ctx.setValue("fileName", fileName);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterContext", stringBuffer.toString());
	}

	protected void method_docHeader(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(copyright);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(title);
		stringBuffer.append(TEXT_3);
		stringBuffer.append(fileName);
		stringBuffer.append(TEXT_4);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "docHeader", stringBuffer.toString());
	}

	protected void method_docFooter(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_5);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "docFooter", stringBuffer.toString());
	}

	protected void method_setContext(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setContext", stringBuffer.toString());
	}

	protected void method_startContent(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_6);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "startContent", stringBuffer.toString());
	}

	protected void method_preContentExtension(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		org.polarsys.kitalpha.doc.gen.business.core.extension.intf.DocGenExtensionFactory.newDocGenExtensionEngine()
				.apply("PRE_CONTENT_EXTENSION", ctx, getParameters(), stringBuffer);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "preContentExtension", stringBuffer.toString());
	}

	protected void method_content(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "content", stringBuffer.toString());
	}

	protected void method_postContentExtension(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		org.polarsys.kitalpha.doc.gen.business.core.extension.intf.DocGenExtensionFactory.newDocGenExtensionEngine()
				.apply("POST_CONTENT_EXTENSION", ctx, getParameters(), stringBuffer);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "postContentExtension", stringBuffer.toString());
	}

	protected void method_endContent(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_7);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "endContent", stringBuffer.toString());
	}
}