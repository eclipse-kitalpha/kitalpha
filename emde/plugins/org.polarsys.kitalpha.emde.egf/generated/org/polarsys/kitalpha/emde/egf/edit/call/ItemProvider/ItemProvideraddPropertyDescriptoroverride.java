//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.emde.egf.edit.call.ItemProvider;

import org.polarsys.kitalpha.emde.egf.helper.*;
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

public class ItemProvideraddPropertyDescriptoroverride
		extends org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvideraddPropertyDescriptoroverride {
	protected static String nl;

	public static synchronized ItemProvideraddPropertyDescriptoroverride create(String lineSeparator) {
		nl = lineSeparator;
		ItemProvideraddPropertyDescriptoroverride result = new ItemProvideraddPropertyDescriptoroverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "\t\t// begin-extension-code" + NL + "\t\t";
	protected final String TEXT_2 = "PropertyDescriptor = createItemPropertyDescriptor" + NL
			+ "\t\t// end-extension-code\t\t";
	protected final String TEXT_3 = NL + "\t\t// begin-extension-code" + NL + "\t\titemPropertyDescriptors.add" + NL
			+ "\t\t\t(createItemPropertyDescriptor" + NL + "\t\t// end-extension-code";
	protected final String TEXT_4 = NL + "\t\t\t\t(((";
	protected final String TEXT_5 = ")adapterFactory).getRootAdapterFactory()," + NL + "\t\t\t\t getResourceLocator(),"
			+ NL + "\t\t\t\t getString(\"_UI_";
	protected final String TEXT_6 = "_";
	protected final String TEXT_7 = "_feature\"),";
	protected final String TEXT_8 = NL + "\t\t\t\t getString(\"_UI_PropertyDescriptor_description\", \"_UI_";
	protected final String TEXT_9 = "_feature\", \"_UI_";
	protected final String TEXT_10 = "_type\"),";
	protected final String TEXT_11 = NL + "\t\t\t\t getString(\"_UI_";
	protected final String TEXT_12 = "_description\"),";
	protected final String TEXT_13 = NL + "\t\t\t\t ";
	protected final String TEXT_14 = "," + NL + "\t\t\t\t ";
	protected final String TEXT_15 = ",";
	protected final String TEXT_16 = NL + "\t\t\t\t null,";
	protected final String TEXT_17 = ".";
	protected final String TEXT_18 = NL + "\t\t\t\t getString(\"";
	protected final String TEXT_19 = "\"),";
	protected final String TEXT_20 = NL + "\t\t// begin-extension-code" + NL + "\t\t\t\t null);" + NL
			+ "\t\titemPropertyDescriptors.add(";
	protected final String TEXT_21 = "PropertyDescriptor);" + NL + "\t\t// end-extension-code";
	protected final String TEXT_22 = NL + "\t\t// begin-extension-code" + NL + "\t\t\t\t null));" + NL
			+ "\t\t// end-extension-code";
	protected final String TEXT_23 = NL + "\t\t\t\t new String[] {";
	protected final String TEXT_24 = NL + "\t\t\t\t\t\"";
	protected final String TEXT_25 = "\"";
	protected final String TEXT_26 = NL + "\t\t// begin-extension-code" + NL + "\t\t\t\t });" + NL
			+ "\t\titemPropertyDescriptors.add(";
	protected final String TEXT_27 = "PropertyDescriptor);" + NL + "\t\t// begin-extension-code";
	protected final String TEXT_28 = NL + "\t\t// begin-extension-code" + NL + "\t\t\t\t }));" + NL
			+ "\t\t// end-extension-code";
	protected final String TEXT_29 = NL;

	public ItemProvideraddPropertyDescriptoroverride() {
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

		List<Object> genFeatureList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genClassList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genPackageList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genModelList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> isJDK50List = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> forceDefaultCaseList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> indentDefaultCaseList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _ListList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object genFeatureParameter : genFeatureList) {
			for (Object genClassParameter : genClassList) {
				for (Object genPackageParameter : genPackageList) {
					for (Object genModelParameter : genModelList) {
						for (Object isJDK50Parameter : isJDK50List) {
							for (Object forceDefaultCaseParameter : forceDefaultCaseList) {
								for (Object indentDefaultCaseParameter : indentDefaultCaseList) {
									for (Object _ListParameter : _ListList) {

										this.genFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) genFeatureParameter;
										this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) genClassParameter;
										this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
										this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;
										this.isJDK50 = (java.lang.Boolean) isJDK50Parameter;
										this.forceDefaultCase = (java.lang.Boolean) forceDefaultCaseParameter;
										this.indentDefaultCase = (java.lang.String) indentDefaultCaseParameter;
										this._List = (java.lang.String) _ListParameter;

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
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_29);
		stringBuffer.append(TEXT_29);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("genFeature", this.genFeature);
			parameterValues.put("genClass", this.genClass);
			parameterValues.put("genPackage", this.genPackage);
			parameterValues.put("genModel", this.genModel);
			parameterValues.put("isJDK50", this.isJDK50);
			parameterValues.put("forceDefaultCase", this.forceDefaultCase);
			parameterValues.put("indentDefaultCase", this.indentDefaultCase);
			parameterValues.put("_List", this._List);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("genFeature", this.genFeature);
		parameters.put("genClass", this.genClass);
		parameters.put("genPackage", this.genPackage);
		parameters.put("genModel", this.genModel);
		parameters.put("isJDK50", this.isJDK50);
		parameters.put("forceDefaultCase", this.forceDefaultCase);
		parameters.put("indentDefaultCase", this.indentDefaultCase);
		parameters.put("_List", this._List);
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		if (ExtensionHelper.hasExtensibleProviderFactory(genModel)
				|| ExtensionHelper.hasChildCreationExtenders(genModel)) {
			if (genFeature.getEcoreFeature() instanceof EReference && genFeature.getEcoreFeature().isMany() == false) {
				stringBuffer.append(TEXT_1);
				stringBuffer.append(genFeature.getName());
				stringBuffer.append(TEXT_2);
			} else {
				stringBuffer.append(TEXT_3);
			}
		} else {
			stringBuffer.append(TEXT_3);
		}
		stringBuffer.append(TEXT_4);
		stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ComposeableAdapterFactory"));
		stringBuffer.append(TEXT_5);
		stringBuffer.append(genFeature.getGenClass().getName());
		stringBuffer.append(TEXT_6);
		stringBuffer.append(genFeature.getName());
		stringBuffer.append(TEXT_7);
		stringBuffer.append(genModel.getNonNLS());
		if (genFeature.getPropertyDescription() == null || genFeature.getPropertyDescription().length() == 0) {
			stringBuffer.append(TEXT_8);
			stringBuffer.append(genFeature.getGenClass().getName());
			stringBuffer.append(TEXT_6);
			stringBuffer.append(genFeature.getName());
			stringBuffer.append(TEXT_9);
			stringBuffer.append(genFeature.getGenClass().getName());
			stringBuffer.append(TEXT_10);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(genModel.getNonNLS(2));
			stringBuffer.append(genModel.getNonNLS(3));
		} else {
			stringBuffer.append(TEXT_11);
			stringBuffer.append(genFeature.getGenClass().getName());
			stringBuffer.append(TEXT_6);
			stringBuffer.append(genFeature.getName());
			stringBuffer.append(TEXT_12);
			stringBuffer.append(genModel.getNonNLS());
		}
		stringBuffer.append(TEXT_13);
		stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
		stringBuffer.append(TEXT_14);
		stringBuffer.append(genFeature.getProperty() == GenPropertyKind.EDITABLE_LITERAL ? "true" : "false");
		stringBuffer.append(TEXT_14);
		stringBuffer.append(genFeature.isPropertyMultiLine() ? "true" : "false");
		stringBuffer.append(TEXT_14);
		stringBuffer.append(genFeature.isPropertySortChoices() ? "true" : "false");
		stringBuffer.append(TEXT_15);
		if (genFeature.isReferenceType()) {
			stringBuffer.append(TEXT_16);
		} else {
			stringBuffer.append(TEXT_13);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ItemPropertyDescriptor"));
			stringBuffer.append(TEXT_17);
			stringBuffer.append(genFeature.getPropertyImageName());
			stringBuffer.append(TEXT_15);
		}
		if (genFeature.getPropertyCategory() == null || genFeature.getPropertyCategory().length() == 0) {
			stringBuffer.append(TEXT_16);
		} else {
			stringBuffer.append(TEXT_18);
			stringBuffer.append(genModel.getPropertyCategoryKey(genFeature.getPropertyCategory()));
			stringBuffer.append(TEXT_19);
			stringBuffer.append(genModel.getNonNLS());
		}
		if (genFeature.getPropertyFilterFlags().isEmpty()) {
			if (ExtensionHelper.hasExtensibleProviderFactory(genModel)
					|| ExtensionHelper.hasChildCreationExtenders(genModel)) {
				if (genFeature.getEcoreFeature() instanceof EReference
						&& genFeature.getEcoreFeature().isMany() == false) {
					stringBuffer.append(TEXT_20);
					stringBuffer.append(genFeature.getName());
					stringBuffer.append(TEXT_21);
				} else {
					stringBuffer.append(TEXT_22);
				}
			} else {
				stringBuffer.append(TEXT_22);
			}
		} else {
			stringBuffer.append(TEXT_23);
			for (Iterator<String> j = genFeature.getPropertyFilterFlags().iterator(); j.hasNext();) {
				String filterFlag = j.next();
				if (filterFlag != null && filterFlag.length() > 0) {
					stringBuffer.append(TEXT_24);
					stringBuffer.append(filterFlag);
					stringBuffer.append(TEXT_25);
					if (j.hasNext()) {
						stringBuffer.append(TEXT_15);
					}
					stringBuffer.append(genModel.getNonNLS());
				}
			}
			if (ExtensionHelper.hasExtensibleProviderFactory(genModel)
					|| ExtensionHelper.hasChildCreationExtenders(genModel)) {
				if (genFeature.getEcoreFeature() instanceof EReference
						&& genFeature.getEcoreFeature().isMany() == false) {
					stringBuffer.append(TEXT_26);
					stringBuffer.append(genFeature.getName());
					stringBuffer.append(TEXT_27);
				} else {
					stringBuffer.append(TEXT_28);
				}
			} else {
				stringBuffer.append(TEXT_28);
			}
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}
}