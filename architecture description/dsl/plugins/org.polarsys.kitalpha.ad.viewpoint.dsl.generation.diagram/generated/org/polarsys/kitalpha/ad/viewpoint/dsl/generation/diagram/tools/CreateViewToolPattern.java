//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.DiagramElementMapping;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.diagram.description.tool.ContainerCreationDescription;
import org.eclipse.sirius.diagram.description.tool.CreateView;
import org.eclipse.sirius.diagram.description.tool.NodeCreationDescription;
import org.eclipse.sirius.diagram.description.tool.NodeCreationVariable;
import org.eclipse.sirius.diagram.description.tool.ToolFactory;
import org.eclipse.sirius.viewpoint.description.tool.ChangeContext;
import org.eclipse.sirius.viewpoint.description.tool.ContainerViewVariable;
import org.eclipse.sirius.viewpoint.description.tool.For;
import org.eclipse.sirius.viewpoint.description.tool.InitialNodeCreationOperation;
import org.eclipse.sirius.viewpoint.description.tool.MappingBasedToolDescription;
import org.eclipse.sirius.viewpoint.description.tool.SelectModelElementVariable;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.commondata.AbstractAssociation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.AbstractNode;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.BorderedNode;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.DiagramElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.NodeDomainElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.VpdiagramPackage;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.IconPathHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.VSMVariable;

public class CreateViewToolPattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools.common.AbstractCreationTool {

	public CreateViewToolPattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Create) parameterParameter;

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

	protected void method_createConcretTool(final StringBuffer out, final PatternContext ctx) throws Exception {
		String icon_path = null;
		if (parameter.getIcon() != null && parameter.getIcon().trim().length() > 0) {
			icon_path = IconPathHelper.computeDslIconPath(parameter.getIcon(), parameter);
			IconPathHelper.copyIconFile(parameter.getIcon(), parameter);
		}

		switch (parameter.getTool_For().eClass().getClassifierID()) {
		case VpdiagramPackage.NODE:
		case VpdiagramPackage.BORDERED_NODE:
		case VpdiagramPackage.CONTAINER:
			DiagramElement diagram_element = (DiagramElement) parameter.getTool_For();
			String mappingName = diagram_element.getName();
			AbstractNode node_mapping = (AbstractNode) parameter.getTool_For();
			NodeDomainElement nodeDomain = node_mapping.getThe_domain();
			AbstractAssociation association = nodeDomain.getChlidren_list();
			String scExpression = association != null ? "feature:" + association.getName() : nodeDomain.getQuery();

			/** Sirius variables creation */
			NodeCreationVariable v_container = ToolFactory.eINSTANCE.createNodeCreationVariable();
			v_container.setName("container");

			// Selection variable
			SelectModelElementVariable selection = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE
					.createSelectModelElementVariable();
			selection.setName("selection");
			selection.setMultiple(true);
			selection.setMessage("Select one or more model elements ...");
			selection.setCandidatesExpression(scExpression);
			v_container.getSubVariables().add(selection);

			ContainerViewVariable v_container_view = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE
					.createContainerViewVariable();
			v_container_view.setName("containerView");

			// ChangeContext creation 
			ChangeContext gotoContainer = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE
					.createChangeContext();
			String pContainer = VSMVariable.container.getExpressionVariable();
			gotoContainer.setBrowseExpression(pContainer);

			For _for = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE.createFor();
			_for.setExpression(VSMVariable.selection.getExpressionVariable());
			_for.setIteratorName(VSMVariable.i.toString());
			gotoContainer.getSubModelOperations().add(_for);

			// ChangeContext creation 
			ChangeContext gotoI = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE
					.createChangeContext();
			gotoI.setBrowseExpression(VSMVariable.i.getExpressionVariable());
			_for.getSubModelOperations().add(gotoI);
			CreateView createView = ToolFactory.eINSTANCE.createCreateView();
			createView.setVariableName("createdView");
			createView.setContainerViewExpression(VSMVariable.containerView.getExpressionVariable());
			DiagramElementMapping mapping = (DiagramElementMapping) GenerationUtil.getDoremiElement(node_mapping);
			createView.setMapping(mapping);
			gotoI.getSubModelOperations().add(createView);

			// Init creation
			InitialNodeCreationOperation init = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE
					.createInitialNodeCreationOperation();
			init.setFirstModelOperations(gotoContainer);

			// Tool creation
			MappingBasedToolDescription creationTool = null;
			String label = parameter.getLabel();
			label = label != null && !label.isEmpty() ? label : mappingName;

			if (node_mapping instanceof org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Node
					|| node_mapping instanceof BorderedNode) {
				creationTool = ToolFactory.eINSTANCE.createNodeCreationDescription();
				NodeCreationDescription nodeCreationTool = (NodeCreationDescription) creationTool;
				if (icon_path != null && !icon_path.isEmpty()) {
					nodeCreationTool.setIconPath(icon_path);
				}

				NodeMapping nm = (NodeMapping) GenerationUtil.getDoremiElement(node_mapping);
				nodeCreationTool.getNodeMappings().add(nm);
				nodeCreationTool.setName(mappingName + "ViewCreationTool");
				nodeCreationTool.setLabel(label);
				nodeCreationTool.setVariable(v_container);
				nodeCreationTool.setViewVariable(v_container_view);
				nodeCreationTool.setInitialOperation(init);
			} else {
				creationTool = ToolFactory.eINSTANCE.createContainerCreationDescription();
				ContainerCreationDescription containerCreationTool = (ContainerCreationDescription) creationTool;
				if (icon_path != null && !icon_path.isEmpty()) {
					containerCreationTool.setIconPath(icon_path);
				}

				ContainerMapping cm = (ContainerMapping) GenerationUtil.getDoremiElement(node_mapping);
				containerCreationTool.getContainerMappings().add(cm);
				containerCreationTool.setName(mappingName + "ViewCreationTool");
				containerCreationTool.setLabel(label);
				containerCreationTool.setVariable(v_container);
				containerCreationTool.setViewVariable(v_container_view);
				containerCreationTool.setInitialOperation(init);
			}

			if (creationTool != null && parameter.getIcon() != null && parameter.getIcon().trim().length() > 0) {
				// FIXME : To finish
			}

			dslvpToolElement = parameter;
			abstractToolDescription = creationTool;
			break;

		case VpdiagramPackage.EDGE:
			// No support for Edges
			break;
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createConcretTool", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return parameter.isOnlyTheView();
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
