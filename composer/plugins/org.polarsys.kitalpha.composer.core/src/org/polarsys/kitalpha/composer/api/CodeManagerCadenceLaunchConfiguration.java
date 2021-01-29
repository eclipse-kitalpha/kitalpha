/*******************************************************************************
 * Copyright (c) 2014, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/


package org.polarsys.kitalpha.composer.api;

import org.polarsys.kitalpha.cadence.core.api.parameter.WorkflowActivityParameter;

/**
 * This class manages the configuration of additional activities.
 * 
 
 */
public class CodeManagerCadenceLaunchConfiguration {

	private WorkflowActivityParameter beforeStrategyActivities = new WorkflowActivityParameter();
	private WorkflowActivityParameter beforeRefineryActivities = new WorkflowActivityParameter();
	private WorkflowActivityParameter beforeGenerationActivities = new WorkflowActivityParameter();
	private WorkflowActivityParameter afterGenerationActivities = new WorkflowActivityParameter();

	public WorkflowActivityParameter getBeforeStrategyActivities() {
		return beforeStrategyActivities;
	}

	public void setBeforeStrategyActivities(
			WorkflowActivityParameter beforeStrategyActivities) {
		this.beforeStrategyActivities = beforeStrategyActivities;
	}

	public WorkflowActivityParameter getBeforeRefineryActivities() {
		return beforeRefineryActivities;
	}

	public void setBeforeRefineryActivities(
			WorkflowActivityParameter beforeRefineryActivities) {
		this.beforeRefineryActivities = beforeRefineryActivities;
	}

	public WorkflowActivityParameter getBeforeGenerationActivities() {
		return beforeGenerationActivities;
	}

	public void setBeforeGenerationActivities(
			WorkflowActivityParameter beforeGenerationActivities) {
		this.beforeGenerationActivities = beforeGenerationActivities;
	}

	public WorkflowActivityParameter getAfterGenerationActivities() {
		return afterGenerationActivities;
	}

	public void setAfterGenerationActivities(
			WorkflowActivityParameter afterGenerationActivities) {
		this.afterGenerationActivities = afterGenerationActivities;
	}

	public boolean containsActivities() {
		return !beforeGenerationActivities.getActivitiesID().isEmpty()
				|| !beforeRefineryActivities.getActivitiesID().isEmpty()
				|| !beforeGenerationActivities.getActivitiesID().isEmpty()
				|| !afterGenerationActivities.getActivitiesID().isEmpty();
	}

}
