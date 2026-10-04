//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.edge;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.DomainElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.ForeignExpressionElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.JavaElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.impl.ExpressionImpl;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Condition;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.EdgeDescription;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.EdgeDomainAssociation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.EdgeDomainElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.EdgeStyle;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Label;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.JavaElementHelper;

import org.eclipse.sirius.diagram.description.DescriptionFactory;
import org.eclipse.sirius.diagram.description.DiagramElementMapping;
import org.eclipse.sirius.diagram.description.EdgeMapping;
import org.eclipse.sirius.diagram.description.ConditionalEdgeStyleDescription;
import org.eclipse.sirius.diagram.description.style.EdgeStyleDescription;
import org.eclipse.sirius.viewpoint.FontFormat;
import org.eclipse.sirius.diagram.description.style.BeginLabelStyleDescription;
import org.eclipse.sirius.diagram.description.style.CenterLabelStyleDescription;
import org.eclipse.sirius.diagram.description.style.EndLabelStyleDescription;
import org.eclipse.sirius.diagram.description.style.StyleFactory;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.diagram.description.EdgeMappingImport;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.SiriusExpressionHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.ExpressionInterpreter;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.VSMVariable;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.SiriusExpressionHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.ExpressionInterpreter;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.VSMVariable;

public class EdgePattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.common.DiagramElementPattern {

	public EdgePattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Edge) parameterParameter;

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
		/************************ Creation of the Edge Mapping ************************/

		EdgeMapping edgeMapping = DescriptionFactory.eINSTANCE.createEdgeMapping();
		edgeMapping.setName(parameter.getName() + "_EM");
		edgeMapping.setLabel(parameter.getName());

		/**
		 Setting mappings data
		for (EObject sourceMapping : parameter.getSource()) 
			edgeMapping.getSourceMapping().add((DiagramElementMapping) GenerationUtil.getDoremiElement(sourceMapping));
				
		for (EObject targetMapping : parameter.getTarget()) 
			edgeMapping.getTargetMapping().add((DiagramElementMapping) GenerationUtil.getDoremiElement(targetMapping));
		*/
		// Setting mappings data

		/**
		* //TODO : todo 1 and todo 2 are Hacks. If one Edge side (source or Target) reference an imported Edge, 
		* so we link this side to the original Edge.
		**/
		for (EObject sourceMapping : parameter.getSource()) {
			EObject eObject = GenerationUtil.getDoremiElement(sourceMapping);
			if (eObject instanceof DiagramElementMapping) {
				edgeMapping.getSourceMapping().add((DiagramElementMapping) eObject);
			}

			// TODO: 1 
			if (eObject instanceof EdgeMappingImport) {
				EdgeMappingImport edgeImport = (EdgeMappingImport) eObject;
				edgeMapping.getSourceMapping().add((DiagramElementMapping) edgeImport.getImportedMapping());
			}
		}

		for (EObject targetMapping : parameter.getTarget()) {
			EObject eObject = GenerationUtil.getDoremiElement(targetMapping);
			if (eObject instanceof DiagramElementMapping) {
				edgeMapping.getTargetMapping().add((DiagramElementMapping) eObject);
			}

			// TODO: 2
			if (eObject instanceof EdgeMappingImport) {
				EdgeMappingImport edgeImport = (EdgeMappingImport) eObject;
				edgeMapping.getTargetMapping().add((DiagramElementMapping) edgeImport.getImportedMapping());
			}
		}

		dEdgeMapping = edgeMapping;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createDoremiElement", out.toString());
	}

	protected void method_setSemanticData(final StringBuffer out, final PatternContext ctx) throws Exception {
		EdgeMapping edgeMapping = (EdgeMapping) dEdgeMapping;

		EdgeDomainAssociation domain = parameter.getThe_domain();

		String domainClass = "";
		String sourceFinderExpression = "";
		String targetFinderExpression = "";

		/******************** The case of Element based Edge Mapping *******************/
		if (domain instanceof EdgeDomainElement) {
			edgeMapping.setUseDomainElement(true);
			EdgeDomainElement edElement = (EdgeDomainElement) domain;

			// Source finder Expression
			if (edElement.getSource_Locator() != null)
				sourceFinderExpression = SiriusExpressionHelper.getExpressoin(edElement.getSource_Locator().getName(),
						ExpressionInterpreter.Feature);
			else {
				String s_query = edElement.getSource_query();
				if (s_query != null && s_query.trim().length() > 0)
					sourceFinderExpression = edElement.getSource_query();
			}

			if (edElement.getThe_Domain() != null)
				domainClass = edElement.getThe_Domain().getFQN();
		}

		/************* The case of both Relation and Element based Edge Mapping ***************/
		// Target finder Expression
		if (domain.getTarget_Locator() != null)
			targetFinderExpression = SiriusExpressionHelper.getExpressoin(domain.getTarget_Locator().getName(),
					ExpressionInterpreter.Feature);
		else {
			String t_query = domain.getTarget_query();
			if (t_query != null && t_query.trim().length() > 0)
				targetFinderExpression = t_query;
		}

		// Setting the semantic data
		edgeMapping.setDomainClass(domainClass);
		edgeMapping.setSourceFinderExpression(sourceFinderExpression);
		edgeMapping.setTargetFinderExpression(targetFinderExpression);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setSemanticData", out.toString());
	}

	protected void method_setStyle(final StringBuffer out, final PatternContext ctx) throws Exception {
		EdgeMapping em = (EdgeMapping) dEdgeMapping;

		for (EdgeDescription iEgdeDescription : parameter.getE_description()) {
			Condition condition = iEgdeDescription.getCondition();
			boolean conditionalStyle = false;
			ConditionalEdgeStyleDescription ceStyleDesc = null;

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
				}
				if (fEE instanceof DomainElement)
					acceleoExpression = "<%" + ((DomainElement) fEE).getAttribute().getName() + "%>";

				ceStyleDesc = DescriptionFactory.eINSTANCE.createConditionalEdgeStyleDescription();
				ceStyleDesc.setPredicateExpression(acceleoExpression);

				em.getConditionnalStyles().add(ceStyleDesc);
			}

			EdgeStyle vpStyle = iEgdeDescription.getStyle();
			EdgeStyleDescription eStyleDesc = null;

			if (vpStyle != null) {
				eStyleDesc = StyleFactory.eINSTANCE.createEdgeStyleDescription();
				eStyleDesc.setSizeComputationExpression("0");
				eStyleDesc.setLineStyle(vpStyle.getLineStyle());
				eStyleDesc.setSourceArrow(vpStyle.getBeginDecorator());
				eStyleDesc.setTargetArrow(vpStyle.getEndDecorator());
				eStyleDesc.setStrokeColor(GenerationUtil.getSystemColor(vpStyle.getColor()));

				/********************** Setting Center Label properties ************************/
				Label c_label = iEgdeDescription.getCenter_label();
				String c_labelExpression = SiriusExpressionHelper.getExpressoin("name", ExpressionInterpreter.Feature);

				String mParameters = VSMVariable.diagram.getInnerVariable() + "," + VSMVariable.view.getInnerVariable();

				if (c_label != null) {
					//((ExpressionImpl) c_label.getValue()).adaptValue();
					((ExpressionImpl) c_label.getValue()).adaptValue(mParameters, true);

					if (c_label.getValue() != null)
						c_labelExpression = c_label.getValue().getValue();

					CenterLabelStyleDescription cLabelStyleDesc = StyleFactory.eINSTANCE
							.createCenterLabelStyleDescription();
					cLabelStyleDesc.setLabelExpression(c_labelExpression);
					cLabelStyleDesc.setLabelSize(c_label.getSize());
					cLabelStyleDesc.setShowIcon(false);
					cLabelStyleDesc.setLabelColor(GenerationUtil.getSystemColor(c_label.getColor()));

					eStyleDesc.setCenterLabelStyleDescription(cLabelStyleDesc);

					if (c_label.isBold())
						cLabelStyleDesc.getLabelFormat().add(FontFormat.BOLD_LITERAL);

					if (c_label.isItalic())
						cLabelStyleDesc.getLabelFormat().add(FontFormat.ITALIC_LITERAL);

				}

				/********************** Setting Begin Label properties ************************/
				Label b_label = iEgdeDescription.getBegin_Label();
				String b_labelExpression = SiriusExpressionHelper.getExpressoin("name", ExpressionInterpreter.Feature);

				if (b_label != null) {
					//((ExpressionImpl) b_label.getValue()).adaptValue();
					((ExpressionImpl) b_label.getValue()).adaptValue(mParameters, true);

					if (b_label.getValue() != null)
						b_labelExpression = b_label.getValue().getValue();

					BeginLabelStyleDescription bLabelStyleDesc = StyleFactory.eINSTANCE
							.createBeginLabelStyleDescription();
					bLabelStyleDesc.setLabelExpression(b_labelExpression);
					bLabelStyleDesc.setLabelSize(b_label.getSize());
					bLabelStyleDesc.setShowIcon(false);
					bLabelStyleDesc.setLabelColor(GenerationUtil.getSystemColor(b_label.getColor()));

					eStyleDesc.setBeginLabelStyleDescription(bLabelStyleDesc);

					if (b_label.isBold())
						bLabelStyleDesc.getLabelFormat().add(FontFormat.BOLD_LITERAL);

					if (b_label.isItalic())
						bLabelStyleDesc.getLabelFormat().add(FontFormat.ITALIC_LITERAL);

				}

				/********************** Setting End Label properties ************************/
				Label e_label = iEgdeDescription.getEnd_label();
				String e_labelExpression = SiriusExpressionHelper.getExpressoin("name", ExpressionInterpreter.Feature);

				if (e_label != null) {
					//((ExpressionImpl) e_label.getValue()).adaptValue();
					((ExpressionImpl) e_label.getValue()).adaptValue(mParameters, true);

					if (e_label.getValue() != null)
						e_labelExpression = e_label.getValue().getValue();

					EndLabelStyleDescription eLabelStyleDesc = StyleFactory.eINSTANCE.createEndLabelStyleDescription();
					eLabelStyleDesc.setLabelExpression(e_labelExpression);
					eLabelStyleDesc.setLabelSize(e_label.getSize());
					eLabelStyleDesc.setShowIcon(false);
					eLabelStyleDesc.setLabelColor(GenerationUtil.getSystemColor(e_label.getColor()));

					eStyleDesc.setEndLabelStyleDescription(eLabelStyleDesc);

					if (e_label.isBold())
						eLabelStyleDesc.getLabelFormat().add(FontFormat.BOLD_LITERAL);

					if (e_label.isItalic())
						eLabelStyleDesc.getLabelFormat().add(FontFormat.ITALIC_LITERAL);
				}

				/************* Add the created container style to it parent **************/
				if (conditionalStyle)
					ceStyleDesc.setStyle(eStyleDesc);
				else
					em.setStyle(eStyleDesc);
			}
			/************************* The end ****************************************************/
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setStyle", out.toString());
	}

	protected void method_setParentMapping(final StringBuffer out, final PatternContext ctx) throws Exception {
		dslvpElement = parameter;
		doremiElement = dEdgeMapping;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setParentMapping", out.toString());
	}

	protected void method_addElementToODesign(final StringBuffer out, final PatternContext ctx) throws Exception {
		EObject vpParent = parameter.eContainer().eContainer();
		EObject currentParent = GenerationUtil.getDoremiElement(vpParent);

		EdgeMapping edgeMapping = (EdgeMapping) dEdgeMapping;

		if (currentParent instanceof Layer) {
			// Add the generated Edge Mapping (edgeMapping) in the Layer
			Layer owner = (Layer) currentParent;
			owner.getEdgeMappings().add(edgeMapping);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "addElementToODesign", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Edge parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Edge parameter) {
		this.parameter = parameter;
	}

	protected org.eclipse.emf.ecore.EObject dEdgeMapping;

	public void set_dEdgeMapping(org.eclipse.emf.ecore.EObject dEdgeMapping) {
		this.dEdgeMapping = dEdgeMapping;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
