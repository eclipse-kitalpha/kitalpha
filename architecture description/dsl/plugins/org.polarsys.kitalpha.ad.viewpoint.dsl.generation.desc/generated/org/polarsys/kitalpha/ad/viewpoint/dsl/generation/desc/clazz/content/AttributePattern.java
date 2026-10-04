//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.clazz.content;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.ECoreResourceManager;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.PlatformEClassesManager;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.ENamedElementAnnotationHelper;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Annotation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Detail;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Attribute;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractAttributeType;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.ExternalAttributeType;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.LocalAttributeType;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Value;

public class AttributePattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.abstracts.ClassAbstractContentElement {

	public AttributePattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Attribute) parameterParameter;

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

	protected void method_initContainingEClassName(final StringBuffer out, final PatternContext ctx) throws Exception {
		eClassName = ((org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class) parameter.eContainer()).getName();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initContainingEClassName", out.toString());
	}

	protected void method_setAnnotationParameters(final StringBuffer out, final PatternContext ctx) throws Exception {
		annotatableElement = parameter;
		ecoreElement = eAt;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setAnnotationParameters", out.toString());
	}

	protected void method_createElement(final StringBuffer out, final PatternContext ctx) throws Exception {
		// Attribute initialization
		final String iAtName = parameter.getName();
		eAt = EcoreFactory.eINSTANCE.createEAttribute();
		eAt.setName(iAtName);
		eAt.setDerived(parameter.isDerived());
		eAt.setOrdered(parameter.isOrdered());
		eAt.setTransient(parameter.isTransient());
		eAt.setUnique(parameter.isUnique());
		eAt.setUnsettable(parameter.isUnsettable());
		eAt.setVolatile(parameter.isVolatile());
		eAt.setChangeable(parameter.isChangeable());
		eAt.setID(parameter.isIsId());

		// Attribute Bound initialization
		int lowerBound = 0;
		int upperBound = 1;

		switch (parameter.getCardinality()) {
		case NOTHING_OR_MANY:
			upperBound = -1;
			break;
		case ONE_OR_MANY:
			lowerBound = 1;
			upperBound = -1;
			break;
		case ONLY_ONE:
			lowerBound = 1;
			break;
		case NOTHING_OR_ONE:
			break;
		}
		eAt.setLowerBound(lowerBound);
		eAt.setUpperBound(upperBound);

		// Attribute Type generation
		AbstractAttributeType abstractAttributeType = parameter.getOwned_type();
		if (abstractAttributeType instanceof LocalAttributeType) {// Handle cases of local type : vpdesc.Enumeration
			final LocalAttributeType localType = (LocalAttributeType) abstractAttributeType;
			final org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Enumeration enumeration = localType.getType();
			final String enumerationName = enumeration.getName();
			final EEnum eEnum = (EEnum) ECoreResourceManager.INSTANCE.getEPackage().getEClassifier(enumerationName);
			eAt.setEType(eEnum);
		} else {// Handle case of external type : a primitive type like EString, EInt, etc. or an EEnumerator
			final ExternalAttributeType externalType = (ExternalAttributeType) abstractAttributeType;
			final EDataType dataType = externalType.getType();
			final String dataTypeName = dataType.getName();
			if (dataTypeName.equals("EEnumerator")) {
				EEnum eEnum = EcoreFactory.eINSTANCE.createEEnum();
				eEnum.setName(iAtName + "_Type");
				for (Value iValue : parameter.getOwned_values()) {
					EEnumLiteral eEnumLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
					eEnumLiteral.setLiteral(iValue.getLiteral());
					eEnumLiteral.setName(iValue.getName().replaceAll("[^a-zA-Z0-9]", "_"));
					eEnumLiteral.setValue(parameter.getOwned_values().indexOf(iValue));
					eEnum.getELiterals().add(eEnumLiteral);
				}

				ECoreResourceManager.INSTANCE.getEPackage().getEClassifiers().add(eEnum);
				eAt.setEType(eEnum);
			} else {
				if (dataType instanceof EEnum) {
					final EEnum ptEEnum = PlatformEClassesManager.INSTANCE.getEEnumWithPlatformURI((EEnum) dataType);
					eAt.setEType(ptEEnum);
				} else {
					eAt.setEType(dataType);
				}
			}
		}

		containingEClass.getEStructuralFeatures().add(eAt);
		if (parameter.getDescription() != null && parameter.getDescription().trim().length() != 0) {
			ENamedElementAnnotationHelper.annotate(eAt, ENamedElementAnnotationHelper.KEY_DOCUMENTATION,
					ENamedElementAnnotationHelper.ENTRY_DOCUMENTATION_KEY, parameter.getDescription(), true);
		}

		/******************************************
		if (parameter.getOwned_annotations().size() > 0)
		{
			for (Annotation iAnnotation : parameter.getOwned_annotations()) 
			{
				String source = iAnnotation.getSource();
				EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				eAnnotation.setSource(source);
				if (iAnnotation.getOwned_details().size() > 0)
				{
					for (Detail iDetail : iAnnotation.getOwned_details()) 
					{
						EStringToStringMapEntryImpl entry = (EStringToStringMapEntryImpl) EcoreFactory.eINSTANCE.create(
																	EcorePackage.eINSTANCE.getEStringToStringMapEntry());
						entry.setKey(iDetail.getKey());
						if (iDetail.getValue() != null)
							entry.setValue(iDetail.getValue());
						eAnnotation.getDetails().add(entry);
					}
				}
				eAt.getEAnnotations().add(eAnnotation);
			}
		}
		******************************************/

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createElement", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Attribute parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Attribute parameter) {
		this.parameter = parameter;
	}

	protected org.eclipse.emf.ecore.EAttribute eAt;

	public void set_eAt(org.eclipse.emf.ecore.EAttribute eAt) {
		this.eAt = eAt;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
