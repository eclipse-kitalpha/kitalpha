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
import org.eclipse.sirius.viewpoint.description.tool.SetValue;
import org.eclipse.sirius.viewpoint.description.tool.ToolFactory;
import org.eclipse.sirius.viewpoint.description.tool.Unset;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.SiriusExpressionHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.VSMVariable;

public class ReconnectEdgeTarget_RelationBasedTool extends
		org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools.common.AbstractTargetEdgeReconnectionTool {

	public ReconnectEdgeTarget_RelationBasedTool() {
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
		AbstractAssociation reference = (AbstractAssociation) t_association;
		if (reference != null) {
			String ref_name = reference.getName();

			ChangeContext gotoElement = ToolFactory.eINSTANCE.createChangeContext();
			initial_operation.setFirstModelOperations(gotoElement);
			String mElement = VSMVariable.element.getExpressionVariable();
			gotoElement.setBrowseExpression(mElement);

			Unset t_unset = ToolFactory.eINSTANCE.createUnset();
			t_unset.setFeatureName(ref_name);
			String mSource = VSMVariable.source.getExpressionVariable();
			t_unset.setElementExpression(mSource);
			gotoElement.getSubModelOperations().add(t_unset);

			SetValue t_setValue = ToolFactory.eINSTANCE.createSetValue();
			t_setValue.setFeatureName(ref_name);
			String mTarget = VSMVariable.target.getExpressionVariable();
			t_setValue.setValueExpression(mTarget);
			gotoElement.getSubModelOperations().add(t_setValue);
		} else
			generate_service = true;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createToolOperations", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return super.preCondition(ctx)
				&& ((parameter.getTool_For() != null) && (parameter.getTool_For() instanceof Edge)
						&& !(((Edge) parameter.getTool_For()).getThe_domain() instanceof EdgeDomainElement));
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
