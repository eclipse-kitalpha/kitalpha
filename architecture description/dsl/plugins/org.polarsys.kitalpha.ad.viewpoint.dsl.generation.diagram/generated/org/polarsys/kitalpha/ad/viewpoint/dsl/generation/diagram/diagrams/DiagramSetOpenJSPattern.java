//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.diagrams;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.helper.desc.CoreModelHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaServiceData;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.javaservice.JavaMethodData.JavaMethodReturnType;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.StringUtils;

public class DiagramSetOpenJSPattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.common.AbstractDiagramPattern {

	public DiagramSetOpenJSPattern() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> diagramSetList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object diagramSetParameter : diagramSetList) {

			this.diagramSet = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.DiagramSet) diagramSetParameter;

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
		method_genOpenJavaService(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("diagramSet", this.diagramSet);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_genOpenJavaService(final StringBuffer out, final PatternContext ctx) throws Exception {
		String s_package_name = (String) ctx.getValue("design.project.name") + ".service";
		String short_name = CoreModelHelper.getViewpointShortName(diagramSet);
		String s_class_name = StringUtils.transformeFirstToUperCase(short_name) + "OpenJavaService";
		String s_service_name = s_package_name + "." + s_class_name;

		// This allows to create an EMPTY java service for the generated Viewpoint.
		JavaServiceData java_service_data = GenerationUtil.getJavaServiceData(s_service_name);
		java_service_data.setContext(diagramSet);

		JavaMethodData javaMethodData = new JavaMethodData(s_class_name, JavaMethodReturnType.ConstructorType);
		java_service_data.getMethods().add(javaMethodData);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genOpenJavaService", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.DiagramSet diagramSet;

	public void set_diagramSet(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.DiagramSet diagramSet) {
		this.diagramSet = diagramSet;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("diagramSet", this.diagramSet);
		return parameters;
	}

}
