//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.af.rule;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.Rule;
import org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.ContextTypes;
import org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.ViewpointFactory;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpservices.VpservicesPackage;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.af.project.AFModelUtils;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.af.project.AfProjectManager;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.af.utils.AfConstants;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.java.JDTUtility;

public class RulesPattern {

	public RulesPattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpservices.Rule) parameterParameter;

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
		method_SetVpID(new StringBuffer(), ictx);
		method_getRuleSet(new StringBuffer(), ictx);
		method_createAFRule(new StringBuffer(), ictx);
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

	protected void method_createAFRule(final StringBuffer out, final PatternContext ctx) throws Exception {
		Rule rule = ViewpointFactory.eINSTANCE.createRule();

		/*** From VPDesc Model ***/
		rule.setName(parameter.getName());
		rule.setDescription(parameter.getDescription());
		rule.setType(parameter.getType().toString());
		String clazz = parameter.getClass_();
		if (clazz != null && clazz.trim().length() != 0) {
			rule.setImplementation(parameter.getClass_());
		} else {
			if (rule.getType().equals(VpservicesPackage.eINSTANCE.getRules_Types().getEEnumLiteral(0).toString())) {
				final String projectName = ctx.getValue(AfConstants.CONTRACT_PROJECT_NAME).toString();
				final String packageName = JDTUtility.getValidPackageName(projectName + ".businessrules.");
				final String className = JDTUtility.getValidClassName(parameter.getName());
				final String implementation = packageName + className;
				rule.setImplementation(implementation);
			}
		}

		/*** Generated ***/
		rule.setId(AFModelUtils.getInstance().generateAFElementID(parameter));
		rule.setLive(false);
		rule.setContext(ContextTypes.GLOBAL);
		//rule.setVpid(parameter.getVpid()); 
		rule.setVpid(parameter.getVpid());
		rule.setLanguage("");

		/*** Adding the new rule to the RuleSet ***/
		rS.getNewRules().add(rule);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createAFRule", out.toString());
	}

	protected void method_getRuleSet(final StringBuffer out, final PatternContext ctx) throws Exception {
		rS = AfProjectManager.INSTANCE.getViewpoint().getRuleSet();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getRuleSet", out.toString());
	}

	protected void method_SetVpID(final StringBuffer out, final PatternContext ctx) throws Exception {
		parameter.setVpid(EcoreUtil.generateUUID());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "SetVpID", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpservices.Rule parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpservices.Rule parameter) {
		this.parameter = parameter;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.RuleSet rS;

	public void set_rS(org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.RuleSet rS) {
		this.rS = rS;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
