//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.extensions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.PageExtension;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.ViewpointActivityExplorerPackage;

public class SectionPattern {
	protected static String nl;

	public static synchronized SectionPattern create(String lineSeparator) {
		nl = lineSeparator;
		SectionPattern result = new SectionPattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + NL + "\t\t<Section" + NL + "\t\t\t   expanded=\"";
	protected final String TEXT_3 = "\"" + NL + "\t\t\t   filtering=\"";
	protected final String TEXT_4 = "\"" + NL + "\t\t\t   id=\"";
	protected final String TEXT_5 = "\"\t   " + NL + "\t\t\t   index=\"";
	protected final String TEXT_6 = "\"" + NL + "\t\t\t   name=\"";
	protected final String TEXT_7 = "\"";
	protected final String TEXT_8 = NL + "\t\t\t   pageId=\"";
	protected final String TEXT_9 = ">";
	protected final String TEXT_10 = "\t\t</Section>" + NL;
	protected final String TEXT_11 = NL;

	public SectionPattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Section) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_11);
		stringBuffer.append(TEXT_11);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_initGenType(new StringBuffer(), ictx);

		method_genSectionBegin(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parameter", this.parameter);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer/egf/vpdslActivityExplorerGeneration.fcore#_vr47oDbKEeW9-uNJc0wiRg",
					ctx_local, parameters);
		}

		{
			final Map<String, Object> parameters = getParameters();
			CallbackContext ctx_callback = new CallbackContext(ictx);
			CallHelper.callBack(ctx_callback, parameters);
		}

		method_genSectionEnd(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected java.lang.Boolean genPageID = null;

	public void set_genPageID(java.lang.Boolean object) {
		this.genPageID = object;
	}

	protected java.lang.String pageID = null;

	public void set_pageID(java.lang.String object) {
		this.pageID = object;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Section parameter = null;

	public void set_parameter(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Section object) {
		this.parameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_initGenType(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		genPageID = false;
		final EObject sectionParent = parameter.eContainer();
		if (sectionParent instanceof PageExtension) {
			genPageID = true;
			PageExtension pageExtension = (PageExtension) sectionParent;
			pageID = pageExtension.getExtendedPageID();
		}

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initGenType", stringBuffer.toString());
	}

	protected void method_genSectionBegin(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		String id = parameter.getActivityExplorerItemID();
		if (null == id || (null != id && id.isEmpty()))
			id = "Activity1";

		final boolean labelIsSet = parameter
				.eIsSet(ViewpointActivityExplorerPackage.eINSTANCE.getActivityExplorerItem_Label());
		final String name = labelIsSet && false == parameter.getLabel().isEmpty() ? parameter.getLabel()
				: parameter.getName();

		stringBuffer.append(TEXT_2);
		stringBuffer.append(parameter.isExpanded() ? "true" : "false");
		stringBuffer.append(TEXT_3);
		stringBuffer.append(parameter.isFiltering() ? "true" : "false");
		stringBuffer.append(TEXT_4);
		stringBuffer.append(id);
		stringBuffer.append(TEXT_5);
		stringBuffer.append(parameter.getIndex());
		stringBuffer.append(TEXT_6);
		stringBuffer.append(name);
		stringBuffer.append(TEXT_7);
		if (genPageID) {
			stringBuffer.append(TEXT_8);
			stringBuffer.append(pageID);
			stringBuffer.append(TEXT_7);
		}
		stringBuffer.append(TEXT_9);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genSectionBegin", stringBuffer.toString());
	}

	protected void method_genSectionEnd(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_10);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genSectionEnd", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}