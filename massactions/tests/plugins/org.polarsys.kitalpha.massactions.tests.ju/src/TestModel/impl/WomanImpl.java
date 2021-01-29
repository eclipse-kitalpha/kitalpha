/*******************************************************************************
 * Copyright (c) 2018, 2020  Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 *  Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
/**
 */
package TestModel.impl;

import TestModel.TestModelPackage;
import TestModel.Woman;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Woman</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class WomanImpl extends PersonImpl implements Woman {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WomanImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestModelPackage.Literals.WOMAN;
	}

} //WomanImpl
