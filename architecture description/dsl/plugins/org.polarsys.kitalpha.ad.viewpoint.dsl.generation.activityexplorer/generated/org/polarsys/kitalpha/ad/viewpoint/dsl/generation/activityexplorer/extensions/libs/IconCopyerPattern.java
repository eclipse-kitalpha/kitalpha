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

public class IconCopyerPattern {
	protected static String nl;

	public static synchronized IconCopyerPattern create(String lineSeparator) {
		nl = lineSeparator;
		IconCopyerPattern result = new IconCopyerPattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL;

	public IconCopyerPattern() {
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

		List<Object> iconElementList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> activityExplorerProjectNameList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object iconElementParameter : iconElementList) {
			for (Object activityExplorerProjectNameParameter : activityExplorerProjectNameList) {

				this.iconElement = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Icon) iconElementParameter;
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

		method_copyIconOffFile(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("iconElement", this.iconElement);
			parameterValues.put("activityExplorerProjectName", this.activityExplorerProjectName);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Icon iconElement = null;

	public void set_iconElement(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.Icon object) {
		this.iconElement = object;
	}

	protected java.lang.String activityExplorerProjectName = null;

	public void set_activityExplorerProjectName(java.lang.String object) {
		this.activityExplorerProjectName = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("iconElement", this.iconElement);
		parameters.put("activityExplorerProjectName", this.activityExplorerProjectName);
		return parameters;
	}

	protected void method_copyIconOffFile(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		// the source project name is the project containing the resource containing the iconElement
		final URI resourceURI = iconElement.eResource().getURI();
		String sourceProjectName = resourceURI.segment(1);
		IconsFileHelper.copyIcon(iconElement.getImagePathOff(), sourceProjectName, activityExplorerProjectName);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "copyIconOffFile", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		final String imagePathOff = iconElement.getImagePathOff();
		return imagePathOff != null && imagePathOff.trim().length() > 0;
	}
}