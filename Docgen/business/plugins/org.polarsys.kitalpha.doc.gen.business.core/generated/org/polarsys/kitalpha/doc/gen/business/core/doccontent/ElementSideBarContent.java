//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.doc.gen.business.core.doccontent;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.doc.gen.business.core.util.*;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class ElementSideBarContent extends org.polarsys.kitalpha.doc.gen.business.core.generic.ElementGen {
	protected static String nl;

	public static synchronized ElementSideBarContent create(String lineSeparator) {
		nl = lineSeparator;
		ElementSideBarContent result = new ElementSideBarContent();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = " ";
	protected final String TEXT_2 = NL + "<li ";
	protected final String TEXT_3 = "id=\"";
	protected final String TEXT_4 = "\" ";
	protected final String TEXT_5 = ">" + NL;
	protected final String TEXT_6 = NL;
	protected final String TEXT_7 = NL + "<img src=\"../icon/";
	protected final String TEXT_8 = "\" alt=\"";
	protected final String TEXT_9 = "\"/> <a href=\"../";
	protected final String TEXT_10 = "/";
	protected final String TEXT_11 = ".html\" target=\"content\">";
	protected final String TEXT_12 = "</a>" + NL + NL;
	protected final String TEXT_13 = "</li>" + NL;
	protected final String TEXT_14 = NL + NL;
	protected final String TEXT_15 = NL;

	public ElementSideBarContent() {
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

		stringBuffer.append(TEXT_15);
		stringBuffer.append(TEXT_15);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_setCurrentObject(new StringBuffer(), ictx);

		method_startSidebarElement(new StringBuffer(), ictx);

		method_contentSidebarElement(new StringBuffer(), ictx);

		method_startSidebarSubElement(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = getParameters();
			CallbackContext ctx_callback = new CallbackContext(ictx);
			CallHelper.callBack(ctx_callback, parameters);
		}

		method_endSidebarSubElement(new StringBuffer(), ictx);

		method_endSidebarElement(new StringBuffer(), ictx);

		method_indexing(new StringBuffer(), ictx);

		return null;
	}

	protected org.eclipse.emf.ecore.EObject currentObject = null;

	public void set_currentObject(org.eclipse.emf.ecore.EObject object) {
		this.currentObject = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_setCurrentObject(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setCurrentObject", stringBuffer.toString());
	}

	protected void method_startSidebarElement(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		String id = EcoreUtil.getID(currentObject);
		stringBuffer.append(TEXT_2);
		if (id != null) {
			stringBuffer.append(TEXT_3);
			stringBuffer.append(id);
			stringBuffer.append(TEXT_4);
		}
		stringBuffer.append(TEXT_5);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "startSidebarElement", stringBuffer.toString());
	}

	protected void method_contentSidebarElement(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		String projectName = ctx.getValue("projectName").toString();
		String outputFolder = ctx.getValue("outputFolder").toString();
		String text = LabelProviderHelper.getText(currentObject);
		text = EscapeChars.forHTML(text);

		stringBuffer.append(TEXT_6);
		String imageFileName = LabelProviderHelper.getImageFileName(currentObject, projectName, outputFolder);
		stringBuffer.append(TEXT_7);
		stringBuffer.append(imageFileName);
		stringBuffer.append(TEXT_8);
		stringBuffer.append(currentObject.eClass().getName());
		stringBuffer.append(TEXT_9);
		stringBuffer.append(DocGenHtmlUtil.getModelName(currentObject));
		stringBuffer.append(TEXT_10);
		stringBuffer.append(fileNameService.getFileName(currentObject));
		stringBuffer.append(TEXT_11);
		stringBuffer.append(text);
		stringBuffer.append(TEXT_12);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "contentSidebarElement", stringBuffer.toString());
	}

	protected void method_startSidebarSubElement(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.polarsys.kitalpha.doc.gen.business.core/egf/HTMLDocGenCommon.fcore#LogicalName=org.polarsys.kitalpha.doc.gen.business.core.doccontent.sidebar.ElementSideBarSubEntry_Start" args="currentObject:parameter"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("parameter", currentObject);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.doc.gen.business.core/egf/HTMLDocGenCommon.fcore#_76_64AEaEeCfXc0sxlW-HQ",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "startSidebarSubElement", stringBuffer.toString());
	}

	protected void method_endSidebarSubElement(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.polarsys.kitalpha.doc.gen.business.core/egf/HTMLDocGenCommon.fcore#LogicalName=org.polarsys.kitalpha.doc.gen.business.core.doccontent.sidebar.ElementSideBarSubEntry_End" args="currentObject:parameter"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("parameter", currentObject);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.doc.gen.business.core/egf/HTMLDocGenCommon.fcore#_KyTtYAEbEeCfXc0sxlW-HQ",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "endSidebarSubElement", stringBuffer.toString());
	}

	protected void method_endSidebarElement(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		stringBuffer.append(TEXT_13);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "endSidebarElement", stringBuffer.toString());
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		String projectName = ctx.getValue("projectName").toString();
		String outputFolder = ctx.getValue("outputFolder").toString();

		stringBuffer.append(TEXT_14);
		stringBuffer.append(TEXT_6);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.polarsys.kitalpha.doc.gen.business.core/egf/HTMLDocGenCommon.fcore#LogicalName=org.polarsys.kitalpha.doc.gen.business.core.doccontent.sidebar.ElementSideBarEntry" args="currentObject:parameter, projectName:projectName, outputFolder:folderName"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("parameter", currentObject);
			callParameters.put("projectName", projectName);
			callParameters.put("folderName", outputFolder);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.doc.gen.business.core/egf/HTMLDocGenCommon.fcore#_-jjtYPeqEd-vRuaiXg4Fzg",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}

	protected void method_indexing(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		//org.polarsys.kitalpha.doc.gen.business.core.services.IndexerService indexer = org.polarsys.kitalpha.doc.gen.business.core.services.IndexerService.INSTANCE;
		//indexer.addElement(currentObject);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "indexing", stringBuffer.toString());
	}
}