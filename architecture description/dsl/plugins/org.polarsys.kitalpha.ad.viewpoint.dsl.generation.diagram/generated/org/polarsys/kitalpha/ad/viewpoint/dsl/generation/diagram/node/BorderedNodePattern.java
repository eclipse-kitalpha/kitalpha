//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.node;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.commondata.AbstractAssociation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.commondata.AbstractClass;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.DomainElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.ForeignExpressionElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.JavaElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.impl.ExpressionImpl;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.AbstractNodeStyle;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.BasicStyle;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Condition;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.HistogramSection;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.HistogramStyle;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.ImageStyle;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Label;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.NodeDescription;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.NodeDomainElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.IconPathHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.JavaElementHelper;

import org.eclipse.sirius.diagram.description.style.GaugeCompositeStyleDescription;
import org.eclipse.sirius.diagram.description.style.GaugeSectionDescription;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.viewpoint.FontFormat;
import org.eclipse.sirius.diagram.description.ConditionalNodeStyleDescription;
import org.eclipse.sirius.diagram.description.DescriptionFactory;
import org.eclipse.sirius.diagram.description.style.NodeStyleDescription;
import org.eclipse.sirius.diagram.description.style.StyleFactory;
import org.eclipse.sirius.diagram.description.style.WorkspaceImageDescription;
import org.eclipse.sirius.diagram.description.style.BundledImageDescription;
import org.eclipse.sirius.diagram.BundledImageShape;
import org.eclipse.sirius.diagram.model.business.internal.helper.MappingHelper;
import org.eclipse.sirius.diagram.ResizeKind;
import org.eclipse.sirius.diagram.description.style.DotDescription;
import org.eclipse.sirius.diagram.description.style.EllipseNodeDescription;
import org.eclipse.sirius.diagram.description.style.LozengeNodeDescription;
import org.eclipse.sirius.diagram.description.style.NoteDescription;
import org.eclipse.sirius.diagram.description.style.SquareDescription;
import org.eclipse.sirius.viewpoint.description.SystemColor;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.SiriusExpressionHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.ExpressionInterpreter;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.VSMVariable;

public class BorderedNodePattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.common.DiagramElementPattern {

	public BorderedNodePattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.BorderedNode) parameterParameter;

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
		NodeMapping nm = DescriptionFactory.eINSTANCE.createNodeMapping();
		nm.setName(parameter.getName() + "_BNM");
		nm.setLabel(parameter.getName());
		dNodeMapping = nm;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createDoremiElement", out.toString());
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
		NodeMapping cn = (NodeMapping) dNodeMapping;

		if (className.trim().length() > 0)
			cn.setDomainClass(className);

		if (semanticCandidateExpression.trim().length() > 0)
			cn.setSemanticCandidatesExpression(semanticCandidateExpression);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setSemanticData", out.toString());
	}

	protected void method_setParentMapping(final StringBuffer out, final PatternContext ctx) throws Exception {
		dslvpElement = parameter;
		doremiElement = dNodeMapping;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setParentMapping", out.toString());
	}

	protected void method_addElementToODesign(final StringBuffer out, final PatternContext ctx) throws Exception {
		EObject vpParent = parameter.eContainer().eContainer();
		EObject currentParent = GenerationUtil.getDoremiElement(vpParent);

		NodeMapping nodeMapping = (NodeMapping) dNodeMapping;

		if (currentParent instanceof ContainerMapping) {
			// Add the generated bordered node Mapping (nodeMapping) in the Container Mapping
			ContainerMapping owner = (ContainerMapping) currentParent;
			owner.getBorderedNodeMappings().add(nodeMapping);
		}

		if (currentParent instanceof NodeMapping) {
			// Add the generated bordered node Mapping (nodeMapping) in the NodeMapping
			NodeMapping owner = (NodeMapping) currentParent;
			owner.getBorderedNodeMappings().add(nodeMapping);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "addElementToODesign", out.toString());
	}

	protected void method_setStyle(final StringBuffer out, final PatternContext ctx) throws Exception {

		NodeMapping nm = (NodeMapping) dNodeMapping;

		for (NodeDescription iNodeDescription : parameter.getStyle()) {
			Condition condition = iNodeDescription.getCondition();
			boolean conditionalStyle = false;
			ConditionalNodeStyleDescription cnStyleDesc = null;

			if (condition != null) {
				conditionalStyle = true;
				ForeignExpressionElement fEE = condition.getExpression();
				String acceleoExpression = "";
				if (fEE instanceof JavaElement) {
					String javaMethodName = ((JavaElement) fEE).getMethod();
					String mParameters = VSMVariable.view.getInnerVariable() + ","
							+ VSMVariable.container.getInnerVariable();
					javaMethodName = JavaElementHelper.addDefaultParameterToJavaMethod(javaMethodName, mParameters);
					acceleoExpression = SiriusExpressionHelper.getExpressoin(javaMethodName,
							ExpressionInterpreter.Service);
					//acceleoExpression = SiriusExpressionHelper.getExpressoin(((JavaElement) fEE).getMethod());
				}
				if (fEE instanceof DomainElement) {
					acceleoExpression = SiriusExpressionHelper
							.getExpressoin(((DomainElement) fEE).getAttribute().getName());
				}

				cnStyleDesc = DescriptionFactory.eINSTANCE.createConditionalNodeStyleDescription();
				cnStyleDesc.setPredicateExpression(acceleoExpression);

				nm.getConditionnalStyles().add(cnStyleDesc);
			}

			AbstractNodeStyle vpStyle = iNodeDescription.getStyle();

			NodeStyleDescription nStyleDesc = null;

			if (vpStyle != null) {

				/************************* Case of Basic Style ***************************/
				if (vpStyle instanceof BasicStyle) {
					BasicStyle basicStyle = (BasicStyle) vpStyle;
					SystemColor backGroundColor = GenerationUtil.getSystemColor(basicStyle.getBackgroundColor());
					//basicStyle.getBorderColor(basicStyle.getBorderColor());
					switch (basicStyle.getForm()) {
					case SQUARE:
						nStyleDesc = StyleFactory.eINSTANCE.createSquareDescription();
						((SquareDescription) nStyleDesc).setColor(backGroundColor);
						break;

					case DOT:
						nStyleDesc = StyleFactory.eINSTANCE.createDotDescription();
						((DotDescription) nStyleDesc).setBackgroundColor(backGroundColor);
						break;

					case ECLIPSE:
						nStyleDesc = StyleFactory.eINSTANCE.createEllipseNodeDescription();
						((EllipseNodeDescription) nStyleDesc).setColor(backGroundColor);
						break;

					case LOZENGE:
						nStyleDesc = StyleFactory.eINSTANCE.createLozengeNodeDescription();
						((LozengeNodeDescription) nStyleDesc).setColor(backGroundColor);
						break;

					case NOTE:
						nStyleDesc = StyleFactory.eINSTANCE.createNoteDescription();
						((NoteDescription) nStyleDesc).setColor(backGroundColor);
						break;

					case RING:
						nStyleDesc = StyleFactory.eINSTANCE.createBundledImageDescription();
						BundledImageDescription bImageRing = (BundledImageDescription) nStyleDesc;
						bImageRing.setShape(BundledImageShape.RING_LITERAL);
						((BundledImageDescription) nStyleDesc).setColor(backGroundColor);
						break;

					case STROKE:
						nStyleDesc = StyleFactory.eINSTANCE.createBundledImageDescription();
						BundledImageDescription bImageStroke = (BundledImageDescription) nStyleDesc;
						bImageStroke.setShape(BundledImageShape.STROKE_LITERAL);
						((BundledImageDescription) nStyleDesc).setColor(backGroundColor);
						break;

					case TRIANGLE:
						nStyleDesc = StyleFactory.eINSTANCE.createBundledImageDescription();
						BundledImageDescription bImageTriangle = (BundledImageDescription) nStyleDesc;
						bImageTriangle.setShape(BundledImageShape.TRIANGLE_LITERAL);
						((BundledImageDescription) nStyleDesc).setColor(backGroundColor);
						break;
					}
					nStyleDesc.setBorderColor(GenerationUtil.getSystemColor(basicStyle.getBorderColor()));
				}

				/******************** Case of Workspace Image Style **********************/
				if (vpStyle instanceof ImageStyle) {
					ImageStyle vpImageStyle = (ImageStyle) vpStyle;

					// Creation of Doremi WorkspaceImageStyle for Container Mapping
					nStyleDesc = StyleFactory.eINSTANCE.createWorkspaceImageDescription();
					WorkspaceImageDescription doremiImageStyle = (WorkspaceImageDescription) nStyleDesc;

					if (vpImageStyle.getImagePath() != null && vpImageStyle.getImagePath().trim().length() > 0) {
						String icon_path = IconPathHelper.computeDslIconPath(vpImageStyle.getImagePath(), parameter);
						if (icon_path != null && icon_path.trim().length() > 0) {
							doremiImageStyle.setWorkspacePath(icon_path);
							IconPathHelper.copyIconFile(vpImageStyle.getImagePath(), parameter);
						}
					}
					//doremiImageStyle.setWorkspacePath(vpImageStyle.getImagePath());

					doremiImageStyle.setBorderColor(GenerationUtil.getSystemColor(vpImageStyle.getBorderColor()));
				}

				/************************ Case of Histogram Style ***********************/
				if (vpStyle instanceof HistogramStyle) {
					HistogramStyle vpHistogramStyle = (HistogramStyle) vpStyle;
					// Creation of Doremi WorkspaceImageStyle for Container Mapping
					nStyleDesc = StyleFactory.eINSTANCE.createGaugeCompositeStyleDescription();
					GaugeCompositeStyleDescription doremiGaugeStyle = (GaugeCompositeStyleDescription) nStyleDesc;
					doremiGaugeStyle.setBorderColor(GenerationUtil.getSystemColor(vpHistogramStyle.getBorderColor()));
					for (HistogramSection iHistogramSection : vpHistogramStyle.getSections()) {
						GaugeSectionDescription one_section = StyleFactory.eINSTANCE.createGaugeSectionDescription();
						one_section.setBackgroundColor(
								GenerationUtil.getSystemColor(iHistogramSection.getBackgroundColor()));
						one_section.setForegroundColor(
								GenerationUtil.getSystemColor(iHistogramSection.getForgroundColor()));
						one_section.setMaxValueExpression(
								SiriusExpressionHelper.getExpressoin(iHistogramSection.getMaxValue().toString()));
						one_section.setMinValueExpression(
								SiriusExpressionHelper.getExpressoin(iHistogramSection.getMinValue().toString()));
						one_section.setValueExpression(
								SiriusExpressionHelper.getExpressoin(iHistogramSection.getValue().toString()));
						doremiGaugeStyle.getSections().add(one_section);
					}
				}

				nStyleDesc.setResizeKind(ResizeKind.NSEW_LITERAL);

				/********************** Setting Label properties ************************/
				Label label = iNodeDescription.getNode_Label();
				String labelExpression = SiriusExpressionHelper.getExpressoin("name", ExpressionInterpreter.Feature);

				if (label != null) {
					//((ExpressionImpl) label.getValue()).adaptValue();
					String mParameters = VSMVariable.diagram.getInnerVariable() + ","
							+ VSMVariable.view.getInnerVariable();
					((ExpressionImpl) label.getValue()).adaptValue(mParameters, true);

					if (label.getValue() != null)
						labelExpression = label.getValue().getValue();

					nStyleDesc.setLabelExpression(labelExpression);
					nStyleDesc.setLabelSize(label.getSize());
					nStyleDesc.setShowIcon(false);
					nStyleDesc.setLabelAlignment(iNodeDescription.getLabel_alignement());
					nStyleDesc.setLabelPosition(iNodeDescription.getLabel_position());

					nStyleDesc.setLabelColor(GenerationUtil.getSystemColor(label.getColor()));

					if (label.isBold())
						nStyleDesc.getLabelFormat().add(FontFormat.BOLD_LITERAL);

					if (label.isItalic())
						nStyleDesc.getLabelFormat().add(FontFormat.ITALIC_LITERAL);
				}

				nStyleDesc.setBorderSizeComputationExpression("1");

				// Add the created container style to it parent
				if (conditionalStyle)
					cnStyleDesc.setStyle(nStyleDesc);
				else
					nm.setStyle(nStyleDesc);
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setStyle", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return super.preCondition(ctx) && parameter.getImports() == null;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.BorderedNode parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.BorderedNode parameter) {
		this.parameter = parameter;
	}

	protected org.eclipse.emf.ecore.EObject dNodeMapping;

	public void set_dNodeMapping(org.eclipse.emf.ecore.EObject dNodeMapping) {
		this.dNodeMapping = dNodeMapping;
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
