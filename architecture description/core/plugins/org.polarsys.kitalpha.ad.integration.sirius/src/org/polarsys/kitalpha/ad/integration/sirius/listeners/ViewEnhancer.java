/*******************************************************************************
 * Copyright (c) 2014, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/

package org.polarsys.kitalpha.ad.integration.sirius.listeners;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManagerListener.Stub;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.concern.ConcernDescription;
import org.eclipse.sirius.diagram.description.concern.ConcernFactory;
import org.eclipse.sirius.diagram.description.concern.ConcernSet;
import org.eclipse.sirius.diagram.description.filter.CompositeFilterDescription;
import org.eclipse.sirius.diagram.description.filter.FilterDescription;
import org.eclipse.sirius.diagram.description.filter.FilterFactory;
import org.eclipse.sirius.diagram.description.filter.FilterKind;
import org.eclipse.sirius.diagram.description.filter.MappingFilter;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.sirius.viewpoint.description.DescriptionFactory;
import org.eclipse.sirius.viewpoint.description.JavaExtension;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;

/**
 * @author Thomas Guiu
 * 
 */
public class ViewEnhancer extends Stub {

	private final class UpdateDescriptionCommand extends RecordingCommand {
		private static final String SERVICE_CLASSNAME = "org.polarsys.kitalpha.ad.integration.sirius.ModelExtensionServices";
		private static final String FILTER_NAME = "Hide Model Extension";
		private static final String DEFAULT_NAME = "default";
		private final Session session;
		private final Job containerJob;

		private UpdateDescriptionCommand(TransactionalEditingDomain domain, Session session, Job containerJob) {
			super(domain);
			this.session = session;
			this.containerJob = containerJob;
		}

		@Override
		protected void doExecute() {
			Collection<DView> ownedViews = session.getOwnedViews();
			if (ownedViews.isEmpty()) {
				// the project has just been created and there is no view yet.
				// reschedule the job to perform our changes later
				containerJob.schedule(1000);
				return;
			}
			for (DView v : ownedViews) {
				// / migration in Sirius may produce a null value
				if (v.getViewpoint() == null || v.getViewpoint().eResource() == null) {
					continue;
				}
				for (RepresentationDescription representation : v.getViewpoint().getOwnedRepresentations()) {
					if (representation instanceof DiagramDescription) {
						DiagramDescription spec = (DiagramDescription) representation;
						addJavaExtension(v);
						if (needFilter(spec)) {
							// 1 - create filter
							CompositeFilterDescription compositeFilterDescription = FilterFactory.eINSTANCE.createCompositeFilterDescription();
							// ajouter les Adapters ?
							compositeFilterDescription.setName(FILTER_NAME);
							MappingFilter mappingFilter = FilterFactory.eINSTANCE.createMappingFilter();
							mappingFilter.setFilterKind(FilterKind.HIDE_LITERAL);
							mappingFilter.setViewConditionExpression("aql:self.isExtensionModelActive()");
							compositeFilterDescription.getFilters().add(mappingFilter);
							spec.getFilters().add(compositeFilterDescription);

							// 2 - create or get current concernSet
							ConcernSet concerns = spec.getConcerns();
							if (concerns == null) {
								concerns = ConcernFactory.eINSTANCE.createConcernSet();
								ConcernDescription defaultConcern = ConcernFactory.eINSTANCE.createConcernDescription();
								defaultConcern.setLabel(DEFAULT_NAME);
								defaultConcern.setName(DEFAULT_NAME);
								spec.setConcerns(concerns);
								spec.setDefaultConcern(defaultConcern);
								concerns.getOwnedConcernDescriptions().add(defaultConcern);
							}

							// 3 - add filter to concernDescriptions
							for (ConcernDescription desc : concerns.getOwnedConcernDescriptions()) {
								desc.getFilters().add(compositeFilterDescription);
							}
						}
					}
				}
			}
		}

		private boolean needFilter(DiagramDescription spec) {
			for (FilterDescription desc : spec.getFilters()) {
				if (FILTER_NAME.equals(desc.getName())){
					return false;
				}
			}
			return true;
		}

		private void addJavaExtension(DView view) {
			for (JavaExtension javaExt : view.getViewpoint().getOwnedJavaExtensions()) {
				if (SERVICE_CLASSNAME.equals(javaExt.getQualifiedClassName())){
					return;
				}
			}
			JavaExtension javaExt = DescriptionFactory.eINSTANCE.createJavaExtension();
			javaExt.setQualifiedClassName(SERVICE_CLASSNAME);
			view.getViewpoint().getOwnedJavaExtensions().add(javaExt);
		}
	}

	@Override
	public void notifyAddSession(final Session session) {
		final Job updateJob = new Job("") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				final UpdateDescriptionCommand command = new UpdateDescriptionCommand(session.getTransactionalEditingDomain(), session, this);
				session.getTransactionalEditingDomain().getCommandStack().execute(command);
				return Status.OK_STATUS;
			}
		};
		updateJob.setSystem(true);
		updateJob.setUser(false);
		updateJob.schedule();

		super.notifyAddSession(session);
	}

}
