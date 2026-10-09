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

import org.eclipse.sirius.diagram.model.business.internal.helper.MappingHelper;
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
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.helper.conf.DiagramGenerationConfigurationHelper;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.mappingimport.merge.ContainerStyleImportMerger;

import org.eclipse.emf.ecore.util.EcoreUtil;

public class ContainerImportPattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.node.ContainerPattern {

	public ContainerImportPattern() {
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
		method_inheritLabelSpecification(new StringBuffer(), ictx);
		method_inheritMappingReuse(new StringBuffer(), ictx);
		method_inheritSemanticData(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("original_m", this.mapping);
			parameters.put("imported_m", this.icm);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram/egf/VpdslSiriusDiagramGenerator.fcore#_MLHN4ISnEeKlgrb0i1zvPQ",
					ctx_local, parameters);
		}
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
		genDefaultSemanticCandidatesExpression = false;

		icm = DescriptionFactory.eINSTANCE.createContainerMappingImport();

		mapping = parameter.getImports();

		icm.setName(parameter.getName() + "_Imported_CM");
		icm.setLabel(parameter.getName());
		icm.setChildrenPresentation(parameter.getContentLayout());
		icm.setImportedMapping(mapping);

		dContainerMapping = icm;

		//MappingAutoImportManager.INSTANCE.registerUserMappingImport(mapping, icm);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createDoremiElement", out.toString());
	}

	protected void method_inheritLabelSpecification(final StringBuffer out, final PatternContext ctx) throws Exception {
		// Inherits label if not defined
		boolean inheritsLabel = true;
		if (parameter.getStyle() != null && parameter.getStyle().size() > 0) {
			for (ContainerDescription iNodeDescription : parameter.getStyle()) {
				if (iNodeDescription.getCondition() == null) {
					if (iNodeDescription.getNode_Label() != null) {
						inheritsLabel = false;
						break;
					}
				}
			}
		}

		if (inheritsLabel) {
			ContainerStyleDescription style = icm.getStyle();
			if (style != null) {
				style.setLabelAlignment(mapping.getStyle().getLabelAlignment());
				style.setLabelColor(mapping.getStyle().getLabelColor());
				style.setLabelExpression(mapping.getStyle().getLabelExpression());
				List<FontFormat> labelFormat = mapping.getStyle().getLabelFormat();
				if (null != labelFormat && false == labelFormat.isEmpty()) {
					style.getLabelFormat().addAll(labelFormat);
				}
				style.setLabelSize(mapping.getStyle().getLabelSize());
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "inheritLabelSpecification", out.toString());
	}

	protected void method_inheritMappingReuse(final StringBuffer out, final PatternContext ctx) throws Exception {
		// ContainerMapping mapping = parameter.getImports();

		// reusing the reused mappings
		if (MappingHelper.getAllContainerMappings(mapping) != null
				&& MappingHelper.getAllContainerMappings(mapping).size() > 0)
			icm.getReusedContainerMappings().addAll(MappingHelper.getAllContainerMappings(mapping));

		if (MappingHelper.getAllContainerMappings(icm).contains(mapping)) {
			icm.getReusedContainerMappings().remove(mapping);
			icm.getReusedContainerMappings().add(icm);
		}

		if (MappingHelper.getAllNodeMappings(mapping) != null && MappingHelper.getAllNodeMappings(mapping).size() > 0)
			icm.getReusedNodeMappings().addAll(MappingHelper.getAllNodeMappings(mapping));

		if (MappingHelper.getAllBorderedNodeMappings(mapping) != null
				&& MappingHelper.getAllBorderedNodeMappings(mapping).size() > 0)
			icm.getReusedBorderedNodeMappings().addAll(MappingHelper.getAllBorderedNodeMappings(mapping));

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "inheritMappingReuse", out.toString());
	}

	protected void method_inheritSemanticData(final StringBuffer out, final PatternContext ctx) throws Exception {
		//ContainerMapping mapping = parameter.getImports();

		boolean inheritSemanticCandidatesExpression = false;

		if (icm.getSemanticCandidatesExpression() == null) {
			inheritSemanticCandidatesExpression = true;
		} else {
			if (icm.getSemanticCandidatesExpression().trim().length() == 0) {
				inheritSemanticCandidatesExpression = true;
			}
		}

		if (inheritSemanticCandidatesExpression) {
			icm.setSemanticCandidatesExpression(mapping.getSemanticCandidatesExpression());
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "inheritSemanticData", out.toString());
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
			} else {
				EcoreUtil.Copier copier = new EcoreUtil.Copier();
				cStyleDesc = (ContainerStyleDescription) copier.copy(parameter.getImports().getStyle());
			}

			if (cStyleDesc != null) {
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
				/************************************************************************************************/
				ContainerStyleDescription cStyleDesc_merged = null;
				try {
					cStyleDesc_merged = ContainerStyleImportMerger.mergeStyles(parameter.getImports().getStyle(),
							cStyleDesc, iContainerDescription);
				} catch (Exception e) {
				}

				if (cStyleDesc_merged != null)
					cStyleDesc = cStyleDesc_merged;
				/************************************************************************************************/

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

	public boolean preCondition(PatternContext ctx) throws Exception {
		return DiagramGenerationConfigurationHelper.generateVSM(parameter) && parameter.getImports() != null;
	}

	protected org.eclipse.sirius.diagram.description.ContainerMappingImport icm;

	public void set_icm(org.eclipse.sirius.diagram.description.ContainerMappingImport icm) {
		this.icm = icm;
	}

	protected org.eclipse.sirius.diagram.description.ContainerMapping mapping;

	public void set_mapping(org.eclipse.sirius.diagram.description.ContainerMapping mapping) {
		this.mapping = mapping;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
