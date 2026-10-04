//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.common;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.helper.conf.DiagramGenerationConfigurationHelper;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

public class AbstractDiagramPattern {

	public AbstractDiagramPattern() {
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
		ictx.setNode(currentNode);
		return null;
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		EDataTypeUniqueEList<EObject> domain = (EDataTypeUniqueEList<EObject>) ctx.getValue("domain");
		EObject modelElement = domain.get(0);
		if (modelElement != null)
			return DiagramGenerationConfigurationHelper.generateVSM(modelElement);
		else
			return false;
	}

}
