//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.common;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.ECoreResourceManager;
//import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.exception.EcoreNotAvailableException;

public class AnyVPSpecElement {

	public AnyVPSpecElement() {
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
		//boolean generate = false;
		//try {
		//	generate = ECoreResourceManager.INSTANCE.generateEcoreModel(true);
		//} 
		//catch (Exception e) 
		//{
		//	if (e instanceof EcoreNotAvailableException) 
		//  {
		//		generate = true;
		//	} 
		//  else 
		//  {
		//		e.printStackTrace();
		//		generate = false;
		//	}
		//}
		//
		//return generate;
		return ECoreResourceManager.INSTANCE.generateEcoreModel(true);
	}

}
