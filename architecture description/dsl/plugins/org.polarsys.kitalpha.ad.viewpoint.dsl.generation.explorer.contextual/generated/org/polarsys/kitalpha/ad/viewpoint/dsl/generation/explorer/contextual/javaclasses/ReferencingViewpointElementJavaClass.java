//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.explorer.contextual.javaclasses;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Association_Types;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractAssociation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.LocalClassAssociation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.explorer.contextual.category.ContextualExplorerCategoryCompliance;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.explorer.contextual.util.ClassUtils;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Data;

public class ReferencingViewpointElementJavaClass extends
		org.polarsys.kitalpha.ad.viewpoint.dsl.generation.explorer.contextual.common.AbstractAssociationJavaClass {
	protected static String nl;

	public static synchronized ReferencingViewpointElementJavaClass create(String lineSeparator) {
		nl = lineSeparator;
		ReferencingViewpointElementJavaClass result = new ReferencingViewpointElementJavaClass();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "\t/**" + NL + "    * <!-- begin-user-doc -->" + NL + "    * <!-- end-user-doc -->"
			+ NL + "    * @param object_p: The model element for which the Contextual Explorer extension is generated"
			+ NL + "    * @return List of object to display in the parent category" + NL + "    * @generated" + NL
			+ "    */" + NL + "\tpublic List<Object> compute(Object object_p) {" + NL
			+ "\t\tList<Object> result = new ArrayList<Object>();" + NL
			+ "\t\tResource resource = ((EObject)object_p).eResource();" + NL + "\t\tif (resource != null)" + NL
			+ "\t\t{" + NL + "\t\t\tfor (TreeIterator<EObject> iter = resource.getAllContents(); iter.hasNext();) " + NL
			+ "\t\t\t{" + NL + "\t\t\t\tEObject eObject = iter.next();" + NL;
	protected final String TEXT_2 = NL + NL + "\t\t\t\tif (eObject instanceof ";
	protected final String TEXT_3 = ") " + NL + "\t\t\t\t{" + NL + "\t\t\t\t\t";
	protected final String TEXT_4 = " referencingElement = (";
	protected final String TEXT_5 = ") eObject;" + NL + "\t\t\t\t\tif (referencingElement.";
	protected final String TEXT_6 = "() != null &&";
	protected final String TEXT_7 = NL + "\t\t\t\t\t\t\treferencingElement.";
	protected final String TEXT_8 = "().contains(object_p))";
	protected final String TEXT_9 = "\t\t" + NL + "\t\t\t\t\t\t\treferencingElement.";
	protected final String TEXT_10 = "().equals(object_p))";
	protected final String TEXT_11 = NL + "\t\t\t\t\t\tresult.add(eObject);" + NL + "\t\t\t\t}";
	protected final String TEXT_12 = NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + ""
			+ NL + "\t";
	protected final String TEXT_13 = NL + "\t\timport ";
	protected final String TEXT_14 = ";" + NL + "\t\t";
	protected final String TEXT_15 = NL + "import java.util.ArrayList;" + NL + "import java.util.List;" + NL + "" + NL
			+ "import org.eclipse.emf.common.util.TreeIterator;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL
			+ "import org.eclipse.emf.ecore.resource.Resource;" + NL + "" + NL
			+ "import org.eclipse.amalgam.explorer.contextual.core.query.IQuery;" + NL;
	protected final String TEXT_16 = NL;

	public ReferencingViewpointElementJavaClass() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_16);
		stringBuffer.append(TEXT_16);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_computeReferencingClassesList(new StringBuffer(), ictx);
		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected java.util.List referencingClassesList = null;

	public void set_referencingClassesList(java.util.List object) {
		this.referencingClassesList = object;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class parameter = null;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class object) {
		this.parameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_computeReferencingClassesList(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		Data data = (Data) parameter.eContainer();
		for (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class clazz : data.getVP_Classes()) {
			for (AbstractAssociation abstractAssociation : clazz.getVP_Classes_Associations()) {
				if (abstractAssociation instanceof LocalClassAssociation
						&& abstractAssociation.getType() == Association_Types.REFERENCE) {
					LocalClassAssociation localClassAssociation = (LocalClassAssociation) abstractAssociation;
					final org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class localTarget = localClassAssociation
							.getLocalTarget();
					boolean addClass = false;
					if ((localTarget != null && localTarget.equals(parameter))) {
						addClass = true;
					} else {
						addClass = ContextualExplorerCategoryCompliance.isDerivedClass(parameter, localTarget);
					}

					if (addClass) {
						if (referencingClassesList == null)
							referencingClassesList = new ArrayList<org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class>();

						referencingClassesList.add(clazz);
					}
				}
			}
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "computeReferencingClassesList", stringBuffer.toString());
	}

	protected void method_genClassMethods(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		for (Object clazz_o : referencingClassesList) {
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class clazz = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class) clazz_o;
			String containgClassName = clazz.getName();
			for (AbstractAssociation abstractAssociation : clazz.getVP_Classes_Associations()) {
				if (abstractAssociation instanceof LocalClassAssociation
						&& abstractAssociation.getType() == Association_Types.REFERENCE) {
					LocalClassAssociation vpAssociation = (LocalClassAssociation) abstractAssociation;
					if (vpAssociation.getLocalTarget().equals(parameter) || ContextualExplorerCategoryCompliance
							.isDerivedClass(parameter, vpAssociation.getLocalTarget())) {
						String vpAssociationGetterName = ClassUtils.INSTANCE.getAssociationAccesssorName(vpAssociation);
						stringBuffer.append(TEXT_2);
						stringBuffer.append(containgClassName);
						stringBuffer.append(TEXT_3);
						stringBuffer.append(containgClassName);
						stringBuffer.append(TEXT_4);
						stringBuffer.append(containgClassName);
						stringBuffer.append(TEXT_5);
						stringBuffer.append(vpAssociationGetterName);
						stringBuffer.append(TEXT_6);
						if (ClassUtils.isAssociationMultiple(abstractAssociation)) {
							stringBuffer.append(TEXT_7);
							stringBuffer.append(vpAssociationGetterName);
							stringBuffer.append(TEXT_8);
						} else {
							stringBuffer.append(TEXT_9);
							stringBuffer.append(vpAssociationGetterName);
							stringBuffer.append(TEXT_10);
						}
						stringBuffer.append(TEXT_11);
					}
				}
			}
		}
		stringBuffer.append(TEXT_12);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genClassMethods", stringBuffer.toString());
	}

	protected void method_genSemanticImoprt(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		if (referencingClassesList != null && referencingClassesList.size() > 0) {
			for (Object clazz_o : referencingClassesList) {
				org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class clazz = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class) clazz_o;
				stringBuffer.append(TEXT_13);
				stringBuffer.append(ClassUtils.INSTANCE.getClassInterfaceFullyQualifiedName(clazz));
				stringBuffer.append(TEXT_14);
			}
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genSemanticImoprt", stringBuffer.toString());
	}

	protected void method_genDefaultImport(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_15);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genDefaultImport", stringBuffer.toString());
	}

	protected void method_setJavaClassName(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		javaClassName = "ReferencingViewpointElementQuery";
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setJavaClassName", stringBuffer.toString());
	}

	protected void method_setConcernedVPClass(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		vpClass = parameter;
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setConcernedVPClass", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return ContextualExplorerCategoryCompliance.referencingViewpointCategoryCompliance(parameter);
	}
}