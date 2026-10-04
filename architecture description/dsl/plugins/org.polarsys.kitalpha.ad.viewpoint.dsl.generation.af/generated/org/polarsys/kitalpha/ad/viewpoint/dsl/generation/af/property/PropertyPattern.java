//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.af.property;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

import org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.Property;
import org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.Types;
import org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.ViewpointFactory;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.af.project.AFModelUtils;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.af.project.AfProjectManager;

public class PropertyPattern {

	public PropertyPattern() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpservices.Property) parameterParameter;

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
		method_getPropertySet(new StringBuffer(), ictx);
		method_createAFProperty(new StringBuffer(), ictx);
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

	protected void method_createAFProperty(final StringBuffer out, final PatternContext ctx) throws Exception {
		Property property = ViewpointFactory.eINSTANCE.createProperty();

		/*** From VPDesc Model ***/
		property.setName(parameter.getName());
		property.setDescription(parameter.getDescription());
		Types type = null;
		switch (parameter.getType()) {
		case BOOLEAN:
			type = Types.BOOLEAN;
			break;
		case FLOAT:
			type = Types.FLOAT;
			break;
		case INTEGER:
			type = Types.INTEGER;
			break;
		case STRING:
			type = Types.STRING;
			break;
		}

		property.setType(type);

		property.setValue(parameter.getValue());

		/*** Generated ***/
		property.setId(AFModelUtils.getInstance().generateAFElementID(parameter));
		//property.setVpid(parameter.getVpid()); 
		property.setVpid(parameter.getVpid());

		/*** Adding the new property to the propertySet ***/
		pS.getNewProperties().add(property);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createAFProperty", out.toString());
	}

	protected void method_getPropertySet(final StringBuffer out, final PatternContext ctx) throws Exception {
		pS = AfProjectManager.INSTANCE.getViewpoint().getPropertySet();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getPropertySet", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpservices.Property parameter;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpservices.Property parameter) {
		this.parameter = parameter;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.PropertySet pS;

	public void set_pS(org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.PropertySet pS) {
		this.pS = pS;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
