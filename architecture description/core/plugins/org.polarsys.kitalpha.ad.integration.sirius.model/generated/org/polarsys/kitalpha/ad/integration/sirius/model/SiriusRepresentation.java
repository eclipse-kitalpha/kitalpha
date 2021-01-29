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

package org.polarsys.kitalpha.ad.integration.sirius.model;

import org.eclipse.sirius.viewpoint.description.Group;

import org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.RepresentationElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Representation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.ad.integration.sirius.model.SiriusRepresentation#getOdesign <em>Odesign</em>}</li>
 * </ul>
 *
 * @see org.polarsys.kitalpha.ad.integration.sirius.model.SiriusPackage#getSiriusRepresentation()
 * @model
 * @generated
 */
public interface SiriusRepresentation extends RepresentationElement {





	/**
	 * Returns the value of the '<em><b>Odesign</b></em>' reference.

	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Odesign</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Odesign</em>' reference.
	 * @see #setOdesign(Group)
	 * @see org.polarsys.kitalpha.ad.integration.sirius.model.SiriusPackage#getSiriusRepresentation_Odesign()
	 * @model
	 * @generated
	 */

	Group getOdesign();




	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.ad.integration.sirius.model.SiriusRepresentation#getOdesign <em>Odesign</em>}' reference.

	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Odesign</em>' reference.
	 * @see #getOdesign()
	 * @generated
	 */

	void setOdesign(Group value);





} // SiriusRepresentation
