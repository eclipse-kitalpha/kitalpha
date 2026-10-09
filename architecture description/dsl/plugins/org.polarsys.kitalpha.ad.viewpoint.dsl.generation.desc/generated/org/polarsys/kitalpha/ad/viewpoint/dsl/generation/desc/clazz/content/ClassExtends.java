//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.clazz.content;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.common.util.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.constant.Constant;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.exception.NotExtensibleEClassException;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.helper.EMDEElementProvider;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.PlatformEClassesManager;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.helper.desc.CoreModelHelper;

import org.polarsys.kitalpha.emde.model.impl.EmdePackageImpl;

public class ClassExtends
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.abstracts.ClassAbstractPattern {

	public ClassExtends() {
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
		method_getTargetClasses(new StringBuffer(), ictx);
		method_checkIfTargetClassesAreExtensible(new StringBuffer(), ictx);
		method_AnnotateCurEClass(new StringBuffer(), ictx);
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

	protected void method_getTargetClasses(final StringBuffer out, final PatternContext ctx) throws Exception {
		//targetClasses = parameter.getExtends();

		for (EClass clazz : parameter.getExtends()) {
			EClass plateformClazz = PlatformEClassesManager.INSTANCE.getEClassesWithPlatformURI(clazz);
			if (plateformClazz != null) {
				if (targetClasses == null)
					targetClasses = new BasicEList<EObject>();

				targetClasses.add(plateformClazz);
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getTargetClasses", out.toString());
	}

	protected void method_AnnotateCurEClass(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (targetClasses == null)
			return;

		if (targetClasses.isEmpty())
			return;

		// Creation of the EAnnotation object 
		EAnnotation anotExtendedElement = EcoreFactory.eINSTANCE.createEAnnotation();
		anotExtendedElement.setSource(Constant.EXTENDTED_ELEMENT_ANNOTATION_SOURCE);
		EAnnotation anotMapping = EcoreFactory.eINSTANCE.createEAnnotation();
		anotMapping.setSource(Constant.MAPPING_ANNOTATION_SOURCE);

		// Compose the annotation details contents
		String strExtendedElement = "";
		String strMapping = "";
		for (Object iClazz : targetClasses) {
			EClass clazz = (EClass) iClazz;
			String clazzName = clazz.getName();
			strExtendedElement = strExtendedElement + " " + clazz.getEPackage().getNsURI() + Constant.URI_SEPARATOR
					+ clazzName;
			strMapping = strMapping + " " + EcoreUtil.getURI(clazz).toString();
		}

		// Creation of the Annotation details Entries			
		EStringToStringMapEntryImpl detExtendedElement = (EStringToStringMapEntryImpl) EcoreFactory.eINSTANCE
				.create(EcorePackage.eINSTANCE.getEStringToStringMapEntry());
		EStringToStringMapEntryImpl detMapping = (EStringToStringMapEntryImpl) EcoreFactory.eINSTANCE
				.create(EcorePackage.eINSTANCE.getEStringToStringMapEntry());
		detExtendedElement.setValue(strExtendedElement);
		detExtendedElement.setKey(Constant.EXTENDTED_ELEMENT_DETAIL);
		detMapping.setValue(strMapping);
		detMapping.setKey(Constant.MAPPING_DETAIL);

		anotExtendedElement.getDetails().add(detExtendedElement);
		anotMapping.getDetails().add(detMapping);

		// Annotating curEClass
		curEClass.getEAnnotations().add(anotExtendedElement);
		curEClass.getEAnnotations().add(anotMapping);

		curEClass.getESuperTypes().add(EMDEElementProvider.INSTANCE.getElementExtension());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "AnnotateCurEClass", out.toString());
	}

	protected void method_checkIfTargetClassesAreExtensible(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		if (targetClasses != null && targetClasses.size() > 0) {
			for (Object iClazz : targetClasses) {
				EClass clazz = (EClass) iClazz;
				boolean throwEception = true;

				for (EClass itClass : clazz.getEAllSuperTypes()) {
					if (itClass.getEPackage().getNsURI().equals(EmdePackageImpl.eINSTANCE.getNsURI())
							&& itClass.getClassifierID() == EmdePackageImpl.EXTENSIBLE_ELEMENT) {
						throwEception = false;
						break;
					}
				}

				if (throwEception) {
					String shortName = CoreModelHelper.getViewpointShortName(parameter);
					throw new NotExtensibleEClassException(parameter, clazz, shortName);
				}
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "checkIfTargetClassesAreExtensible", out.toString());
	}

	protected org.eclipse.emf.common.util.EList targetClasses;

	public void set_targetClasses(org.eclipse.emf.common.util.EList targetClasses) {
		this.targetClasses = targetClasses;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
