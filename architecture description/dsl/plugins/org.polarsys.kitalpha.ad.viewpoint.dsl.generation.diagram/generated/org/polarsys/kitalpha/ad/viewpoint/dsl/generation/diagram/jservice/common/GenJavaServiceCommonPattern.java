//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.jservice.common;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.sirius.viewpoint.description.DescriptionFactory;
import org.eclipse.sirius.viewpoint.description.JavaExtension;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.java.JavaClassReporter;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.MethodParameterData;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.resource.DoremiResourceManager;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.helper.conf.DiagramGenerationConfigurationHelper;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

public class GenJavaServiceCommonPattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.java.patterns.JavaAbstractPattern {
	protected static String nl;

	public static synchronized GenJavaServiceCommonPattern create(String lineSeparator) {
		nl = lineSeparator;
		GenJavaServiceCommonPattern result = new GenJavaServiceCommonPattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "package ";
	protected final String TEXT_2 = ";" + NL + "" + NL + "import java.util.ArrayList;" + NL + "import java.util.List;"
			+ NL + "" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "" + NL
			+ "import org.eclipse.sirius.diagram.DDiagram;" + NL + "import org.eclipse.sirius.diagram.DDiagramElement;"
			+ NL;
	protected final String TEXT_3 = NL + "import ";
	protected final String TEXT_4 = ";";
	protected final String TEXT_5 = NL + NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL
			+ " * This class is an implementation of the Sirius JavaExtension '<em><b>[";
	protected final String TEXT_6 = "]</b></em>'." + NL + " * <!-- end-user-doc -->" + NL + " * <p>" + NL + " * </p>"
			+ NL + " *" + NL + " * @generated" + NL + " */ " + NL + "" + NL + "public class ";
	protected final String TEXT_7 = "{";
	protected final String TEXT_8 = "\t";
	protected final String TEXT_9 = NL + "\t/**" + NL + "\t* <!-- begin-user-doc -->" + NL
			+ "\t* <!-- end-user-doc -->";
	protected final String TEXT_10 = NL + "\t* @param ";
	protected final String TEXT_11 = " : ";
	protected final String TEXT_12 = NL + "\t* @generated" + NL + "\t*/" + NL + "public ";
	protected final String TEXT_13 = " ";
	protected final String TEXT_14 = "(";
	protected final String TEXT_15 = NL + "\t\t\t\t\t\t";
	protected final String TEXT_16 = ",";
	protected final String TEXT_17 = "){";
	protected final String TEXT_18 = NL + "\t";
	protected final String TEXT_19 = NL + "// TODO Auto-generated method stub";
	protected final String TEXT_20 = NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL
			+ "\tthrow new UnsupportedOperationException();";
	protected final String TEXT_21 = NL + "}";
	protected final String TEXT_22 = NL;
	protected final String TEXT_23 = "}";
	protected final String TEXT_24 = NL;

	public GenJavaServiceCommonPattern() {
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

		if (preCondition(ctx)) {
			ctx.setNode(new Node.Container(currentNode, getClass()));
			orchestration(ctx);
		}

		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_24);
		stringBuffer.append(TEXT_24);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_addServiceToODesignModel(new StringBuffer(), ictx);

		method_generateJSCHeader(new StringBuffer(), ictx);

		method_generateJSCMethods(new StringBuffer(), ictx);

		method_generateJSCEnd(new StringBuffer(), ictx);

		return null;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaServiceData java_service_data = null;

	public void set_java_service_data(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaServiceData object) {
		this.java_service_data = object;
	}

	protected org.eclipse.emf.ecore.EObject parameter = null;

	public void set_parameter(org.eclipse.emf.ecore.EObject object) {
		this.parameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_setParameters(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		java_service_data = GenerationUtil.getJavaServiceDataFor(parameter);
		if (java_service_data != null) {
			projectname = (String) ctx.getValue("design.project.name");
			packagename = java_service_data.getPackageName();
			classname = java_service_data.getClassName();
			savetime = JavaClassReporter.whenLoopFinished;
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setParameters", stringBuffer.toString());
	}

	protected void method_addServiceToODesignModel(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		if (java_service_data != null) {
			String JS_Name = packagename + "." + classname;
			Viewpoint vp = DoremiResourceManager.getGenerateViewpoint();
			JavaExtension java_extension = DescriptionFactory.eINSTANCE.createJavaExtension();
			java_extension.setQualifiedClassName(JS_Name);
			vp.getOwnedJavaExtensions().add(java_extension);
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "addServiceToODesignModel", stringBuffer.toString());
	}

	protected void method_generateJSCHeader(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		if (java_service_data != null) {
			stringBuffer.append(TEXT_1);
			stringBuffer.append(packagename);
			stringBuffer.append(TEXT_2);

			List<String> requiredClasses = java_service_data.getAllRequiredClassesFQN();
			for (String importToAdd : requiredClasses) {
				stringBuffer.append(TEXT_3);
				stringBuffer.append(importToAdd);
				stringBuffer.append(TEXT_4);
			}
			stringBuffer.append(TEXT_5);
			stringBuffer.append(packagename + "." + classname);
			stringBuffer.append(TEXT_6);
			stringBuffer.append(classname);
			stringBuffer.append(TEXT_7);
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "generateJSCHeader", stringBuffer.toString());
	}

	protected void method_generateJSCMethods(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		if (java_service_data != null) {
			stringBuffer.append(TEXT_8);
			for (JavaMethodData iJavaMethodData : java_service_data.getMethods()) {
				String return_type = "void";
				switch (iJavaMethodData.getReturnType()) {
				case Boolean:
					return_type = "boolean";
					break;
				case EObject:
					return_type = "EObject";
					break;
				case EObjectList:
					return_type = "List<EObject>";
					break;
				case Integer:
					return_type = "int";
					break;
				case String:
					return_type = "String";
					break;
				case EEnumLiteral:
					return_type = "EEnumLiteral";
					break;
				case ConstructorType:
					return_type = "";
					break;
				}
				stringBuffer.append(TEXT_9);

				for (MethodParameterData iMethodParameterData : iJavaMethodData.getMethodParameter()) {
					stringBuffer.append(TEXT_10);
					stringBuffer.append(iMethodParameterData.getName());
					stringBuffer.append(TEXT_11);
					stringBuffer.append(iMethodParameterData.getDocumentation());
				}
				stringBuffer.append(TEXT_12);
				stringBuffer.append(return_type);
				stringBuffer.append(TEXT_13);
				stringBuffer.append(iJavaMethodData.getName());
				stringBuffer.append(TEXT_14);
				int length = iJavaMethodData.getMethodParameter().size();
				int current_index = 0;
				for (MethodParameterData iMethodParameterData : iJavaMethodData.getMethodParameter()) {
					current_index += 1;
					stringBuffer.append(TEXT_15);
					stringBuffer.append(iMethodParameterData.getType());
					stringBuffer.append(TEXT_13);
					stringBuffer.append(iMethodParameterData.getName());

					if (current_index < iJavaMethodData.getMethodParameter().size()) {
						stringBuffer.append(TEXT_16);
					}
				}
				stringBuffer.append(TEXT_17);
				String methodCode = iJavaMethodData.getMethodCode();
				if (methodCode != null && methodCode.isEmpty() == false) {
					stringBuffer.append(TEXT_18);
					stringBuffer.append(methodCode);
				} else {
					stringBuffer.append(TEXT_19);
					if (return_type.trim().length() > 0 && !return_type.equals("void")) {
						stringBuffer.append(TEXT_20);
					}
				}
				stringBuffer.append(TEXT_21);
			}
		}
		stringBuffer.append(TEXT_22);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "generateJSCMethods", stringBuffer.toString());
	}

	protected void method_generateJSCEnd(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		if (java_service_data != null) {
			stringBuffer.append(TEXT_23);
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "generateJSCEnd", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		EDataTypeUniqueEList<EObject> domain = (EDataTypeUniqueEList<EObject>) ctx.getValue("domain");
		EObject modelElement = domain.get(0);
		if (modelElement != null)
			return DiagramGenerationConfigurationHelper.generateVSM(modelElement);
		else
			return false;
	}
}