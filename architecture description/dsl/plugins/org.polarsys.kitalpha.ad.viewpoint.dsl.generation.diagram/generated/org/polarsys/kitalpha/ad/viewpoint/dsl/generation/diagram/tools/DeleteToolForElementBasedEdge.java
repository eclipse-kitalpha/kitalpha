//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.commondata.AbstractAssociation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Edge;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.EdgeDomainElement;

import org.eclipse.sirius.viewpoint.description.tool.ChangeContext;
import org.eclipse.sirius.viewpoint.description.tool.Unset;
import org.eclipse.sirius.viewpoint.description.tool.ToolFactory;
import org.eclipse.sirius.viewpoint.description.tool.SelectModelElementVariable;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.SiriusExpressionHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.VSMVariable;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.ExpressionKind;

public class DeleteToolForElementBasedEdge
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools.common.AbstractEdgeDeleteTool {

	public DeleteToolForElementBasedEdge() {
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

	protected void method_createToolOperations(final StringBuffer out, final PatternContext ctx) throws Exception {
		AbstractAssociation t_reference = (AbstractAssociation) t_association;
		AbstractAssociation s_reference = (AbstractAssociation) s_association;

		generateJavaService = false;

		if (t_reference != null && s_reference != null) {
			ChangeContext gotoElement = ToolFactory.eINSTANCE.createChangeContext();

			gotoElement.setBrowseExpression(VSMVariable.element.getExpressionVariable());

			initial_operation.setFirstModelOperations(gotoElement);

			//AbstractAssociation t_reference = (AbstractAssociation)t_association;
			String pElementToRemove = VSMVariable.getGenericExpressionVariable("elementsToRemove");
			if (t_reference != null) {
				String t_ref_name = t_reference.getName();
				Unset unset = ToolFactory.eINSTANCE.createUnset();
				//unset.setElementExpression(SiriusExpressionHelper.getExpressoin(pElementToRemove));
				unset.setElementExpression(pElementToRemove);
				unset.setFeatureName(t_ref_name);

				gotoElement.getSubModelOperations().add(unset);
			}

			//AbstractAssociation s_reference = (AbstractAssociation)s_association;
			if (s_reference != null) {
				String s_ref_name = s_reference.getName();
				Unset unset = ToolFactory.eINSTANCE.createUnset();
				//unset.setElementExpression(SiriusExpressionHelper.getExpressoin(pElementToRemove));
				unset.setElementExpression(pElementToRemove);
				unset.setFeatureName(s_ref_name);

				gotoElement.getSubModelOperations().add(unset);
			}
		} else {
			generateJavaService = true;
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createToolOperations", out.toString());
	}

	protected void method_createSubVariables(final StringBuffer out, final PatternContext ctx) throws Exception {
		// FIXME: [VPDiag_EXP: 01] Expression need validation

		SelectModelElementVariable select = ToolFactory.eINSTANCE.createSelectModelElementVariable();
		select.setName("elementsToRemove");

		String expression = "";
		switch (SiriusExpressionHelper.getCurrentExpressionKind()) {
		case QueryLegacy:
			expression = SiriusExpressionHelper.getExpressoin("if (sourceNode.target != targetNode.target) {")
					+ SiriusExpressionHelper.getExpressoin("sourceNode.target + targetNode.target")
					+ SiriusExpressionHelper.getExpressoin("}else{")
					+ SiriusExpressionHelper.getExpressoin("sourceNode.target")
					+ SiriusExpressionHelper.getExpressoin("}");
			break;
		case Acceleo_3_x:
			expression = "[elementView.sourceNode.eGet('target')->asSet()->including(elementView.targetNode.eGet('target'))->asOrderedSet()->asSequence()/]";

			break;
		case AQL:
			expression = "aql:Sequence{elementView.sourceNode.target, elementView.targetNode.target}->asSet()";
			break;
		}

		select.setCandidatesExpression(expression);
		select.setMessage("Select the element you want to unlink");
		elementView_del_var.getSubVariables().add(select);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createSubVariables", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return super.preCondition(ctx) && (parameter.getTool_For() != null && parameter.getTool_For() instanceof Edge
				&& (((Edge) parameter.getTool_For()).getThe_domain() instanceof EdgeDomainElement));
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
