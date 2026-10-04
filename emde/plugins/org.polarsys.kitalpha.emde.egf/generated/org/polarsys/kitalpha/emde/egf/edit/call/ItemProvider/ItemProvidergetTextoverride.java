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

public class ItemProvidergetTextoverride
		extends org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvidergetTextoverride {
	protected static String nl;

	public static synchronized ItemProvidergetTextoverride create(String lineSeparator) {
		nl = lineSeparator;
		ItemProvidergetTextoverride result = new ItemProvidergetTextoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "\t\treturn ((";
	protected final String TEXT_2 = ")getStyledText(object)).getString();";
	protected final String TEXT_3 = NL + "\t\t";
	protected final String TEXT_4 = "<?, ?>";
	protected final String TEXT_5 = " ";
	protected final String TEXT_6 = " = (";
	protected final String TEXT_7 = ")object;";
	protected final String TEXT_8 = NL + "\t\treturn \"\" + ";
	protected final String TEXT_9 = ".getKey() + \" -> \" + ";
	protected final String TEXT_10 = ".getValue();";
	protected final String TEXT_11 = NL + "\t\tString key = crop(\"\" + ";
	protected final String TEXT_12 = ".getKey());";
	protected final String TEXT_13 = NL + "\t\tString key = \"\" + ";
	protected final String TEXT_14 = ".getKey();";
	protected final String TEXT_15 = NL + "\t\tString value = crop(\"\" + ";
	protected final String TEXT_16 = ".getValue());";
	protected final String TEXT_17 = NL + "\t\tString value = \"\" + ";
	protected final String TEXT_18 = NL + "\t\treturn key + \" -> \" + value;";
	protected final String TEXT_19 = ")object;" + NL + "\t\t// begin-extension-code" + NL + "\t\treturn ";
	protected final String TEXT_20 = ".";
	protected final String TEXT_21 = "() + \" [\" + getString(\"_UI_";
	protected final String TEXT_22 = "_type\") + \"]\";";
	protected final String TEXT_23 = NL + "\t\t// end-extension-code";
	protected final String TEXT_24 = NL + "\t\tString label = crop(((";
	protected final String TEXT_25 = ")object).";
	protected final String TEXT_26 = "());";
	protected final String TEXT_27 = NL + "\t\tString label = ((";
	protected final String TEXT_28 = "();";
	protected final String TEXT_29 = " labelValue = ((";
	protected final String TEXT_30 = ")object).eGet(";
	protected final String TEXT_31 = ");";
	protected final String TEXT_32 = NL + "\t\tString label = labelValue == null ? null : labelValue.toString();";
	protected final String TEXT_33 = NL + "\t\t// begin-extension-code" + NL
			+ "\t\treturn label == null || label.length() == 0 ?" + NL + "\t\t\t\"[\" + getString(\"_UI_";
	protected final String TEXT_34 = "_type\") + \"]\" : label;";
	protected final String TEXT_35 = NL + "\t\t// begin-extension-code" + NL + "\t\treturn \"[\" + getString(\"_UI_";
	protected final String TEXT_36 = NL;

	public ItemProvidergetTextoverride() {
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

		for (Object genClassParameter : genClassList) {
			for (Object genPackageParameter : genPackageList) {
				for (Object genModelParameter : genModelList) {
					for (Object isJDK50Parameter : isJDK50List) {
						for (Object forceDefaultCaseParameter : forceDefaultCaseList) {
							for (Object indentDefaultCaseParameter : indentDefaultCaseList) {
								for (Object _ListParameter : _ListList) {

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
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_36);
		stringBuffer.append(TEXT_36);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
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

		if (genModel.isStyleProviders()) {
			stringBuffer.append(TEXT_1);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
			stringBuffer.append(TEXT_2);
		} else {
			if (genClass.isMapEntry()) {
				stringBuffer.append(TEXT_3);
				stringBuffer.append(genClass.getImportedInterfaceName());
				if (genModel.useGenerics()) {
					stringBuffer.append(TEXT_4);
				}
				stringBuffer.append(TEXT_5);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_6);
				stringBuffer.append(genClass.getImportedInterfaceName());
				if (genModel.useGenerics()) {
					stringBuffer.append(TEXT_4);
				}
				stringBuffer.append(TEXT_7);
				if (!genClass.getMapEntryKeyFeature().isPropertyMultiLine()
						&& !genClass.getMapEntryValueFeature().isPropertyMultiLine()) {
					stringBuffer.append(TEXT_8);
					stringBuffer.append(genClass.getSafeUncapName());
					stringBuffer.append(TEXT_9);
					stringBuffer.append(genClass.getSafeUncapName());
					stringBuffer.append(TEXT_10);
					stringBuffer.append(genModel.getNonNLS());
					stringBuffer.append(genModel.getNonNLS(2));
				} else {
					if (genClass.getMapEntryKeyFeature().isPropertyMultiLine()) {
						stringBuffer.append(TEXT_11);
						stringBuffer.append(genClass.getSafeUncapName());
						stringBuffer.append(TEXT_12);
						stringBuffer.append(genModel.getNonNLS());
					} else {
						stringBuffer.append(TEXT_13);
						stringBuffer.append(genClass.getSafeUncapName());
						stringBuffer.append(TEXT_14);
						stringBuffer.append(genModel.getNonNLS());
					}
					if (genClass.getMapEntryValueFeature().isPropertyMultiLine()) {
						stringBuffer.append(TEXT_15);
						stringBuffer.append(genClass.getSafeUncapName());
						stringBuffer.append(TEXT_16);
						stringBuffer.append(genModel.getNonNLS());
					} else {
						stringBuffer.append(TEXT_17);
						stringBuffer.append(genClass.getSafeUncapName());
						stringBuffer.append(TEXT_10);
						stringBuffer.append(genModel.getNonNLS());
					}
					stringBuffer.append(TEXT_18);
					stringBuffer.append(genModel.getNonNLS());
				}
			} else if (genClass.getLabelFeature() != null) {
				GenFeature labelFeature = genClass.getLabelFeature();
				if (labelFeature.isPrimitiveType() && !labelFeature.getGenClass().isDynamic()
						&& !labelFeature.isSuppressedGetVisibility()) {
					stringBuffer.append(TEXT_3);
					stringBuffer.append(genClass.getImportedInterfaceName());
					stringBuffer.append(genClass.getInterfaceWildTypeArguments());
					stringBuffer.append(TEXT_5);
					stringBuffer.append(genClass.getSafeUncapName());
					stringBuffer.append(TEXT_6);
					stringBuffer.append(genClass.getImportedInterfaceName());
					stringBuffer.append(genClass.getInterfaceWildTypeArguments());
					stringBuffer.append(TEXT_19);
					stringBuffer.append(genClass.getSafeUncapName());
					stringBuffer.append(TEXT_20);
					stringBuffer.append(genClass.getLabelFeature().getGetAccessor());
					stringBuffer.append(TEXT_21);
					stringBuffer.append(genClass.getName());
					stringBuffer.append(TEXT_22);
					stringBuffer.append(genModel.getNonNLS());
					stringBuffer.append(genModel.getNonNLS(2));
					stringBuffer.append(genModel.getNonNLS(3));
					stringBuffer.append(TEXT_23);
				} else {
					if (labelFeature.isStringType() && !labelFeature.getGenClass().isDynamic()
							&& !labelFeature.isSuppressedGetVisibility()) {
						if (labelFeature.isPropertyMultiLine()) {
							stringBuffer.append(TEXT_24);
							stringBuffer.append(genClass.getImportedInterfaceName());
							stringBuffer.append(genClass.getInterfaceWildTypeArguments());
							stringBuffer.append(TEXT_25);
							stringBuffer.append(labelFeature.getGetAccessor());
							stringBuffer.append(TEXT_26);
						} else {
							stringBuffer.append(TEXT_27);
							stringBuffer.append(genClass.getImportedInterfaceName());
							stringBuffer.append(genClass.getInterfaceWildTypeArguments());
							stringBuffer.append(TEXT_25);
							stringBuffer.append(labelFeature.getGetAccessor());
							stringBuffer.append(TEXT_28);
						}
					} else {
						if (labelFeature.isSuppressedGetVisibility() || labelFeature.getGenClass().isDynamic()) {
							stringBuffer.append(TEXT_3);
							stringBuffer.append(genModel.getImportedName("java.lang.Object"));
							stringBuffer.append(TEXT_29);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
							stringBuffer.append(TEXT_30);
							stringBuffer.append(labelFeature.getQualifiedFeatureAccessor());
							stringBuffer.append(TEXT_31);
						} else {
							stringBuffer.append(TEXT_3);
							stringBuffer.append(labelFeature.getRawImportedType());
							stringBuffer.append(TEXT_29);
							stringBuffer.append(genClass.getImportedInterfaceName());
							stringBuffer.append(genClass.getInterfaceWildTypeArguments());
							stringBuffer.append(TEXT_25);
							stringBuffer.append(labelFeature.getGetAccessor());
							stringBuffer.append(TEXT_28);
						}
						stringBuffer.append(TEXT_32);
					}
					stringBuffer.append(TEXT_33);
					stringBuffer.append(genClass.getName());
					stringBuffer.append(TEXT_34);
					stringBuffer.append(genModel.getNonNLS());
					stringBuffer.append(genModel.getNonNLS(2));
					stringBuffer.append(genModel.getNonNLS(3));
					stringBuffer.append(TEXT_23);
				}
			} else {
				stringBuffer.append(TEXT_35);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_22);
				stringBuffer.append(genModel.getNonNLS());
				stringBuffer.append(genModel.getNonNLS(2));
				stringBuffer.append(genModel.getNonNLS(3));
				stringBuffer.append(TEXT_23);
			}
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}
}