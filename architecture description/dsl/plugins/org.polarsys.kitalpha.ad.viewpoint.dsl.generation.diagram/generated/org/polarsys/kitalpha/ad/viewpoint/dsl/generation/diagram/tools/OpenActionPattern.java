//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData.JavaMethodReturnType;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaServiceData;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.IconPathHelper;

import org.eclipse.sirius.viewpoint.description.tool.If;
import org.eclipse.sirius.viewpoint.description.tool.ToolDescription;
import org.eclipse.sirius.viewpoint.description.tool.ElementVariable;
import org.eclipse.sirius.viewpoint.description.tool.ElementViewVariable;
import org.eclipse.sirius.viewpoint.description.tool.ToolFactory;
import org.eclipse.sirius.viewpoint.description.tool.InitialOperation;
import org.eclipse.sirius.viewpoint.description.tool.ChangeContext;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.SiriusExpressionHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.ExpressionInterpreter;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.VSMVariable;

public class OpenActionPattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools.common.AbstractTool {

	public OpenActionPattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.OpenAction) parameterParameter;

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

	protected void method_createConcretTool(final StringBuffer out, final PatternContext ctx) throws Exception {
		ToolDescription openTool = ToolFactory.eINSTANCE.createToolDescription();

		if (parameter.getIcon() != null && parameter.getIcon().trim().length() > 0) {
			String icon_path = IconPathHelper.computeDslIconPath(parameter.getIcon(), parameter);
			if (icon_path != null && icon_path.trim().length() > 0) {
				openTool.setIconPath(icon_path);
				IconPathHelper.copyIconFile(parameter.getIcon(), parameter);
			}
		}

		openTool.setName(parameter.getName());
		openTool.setLabel(parameter.getLabel() != null ? parameter.getLabel() : parameter.getName());

		ElementVariable element = ToolFactory.eINSTANCE.createElementVariable();
		element.setName("element");
		openTool.setElement(element);

		ElementViewVariable elementView = ToolFactory.eINSTANCE.createElementViewVariable();
		elementView.setName("elementView");
		openTool.setElementView(elementView);

		InitialOperation init = ToolFactory.eINSTANCE.createInitialOperation();
		openTool.setInitialOperation(init);
		ChangeContext gotoElement = ToolFactory.eINSTANCE.createChangeContext();
		String pElement = VSMVariable.element.getExpressionVariable();
		gotoElement.setBrowseExpression(pElement);
		init.setFirstModelOperations(gotoElement);

		String s_package_name = (String) ctx.getValue("design.project.name") + ".service.tools";
		String s_class_name = "OpenActionService";
		String s_service_name = s_package_name + "." + s_class_name;

		JavaServiceData javaServiceData = GenerationUtil.getJavaServiceData(s_service_name);

		if (javaServiceData != null) {
			javaServiceData.setContext(parameter);
			String n_method_name = parameter.getName();
			JavaMethodReturnType n_returnType = JavaMethodReturnType.Boolean;
			JavaMethodData javaMethodData = new JavaMethodData(n_method_name, n_returnType);

			javaMethodData.addMethodParameter(VSMVariable.element.toString(), "EObject", "the element");
			javaMethodData.addMethodParameter("newSemanticContainer", "EObject", "the element view");
			javaServiceData.addMethod(javaMethodData);

			If d_if = ToolFactory.eINSTANCE.createIf();
			String pElementView = "(" + VSMVariable.elementView.getInnerVariable() + ")";
			d_if.setConditionExpression(
					SiriusExpressionHelper.getExpressoin(n_method_name + pElementView, ExpressionInterpreter.Service));
			gotoElement.getSubModelOperations().add(d_if);
		}

		dslvpToolElement = parameter;
		abstractToolDescription = openTool;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createConcretTool", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.OpenAction parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.OpenAction parameter) {
		this.parameter = parameter;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
