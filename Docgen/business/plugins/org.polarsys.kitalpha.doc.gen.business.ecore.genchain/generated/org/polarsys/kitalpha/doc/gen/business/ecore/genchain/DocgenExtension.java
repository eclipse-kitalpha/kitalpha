//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.doc.gen.business.ecore.genchain;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement;
import org.eclipse.egf.portfolio.genchain.tools.FcoreBuilderConstants;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.util.URI;

import org.eclipse.egf.portfolio.genchain.tools.utils.ActivityInvocationHelper;
import org.polarsys.kitalpha.doc.gen.business.core.branding.DocumentationBrandingData;
import org.polarsys.kitalpha.doc.gen.business.ecore.genchain.DocgenGenchainExtension.KitalphaDocumentationGenerationBranding;

public class DocgenExtension {

	public DocgenExtension() {
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

			this.parameter = (org.polarsys.kitalpha.doc.gen.business.ecore.genchain.DocgenGenchainExtension.KitalphaDocumentationGeneration) parameterParameter;

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
		method_initializeContractsData(new StringBuffer(), ictx);
		method_body(new StringBuffer(), ictx);
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

	protected void method_initializeContractsData(final StringBuffer out, final PatternContext ctx) throws Exception {
		/*String name = parameter.getName();*/
		pluginName = parameter.getPluginName();
		outputDirectoryPath = parameter.getOutputDirectoryPath();
		ecorePath = parameter.getModelPath();

		KitalphaDocumentationGenerationBranding brandingData = parameter.getBrandingData();
		if (brandingData != null) {
			copyright = brandingData.getCopyright();
			logoPath = brandingData.getLogoPath();
			logoAlt = brandingData.getLogoAlt();
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initializeContractsData", out.toString());
	}

	protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {
		URI DOC_GEN_ACTIVITY_MODEL_URI = URI.createPlatformPluginURI(
				"/org.polarsys.kitalpha.doc.gen.business.ecore/egf/EcoreDocGenLauncher.fcore", false);
		String DOC_GEN_ACTIVITY_ID = "_B9nwIR4UEeSYicwoCfn9sQ";

		/** Preparing the contract values **/
		Map<String, Type> contract2type = new HashMap<String, Type>();

		// Set ecoreFilePath contract value
		TypeString typeString = TypesFactory.eINSTANCE.createTypeString();
		typeString.setValue(ecorePath);
		contract2type.put("ecoreFilePath", typeString);

		// Set outputDirectoryPath contract value
		typeString = TypesFactory.eINSTANCE.createTypeString();
		typeString.setValue(pluginName + "/" + outputDirectoryPath);
		contract2type.put("outputDirectoryPath", typeString);

		// Setting the branding contracts values
		TypeString copyrightTypeString = TypesFactory.eINSTANCE.createTypeString();
		copyrightTypeString.setValue(copyright);
		contract2type.put("copyright", copyrightTypeString);

		TypeString logoPathTypeString = TypesFactory.eINSTANCE.createTypeString();
		logoPathTypeString.setValue(logoPath);
		contract2type.put("logo.path", logoPathTypeString);

		TypeString logoAltTypeString = TypesFactory.eINSTANCE.createTypeString();
		logoAltTypeString.setValue(logoAlt);
		contract2type.put("logo.alt", logoAltTypeString);

		/** Adding the Ecore documentation luncher to the FC.  **/
		@SuppressWarnings("unchecked")
		Map<GenerationElement, FactoryComponent> fcs = (Map<GenerationElement, FactoryComponent>) ctx
				.getValue(FcoreBuilderConstants.CURRENT_FCORE);
		FactoryComponent fc = fcs.get((GenerationElement) (parameter.eContainer()));
		Resource eResource = fc.eResource();
		ResourceSet resourceSet = eResource.getResourceSet();
		Activity activity = (Activity) resourceSet.getResource(DOC_GEN_ACTIVITY_MODEL_URI, true)
				.getEObject(DOC_GEN_ACTIVITY_ID);
		ProductionPlan pp = (ProductionPlan) fc.getOrchestration();
		ActivityInvocationHelper.addInvocation(pp, activity, contract2type);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}

	protected org.polarsys.kitalpha.doc.gen.business.ecore.genchain.DocgenGenchainExtension.KitalphaDocumentationGeneration parameter;

	public void set_parameter(
			org.polarsys.kitalpha.doc.gen.business.ecore.genchain.DocgenGenchainExtension.KitalphaDocumentationGeneration parameter) {
		this.parameter = parameter;
	}

	protected java.lang.String copyright;

	public void set_copyright(java.lang.String copyright) {
		this.copyright = copyright;
	}

	protected java.lang.String logoPath;

	public void set_logoPath(java.lang.String logoPath) {
		this.logoPath = logoPath;
	}

	protected java.lang.String logoAlt;

	public void set_logoAlt(java.lang.String logoAlt) {
		this.logoAlt = logoAlt;
	}

	protected java.lang.String pluginName;

	public void set_pluginName(java.lang.String pluginName) {
		this.pluginName = pluginName;
	}

	protected java.lang.String outputDirectoryPath;

	public void set_outputDirectoryPath(java.lang.String outputDirectoryPath) {
		this.outputDirectoryPath = outputDirectoryPath;
	}

	protected java.lang.String ecorePath;

	public void set_ecorePath(java.lang.String ecorePath) {
		this.ecorePath = ecorePath;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
