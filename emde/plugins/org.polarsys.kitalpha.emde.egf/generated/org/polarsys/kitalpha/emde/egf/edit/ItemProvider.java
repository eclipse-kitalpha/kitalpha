//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.emde.egf.edit;

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
import org.polarsys.kitalpha.emde.model.edit.provider.helpers.EMDEHelper;

public class ItemProvider extends org.eclipse.egf.emf.pattern.edit.ItemProvider {
	protected static String nl;

	public static synchronized ItemProvider create(String lineSeparator) {
		nl = lineSeparator;
		ItemProvider result = new ItemProvider();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "package ";
	protected final String TEXT_3 = ";" + NL;
	protected final String TEXT_4 = NL + NL + "/**" + NL + " * This is the item provider adapter for a {@link ";
	protected final String TEXT_5 = "} object." + NL + " * <!-- begin-user-doc -->";
	protected final String TEXT_6 = NL + " * @superClass ExtensionItemProviderAdapter";
	protected final String TEXT_7 = NL + " * <!-- end-user-doc -->";
	protected final String TEXT_8 = NL + " * ";
	protected final String TEXT_9 = NL + " * @generated" + NL + " */";
	protected final String TEXT_10 = NL + "@Deprecated";
	protected final String TEXT_11 = NL + "public class ";
	protected final String TEXT_12 = NL + "\textends ";
	protected final String TEXT_13 = NL + "\timplements";
	protected final String TEXT_14 = NL + "\t\t";
	protected final String TEXT_15 = ",";
	protected final String TEXT_16 = NL + "{";
	protected final String TEXT_17 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
	protected final String TEXT_18 = " copyright = ";
	protected final String TEXT_19 = ";";
	protected final String TEXT_20 = NL;
	protected final String TEXT_21 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
	protected final String TEXT_22 = " ";
	protected final String TEXT_23 = "PropertyDescriptor;" + NL;
	protected final String TEXT_24 = NL + "\t/**" + NL
			+ "\t * This constructs an instance from a factory and a notifier." + NL + "\t * <!-- begin-user-doc -->"
			+ NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
	protected final String TEXT_25 = "(AdapterFactory adapterFactory)" + NL + "\t{" + NL + "\t\tsuper(adapterFactory);"
			+ NL + "\t}" + NL;
	protected final String TEXT_26 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_27 = NL + "\t@Override";
	protected final String TEXT_28 = NL + "\tpublic void checkChildCreationExtender(Object object) {" + NL
			+ "\t\tsuper.checkChildCreationExtender(object);" + NL + "\t\tif (object instanceof ";
	protected final String TEXT_29 = ") {" + NL + "\t\t\t";
	protected final String TEXT_30 = " eObject = (EObject) object;";
	protected final String TEXT_31 = NL + "\t\t\t// Process ";
	protected final String TEXT_32 = NL + "\t\t\tif (";
	protected final String TEXT_33 = "PropertyDescriptor != null) {" + NL + "\t\t\t\tObject ";
	protected final String TEXT_34 = "Value = eObject.eGet(";
	protected final String TEXT_35 = ", true);" + NL + "\t\t\t\tif (";
	protected final String TEXT_36 = "Value != null && ";
	protected final String TEXT_37 = "Value instanceof ";
	protected final String TEXT_38 = " && ";
	protected final String TEXT_39 = ".getInstance(eObject).isExtensionModelDisabled((EObject) ";
	protected final String TEXT_40 = "Value)) {" + NL + "\t\t\t\t\titemPropertyDescriptors.remove(";
	protected final String TEXT_41 = "PropertyDescriptor);" + NL + "\t\t\t\t} else if (";
	protected final String TEXT_42 = "Value == null && ";
	protected final String TEXT_43 = ".getAnyType(eObject, ";
	protected final String TEXT_44 = ") != null) {" + NL + "\t\t\t\t\titemPropertyDescriptors.remove(";
	protected final String TEXT_45 = "PropertyDescriptor);\t\t\t\t  \t\t\t\t\t" + NL
			+ "\t\t\t\t} else if (itemPropertyDescriptors.contains(";
	protected final String TEXT_46 = "PropertyDescriptor) == false) {" + NL + "\t\t\t\t\titemPropertyDescriptors.add(";
	protected final String TEXT_47 = "PropertyDescriptor);" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
	protected final String TEXT_48 = NL + "\t\t}\t\t" + NL + "\t}" + NL;
	protected final String TEXT_49 = NL + "\t/**" + NL
			+ "\t * This returns the property descriptors for the adapted class." + NL + "\t * <!-- begin-user-doc -->"
			+ NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_50 = NL + "\tpublic ";
	protected final String TEXT_51 = " getPropertyDescriptors(Object object)" + NL + "\t{" + NL
			+ "\t\tif (itemPropertyDescriptors == null)" + NL + "\t\t{" + NL
			+ "\t\t\tsuper.getPropertyDescriptors(object);" + NL;
	protected final String TEXT_52 = NL + "\t\t\tadd";
	protected final String TEXT_53 = "PropertyDescriptor(object);";
	protected final String TEXT_54 = NL + "\t\t}";
	protected final String TEXT_55 = NL + "\t\t// begin-extension-code" + NL + "\t\tcheckChildCreationExtender(object);"
			+ NL + "\t\t// end-extension-code";
	protected final String TEXT_56 = NL + "\t\treturn itemPropertyDescriptors;" + NL + "\t}" + NL;
	protected final String TEXT_57 = NL + "\t/**" + NL + "\t * This adds a property descriptor for the ";
	protected final String TEXT_58 = " feature." + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->";
	protected final String TEXT_59 = NL + "\t * ";
	protected final String TEXT_60 = NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_61 = NL + "\t@Deprecated";
	protected final String TEXT_62 = NL + "\tprotected void add";
	protected final String TEXT_63 = "PropertyDescriptor(Object object)" + NL + "\t{";
	protected final String TEXT_64 = NL + "\t}" + NL;
	protected final String TEXT_65 = NL + "\t/**" + NL
			+ "\t * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an"
			+ NL
			+ "\t * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or"
			+ NL + "\t * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */";
	protected final String TEXT_66 = " getChildrenFeatures(Object object)" + NL + "\t{" + NL
			+ "\t\tif (childrenFeatures == null)" + NL + "\t\t{" + NL + "\t\t\tsuper.getChildrenFeatures(object);";
	protected final String TEXT_67 = NL + "\t\t\tchildrenFeatures.add(";
	protected final String TEXT_68 = ");";
	protected final String TEXT_69 = NL + "\t\t}" + NL + "\t\treturn childrenFeatures;" + NL + "\t}" + NL;
	protected final String TEXT_70 = NL + "\tprotected ";
	protected final String TEXT_71 = " getChildFeature(Object object, Object child)" + NL + "\t{" + NL
			+ "\t\t// Check the type of the specified child object and return the proper feature to use for" + NL
			+ "\t\t// adding (see {@link AddCommand}) it as a child." + NL + "" + NL
			+ "\t\treturn super.getChildFeature(object, child);" + NL + "\t}" + NL;
	protected final String TEXT_72 = NL + "\tpublic boolean hasChildren(Object object)" + NL + "\t{" + NL
			+ "\t\treturn hasChildren(object, ";
	protected final String TEXT_73 = ");" + NL + "\t}" + NL;
	protected final String TEXT_74 = NL + "\t/**" + NL + "\t * This returns ";
	protected final String TEXT_75 = ".gif." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->"
			+ NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_76 = NL + "\tpublic Object getImage(Object object)" + NL + "\t{" + NL
			+ "\t\treturn overlayImage(object, getResourceLocator().getImage(\"full/obj16/";
	protected final String TEXT_77 = "\"));";
	protected final String TEXT_78 = NL + "\t/**" + NL
			+ "\t * This returns <code>getImage(object)</code> for the column index <code>0</code> or <code>super.getImage(object)</code> otherwise."
			+ NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL
			+ "\t * @see #getText(Object)" + NL + "\t * @see #getColumnText(Object, int)" + NL + "\t * @generated" + NL
			+ "\t */";
	protected final String TEXT_79 = NL + "\tpublic Object getColumnImage(Object object, int columnIndex)" + NL + "\t{"
			+ NL + "\t\t// TODO: implement this method to return appropriate information for each column." + NL
			+ "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL
			+ "\t\treturn columnIndex == 0 ? getImage(object) : super.getImage(object);" + NL + "\t}" + NL;
	protected final String TEXT_80 = NL + "\tprotected boolean shouldComposeCreationImage()" + NL + "\t{" + NL
			+ "\t\treturn true;" + NL + "\t}" + NL;
	protected final String TEXT_81 = NL + "\t/**" + NL + "\t * This returns the label text for the adapted class." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */";
	protected final String TEXT_82 = NL + "\tpublic String getText(Object object)" + NL + "\t{";
	protected final String TEXT_83 = NL + "\t/**" + NL
			+ "\t * This returns <code>getText(object)</code> for the column index <code>0</code> or <code>super.getText(object)</code> otherwise."
			+ NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL
			+ "\t * @see #getImage(Object)" + NL + "\t * @see #getColumnImage(Object, int)" + NL + "\t * @generated"
			+ NL + "\t */";
	protected final String TEXT_84 = NL + "\tpublic String getColumnText(Object object, int columnIndex)" + NL + "\t{"
			+ NL + "\t\t// TODO: implement this method to return appropriate information for each column." + NL
			+ "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL
			+ "\t\treturn columnIndex == 0 ? getText(object) : super.getText(object);" + NL + "\t}" + NL;
	protected final String TEXT_85 = NL + "\t/**" + NL
			+ "\t * This returns the label styled text for the adapted class." + NL + "\t * <!-- begin-user-doc -->"
			+ NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_86 = NL + "\tpublic Object getStyledText(Object object)" + NL + "\t{";
	protected final String TEXT_87 = NL + "\t}";
	protected final String TEXT_88 = NL + NL + "\t/**" + NL
			+ "\t * This handles model notifications by calling {@link #updateChildren} to update any cached" + NL
			+ "\t * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */";
	protected final String TEXT_89 = NL + "\tpublic void notifyChanged(Notification notification)" + NL + "\t{" + NL
			+ "\t\tupdateChildren(notification);";
	protected final String TEXT_90 = NL + NL + "\t\tswitch (notification.getFeatureID(";
	protected final String TEXT_91 = ".class))" + NL + "\t\t{";
	protected final String TEXT_92 = NL + "\t\t\tcase ";
	protected final String TEXT_93 = ":";
	protected final String TEXT_94 = NL + "\t\t\t\tfireNotifyChanged(new ";
	protected final String TEXT_95 = "(notification, notification.getNotifier(), false, true));" + NL
			+ "\t\t\t\treturn;";
	protected final String TEXT_96 = "(notification, notification.getNotifier(), true, false));" + NL
			+ "\t\t\t\treturn;";
	protected final String TEXT_97 = "(notification, notification.getNotifier(), true, true));" + NL
			+ "\t\t\t\treturn;";
	protected final String TEXT_98 = NL + "\t\t\tdefault:";
	protected final String TEXT_99 = "\t\tsuper.notifyChanged(notification);";
	protected final String TEXT_100 = "\t\treturn;" + NL + "\t\t\t}";
	protected final String TEXT_101 = NL + "\t/**" + NL
			+ "\t * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children" + NL
			+ "\t * that can be created under this object." + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_102 = NL + "\tprotected void collectNewChildDescriptors(";
	protected final String TEXT_103 = " newChildDescriptors, Object object)" + NL + "\t{" + NL
			+ "\t\tsuper.collectNewChildDescriptors(newChildDescriptors, object);";
	protected final String TEXT_104 = NL + "\t/**" + NL
			+ "\t * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */";
	protected final String TEXT_105 = NL
			+ "\tpublic String getCreateChildText(Object owner, Object feature, Object child, ";
	protected final String TEXT_106 = " selection)" + NL + "\t{" + NL + "\t\tObject childFeature = feature;" + NL
			+ "\t\tObject childObject = child;" + NL;
	protected final String TEXT_107 = NL + "\t\tif (childFeature instanceof ";
	protected final String TEXT_108 = ".isFeatureMap((EStructuralFeature)childFeature))" + NL + "\t\t{" + NL + "\t\t\t";
	protected final String TEXT_109 = ".Entry entry = (FeatureMap.Entry)childObject;" + NL
			+ "\t\t\tchildFeature = entry.getEStructuralFeature();" + NL + "\t\t\tchildObject = entry.getValue();" + NL
			+ "\t\t}" + NL;
	protected final String TEXT_110 = NL + "\t\tboolean qualify =";
	protected final String TEXT_111 = NL + "\t\t\tchildFeature == ";
	protected final String TEXT_112 = NL + NL + "\t\tif (qualify)" + NL + "\t\t{" + NL + "\t\t\treturn getString" + NL
			+ "\t\t\t\t(\"_UI_CreateChild_text2\",";
	protected final String TEXT_113 = NL
			+ "\t\t\t\t new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });"
			+ NL + "\t\t}" + NL + "\t\treturn super.getCreateChildText(owner, feature, child, selection);" + NL + "\t}"
			+ NL;
	protected final String TEXT_114 = NL + "\t/**" + NL
			+ "\t * Return the resource locator for this item provider's resources." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */";
	protected final String TEXT_115 = " getResourceLocator()" + NL + "\t{";
	protected final String TEXT_116 = NL + "\t\treturn ((";
	protected final String TEXT_117 = ")adapterFactory).getResourceLocator();";
	protected final String TEXT_118 = NL + "\t\treturn ";
	protected final String TEXT_119 = ".INSTANCE;";
	protected final String TEXT_120 = NL + "}";
	protected final String TEXT_121 = NL;

	public ItemProvider() {
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

		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_121);
		stringBuffer.append(TEXT_121);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		/**
		 * Copyright (c) 2002-2019 IBM Corporation and others.
		 * All rights reserved.   This program and the accompanying materials
		 * are made available under the terms of the Eclipse Public License v2.0
		 * which accompanies this distribution, and is available at
		 * http://www.eclipse.org/legal/epl-v20.html
		 *
		 * Contributors:
		 *   IBM - Initial API and implementation
		 *   Alexander Fedorov <alexander.fedorov@arsysop.ru> - Bug 546714
		 */

		GenClass genClass = (GenClass) argument;
		GenPackage genPackage = genClass.getGenPackage();
		GenModel genModel = genPackage.getGenModel();
		final boolean isJDK50 = genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50;
		final boolean forceDefaultCase = genModel.isSwitchMissingDefaultCase();
		String indentDefaultCase = forceDefaultCase ? "\t\t" : "";
		stringBuffer.append(TEXT_1);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderJava" args="parameter:argument"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("argument", parameter);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_XHLrsCwtEd-jc5T-XaRJlg",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(genPackage.getProviderPackageName());
		stringBuffer.append(TEXT_3);
		boolean hasNonManyEReferences = false;
		genModel.addImport("org.eclipse.emf.common.notify.AdapterFactory");
		genModel.addImport("org.eclipse.emf.common.notify.Notification");
		genModel.addImport("org.eclipse.emf.edit.provider.IEditingDomainItemProvider");
		genModel.addImport("org.eclipse.emf.edit.provider.IItemLabelProvider");
		genModel.addImport("org.eclipse.emf.edit.provider.IItemPropertySource");
		genModel.addImport("org.eclipse.emf.edit.provider.IStructuredItemContentProvider");
		genModel.addImport("org.eclipse.emf.edit.provider.ITreeItemContentProvider");
		String _List = genModel.getImportedName(
				genModel.useGenerics() ? "java.util.List<org.eclipse.emf.edit.provider.IItemPropertyDescriptor>"
						: "java.util.List");
		genModel.markImportLocation(stringBuffer);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(genClass.getRawQualifiedInterfaceName());
		stringBuffer.append(TEXT_5);
		if ((genPackage.isExtensibleProviderFactory() || genPackage.isChildCreationExtenders())
				&& genClass.getProviderBaseClassName() == null) {
			stringBuffer.append(TEXT_6);
		}
		stringBuffer.append(TEXT_7);
		if (genClass.hasImplicitAPITags()) {
			stringBuffer.append(TEXT_8);
			stringBuffer.append(genClass.getImplicitAPITags(genModel.getIndentation(stringBuffer)));
		}
		stringBuffer.append(TEXT_9);
		if (isJDK50 && genClass.hasImplicitAPIDeprecatedTag()) {
			stringBuffer.append(TEXT_10);
		}
		stringBuffer.append(TEXT_11);
		stringBuffer.append(genClass.getProviderClassName());
		if ((genPackage.isExtensibleProviderFactory() || genPackage.isChildCreationExtenders())
				&& genClass.getProviderBaseClassName() == null) {
			stringBuffer.append(TEXT_12);
			stringBuffer.append(
					genModel.getImportedName("org.polarsys.kitalpha.emde.extension.edit.ExtensionItemProviderAdapter"));
		} else {
			stringBuffer.append(TEXT_12);
			stringBuffer.append(genClass.getProviderBaseClassName() != null ? genClass.getProviderBaseClassName()
					: genModel.getImportedName("org.eclipse.emf.edit.provider.ItemProviderAdapter"));
		}
		stringBuffer.append(TEXT_13);
		for (Iterator<String> i = genPackage.getProviderSupportedTypes().iterator(); i.hasNext();) {
			stringBuffer.append(TEXT_14);
			stringBuffer.append(genModel.getImportedName(i.next()));
			if (i.hasNext()) {
				stringBuffer.append(TEXT_15);
			}
		}
		stringBuffer.append(TEXT_16);
		if (genModel.hasCopyrightField()) {
			stringBuffer.append(TEXT_17);
			stringBuffer.append(genModel.getImportedName("java.lang.String"));
			stringBuffer.append(TEXT_18);
			stringBuffer.append(genModel.getCopyrightFieldLiteral());
			stringBuffer.append(TEXT_19);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_20);
		}
		if (ExtensionHelper.hasExtensibleProviderFactory(genModel)
				|| ExtensionHelper.hasChildCreationExtenders(genModel)) {
			for (GenFeature genFeature : genClass.getPropertyFeatures()) {
				if (genFeature.getEcoreFeature() instanceof EReference
						&& genFeature.getEcoreFeature().isMany() == false) {
					hasNonManyEReferences = true;
					stringBuffer.append(TEXT_21);
					stringBuffer
							.append(genModel.getImportedName("org.eclipse.emf.edit.provider.IItemPropertyDescriptor"));
					stringBuffer.append(TEXT_22);
					stringBuffer.append(genFeature.getName());
					stringBuffer.append(TEXT_23);
				}
			}
		}
		stringBuffer.append(TEXT_24);
		stringBuffer.append(genClass.getProviderClassName());
		stringBuffer.append(TEXT_25);
		if (hasNonManyEReferences) {
			stringBuffer.append(TEXT_26);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_27);
			}
			stringBuffer.append(TEXT_28);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
			stringBuffer.append(TEXT_29);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
			stringBuffer.append(TEXT_30);
			for (GenFeature genFeature : genClass.getPropertyFeatures()) {
				if (genFeature.getEcoreFeature() instanceof EReference
						&& genFeature.getEcoreFeature().isMany() == false) {
					stringBuffer.append(TEXT_31);
					stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
					stringBuffer.append(TEXT_32);
					stringBuffer.append(genFeature.getName());
					stringBuffer.append(TEXT_33);
					stringBuffer.append(genFeature.getName());
					stringBuffer.append(TEXT_34);
					stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
					stringBuffer.append(TEXT_35);
					stringBuffer.append(genFeature.getName());
					stringBuffer.append(TEXT_36);
					stringBuffer.append(genFeature.getName());
					stringBuffer.append(TEXT_37);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
					stringBuffer.append(TEXT_38);
					stringBuffer.append(
							genModel.getImportedName("org.polarsys.kitalpha.emde.extension.ModelExtensionHelper"));
					stringBuffer.append(TEXT_39);
					stringBuffer.append(genFeature.getName());
					stringBuffer.append(TEXT_40);
					stringBuffer.append(genFeature.getName());
					stringBuffer.append(TEXT_41);
					stringBuffer.append(genFeature.getName());
					stringBuffer.append(TEXT_42);
					stringBuffer.append(
							genModel.getImportedName("org.polarsys.kitalpha.emde.extension.ExtensionModelManager"));
					stringBuffer.append(TEXT_43);
					stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
					stringBuffer.append(TEXT_44);
					stringBuffer.append(genFeature.getName());
					stringBuffer.append(TEXT_45);
					stringBuffer.append(genFeature.getName());
					stringBuffer.append(TEXT_46);
					stringBuffer.append(genFeature.getName());
					stringBuffer.append(TEXT_47);
				}
			}
			stringBuffer.append(TEXT_48);
		}
		stringBuffer.append(TEXT_49);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_27);
		}
		stringBuffer.append(TEXT_50);
		stringBuffer.append(_List);
		stringBuffer.append(TEXT_51);
		for (GenFeature genFeature : genClass.getPropertyFeatures()) {
			stringBuffer.append(TEXT_52);
			stringBuffer.append(genFeature.getCapName());
			stringBuffer.append(TEXT_53);
		}
		stringBuffer.append(TEXT_54);
		if (genClass.getProviderBaseClassName() != null && EMDEHelper.isExtensibleElement(genClass.getEcoreClass())
				&& (ExtensionHelper.hasExtensibleProviderFactory(genModel)
						|| ExtensionHelper.hasChildCreationExtenders(genModel))) {
			stringBuffer.append(TEXT_55);
		}
		stringBuffer.append(TEXT_56);
		for (GenFeature genFeature : genClass.getPropertyFeatures()) {
			stringBuffer.append(TEXT_57);
			stringBuffer.append(genFeature.getFormattedName());
			stringBuffer.append(TEXT_58);
			if (genFeature.hasAPITags()) {
				stringBuffer.append(TEXT_59);
				stringBuffer.append(genFeature.getAPITags(genModel.getIndentation(stringBuffer)));
			}
			stringBuffer.append(TEXT_60);
			if (isJDK50 && genFeature.hasAPIDeprecatedTag()) {
				stringBuffer.append(TEXT_61);
			}
			stringBuffer.append(TEXT_62);
			stringBuffer.append(genFeature.getCapName());
			stringBuffer.append(TEXT_63);
			stringBuffer.append(TEXT_20);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.addPropertyDescriptor.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,_List:_List"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genFeature", genFeature);
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				callParameters.put("isJDK50", isJDK50);
				callParameters.put("forceDefaultCase", forceDefaultCase);
				callParameters.put("indentDefaultCase", indentDefaultCase);
				callParameters.put("_List", _List);
				CallHelper.executeWithParameterInjection(
						"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_03mkEWJ-Ed-FqczH3ESmRw",
						new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//ItemProvider/addPropertyDescriptor.override.javajetinc
			stringBuffer.append(TEXT_64);
		}
		if (!genClass.getChildrenFeatures().isEmpty()) {
			stringBuffer.append(TEXT_65);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_27);
			}
			stringBuffer.append(TEXT_50);
			stringBuffer.append(genModel.getImportedName(
					genModel.useGenerics() ? "java.util.Collection<? extends org.eclipse.emf.ecore.EStructuralFeature>"
							: "java.util.Collection"));
			stringBuffer.append(TEXT_66);
			for (GenFeature genFeature : genClass.getChildrenFeatures()) {
				stringBuffer.append(TEXT_67);
				stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
				stringBuffer.append(TEXT_68);
			}
			stringBuffer.append(TEXT_69);
			if (!genClass.getChildrenFeatures().isEmpty()) {
				stringBuffer.append(TEXT_26);
				if (genModel.useClassOverrideAnnotation()) {
					stringBuffer.append(TEXT_27);
				}
				stringBuffer.append(TEXT_70);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
				stringBuffer.append(TEXT_71);
			}
		}
		if (genClass.needsHasChildrenMethodOverride()) {
			stringBuffer.append(TEXT_26);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_27);
			}
			stringBuffer.append(TEXT_72);
			stringBuffer.append(genModel.isOptimizedHasChildren());
			stringBuffer.append(TEXT_73);
		}
		if (genClass.isImage()) {
			stringBuffer.append(TEXT_74);
			stringBuffer.append(genClass.getName());
			stringBuffer.append(TEXT_75);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_27);
			}
			stringBuffer.append(TEXT_76);
			stringBuffer.append(genClass.getName());
			stringBuffer.append(TEXT_77);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_64);
		}
		if (genClass.getProviderImplementsClassNames()
				.contains("org.eclipse.emf.edit.provider.ITableItemLabelProvider")) {
			stringBuffer.append(TEXT_78);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_27);
			}
			stringBuffer.append(TEXT_79);
		}
		if (genModel.getRuntimeVersion().getValue() >= GenRuntimeVersion.EMF26_VALUE && !genModel.isCreationIcons()) {
			stringBuffer.append(TEXT_26);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_27);
			}
			stringBuffer.append(TEXT_80);
		}
		stringBuffer.append(TEXT_81);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_27);
		}
		stringBuffer.append(TEXT_82);
		stringBuffer.append(TEXT_20);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.getText.override" args="genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,_List:_List"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("genClass", genClass);
			callParameters.put("genPackage", genPackage);
			callParameters.put("genModel", genModel);
			callParameters.put("isJDK50", isJDK50);
			callParameters.put("forceDefaultCase", forceDefaultCase);
			callParameters.put("indentDefaultCase", indentDefaultCase);
			callParameters.put("_List", _List);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_03wVEGJ-Ed-FqczH3ESmRw",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		//ItemProvider/getText.override.javajetinc
		stringBuffer.append(TEXT_64);
		if (genClass.getProviderImplementsClassNames()
				.contains("org.eclipse.emf.edit.provider.ITableItemLabelProvider")) {
			stringBuffer.append(TEXT_83);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_27);
			}
			stringBuffer.append(TEXT_84);
		}
		if (genModel.isStyleProviders()) {
			stringBuffer.append(TEXT_85);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_27);
			}
			stringBuffer.append(TEXT_86);
			stringBuffer.append(TEXT_20);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.getStyledText.override" args="genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,_List:_List"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				callParameters.put("isJDK50", isJDK50);
				callParameters.put("forceDefaultCase", forceDefaultCase);
				callParameters.put("indentDefaultCase", indentDefaultCase);
				callParameters.put("_List", _List);
				CallHelper.executeWithParameterInjection(
						"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_sd5EMKoMEeOCpsO1cKKCxA",
						new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//ItemProvider/getStyledText.override.javajetinc
			stringBuffer.append(TEXT_87);
		}
		stringBuffer.append(TEXT_88);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_27);
		}
		stringBuffer.append(TEXT_89);
		boolean hasSwitch = !genClass.getLabelNotifyFeatures().isEmpty()
				|| !genClass.getContentNotifyFeatures().isEmpty()
				|| !genClass.getLabelAndContentNotifyFeatures().isEmpty();
		if (hasSwitch) {
			stringBuffer.append(TEXT_90);
			stringBuffer.append(genClass.getRawImportedInterfaceName());
			stringBuffer.append(TEXT_91);
			if (!genClass.getLabelNotifyFeatures().isEmpty()) {
				for (GenFeature genFeature : genClass.getLabelNotifyFeatures()) {
					stringBuffer.append(TEXT_92);
					stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
					stringBuffer.append(TEXT_93);
				}
				stringBuffer.append(TEXT_94);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ViewerNotification"));
				stringBuffer.append(TEXT_95);
			}
			if (!genClass.getContentNotifyFeatures().isEmpty()) {
				for (GenFeature genFeature : genClass.getContentNotifyFeatures()) {
					stringBuffer.append(TEXT_92);
					stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
					stringBuffer.append(TEXT_93);
				}
				stringBuffer.append(TEXT_94);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ViewerNotification"));
				stringBuffer.append(TEXT_96);
			}
			if (!genClass.getLabelAndContentNotifyFeatures().isEmpty()) {
				for (GenFeature genFeature : genClass.getLabelAndContentNotifyFeatures()) {
					stringBuffer.append(TEXT_92);
					stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
					stringBuffer.append(TEXT_93);
				}
				stringBuffer.append(TEXT_94);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ViewerNotification"));
				stringBuffer.append(TEXT_97);
			}
			if (forceDefaultCase) {
				stringBuffer.append(TEXT_98);
			} else {
				stringBuffer.append(TEXT_54);
			}
		}
		stringBuffer.append(TEXT_20);
		stringBuffer.append(hasSwitch ? indentDefaultCase : "");
		stringBuffer.append(TEXT_99);
		if (hasSwitch && forceDefaultCase) {
			stringBuffer.append(TEXT_20);
			stringBuffer.append(indentDefaultCase);
			stringBuffer.append(TEXT_100);
		}
		stringBuffer.append(TEXT_64);
		if (genModel.isCreationCommands()) {
			stringBuffer.append(TEXT_101);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_27);
			}
			stringBuffer.append(TEXT_102);
			stringBuffer.append(genModel.getImportedName(
					genModel.useGenerics() ? "java.util.Collection<java.lang.Object>" : "java.util.Collection"));
			stringBuffer.append(TEXT_103);
			for (GenClass.ChildCreationData childCreationData : genClass.getChildCreationData()) {
				GenFeature createFeature = childCreationData.createFeature;
				GenFeature delegatedFeature = childCreationData.delegatedFeature;
				GenClassifier createClassifier = childCreationData.createClassifier;
				if (createFeature.isFeatureMapType()) {
					if (delegatedFeature.isReferenceType()) {
						GenClass createClass = (GenClass) createClassifier;
						stringBuffer.append(TEXT_20);
						{
							//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.newChildDescriptorsReferenceDelegatedFeature.override" args="createClass:createClass,createFeature:createFeature,delegatedFeature:delegatedFeature,createClassifier:createClassifier,childCreationData:childCreationData,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50"%>

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
							callParameters.put("isJDK50", isJDK50);
							CallHelper.executeWithParameterInjection(
									"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_036GEGJ-Ed-FqczH3ESmRw",
									new ExecutionContext((InternalPatternContext) ctx), callParameters);
							stringBuffer.setLength(0);
						}

						//ItemProvider/newChildDescriptorsReferenceDelegatedFeature.override.javajetinc
					} else {
						GenDataType createDataType = (GenDataType) createClassifier;
						stringBuffer.append(TEXT_20);
						{
							//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.newChildDescriptorsAttributeDelegatedFeature.override" args="createDataType:createDataType,createFeature:createFeature,delegatedFeature:delegatedFeature,createClassifier:createClassifier,childCreationData:childCreationData,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50"%>

							InternalPatternContext ictx = (InternalPatternContext) ctx;
							new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
							stringBuffer.setLength(0);

							final Map<String, Object> callParameters = new HashMap<String, Object>();
							callParameters.put("createDataType", createDataType);
							callParameters.put("createFeature", createFeature);
							callParameters.put("delegatedFeature", delegatedFeature);
							callParameters.put("createClassifier", createClassifier);
							callParameters.put("childCreationData", childCreationData);
							callParameters.put("genClass", genClass);
							callParameters.put("genPackage", genPackage);
							callParameters.put("genModel", genModel);
							callParameters.put("isJDK50", isJDK50);
							CallHelper.executeWithParameterInjection(
									"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_04WyAGJ-Ed-FqczH3ESmRw",
									new ExecutionContext((InternalPatternContext) ctx), callParameters);
							stringBuffer.setLength(0);
						}

						//ItemProvider/newChildDescriptorsAttributeDelegatedFeature.override.javajetinc
					}
				} else if (createFeature.isReferenceType()) {
					GenClass createClass = (GenClass) createClassifier;
					stringBuffer.append(TEXT_20);
					{
						//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.newChildDescriptorsReferenceFeature.override" args="createClass:createClass,createFeature:createFeature,delegatedFeature:delegatedFeature,createClassifier:createClassifier,childCreationData:childCreationData,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50"%>

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
						callParameters.put("isJDK50", isJDK50);
						CallHelper.executeWithParameterInjection(
								"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_04ps8GJ-Ed-FqczH3ESmRw",
								new ExecutionContext((InternalPatternContext) ctx), callParameters);
						stringBuffer.setLength(0);
					}

					//ItemProvider/newChildDescriptorsReferenceFeature.override.javajetinc 
				} else {
					GenDataType createDataType = (GenDataType) createClassifier;
					stringBuffer.append(TEXT_20);
					{
						//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.newChildDescriptorsAttributeFeature.override" args="createDataType:createDataType,createFeature:createFeature,delegatedFeature:delegatedFeature,createClassifier:createClassifier,childCreationData:childCreationData,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50"%>

						InternalPatternContext ictx = (InternalPatternContext) ctx;
						new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
						stringBuffer.setLength(0);

						final Map<String, Object> callParameters = new HashMap<String, Object>();
						callParameters.put("createDataType", createDataType);
						callParameters.put("createFeature", createFeature);
						callParameters.put("delegatedFeature", delegatedFeature);
						callParameters.put("createClassifier", createClassifier);
						callParameters.put("childCreationData", childCreationData);
						callParameters.put("genClass", genClass);
						callParameters.put("genPackage", genPackage);
						callParameters.put("genModel", genModel);
						callParameters.put("isJDK50", isJDK50);
						CallHelper.executeWithParameterInjection(
								"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_048n4GJ-Ed-FqczH3ESmRw",
								new ExecutionContext((InternalPatternContext) ctx), callParameters);
						stringBuffer.setLength(0);
					}

					//ItemProvider/newChildDescriptorsAttributeFeature.override.javajetinc
				}
			}
			stringBuffer.append(TEXT_64);
			if (!genClass.getSharedClassCreateChildFeatures().isEmpty()) {
				stringBuffer.append(TEXT_104);
				if (genModel.useClassOverrideAnnotation()) {
					stringBuffer.append(TEXT_27);
				}
				stringBuffer.append(TEXT_105);
				stringBuffer.append(genModel
						.getImportedName(genModel.useGenerics() ? "java.util.Collection<?>" : "java.util.Collection"));
				stringBuffer.append(TEXT_106);
				if (genClass.hasFeatureMapCreateChildFeatures()) {
					stringBuffer.append(TEXT_107);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
					stringBuffer.append(TEXT_38);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMapUtil"));
					stringBuffer.append(TEXT_108);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_109);
				}
				stringBuffer.append(TEXT_110);
				for (Iterator<GenFeature> i = genClass.getSharedClassCreateChildFeatures().iterator(); i.hasNext();) {
					GenFeature createFeature = i.next();
					stringBuffer.append(TEXT_111);
					stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
					stringBuffer.append(i.hasNext() ? " ||" : ";");
				}
				stringBuffer.append(TEXT_112);
				stringBuffer.append(genModel.getNonNLS());
				stringBuffer.append(TEXT_113);
			}
		}
		if (genClass.getProviderExtendsGenClass() == null || genClass.getProviderExtendsGenClass()
				.getGenPackage() != genPackage
				&& (!genPackage.isExtensibleProviderFactory() || genClass.getProviderExtendsGenClass().getGenPackage()
						.isExtensibleProviderFactory() != genPackage.isExtensibleProviderFactory())) {
			stringBuffer.append(TEXT_114);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_27);
			}
			stringBuffer.append(TEXT_50);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.ResourceLocator"));
			stringBuffer.append(TEXT_115);
			if (genPackage.isExtensibleProviderFactory()) {
				stringBuffer.append(TEXT_116);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.IChildCreationExtender"));
				stringBuffer.append(TEXT_117);
			} else {
				stringBuffer.append(TEXT_118);
				stringBuffer.append(genPackage.getImportedEditPluginClassName());
				stringBuffer.append(TEXT_119);
			}
			stringBuffer.append(TEXT_64);
		}
		stringBuffer.append(TEXT_20);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.insert" args="genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,_List:_List,hasSwitch:hasSwitch"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("genClass", genClass);
			callParameters.put("genPackage", genPackage);
			callParameters.put("genModel", genModel);
			callParameters.put("isJDK50", isJDK50);
			callParameters.put("forceDefaultCase", forceDefaultCase);
			callParameters.put("indentDefaultCase", indentDefaultCase);
			callParameters.put("_List", _List);
			callParameters.put("hasSwitch", hasSwitch);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_051_wGJ-Ed-FqczH3ESmRw",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_120);
		genModel.emitSortedImports();
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}
}