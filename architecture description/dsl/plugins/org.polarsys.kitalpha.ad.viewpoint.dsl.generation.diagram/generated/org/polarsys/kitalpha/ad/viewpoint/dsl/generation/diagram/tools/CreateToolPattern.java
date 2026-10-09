//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.commondata.AbstractAssociation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.commondata.AbstractClass;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.AbstractNode;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.BorderedNode;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.DiagramElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Edge;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.EdgeDomainAssociation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.EdgeDomainElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.NodeDomainElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.VpdiagramPackage;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData.JavaMethodReturnType;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaServiceData;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.IconPathHelper;

import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.EdgeMapping;
import org.eclipse.sirius.viewpoint.description.tool.ContainerModelOperation;
import org.eclipse.sirius.diagram.description.tool.EdgeCreationDescription;
import org.eclipse.sirius.viewpoint.description.tool.InitEdgeCreationOperation;
import org.eclipse.sirius.diagram.description.tool.SourceEdgeCreationVariable;
import org.eclipse.sirius.diagram.description.tool.TargetEdgeCreationVariable;
import org.eclipse.sirius.diagram.description.tool.SourceEdgeViewCreationVariable;
import org.eclipse.sirius.diagram.description.tool.TargetEdgeViewCreationVariable;
import org.eclipse.sirius.viewpoint.description.tool.SetValue;
import org.eclipse.sirius.diagram.description.tool.ToolFactory;
import org.eclipse.sirius.diagram.description.tool.NodeCreationDescription;
import org.eclipse.sirius.diagram.description.tool.ContainerCreationDescription;
import org.eclipse.sirius.viewpoint.description.tool.InitialNodeCreationOperation;
import org.eclipse.sirius.diagram.description.tool.NodeCreationVariable;
import org.eclipse.sirius.viewpoint.description.tool.ContainerViewVariable;
import org.eclipse.sirius.viewpoint.description.tool.ChangeContext;
import org.eclipse.sirius.viewpoint.description.tool.CreateInstance;
import org.eclipse.sirius.viewpoint.description.tool.If;
import org.eclipse.sirius.viewpoint.description.tool.MappingBasedToolDescription;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.SiriusExpressionHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.ExpressionInterpreter;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.VSMVariable;

public class CreateToolPattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools.common.AbstractCreationTool {

	public CreateToolPattern() {
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
		String clazzName = "";
		String referenceName = "";
		boolean useJavaService = false;

		/***
		String s_package_name = (String) ctx.getValue("design.project.name") + ".service.tools";
		String s_class_name = "CreateToolService";
		String s_service_name = s_package_name.toLowerCase()+ "." + s_class_name;
		**/

		String vSource = VSMVariable.source.getExpressionVariable();
		String vTarget = VSMVariable.target.getExpressionVariable();

		String mParameters = "(" + VSMVariable.sourceView.getInnerVariable() + ","
				+ VSMVariable.target.getInnerVariable() + "," + VSMVariable.targetView.getInnerVariable() + ")";

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

			InitialNodeCreationOperation init = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE
					.createInitialNodeCreationOperation();
			NodeCreationVariable v_container = ToolFactory.eINSTANCE.createNodeCreationVariable();
			v_container.setName("container");
			ContainerViewVariable v_container_view = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE
					.createContainerViewVariable();
			v_container_view.setName("containerView");

			ChangeContext gotoContainer = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE
					.createChangeContext();
			String pContainer = VSMVariable.container.getExpressionVariable();
			gotoContainer.setBrowseExpression(pContainer);

			useJavaService = false;

			if (node_mapping.getThe_domain() != null) {
				NodeDomainElement nodeDomain = node_mapping.getThe_domain();

				if (nodeDomain.getDomain_Class() != null)
					clazzName = nodeDomain.getDomain_Class().getName();

				if (nodeDomain.getChlidren_list() != null)
					referenceName = nodeDomain.getChlidren_list().getName();
				else
					useJavaService = true;
			}

			if (useJavaService) {
				String n_package_name = (String) ctx.getValue("design.project.name") + ".service.tools";
				String n_class_name = "CreateToolService";
				String n_service_name = n_package_name + "." + n_class_name;

				JavaServiceData javaServiceData = GenerationUtil.getJavaServiceData(n_service_name);

				if (javaServiceData != null) {
					javaServiceData.setContext(parameter);
					String n_method_name = "CreateInstance" + node_mapping.getThe_domain().getDomain_Class().getName();
					JavaMethodReturnType n_returnType = JavaMethodReturnType.Boolean;
					JavaMethodData javaMethodData = new JavaMethodData(n_method_name, n_returnType);
					javaMethodData.addMethodParameter(VSMVariable.container.toString(), "EObject",
							"the semantic container of the new model element");
					javaMethodData.addMethodParameter(VSMVariable.containerView.toString(), "EObject",
							"the view of the semantic container");

					javaServiceData.addMethod(javaMethodData);

					If n_if = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE.createIf();
					String pContainerView = "(" + VSMVariable.containerView.getInnerVariable() + ")";
					n_if.setConditionExpression(SiriusExpressionHelper.getExpressoin(n_method_name + pContainerView,
							ExpressionInterpreter.Service));
					gotoContainer.getSubModelOperations().add(n_if);
				}
			} else {
				CreateInstance createIntance = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE
						.createCreateInstance();
				createIntance.setReferenceName(referenceName);
				createIntance.setTypeName(clazzName);
				createIntance.setVariableName("instance");
				gotoContainer.getSubModelOperations().add(createIntance);
			}

			init.setFirstModelOperations(gotoContainer);

			MappingBasedToolDescription creationTool = null;

			if (node_mapping instanceof org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Node
					|| node_mapping instanceof BorderedNode) {
				creationTool = ToolFactory.eINSTANCE.createNodeCreationDescription();
				NodeCreationDescription nodeCreationTool = (NodeCreationDescription) creationTool;
				if (icon_path != null && icon_path.trim().length() > 0) {
					nodeCreationTool.setIconPath(icon_path);
				}
				NodeMapping nm = (NodeMapping) GenerationUtil.getDoremiElement(node_mapping);
				nodeCreationTool.getNodeMappings().add(nm);
				nodeCreationTool.setName(mappingName + "CreationTool");
				if (parameter.getLabel() != null && parameter.getLabel().trim().length() > 0)
					nodeCreationTool.setLabel(parameter.getLabel());
				else
					nodeCreationTool.setLabel(mappingName);

				nodeCreationTool.setVariable(v_container);
				nodeCreationTool.setViewVariable(v_container_view);
				nodeCreationTool.setInitialOperation(init);
			} else {
				creationTool = ToolFactory.eINSTANCE.createContainerCreationDescription();
				ContainerCreationDescription containerCreationTool = (ContainerCreationDescription) creationTool;
				if (icon_path != null && icon_path.trim().length() > 0) {
					containerCreationTool.setIconPath(icon_path);
				}
				ContainerMapping cm = (ContainerMapping) GenerationUtil.getDoremiElement(node_mapping);
				containerCreationTool.getContainerMappings().add(cm);
				containerCreationTool.setName(mappingName + "CreationTool");
				if (parameter.getLabel() != null && parameter.getLabel().trim().length() > 0)
					containerCreationTool.setLabel(parameter.getLabel());
				else
					containerCreationTool.setLabel(mappingName);

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
			Edge edge_mapping = (Edge) parameter.getTool_For();
			String e_mappingName = edge_mapping.getName();

			// creation of the edge creation tool 
			EdgeCreationDescription edge_creation_tool = ToolFactory.eINSTANCE.createEdgeCreationDescription();
			if (icon_path != null && icon_path.trim().length() > 0) {
				edge_creation_tool.setIconPath(icon_path);
			}

			// Default variable creation
			InitEdgeCreationOperation e_init = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE
					.createInitEdgeCreationOperation();
			SourceEdgeCreationVariable source = ToolFactory.eINSTANCE.createSourceEdgeCreationVariable();
			source.setName("source");
			TargetEdgeCreationVariable target = ToolFactory.eINSTANCE.createTargetEdgeCreationVariable();
			target.setName("target");
			SourceEdgeViewCreationVariable source_view = ToolFactory.eINSTANCE.createSourceEdgeViewCreationVariable();
			source_view.setName("sourceView");
			TargetEdgeViewCreationVariable target_view = ToolFactory.eINSTANCE.createTargetEdgeViewCreationVariable();
			target_view.setName("targetView");

			// Setting the edge creation tool parameters 

			// Mapping
			EdgeMapping em = (EdgeMapping) GenerationUtil.getDoremiElement(edge_mapping);
			edge_creation_tool.getEdgeMappings().add(em);
			// ID and Label
			edge_creation_tool.setName(e_mappingName);
			if (parameter.getLabel() != null && parameter.getLabel().trim().length() > 0)
				edge_creation_tool.setLabel(parameter.getLabel());
			else
				edge_creation_tool.setLabel(e_mappingName);

			// Default variable and initial Operation
			edge_creation_tool.setSourceVariable(source);
			edge_creation_tool.setSourceViewVariable(source_view);
			edge_creation_tool.setTargetVariable(target);
			edge_creation_tool.setTargetViewVariable(target_view);
			edge_creation_tool.setInitialOperation(e_init);

			AbstractAssociation target_asso = null;
			AbstractAssociation source_asso = null;
			AbstractClass clazz = null;

			if (edge_mapping.getThe_domain() != null) {
				// Gather informations
				target_asso = ((EdgeDomainAssociation) edge_mapping.getThe_domain()).getTarget_Locator();

				if (edge_mapping.getThe_domain() instanceof EdgeDomainElement) {
					source_asso = ((EdgeDomainElement) edge_mapping.getThe_domain()).getSource_Locator();
					clazz = ((EdgeDomainElement) edge_mapping.getThe_domain()).getThe_Domain();
					//element_container = ((EdgeDomainElement) edge_mapping.getThe_domain()).getElement_container();

					String e_package_name = (String) ctx.getValue("design.project.name") + ".service.tools";
					String e_class_name = "CreateToolService";
					String e_service_name = e_package_name.toLowerCase() + "." + e_class_name;
					JavaServiceData javaServiceData = GenerationUtil.getJavaServiceData(e_service_name);

					if (javaServiceData != null) {
						javaServiceData.setContext(parameter);
						// Java method creation
						String e_method_name = "create" + clazz.getName() + "Instance";
						JavaMethodReturnType n_returnType = JavaMethodReturnType.Boolean;
						JavaMethodData javaMethodData = new JavaMethodData(e_method_name, n_returnType);
						javaMethodData.addMethodParameter(VSMVariable.source.toString(), "EObject",
								"the semantic source element");
						javaMethodData.addMethodParameter(VSMVariable.sourceView.toString(), "EObject",
								"the semantic source view");
						javaMethodData.addMethodParameter(VSMVariable.target.toString(), "EObject",
								"the semantic target element");
						javaMethodData.addMethodParameter(VSMVariable.targetView.toString(), "EObject",
								"the semantic target view");

						javaServiceData.addMethod(javaMethodData);

						ChangeContext gotoElementContainer = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE
								.createChangeContext();
						gotoElementContainer.setBrowseExpression(vSource);

						If iv = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE.createIf();
						iv.setConditionExpression(SiriusExpressionHelper.getExpressoin(e_method_name + mParameters,
								ExpressionInterpreter.Service));

						gotoElementContainer.getSubModelOperations().add(iv);
						e_init.setFirstModelOperations(gotoElementContainer);

						// Create operations
						/**
						if (clazz != null) 
						{
							CreateInstance createElement = ToolFactory.eINSTANCE.createCreateInstance();
							//createElement.setReferenceName(element_container.getName());
							createElement.setTypeName(clazz.getName());
							createElement.setVariableName("element");
						
							ChangeContext gotoElement = ToolFactory.eINSTANCE.createChangeContext();
							String vElement = VSMVariable.element.getExpressionVariable();
							gotoElement.setBrowseExpression(vElement);
						
							if (source_asso != null) 
							{
								SetValue setSource = ToolFactory.eINSTANCE.createSetValue();
								setSource.setFeatureName(source_asso.getName());
								setSource.setValueExpression(vSource);
								//------------------------------------------------
								gotoElement.getSubModelOperations().add(setSource);
							} 
							else 
							{
								String sourceMethodName = "set"+clazz.getName() + "SemanticSourceElement";
								JavaMethodData getSemanticSourceElementMethodData = new JavaMethodData(sourceMethodName, n_returnType);
								getSemanticSourceElementMethodData.addMethodParameter(VSMVariable.source.toString(),"EObject", "the semantic source element");
								getSemanticSourceElementMethodData.addMethodParameter(VSMVariable.sourceView.toString(),"EObject", "the semantic source view");
								getSemanticSourceElementMethodData.addMethodParameter(VSMVariable.target.toString(),"EObject", "the semantic target element");
								getSemanticSourceElementMethodData.addMethodParameter(VSMVariable.targetView.toString(),"EObject", "the semantic target view");
						
								javaServiceData.addMethod(getSemanticSourceElementMethodData);
								
								If source_if = (If) ToolFactory.eINSTANCE.createIf();
								source_if.setConditionExpression(SiriusExpressionHelper.getExpressoin(sourceMethodName+ mParameters, ExpressionInterpreter.Service));
								gotoElement.getSubModelOperations().add(source_if);
							}
						
							if (target_asso != null )
							{
								SetValue setTarget = ToolFactory.eINSTANCE.createSetValue();
								setTarget.setFeatureName(target_asso.getName());
								setTarget.setValueExpression(vTarget);
								//------------------------------------------------
								gotoElement.getSubModelOperations().add(setTarget);
							}
							else
							{
								String targetMethodName = "set"+clazz.getName() + "SemanticTargetElement";
								JavaMethodData getSemanticTargetElementMethodData = new JavaMethodData(targetMethodName, n_returnType);
								getSemanticTargetElementMethodData.addMethodParameter(VSMVariable.source.toString(),"EObject", "the semantic source element");
								getSemanticTargetElementMethodData.addMethodParameter(VSMVariable.sourceView.toString(),"EObject", "the semantic source view");
								getSemanticTargetElementMethodData.addMethodParameter(VSMVariable.target.toString(),"EObject", "the semantic target element");
								getSemanticTargetElementMethodData.addMethodParameter(VSMVariable.targetView.toString(),"EObject", "the semantic target view");
						
								javaServiceData.addMethod(getSemanticTargetElementMethodData);
								
								If target_if = (If) ToolFactory.eINSTANCE.createIf();
								target_if.setConditionExpression(SiriusExpressionHelper.getExpressoin(targetMethodName+ mParameters, ExpressionInterpreter.Service));
								gotoElement.getSubModelOperations().add(target_if);
							}
						
							createElement.getSubModelOperations().add(gotoElement);
							gotoElementContainer.getSubModelOperations().add(createElement);
							e_init.setFirstModelOperations(gotoElementContainer);
						} */
					}
				} else {
					ChangeContext gotoSource = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE
							.createChangeContext();
					gotoSource.setBrowseExpression(vSource);
					ContainerModelOperation operation = null;

					if (target_asso != null) {
						operation = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE
								.createSetValue();
						SetValue setValue = (SetValue) operation;
						setValue.setFeatureName(target_asso.getName());
						setValue.setValueExpression(vTarget);
					} else {
						String e_package_name = (String) ctx.getValue("design.project.name") + ".service.tools";
						String e_class_name = "CreateToolService";
						String e_service_name = e_package_name.toLowerCase() + "." + e_class_name;

						JavaServiceData javaServiceData = GenerationUtil.getJavaServiceData(e_service_name);

						if (javaServiceData != null) {
							javaServiceData.setContext(parameter);
							String e_method_name = parameter.getName() + "CreationHelper";
							JavaMethodReturnType n_returnType = JavaMethodReturnType.Boolean;
							JavaMethodData javaMethodData = new JavaMethodData(e_method_name, n_returnType);

							javaMethodData.addMethodParameter(VSMVariable.source.toString(), "EObject",
									"the semantic source element");
							javaMethodData.addMethodParameter(VSMVariable.sourceView.toString(), "EObject",
									"the semantic source view");
							javaMethodData.addMethodParameter(VSMVariable.target.toString(), "EObject",
									"the semantic target element");
							javaMethodData.addMethodParameter(VSMVariable.targetView.toString(), "EObject",
									"the semantic target view");

							javaServiceData.addMethod(javaMethodData);

							operation = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE.createIf();
							If n_if = (If) operation;
							n_if.setConditionExpression(SiriusExpressionHelper
									.getExpressoin(e_method_name + mParameters, ExpressionInterpreter.Service));
						}
					}

					gotoSource.getSubModelOperations().add(operation);
					e_init.setFirstModelOperations(gotoSource);
				}
			}

			dslvpToolElement = parameter;
			abstractToolDescription = edge_creation_tool;
			break;
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createConcretTool", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return !parameter.isOnlyTheView();
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
