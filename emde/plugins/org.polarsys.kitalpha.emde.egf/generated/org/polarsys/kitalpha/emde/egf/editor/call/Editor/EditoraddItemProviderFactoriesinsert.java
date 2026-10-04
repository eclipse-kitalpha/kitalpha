//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.emde.egf.editor.call.Editor;

import org.polarsys.kitalpha.emde.egf.utils.*;
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

public class EditoraddItemProviderFactoriesinsert
		extends org.eclipse.egf.emf.pattern.editor.call.Editor.EditoraddItemProviderFactoriesinsert {
	protected static String nl;

	public static synchronized EditoraddItemProviderFactoriesinsert create(String lineSeparator) {
		nl = lineSeparator;
		EditoraddItemProviderFactoriesinsert result = new EditoraddItemProviderFactoriesinsert();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "\t\tfor (AdapterFactory extendedAdapterFactory : ";
	protected final String TEXT_2 = ".INSTANCE.getExtendedModelAdapterFactories(";
	protected final String TEXT_3 = ".class.getName())) {" + NL
			+ "\t\t\tadapterFactory.addAdapterFactory(extendedAdapterFactory);" + NL + "\t\t}";
	protected final String TEXT_4 = NL
			+ "\t\tadapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());";
	protected final String TEXT_5 = NL;

	public EditoraddItemProviderFactoriesinsert() {
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

		List<Object> genPackageList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genModelList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> isJDK50List = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> forceDefaultCaseList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> importedOperationClassNameList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> operationMethodNameList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _ArrayListOfObjectList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _ArrayListOfSelectionChangedListenerList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _CollectionOfSelectionChangedListenerList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _ListOfResourceList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _ArrayListOfResourceList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _CollectionOfResourceList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _MapOfResourceToDiagnosticList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _HashMapOfResourceToBooleanList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _MapOfObjectToObjectList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _HashMapOfObjectToObjectList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _LinkedHashMapOfResourceToDiagnosticList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _CollectionOfAnythingList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _ListOfAnythingList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> useExtendedLabelProviderList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> useStyledLabelProviderList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _AdapterFactoryLabelProviderList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _DelegatingAdapterFactoryLabelProviderList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _DecoratingColumLabelProviderList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _DiagnosticDecoratorList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _ArrayListOfStringList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _ListOfStringList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _ListOfPropertySheetPageList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _ArrayListOfPropertySheetPageList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object genPackageParameter : genPackageList) {
			for (Object genModelParameter : genModelList) {
				for (Object isJDK50Parameter : isJDK50List) {
					for (Object forceDefaultCaseParameter : forceDefaultCaseList) {
						for (Object importedOperationClassNameParameter : importedOperationClassNameList) {
							for (Object operationMethodNameParameter : operationMethodNameList) {
								for (Object _ArrayListOfObjectParameter : _ArrayListOfObjectList) {
									for (Object _ArrayListOfSelectionChangedListenerParameter : _ArrayListOfSelectionChangedListenerList) {
										for (Object _CollectionOfSelectionChangedListenerParameter : _CollectionOfSelectionChangedListenerList) {
											for (Object _ListOfResourceParameter : _ListOfResourceList) {
												for (Object _ArrayListOfResourceParameter : _ArrayListOfResourceList) {
													for (Object _CollectionOfResourceParameter : _CollectionOfResourceList) {
														for (Object _MapOfResourceToDiagnosticParameter : _MapOfResourceToDiagnosticList) {
															for (Object _HashMapOfResourceToBooleanParameter : _HashMapOfResourceToBooleanList) {
																for (Object _MapOfObjectToObjectParameter : _MapOfObjectToObjectList) {
																	for (Object _HashMapOfObjectToObjectParameter : _HashMapOfObjectToObjectList) {
																		for (Object _LinkedHashMapOfResourceToDiagnosticParameter : _LinkedHashMapOfResourceToDiagnosticList) {
																			for (Object _CollectionOfAnythingParameter : _CollectionOfAnythingList) {
																				for (Object _ListOfAnythingParameter : _ListOfAnythingList) {
																					for (Object useExtendedLabelProviderParameter : useExtendedLabelProviderList) {
																						for (Object useStyledLabelProviderParameter : useStyledLabelProviderList) {
																							for (Object _AdapterFactoryLabelProviderParameter : _AdapterFactoryLabelProviderList) {
																								for (Object _DelegatingAdapterFactoryLabelProviderParameter : _DelegatingAdapterFactoryLabelProviderList) {
																									for (Object _DecoratingColumLabelProviderParameter : _DecoratingColumLabelProviderList) {
																										for (Object _DiagnosticDecoratorParameter : _DiagnosticDecoratorList) {
																											for (Object _ArrayListOfStringParameter : _ArrayListOfStringList) {
																												for (Object _ListOfStringParameter : _ListOfStringList) {
																													for (Object _ListOfPropertySheetPageParameter : _ListOfPropertySheetPageList) {
																														for (Object _ArrayListOfPropertySheetPageParameter : _ArrayListOfPropertySheetPageList) {

																															this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
																															this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;
																															this.isJDK50 = (java.lang.Boolean) isJDK50Parameter;
																															this.forceDefaultCase = (java.lang.Boolean) forceDefaultCaseParameter;
																															this.importedOperationClassName = (java.lang.String) importedOperationClassNameParameter;
																															this.operationMethodName = (java.lang.String) operationMethodNameParameter;
																															this._ArrayListOfObject = (java.lang.String) _ArrayListOfObjectParameter;
																															this._ArrayListOfSelectionChangedListener = (java.lang.String) _ArrayListOfSelectionChangedListenerParameter;
																															this._CollectionOfSelectionChangedListener = (java.lang.String) _CollectionOfSelectionChangedListenerParameter;
																															this._ListOfResource = (java.lang.String) _ListOfResourceParameter;
																															this._ArrayListOfResource = (java.lang.String) _ArrayListOfResourceParameter;
																															this._CollectionOfResource = (java.lang.String) _CollectionOfResourceParameter;
																															this._MapOfResourceToDiagnostic = (java.lang.String) _MapOfResourceToDiagnosticParameter;
																															this._HashMapOfResourceToBoolean = (java.lang.String) _HashMapOfResourceToBooleanParameter;
																															this._MapOfObjectToObject = (java.lang.String) _MapOfObjectToObjectParameter;
																															this._HashMapOfObjectToObject = (java.lang.String) _HashMapOfObjectToObjectParameter;
																															this._LinkedHashMapOfResourceToDiagnostic = (java.lang.String) _LinkedHashMapOfResourceToDiagnosticParameter;
																															this._CollectionOfAnything = (java.lang.String) _CollectionOfAnythingParameter;
																															this._ListOfAnything = (java.lang.String) _ListOfAnythingParameter;
																															this.useExtendedLabelProvider = (java.lang.Boolean) useExtendedLabelProviderParameter;
																															this.useStyledLabelProvider = (java.lang.Boolean) useStyledLabelProviderParameter;
																															this._AdapterFactoryLabelProvider = (java.lang.String) _AdapterFactoryLabelProviderParameter;
																															this._DelegatingAdapterFactoryLabelProvider = (java.lang.String) _DelegatingAdapterFactoryLabelProviderParameter;
																															this._DecoratingColumLabelProvider = (java.lang.String) _DecoratingColumLabelProviderParameter;
																															this._DiagnosticDecorator = (java.lang.String) _DiagnosticDecoratorParameter;
																															this._ArrayListOfString = (java.lang.String) _ArrayListOfStringParameter;
																															this._ListOfString = (java.lang.String) _ListOfStringParameter;
																															this._ListOfPropertySheetPage = (java.lang.String) _ListOfPropertySheetPageParameter;
																															this._ArrayListOfPropertySheetPage = (java.lang.String) _ArrayListOfPropertySheetPageParameter;

																															if (preCondition(
																																	ctx)) {
																																ctx.setNode(
																																		new Node.Container(
																																				currentNode,
																																				getClass()));
																																orchestration(
																																		ctx);
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

		stringBuffer.append(TEXT_5);
		stringBuffer.append(TEXT_5);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("genPackage", this.genPackage);
			parameterValues.put("genModel", this.genModel);
			parameterValues.put("isJDK50", this.isJDK50);
			parameterValues.put("forceDefaultCase", this.forceDefaultCase);
			parameterValues.put("importedOperationClassName", this.importedOperationClassName);
			parameterValues.put("operationMethodName", this.operationMethodName);
			parameterValues.put("_ArrayListOfObject", this._ArrayListOfObject);
			parameterValues.put("_ArrayListOfSelectionChangedListener", this._ArrayListOfSelectionChangedListener);
			parameterValues.put("_CollectionOfSelectionChangedListener", this._CollectionOfSelectionChangedListener);
			parameterValues.put("_ListOfResource", this._ListOfResource);
			parameterValues.put("_ArrayListOfResource", this._ArrayListOfResource);
			parameterValues.put("_CollectionOfResource", this._CollectionOfResource);
			parameterValues.put("_MapOfResourceToDiagnostic", this._MapOfResourceToDiagnostic);
			parameterValues.put("_HashMapOfResourceToBoolean", this._HashMapOfResourceToBoolean);
			parameterValues.put("_MapOfObjectToObject", this._MapOfObjectToObject);
			parameterValues.put("_HashMapOfObjectToObject", this._HashMapOfObjectToObject);
			parameterValues.put("_LinkedHashMapOfResourceToDiagnostic", this._LinkedHashMapOfResourceToDiagnostic);
			parameterValues.put("_CollectionOfAnything", this._CollectionOfAnything);
			parameterValues.put("_ListOfAnything", this._ListOfAnything);
			parameterValues.put("useExtendedLabelProvider", this.useExtendedLabelProvider);
			parameterValues.put("useStyledLabelProvider", this.useStyledLabelProvider);
			parameterValues.put("_AdapterFactoryLabelProvider", this._AdapterFactoryLabelProvider);
			parameterValues.put("_DelegatingAdapterFactoryLabelProvider", this._DelegatingAdapterFactoryLabelProvider);
			parameterValues.put("_DecoratingColumLabelProvider", this._DecoratingColumLabelProvider);
			parameterValues.put("_DiagnosticDecorator", this._DiagnosticDecorator);
			parameterValues.put("_ArrayListOfString", this._ArrayListOfString);
			parameterValues.put("_ListOfString", this._ListOfString);
			parameterValues.put("_ListOfPropertySheetPage", this._ListOfPropertySheetPage);
			parameterValues.put("_ArrayListOfPropertySheetPage", this._ArrayListOfPropertySheetPage);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("genPackage", this.genPackage);
		parameters.put("genModel", this.genModel);
		parameters.put("isJDK50", this.isJDK50);
		parameters.put("forceDefaultCase", this.forceDefaultCase);
		parameters.put("importedOperationClassName", this.importedOperationClassName);
		parameters.put("operationMethodName", this.operationMethodName);
		parameters.put("_ArrayListOfObject", this._ArrayListOfObject);
		parameters.put("_ArrayListOfSelectionChangedListener", this._ArrayListOfSelectionChangedListener);
		parameters.put("_CollectionOfSelectionChangedListener", this._CollectionOfSelectionChangedListener);
		parameters.put("_ListOfResource", this._ListOfResource);
		parameters.put("_ArrayListOfResource", this._ArrayListOfResource);
		parameters.put("_CollectionOfResource", this._CollectionOfResource);
		parameters.put("_MapOfResourceToDiagnostic", this._MapOfResourceToDiagnostic);
		parameters.put("_HashMapOfResourceToBoolean", this._HashMapOfResourceToBoolean);
		parameters.put("_MapOfObjectToObject", this._MapOfObjectToObject);
		parameters.put("_HashMapOfObjectToObject", this._HashMapOfObjectToObject);
		parameters.put("_LinkedHashMapOfResourceToDiagnostic", this._LinkedHashMapOfResourceToDiagnostic);
		parameters.put("_CollectionOfAnything", this._CollectionOfAnything);
		parameters.put("_ListOfAnything", this._ListOfAnything);
		parameters.put("useExtendedLabelProvider", this.useExtendedLabelProvider);
		parameters.put("useStyledLabelProvider", this.useStyledLabelProvider);
		parameters.put("_AdapterFactoryLabelProvider", this._AdapterFactoryLabelProvider);
		parameters.put("_DelegatingAdapterFactoryLabelProvider", this._DelegatingAdapterFactoryLabelProvider);
		parameters.put("_DecoratingColumLabelProvider", this._DecoratingColumLabelProvider);
		parameters.put("_DiagnosticDecorator", this._DiagnosticDecorator);
		parameters.put("_ArrayListOfString", this._ArrayListOfString);
		parameters.put("_ListOfString", this._ListOfString);
		parameters.put("_ListOfPropertySheetPage", this._ListOfPropertySheetPage);
		parameters.put("_ArrayListOfPropertySheetPage", this._ArrayListOfPropertySheetPage);
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		if (genPackage.isExtensibleProviderFactory()) {
			stringBuffer.append(TEXT_1);
			stringBuffer
					.append(genModel.getImportedName("org.polarsys.kitalpha.emde.extension.ModelExtensionDescriptor"));
			stringBuffer.append(TEXT_2);
			stringBuffer.append(genPackage.getImportedItemProviderAdapterFactoryClassName());
			stringBuffer.append(TEXT_3);
		}
		stringBuffer.append(TEXT_4);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}
}