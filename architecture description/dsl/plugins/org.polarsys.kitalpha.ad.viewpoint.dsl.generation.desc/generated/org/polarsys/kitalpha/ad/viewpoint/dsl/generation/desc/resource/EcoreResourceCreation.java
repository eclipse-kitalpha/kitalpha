//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.resource;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.ECoreResourceManager;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.ECoreFileInformation;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.helper.configuration.VpDslConfigurationHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.helper.desc.CoreModelHelper;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.adapter.IContractProvider;

public class EcoreResourceCreation
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.common.AnyVPSpecElement {

	public EcoreResourceCreation() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Data) parameterParameter;

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
		method_initResourceInformations(new StringBuffer(), ictx);
		method_generateResource(new StringBuffer(), ictx);
		method_loadEcoreResource(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("vpElement", this.parameter);
			parameters.put("eElement", this.gEPackage);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc/egf/vpdslECoreGenerator.fcore#_HKpWoL4sEeKDeKot98nSrA",
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

	protected void method_initResourceInformations(final StringBuffer out, final PatternContext ctx) throws Exception {
		nsUri = VpDslConfigurationHelper.getNsURI(parameter);
		shortName = CoreModelHelper.getViewpointShortName(parameter);
		modelFolder = (String) ctx.getValue(IContractProvider.MODEL_FOLDER);
		rootProjectName = VpDslConfigurationHelper.getRootProjectName(parameter);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initResourceInformations", out.toString());
	}

	protected void method_generateResource(final StringBuffer out, final PatternContext ctx) throws Exception {
		// EPackage creation
		gEPackage = EcoreFactory.eINSTANCE.createEPackage();
		gEPackage.setName(shortName);
		gEPackage.setNsPrefix(shortName);
		gEPackage.setNsURI(nsUri);

		// Resource creation
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createPlatformResourceURI(rootProjectName + "/" + modelFolder + "/" + shortName + ".ecore",
				false);
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(gEPackage);
		resource.save(Collections.EMPTY_MAP);

		// Loading resource
		//ECoreResourceManager.INSTANCE.loadECoreResource(new ECoreFileInformation(rootProjectName, "models", shortName));

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "generateResource", out.toString());
	}

	protected void method_loadEcoreResource(final StringBuffer out, final PatternContext ctx) throws Exception {
		// Loading resource
		ECoreResourceManager.INSTANCE
				.loadECoreResource(new ECoreFileInformation(rootProjectName, modelFolder, shortName));

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "loadEcoreResource", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Data parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Data parameter) {
		this.parameter = parameter;
	}

	protected java.lang.String shortName;

	public void set_shortName(java.lang.String shortName) {
		this.shortName = shortName;
	}

	protected java.lang.String nsUri;

	public void set_nsUri(java.lang.String nsUri) {
		this.nsUri = nsUri;
	}

	protected org.eclipse.emf.ecore.EPackage gEPackage;

	public void set_gEPackage(org.eclipse.emf.ecore.EPackage gEPackage) {
		this.gEPackage = gEPackage;
	}

	protected java.lang.String rootProjectName;

	public void set_rootProjectName(java.lang.String rootProjectName) {
		this.rootProjectName = rootProjectName;
	}

	protected java.lang.String modelFolder;

	public void set_modelFolder(java.lang.String modelFolder) {
		this.modelFolder = modelFolder;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
