//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.customizations.style;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData.JavaMethodReturnType;

public class InitializeEnumerationHelperJServiceData {

	public InitializeEnumerationHelperJServiceData() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.Customizations) parameterParameter;

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
		method_initializeJServiceData(new StringBuffer(), ictx);
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

	protected void method_initializeJServiceData(final StringBuffer out, final PatternContext ctx) throws Exception {
		String package_name = (String) ctx.getValue("design.project.name") + ".service.customizations";
		String class_name = "StyleEnumerationsHelper";
		String service_name = package_name + "." + class_name;

		javaServiceData = GenerationUtil.getJavaServiceData(service_name);

		if (javaServiceData != null)
			javaServiceData.setContext(parameter);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initializeJServiceData", out.toString());
	}

	protected void method_getCorrespondingLineStyle(final StringBuffer out, final PatternContext ctx) throws Exception {
		String methodCode = "return DiagramPackage.eINSTANCE.getLineStyle().getEEnumLiteral(name);";
		String methodName = "getCorrespondingLineStyle";

		JavaMethodData javaMethodData = new JavaMethodData(methodName, JavaMethodReturnType.EEnumLiteral, methodCode);

		// Set method parameters data
		javaMethodData.addMethodParameter("any", "EObject", "any model element");
		javaMethodData.addMethodParameter("name", "String", "the name of the Enumeration literal");

		// Set method Required classes FQN
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.emf.ecore.EEnumLiteral");
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.sirius.diagram.DiagramPackage");

		// Add the method to the Java Service.
		if (javaMethodData != null)
			javaServiceData.addMethod(javaMethodData);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getCorrespondingLineStyle", out.toString());
	}

	protected void method_getCorrespondingEdgeArrows(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		String methodCode = "return DiagramPackage.eINSTANCE.getEdgeArrows().getEEnumLiteral(name);";
		String methodName = "getCorrespondingEdgeArrows";

		JavaMethodData javaMethodData = new JavaMethodData(methodName, JavaMethodReturnType.EEnumLiteral, methodCode);

		// Set method parameters data
		javaMethodData.addMethodParameter("any", "EObject", "any model element");
		javaMethodData.addMethodParameter("name", "String", "the name of the Enumeration literal");

		// Set method Required classes FQN
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.emf.ecore.EEnumLiteral");
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.sirius.diagram.DiagramPackage");

		// Add the method to the Java Service.
		if (javaMethodData != null)
			javaServiceData.addMethod(javaMethodData);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getCorrespondingEdgeArrows", out.toString());
	}

	protected void method_getCorrespondingEdgeRouting(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		String methodCode = "return DiagramPackage.eINSTANCE.getEdgeRouting().getEEnumLiteral(name);";
		String methodName = "getCorrespondingEdgeRouting";

		JavaMethodData javaMethodData = new JavaMethodData(methodName, JavaMethodReturnType.EEnumLiteral, methodCode);

		// Set method parameters data
		javaMethodData.addMethodParameter("any", "EObject", "any model element");
		javaMethodData.addMethodParameter("name", "String", "the name of the Enumeration literal");

		// Set method Required classes FQN
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.emf.ecore.EEnumLiteral");
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.sirius.diagram.DiagramPackage");

		// Add the method to the Java Service.
		if (javaMethodData != null)
			javaServiceData.addMethod(javaMethodData);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getCorrespondingEdgeRouting", out.toString());
	}

	protected void method_getCorrespondingBundledImageShape(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		String methodCode = "return DiagramPackage.eINSTANCE.getBundledImageShape().getEEnumLiteral(name);";
		String methodName = "getCorrespondingBundledImageShape";

		JavaMethodData javaMethodData = new JavaMethodData(methodName, JavaMethodReturnType.EEnumLiteral, methodCode);

		// Set method parameters data
		javaMethodData.addMethodParameter("any", "EObject", "any model element");
		javaMethodData.addMethodParameter("name", "String", "the name of the Enumeration literal");

		// Set method Required classes FQN
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.emf.ecore.EEnumLiteral");
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.sirius.diagram.DiagramPackage");

		// Add the method to the Java Service.
		if (javaMethodData != null)
			javaServiceData.addMethod(javaMethodData);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getCorrespondingBundledImageShape", out.toString());
	}

	protected void method_getCorrespondingFoldingStyle(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		String methodCode = "return DescriptionPackage.eINSTANCE.getFoldingStyle().getEEnumLiteral(name);";
		String methodName = "getCorrespondingFoldingStyle";

		JavaMethodData javaMethodData = new JavaMethodData(methodName, JavaMethodReturnType.EEnumLiteral, methodCode);

		// Set method parameters data
		javaMethodData.addMethodParameter("any", "EObject", "any model element");
		javaMethodData.addMethodParameter("name", "String", "the name of the Enumeration literal");

		// Set method Required classes FQN
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.emf.ecore.EEnumLiteral");
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.sirius.diagram.description.DescriptionPackage");

		// Add the method to the Java Service.
		if (javaMethodData != null)
			javaServiceData.addMethod(javaMethodData);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getCorrespondingFoldingStyle", out.toString());
	}

	protected void method_getCorrespondingResizeKind(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		String methodCode = "return DiagramPackage.eINSTANCE.getResizeKind().getEEnumLiteral(name);";
		String methodName = "getCorrespondingResizeKind";

		JavaMethodData javaMethodData = new JavaMethodData(methodName, JavaMethodReturnType.EEnumLiteral, methodCode);

		// Set method parameters data
		javaMethodData.addMethodParameter("any", "EObject", "any model element");
		javaMethodData.addMethodParameter("name", "String", "the name of the Enumeration literal");

		// Set method Required classes FQN
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.emf.ecore.EEnumLiteral");
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.sirius.diagram.DiagramPackage");

		// Add the method to the Java Service.
		if (javaMethodData != null)
			javaServiceData.addMethod(javaMethodData);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getCorrespondingResizeKind", out.toString());
	}

	protected void method_getCorrespondingCenteringStyle(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		String methodCode = "return DescriptionPackage.eINSTANCE.getCenteringStyle().getEEnumLiteral(name);";
		String methodName = "getCorrespondingCenteringStyle";

		JavaMethodData javaMethodData = new JavaMethodData(methodName, JavaMethodReturnType.EEnumLiteral, methodCode);

		// Set method parameters data
		javaMethodData.addMethodParameter("any", "EObject", "any model element");
		javaMethodData.addMethodParameter("name", "String", "the name of the Enumeration literal");

		// Set method Required classes FQN
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.emf.ecore.EEnumLiteral");
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.sirius.diagram.description.DescriptionPackage");

		// Add the method to the Java Service.
		if (javaMethodData != null)
			javaServiceData.addMethod(javaMethodData);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getCorrespondingCenteringStyle", out.toString());
	}

	protected void method_getCorrespondingFontFormat(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		String methodCode = "return ViewpointPackage.eINSTANCE.getFontFormat().getEEnumLiteral(name);";
		String methodName = "getCorrespondingFontFormat";

		JavaMethodData javaMethodData = new JavaMethodData(methodName, JavaMethodReturnType.EEnumLiteral, methodCode);

		// Set method parameters data
		javaMethodData.addMethodParameter("any", "EObject", "any model element");
		javaMethodData.addMethodParameter("name", "String", "the name of the Enumeration literal");

		// Set method Required classes FQN
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.emf.ecore.EEnumLiteral");
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.sirius.viewpoint.ViewpointPackage");

		// Add the method to the Java Service.
		if (javaMethodData != null)
			javaServiceData.addMethod(javaMethodData);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getCorrespondingFontFormat", out.toString());
	}

	protected void method_getCorrespondingLabelAlignment(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		String methodCode = "return ViewpointPackage.eINSTANCE.getLabelAlignment().getEEnumLiteral(name);";
		String methodName = "getCorrespondingLabelAlignment";

		JavaMethodData javaMethodData = new JavaMethodData(methodName, JavaMethodReturnType.EEnumLiteral, methodCode);

		// Set method parameters data
		javaMethodData.addMethodParameter("any", "EObject", "any model element");
		javaMethodData.addMethodParameter("name", "String", "the name of the Enumeration literal");

		// Set method Required classes FQN
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.emf.ecore.EEnumLiteral");
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.sirius.viewpoint.ViewpointPackage");

		// Add the method to the Java Service.
		if (javaMethodData != null)
			javaServiceData.addMethod(javaMethodData);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getCorrespondingLabelAlignment", out.toString());
	}

	protected void method_getCorrespondingLabelPosition(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		String methodCode = "return DiagramPackage.eINSTANCE.getLabelPosition().getEEnumLiteral(name);";
		String methodName = "getCorrespondingLabelPosition";

		JavaMethodData javaMethodData = new JavaMethodData(methodName, JavaMethodReturnType.EEnumLiteral, methodCode);

		// Set method parameters data
		javaMethodData.addMethodParameter("any", "EObject", "any model element");
		javaMethodData.addMethodParameter("name", "String", "the name of the Enumeration literal");

		// Set method Required classes FQN
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.emf.ecore.EEnumLiteral");
		javaMethodData.getRequiredClassesFQN().add("org.eclipse.sirius.diagram.DiagramPackage");

		// Add the method to the Java Service.
		if (javaMethodData != null)
			javaServiceData.addMethod(javaMethodData);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getCorrespondingLabelPosition", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.Customizations parameter;

	public void set_parameter(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.Customizations parameter) {
		this.parameter = parameter;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaServiceData javaServiceData;

	public void set_javaServiceData(
			org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaServiceData javaServiceData) {
		this.javaServiceData = javaServiceData;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
