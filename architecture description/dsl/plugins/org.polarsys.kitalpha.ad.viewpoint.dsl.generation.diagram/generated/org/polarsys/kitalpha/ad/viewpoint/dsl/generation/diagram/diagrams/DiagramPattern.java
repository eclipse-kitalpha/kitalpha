//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.diagrams;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.eclipse.sirius.diagram.description.DescriptionFactory;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.viewpoint.description.Group;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.helper.desc.CoreModelHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.commondata.AbstractClass;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.DomainContainer;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.resource.DoremiResourceManager;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StringUtils;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.provider.resourceimpl.EcoreProviderImpl;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.provider.resourceimpl.ViewpointResourceProviderRegistry;

public class DiagramPattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.common.DiagramElementPattern {

	public DiagramPattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Diagram) parameterParameter;

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
		method_computeDomainClass(new StringBuffer(), ictx);
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

	protected void method_setParentMapping(final StringBuffer out, final PatternContext ctx) throws Exception {
		dslvpElement = parameter;
		doremiElement = doremiParent;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setParentMapping", out.toString());
	}

	protected void method_computeDomainClass(final StringBuffer out, final PatternContext ctx) throws Exception {
		DomainContainer domain_container = parameter.getThe_domain();
		if (domain_container != null) {
			AbstractClass aClass = domain_container.getThe_domain();
			domainClass = aClass.getFQN();
		} else
			domainClass = "";

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "computeDomainClass", out.toString());
	}

	protected void method_createDoremiElement(final StringBuffer out, final PatternContext ctx) throws Exception {
		// Creation of the sirius Diagram element
		DiagramDescription dDiagram = DescriptionFactory.eINSTANCE.createDiagramDescription();
		dDiagram.setName(parameter.getName());
		dDiagram.setLabel(parameter.getName());
		dDiagram.setDomainClass(domainClass);

		EcoreProviderImpl eProvider = ViewpointResourceProviderRegistry.getInstance().getEcoreProvider();
		if (eProvider != null) {
			EPackage ePackage = eProvider.getEPackage();
			dDiagram.getMetamodel().add(ePackage);
		}

		// Creation of the default Layer
		Layer dLayer = DescriptionFactory.eINSTANCE.createLayer();
		String shortName = CoreModelHelper.getViewpointShortName(parameter);
		shortName = StringUtils.getDisplayableShortName(shortName);
		dLayer.setName(shortName);
		dDiagram.setDefaultLayer(dLayer);

		doremiParent = dLayer;

		// Adding the diagram to the generated viewpoint
		DoremiResourceManager.getGenerateViewpoint().getOwnedRepresentations().add(dDiagram);

		// Get the reference SystemColorPalette.
		Group grp = (Group) dDiagram.eContainer().eContainer();
		GenerationUtil.setSytemColorsPalette(grp.getSystemColorsPalette());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createDoremiElement", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Diagram parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Diagram parameter) {
		this.parameter = parameter;
	}

	protected org.eclipse.emf.ecore.EObject doremiParent;

	public void set_doremiParent(org.eclipse.emf.ecore.EObject doremiParent) {
		this.doremiParent = doremiParent;
	}

	protected java.lang.String domainClass;

	public void set_domainClass(java.lang.String domainClass) {
		this.domainClass = domainClass;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
