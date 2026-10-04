//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.customizations.style;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.AbstractComputableElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.CustomizationExpression;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.VpstylecustomizationPackage;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.DiagramExpressionUtil;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.VSMVariable;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData.JavaMethodReturnType;

public class EdgeStyleCustomizationPattern extends
		org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.customizations.common.AbstractStyleCustomizationPattern {

	public EdgeStyleCustomizationPattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.EdgeStyleCustomization) parameterParameter;

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
		method_initLineStyleData(new StringBuffer(), ictx);
		method_initSourceArrowdata(new StringBuffer(), ictx);
		method_initTargetArrowData(new StringBuffer(), ictx);
		method_initRoutingStyleData(new StringBuffer(), ictx);
		method_initFoldingStyleData(new StringBuffer(), ictx);
		method_initEndCenteringData(new StringBuffer(), ictx);
		method_initSizeComputationExpressionData(new StringBuffer(), ictx);
		method_initLabelStyleDescriptionData(new StringBuffer(), ictx);
		method_initCenteredMappingsData(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("applyOnAll", this.applyOnAll);
			parameters.put("appliedOn", this.appliedOn);
			parameters.put("stylePropertyData", this.lineStyle);
			parameters.put("parent", this.parent);
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
			parameters.put("stylePropertyData", this.sourceArrow);
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
			parameters.put("stylePropertyData", this.targetArrow);
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
			parameters.put("stylePropertyData", this.routineStyle);
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
			parameters.put("stylePropertyData", this.foldingStyle);
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
			parameters.put("stylePropertyData", this.endCentering);
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
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parent", this.parent);
			parameters.put("applyOnAll", this.applyOnAll);
			parameters.put("appliedOn", this.appliedOn);
			parameters.put("stylePropertyData", this.beginLabelStyleDescription);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram/egf/VpdslSiriusDiagramGenerator.fcore#_VpyWIGz4EeWW0teG0FdF7g",
					ctx_local, parameters);
		}
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parent", this.parent);
			parameters.put("applyOnAll", this.applyOnAll);
			parameters.put("appliedOn", this.appliedOn);
			parameters.put("stylePropertyData", this.endLabelStyleDescription);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram/egf/VpdslSiriusDiagramGenerator.fcore#_VpyWIGz4EeWW0teG0FdF7g",
					ctx_local, parameters);
		}
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parent", this.parent);
			parameters.put("applyOnAll", this.applyOnAll);
			parameters.put("appliedOn", this.appliedOn);
			parameters.put("stylePropertyData", this.centerLabelStyleDescription);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram/egf/VpdslSiriusDiagramGenerator.fcore#_VpyWIGz4EeWW0teG0FdF7g",
					ctx_local, parameters);
		}
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parent", this.parent);
			parameters.put("applyOnAll", this.applyOnAll);
			parameters.put("appliedOn", this.appliedOn);
			parameters.put("stylePropertyData", this.centeredTargetMappings);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram/egf/VpdslSiriusDiagramGenerator.fcore#_VpyWIGz4EeWW0teG0FdF7g",
					ctx_local, parameters);
		}
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parent", this.parent);
			parameters.put("applyOnAll", this.applyOnAll);
			parameters.put("appliedOn", this.appliedOn);
			parameters.put("stylePropertyData", this.centeredSourceMappings);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram/egf/VpdslSiriusDiagramGenerator.fcore#_VpyWIGz4EeWW0teG0FdF7g",
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

	protected void method_initLineStyleData(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (parameter.eIsSet(VpstylecustomizationPackage.eINSTANCE.getEdgeStyleCustomization_LineStyle())) {
			String enumLiteralName = parameter.getLineStyle().toString();
			String methodCode = "return DiagramPackage.eINSTANCE.getLineStyle().getEEnumLiteral(\"" + enumLiteralName
					+ "\");";
			char first = Character.toUpperCase(enumLiteralName.charAt(0));
			enumLiteralName = first + enumLiteralName.substring(1).toLowerCase();
			String methodName = "getLineStyle" + enumLiteralName;

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

			set_lineStyle(new StylePropertyNameValueCouple("lineStyle", "service:" + methodName));
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initLineStyleData", out.toString());
	}

	protected void method_initSourceArrowdata(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (parameter.eIsSet(VpstylecustomizationPackage.eINSTANCE.getEdgeStyleCustomization_SourceArrow())) {
			String enumLiteralName = parameter.getSourceArrow().toString();
			String methodCode = "return DiagramPackage.eINSTANCE.getEdgeArrows().getEEnumLiteral(\"" + enumLiteralName
					+ "\");";
			char first = Character.toUpperCase(enumLiteralName.charAt(0));
			enumLiteralName = first + enumLiteralName.substring(1).toLowerCase();
			String methodName = "getEdgeArrows" + enumLiteralName;

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

			set_sourceArrow(new StylePropertyNameValueCouple("sourceArrow", "service:" + methodName));
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initSourceArrowdata", out.toString());
	}

	protected void method_initTargetArrowData(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (parameter.eIsSet(VpstylecustomizationPackage.eINSTANCE.getEdgeStyleCustomization_TargetArrow())) {
			String enumLiteralName = parameter.getTargetArrow().toString();
			String methodCode = "return DiagramPackage.eINSTANCE.getEdgeArrows().getEEnumLiteral(\"" + enumLiteralName
					+ "\");";
			char first = Character.toUpperCase(enumLiteralName.charAt(0));
			enumLiteralName = first + enumLiteralName.substring(1).toLowerCase();
			String methodName = "getEdgeArrows" + enumLiteralName;

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

			set_targetArrow(new StylePropertyNameValueCouple("targetArrow", "service:" + methodName));
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initTargetArrowData", out.toString());
	}

	protected void method_initRoutingStyleData(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (parameter.eIsSet(VpstylecustomizationPackage.eINSTANCE.getEdgeStyleCustomization_RoutingStyle())) {
			String enumLiteralName = parameter.getRoutingStyle().toString();
			String methodCode = "return DiagramPackage.eINSTANCE.getEdgeRouting().getEEnumLiteral(\"" + enumLiteralName
					+ "\");";
			char first = Character.toUpperCase(enumLiteralName.charAt(0));
			enumLiteralName = first + enumLiteralName.substring(1).toLowerCase();
			String methodName = "getEdgeRouting" + enumLiteralName;

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

			set_routineStyle(new StylePropertyNameValueCouple("routingStyle", "service:" + methodName));
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initRoutingStyleData", out.toString());
	}

	protected void method_initFoldingStyleData(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (parameter.eIsSet(VpstylecustomizationPackage.eINSTANCE.getEdgeStyleCustomization_FoldingStyle())) {
			String enumLiteralName = parameter.getFoldingStyle().toString();
			String methodCode = "return DescriptionPackage.eINSTANCE.getFoldingStyle().getEEnumLiteral(\""
					+ enumLiteralName + "\");";
			char first = Character.toUpperCase(enumLiteralName.charAt(0));
			enumLiteralName = first + enumLiteralName.substring(1).toLowerCase();
			String methodName = "getFoldingStyle" + enumLiteralName;

			JavaMethodData javaMethodData = new JavaMethodData(methodName, JavaMethodReturnType.EEnumLiteral,
					methodCode);

			// Set method parameters data
			javaMethodData.addMethodParameter("any", "EObject", "any model element");

			// Set method Required classes FQN
			javaMethodData.getRequiredClassesFQN().add("org.eclipse.emf.ecore.EEnumLiteral");
			javaMethodData.getRequiredClassesFQN().add("org.eclipse.sirius.diagram.description.DescriptionPackage");

			// Add the method to the Java Service.
			if (javaMethodData != null)
				enumHelperJavaServiceData.addMethod(javaMethodData);

			set_foldingStyle(new StylePropertyNameValueCouple("foldingStyle", "service:" + methodName));
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initFoldingStyleData", out.toString());
	}

	protected void method_initEndCenteringData(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (parameter.eIsSet(VpstylecustomizationPackage.eINSTANCE.getEdgeStyleCustomization_EndCentering())) {
			String enumLiteralName = parameter.getEndCentering().toString();
			String methodCode = "return DescriptionPackage.eINSTANCE.getCenteringStyle().getEEnumLiteral(\""
					+ enumLiteralName + "\");";
			char first = Character.toUpperCase(enumLiteralName.charAt(0));
			enumLiteralName = first + enumLiteralName.substring(1).toLowerCase();
			String methodName = "getEndCentering" + enumLiteralName;

			JavaMethodData javaMethodData = new JavaMethodData(methodName, JavaMethodReturnType.EEnumLiteral,
					methodCode);

			// Set method parameters data
			javaMethodData.addMethodParameter("any", "EObject", "any model element");

			// Set method Required classes FQN
			javaMethodData.getRequiredClassesFQN().add("org.eclipse.emf.ecore.EEnumLiteral");
			javaMethodData.getRequiredClassesFQN().add("org.eclipse.sirius.diagram.description.DescriptionPackage");

			// Add the method to the Java Service.
			if (javaMethodData != null)
				enumHelperJavaServiceData.addMethod(javaMethodData);

			set_endCentering(new StylePropertyNameValueCouple("endsCentering", "service:" + methodName));
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initEndCenteringData", out.toString());
	}

	protected void method_initSizeComputationExpressionData(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		if (parameter
				.eIsSet(VpstylecustomizationPackage.eINSTANCE.getEdgeStyleCustomization_SizeComputationExpression())) {
			final CustomizationExpression expression = parameter.getSizeComputationExpression();
			final AbstractComputableElement expressionElement = expression.getOwnedExpressionElement();
			if (expressionElement != null) {
				final String sceExpression = DiagramExpressionUtil.getAbstractComputableElementExpression(
						expressionElement, VSMVariable.view, VSMVariable.container);
				set_sizeComputationExpression(
						new StylePropertyNameValueCouple("sizeComputationExpression", sceExpression));
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initSizeComputationExpressionData", out.toString());
	}

	protected void method_initLabelStyleDescriptionData(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		if (parameter
				.eIsSet(VpstylecustomizationPackage.eINSTANCE.getEdgeStyleCustomization_BeginLabelStyleDescription())) {
			set_beginLabelStyleDescription(new StylePropertyNameValueCouple("beginLabelStyleDescription",
					parameter.getBeginLabelStyleDescription()));
		}

		if (parameter
				.eIsSet(VpstylecustomizationPackage.eINSTANCE.getEdgeStyleCustomization_EndLabelStyleDescription())) {
			set_endLabelStyleDescription(new StylePropertyNameValueCouple("endLabelStyleDescription",
					parameter.getEndLabelStyleDescription()));
		}

		if (parameter.eIsSet(
				VpstylecustomizationPackage.eINSTANCE.getEdgeStyleCustomization_CenterLabelStyleDescription())) {
			set_centerLabelStyleDescription(new StylePropertyNameValueCouple("centerLabelStyleDescription",
					parameter.getCenterLabelStyleDescription()));
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initLabelStyleDescriptionData", out.toString());
	}

	protected void method_initCenteredMappingsData(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (parameter
				.eIsSet(VpstylecustomizationPackage.eINSTANCE.getEdgeStyleCustomization_CenteredSourceMappings())) {
			set_centeredSourceMappings(
					new StylePropertyNameValueCouple("centeredSourceMappings", parameter.getCenteredSourceMappings()));
		}

		if (parameter
				.eIsSet(VpstylecustomizationPackage.eINSTANCE.getEdgeStyleCustomization_CenteredTargetMappings())) {
			set_centeredTargetMappings(
					new StylePropertyNameValueCouple("centeredTargetMappings", parameter.getCenteredTargetMappings()));
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initCenteredMappingsData", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.EdgeStyleCustomization parameter;

	public void set_parameter(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.EdgeStyleCustomization parameter) {
		this.parameter = parameter;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple lineStyle;

	public void set_lineStyle(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple lineStyle) {
		this.lineStyle = lineStyle;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple sourceArrow;

	public void set_sourceArrow(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple sourceArrow) {
		this.sourceArrow = sourceArrow;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple targetArrow;

	public void set_targetArrow(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple targetArrow) {
		this.targetArrow = targetArrow;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple routineStyle;

	public void set_routineStyle(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple routineStyle) {
		this.routineStyle = routineStyle;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple foldingStyle;

	public void set_foldingStyle(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple foldingStyle) {
		this.foldingStyle = foldingStyle;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple endCentering;

	public void set_endCentering(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple endCentering) {
		this.endCentering = endCentering;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple sizeComputationExpression;

	public void set_sizeComputationExpression(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple sizeComputationExpression) {
		this.sizeComputationExpression = sizeComputationExpression;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple beginLabelStyleDescription;

	public void set_beginLabelStyleDescription(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple beginLabelStyleDescription) {
		this.beginLabelStyleDescription = beginLabelStyleDescription;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple endLabelStyleDescription;

	public void set_endLabelStyleDescription(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple endLabelStyleDescription) {
		this.endLabelStyleDescription = endLabelStyleDescription;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple centerLabelStyleDescription;

	public void set_centerLabelStyleDescription(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple centerLabelStyleDescription) {
		this.centerLabelStyleDescription = centerLabelStyleDescription;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple centeredTargetMappings;

	public void set_centeredTargetMappings(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple centeredTargetMappings) {
		this.centeredTargetMappings = centeredTargetMappings;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple centeredSourceMappings;

	public void set_centeredSourceMappings(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple centeredSourceMappings) {
		this.centeredSourceMappings = centeredSourceMappings;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
