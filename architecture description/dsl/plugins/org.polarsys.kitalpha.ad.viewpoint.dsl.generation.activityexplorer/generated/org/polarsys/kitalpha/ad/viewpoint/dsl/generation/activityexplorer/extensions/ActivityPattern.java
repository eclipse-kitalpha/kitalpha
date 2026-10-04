//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.extensions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.internal.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.SectionExtension;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.ViewpointActivityExplorerPackage;

public class ActivityPattern {
	protected static String nl;

	public static synchronized ActivityPattern create(String lineSeparator) {
		nl = lineSeparator;
		ActivityPattern result = new ActivityPattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = NL + "\t\t\t<Activity" + NL + "\t\t\t\tclass=\"";
	protected final String TEXT_2 = "\"" + NL + "\t\t\t\tid=\"";
	protected final String TEXT_3 = "\"" + NL + "\t\t\t\tindex=\"";
	protected final String TEXT_4 = "\"";
	protected final String TEXT_5 = " " + NL + "\t\t\t\timage=\"";
	protected final String TEXT_6 = NL + "\t\t\t\tname=\"";
	protected final String TEXT_7 = NL + "\t\t\t\tsectionId=\"";
	protected final String TEXT_8 = ">";
	protected final String TEXT_9 = "\t\t\t</Activity>" + NL;
	protected final String TEXT_10 = NL;

	public ActivityPattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Activity) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_10);
		stringBuffer.append(TEXT_10);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_initGenType(new StringBuffer(), ictx);

		method_setProjectName(new StringBuffer(), ictx);

		method_genActivityBegin(new StringBuffer(), ictx);
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

		method_genActivityEnd(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("iconElement", this.parameter);
			parameters.put("activityExplorerProjectName", this.projectName);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer/egf/vpdslActivityExplorerGeneration.fcore#_77MRMDdmEeW9-uNJc0wiRg",
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

	protected java.lang.Boolean genSectionID = null;

	public void set_genSectionID(java.lang.Boolean object) {
		this.genSectionID = object;
	}

	protected java.lang.String sectionID = null;

	public void set_sectionID(java.lang.String object) {
		this.sectionID = object;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Activity parameter = null;

	public void set_parameter(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Activity object) {
		this.parameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_initGenType(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		genSectionID = false;
		final EObject activityParent = parameter.eContainer();
		if (activityParent instanceof SectionExtension) {
			genSectionID = true;
			SectionExtension sectionExtension = (SectionExtension) activityParent;
			sectionID = sectionExtension.getExtendedSectionID();
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initGenType", stringBuffer.toString());
	}

	protected void method_setProjectName(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		projectName = (String) ctx.getValue("activity.explorer.project.name");
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setProjectName", stringBuffer.toString());
	}

	protected void method_genActivityBegin(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		String className = JavaNamingConvention.getJavaClassFQNFor(projectName, parameter,
				JavaNamingConvention.JavaUseContext.Activity);

		String id = parameter.getActivityExplorerItemID();
		if (null == id || (null != id && id.isEmpty()))
			id = "Activity1";

		boolean hasImage = parameter.getImagePathOff() != null;
		final boolean labelIsSet = parameter
				.eIsSet(ViewpointActivityExplorerPackage.eINSTANCE.getActivityExplorerItem_Label());
		final String name = labelIsSet && false == parameter.getLabel().isEmpty() ? parameter.getLabel()
				: parameter.getName();

		stringBuffer.append(TEXT_1);
		stringBuffer.append(className);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(id);
		stringBuffer.append(TEXT_3);
		stringBuffer.append(parameter.getIndex());
		stringBuffer.append(TEXT_4);
		if (hasImage) {
			stringBuffer.append(TEXT_5);
			stringBuffer.append(IconsFileHelper.ICONS_FOLDER_NAME + "/" + parameter.getImagePathOff());
			stringBuffer.append(TEXT_4);
		}
		stringBuffer.append(TEXT_6);
		stringBuffer.append(name);
		stringBuffer.append(TEXT_4);
		if (genSectionID) {
			stringBuffer.append(TEXT_7);
			stringBuffer.append(sectionID);
			stringBuffer.append(TEXT_4);
		}
		stringBuffer.append(TEXT_8);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genActivityBegin", stringBuffer.toString());
	}

	protected void method_genActivityEnd(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_9);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genActivityEnd", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}