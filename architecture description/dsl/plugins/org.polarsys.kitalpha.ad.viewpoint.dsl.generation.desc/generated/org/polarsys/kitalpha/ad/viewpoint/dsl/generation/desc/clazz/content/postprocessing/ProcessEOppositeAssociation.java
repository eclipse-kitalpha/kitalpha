//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.clazz.content.postprocessing;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.EPackageHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.ECoreResourceManager;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.LocalClassAssociation;

public class ProcessEOppositeAssociation
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.common.AnyVPSpecElement {

	public ProcessEOppositeAssociation() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.LocalClassAssociation) parameterParameter;

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
		method_process(new StringBuffer(), ictx);
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

	protected void method_process(final StringBuffer out, final PatternContext ctx) throws Exception {
		EPackageHelper helper = new EPackageHelper(ECoreResourceManager.INSTANCE.getEPackage());

		LocalClassAssociation opposite = parameter.getOpposite();
		if (opposite != null) {
			//
			//Current reference
			EObject eContainer = parameter.eContainer();
			String vpClassName = ((org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class) eContainer).getName();
			EReference eReference = helper.getEReference(vpClassName, parameter.getName());

			if (eReference == null) {
				throw new RuntimeException(
						"Could not find a reference (" + parameter.getName() + " to compute its eOpposite"); //$NON-NLS-1$
			}

			//eOppoiste reference
			EObject oppositeVpClass = opposite.eContainer();
			String oppositeReferenceName = opposite.getName();
			String oppositeVpClassName = ((org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class) oppositeVpClass)
					.getName();
			EReference eOpposite = helper.getEReference(oppositeVpClassName, oppositeReferenceName);

			if (eOpposite == null) {
				throw new RuntimeException("Could not find eOpposite of reference: " + parameter.getName()); //$NON-NLS-1$
			}

			//Set references as eOpposite each other
			eReference.setEOpposite(eOpposite);

			eOpposite.setEOpposite(eReference);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "process", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.LocalClassAssociation parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.LocalClassAssociation parameter) {
		this.parameter = parameter;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
