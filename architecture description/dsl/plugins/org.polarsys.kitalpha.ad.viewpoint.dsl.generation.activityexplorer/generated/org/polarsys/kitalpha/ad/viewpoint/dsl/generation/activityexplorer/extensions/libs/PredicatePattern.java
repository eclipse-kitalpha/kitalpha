//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.extensions.libs;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.internal.JavaNamingConvention;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.NamedElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.activityexplorer.internal.PredicateHelper;

public class PredicatePattern {
	protected static String nl;

	public static synchronized PredicatePattern create(String lineSeparator) {
		nl = lineSeparator;
		PredicatePattern result = new PredicatePattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = NL + "\t\t\t<Predicate" + NL + "\t\t\t\tclass=\"";
	protected final String TEXT_2 = "\">" + NL + "\t\t\t</Predicate>" + NL;
	protected final String TEXT_3 = NL;

	public PredicatePattern() {
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

		List<Object> predicatedElementList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> basePackageList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object predicatedElementParameter : predicatedElementList) {
			for (Object basePackageParameter : basePackageList) {

				this.predicatedElement = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.PredicateElement) predicatedElementParameter;
				this.basePackage = (java.lang.String) basePackageParameter;

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

		stringBuffer.append(TEXT_3);
		stringBuffer.append(TEXT_3);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_genPredicateElement(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("predicatedElement", this.predicatedElement);
			parameterValues.put("basePackage", this.basePackage);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.PredicateElement predicatedElement = null;

	public void set_predicatedElement(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.PredicateElement object) {
		this.predicatedElement = object;
	}

	protected java.lang.String basePackage = null;

	public void set_basePackage(java.lang.String object) {
		this.basePackage = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("predicatedElement", this.predicatedElement);
		parameters.put("basePackage", this.basePackage);
		return parameters;
	}

	protected void method_genPredicateElement(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		String className = JavaNamingConvention.getJavaClassFQNFor(basePackage, (NamedElement) predicatedElement,
				JavaNamingConvention.JavaUseContext.Predicate);
		stringBuffer.append(TEXT_1);
		stringBuffer.append(className);
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genPredicateElement", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return predicatedElement instanceof NamedElement && PredicateHelper.generatePredicate(predicatedElement);
	}
}