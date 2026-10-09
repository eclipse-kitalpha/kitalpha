//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.edge;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.diagram.description.DescriptionFactory;
import org.eclipse.sirius.diagram.description.EdgeMappingImport;
import org.eclipse.sirius.diagram.description.Layer;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.DomainElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.ForeignExpressionElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.JavaElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.impl.ExpressionImpl;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Condition;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.EdgeDescription;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.EdgeStyle;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Label;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.JavaElementHelper;

import org.eclipse.sirius.diagram.description.ConditionalEdgeStyleDescription;
import org.eclipse.sirius.diagram.description.style.EdgeStyleDescription;
import org.eclipse.sirius.viewpoint.FontFormat;
import org.eclipse.sirius.diagram.description.style.BeginLabelStyleDescription;
import org.eclipse.sirius.diagram.description.style.CenterLabelStyleDescription;
import org.eclipse.sirius.diagram.description.style.EndLabelStyleDescription;
import org.eclipse.sirius.diagram.description.style.StyleFactory;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.SiriusExpressionHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.ExpressionInterpreter;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.VSMVariable;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.mappingimport.merge.EdgeStyleImportMerger;

public class EdgeImportPattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.common.DiagramElementPattern {

	public EdgeImportPattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.EdgeImport) parameterParameter;

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
		method_createDoremiElement(new StringBuffer(), ictx);
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
		/************************ Creation of the Edge Mapping Import ************************/

		EdgeMappingImport edgeMappingImort = DescriptionFactory.eINSTANCE.createEdgeMappingImport();

		edgeMappingImort.setName(parameter.getName() + "_EMI");
		edgeMappingImort.setLabel(parameter.getName());

		edgeMappingImort.setImportedMapping(parameter.getImports());

		dEdgeImportMapping = edgeMappingImort;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createDoremiElement", out.toString());
	}

	protected void method_setParentMapping(final StringBuffer out, final PatternContext ctx) throws Exception {
		dslvpElement = parameter;
		doremiElement = dEdgeImportMapping;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setParentMapping", out.toString());
	}

	protected void method_addElementToODesign(final StringBuffer out, final PatternContext ctx) throws Exception {
		EObject vpParent = parameter.eContainer().eContainer();
		EObject currentParent = GenerationUtil.getDoremiElement(vpParent);

		EdgeMappingImport edgeImportMapping = (EdgeMappingImport) dEdgeImportMapping;

		if (currentParent instanceof Layer) {
			// Add the generated Edge Import Mapping (edgeImportMapping) in the Layer
			Layer owner = (Layer) currentParent;
			owner.getEdgeMappingImports().add(edgeImportMapping);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "addElementToODesign", out.toString());
	}

	protected void method_setStyle(final StringBuffer out, final PatternContext ctx) throws Exception {
		EdgeMappingImport em = (EdgeMappingImport) dEdgeImportMapping;

		for (EdgeDescription iEgdeDescription : parameter.getE_description()) {

			Condition condition = iEgdeDescription.getCondition();
			ConditionalEdgeStyleDescription ceStyleDesc = null;

			if (condition != null) {
				ForeignExpressionElement fEE = condition.getExpression();
				String acceleoExpression = "";
				if (fEE instanceof JavaElement) {
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

				ceStyleDesc = DescriptionFactory.eINSTANCE.createConditionalEdgeStyleDescription();
				ceStyleDesc.setPredicateExpression(acceleoExpression);
				em.getConditionnalStyles().add(ceStyleDesc);
			} else {
				ceStyleDesc = DescriptionFactory.eINSTANCE.createConditionalEdgeStyleDescription();
				ceStyleDesc.setPredicateExpression(SiriusExpressionHelper.getExpressoin("true"));
				em.getConditionnalStyles().add(ceStyleDesc);
			}

			// Initialize style and labels
			EdgeStyle vpStyle = iEgdeDescription.getStyle();
			EdgeStyleDescription eStyleDesc = null;

			CenterLabelStyleDescription cLabelStyleDesc = null;
			Label c_label = iEgdeDescription.getCenter_label();
			String c_labelExpression = SiriusExpressionHelper.getExpressoin("name", ExpressionInterpreter.Feature);

			BeginLabelStyleDescription bLabelStyleDesc = null;
			Label b_label = iEgdeDescription.getBegin_Label();
			String b_labelExpression = SiriusExpressionHelper.getExpressoin("name", ExpressionInterpreter.Feature);

			EndLabelStyleDescription eLabelStyleDesc = null;
			Label e_label = iEgdeDescription.getEnd_label();
			String e_labelExpression = SiriusExpressionHelper.getExpressoin("name", ExpressionInterpreter.Feature);

			if (vpStyle != null) {
				eStyleDesc = StyleFactory.eINSTANCE.createEdgeStyleDescription();
				eStyleDesc.setLineStyle(vpStyle.getLineStyle());
				eStyleDesc.setSourceArrow(vpStyle.getBeginDecorator());
				eStyleDesc.setTargetArrow(vpStyle.getEndDecorator());
				eStyleDesc.setStrokeColor(GenerationUtil.getSystemColor(vpStyle.getColor()));
				eStyleDesc.setSizeComputationExpression("1");
			} else {
				if (b_label != null || c_label != null || e_label != null)
					eStyleDesc = EcoreUtil.copy(parameter.getImports().getStyle());
			}

			/********************** Setting Center Label properties ************************/

			String mParameters = VSMVariable.diagram.getInnerVariable() + "," + VSMVariable.view.getInnerVariable();

			if (c_label != null) {
				((ExpressionImpl) c_label.getValue()).adaptValue(mParameters, true);
				if (c_label.getValue() != null)
					c_labelExpression = c_label.getValue().getValue();

				cLabelStyleDesc = StyleFactory.eINSTANCE.createCenterLabelStyleDescription();
				cLabelStyleDesc.setLabelExpression(c_labelExpression);
				cLabelStyleDesc.setLabelSize(c_label.getSize());
				cLabelStyleDesc.setShowIcon(false);
				cLabelStyleDesc.setLabelColor(GenerationUtil.getSystemColor(c_label.getColor()));

				if (c_label.isBold())
					cLabelStyleDesc.getLabelFormat().add(FontFormat.BOLD_LITERAL);
				if (c_label.isItalic())
					cLabelStyleDesc.getLabelFormat().add(FontFormat.ITALIC_LITERAL);
			} else {
				cLabelStyleDesc = EcoreUtil.copy(parameter.getImports().getStyle().getCenterLabelStyleDescription());
			}

			/********************** Setting Begin Label properties ************************/
			if (b_label != null) {
				((ExpressionImpl) b_label.getValue()).adaptValue(mParameters, true);

				if (b_label.getValue() != null)
					b_labelExpression = b_label.getValue().getValue();

				bLabelStyleDesc = StyleFactory.eINSTANCE.createBeginLabelStyleDescription();
				bLabelStyleDesc.setLabelExpression(b_labelExpression);
				bLabelStyleDesc.setLabelSize(b_label.getSize());
				bLabelStyleDesc.setShowIcon(false);
				bLabelStyleDesc.setLabelColor(GenerationUtil.getSystemColor(b_label.getColor()));

				if (b_label.isBold())
					bLabelStyleDesc.getLabelFormat().add(FontFormat.BOLD_LITERAL);

				if (b_label.isItalic())
					bLabelStyleDesc.getLabelFormat().add(FontFormat.ITALIC_LITERAL);
			} else {
				bLabelStyleDesc = EcoreUtil.copy(parameter.getImports().getStyle().getBeginLabelStyleDescription());
			}

			/********************** Setting End Label properties ************************/
			if (e_label != null) {
				((ExpressionImpl) e_label.getValue()).adaptValue(mParameters, true);
				if (e_label.getValue() != null)
					e_labelExpression = e_label.getValue().getValue();

				eLabelStyleDesc = StyleFactory.eINSTANCE.createEndLabelStyleDescription();
				eLabelStyleDesc.setLabelExpression(e_labelExpression);
				eLabelStyleDesc.setLabelSize(e_label.getSize());
				eLabelStyleDesc.setShowIcon(false);
				eLabelStyleDesc.setLabelColor(GenerationUtil.getSystemColor(e_label.getColor()));

				if (e_label.isBold())
					eLabelStyleDesc.getLabelFormat().add(FontFormat.BOLD_LITERAL);

				if (e_label.isItalic())
					eLabelStyleDesc.getLabelFormat().add(FontFormat.ITALIC_LITERAL);
			} else {
				eLabelStyleDesc = EcoreUtil.copy(parameter.getImports().getStyle().getEndLabelStyleDescription());
			}
			/****************************************************************************************************/

			EdgeStyleDescription eStyleDesc_merged = null;
			try {
				eStyleDesc_merged = EdgeStyleImportMerger.mergeStyles(parameter.getImports().getStyle(), eStyleDesc,
						iEgdeDescription);
			} catch (Exception e) {
			}

			if (eStyleDesc_merged != null)
				eStyleDesc = eStyleDesc_merged;

			/****************************************************************************************************/
			eStyleDesc.setCenterLabelStyleDescription(cLabelStyleDesc);
			eStyleDesc.setBeginLabelStyleDescription(bLabelStyleDesc);
			eStyleDesc.setEndLabelStyleDescription(eLabelStyleDesc);
			ceStyleDesc.setStyle(eStyleDesc);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setStyle", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.EdgeImport parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.EdgeImport parameter) {
		this.parameter = parameter;
	}

	protected org.eclipse.emf.ecore.EObject dEdgeImportMapping;

	public void set_dEdgeImportMapping(org.eclipse.emf.ecore.EObject dEdgeImportMapping) {
		this.dEdgeImportMapping = dEdgeImportMapping;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
