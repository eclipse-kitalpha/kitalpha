//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools.common;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Edge;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.EdgeDomainAssociation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.EdgeDomainElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData.JavaMethodReturnType;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaServiceData;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;

import org.eclipse.sirius.diagram.description.EdgeMapping;
import org.eclipse.sirius.diagram.description.tool.ReconnectEdgeDescription;
import org.eclipse.sirius.diagram.description.tool.ReconnectionKind;
import org.eclipse.sirius.diagram.description.tool.SourceEdgeCreationVariable;
import org.eclipse.sirius.diagram.description.tool.SourceEdgeViewCreationVariable;
import org.eclipse.sirius.diagram.description.tool.TargetEdgeCreationVariable;
import org.eclipse.sirius.diagram.description.tool.TargetEdgeViewCreationVariable;
import org.eclipse.sirius.diagram.description.tool.ToolFactory;
import org.eclipse.sirius.viewpoint.description.tool.ElementSelectVariable;
import org.eclipse.sirius.viewpoint.description.tool.If;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.SiriusExpressionHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.ExpressionInterpreter;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.VSMVariable;

public class AbstractEdgeReconnectionTool
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools.common.AbstractTool {

	public AbstractEdgeReconnectionTool() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.ReconnectEdge) parameterParameter;

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
		method_setEdgeReconnectionType(new StringBuffer(), ictx);
		method_setToolName(new StringBuffer(), ictx);
		method_setEdgeReconnectionType(new StringBuffer(), ictx);
		super.orchestration(new SuperOrchestrationContext(ictx));
		method_setAssociationsValues(new StringBuffer(), ictx);
		method_setJavaServiceName(new StringBuffer(), ictx);
		method_createToolOperations(new StringBuffer(), ictx);
		method_createJavaService(new StringBuffer(), ictx);
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
		ReconnectEdgeDescription reconnect = ToolFactory.eINSTANCE.createReconnectEdgeDescription();
		reconnect.setReconnectionKind(source_reconnection ? ReconnectionKind.RECONNECT_SOURCE_LITERAL
				: ReconnectionKind.RECONNECT_TARGET_LITERAL);
		reconnect.setName(tool_name);

		EObject doEdgeMapping = GenerationUtil.getDoremiElement(associated_mapping);
		((EdgeMapping) doEdgeMapping).getReconnections().add(reconnect);

		// create default variables and initial operation
		SourceEdgeCreationVariable v_source = ToolFactory.eINSTANCE.createSourceEdgeCreationVariable();
		TargetEdgeCreationVariable v_Target = ToolFactory.eINSTANCE.createTargetEdgeCreationVariable();
		SourceEdgeViewCreationVariable v_sourceView = ToolFactory.eINSTANCE.createSourceEdgeViewCreationVariable();
		TargetEdgeViewCreationVariable v_TargetView = ToolFactory.eINSTANCE.createTargetEdgeViewCreationVariable();
		ElementSelectVariable v_element = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE
				.createElementSelectVariable();
		ElementSelectVariable v_edgeView = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE
				.createElementSelectVariable();
		initial_operation = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE
				.createInitialOperation();

		// Set the names of the variable
		v_source.setName("source");
		v_Target.setName("target");
		v_sourceView.setName("sourceView");
		v_TargetView.setName("targetView");
		v_element.setName("element");
		v_edgeView.setName("edgeView");

		// Add Variables and initial to the ReconnectEdgeDescription
		reconnect.setSource(v_source);
		reconnect.setTarget(v_Target);
		reconnect.setSourceView(v_sourceView);
		reconnect.setTargetView(v_TargetView);
		reconnect.setElement(v_element);
		reconnect.setEdgeView(v_edgeView);
		reconnect.setInitialOperation(initial_operation);

		dslvpToolElement = parameter;
		abstractToolDescription = reconnect;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createConcretTool", out.toString());
	}

	protected void method_setAssociatedMapping(final StringBuffer out, final PatternContext ctx) throws Exception {
		associated_mapping = parameter.getTool_For();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setAssociatedMapping", out.toString());
	}

	protected void method_setToolName(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (parameter.getName() != null && parameter.getName().trim().length() > 0)
			tool_name = parameter.getName();
		else
			tool_name = "Reconnect_" + associated_mapping.getName();

		if (source_reconnection)
			tool_name = tool_name + "_Source";
		else
			tool_name = tool_name + "_Target";

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setToolName", out.toString());
	}

	protected void method_setEdgeReconnectionType(final StringBuffer out, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setEdgeReconnectionType", out.toString());
	}

	protected void method_setJavaServiceName(final StringBuffer out, final PatternContext ctx) throws Exception {
		String r_package_name = (String) ctx.getValue("design.project.name") + ".service.tools";
		String r_class_name = "ReconnectEdgeToolService";
		java_service_name = r_package_name + "." + r_class_name;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setJavaServiceName", out.toString());
	}

	protected void method_createToolOperations(final StringBuffer out, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createToolOperations", out.toString());
	}

	protected void method_setAssociationsValues(final StringBuffer out, final PatternContext ctx) throws Exception {
		Edge edge = (Edge) associated_mapping;
		EObject eO_Domain = edge.getThe_domain();

		EdgeDomainAssociation domain = (EdgeDomainAssociation) eO_Domain;
		t_association = domain.getTarget_Locator();
		s_association = null;
		if (domain instanceof EdgeDomainElement) {
			EdgeDomainElement domain_element = (EdgeDomainElement) domain;
			s_association = domain_element.getSource_Locator();
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setAssociationsValues", out.toString());
	}

	protected void method_createJavaService(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (generate_service != null && generate_service) {
			JavaServiceData javaServiceData = GenerationUtil.getJavaServiceData(java_service_name);
			if (javaServiceData != null) {
				javaServiceData.setContext(parameter);
				JavaMethodReturnType returnType = JavaMethodReturnType.Boolean;
				JavaMethodData javaMethodData = new JavaMethodData(tool_name, returnType);
				javaMethodData.addMethodParameter(VSMVariable.source.toString(), "EObject",
						"the semantic source element");
				javaMethodData.addMethodParameter(VSMVariable.sourceView.toString(), "EObject",
						"the source element view");
				javaMethodData.addMethodParameter(VSMVariable.target.toString(), "EObject",
						"the semantic target element");
				javaMethodData.addMethodParameter(VSMVariable.targetView.toString(), "EObject",
						"the target element view");
				javaMethodData.addMethodParameter(VSMVariable.element.toString(), "EObject",
						"the semantic element behind the edge");
				javaMethodData.addMethodParameter(VSMVariable.edgeView.toString(), "EObject", "the edge view");
				javaServiceData.addMethod(javaMethodData);

				If iv = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE.createIf();
				String mParameters = "(" + VSMVariable.sourceView.getInnerVariable() + ","
						+ VSMVariable.target.getInnerVariable() + "," + VSMVariable.targetView.getInnerVariable() + ","
						+ VSMVariable.element.getInnerVariable() + "," + VSMVariable.edgeView.getInnerVariable() + ")";
				iv.setConditionExpression(
						SiriusExpressionHelper.getExpressoin(tool_name + mParameters, ExpressionInterpreter.Service));
				initial_operation.setFirstModelOperations(iv);
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createJavaService", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.ReconnectEdge parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.ReconnectEdge parameter) {
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

	protected java.lang.Boolean source_reconnection;

	public void set_source_reconnection(java.lang.Boolean source_reconnection) {
		this.source_reconnection = source_reconnection;
	}

	protected java.lang.String java_service_name;

	public void set_java_service_name(java.lang.String java_service_name) {
		this.java_service_name = java_service_name;
	}

	protected org.eclipse.emf.ecore.EObject t_association;

	public void set_t_association(org.eclipse.emf.ecore.EObject t_association) {
		this.t_association = t_association;
	}

	protected org.eclipse.emf.ecore.EObject s_association;

	public void set_s_association(org.eclipse.emf.ecore.EObject s_association) {
		this.s_association = s_association;
	}

	protected java.lang.Boolean generate_service;

	public void set_generate_service(java.lang.Boolean generate_service) {
		this.generate_service = generate_service;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
