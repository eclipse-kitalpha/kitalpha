//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.abstracts;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.ECoreResourceManager;

public class ClassAbstractContentElement
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.common.AnyVPSpecElement {

	public ClassAbstractContentElement() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();

		if (preCondition(ctx))
			orchestration((PatternContext) argument);

		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		super.orchestration(new SuperOrchestrationContext(ictx));
		method_initContainingEClassName(new StringBuffer(), ictx);
		method_setContainingEClass(new StringBuffer(), ictx);
		method_createElement(new StringBuffer(), ictx);
		method_setAnnotationParameters(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("vpElement", this.annotatableElement);
			parameters.put("eElement", this.ecoreElement);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc/egf/vpdslECoreGenerator.fcore#_HKpWoL4sEeKDeKot98nSrA",
					ctx_local, parameters);
		}
		ictx.setNode(currentNode);
		return null;
	}

	protected void method_initContainingEClassName(final StringBuffer out, final PatternContext ctx) throws Exception {
		// To implement by derived patterns

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initContainingEClassName", out.toString());
	}

	protected void method_setContainingEClass(final StringBuffer out, final PatternContext ctx) throws Exception {
		EPackage vpsPackage = ECoreResourceManager.INSTANCE.getEPackage();

		for (EClassifier iEClassifier : vpsPackage.getEClassifiers()) {
			if (iEClassifier.getName().equals(eClassName)) {
				containingEClass = (EClass) iEClassifier;
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setContainingEClass", out.toString());
	}

	protected void method_setAnnotationParameters(final StringBuffer out, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setAnnotationParameters", out.toString());
	}

	protected void method_createElement(final StringBuffer out, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createElement", out.toString());
	}

	protected org.eclipse.emf.ecore.EClass containingEClass;

	public void set_containingEClass(org.eclipse.emf.ecore.EClass containingEClass) {
		this.containingEClass = containingEClass;
	}

	protected java.lang.String eClassName;

	public void set_eClassName(java.lang.String eClassName) {
		this.eClassName = eClassName;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AnnotatableElement annotatableElement;

	public void set_annotatableElement(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AnnotatableElement annotatableElement) {
		this.annotatableElement = annotatableElement;
	}

	protected org.eclipse.emf.ecore.ENamedElement ecoreElement;

	public void set_ecoreElement(org.eclipse.emf.ecore.ENamedElement ecoreElement) {
		this.ecoreElement = ecoreElement;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

}
