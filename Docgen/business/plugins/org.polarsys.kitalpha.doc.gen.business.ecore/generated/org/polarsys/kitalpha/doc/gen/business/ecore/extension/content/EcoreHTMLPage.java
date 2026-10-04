//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.doc.gen.business.ecore.extension.content;

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
import org.polarsys.kitalpha.doc.gen.business.core.helper.IConceptsHelper;
import org.polarsys.kitalpha.doc.gen.business.core.services.ExtensionService;

public class EcoreHTMLPage extends org.polarsys.kitalpha.doc.gen.business.core.doccontent.ElementDocContent {
	protected static String nl;

	public static synchronized EcoreHTMLPage create(String lineSeparator) {
		nl = lineSeparator;
		EcoreHTMLPage result = new EcoreHTMLPage();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL;

	public EcoreHTMLPage() {
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

			this.parameter = (org.eclipse.emf.ecore.EObject) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_1);
		stringBuffer.append(TEXT_2);
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

	protected org.eclipse.emf.ecore.EObject element = null;

	public void set_element(org.eclipse.emf.ecore.EObject object) {
		this.element = object;
	}

	protected org.polarsys.kitalpha.doc.gen.business.core.util.IDiagramHelper helper = null;

	public void set_helper(org.polarsys.kitalpha.doc.gen.business.core.util.IDiagramHelper object) {
		this.helper = object;
	}

	protected org.polarsys.kitalpha.doc.gen.business.core.util.IFileNameService fileNameService = null;

	public void set_fileNameService(org.polarsys.kitalpha.doc.gen.business.core.util.IFileNameService object) {
		this.fileNameService = object;
	}

	protected org.eclipse.emf.ecore.EObject parameter = null;

	public void set_parameter(org.eclipse.emf.ecore.EObject object) {
		this.parameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_content(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		{
			//<%@ egf:patternInjectedCall toInject="parameter"
			//	patternId="platform:/plugin/org.polarsys.kitalpha.doc.gen.business.ecore/egf/EcoreDocGen.fcore#LogicalName=org.polarsys.kitalpha.doc.gen.business.ecore.extension.content.HTMLSection"
			//%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			ExecutionContext callCtx = new ExecutionContext((InternalPatternContext) ctx);
			callCtx.setValue(PatternContext.INJECTED_CONTEXT, parameter);
			CallHelper.executeWithContextInjection(
					"platform:/plugin/org.polarsys.kitalpha.doc.gen.business.ecore/egf/EcoreDocGen.fcore#_2kTEYCvfEeawWu7_KH9Pog",
					callCtx);
			stringBuffer.setLength(0);

		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "content", stringBuffer.toString());
	}

	protected void method_setContext(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		helper = new DefaultSiriusDiagramHelper();
		element = parameter;
		if (element instanceof ENamedElement) {
			fileName = fileNameService.getFileName(element);
		} else {
			fileName = "Default.html";
		}
		IConceptsHelper conceptsHelpersForObject = ExtensionService.INSTANCE.getConceptsHelpersForObject(element);
		title = conceptsHelpersForObject.getConceptLabel(element);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setContext", stringBuffer.toString());
	}

	protected void method_setFileNameService(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		fileNameService = EcoreFileNameService.INSTANCE;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setFileNameService", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return (parameter instanceof EPackage) || (parameter instanceof EClass) || (parameter instanceof EDataType);
	}
}