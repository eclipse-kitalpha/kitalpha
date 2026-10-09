//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools.common;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Edge;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.EdgeDomainAssociation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.EdgeDomainElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData.JavaMethodReturnType;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaServiceData;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;

import org.eclipse.sirius.viewpoint.description.tool.If;
import org.eclipse.sirius.viewpoint.description.tool.ToolFactory;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.SiriusExpressionHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.ExpressionInterpreter;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.VSMVariable;

public class AbstractEdgeDeleteTool
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools.common.AbstractDeleteTool {

	public AbstractEdgeDeleteTool() {
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
		super.orchestration(new SuperOrchestrationContext(ictx));
		method_setAssociationsValues(new StringBuffer(), ictx);
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

	protected void method_createToolOperations(final StringBuffer out, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createToolOperations", out.toString());
	}

	protected void method_createJavaService(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (generateJavaService != null && generateJavaService) {
			String r_package_name = (String) ctx.getValue("design.project.name") + ".service.tools";
			String r_class_name = "DeleteToolService";
			String java_service_name = r_package_name + "." + r_class_name;

			JavaServiceData javaServiceData = GenerationUtil.getJavaServiceData(java_service_name);
			if (javaServiceData != null) {
				javaServiceData.setContext(parameter);
				JavaMethodReturnType returnType = JavaMethodReturnType.Boolean;
				JavaMethodData javaMethodData = new JavaMethodData(tool_name, returnType);
				javaMethodData.addMethodParameter("element", "EObject", "the semantic source element");
				javaMethodData.addMethodParameter("elementView", "EObject", "the semantic element view");
				javaMethodData.addMethodParameter("containerView", "EObject", "the container view");
				javaServiceData.addMethod(javaMethodData);

				If iv = ToolFactory.eINSTANCE.createIf();
				String mParameters = "(" + VSMVariable.elementView.getInnerVariable() + ","
						+ VSMVariable.containerView.getInnerVariable() + ")";
				iv.setConditionExpression(
						SiriusExpressionHelper.getExpressoin(tool_name + mParameters, ExpressionInterpreter.Service));
				initial_operation.setFirstModelOperations(iv);
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createJavaService", out.toString());
	}

	protected org.eclipse.emf.ecore.EObject t_association;

	public void set_t_association(org.eclipse.emf.ecore.EObject t_association) {
		this.t_association = t_association;
	}

	protected org.eclipse.emf.ecore.EObject s_association;

	public void set_s_association(org.eclipse.emf.ecore.EObject s_association) {
		this.s_association = s_association;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
