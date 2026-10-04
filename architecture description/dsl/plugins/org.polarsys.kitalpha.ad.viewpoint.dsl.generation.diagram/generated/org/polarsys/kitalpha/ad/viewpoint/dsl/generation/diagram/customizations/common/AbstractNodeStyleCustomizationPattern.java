//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.customizations.common;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.AbstractComputableElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.AbstractNodeStyleCustomization;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.CustomizationExpression;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.VpstylecustomizationPackage;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.DiagramExpressionUtil;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.VSMVariable;

public class AbstractNodeStyleCustomizationPattern extends
		org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.customizations.common.AbstractStyleCustomizationPattern {

	public AbstractNodeStyleCustomizationPattern() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();

		if (preCondition(ctx))
			orchestration((PatternContext) argument);

		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		super.orchestration(new SuperOrchestrationContext(ictx));
		method_initExpressionsData(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("parent", this.parent);
			parameters.put("applyOnAll", this.applyOnAll);
			parameters.put("appliedOn", this.appliedOn);
			parameters.put("stylePropertyData", this.borderSizeComputationExpression);
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
			parameters.put("stylePropertyData", this.tooltipExpression);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram/egf/VpdslSiriusDiagramGenerator.fcore#_IXiPcGdyEeWYaMtt1GGGww",
					ctx_local, parameters);
		}
		ictx.setNode(currentNode);
		return null;
	}

	protected void method_initExpressionsData(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (dslvpElement.eIsSet(VpstylecustomizationPackage.eINSTANCE
				.getAbstractNodeStyleCustomization_BorderSizeComputationExpression())) {
			AbstractNodeStyleCustomization customization = (AbstractNodeStyleCustomization) dslvpElement;
			final CustomizationExpression expression = customization.getBorderSizeComputationExpression();
			final AbstractComputableElement expressionElement = expression.getOwnedExpressionElement();
			if (expressionElement != null) {
				final String bscExpression = DiagramExpressionUtil.getAbstractComputableElementExpression(
						expressionElement, VSMVariable.view, VSMVariable.container);
				set_borderSizeComputationExpression(
						new StylePropertyNameValueCouple("borderSizeComputationExpression", bscExpression));
			}
		}

		if (dslvpElement
				.eIsSet(VpstylecustomizationPackage.eINSTANCE.getAbstractNodeStyleCustomization_TooltipExpression())) {
			AbstractNodeStyleCustomization customization = (AbstractNodeStyleCustomization) dslvpElement;
			final CustomizationExpression expression = customization.getTooltipExpression();
			final AbstractComputableElement expressionElement = expression.getOwnedExpressionElement();
			if (expressionElement != null) {
				final String ttExpression = DiagramExpressionUtil.getAbstractComputableElementExpression(
						expressionElement, VSMVariable.view, VSMVariable.container);
				set_tooltipExpression(new StylePropertyNameValueCouple("tooltipExpression", ttExpression));
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initExpressionsData", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple tooltipExpression;

	public void set_tooltipExpression(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple tooltipExpression) {
		this.tooltipExpression = tooltipExpression;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple borderSizeComputationExpression;

	public void set_borderSizeComputationExpression(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple borderSizeComputationExpression) {
		this.borderSizeComputationExpression = borderSizeComputationExpression;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

}
