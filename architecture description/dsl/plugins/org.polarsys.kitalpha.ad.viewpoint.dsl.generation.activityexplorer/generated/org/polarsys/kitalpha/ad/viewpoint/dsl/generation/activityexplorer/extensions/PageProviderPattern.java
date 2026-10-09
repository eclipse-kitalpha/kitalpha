//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.extensions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Overview;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.internal.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.ViewpointActivityExplorerPackage;

public class PageProviderPattern {
	protected static String nl;

	public static synchronized PageProviderPattern create(String lineSeparator) {
		nl = lineSeparator;
		PageProviderPattern result = new PageProviderPattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = NL + "<extension point=\"org.eclipse.amalgam.explorer.activity.ui.pagesProvider\">"
			+ NL + "\t<Page" + NL + "\t\tclass=\"";
	protected final String TEXT_2 = "\"" + NL + "        id=\"";
	protected final String TEXT_3 = "\"";
	protected final String TEXT_4 = " " + NL + "\t\timageOff=\"";
	protected final String TEXT_5 = " " + NL + "\t\timageOn=\"";
	protected final String TEXT_6 = NL + "        index=\"";
	protected final String TEXT_7 = "\"" + NL + "        tabName=\"";
	protected final String TEXT_8 = "\"" + NL + "        title=\"";
	protected final String TEXT_9 = "\"" + NL + "        viewer=\"";
	protected final String TEXT_10 = "\">";
	protected final String TEXT_11 = "\t</Page>" + NL + "</extension>" + NL;
	protected final String TEXT_12 = NL + "\t\t<Overview";
	protected final String TEXT_13 = " imageOff=\"";
	protected final String TEXT_14 = " imageOn=\"";
	protected final String TEXT_15 = ">" + NL + "\t\t\t<Description>" + NL + "\t\t\t\t";
	protected final String TEXT_16 = NL + "\t\t\t</Description>" + NL + "\t\t</Overview>";
	protected final String TEXT_17 = NL;

	public PageProviderPattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Page) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_17);
		stringBuffer.append(TEXT_17);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_initParameter(new StringBuffer(), ictx);

		method_genPageBegin(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parameter", this.parameter);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer/egf/vpdslActivityExplorerGeneration.fcore#_vr47oDbKEeW9-uNJc0wiRg",
					ctx_local, parameters);
		}

		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("predicatedElement", this.parameter);
			parameters.put("basePackage", this.projectName);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer/egf/vpdslActivityExplorerGeneration.fcore#_JYnqcDbJEeW9-uNJc0wiRg",
					ctx_local, parameters);
		}

		method_genOverview(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("dynamicIconElement", this.overview);
			parameters.put("activityExplorerProjectName", this.projectName);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer/egf/vpdslActivityExplorerGeneration.fcore#_DdCxsDdqEeW9-uNJc0wiRg",
					ctx_local, parameters);
		}

		{
			final Map<String, Object> parameters = getParameters();
			CallbackContext ctx_callback = new CallbackContext(ictx);
			CallHelper.callBack(ctx_callback, parameters);
		}

		method_genPageEnd(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("dynamicIconElement", this.parameter);
			parameters.put("activityExplorerProjectName", this.projectName);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer/egf/vpdslActivityExplorerGeneration.fcore#_DdCxsDdqEeW9-uNJc0wiRg",
					ctx_local, parameters);
		}

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected java.lang.String projectName = null;

	public void set_projectName(java.lang.String object) {
		this.projectName = object;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Overview overview = null;

	public void set_overview(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Overview object) {
		this.overview = object;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Page parameter = null;

	public void set_parameter(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Page object) {
		this.parameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_initParameter(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		projectName = (String) ctx.getValue("activity.explorer.project.name");
		overview = parameter.getOwnedOverview();
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initParameter", stringBuffer.toString());
	}

	protected void method_genPageBegin(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		String className = JavaNamingConvention.getJavaClassFQNFor(projectName, parameter,
				JavaNamingConvention.JavaUseContext.Page);

		String id = parameter.getActivityExplorerItemID();
		if (null == id || (null != id && id.isEmpty()))
			id = "Page1";

		final boolean labelIsSet = parameter
				.eIsSet(ViewpointActivityExplorerPackage.eINSTANCE.getActivityExplorerItem_Label());
		final String name = labelIsSet && false == parameter.getLabel().isEmpty() ? parameter.getLabel()
				: parameter.getName();

		final boolean tabNameIsSet = parameter.eIsSet(ViewpointActivityExplorerPackage.eINSTANCE.getPage_TabName());
		final String tabName = tabNameIsSet && false == parameter.getTabName().isEmpty() ? parameter.getTabName()
				: name;

		stringBuffer.append(TEXT_1);
		stringBuffer.append(className);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(id);
		stringBuffer.append(TEXT_3);
		if (parameter.getImagePathOff() != null && parameter.getImagePathOff().isEmpty() == false) {
			stringBuffer.append(TEXT_4);
			stringBuffer.append(IconsFileHelper.ICONS_FOLDER_NAME + "/" + parameter.getImagePathOff());
			stringBuffer.append(TEXT_3);
		}
		if (parameter.getImagePathOn() != null && parameter.getImagePathOn().isEmpty() == false) {
			stringBuffer.append(TEXT_5);
			stringBuffer.append(IconsFileHelper.ICONS_FOLDER_NAME + "/" + parameter.getImagePathOn());
			stringBuffer.append(TEXT_3);
		}
		stringBuffer.append(TEXT_6);
		stringBuffer.append(parameter.getIndex());
		stringBuffer.append(TEXT_7);
		stringBuffer.append(tabName);
		stringBuffer.append(TEXT_8);
		stringBuffer.append(name);
		stringBuffer.append(TEXT_9);
		stringBuffer.append(parameter.isShowViewer());
		stringBuffer.append(TEXT_10);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genPageBegin", stringBuffer.toString());
	}

	protected void method_genPageEnd(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_11);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genPageEnd", stringBuffer.toString());
	}

	protected void method_genOverview(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		String description = "Description body text";
		if (null != overview && null != overview.getDescription() && false == overview.getDescription().isEmpty()) {
			description = overview.getDescription();
			description = description.replaceAll("<", "&lt;");
			description = description.replaceAll(">", "&gt;");
		}
		if (overview != null) {
			stringBuffer.append(TEXT_12);
			if (overview.getImagePathOff() != null && false == overview.getImagePathOff().isEmpty()) {
				stringBuffer.append(TEXT_13);
				stringBuffer.append(IconsFileHelper.ICONS_FOLDER_NAME + "/" + overview.getImagePathOff());
				stringBuffer.append(TEXT_3);
			}
			if (overview.getImagePathOn() != null && false == overview.getImagePathOn().isEmpty()) {
				stringBuffer.append(TEXT_14);
				stringBuffer.append(IconsFileHelper.ICONS_FOLDER_NAME + "/" + overview.getImagePathOn());
				stringBuffer.append(TEXT_3);
			}
			stringBuffer.append(TEXT_15);
			stringBuffer.append(description);
			stringBuffer.append(TEXT_16);
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genOverview", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}