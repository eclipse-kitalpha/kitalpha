//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.decorators.common;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.eclipse.sirius.viewpoint.description.DecorationDescription;
import org.eclipse.sirius.viewpoint.description.DecorationDescriptionsSet;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.ExpressionElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.diagram.expression.StringElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.GenerationUtil;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.util.IconPathHelper;

public class AbstractDecorator
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.common.AbstractDiagramPattern {

	public AbstractDecorator() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();

		if (preCondition(ctx))
			orchestration((PatternContext) argument);

		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		super.orchestration(new SuperOrchestrationContext(ictx));
		method_createSiriusDecorator(new StringBuffer(), ictx);
		method_initializeVariable(new StringBuffer(), ictx);
		method_addDecorator2DecoratorSet(new StringBuffer(), ictx);
		method_setCommonData(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		return null;
	}

	protected void method_createSiriusDecorator(final StringBuffer out, final PatternContext ctx) throws Exception {
		//default content

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createSiriusDecorator", out.toString());
	}

	protected void method_addDecorator2DecoratorSet(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (vpdslDecorator != null && siriusDecorator != null) {
			EObject dslvpParent = vpdslDecorator.eContainer();
			EObject doremiParent = GenerationUtil.getDoremiElement(dslvpParent);

			if (doremiParent instanceof DecorationDescriptionsSet) {
				DecorationDescriptionsSet toolSection = (DecorationDescriptionsSet) doremiParent;
				toolSection.getDecorationDescriptions().add((DecorationDescription) siriusDecorator);
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "addDecorator2DecoratorSet", out.toString());
	}

	protected void method_setCommonData(final StringBuffer out, final PatternContext ctx) throws Exception {
		siriusDecorator.setName(vpdslDecorator.getName());
		siriusDecorator.setPosition(vpdslDecorator.getPosition());
		siriusDecorator.setDistributionDirection(vpdslDecorator.getDirection());

		if (vpdslDecorator.getIcon() != null && vpdslDecorator.getIcon().trim().length() > 0) {
			String icon_path = IconPathHelper.computeDslIconPath(vpdslDecorator.getIcon(), vpdslDecorator);
			if (icon_path != null && icon_path.trim().length() > 0) {
				siriusDecorator.setImageExpression(icon_path);
			}
			IconPathHelper.copyIconFile(vpdslDecorator.getIcon(), vpdslDecorator);
		}

		ExpressionElement precondition = vpdslDecorator.getPrecondition();
		if (precondition instanceof StringElement) {
			siriusDecorator.setPreconditionExpression(((StringElement) precondition).getValue());
		}

		ExpressionElement tooltip = vpdslDecorator.getTooltip();
		if (tooltip instanceof StringElement) {
			siriusDecorator.setTooltipExpression(((StringElement) tooltip).getValue());
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setCommonData", out.toString());
	}

	protected void method_initializeVariable(final StringBuffer out, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "initializeVariable", out.toString());
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.AbstractDecorator vpdslDecorator;

	public void set_vpdslDecorator(
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.AbstractDecorator vpdslDecorator) {
		this.vpdslDecorator = vpdslDecorator;
	}

	protected org.eclipse.sirius.viewpoint.description.DecorationDescription siriusDecorator;

	public void set_siriusDecorator(org.eclipse.sirius.viewpoint.description.DecorationDescription siriusDecorator) {
		this.siriusDecorator = siriusDecorator;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

}
