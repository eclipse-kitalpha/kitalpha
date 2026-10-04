//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.enumeration;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.ECoreResourceManager;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.ENamedElementAnnotationHelper;

import org.eclipse.emf.ecore.EcoreFactory;

public class EnumerationCreation
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.common.AnyVPSpecElement {

	public EnumerationCreation() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Enumeration) parameterParameter;

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
		method_createEnumeration(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("vpElement", this.parameter);
			parameters.put("eElement", this.generatedEEnum);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc/egf/vpdslECoreGenerator.fcore#_HKpWoL4sEeKDeKot98nSrA",
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

	protected void method_createEnumeration(final StringBuffer out, final PatternContext ctx) throws Exception {
		/************************* EClass Creation ***********************************/
		generatedEEnum = EcoreFactory.eINSTANCE.createEEnum();
		generatedEEnum.setName(parameter.getName());

		/************************* EEnum Generic Annotation *************************/
		if (parameter.getDescription() != null && parameter.getDescription().trim().length() != 0)
			ENamedElementAnnotationHelper.annotate(generatedEEnum, ENamedElementAnnotationHelper.KEY_DOCUMENTATION,
					ENamedElementAnnotationHelper.ENTRY_DOCUMENTATION_KEY, parameter.getDescription(), true);

		ECoreResourceManager.INSTANCE.getEPackage().getEClassifiers().add(generatedEEnum);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createEnumeration", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Enumeration parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Enumeration parameter) {
		this.parameter = parameter;
	}

	protected org.eclipse.emf.ecore.EEnum generatedEEnum;

	public void set_generatedEEnum(org.eclipse.emf.ecore.EEnum generatedEEnum) {
		this.generatedEEnum = generatedEEnum;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
