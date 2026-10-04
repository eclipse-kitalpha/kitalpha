//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.customizations.style;

import java.util.*;

import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.sirius.diagram.description.style.EdgeStyleDescription;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.ColorUseCase;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.VpstylecustomizationPackage;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.SiriusSystemColorHelper;

import org.eclipse.sirius.viewpoint.description.SystemColor;
import org.eclipse.sirius.viewpoint.description.SystemColors;

public class ColorCustomizationPattern extends
		org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.customizations.common.AbstractStyleCustomizationPattern {

	public ColorCustomizationPattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.ColorCustomization) parameterParameter;

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
		method_initBorderColorData(new StringBuffer(), ictx);
		method_initBackgroundColorData(new StringBuffer(), ictx);
		method_initForegroundColorData(new StringBuffer(), ictx);
		method_initColorAndStrokeColorData(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parent", this.parent);
			parameters.put("applyOnAll", this.applyOnAll);
			parameters.put("appliedOn", this.appliedOn);
			parameters.put("stylePropertyData", this.borderColor);
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
			parameters.put("stylePropertyData", this.backgroundColor);
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
			parameters.put("stylePropertyData", this.foregroundColor);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram/egf/VpdslSiriusDiagramGenerator.fcore#_VpyWIGz4EeWW0teG0FdF7g",
					ctx_local, parameters);
		}
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parent", this.parent);
			parameters.put("applyOnAll", this.applyOnAll);
			parameters.put("appliedOn", this.colorAppliedOn);
			parameters.put("stylePropertyData", this.color);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram/egf/VpdslSiriusDiagramGenerator.fcore#_VpyWIGz4EeWW0teG0FdF7g",
					ctx_local, parameters);
		}
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parent", this.parent);
			parameters.put("applyOnAll", this.applyOnAll);
			parameters.put("appliedOn", this.strokeColorAppliedOn);
			parameters.put("stylePropertyData", this.strokeColor);
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

	protected void method_initBorderColorData(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (parameter.eIsSet(VpstylecustomizationPackage.eINSTANCE.getColorCustomization_Color())) {
			final ColorUseCase colorUseCase = parameter.getColorUseCase();
			if (colorUseCase.equals(ColorUseCase.BORDER)) {
				set_borderColor(new StylePropertyNameValueCouple("borderColor",
						SiriusSystemColorHelper.getSystemColorDescription(parameter.getColor().getName())));
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initBorderColorData", out.toString());
	}

	protected void method_initBackgroundColorData(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (parameter.eIsSet(VpstylecustomizationPackage.eINSTANCE.getColorCustomization_Color())) {
			final ColorUseCase colorUseCase = parameter.getColorUseCase();
			if (colorUseCase.equals(ColorUseCase.BACKGROUND)) {
				set_backgroundColor(new StylePropertyNameValueCouple("backgroundColor",
						SiriusSystemColorHelper.getSystemColorDescription(parameter.getColor().getName())));
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initBackgroundColorData", out.toString());
	}

	protected void method_initForegroundColorData(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (parameter.eIsSet(VpstylecustomizationPackage.eINSTANCE.getColorCustomization_Color())) {
			final ColorUseCase colorUseCase = parameter.getColorUseCase();
			if (colorUseCase.equals(ColorUseCase.FOREGROUND)) {
				set_foregroundColor(new StylePropertyNameValueCouple("foregroundColor",
						SiriusSystemColorHelper.getSystemColorDescription(parameter.getColor().getName())));
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initForegroundColorData", out.toString());
	}

	protected void method_initColorAndStrokeColorData(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		if (parameter.eIsSet(VpstylecustomizationPackage.eINSTANCE.getColorCustomization_Color())) {
			final ColorUseCase colorUseCase = parameter.getColorUseCase();
			if (colorUseCase.equals(ColorUseCase.COLOR)) {
				final EList<EObject> targetElements = parameter.getAppliedOn();
				final EList<EObject> targetForStokeColor = new BasicEList<EObject>();
				final EList<EObject> targetForOther = new BasicEList<EObject>();

				/** First: Extract edge element from the applied on **/
				for (EObject iTarget : targetElements) {
					if (iTarget instanceof EdgeStyleDescription) {
						targetForStokeColor.add(iTarget);
					} else {
						targetForOther.add(iTarget);
					}
				}

				/** Second: Create two StylePropertyNameValueCouple. 
				 *  One for the color customization and 
				 *  the other one for the stokeColor customization **/
				SystemColors colorEnum = parameter.getColor();
				SystemColor color = SiriusSystemColorHelper.getSystemColorDescription(colorEnum.getName());
				if (color != null) {
					set_strokeColor(new StylePropertyNameValueCouple("strokeColor", color));
					set_strokeColorAppliedOn(targetForStokeColor);

					set_color(new StylePropertyNameValueCouple("color", color));
					set_colorAppliedOn(targetForOther);
				}
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initColorAndStrokeColorData", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.ColorCustomization parameter;

	public void set_parameter(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.ColorCustomization parameter) {
		this.parameter = parameter;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple borderColor;

	public void set_borderColor(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple borderColor) {
		this.borderColor = borderColor;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple backgroundColor;

	public void set_backgroundColor(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple foregroundColor;

	public void set_foregroundColor(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple foregroundColor) {
		this.foregroundColor = foregroundColor;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple color;

	public void set_color(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple color) {
		this.color = color;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple strokeColor;

	public void set_strokeColor(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple strokeColor) {
		this.strokeColor = strokeColor;
	}

	protected java.util.List colorAppliedOn;

	public void set_colorAppliedOn(java.util.List colorAppliedOn) {
		this.colorAppliedOn = colorAppliedOn;
	}

	protected java.util.List strokeColorAppliedOn;

	public void set_strokeColorAppliedOn(java.util.List strokeColorAppliedOn) {
		this.strokeColorAppliedOn = strokeColorAppliedOn;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
