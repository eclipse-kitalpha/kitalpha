//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.common;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Annotation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Detail;

import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

public class AnnotationPattern {

	public AnnotationPattern() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> vpElementList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> eElementList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object vpElementParameter : vpElementList) {
			for (Object eElementParameter : eElementList) {

				this.vpElement = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AnnotatableElement) vpElementParameter;
				this.eElement = (org.eclipse.emf.ecore.EModelElement) eElementParameter;

				if (preCondition(ctx)) {
					ctx.setNode(new Node.Container(currentNode, getClass()));
					orchestration((PatternContext) argument);

				}
			}
		}
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		method_processAnnotation(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("vpElement", this.vpElement);
			parameterValues.put("eElement", this.eElement);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_processAnnotation(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (vpElement.getOwned_annotations().size() > 0) {
			for (Annotation iAnnotation : vpElement.getOwned_annotations()) {
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
				eElement.getEAnnotations().add(eAnnotation);
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "processAnnotation", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AnnotatableElement vpElement;

	public void set_vpElement(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AnnotatableElement vpElement) {
		this.vpElement = vpElement;
	}

	protected org.eclipse.emf.ecore.EModelElement eElement;

	public void set_eElement(org.eclipse.emf.ecore.EModelElement eElement) {
		this.eElement = eElement;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("vpElement", this.vpElement);
		parameters.put("eElement", this.eElement);
		return parameters;
	}

}
