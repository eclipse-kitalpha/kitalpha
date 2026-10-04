//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.customizations.style;

import java.util.*;

import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.eclipse.emf.common.util.EList;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.VpstylecustomizationPackage;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.SpecificNodeStyleCustomization;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.NodeWorkspaceImageCustomization;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.SquareCustomization;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.AbstractComputableElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.BundledImageCustomization;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.CustomizationExpression;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.GaugeCustomization;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.DiagramExpressionUtil;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.VSMVariable;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData.JavaMethodReturnType;

public class NodeStyleCustomizationPattern extends
		org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.customizations.common.AbstractNodeStyleCustomizationPattern {

	public NodeStyleCustomizationPattern() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.NodeStyleCustomization) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration((PatternContext) argument);

			}
		}
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		super.orchestration(new SuperOrchestrationContext(ictx));
		method_initLabelPositionData(new StringBuffer(), ictx);
		method_initHideLabelByDefaultData(new StringBuffer(), ictx);
		method_initResizeKindData(new StringBuffer(), ictx);
		method_initSizeComputationExpressionData(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parent", this.parent);
			parameters.put("applyOnAll", this.applyOnAll);
			parameters.put("appliedOn", this.appliedOn);
			parameters.put("stylePropertyData", this.labelPosition);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram/egf/VpdslSiriusDiagramGenerator.fcore#_IXiPcGdyEeWYaMtt1GGGww",
					ctx_local, parameters);
		}
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parent", this.parent);
			parameters.put("applyOnAll", this.applyOnAll);
			parameters.put("appliedOn", this.appliedOn);
			parameters.put("stylePropertyData", this.hideLabelByDefault);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram/egf/VpdslSiriusDiagramGenerator.fcore#_IXiPcGdyEeWYaMtt1GGGww",
					ctx_local, parameters);
		}
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parent", this.parent);
			parameters.put("applyOnAll", this.applyOnAll);
			parameters.put("appliedOn", this.appliedOn);
			parameters.put("stylePropertyData", this.resizeKind);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram/egf/VpdslSiriusDiagramGenerator.fcore#_IXiPcGdyEeWYaMtt1GGGww",
					ctx_local, parameters);
		}
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parent", this.parent);
			parameters.put("applyOnAll", this.applyOnAll);
			parameters.put("appliedOn", this.appliedOn);
			parameters.put("stylePropertyData", this.sizeComputationExpression);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram/egf/VpdslSiriusDiagramGenerator.fcore#_IXiPcGdyEeWYaMtt1GGGww",
					ctx_local, parameters);
		}
		ictx.setNode(currentNode);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_setParentMapping(final StringBuffer out, final PatternContext ctx) throws Exception {
		dslvpElement = parameter;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setParentMapping", out.toString());
	}

	protected void method_initLabelPositionData(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (parameter.eIsSet(VpstylecustomizationPackage.eINSTANCE.getNodeStyleCustomization_LabelPosition())) {
			String enumLiteralName = parameter.getLabelPosition().toString();
			String methodCode = "return DiagramPackage.eINSTANCE.getLabelPosition().getEEnumLiteral(\""
					+ enumLiteralName + "\");";
			char first = Character.toUpperCase(enumLiteralName.charAt(0));
			enumLiteralName = first + enumLiteralName.substring(1).toLowerCase();
			String methodName = "getLabelPosition" + enumLiteralName;

			JavaMethodData javaMethodData = new JavaMethodData(methodName, JavaMethodReturnType.EEnumLiteral,
					methodCode);

			// Set method parameters data
			javaMethodData.addMethodParameter("any", "EObject", "any model element");

			// Set method Required classes FQN
			javaMethodData.getRequiredClassesFQN().add("org.eclipse.emf.ecore.EEnumLiteral");
			javaMethodData.getRequiredClassesFQN().add("org.eclipse.sirius.diagram.DiagramPackage");

			// Add the method to the Java Service.
			if (javaMethodData != null)
				enumHelperJavaServiceData.addMethod(javaMethodData);

			set_labelPosition(new StylePropertyNameValueCouple("labelPosition", "service:" + methodName));
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initLabelPositionData", out.toString());
	}

	protected void method_initHideLabelByDefaultData(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		if (parameter.eIsSet(VpstylecustomizationPackage.eINSTANCE.getNodeStyleCustomization_HideLabelByDefault())) {
			set_hideLabelByDefault(
					new StylePropertyNameValueCouple("hideLabelByDefault", parameter.isHideLabelByDefault()));
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initHideLabelByDefaultData", out.toString());
	}

	protected void method_initResizeKindData(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (parameter.eIsSet(VpstylecustomizationPackage.eINSTANCE.getNodeStyleCustomization_ResizeKind())) {
			String enumLiteralName = parameter.getResizeKind().toString();
			String methodCode = "return DiagramPackage.eINSTANCE.getResizeKind().getEEnumLiteral(\"" + enumLiteralName
					+ "\");";
			char first = Character.toUpperCase(enumLiteralName.charAt(0));
			enumLiteralName = first + enumLiteralName.substring(1).toLowerCase();
			String methodName = "getResizeKind" + enumLiteralName;

			JavaMethodData javaMethodData = new JavaMethodData(methodName, JavaMethodReturnType.EEnumLiteral,
					methodCode);

			// Set method parameters data
			javaMethodData.addMethodParameter("any", "EObject", "any model element");

			// Set method Required classes FQN
			javaMethodData.getRequiredClassesFQN().add("org.eclipse.emf.ecore.EEnumLiteral");
			javaMethodData.getRequiredClassesFQN().add("org.eclipse.sirius.diagram.DiagramPackage");

			// Add the method to the Java Service.
			if (javaMethodData != null)
				enumHelperJavaServiceData.addMethod(javaMethodData);

			set_resizeKind(new StylePropertyNameValueCouple("resizeKind", "service:" + methodName));
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initResizeKindData", out.toString());
	}

	protected void method_initSizeComputationExpressionData(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		if (parameter
				.eIsSet(VpstylecustomizationPackage.eINSTANCE.getNodeStyleCustomization_SizeComputationExpression())) {
			final CustomizationExpression expression = parameter.getSizeComputationExpression();
			final AbstractComputableElement expressionElement = expression.getOwnedExpressionElement();
			if (expressionElement != null) {
				final String newLabelExpression = DiagramExpressionUtil.getAbstractComputableElementExpression(
						expressionElement, VSMVariable.view, VSMVariable.container);
				set_sizeComputationExpression(
						new StylePropertyNameValueCouple("sizeComputationExpression", newLabelExpression));
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initSizeComputationExpressionData", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.NodeStyleCustomization parameter;

	public void set_parameter(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.NodeStyleCustomization parameter) {
		this.parameter = parameter;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple labelPosition;

	public void set_labelPosition(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple labelPosition) {
		this.labelPosition = labelPosition;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple hideLabelByDefault;

	public void set_hideLabelByDefault(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple hideLabelByDefault) {
		this.hideLabelByDefault = hideLabelByDefault;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple resizeKind;

	public void set_resizeKind(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple resizeKind) {
		this.resizeKind = resizeKind;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple sizeComputationExpression;

	public void set_sizeComputationExpression(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple sizeComputationExpression) {
		this.sizeComputationExpression = sizeComputationExpression;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
