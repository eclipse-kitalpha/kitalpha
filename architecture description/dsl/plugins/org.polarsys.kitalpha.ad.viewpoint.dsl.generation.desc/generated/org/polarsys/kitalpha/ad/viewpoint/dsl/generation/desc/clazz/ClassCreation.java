//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.clazz;

import java.util.*;

import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.eclipse.emf.ecore.EcoreFactory;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.ECoreResourceManager;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.ENamedElementAnnotationHelper;

public class ClassCreation
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.abstracts.ClassAbstractPattern {

	public ClassCreation() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class) parameterParameter;

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
		method_createClass(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("vpElement", this.parameter);
			parameters.put("eElement", this.generatedEClass);
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

	protected void method_createClass(final StringBuffer out, final PatternContext ctx) throws Exception {
		/************************* EClass Creation ***********************************/
		generatedEClass = EcoreFactory.eINSTANCE.createEClass();
		generatedEClass.setName(vpsClassName);
		generatedEClass.setAbstract(parameter.isAbstract());

		/************************* EClass Generic Annotation *************************/

		if (parameter.getDescription() != null && parameter.getDescription().trim().length() != 0)
			ENamedElementAnnotationHelper.annotate(generatedEClass, ENamedElementAnnotationHelper.KEY_DOCUMENTATION,
					ENamedElementAnnotationHelper.ENTRY_DOCUMENTATION_KEY, parameter.getDescription(), true);

		ECoreResourceManager.INSTANCE.getEPackage().getEClassifiers().add(generatedEClass);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createClass", out.toString());
	}

	protected org.eclipse.emf.ecore.EClass generatedEClass;

	public void set_generatedEClass(org.eclipse.emf.ecore.EClass generatedEClass) {
		this.generatedEClass = generatedEClass;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
