//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.abstracts;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.ECoreResourceManager;

public class ClassAbstractPattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.common.AnyVPSpecElement {

	public ClassAbstractPattern() {
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
		method_initialize(new StringBuffer(), ictx);
		super.orchestration(new SuperOrchestrationContext(ictx));
		method_getCurrentEClass(new StringBuffer(), ictx);
		method_getvpsClassName(new StringBuffer(), ictx);
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

	protected void method_initialize(final StringBuffer out, final PatternContext ctx) throws Exception {
		vpsPackage = ECoreResourceManager.INSTANCE.getEPackage();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initialize", out.toString());
	}

	protected void method_getCurrentEClass(final StringBuffer out, final PatternContext ctx) throws Exception {
		for (EClassifier iEClassifier : vpsPackage.getEClassifiers()) {
			if (iEClassifier instanceof EClass && iEClassifier.getName().equals(parameter.getName())) {
				curEClass = (EClass) iEClassifier;
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getCurrentEClass", out.toString());
	}

	protected void method_getvpsClassName(final StringBuffer out, final PatternContext ctx) throws Exception {
		vpsClassName = parameter.getName();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getvpsClassName", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class parameter) {
		this.parameter = parameter;
	}

	protected org.eclipse.emf.ecore.EClass curEClass;

	public void set_curEClass(org.eclipse.emf.ecore.EClass curEClass) {
		this.curEClass = curEClass;
	}

	protected java.lang.String vpsClassName;

	public void set_vpsClassName(java.lang.String vpsClassName) {
		this.vpsClassName = vpsClassName;
	}

	protected org.eclipse.emf.ecore.EPackage vpsPackage;

	public void set_vpsPackage(org.eclipse.emf.ecore.EPackage vpsPackage) {
		this.vpsPackage = vpsPackage;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
