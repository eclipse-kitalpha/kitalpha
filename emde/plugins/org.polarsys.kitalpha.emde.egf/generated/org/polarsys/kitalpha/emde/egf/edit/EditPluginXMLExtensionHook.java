//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.emde.egf.edit;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

public class EditPluginXMLExtensionHook extends org.polarsys.kitalpha.emde.egf.PluginXMLExtensionHook {

	public EditPluginXMLExtensionHook() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> genModelList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> targetPathNameList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object genModelParameter : genModelList) {
			for (Object targetPathNameParameter : targetPathNameList) {

				this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;
				this.targetPathName = (java.lang.String) targetPathNameParameter;

				if (preCondition(ctx)) {
					ctx.setNode(new Node.Container(currentNode, getClass()));
					orchestration((PatternContext) argument);

				}
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
			parameterValues.put("genModel", this.genModel);
			parameterValues.put("targetPathName", this.targetPathName);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_call_extension(final StringBuffer out, final PatternContext ctx) throws Exception {
		{
			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("root", root);
			callParameters.put("genModel", genModel);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.emde.egf/egf/eMDE_EMF_Extension.fcore#_xdtBEDA3EeCJ8qG0PlPcqA",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "call_extension", out.toString());
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("genModel", this.genModel);
		parameters.put("targetPathName", this.targetPathName);
		return parameters;
	}

}
