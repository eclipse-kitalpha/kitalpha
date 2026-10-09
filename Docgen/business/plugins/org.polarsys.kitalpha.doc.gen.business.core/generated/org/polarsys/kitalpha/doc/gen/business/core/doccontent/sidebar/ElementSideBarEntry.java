//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.doc.gen.business.core.doccontent.sidebar;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.doc.gen.business.core.util.*;

public class ElementSideBarEntry extends org.polarsys.kitalpha.doc.gen.business.core.generic.ElementGen {
	protected static String nl;

	public static synchronized ElementSideBarEntry create(String lineSeparator) {
		nl = lineSeparator;
		ElementSideBarEntry result = new ElementSideBarEntry();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<li>" + NL;
	protected final String TEXT_2 = NL + "<img src=\"../icon/";
	protected final String TEXT_3 = "\" alt=\"";
	protected final String TEXT_4 = "\"/>";
	protected final String TEXT_5 = NL + NL;
	protected final String TEXT_6 = "</li>" + NL;
	protected final String TEXT_7 = NL;

	public ElementSideBarEntry() {
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
		List<Object> projectNameList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> folderNameList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {
			for (Object projectNameParameter : projectNameList) {
				for (Object folderNameParameter : folderNameList) {

					this.parameter = (org.eclipse.emf.ecore.EObject) parameterParameter;
					this.projectName = (java.lang.String) projectNameParameter;
					this.folderName = (java.lang.String) folderNameParameter;

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

		stringBuffer.append(TEXT_7);
		stringBuffer.append(TEXT_7);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_startSidebarElement(new StringBuffer(), ictx);

		method_contentSidebarElement(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parameter", this.parameter);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.doc.gen.business.core/egf/HTMLDocGenCommon.fcore#_76_64AEaEeCfXc0sxlW-HQ",
					ctx_local, parameters);
		}

		{
			final Map<String, Object> parameters = getParameters();
			CallbackContext ctx_callback = new CallbackContext(ictx);
			CallHelper.callBack(ctx_callback, parameters);
		}

		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parameter", this.parameter);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.doc.gen.business.core/egf/HTMLDocGenCommon.fcore#_KyTtYAEbEeCfXc0sxlW-HQ",
					ctx_local, parameters);
		}

		method_endSidebarElement(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			parameterValues.put("projectName", this.projectName);
			parameterValues.put("folderName", this.folderName);
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

	protected java.lang.String projectName = null;

	public void set_projectName(java.lang.String object) {
		this.projectName = object;
	}

	protected java.lang.String folderName = null;

	public void set_folderName(java.lang.String object) {
		this.folderName = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		parameters.put("projectName", this.projectName);
		parameters.put("folderName", this.folderName);
		return parameters;
	}

	protected void method_startSidebarElement(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "startSidebarElement", stringBuffer.toString());
	}

	protected void method_contentSidebarElement(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		String imageFileName = LabelProviderHelper.getImageFileName(parameter, projectName, folderName);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(imageFileName);
		stringBuffer.append(TEXT_3);
		stringBuffer.append(parameter.eClass().getName());
		stringBuffer.append(TEXT_4);
		stringBuffer.append(LabelProviderHelper.getText(parameter));
		stringBuffer.append(TEXT_5);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "contentSidebarElement", stringBuffer.toString());
	}

	protected void method_endSidebarElement(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		stringBuffer.append(TEXT_6);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "endSidebarElement", stringBuffer.toString());
	}
}