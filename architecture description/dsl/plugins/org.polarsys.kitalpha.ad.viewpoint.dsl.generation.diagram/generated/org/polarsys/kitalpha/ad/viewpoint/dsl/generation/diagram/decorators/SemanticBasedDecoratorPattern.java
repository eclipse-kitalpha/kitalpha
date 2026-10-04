//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.decorators;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.eclipse.sirius.viewpoint.description.DescriptionFactory;
import org.eclipse.sirius.viewpoint.description.SemanticBasedDecoration;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.commondata.AbstractClass;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.SemanticBasedDecorator;

public class SemanticBasedDecoratorPattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.decorators.common.AbstractDecorator {

	public SemanticBasedDecoratorPattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.SemanticBasedDecorator) parameterParameter;

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
		method_setDomain(new StringBuffer(), ictx);
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

	protected void method_createSiriusDecorator(final StringBuffer out, final PatternContext ctx) throws Exception {
		siriusDecorator = DescriptionFactory.eINSTANCE.createSemanticBasedDecoration();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createSiriusDecorator", out.toString());
	}

	protected void method_initializeVariable(final StringBuffer out, final PatternContext ctx) throws Exception {
		vpdslDecorator = parameter;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initializeVariable", out.toString());
	}

	protected void method_setDomain(final StringBuffer out, final PatternContext ctx) throws Exception {
		AbstractClass domain = ((SemanticBasedDecorator) vpdslDecorator).getDomain();
		if (domain != null) {
			String domainclass = domain.getEPackageName() + "." + domain.getName();
			((SemanticBasedDecoration) siriusDecorator).setDomainClass(domainclass);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setDomain", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.SemanticBasedDecorator parameter;

	public void set_parameter(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.SemanticBasedDecorator parameter) {
		this.parameter = parameter;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
