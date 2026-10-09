//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.diagrams;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.helper.desc.CoreModelHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.resource.DoremiResourceManager;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StringUtils;

import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.diagram.description.AdditionalLayer;
import org.eclipse.sirius.diagram.description.DescriptionFactory;
import org.eclipse.sirius.diagram.description.DiagramExtensionDescription;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

public class DiagramExtensionPattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.common.DiagramElementPattern {

	public DiagramExtensionPattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.DiagramExtension) parameterParameter;

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
		method_setParentMapping(new StringBuffer(), ictx);
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

	protected void method_setParentMapping(final StringBuffer out, final PatternContext ctx) throws Exception {
		dslvpElement = parameter;
		doremiElement = doremiParent;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setParentMapping", out.toString());
	}

	protected void method_createDoremiElement(final StringBuffer out, final PatternContext ctx) throws Exception {
		// Gathering informations
		String representationName = parameter.getExtented_diagram().getName();
		Viewpoint vp = ViewpointRegistry.getInstance().getViewpoint(parameter.getExtented_diagram());
		String plugin = vp.eResource().getURI().segments()[1];
		String vpName = vp.getName();
		String vpURI = "viewpoint:/" + plugin + "/" + vpName;
		String vpShortName = CoreModelHelper.getViewpointShortName(parameter);
		String extensionName = vpShortName + " Extension - " + representationName;

		String diagramExtensionName = parameter.getName();
		if (diagramExtensionName != null && diagramExtensionName.trim().length() > 0) {
			extensionName = diagramExtensionName;
		}

		// Creation of the DiagramExtensionDescription element
		DiagramExtensionDescription ddiagramED = DescriptionFactory.eINSTANCE.createDiagramExtensionDescription();
		ddiagramED.setName(extensionName);
		ddiagramED.setRepresentationName(representationName);
		ddiagramED.setViewpointURI(vpURI);

		// Creation of the optional Layer
		AdditionalLayer dLayer = DescriptionFactory.eINSTANCE.createAdditionalLayer();
		dLayer.setName(StringUtils.getDisplayableShortName(vpShortName));
		ddiagramED.getLayers().add(dLayer);

		doremiParent = dLayer;

		// Adding the diagram extension to the generated viewpoint
		DoremiResourceManager.getGenerateViewpoint().getOwnedRepresentationExtensions().add(ddiagramED);

		// Get the reference SystemColorPalette.
		Group grp = (Group) ddiagramED.eContainer().eContainer();
		GenerationUtil.setSytemColorsPalette(grp.getSystemColorsPalette());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createDoremiElement", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.DiagramExtension parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.DiagramExtension parameter) {
		this.parameter = parameter;
	}

	protected org.eclipse.emf.ecore.EObject doremiParent;

	public void set_doremiParent(org.eclipse.emf.ecore.EObject doremiParent) {
		this.doremiParent = doremiParent;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
