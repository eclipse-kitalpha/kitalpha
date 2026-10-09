//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.extensions.libs;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.emf.common.util.URI;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.internal.IconsFileHelper;

public class DynamicIconCopyerPattern {
	protected static String nl;

	public static synchronized DynamicIconCopyerPattern create(String lineSeparator) {
		nl = lineSeparator;
		DynamicIconCopyerPattern result = new DynamicIconCopyerPattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL;

	public DynamicIconCopyerPattern() {
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

		List<Object> dynamicIconElementList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> activityExplorerProjectNameList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object dynamicIconElementParameter : dynamicIconElementList) {
			for (Object activityExplorerProjectNameParameter : activityExplorerProjectNameList) {

				this.dynamicIconElement = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.DynamicIcon) dynamicIconElementParameter;
				this.activityExplorerProjectName = (java.lang.String) activityExplorerProjectNameParameter;

				if (preCondition(ctx)) {
					ctx.setNode(new Node.Container(currentNode, getClass()));
					orchestration(ctx);
				}

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

		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("iconElement", this.dynamicIconElement);
			parameters.put("activityExplorerProjectName", this.activityExplorerProjectName);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer/egf/vpdslActivityExplorerGeneration.fcore#_77MRMDdmEeW9-uNJc0wiRg",
					ctx_local, parameters);
		}

		method_copyIconOnFile(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("dynamicIconElement", this.dynamicIconElement);
			parameterValues.put("activityExplorerProjectName", this.activityExplorerProjectName);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.DynamicIcon dynamicIconElement = null;

	public void set_dynamicIconElement(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.DynamicIcon object) {
		this.dynamicIconElement = object;
	}

	protected java.lang.String activityExplorerProjectName = null;

	public void set_activityExplorerProjectName(java.lang.String object) {
		this.activityExplorerProjectName = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("dynamicIconElement", this.dynamicIconElement);
		parameters.put("activityExplorerProjectName", this.activityExplorerProjectName);
		return parameters;
	}

	protected void method_copyIconOnFile(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		// the source project name is the project containing the resource containing the iconElement
		final URI resourceURI = dynamicIconElement.eResource().getURI();
		String sourceProjectName = resourceURI.segment(1);
		IconsFileHelper.copyIcon(dynamicIconElement.getImagePathOn(), sourceProjectName, activityExplorerProjectName);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "copyIconOnFile", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		if (null == dynamicIconElement) {
			return false;
		} else {
			final String imagePathOn = dynamicIconElement.getImagePathOn();
			return imagePathOn != null && imagePathOn.trim().length() > 0;
		}

	}
}