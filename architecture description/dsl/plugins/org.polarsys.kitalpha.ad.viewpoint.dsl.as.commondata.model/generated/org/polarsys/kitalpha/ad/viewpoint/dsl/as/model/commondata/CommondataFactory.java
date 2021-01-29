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
 ******************************************************************************/

package org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.commondata;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.commondata.CommondataPackage
 * @generated
 */
public interface CommondataFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommondataFactory eINSTANCE = org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.commondata.impl.CommondataFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>External Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Class</em>'.
	 * @generated
	 */
	ExternalClass createExternalClass();

	/**
	 * Returns a new object of class '<em>Local Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Class</em>'.
	 * @generated
	 */
	LocalClass createLocalClass();

	/**
	 * Returns a new object of class '<em>External Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Association</em>'.
	 * @generated
	 */
	ExternalAssociation createExternalAssociation();

	/**
	 * Returns a new object of class '<em>Local Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Association</em>'.
	 * @generated
	 */
	LocalAssociation createLocalAssociation();

	/**
	 * Returns a new object of class '<em>Local Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Attribute</em>'.
	 * @generated
	 */
	LocalAttribute createLocalAttribute();

	/**
	 * Returns a new object of class '<em>External Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Attribute</em>'.
	 * @generated
	 */
	ExternalAttribute createExternalAttribute();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CommondataPackage getCommondataPackage();

} //CommondataFactory
