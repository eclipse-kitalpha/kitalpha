/*******************************************************************************
 * Copyright (c) 2014, 2020 Thales Global Services S.A.S.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License 2.0 which is available at
 *  http://www.eclipse.org/legal/epl-2.0
 *  
 *  SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpbuild.impl;

import org.eclipse.emf.ecore.EClass;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpbuild.Cron;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpbuild.VpbuildPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cron</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CronImpl extends TriggerImpl implements Cron {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CronImpl() {

		super();

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VpbuildPackage.Literals.CRON;
	}

} //CronImpl
