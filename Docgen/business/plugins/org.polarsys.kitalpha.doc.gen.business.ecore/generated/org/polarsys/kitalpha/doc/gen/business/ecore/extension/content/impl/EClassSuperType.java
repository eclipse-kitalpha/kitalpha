//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.doc.gen.business.ecore.extension.content.impl;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.doc.gen.business.ecore.helpers.EcoreFileNameService;
import org.polarsys.kitalpha.doc.gen.business.core.util.EscapeChars;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.polarsys.kitalpha.doc.gen.business.core.util.SiriusHelper;
import org.polarsys.kitalpha.doc.gen.business.core.util.DefaultSiriusDiagramHelper;

public class EClassSuperType {
	protected static String nl;

	public static synchronized EClassSuperType create(String lineSeparator) {
		nl = lineSeparator;
		EClassSuperType result = new EClassSuperType();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<p><strong>Inherits from: </strong><br />";
	protected final String TEXT_2 = "&nbsp;";
	protected final String TEXT_3 = NL + "</p>" + NL;
	protected final String TEXT_4 = NL + "<p><strong>Inheritance: </strong></p>";
	protected final String TEXT_5 = NL;
	protected final String TEXT_6 = NL;

	public EClassSuperType() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;
		Node.Container currentNode = ctx.getNode();

		paramDesc = new IQuery.ParameterDescription("parameter", "http://www.eclipse.org/emf/2002/Ecore#//EClass");
		queryCtx = new HashMap<String, String>();
		List<Object> parameterList = QueryHelper
				.load(ctx, "org.polarsys.kitalpha.doc.gen.business.ecore.injected.context")
				.execute(paramDesc, queryCtx, ctx);
		paramDesc = new IQuery.ParameterDescription("helper",
				"org.polarsys.kitalpha.doc.gen.business.core.util.IDiagramHelper");
		queryCtx = new HashMap<String, String>();
		List<Object> helperList = QueryHelper.load(ctx, "org.polarsys.kitalpha.doc.gen.business.ecore.diagramHelper")
				.execute(paramDesc, queryCtx, ctx);
		paramDesc = new IQuery.ParameterDescription("fileNameService",
				"org.polarsys.kitalpha.doc.gen.business.core.util.IFileNameService");
		queryCtx = new HashMap<String, String>();
		List<Object> fileNameServiceList = QueryHelper
				.load(ctx, "org.polarsys.kitalpha.doc.gen.business.ecore.inject.file.name.service")
				.execute(paramDesc, queryCtx, ctx);

		for (Object parameterParameter : parameterList) {
			for (Object helperParameter : helperList) {
				for (Object fileNameServiceParameter : fileNameServiceList) {

					this.parameter = (org.eclipse.emf.ecore.EClass) parameterParameter;
					this.helper = (org.polarsys.kitalpha.doc.gen.business.core.util.IDiagramHelper) helperParameter;
					this.fileNameService = (org.polarsys.kitalpha.doc.gen.business.core.util.IFileNameService) fileNameServiceParameter;

					if (preCondition(ctx)) {
						ctx.setNode(new Node.Container(currentNode, getClass()));
						orchestration(ctx);
					}

				}
			}
		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_6);
		stringBuffer.append(TEXT_6);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_content(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			parameterValues.put("helper", this.helper);
			parameterValues.put("fileNameService", this.fileNameService);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.emf.ecore.EClass parameter = null;

	public void set_parameter(org.eclipse.emf.ecore.EClass object) {
		this.parameter = object;
	}

	protected org.polarsys.kitalpha.doc.gen.business.core.util.IDiagramHelper helper = null;

	public void set_helper(org.polarsys.kitalpha.doc.gen.business.core.util.IDiagramHelper object) {
		this.helper = object;
	}

	protected org.polarsys.kitalpha.doc.gen.business.core.util.IFileNameService fileNameService = null;

	public void set_fileNameService(org.polarsys.kitalpha.doc.gen.business.core.util.IFileNameService object) {
		this.fileNameService = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		parameters.put("helper", this.helper);
		parameters.put("fileNameService", this.fileNameService);
		return parameters;
	}

	protected void method_content(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		String outputFolder = ctx.getValue("outputFolder").toString();
		String projectName = ctx.getValue("projectName").toString();

		Collection<DRepresentation> diagramList = SiriusHelper.getDiagramForObject(parameter);

		if ((parameter).getESuperTypes().size() > 0) {
			stringBuffer.append(TEXT_1);

			for (EClass eClass : (parameter).getESuperTypes()) {

				stringBuffer.append(
						org.polarsys.kitalpha.doc.gen.business.ecore.helpers.EcoreModelHelper.getTypeHyperLink(eClass));
				stringBuffer.append(TEXT_2);

			}

			stringBuffer.append(TEXT_3);

		}
		for (DRepresentation diagram : diagramList) {
			if ((diagram instanceof DSemanticDiagram)
					&& (((DSemanticDiagram) diagram).getDescription().getName().equals("Inheritance")
							&& ((DSemanticDiagram) diagram).getTarget() == parameter)) {
				String generatedFolder = fileNameService.getFileName(((DSemanticDiagram) diagram).getTarget());

				stringBuffer.append(TEXT_4);
				stringBuffer.append(TEXT_5);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.polarsys.kitalpha.doc.gen.business.core/egf/HTMLDocGenCommon.fcore#LogicalName=org.polarsys.kitalpha.doc.gen.business.core.sirius.DiagramGenerator" args="diagram:diagram, outputFolder:outputFolder, projectName:projectName, generatedFolder:generatedFolder, fileNameService:fileNameService, helper:helper"%>

					InternalPatternContext ictx = (InternalPatternContext) ctx;
					new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
					stringBuffer.setLength(0);

					final Map<String, Object> callParameters = new HashMap<String, Object>();
					callParameters.put("diagram", diagram);
					callParameters.put("outputFolder", outputFolder);
					callParameters.put("projectName", projectName);
					callParameters.put("generatedFolder", generatedFolder);
					callParameters.put("fileNameService", fileNameService);
					callParameters.put("helper", helper);
					CallHelper.executeWithParameterInjection(
							"platform:/plugin/org.polarsys.kitalpha.doc.gen.business.core/egf/HTMLDocGenCommon.fcore#_yyU7IvYiEd-jis7N5RhttA",
							new ExecutionContext((InternalPatternContext) ctx), callParameters);
					stringBuffer.setLength(0);
				}

			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "content", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}