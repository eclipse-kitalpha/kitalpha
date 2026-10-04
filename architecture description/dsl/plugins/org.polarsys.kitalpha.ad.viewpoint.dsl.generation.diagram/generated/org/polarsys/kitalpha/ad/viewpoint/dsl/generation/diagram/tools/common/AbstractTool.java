//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools.common;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;

import org.eclipse.sirius.diagram.description.tool.ToolSection;
import org.eclipse.sirius.viewpoint.description.tool.ToolEntry;

import org.eclipse.sirius.viewpoint.description.tool.AbstractToolDescription;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Action;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.OpenAction;

public class AbstractTool
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.common.AbstractDiagramPattern {

	public AbstractTool() {
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
		method_createConcretTool(new StringBuffer(), ictx);
		method_setToolPrecondition(new StringBuffer(), ictx);
		method_addToolToToolSection(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		return null;
	}

	protected void method_createConcretTool(final StringBuffer out, final PatternContext ctx) throws Exception {
		//default content

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createConcretTool", out.toString());
	}

	protected void method_addToolToToolSection(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (dslvpToolElement != null) {
			EObject dslvpParent = dslvpToolElement.eContainer();
			EObject doremiParent = GenerationUtil.getDoremiElement(dslvpParent);

			if (doremiParent instanceof ToolSection) {
				ToolSection toolSection = (ToolSection) doremiParent;
				toolSection.getOwnedTools().add((ToolEntry) abstractToolDescription);
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "addToolToToolSection", out.toString());
	}

	protected void method_setToolPrecondition(final StringBuffer out, final PatternContext ctx) throws Exception {

		if (dslvpToolElement != null && abstractToolDescription != null) {
			String precondition = null;

			if (dslvpToolElement instanceof OpenAction) {
				precondition = ((OpenAction) dslvpToolElement).getPrecondition();
			}

			if (dslvpToolElement instanceof Action) {
				precondition = ((Action) dslvpToolElement).getPrecondition();
			}

			if (precondition != null && precondition.isEmpty() == false) {
				((AbstractToolDescription) abstractToolDescription).setPrecondition(precondition);
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setToolPrecondition", out.toString());
	}

	protected org.eclipse.emf.ecore.EObject abstractToolDescription;

	public void set_abstractToolDescription(org.eclipse.emf.ecore.EObject abstractToolDescription) {
		this.abstractToolDescription = abstractToolDescription;
	}

	protected org.eclipse.emf.ecore.EObject dslvpToolElement;

	public void set_dslvpToolElement(org.eclipse.emf.ecore.EObject dslvpToolElement) {
		this.dslvpToolElement = dslvpToolElement;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

}
