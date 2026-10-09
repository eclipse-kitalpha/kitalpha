//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.customizations.style.libs;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.sirius.viewpoint.description.DescriptionFactory;
import org.eclipse.sirius.viewpoint.description.EReferenceCustomization;

public class ReferenceStyleCustomizationPattern {

	public ReferenceStyleCustomizationPattern() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> parentList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> applyOnAllList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> appliedOnList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> stylePropertyDataList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parentParameter : parentList) {
			for (Object applyOnAllParameter : applyOnAllList) {
				for (Object appliedOnParameter : appliedOnList) {
					for (Object stylePropertyDataParameter : stylePropertyDataList) {

						this.parent = (org.eclipse.sirius.viewpoint.description.VSMElementCustomization) parentParameter;
						this.applyOnAll = (java.lang.Boolean) applyOnAllParameter;
						this.appliedOn = (java.util.List) appliedOnParameter;
						this.stylePropertyData = (org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple) stylePropertyDataParameter;

						if (preCondition(ctx)) {
							ctx.setNode(new Node.Container(currentNode, getClass()));
							orchestration((PatternContext) argument);

						}
					}
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
		method_createCustomization(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parent", this.parent);
			parameterValues.put("applyOnAll", this.applyOnAll);
			parameterValues.put("appliedOn", this.appliedOn);
			parameterValues.put("stylePropertyData", this.stylePropertyData);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_createCustomization(final StringBuffer out, final PatternContext ctx) throws Exception {
		EReferenceCustomization referenceCustomization = DescriptionFactory.eINSTANCE.createEReferenceCustomization();
		referenceCustomization.setReferenceName(stylePropertyData.getName());
		Object value = stylePropertyData.getValue();
		if (value instanceof List<?>) {
			value = ((List<?>) value).get(0);
		}
		referenceCustomization.setValue((EObject) value);
		referenceCustomization.setApplyOnAll(applyOnAll);
		if (applyOnAll == false) {
			referenceCustomization.getAppliedOn().addAll(appliedOn);
		}
		parent.getFeatureCustomizations().add(referenceCustomization);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createCustomization", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		/*return parent != null && appliedOn != null && appliedOn.isEmpty() == false && 
						(applyOnAll || (stylePropertyData != null && (stylePropertyData.getName() != null
						&& stylePropertyData.getName().isEmpty() == false && stylePropertyData.getValue() != null )));*/

		return parent != null && (applyOnAll || (appliedOn != null && appliedOn.isEmpty() == false))
				&& stylePropertyData != null && stylePropertyData.getName() != null
				&& stylePropertyData.getName().isEmpty() == false && stylePropertyData.getValue() != null;
	}

	protected org.eclipse.sirius.viewpoint.description.VSMElementCustomization parent;

	public void set_parent(org.eclipse.sirius.viewpoint.description.VSMElementCustomization parent) {
		this.parent = parent;
	}

	protected java.lang.Boolean applyOnAll;

	public void set_applyOnAll(java.lang.Boolean applyOnAll) {
		this.applyOnAll = applyOnAll;
	}

	protected java.util.List appliedOn;

	public void set_appliedOn(java.util.List appliedOn) {
		this.appliedOn = appliedOn;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple stylePropertyData;

	public void set_stylePropertyData(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StylePropertyNameValueCouple stylePropertyData) {
		this.stylePropertyData = stylePropertyData;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parent", this.parent);
		parameters.put("applyOnAll", this.applyOnAll);
		parameters.put("appliedOn", this.appliedOn);
		parameters.put("stylePropertyData", this.stylePropertyData);
		return parameters;
	}

}
