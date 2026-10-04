//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.helper.desc.CoreModelHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.ActionSet;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;

import org.eclipse.sirius.diagram.description.tool.ToolFactory;
import org.eclipse.sirius.diagram.description.tool.ToolSection;
import org.eclipse.sirius.diagram.description.Layer;

public class SectionTool extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.common.DoremiElementPattern {

	public SectionTool() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.ActionSet) parameterParameter;

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

	protected void method_createDoremiElement(final StringBuffer out, final PatternContext ctx) throws Exception {
		ToolSection section = ToolFactory.eINSTANCE.createToolSection();
		section.setName(CoreModelHelper.getViewpointShortName(parameter));
		section.setLabel(CoreModelHelper.getViewpointShortName(parameter));
		sectionObject = section;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createDoremiElement", out.toString());
	}

	protected void method_addElementToODesign(final StringBuffer out, final PatternContext ctx) throws Exception {
		EObject vpParent = parameter.eContainer();
		EObject currentParent = GenerationUtil.getDoremiElement(vpParent);

		ToolSection section = (ToolSection) sectionObject;

		if (currentParent instanceof Layer) {
			// Add the generated container Mapping (dContainer) in the Layer
			Layer owner = (Layer) currentParent;
			owner.getToolSections().add(section);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "addElementToODesign", out.toString());
	}

	protected void method_setParentMapping(final StringBuffer out, final PatternContext ctx) throws Exception {
		doremiElement = sectionObject;
		dslvpElement = parameter;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setParentMapping", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		final ActionSet actionSet = (ActionSet) parameter;
		final boolean hasActions = actionSet.getActions().isEmpty() == false
				|| actionSet.getOpenActions().isEmpty() == false;
		return super.preCondition(ctx) && hasActions;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.ActionSet parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.ActionSet parameter) {
		this.parameter = parameter;
	}

	protected org.eclipse.emf.ecore.EObject sectionObject;

	public void set_sectionObject(org.eclipse.emf.ecore.EObject sectionObject) {
		this.sectionObject = sectionObject;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
