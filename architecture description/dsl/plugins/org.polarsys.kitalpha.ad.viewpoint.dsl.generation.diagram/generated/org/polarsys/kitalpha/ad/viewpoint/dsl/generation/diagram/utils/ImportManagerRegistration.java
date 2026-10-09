//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.utils;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.mappingimport.MappingImportAgent;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.mappingimport.MappingImportManager;

public class ImportManagerRegistration {

	public ImportManagerRegistration() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> original_mList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> imported_mList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object original_mParameter : original_mList) {
			for (Object imported_mParameter : imported_mList) {

				this.original_m = (org.eclipse.sirius.diagram.description.AbstractNodeMapping) original_mParameter;
				this.imported_m = (org.eclipse.sirius.diagram.description.AbstractNodeMapping) imported_mParameter;

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
		method_RegisterMapping(new StringBuffer(), ictx);
		method_ReuseTools(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("original_m", this.original_m);
			parameterValues.put("imported_m", this.imported_m);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_RegisterMapping(final StringBuffer out, final PatternContext ctx) throws Exception {

		MappingImportManager.getMappingImportAgentFor(imported_m).registerSpecifiedImport(original_m, imported_m);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "RegisterMapping", out.toString());
	}

	protected void method_ReuseTools(final StringBuffer out, final PatternContext ctx) throws Exception {

		MappingImportAgent.reuseTools(original_m, imported_m);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "ReuseTools", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}

	protected org.eclipse.sirius.diagram.description.AbstractNodeMapping original_m;

	public void set_original_m(org.eclipse.sirius.diagram.description.AbstractNodeMapping original_m) {
		this.original_m = original_m;
	}

	protected org.eclipse.sirius.diagram.description.AbstractNodeMapping imported_m;

	public void set_imported_m(org.eclipse.sirius.diagram.description.AbstractNodeMapping imported_m) {
		this.imported_m = imported_m;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("original_m", this.original_m);
		parameters.put("imported_m", this.imported_m);
		return parameters;
	}

}
