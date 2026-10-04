//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.af.rule;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import java.text.SimpleDateFormat;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpservices.Rule;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpservices.VpservicesPackage;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.af.project.AFModelUtils;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.af.project.AfProjectManager;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.java.JDTUtility;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpservices.Rule;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.af.utils.AfConstants;

public class RuleJavaClasse {
	protected static String nl;

	public static synchronized RuleJavaClasse create(String lineSeparator) {
		nl = lineSeparator;
		RuleJavaClasse result = new RuleJavaClasse();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "// DSL Viewpoint Generator V0.1 ";
	protected final String TEXT_2 = NL + NL + "package ";
	protected final String TEXT_3 = ";" + NL + "" + NL
			+ "import org.polarsys.kitalpha.ad.viewpoint.integration.rules.JavaRule;" + NL
			+ "import org.polarsys.kitalpha.ad.viewpoint.utils.ModelAccessor;" + NL + "" + NL + "public class ";
	protected final String TEXT_4 = " implements JavaRule {" + NL + "" + NL + "\t/* (non-Javadoc)" + NL
			+ "\t * @see org.polarsys.kitalpha.ad.viewpoint.integration.rules.JavaRule#run(org.polarsys.kitalpha.ad.viewpoint.utils.ModelAccessor, java.lang.Object[])"
			+ NL + "\t */" + NL + "\tpublic void run(ModelAccessor properties, Object[] selection) {" + NL
			+ "\t\t// TODO Auto-generated method stub" + NL
			+ "\t\torg.eclipse.jface.dialogs.MessageDialog.openInformation(" + NL
			+ "\t\t\t\torg.eclipse.ui.PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), " + NL
			+ "\t\t\t\t\"Java rule execution\", " + NL + "\t\t\t\t\"DSL Viewpoint generated rule \\n Message from ";
	protected final String TEXT_5 = " rule\");" + NL + "" + NL + "\t}" + NL + "" + NL + "\t/* (non-Javadoc)" + NL
			+ "\t * @see org.polarsys.kitalpha.ad.viewpoint.integration.rules.JavaRule#canRun(org.polarsys.kitalpha.ad.viewpoint.utils.ModelAccessor, java.lang.Object[])"
			+ NL + "\t */" + NL + "\tpublic boolean canRun(ModelAccessor properties, Object[] selection) {" + NL
			+ "\t\t// TODO Auto-generated method stub" + NL + "\t\treturn true;" + NL + "\t}" + NL + "" + NL + "}";
	protected final String TEXT_6 = " ";
	protected final String TEXT_7 = NL;

	public RuleJavaClasse() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpservices.Rule) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_7);
		stringBuffer.append(TEXT_7);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_setDateTime(new StringBuffer(), ictx);

		method_setPackName(new StringBuffer(), ictx);

		method_setRuleName(new StringBuffer(), ictx);

		method_body(new StringBuffer(), ictx);

		method_registerJavaRuleClass(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected java.lang.String packageName = null;

	public void set_packageName(java.lang.String object) {
		this.packageName = object;
	}

	protected java.lang.String ruleName = null;

	public void set_ruleName(java.lang.String object) {
		this.ruleName = object;
	}

	protected java.lang.String genTime = null;

	public void set_genTime(java.lang.String object) {
		this.genTime = object;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpservices.Rule parameter = null;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpservices.Rule object) {
		this.parameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(genTime);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(packageName);
		stringBuffer.append(TEXT_3);
		stringBuffer.append(ruleName);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(ruleName);
		stringBuffer.append(TEXT_5);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}

	protected void method_setPackName(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		packageName = (String) ctx.getValue(AfConstants.CONTRACT_PROJECT_NAME) + ".businessrules";
		packageName = JDTUtility.getValidPackageName(packageName);
		stringBuffer.append(TEXT_6);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setPackName", stringBuffer.toString());
	}

	protected void method_setRuleName(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		ruleName = ((Rule) parameter).getName();
		ruleName = ruleName.substring(0, 1).toUpperCase() + ruleName.substring(1);
		ruleName = JDTUtility.getValidClassName(ruleName);
		ctx.setValue("ruleName", ruleName);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setRuleName", stringBuffer.toString());
	}

	protected void method_setDateTime(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy 'at' hh:mm:ss z");
		genTime = sdf.format(cal.getTime());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setDateTime", stringBuffer.toString());
	}

	protected void method_registerJavaRuleClass(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		// TODO : � refaire 
		AfProjectManager.INSTANCE.registerJavaRule(AFModelUtils.getInstance().generateAFElementID(parameter),
				packageName + "." + ruleName);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "registerJavaRuleClass", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return parameter.getType().toString()
				.equals(VpservicesPackage.eINSTANCE.getRules_Types().getEEnumLiteral(0).toString())
				&& (parameter.getClass_() == null || parameter.getClass_().trim().length() == 0);
	}
}