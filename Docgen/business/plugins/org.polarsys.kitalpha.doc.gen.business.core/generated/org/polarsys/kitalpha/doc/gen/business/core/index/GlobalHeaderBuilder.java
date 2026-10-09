//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.doc.gen.business.core.index;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.doc.gen.business.core.branding.DocumentationBrandingData;
import org.polarsys.kitalpha.doc.gen.business.core.branding.DocumentationBrandingDataHelper;

public class GlobalHeaderBuilder extends org.polarsys.kitalpha.doc.gen.business.core.doccontent.ElementDocContent {
	protected static String nl;

	public static synchronized GlobalHeaderBuilder create(String lineSeparator) {
		nl = lineSeparator;
		GlobalHeaderBuilder result = new GlobalHeaderBuilder();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"" + NL
			+ "       \"http://www.w3.org/TR/html4/loose.dtd\">" + NL + "<html>" + NL + "<head>" + NL + "<title>";
	protected final String TEXT_2 = "</title>" + NL + "</head>";
	protected final String TEXT_3 = "</html>";
	protected final String TEXT_4 = NL + "<body style=\"background-color:#5C74A2; " + NL
			+ "\t  background-image:url('../img/heander_fndContenuGauche_small3.jpg'); " + NL
			+ "\t  background-repeat:repeat-x;\">" + NL + "" + NL + "\t<h1 style=\"width:50%; " + NL
			+ "\t\tfloat:left; " + NL + "\t\tcolor:#FFFFFF; " + NL + "\t\tmargin:15px; " + NL
			+ "\t\tfont-family: Arial, sans-serif; " + NL + "\t\tfont-size:25px\">" + NL + "\t\tList of models" + NL
			+ "\t</h1>" + NL + "\t<div style=\"float:right; " + NL + "\t\t position:relative; " + NL + "\t\t top:10px; "
			+ NL + "\t\t right:30px;\">" + NL + "\t\t <img style=\"height:45px;\" " + NL
			+ "\t\t\t  src=\"../img/logo.gif\" " + NL + "\t\t\t  alt=\"";
	protected final String TEXT_5 = "\"/> " + NL + "\t</div>" + NL + "</body>";
	protected final String TEXT_6 = NL;

	public GlobalHeaderBuilder() {
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

		stringBuffer.append(TEXT_6);
		stringBuffer.append(TEXT_6);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		return null;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_setContext(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		title = "Index";
		fileName = "header";

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setContext", stringBuffer.toString());
	}

	protected void method_docHeader(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(title);
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "docHeader", stringBuffer.toString());
	}

	protected void method_docFooter(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_3);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "docFooter", stringBuffer.toString());
	}

	protected void method_content(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		String projectName = ctx.getValue("projectName").toString();
		String outputFolder = ctx.getValue("outputFolder").toString();
		List<EObject> domain = (List<EObject>) ctx.getValue("domain");
		String logoAlt = (String) DocumentationBrandingData.getInstance().getData("logoAlt");
		String logoPath = (String) DocumentationBrandingData.getInstance().getData("logoPath");
		// Copier l'image dans le r�pertoire g�n�r� des images et la nommer logo.gif (../../img/logo.gif)
		if (logoPath.equals("Default") == false)
			DocumentationBrandingDataHelper.copyLogoFile(projectName, outputFolder, logoPath);

		stringBuffer.append(TEXT_4);
		stringBuffer.append(logoAlt);
		stringBuffer.append(TEXT_5);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "content", stringBuffer.toString());
	}

	protected void method_startContent(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "startContent", stringBuffer.toString());
	}

	protected void method_endContent(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "endContent", stringBuffer.toString());
	}
}