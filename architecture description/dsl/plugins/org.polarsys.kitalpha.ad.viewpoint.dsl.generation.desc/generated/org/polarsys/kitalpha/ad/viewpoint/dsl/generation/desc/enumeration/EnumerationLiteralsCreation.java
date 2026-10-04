//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.enumeration;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Value;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Annotation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Detail;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.ECoreResourceManager;

import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

public class EnumerationLiteralsCreation
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.common.AnyVPSpecElement {

	public EnumerationLiteralsCreation() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Value) parameterParameter;

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
		method_initViewpointAndEcoreEnum(new StringBuffer(), ictx);
		method_cerateEnumerationLiterals(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("vpElement", this.parameter);
			parameters.put("eElement", this.literal);
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

	protected void method_cerateEnumerationLiterals(final StringBuffer out, final PatternContext ctx) throws Exception {
		// Create Enumeration Literal 
		final String name = parameter.getName().replaceAll("[^a-zA-Z0-9]", "_");
		final String s_literal = parameter.getLiteral();
		literal = EcoreFactory.eINSTANCE.createEEnumLiteral();
		literal.setLiteral(s_literal);
		literal.setName(name);
		literal.setValue(vpEnumeration.getOwnedValues().indexOf(parameter));
		eEnum.getELiterals().add(literal);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "cerateEnumerationLiterals", out.toString());
	}

	protected void method_initViewpointAndEcoreEnum(final StringBuffer out, final PatternContext ctx) throws Exception {
		/* Get the specified Target Class */
		vpEnumeration = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Enumeration) parameter.eContainer();

		/* Get the corresponding generated Target ECLass from the generated EPackage */
		EPackage vpsPackage = ECoreResourceManager.INSTANCE.getEPackage();
		for (EClassifier iEClassifier : vpsPackage.getEClassifiers()) {
			if (iEClassifier instanceof EEnum && iEClassifier.getName().equals(vpEnumeration.getName())) {
				eEnum = (EEnum) iEClassifier;
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initViewpointAndEcoreEnum", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return super.preCondition(ctx)
				&& parameter.eContainer() instanceof org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Enumeration;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Value parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Value parameter) {
		this.parameter = parameter;
	}

	protected org.eclipse.emf.ecore.EEnum eEnum;

	public void set_eEnum(org.eclipse.emf.ecore.EEnum eEnum) {
		this.eEnum = eEnum;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Enumeration vpEnumeration;

	public void set_vpEnumeration(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Enumeration vpEnumeration) {
		this.vpEnumeration = vpEnumeration;
	}

	protected org.eclipse.emf.ecore.EEnumLiteral literal;

	public void set_literal(org.eclipse.emf.ecore.EEnumLiteral literal) {
		this.literal = literal;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
