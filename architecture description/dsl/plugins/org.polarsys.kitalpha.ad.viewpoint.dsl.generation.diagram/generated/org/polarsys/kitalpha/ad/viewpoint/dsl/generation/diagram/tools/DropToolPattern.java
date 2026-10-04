//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.AbstractNode;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.DiagramElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.MappingSet;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.NodeDomainElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData.JavaMethodReturnType;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaServiceData;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;

import org.eclipse.sirius.diagram.description.DragAndDropTargetDescription;
import org.eclipse.sirius.diagram.description.DiagramElementMapping;
import org.eclipse.sirius.diagram.description.tool.ContainerDropDescription;
import org.eclipse.sirius.viewpoint.description.tool.DropContainerVariable;
import org.eclipse.sirius.viewpoint.description.tool.ToolFactory;
import org.eclipse.sirius.viewpoint.description.tool.InitialContainerDropOperation;
import org.eclipse.sirius.viewpoint.description.tool.ElementDropVariable;
import org.eclipse.sirius.viewpoint.description.tool.ContainerViewVariable;
import org.eclipse.sirius.viewpoint.description.tool.ChangeContext;
import org.eclipse.sirius.viewpoint.description.tool.SetValue;
import org.eclipse.sirius.viewpoint.description.tool.Unset;
import org.eclipse.sirius.viewpoint.description.tool.If;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.SiriusExpressionHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.ExpressionInterpreter;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.VSMVariable;

import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;

public class DropToolPattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.tools.common.AbstractTool {

	public DropToolPattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Drop) parameterParameter;

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
		String s_package_name = (String) ctx.getValue("design.project.name") + ".service.tools";
		String s_class_name = "DropToolService";
		String s_service_name = s_package_name + "." + s_class_name;

		DiagramElement mapping = parameter.getTool_For();

		EObject d_mapping_container = GenerationUtil.getDoremiElement(mapping.eContainer().eContainer());

		if (!(d_mapping_container instanceof DragAndDropTargetDescription)) {
			return;
		}

		ContainerDropDescription drop = org.eclipse.sirius.diagram.description.tool.ToolFactory.eINSTANCE
				.createContainerDropDescription();
		drop.setName("Drop_" + mapping.getName());
		((DragAndDropTargetDescription) d_mapping_container).getDropDescriptions().add(drop);
		drop.getMappings().add((DiagramElementMapping) GenerationUtil.getDoremiElement(mapping));

		// Handle reusing nodes
		final ECrossReferenceAdapter eCrossReferenceAdapter = new ECrossReferenceAdapter();
		mapping.eAdapters().add(eCrossReferenceAdapter);
		final Collection<Setting> inverseReferences = eCrossReferenceAdapter.getInverseReferences(mapping);
		for (Setting setting : inverseReferences) {
			setting.getEStructuralFeature();
			final EObject doremiElement = GenerationUtil.getDoremiElement(setting.getEObject().eContainer());
			if (d_mapping_container != doremiElement && doremiElement instanceof DragAndDropTargetDescription) {
				((DragAndDropTargetDescription) doremiElement).getDropDescriptions().add(drop);
			}
		}

		DropContainerVariable _old = ToolFactory.eINSTANCE.createDropContainerVariable();
		DropContainerVariable _new = ToolFactory.eINSTANCE.createDropContainerVariable();
		ElementDropVariable element = ToolFactory.eINSTANCE.createElementDropVariable();
		ContainerViewVariable c_view = ToolFactory.eINSTANCE.createContainerViewVariable();
		InitialContainerDropOperation init = ToolFactory.eINSTANCE.createInitialContainerDropOperation();

		_old.setName("oldSemanticContainer");
		_new.setName("newSemanticContainer");
		element.setName("element");
		c_view.setName("newContainerView");

		drop.setOldContainer(_old);
		drop.setNewContainer(_new);
		drop.setElement(element);
		drop.setNewViewContainer(c_view);
		drop.setInitialOperation(init);

		ChangeContext gotoNewContainer = ToolFactory.eINSTANCE.createChangeContext();

		String pNewSemanticContainer = VSMVariable.getGenericExpressionVariable("newSemanticContainer");
		gotoNewContainer.setBrowseExpression(pNewSemanticContainer);
		init.setFirstModelOperations(gotoNewContainer);

		if (!(mapping.eContainer() instanceof MappingSet)) {
			if (mapping instanceof AbstractNode) {
				NodeDomainElement domain = ((AbstractNode) mapping).getThe_domain();
				if (domain != null) {
					if (domain.getChlidren_list() != null) {
						String ref_name = domain.getChlidren_list().getName();
						SetValue setNewContainer = ToolFactory.eINSTANCE.createSetValue();
						setNewContainer.setFeatureName(ref_name);

						String pElement = VSMVariable.element.getExpressionVariable();

						setNewContainer.setValueExpression(pElement);

						ChangeContext gotoOldContainer = ToolFactory.eINSTANCE.createChangeContext();
						String pOldSemanticContainer = VSMVariable.getGenericExpressionVariable("oldSemanticContainer");
						gotoOldContainer.setBrowseExpression(pOldSemanticContainer);

						Unset unsetOldContainer = ToolFactory.eINSTANCE.createUnset();
						unsetOldContainer.setFeatureName(ref_name);
						unsetOldContainer.setElementExpression(pElement);
						gotoOldContainer.getSubModelOperations().add(unsetOldContainer);

						gotoNewContainer.getSubModelOperations().add(setNewContainer);
						gotoNewContainer.getSubModelOperations().add(gotoOldContainer);
					} else {
						JavaServiceData javaServiceData = GenerationUtil.getJavaServiceData(s_service_name);

						if (javaServiceData != null) {
							String mappingParentName = ((DiagramElement) mapping.eContainer().eContainer()).getName();
							javaServiceData.setContext(parameter);
							String n_method_name = mappingParentName + "Drop" + mapping.getName();
							JavaMethodReturnType n_returnType = JavaMethodReturnType.Boolean;
							JavaMethodData javaMethodData = new JavaMethodData(n_method_name, n_returnType);
							javaMethodData.addMethodParameter("oldSemanticContainer", "EObject",
									"the old semantic container");
							javaMethodData.addMethodParameter("newSemanticContainer", "EObject",
									"the new semantic container");
							javaMethodData.addMethodParameter(VSMVariable.element.toString(), "EObject",
									"the semantic container of the mapping");
							javaMethodData.addMethodParameter("newContainerView", "EObject",
									"the view of the new container");

							javaServiceData.addMethod(javaMethodData);

							If d_if = ToolFactory.eINSTANCE.createIf();
							String mParameters = "(" + VSMVariable.getGenericInnerVariable("newSemanticContainer") + ","
									+ VSMVariable.element.getInnerVariable() + ","
									+ VSMVariable.getGenericInnerVariable("newContainerView") + ")";

							d_if.setConditionExpression(SiriusExpressionHelper
									.getExpressoin(n_method_name + mParameters, ExpressionInterpreter.Service));
							gotoNewContainer.getSubModelOperations().add(d_if);
						}
					}
					dslvpToolElement = parameter;
					abstractToolDescription = drop;
				}
			} else {
				// TODO: Handle the case of Edge Drop ????
			}
		}

		else {
			// TODO: Handle the case of Edge Drop ????
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createConcretTool", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Drop parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Drop parameter) {
		this.parameter = parameter;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
