//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.common;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.sirius.diagram.description.DescriptionPackage;
import org.eclipse.sirius.diagram.description.DiagramElementMapping;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.SynchronizationMode;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.DiagramElement;

public class DiagramElementPattern
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.common.DoremiElementPattern {

	public DiagramElementPattern() {
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
		method_setStyle(new StringBuffer(), ictx);
		method_setSemanticData(new StringBuffer(), ictx);
		method_setSynchronizationMode(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		return null;
	}

	protected void method_setStyle(final StringBuffer out, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setStyle", out.toString());
	}

	protected void method_setSemanticData(final StringBuffer out, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setSemanticData", out.toString());
	}

	protected void method_setSynchronizationMode(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (doremiElement instanceof DiagramElementMapping) {
			// Getting attribute default values.
			final EAttribute synchronizationLock = DescriptionPackage.eINSTANCE
					.getDiagramElementMapping_SynchronizationLock();
			boolean synchronizationLockDefaultValue = (Boolean) synchronizationLock.getDefaultValue();
			final EAttribute createElements = DescriptionPackage.eINSTANCE.getDiagramElementMapping_CreateElements();
			boolean createElementDefaultValue = (Boolean) createElements.getDefaultValue();

			final DiagramElementMapping siriusElement = (DiagramElementMapping) doremiElement;
			final DiagramElement dslElement = (DiagramElement) dslvpElement;

			SynchronizationMode mode = dslElement.getSynchronizationMode();
			if (!mode.equals(SynchronizationMode.DEFAULT)) {
				// Initializing attributes to their default values
				siriusElement.setSynchronizationLock(synchronizationLockDefaultValue);
				siriusElement.setCreateElements(createElementDefaultValue);

				// Setting attributes values depending on their synchronization mode.
				switch (mode) {
				case NOT_SYNCHRONIZED:
					siriusElement.setCreateElements(false);
					break;
				case SYNCHRONIZED:
					siriusElement.setSynchronizationLock(true);
					break;
				case UNSYNCHRONIZABLE:
				case DEFAULT:
					// Do nothing
					// keep default values (capture Unsynchronizable mode)
					break;
				}
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setSynchronizationMode", out.toString());
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

}
