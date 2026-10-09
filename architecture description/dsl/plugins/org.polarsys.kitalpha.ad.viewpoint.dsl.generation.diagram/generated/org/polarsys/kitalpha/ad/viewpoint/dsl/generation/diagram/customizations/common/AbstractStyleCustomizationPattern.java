//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.customizations.common;

import java.util.*;

import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;
import org.eclipse.emf.common.util.*;

import org.eclipse.sirius.viewpoint.description.VSMElementCustomization;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.AbstractCustomization;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.Customizations;

public class AbstractStyleCustomizationPattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.common.DiagramElementPattern {

	public AbstractStyleCustomizationPattern() {
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
		method_initEnumHelperJavaServiceData(new StringBuffer(), ictx);
		method_initializeCommonStyleData(new StringBuffer(), ictx);
		method_initializeCustomStyleData(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		return null;
	}

	protected void method_initializeCommonStyleData(final StringBuffer out, final PatternContext ctx) throws Exception {
		final EObject eContainer = dslvpElement.eContainer();
		final EObject doremiElement2 = GenerationUtil.getDoremiElement(eContainer);
		if (doremiElement2 instanceof VSMElementCustomization)
			parent = (VSMElementCustomization) doremiElement2;

		AbstractCustomization abstractCustomization = (AbstractCustomization) dslvpElement;
		/** Set the Apply on all variable **/
		set_applyOnAll(abstractCustomization.isApplyonAll());

		/** Set the Applied on  variable **/
		final EStructuralFeature appliedOnEReference = abstractCustomization.eClass()
				.getEStructuralFeature("appliedOn");
		final Object appliedOnValue = abstractCustomization.eGet(appliedOnEReference);
		if (appliedOnValue instanceof EList<?>) {
			set_appliedOn((List<?>) appliedOnValue);
		} else {
			List<Object> newList = new BasicEList<Object>();
			newList.add(appliedOnValue);
			set_appliedOn(newList);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initializeCommonStyleData", out.toString());
	}

	protected void method_initializeCustomStyleData(final StringBuffer out, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initializeCustomStyleData", out.toString());
	}

	protected void method_initEnumHelperJavaServiceData(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		EObject customizations = dslvpElement.eContainer().eContainer();
		if (customizations != null && customizations instanceof Customizations)
			enumHelperJavaServiceData = GenerationUtil.getJavaServiceDataFor(customizations);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initEnumHelperJavaServiceData", out.toString());
	}

	protected java.util.List appliedOn;

	public void set_appliedOn(java.util.List appliedOn) {
		this.appliedOn = appliedOn;
	}

	protected java.lang.Boolean applyOnAll;

	public void set_applyOnAll(java.lang.Boolean applyOnAll) {
		this.applyOnAll = applyOnAll;
	}

	protected org.eclipse.sirius.viewpoint.description.VSMElementCustomization parent;

	public void set_parent(org.eclipse.sirius.viewpoint.description.VSMElementCustomization parent) {
		this.parent = parent;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaServiceData enumHelperJavaServiceData;

	public void set_enumHelperJavaServiceData(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaServiceData enumHelperJavaServiceData) {
		this.enumHelperJavaServiceData = enumHelperJavaServiceData;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

}
