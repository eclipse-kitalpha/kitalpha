//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.coredomain.patterns.eoperations.viewpoint;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class insertOperationPattern extends org.eclipse.egf.emf.pattern.model.call.Class.Classinsert {
	protected static String nl;

	public static synchronized insertOperationPattern create(String lineSeparator) {
		nl = lineSeparator;
		insertOperationPattern result = new insertOperationPattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = NL + NL + "\tprotected void collectProperties(Map<String, Property> name2prop) {"
			+ NL + "\t\tfor (Viewpoint vp : getParents())" + NL
			+ "\t\t\t((ViewpointImpl) vp).collectProperties(name2prop);" + NL + "\t\tif (getPropertySet() != null) {"
			+ NL + "\t\t\tfor (Property prop : getPropertySet().getNewProperties())" + NL
			+ "\t\t\t\tname2prop.put(prop.getName(), prop);" + NL
			+ "\t\t\tfor (Property prop : getPropertySet().getHiddenProperties())" + NL
			+ "\t\t\t\tname2prop.remove(prop.getName());" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL
			+ "\tprotected void collectRules(Map<String, Rule> rules) {" + NL + "\t\tfor (Viewpoint vp : getParents())"
			+ NL + "\t\t\t((ViewpointImpl) vp).collectRules(rules);" + NL + "\t\tif (getRuleSet() != null) {" + NL
			+ "\t\t\taddElements(rules, getRuleSet().getNewRules());" + NL
			+ "\t\t\tremoveElements(rules, (getRuleSet().getHiddenRules()));" + NL + "\t\t}" + NL + "\t}" + NL + "\t"
			+ NL + "\tprotected void collectServices(Map<String, Service> services) {" + NL
			+ "\t\tfor (Viewpoint vp : getParents())" + NL + "\t\t\t((ViewpointImpl) vp).collectServices(services);"
			+ NL + "\t\tif (getServiceSet() != null) {" + NL
			+ "\t\t\taddElements(services, getServiceSet().getNewServices());" + NL
			+ "\t\t\tremoveElements(services, getServiceSet().getHiddenServices());" + NL + "\t\t}" + NL + "\t}" + NL;
	protected final String TEXT_2 = NL + NL
			+ "\tprivate static void collectParents(Viewpoint vp, EList<Viewpoint> collecteur) {" + NL
			+ "\t\tfor (Viewpoint parent : vp.getParents()) {" + NL + "\t\t\tcollectParents(parent, collecteur);" + NL
			+ "\t\t\tcollecteur.add(parent);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL
			+ "\tprotected <T extends NameElement> void addElements(Map<String, T> collector, EList<T> elts) {" + NL
			+ "\t\tfor (T elt : elts) {" + NL + "\t\t\t// if (!collector.containsKey(elt.getId()))" + NL
			+ "\t\t\tcollector.put(elt.getId(), elt);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL
			+ "\tprotected <T extends NameElement> void removeElements(Map<String, T> collector, EList<T> elts) {" + NL
			+ "\t\tfor (T elt : elts) {" + NL + "\t\t\tcollector.remove(elt.getId());" + NL + "\t\t}" + NL + "\t}" + NL
			+ NL;
	protected final String TEXT_3 = NL;

	public insertOperationPattern() {
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
		List<Object> isInterfaceList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> isImplementationList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> useInterfaceOverrideAnnotationList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> isGWTList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> forceDefaultCaseList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> indentDefaultCaseList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> publicStaticFinalFlagList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> singleWildcardList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> negativeOffsetCorrectionList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> positiveOffsetCorrectionList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> negativeOperationOffsetCorrectionList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> positiveOperationOffsetCorrectionList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object genClassParameter : genClassList) {
			for (Object genPackageParameter : genPackageList) {
				for (Object genModelParameter : genModelList) {
					for (Object isJDK50Parameter : isJDK50List) {
						for (Object isInterfaceParameter : isInterfaceList) {
							for (Object isImplementationParameter : isImplementationList) {
								for (Object useInterfaceOverrideAnnotationParameter : useInterfaceOverrideAnnotationList) {
									for (Object isGWTParameter : isGWTList) {
										for (Object forceDefaultCaseParameter : forceDefaultCaseList) {
											for (Object indentDefaultCaseParameter : indentDefaultCaseList) {
												for (Object publicStaticFinalFlagParameter : publicStaticFinalFlagList) {
													for (Object singleWildcardParameter : singleWildcardList) {
														for (Object negativeOffsetCorrectionParameter : negativeOffsetCorrectionList) {
															for (Object positiveOffsetCorrectionParameter : positiveOffsetCorrectionList) {
																for (Object negativeOperationOffsetCorrectionParameter : negativeOperationOffsetCorrectionList) {
																	for (Object positiveOperationOffsetCorrectionParameter : positiveOperationOffsetCorrectionList) {

																		this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) genClassParameter;
																		this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
																		this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;
																		this.isJDK50 = (java.lang.Boolean) isJDK50Parameter;
																		this.isInterface = (java.lang.Boolean) isInterfaceParameter;
																		this.isImplementation = (java.lang.Boolean) isImplementationParameter;
																		this.useInterfaceOverrideAnnotation = (java.lang.Boolean) useInterfaceOverrideAnnotationParameter;
																		this.isGWT = (java.lang.Boolean) isGWTParameter;
																		this.forceDefaultCase = (java.lang.Boolean) forceDefaultCaseParameter;
																		this.indentDefaultCase = (java.lang.String) indentDefaultCaseParameter;
																		this.publicStaticFinalFlag = (java.lang.String) publicStaticFinalFlagParameter;
																		this.singleWildcard = (java.lang.String) singleWildcardParameter;
																		this.negativeOffsetCorrection = (java.lang.String) negativeOffsetCorrectionParameter;
																		this.positiveOffsetCorrection = (java.lang.String) positiveOffsetCorrectionParameter;
																		this.negativeOperationOffsetCorrection = (java.lang.String) negativeOperationOffsetCorrectionParameter;
																		this.positiveOperationOffsetCorrection = (java.lang.String) positiveOperationOffsetCorrectionParameter;

																		if (preCondition(ctx)) {
																			ctx.setNode(new Node.Container(currentNode,
																					getClass()));
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

		stringBuffer.append(TEXT_3);
		stringBuffer.append(TEXT_3);
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
			parameterValues.put("isInterface", this.isInterface);
			parameterValues.put("isImplementation", this.isImplementation);
			parameterValues.put("useInterfaceOverrideAnnotation", this.useInterfaceOverrideAnnotation);
			parameterValues.put("isGWT", this.isGWT);
			parameterValues.put("forceDefaultCase", this.forceDefaultCase);
			parameterValues.put("indentDefaultCase", this.indentDefaultCase);
			parameterValues.put("publicStaticFinalFlag", this.publicStaticFinalFlag);
			parameterValues.put("singleWildcard", this.singleWildcard);
			parameterValues.put("negativeOffsetCorrection", this.negativeOffsetCorrection);
			parameterValues.put("positiveOffsetCorrection", this.positiveOffsetCorrection);
			parameterValues.put("negativeOperationOffsetCorrection", this.negativeOperationOffsetCorrection);
			parameterValues.put("positiveOperationOffsetCorrection", this.positiveOperationOffsetCorrection);
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
		parameters.put("isInterface", this.isInterface);
		parameters.put("isImplementation", this.isImplementation);
		parameters.put("useInterfaceOverrideAnnotation", this.useInterfaceOverrideAnnotation);
		parameters.put("isGWT", this.isGWT);
		parameters.put("forceDefaultCase", this.forceDefaultCase);
		parameters.put("indentDefaultCase", this.indentDefaultCase);
		parameters.put("publicStaticFinalFlag", this.publicStaticFinalFlag);
		parameters.put("singleWildcard", this.singleWildcard);
		parameters.put("negativeOffsetCorrection", this.negativeOffsetCorrection);
		parameters.put("positiveOffsetCorrection", this.positiveOffsetCorrection);
		parameters.put("negativeOperationOffsetCorrection", this.negativeOperationOffsetCorrection);
		parameters.put("positiveOperationOffsetCorrection", this.positiveOperationOffsetCorrection);
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		genModel.getImportedName("org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.NameElement");

		stringBuffer.append(TEXT_1);

		genModel.getImportedName("org.eclipse.emf.common.util.BasicEList");
		genModel.getImportedName("java.util.Map");
		genModel.getImportedName("java.util.HashMap");

		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		String cls = genClass.getName();
		return "Viewpoint".equals(cls);

	}
}