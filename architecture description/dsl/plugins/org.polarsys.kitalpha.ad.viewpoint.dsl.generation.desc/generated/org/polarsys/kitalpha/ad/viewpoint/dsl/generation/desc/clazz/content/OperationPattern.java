//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.clazz.content;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.ECoreResourceManager;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractType;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.LocalType;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.ExternalType;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Cardinalities;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Parameter;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Annotation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Detail;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.ViewpointClassifier;

public class OperationPattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.abstracts.ClassAbstractContentElement {

	public OperationPattern() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> operationList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object operationParameter : operationList) {

			this.operation = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Operation) operationParameter;

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
		method_getGeneratedEPackage(new StringBuffer(), ictx);
		method_setOperationType(new StringBuffer(), ictx);
		method_setOperationCardinalities(new StringBuffer(), ictx);
		method_setOperationParameters(new StringBuffer(), ictx);
		method_addEOperationToEClass(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("operation", this.operation);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_initContainingEClassName(final StringBuffer out, final PatternContext ctx) throws Exception {
		Class containerClass = (Class) operation.eContainer();

		eClassName = containerClass.getName();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initContainingEClassName", out.toString());
	}

	protected void method_createElement(final StringBuffer out, final PatternContext ctx) throws Exception {
		eOperation = EcoreFactory.eINSTANCE.createEOperation();
		eOperation.setName(operation.getName());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createElement", out.toString());
	}

	protected void method_setOperationType(final StringBuffer out, final PatternContext ctx) throws Exception {
		// get the specified type in vp desc model
		AbstractType opType = operation.getOperation_type();

		if (opType != null) {
			// The EType to compute
			EClassifier opertionEClassifierType = null;
			// Case of local type, then look for the EClass generated from the Local Type (vpspec.Class) 
			if (opType instanceof LocalType) {
				final LocalType localType = (LocalType) opType;
				final ViewpointClassifier viewpointClassifier = localType.getType();

				/* Get the corresponding generated Target ECLass from the generated EPackage */
				for (EClassifier iEClassifier : vpsPackage.getEClassifiers()) {
					if (iEClassifier.getName().equals(viewpointClassifier.getName()))
						opertionEClassifierType = iEClassifier;
				}
			}
			// Case of external type, then look for the selected EClassifier
			if (opType instanceof ExternalType) {
				ExternalType extType = (ExternalType) opType;
				opertionEClassifierType = extType.getType();
			}
			// set the generated EOperation Etype
			if (opertionEClassifierType != null)
				eOperation.setEType(opertionEClassifierType);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setOperationType", out.toString());
	}

	protected void method_setOperationCardinalities(final StringBuffer out, final PatternContext ctx) throws Exception {
		AbstractType opType = operation.getOperation_type();

		if (opType != null) {
			Cardinalities cardinalities = opType.getCardinality();
			int lower = 0;
			int upper = -1;
			switch (cardinalities) {
			case NOTHING_OR_MANY:
				break;
			case NOTHING_OR_ONE:
				upper = 1;
				break;
			case ONE_OR_MANY:
				lower = 1;
				break;
			case ONLY_ONE:
				lower = 1;
				upper = 1;
				break;
			}
			eOperation.setLowerBound(lower);
			eOperation.setUpperBound(upper);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setOperationCardinalities", out.toString());
	}

	protected void method_setOperationParameters(final StringBuffer out, final PatternContext ctx) throws Exception {
		for (Parameter iParameter : operation.getParameters()) {
			EParameter parameter = EcoreFactory.eINSTANCE.createEParameter();
			parameter.setName(iParameter.getName());

			AbstractType pAbstractType = iParameter.getParameter_type();
			if (pAbstractType != null) {
				/**
				 * Parameter Type
				 */
				// The EType to compute
				EClassifier parameterType = null;
				// Case of local type, then look for the EClass generated from the Local Type (vpspec.Class) 
				if (pAbstractType instanceof LocalType) {
					final LocalType localType = (LocalType) pAbstractType;
					final ViewpointClassifier viewpointClassifier = localType.getType();

					/* Get the corresponding generated Target ECLass from the generated EPackage */
					for (EClassifier iEClassifier : vpsPackage.getEClassifiers()) {
						if (iEClassifier.getName().equals(viewpointClassifier.getName()))
							parameterType = iEClassifier;
					}
				}
				// Case of external type, then look for the selected EClassifier
				if (pAbstractType instanceof ExternalType) {
					ExternalType extType = (ExternalType) pAbstractType;
					parameterType = extType.getType();
				}
				// set the generated EOperation Etype
				if (parameterType != null)
					parameter.setEType(parameterType);

				/**
				 * Parameter Cardinalities
				 */
				Cardinalities cardinalities = pAbstractType.getCardinality();
				int lower = 0;
				int upper = -1;
				switch (cardinalities) {
				case NOTHING_OR_MANY:
					break;
				case NOTHING_OR_ONE:
					upper = 1;
					break;
				case ONE_OR_MANY:
					lower = 1;
					break;
				case ONLY_ONE:
					lower = 1;
					upper = 1;
					break;
				}
				parameter.setLowerBound(lower);
				parameter.setUpperBound(upper);
			}

			eOperation.getEParameters().add(parameter);

			/******************************************/
			if (iParameter.getOwned_annotations().size() > 0) {
				for (Annotation iAnnotation : iParameter.getOwned_annotations()) {
					String source = iAnnotation.getSource();
					EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
					eAnnotation.setSource(source);
					if (iAnnotation.getOwned_details().size() > 0) {
						for (Detail iDetail : iAnnotation.getOwned_details()) {
							EStringToStringMapEntryImpl entry = (EStringToStringMapEntryImpl) EcoreFactory.eINSTANCE
									.create(EcorePackage.eINSTANCE.getEStringToStringMapEntry());
							entry.setKey(iDetail.getKey());
							if (iDetail.getValue() != null)
								entry.setValue(iDetail.getValue());
							eAnnotation.getDetails().add(entry);
						}
					}
					parameter.getEAnnotations().add(eAnnotation);
				}
			}
			/******************************************/
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setOperationParameters", out.toString());
	}

	protected void method_addEOperationToEClass(final StringBuffer out, final PatternContext ctx) throws Exception {
		containingEClass.getEOperations().add(eOperation);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "addEOperationToEClass", out.toString());
	}

	protected void method_setAnnotationParameters(final StringBuffer out, final PatternContext ctx) throws Exception {
		annotatableElement = operation;
		ecoreElement = eOperation;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setAnnotationParameters", out.toString());
	}

	protected void method_getGeneratedEPackage(final StringBuffer out, final PatternContext ctx) throws Exception {
		vpsPackage = ECoreResourceManager.INSTANCE.getEPackage();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getGeneratedEPackage", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Operation operation;

	public void set_operation(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Operation operation) {
		this.operation = operation;
	}

	protected org.eclipse.emf.ecore.EOperation eOperation;

	public void set_eOperation(org.eclipse.emf.ecore.EOperation eOperation) {
		this.eOperation = eOperation;
	}

	protected org.eclipse.emf.ecore.EPackage vpsPackage;

	public void set_vpsPackage(org.eclipse.emf.ecore.EPackage vpsPackage) {
		this.vpsPackage = vpsPackage;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("operation", this.operation);
		return parameters;
	}

}
