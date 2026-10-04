//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.explorer.contextual.common;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.explorer.contextual.category.ContextualExplorerCategories;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.explorer.contextual.category.ContextualExplorerCategoriesHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.explorer.contextual.util.ClassUtils;

public class AbstractCategoryPattern {
	protected static String nl;

	public static synchronized AbstractCategoryPattern create(String lineSeparator) {
		nl = lineSeparator;
		AbstractCategoryPattern result = new AbstractCategoryPattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "      <category" + NL + "            id=\"";
	protected final String TEXT_2 = "\"" + NL + "            isTopLevel=\"true\"" + NL + "            name=\"";
	protected final String TEXT_3 = "\">" + NL + "         <targetExplorerId" + NL + "               id=\"";
	protected final String TEXT_4 = "\">" + NL + "         </targetExplorerId>" + NL + "         <availableForType" + NL
			+ "               class=\"";
	protected final String TEXT_5 = "\">" + NL + "         </availableForType>" + NL + "         <categoryQuery>" + NL
			+ "            <basicQuery" + NL + "                  class=\"";
	protected final String TEXT_6 = "\">" + NL + "            </basicQuery>" + NL + "         </categoryQuery>" + NL
			+ "      </category>";
	protected final String TEXT_7 = NL;

	public AbstractCategoryPattern() {
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

		if (preCondition(ctx)) {
			ctx.setNode(new Node.Container(currentNode, getClass()));
			orchestration(ctx);
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

		method_setCategoryType(new StringBuffer(), ictx);

		method_setVpClass(new StringBuffer(), ictx);

		method_intLocalVariable(new StringBuffer(), ictx);

		method_genCategoryConfigurationElement(new StringBuffer(), ictx);

		return null;
	}

	protected java.lang.String categoryID = null;

	public void set_categoryID(java.lang.String object) {
		this.categoryID = object;
	}

	protected java.lang.String categoryName = null;

	public void set_categoryName(java.lang.String object) {
		this.categoryName = object;
	}

	protected java.lang.String targetExplorerId = null;

	public void set_targetExplorerId(java.lang.String object) {
		this.targetExplorerId = object;
	}

	protected java.lang.String domainClassFQN = null;

	public void set_domainClassFQN(java.lang.String object) {
		this.domainClassFQN = object;
	}

	protected java.lang.String queryJavaClassFQN = null;

	public void set_queryJavaClassFQN(java.lang.String object) {
		this.queryJavaClassFQN = object;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class vpClass = null;

	public void set_vpClass(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class object) {
		this.vpClass = object;
	}

	protected java.lang.Object category = null;

	public void set_category(java.lang.Object object) {
		this.category = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_setCategoryType(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		// to be implemented by Patterns which inherits from this Pattern 
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setCategoryType", stringBuffer.toString());
	}

	protected void method_setVpClass(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		// to be implemented by Patterns which inherits from this Pattern 
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setVpClass", stringBuffer.toString());
	}

	protected void method_intLocalVariable(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		ContextualExplorerCategories cat = (ContextualExplorerCategories) category;
		String projectName = ClassUtils.INSTANCE.getProjectName();
		categoryID = ContextualExplorerCategoriesHelper.getCategoryID(cat, vpClass, projectName);
		categoryName = cat.getCategoryName();
		targetExplorerId = cat.getTargetExplorerID();
		domainClassFQN = ClassUtils.INSTANCE.getClassInterfaceFullyQualifiedName(vpClass);
		queryJavaClassFQN = ContextualExplorerCategoriesHelper.getQueryJavaClassFQN(cat, vpClass, projectName);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "intLocalVariable", stringBuffer.toString());
	}

	protected void method_genCategoryConfigurationElement(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(categoryID);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(categoryName);
		stringBuffer.append(TEXT_3);
		stringBuffer.append(targetExplorerId);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(domainClassFQN);
		stringBuffer.append(TEXT_5);
		stringBuffer.append(queryJavaClassFQN);
		stringBuffer.append(TEXT_6);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genCategoryConfigurationElement", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}