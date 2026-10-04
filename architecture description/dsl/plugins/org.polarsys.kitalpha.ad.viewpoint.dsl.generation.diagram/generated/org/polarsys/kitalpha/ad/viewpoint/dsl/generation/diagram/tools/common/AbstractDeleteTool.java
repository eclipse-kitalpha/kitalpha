//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools.common;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;

import org.eclipse.sirius.viewpoint.description.tool.ToolFactory;
import org.eclipse.sirius.diagram.description.DiagramElementMapping;

public class AbstractDeleteTool
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools.common.AbstractTool {

	public AbstractDeleteTool() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Delete) parameterParameter;

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
		method_setAssociatedMapping(new StringBuffer(), ictx);
		method_setToolName(new StringBuffer(), ictx);
		super.orchestration(new SuperOrchestrationContext(ictx));
		method_createSubVariables(new StringBuffer(), ictx);
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

	protected void method_setToolName(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (parameter.getName() != null && parameter.getName().trim().length() > 0)
			tool_name = parameter.getName();
		else
			tool_name = "Delete_" + associated_mapping.getName();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setToolName", out.toString());
	}

	protected void method_setAssociatedMapping(final StringBuffer out, final PatternContext ctx) throws Exception {
		associated_mapping = parameter.getTool_For();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setAssociatedMapping", out.toString());
	}

	protected void method_createConcretTool(final StringBuffer out, final PatternContext ctx) throws Exception {
		delete_tool = org.eclipse.sirius.diagram.description.tool.ToolFactory.eINSTANCE
				.createDeleteElementDescription();
		delete_tool.setName(tool_name + "_ID");
		delete_tool.setLabel(tool_name);

		element_del_var = ToolFactory.eINSTANCE.createElementDeleteVariable();
		element_del_var.setName("element");

		EObject doEdgeMapping = GenerationUtil.getDoremiElement(associated_mapping);
		((DiagramElementMapping) doEdgeMapping).setDeletionDescription(delete_tool);

		elementView_del_var = ToolFactory.eINSTANCE.createElementDeleteVariable();
		elementView_del_var.setName("elementView");

		containerView_del_var = ToolFactory.eINSTANCE.createContainerViewVariable();
		containerView_del_var.setName("containerView");

		initial_operation = ToolFactory.eINSTANCE.createInitialOperation();

		delete_tool.setContainerView(containerView_del_var);
		delete_tool.setElement(element_del_var);
		delete_tool.setElementView(elementView_del_var);
		delete_tool.setInitialOperation(initial_operation);

		dslvpToolElement = parameter;
		abstractToolDescription = delete_tool;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createConcretTool", out.toString());
	}

	protected void method_createSubVariables(final StringBuffer out, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createSubVariables", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Delete parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Delete parameter) {
		this.parameter = parameter;
	}

	protected org.eclipse.sirius.viewpoint.description.tool.InitialOperation initial_operation;

	public void set_initial_operation(
			org.eclipse.sirius.viewpoint.description.tool.InitialOperation initial_operation) {
		this.initial_operation = initial_operation;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.DiagramElement associated_mapping;

	public void set_associated_mapping(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.DiagramElement associated_mapping) {
		this.associated_mapping = associated_mapping;
	}

	protected java.lang.String tool_name;

	public void set_tool_name(java.lang.String tool_name) {
		this.tool_name = tool_name;
	}

	protected org.eclipse.sirius.viewpoint.description.tool.ElementDeleteVariable element_del_var;

	public void set_element_del_var(
			org.eclipse.sirius.viewpoint.description.tool.ElementDeleteVariable element_del_var) {
		this.element_del_var = element_del_var;
	}

	protected org.eclipse.sirius.viewpoint.description.tool.ElementDeleteVariable elementView_del_var;

	public void set_elementView_del_var(
			org.eclipse.sirius.viewpoint.description.tool.ElementDeleteVariable elementView_del_var) {
		this.elementView_del_var = elementView_del_var;
	}

	protected org.eclipse.sirius.viewpoint.description.tool.ContainerViewVariable containerView_del_var;

	public void set_containerView_del_var(
			org.eclipse.sirius.viewpoint.description.tool.ContainerViewVariable containerView_del_var) {
		this.containerView_del_var = containerView_del_var;
	}

	protected org.eclipse.sirius.diagram.description.tool.DeleteElementDescription delete_tool;

	public void set_delete_tool(org.eclipse.sirius.diagram.description.tool.DeleteElementDescription delete_tool) {
		this.delete_tool = delete_tool;
	}

	protected java.lang.Boolean generateJavaService;

	public void set_generateJavaService(java.lang.Boolean generateJavaService) {
		this.generateJavaService = generateJavaService;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
