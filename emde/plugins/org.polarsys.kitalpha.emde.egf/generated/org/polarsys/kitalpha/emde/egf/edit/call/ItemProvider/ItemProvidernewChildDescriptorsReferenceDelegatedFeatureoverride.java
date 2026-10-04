//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.emde.egf.edit.call.ItemProvider;

import org.polarsys.kitalpha.emde.model.edit.provider.helpers.*;
import org.eclipse.egf.emf.pattern.base.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.codegen.ecore.genmodel.impl.*;
import org.eclipse.emf.codegen.ecore.genmodel.generator.*;
import org.eclipse.emf.codegen.util.*;
import org.eclipse.emf.ecore.util.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class ItemProvidernewChildDescriptorsReferenceDelegatedFeatureoverride extends
		org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvidernewChildDescriptorsReferenceDelegatedFeatureoverride {
	protected static String nl;

	public static synchronized ItemProvidernewChildDescriptorsReferenceDelegatedFeatureoverride create(
			String lineSeparator) {
		nl = lineSeparator;
		ItemProvidernewChildDescriptorsReferenceDelegatedFeatureoverride result = new ItemProvidernewChildDescriptorsReferenceDelegatedFeatureoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "                // begin-extension-code" + NL + "                {";
	protected final String TEXT_2 = NL + "                    ";
	protected final String TEXT_3 = " commandParameter = createChildParameter" + NL + "                        (";
	protected final String TEXT_4 = ",";
	protected final String TEXT_5 = NL + "                         ";
	protected final String TEXT_6 = ".createEntry" + NL + "                            (";
	protected final String TEXT_7 = NL + "                             ";
	protected final String TEXT_8 = ".create(";
	protected final String TEXT_9 = ")));";
	protected final String TEXT_10 = ".create";
	protected final String TEXT_11 = "()));";
	protected final String TEXT_12 = NL + "                    if (";
	protected final String TEXT_13 = ".isValidCommand(object, commandParameter)) {" + NL
			+ "                        newChildDescriptors.add(commandParameter);      " + NL + "                    }"
			+ NL + "                }" + NL + "                // end-extension-code";
	protected final String TEXT_14 = NL + "                newChildDescriptors.add" + NL
			+ "                    (createChildParameter" + NL + "                        (";
	protected final String TEXT_15 = "))));";
	protected final String TEXT_16 = "())));";
	protected final String TEXT_17 = NL;
	protected final String TEXT_18 = NL;

	public ItemProvidernewChildDescriptorsReferenceDelegatedFeatureoverride() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

		// add initialisation of the pattern variables (declaration has been already done).

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;
		Node.Container currentNode = ctx.getNode();

		List<Object> createClassList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> createFeatureList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> delegatedFeatureList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> createClassifierList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> childCreationDataList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genClassList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genPackageList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genModelList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> isJDK50List = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object createClassParameter : createClassList) {
			for (Object createFeatureParameter : createFeatureList) {
				for (Object delegatedFeatureParameter : delegatedFeatureList) {
					for (Object createClassifierParameter : createClassifierList) {
						for (Object childCreationDataParameter : childCreationDataList) {
							for (Object genClassParameter : genClassList) {
								for (Object genPackageParameter : genPackageList) {
									for (Object genModelParameter : genModelList) {
										for (Object isJDK50Parameter : isJDK50List) {

											this.createClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) createClassParameter;
											this.createFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) createFeatureParameter;
											this.delegatedFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) delegatedFeatureParameter;
											this.createClassifier = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier) createClassifierParameter;
											this.childCreationData = (org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData) childCreationDataParameter;
											this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) genClassParameter;
											this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
											this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;
											this.isJDK50 = (java.lang.Boolean) isJDK50Parameter;

											if (preCondition(ctx)) {
												ctx.setNode(new Node.Container(currentNode, getClass()));
												orchestration(ctx);
											}

										}
									}
								}
							}
						}
					}
				}
			}
		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_18);
		stringBuffer.append(TEXT_18);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("createClass", this.createClass);
			parameterValues.put("createFeature", this.createFeature);
			parameterValues.put("delegatedFeature", this.delegatedFeature);
			parameterValues.put("createClassifier", this.createClassifier);
			parameterValues.put("childCreationData", this.childCreationData);
			parameterValues.put("genClass", this.genClass);
			parameterValues.put("genPackage", this.genPackage);
			parameterValues.put("genModel", this.genModel);
			parameterValues.put("isJDK50", this.isJDK50);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("createClass", this.createClass);
		parameters.put("createFeature", this.createFeature);
		parameters.put("delegatedFeature", this.delegatedFeature);
		parameters.put("createClassifier", this.createClassifier);
		parameters.put("childCreationData", this.childCreationData);
		parameters.put("genClass", this.genClass);
		parameters.put("genPackage", this.genPackage);
		parameters.put("genModel", this.genModel);
		parameters.put("isJDK50", this.isJDK50);
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		if (EMDEHelper.isExtensibleElement(genClass.getEcoreClass())) {
			stringBuffer.append(TEXT_1);
			stringBuffer.append(TEXT_2);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.command.CommandParameter"));
			stringBuffer.append(TEXT_3);
			stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
			stringBuffer.append(TEXT_4);
			stringBuffer.append(TEXT_5);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMapUtil"));
			stringBuffer.append(TEXT_6);
			stringBuffer.append(delegatedFeature.getQualifiedFeatureAccessor());
			stringBuffer.append(TEXT_4);
			if (createClass.isMapEntry()) {
				stringBuffer.append(TEXT_7);
				stringBuffer.append(createClass.getGenPackage().getQualifiedEFactoryInstanceAccessor());
				stringBuffer.append(TEXT_8);
				stringBuffer.append(createClass.getQualifiedClassifierAccessor());
				stringBuffer.append(TEXT_9);
			} else {
				stringBuffer.append(TEXT_7);
				stringBuffer.append(createClass.getGenPackage().getQualifiedFactoryInstanceAccessor());
				stringBuffer.append(TEXT_10);
				stringBuffer.append(createClass.getName());
				stringBuffer.append(TEXT_11);
			}
			stringBuffer.append(TEXT_12);
			stringBuffer.append(genModel
					.getImportedName("org.polarsys.kitalpha.emde.model.edit.provider.NewChildDescriptorHelper"));
			stringBuffer.append(TEXT_13);
		} else {
			stringBuffer.append(TEXT_14);
			stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
			stringBuffer.append(TEXT_4);
			stringBuffer.append(TEXT_5);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMapUtil"));
			stringBuffer.append(TEXT_6);
			stringBuffer.append(delegatedFeature.getQualifiedFeatureAccessor());
			stringBuffer.append(TEXT_4);
			if (createClass.isMapEntry()) {
				stringBuffer.append(TEXT_7);
				stringBuffer.append(createClass.getGenPackage().getQualifiedEFactoryInstanceAccessor());
				stringBuffer.append(TEXT_8);
				stringBuffer.append(createClass.getQualifiedClassifierAccessor());
				stringBuffer.append(TEXT_15);
			} else {
				stringBuffer.append(TEXT_7);
				stringBuffer.append(createClass.getGenPackage().getQualifiedFactoryInstanceAccessor());
				stringBuffer.append(TEXT_10);
				stringBuffer.append(createClass.getName());
				stringBuffer.append(TEXT_16);
			}
		}
		stringBuffer.append(TEXT_17);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.newChildDescriptorsReferenceDelegatedFeature.insert" args="createClass:createClass,createFeature:createFeature,delegatedFeature:delegatedFeature,createClassifier:createClassifier,childCreationData:childCreationData,genClass:genClass,genPackage:genPackage,genModel:genModel"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("createClass", createClass);
			callParameters.put("createFeature", createFeature);
			callParameters.put("delegatedFeature", delegatedFeature);
			callParameters.put("createClassifier", createClassifier);
			callParameters.put("childCreationData", childCreationData);
			callParameters.put("genClass", genClass);
			callParameters.put("genPackage", genPackage);
			callParameters.put("genModel", genModel);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_04NBAGJ-Ed-FqczH3ESmRw",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}
}