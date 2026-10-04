//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.doc.gen.business.ecore.sidebar;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.doc.gen.business.ecore.helpers.EcoreFileNameService;
import org.polarsys.kitalpha.doc.gen.business.core.util.*;

public class ecoreElementSideBar extends org.polarsys.kitalpha.doc.gen.business.core.doccontent.ElementSideBarContent {
	protected static String nl;

	public static synchronized ecoreElementSideBar create(String lineSeparator) {
		nl = lineSeparator;
		ecoreElementSideBar result = new ecoreElementSideBar();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "<img src=\"../icon/";
	protected final String TEXT_3 = "\" alt=\"";
	protected final String TEXT_4 = "\"/> <a href=\"../";
	protected final String TEXT_5 = "/";
	protected final String TEXT_6 = ".html\" target=\"content\">";
	protected final String TEXT_7 = "</a>" + NL + NL;
	protected final String TEXT_8 = NL;

	public ecoreElementSideBar() {
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

			this.parameter = (org.eclipse.emf.ecore.ENamedElement) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

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

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.emf.ecore.ENamedElement parameter = null;

	public void set_parameter(org.eclipse.emf.ecore.ENamedElement object) {
		this.parameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_setCurrentObject(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		currentObject = parameter;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setCurrentObject", stringBuffer.toString());
	}

	protected void method_setFileNameService(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		fileNameService = EcoreFileNameService.INSTANCE;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setFileNameService", stringBuffer.toString());
	}

	protected void method_startSidebarSubElement(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		if (org.polarsys.kitalpha.doc.gen.business.ecore.helpers.SideBarHelper.hasChildren(parameter)) {
			super.method_startSidebarSubElement(stringBuffer, ctx);

		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "startSidebarSubElement", stringBuffer.toString());
	}

	protected void method_endSidebarSubElement(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		if (org.polarsys.kitalpha.doc.gen.business.ecore.helpers.SideBarHelper.hasChildren(parameter)) {
			super.method_endSidebarSubElement(stringBuffer, ctx);

		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "endSidebarSubElement", stringBuffer.toString());
	}

	protected void method_contentSidebarElement(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		String projectName = ctx.getValue("projectName").toString();
		String outputFolder = ctx.getValue("outputFolder").toString();
		String text = ((ENamedElement) currentObject).getName();
		text = EscapeChars.forHTML(text);

		stringBuffer.append(TEXT_1);
		String imageFileName = LabelProviderHelper.getImageFileName(currentObject, projectName, outputFolder);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(imageFileName);
		stringBuffer.append(TEXT_3);
		stringBuffer.append(currentObject.eClass().getName());
		stringBuffer.append(TEXT_4);
		stringBuffer.append(DocGenHtmlUtil.getModelName(currentObject));
		stringBuffer.append(TEXT_5);
		stringBuffer.append(fileNameService.getFileName(currentObject));
		stringBuffer.append(TEXT_6);
		stringBuffer.append(text);
		stringBuffer.append(TEXT_7);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "contentSidebarElement", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return org.polarsys.kitalpha.doc.gen.business.ecore.helpers.PreConditionHelper.isTypeGenerated(parameter);
	}
}