//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.node;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.commondata.AbstractAssociation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.commondata.AbstractClass;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.DomainElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.ForeignExpressionElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.JavaElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.impl.ExpressionImpl;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.AbstractContainerStyle;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Condition;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.ContainerDescription;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.FlatStyle;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.ImageStyle;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Label;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.NodeDomainElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.IconPathHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.JavaElementHelper;

import org.eclipse.sirius.viewpoint.FontFormat;
import org.eclipse.sirius.diagram.description.ConditionalContainerStyleDescription;
import org.eclipse.sirius.diagram.description.style.ContainerStyleDescription;
import org.eclipse.sirius.diagram.description.DescriptionFactory;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.style.FlatContainerStyleDescription;
import org.eclipse.sirius.diagram.description.style.StyleFactory;
import org.eclipse.sirius.diagram.description.style.WorkspaceImageDescription;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.SiriusExpressionHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.ExpressionInterpreter;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.VSMVariable;

public class ContainerPattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.common.DiagramElementPattern {

	public ContainerPattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Container) parameterParameter;

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

	protected void method_setSemanticData(final StringBuffer out, final PatternContext ctx) throws Exception {
		// Gather semantic data from the vpspec model
		String className = "";
		String semanticCandidateExpression = "";
		NodeDomainElement domain = parameter.getThe_domain();
		if (domain != null) {
			// Domain class
			AbstractClass clazz = domain.getDomain_Class();
			if (clazz != null) {
				className = clazz.getFQN();
			}

			// Semantic candidate expression
			AbstractAssociation association = domain.getChlidren_list();
			if (association != null) {
				semanticCandidateExpression = SiriusExpressionHelper.getExpressoin(association.getName(),
						ExpressionInterpreter.Feature);
			} else {
				if (domain.getQuery() != null && domain.getQuery().trim().length() > 0) {
					semanticCandidateExpression = domain.getQuery();
				} else {
					if (genDefaultSemanticCandidatesExpression == null || genDefaultSemanticCandidatesExpression) {
						semanticCandidateExpression = SiriusExpressionHelper.getExpressoin("eAllContents",
								ExpressionInterpreter.Feature);
					}
				}
			}
		}

		// Set the Semantic data of the container mapping	
		ContainerMapping cm = (ContainerMapping) dContainerMapping;

		if (className.trim().length() > 0)
			cm.setDomainClass(className);

		if (semanticCandidateExpression.trim().length() > 0)
			cm.setSemanticCandidatesExpression(semanticCandidateExpression);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setSemanticData", out.toString());
	}

	protected void method_addElementToODesign(final StringBuffer out, final PatternContext ctx) throws Exception {
		EObject vpParent = parameter.eContainer().eContainer();
		EObject currentParent = GenerationUtil.getDoremiElement(vpParent);

		ContainerMapping containerMapping = (ContainerMapping) dContainerMapping;

		if (currentParent instanceof Layer) {
			// Add the generated container Mapping (dContainer) in the Layer
			Layer owner = (Layer) currentParent;
			owner.getContainerMappings().add(containerMapping);
		}

		if (currentParent instanceof ContainerMapping) {
			// Add the generated container Mapping (dContainer) in the Container Mapping
			ContainerMapping owner = (ContainerMapping) currentParent;
			owner.getSubContainerMappings().add(containerMapping);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "addElementToODesign", out.toString());
	}

	protected void method_createDoremiElement(final StringBuffer out, final PatternContext ctx) throws Exception {
		ContainerMapping cm = DescriptionFactory.eINSTANCE.createContainerMapping();
		cm.setName(parameter.getName() + "_CM");
		cm.setLabel(parameter.getName());
		cm.setChildrenPresentation(parameter.getContentLayout());
		dContainerMapping = cm;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createDoremiElement", out.toString());
	}

	protected void method_setStyle(final StringBuffer out, final PatternContext ctx) throws Exception {
		ContainerMapping cm = (ContainerMapping) dContainerMapping;

		for (ContainerDescription iContainerDescription : parameter.getStyle()) {
			Condition condition = iContainerDescription.getCondition();
			boolean conditionalStyle = false;
			ConditionalContainerStyleDescription ccStyleDesc = null;

			if (condition != null) {
				conditionalStyle = true;
				ForeignExpressionElement fEE = condition.getExpression();
				String acceleoExpression = "";
				if (fEE instanceof JavaElement) {
					// 
					String javaMethodName = ((JavaElement) fEE).getMethod();
					String mParameters = VSMVariable.view.getInnerVariable() + ","
							+ VSMVariable.container.getInnerVariable();
					javaMethodName = JavaElementHelper.addDefaultParameterToJavaMethod(javaMethodName, mParameters);
					acceleoExpression = SiriusExpressionHelper.getExpressoin(javaMethodName,
							ExpressionInterpreter.Service);
				}
				if (fEE instanceof DomainElement) {
					acceleoExpression = SiriusExpressionHelper.getExpressoin(
							((DomainElement) fEE).getAttribute().getName(), ExpressionInterpreter.Feature);
				}

				ccStyleDesc = DescriptionFactory.eINSTANCE.createConditionalContainerStyleDescription();
				ccStyleDesc.setPredicateExpression(acceleoExpression);

				cm.getConditionnalStyles().add(ccStyleDesc);
			}

			AbstractContainerStyle vpStyle = iContainerDescription.getStyle();

			ContainerStyleDescription cStyleDesc = null;

			if (vpStyle != null) {
				/************************ Case of Flat Style **************************/
				if (vpStyle instanceof FlatStyle) {
					FlatStyle vpFlatStyle = (FlatStyle) vpStyle;
					// Creation of Doremi FlatStyle for Container Mapping 
					cStyleDesc = StyleFactory.eINSTANCE.createFlatContainerStyleDescription();
					FlatContainerStyleDescription doremiFlatStyle = (FlatContainerStyleDescription) cStyleDesc;
					doremiFlatStyle.setBackgroundStyle(vpFlatStyle.getBackgroundStyle());

					doremiFlatStyle.setBackgroundColor(GenerationUtil.getSystemColor(vpFlatStyle.getBackgroundColor()));
					doremiFlatStyle.setBorderColor(GenerationUtil.getSystemColor(vpFlatStyle.getBorderColor()));
					doremiFlatStyle.setForegroundColor(GenerationUtil.getSystemColor(vpFlatStyle.getForgroundColor()));
				}

				/******************** Case of Workspace Image Style **********************/
				if (vpStyle instanceof ImageStyle) {
					ImageStyle vpImageStyle = (ImageStyle) vpStyle;
					// Creation of Doremi WorkspaceImageStyle for Container Mapping
					cStyleDesc = StyleFactory.eINSTANCE.createWorkspaceImageDescription();
					WorkspaceImageDescription doremiImageStyle = (WorkspaceImageDescription) cStyleDesc;

					doremiImageStyle.setBorderColor(GenerationUtil.getSystemColor(vpImageStyle.getBorderColor()));

					if (vpImageStyle.getImagePath() != null && vpImageStyle.getImagePath().trim().length() > 0) {
						String icon_path = IconPathHelper.computeDslIconPath(vpImageStyle.getImagePath(), parameter);
						if (icon_path != null && icon_path.trim().length() > 0) {
							doremiImageStyle.setWorkspacePath(icon_path);
							IconPathHelper.copyIconFile(vpImageStyle.getImagePath(), parameter);
						}
					}
					//doremiImageStyle.setWorkspacePath(vpImageStyle.getImagePath());
				}

				/********************** Setting Label properties ************************/
				Label label = iContainerDescription.getNode_Label();
				String labelExpression = SiriusExpressionHelper.getExpressoin("name", ExpressionInterpreter.Feature);

				if (label != null) {
					String mParameters = VSMVariable.diagram.getInnerVariable() + ","
							+ VSMVariable.view.getInnerVariable();
					((ExpressionImpl) label.getValue()).adaptValue(mParameters, true);

					if (label.getValue() != null)
						labelExpression = label.getValue().getValue();

					cStyleDesc.setLabelExpression(labelExpression);
					cStyleDesc.setLabelSize(label.getSize());
					cStyleDesc.setLabelColor(GenerationUtil.getSystemColor(label.getColor()));
					if (label.isBold())
						cStyleDesc.getLabelFormat().add(FontFormat.BOLD_LITERAL);

					if (label.isItalic())
						cStyleDesc.getLabelFormat().add(FontFormat.ITALIC_LITERAL);

				}

				cStyleDesc.setBorderSizeComputationExpression("1");

				// Add the created container style to it parent
				if (conditionalStyle)
					ccStyleDesc.setStyle(cStyleDesc);
				else
					cm.setStyle(cStyleDesc);
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setStyle", out.toString());
	}

	protected void method_setParentMapping(final StringBuffer out, final PatternContext ctx) throws Exception {
		dslvpElement = parameter;
		doremiElement = dContainerMapping;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setParentMapping", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return super.preCondition(ctx) && parameter.getImports() == null;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Container parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Container parameter) {
		this.parameter = parameter;
	}

	protected org.eclipse.emf.ecore.EObject dContainerMapping;

	public void set_dContainerMapping(org.eclipse.emf.ecore.EObject dContainerMapping) {
		this.dContainerMapping = dContainerMapping;
	}

	protected java.lang.Boolean genDefaultSemanticCandidatesExpression;

	public void set_genDefaultSemanticCandidatesExpression(java.lang.Boolean genDefaultSemanticCandidatesExpression) {
		this.genDefaultSemanticCandidatesExpression = genDefaultSemanticCandidatesExpression;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
