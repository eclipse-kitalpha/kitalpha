//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.customizations.style;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.eclipse.emf.common.util.EList;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData.JavaMethodReturnType;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.VpstylecustomizationPackage;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.SpecificContainerStyleCustomization;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.ContainerWorkspaceImageCustomization;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.FlatContainerStyleCustomization;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.ShapeContainerStyleCustomization;

public class ContainerStyleCustomizationPattern extends
		org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.customizations.common.AbstractNodeStyleCustomizationPattern {

	public ContainerStyleCustomizationPattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.ContainerStyleCustomization) parameterParameter;

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
		method_initArcWidthData(new StringBuffer(), ictx);
		method_initArcHeightData(new StringBuffer(), ictx);
		method_initRoundedCornerData(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parent", this.parent);
			parameters.put("applyOnAll", this.applyOnAll);
			parameters.put("appliedOn", this.appliedOn);
			parameters.put("stylePropertyData", this.arcWidth);
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
			parameters.put("stylePropertyData", this.arcHeight);
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
			parameters.put("stylePropertyData", this.roundedCorner);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram/egf/VpdslSiriusDiagramGenerator.fcore#_IXiPcGdyEeWYaMtt1GGGww",
					ctx_local, parameters);
		}
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parent", this.parent);
			parameters.put("applyOnAll", this.applyOnAll);
			parameters.put("stylePropertyData", this.workspacePath);
			parameters.put("appliedOn", this.workspacePathAppliedOn);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram/egf/VpdslSiriusDiagramGenerator.fcore#_IXiPcGdyEeWYaMtt1GGGww",
					ctx_local, parameters);
		}
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parent", this.parent);
			parameters.put("applyOnAll", this.applyOnAll);
			parameters.put("stylePropertyData", this.backgroundStyle);
			parameters.put("appliedOn", this.backgroundStyleAppliedOn);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram/egf/VpdslSiriusDiagramGenerator.fcore#_IXiPcGdyEeWYaMtt1GGGww",
					ctx_local, parameters);
		}
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parent", this.parent);
			parameters.put("applyOnAll", this.applyOnAll);
			parameters.put("stylePropertyData", this.shape);
			parameters.put("appliedOn", this.shapeAppliedOn);
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

	protected void method_initArcWidthData(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (parameter.eIsSet(VpstylecustomizationPackage.eINSTANCE.getContainerStyleCustomization_ArcWith())) {
			set_arcWidth(new StylePropertyNameValueCouple("arcWidth", parameter.getArcWith()));
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initArcWidthData", out.toString());
	}

	protected void method_initArcHeightData(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (parameter.eIsSet(VpstylecustomizationPackage.eINSTANCE.getContainerStyleCustomization_ArcHeight())) {
			set_arcHeight(new StylePropertyNameValueCouple("arcHeight", parameter.getArcHeight()));
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initArcHeightData", out.toString());
	}

	protected void method_initRoundedCornerData(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (parameter.eIsSet(VpstylecustomizationPackage.eINSTANCE.getContainerStyleCustomization_RoundedCorner())) {
			set_roundedCorner(new StylePropertyNameValueCouple("roundedCorner", parameter.isRoundedCorner()));
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initRoundedCornerData", out.toString());
	}

	protected void method_initializeCustomStyleData(final StringBuffer out, final PatternContext ctx) throws Exception {
		final EList<SpecificContainerStyleCustomization> specificCustomizations = parameter
				.getOwnedSpecificContainerStyleCustomization();
		for (SpecificContainerStyleCustomization specificCustomization : specificCustomizations) {
			if (specificCustomization instanceof ContainerWorkspaceImageCustomization) {
				ContainerWorkspaceImageCustomization cwic = (ContainerWorkspaceImageCustomization) specificCustomization;
				set_workspacePathAppliedOn(cwic.getAppliedOn());
				if (cwic.eIsSet(VpstylecustomizationPackage.eINSTANCE
						.getContainerWorkspaceImageCustomization_WorkspacePath())) {
					set_workspacePath(new StylePropertyNameValueCouple("workspacePath", cwic.getWorkspacePath()));
				}
			}

			if (specificCustomization instanceof FlatContainerStyleCustomization) {
				FlatContainerStyleCustomization fcsc = (FlatContainerStyleCustomization) specificCustomization;
				set_backgroundStyleAppliedOn(fcsc.getAppliedOn());
				if (fcsc.eIsSet(
						VpstylecustomizationPackage.eINSTANCE.getFlatContainerStyleCustomization_BackgroundStyle())) {
					String enumLiteralName = fcsc.getBackgroundStyle().toString();
					String methodCode = "return DiagramPackage.eINSTANCE.getBackgroundStyle().getEEnumLiteral(\""
							+ enumLiteralName + "\");";
					char first = Character.toUpperCase(enumLiteralName.charAt(0));
					enumLiteralName = first + enumLiteralName.substring(1).toLowerCase();
					String methodName = "getBackgroundStyle" + enumLiteralName;

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

					set_backgroundStyle(new StylePropertyNameValueCouple("backgroundStyle", "service:" + methodName));
				}
			}

			if (specificCustomization instanceof ShapeContainerStyleCustomization) {
				ShapeContainerStyleCustomization scsc = (ShapeContainerStyleCustomization) specificCustomization;
				set_shapeAppliedOn(scsc.getAppliedOn());
				if (scsc.eIsSet(VpstylecustomizationPackage.eINSTANCE.getShapeContainerStyleCustomization_Shape())) {
					String enumLiteralName = scsc.getShape().toString();
					String methodCode = "return DiagramPackage.eINSTANCE.getContainerShape().getEEnumLiteral(\""
							+ enumLiteralName + "\");";
					char first = Character.toUpperCase(enumLiteralName.charAt(0));
					enumLiteralName = first + enumLiteralName.substring(1).toLowerCase();
					String methodName = "getContainerShape" + enumLiteralName;

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

					set_shape(new StylePropertyNameValueCouple("shape", "service:" + methodName));
				}
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initializeCustomStyleData", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.ContainerStyleCustomization parameter;

	public void set_parameter(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.ContainerStyleCustomization parameter) {
		this.parameter = parameter;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple arcWidth;

	public void set_arcWidth(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple arcWidth) {
		this.arcWidth = arcWidth;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple arcHeight;

	public void set_arcHeight(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple arcHeight) {
		this.arcHeight = arcHeight;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple roundedCorner;

	public void set_roundedCorner(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple roundedCorner) {
		this.roundedCorner = roundedCorner;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple workspacePath;

	public void set_workspacePath(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple workspacePath) {
		this.workspacePath = workspacePath;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple backgroundStyle;

	public void set_backgroundStyle(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple backgroundStyle) {
		this.backgroundStyle = backgroundStyle;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple shape;

	public void set_shape(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple shape) {
		this.shape = shape;
	}

	protected java.util.List workspacePathAppliedOn;

	public void set_workspacePathAppliedOn(java.util.List workspacePathAppliedOn) {
		this.workspacePathAppliedOn = workspacePathAppliedOn;
	}

	protected java.util.List backgroundStyleAppliedOn;

	public void set_backgroundStyleAppliedOn(java.util.List backgroundStyleAppliedOn) {
		this.backgroundStyleAppliedOn = backgroundStyleAppliedOn;
	}

	protected java.util.List shapeAppliedOn;

	public void set_shapeAppliedOn(java.util.List shapeAppliedOn) {
		this.shapeAppliedOn = shapeAppliedOn;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
