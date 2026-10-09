//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.abstracts;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.ENamedElementAnnotationHelper;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.ECoreResourceManager;

public class AbstractAssociationPattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.abstracts.ClassAbstractContentElement {

	public AbstractAssociationPattern() {
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
		method_setAbstractAssociationParameter(new StringBuffer(), ictx);
		method_setTargetEClass(new StringBuffer(), ictx);
		method_setAssociationBounds(new StringBuffer(), ictx);
		super.orchestration(new SuperOrchestrationContext(ictx));
		ictx.setNode(currentNode);
		return null;
	}

	protected void method_initContainingEClassName(final StringBuffer out, final PatternContext ctx) throws Exception {
		eClassName = ((org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class) abstractAssociation.eContainer())
				.getName();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initContainingEClassName", out.toString());
	}

	protected void method_setAbstractAssociationParameter(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		//To be implemented by derided patterns 

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setAbstractAssociationParameter", out.toString());
	}

	protected void method_setTargetEClass(final StringBuffer out, final PatternContext ctx) throws Exception {
		//To be implemented by derided patterns 

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setTargetEClass", out.toString());
	}

	protected void method_setAssociationBounds(final StringBuffer out, final PatternContext ctx) throws Exception {
		// Association cardinality

		if (abstractAssociation.getCardinality() == Cardinalities.NOTHING_OR_MANY) {
			associationLowerBound = 0;
			associationUpperBound = -1;
		} else if (abstractAssociation.getCardinality() == Cardinalities.NOTHING_OR_ONE) {
			associationLowerBound = 0;
			associationUpperBound = 1;
		} else if (abstractAssociation.getCardinality() == Cardinalities.ONE_OR_MANY) {
			associationLowerBound = 1;
			associationUpperBound = -1;
		} else if (abstractAssociation.getCardinality() == Cardinalities.ONLY_ONE) {
			associationLowerBound = 1;
			associationUpperBound = 1;
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setAssociationBounds", out.toString());
	}

	protected void method_createElement(final StringBuffer out, final PatternContext ctx) throws Exception {
		// Create the EReference

		if (containingEClass != null && targetEClass != null) {
			ref = EcoreFactory.eINSTANCE.createEReference();
			ref.setContainment(abstractAssociation.getType() == Association_Types.CONTAINMENT);
			ref.setEType(targetEClass);

			ref.setDerived(abstractAssociation.isDerived());
			ref.setOrdered(abstractAssociation.isOrdered());
			ref.setTransient(abstractAssociation.isTransient());
			ref.setUnique(abstractAssociation.isUnique());
			ref.setUnsettable(abstractAssociation.isUnsettable());
			ref.setVolatile(abstractAssociation.isVolatile());
			ref.setChangeable(abstractAssociation.isChangeable());

			ref.setLowerBound(associationLowerBound);
			ref.setUpperBound(associationUpperBound);
			ref.setName(abstractAssociation.getName());
			containingEClass.getEStructuralFeatures().add(ref);

			/* Set EReference description */
			if (abstractAssociation.getDescription() != null
					&& abstractAssociation.getDescription().trim().length() != 0) {
				ENamedElementAnnotationHelper.annotate(ref, ENamedElementAnnotationHelper.KEY_DOCUMENTATION,
						ENamedElementAnnotationHelper.ENTRY_DOCUMENTATION_KEY, abstractAssociation.getDescription(),
						true);
			}

		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createElement", out.toString());
	}

	protected void method_setAnnotationParameters(final StringBuffer out, final PatternContext ctx) throws Exception {
		annotatableElement = abstractAssociation;
		ecoreElement = ref;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setAnnotationParameters", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractAssociation abstractAssociation;

	public void set_abstractAssociation(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractAssociation abstractAssociation) {
		this.abstractAssociation = abstractAssociation;
	}

	protected java.lang.Integer associationLowerBound;

	public void set_associationLowerBound(java.lang.Integer associationLowerBound) {
		this.associationLowerBound = associationLowerBound;
	}

	protected java.lang.Integer associationUpperBound;

	public void set_associationUpperBound(java.lang.Integer associationUpperBound) {
		this.associationUpperBound = associationUpperBound;
	}

	protected org.eclipse.emf.ecore.EClass targetEClass;

	public void set_targetEClass(org.eclipse.emf.ecore.EClass targetEClass) {
		this.targetEClass = targetEClass;
	}

	protected org.eclipse.emf.ecore.EReference ref;

	public void set_ref(org.eclipse.emf.ecore.EReference ref) {
		this.ref = ref;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

}
