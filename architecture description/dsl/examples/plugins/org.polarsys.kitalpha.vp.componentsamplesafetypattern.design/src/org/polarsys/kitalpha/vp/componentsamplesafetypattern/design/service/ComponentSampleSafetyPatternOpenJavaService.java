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
package org.polarsys.kitalpha.vp.componentsamplesafetypattern.design.service;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.polarsys.kitalpha.vp.componentsamplesafety.ComponentSampleSafety.Safety;

// Generated on 22.09.2014 at 12:07:08 CEST by Viewpoint DSL Generator V 0.1

/**
 * <!-- begin-user-doc -->
 * This class is an implementation of the DoReMi JavaExtension '<em><b>[org.polarsys.kitalpha.vp.componentsamplesafetypattern.design.service.ComponentSampleSafetyPatternOpenJavaService]</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */

public class ComponentSampleSafetyPatternOpenJavaService {
	/**
	* <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	* @generated
	*/
	public ComponentSampleSafetyPatternOpenJavaService() {
		// TODO Auto-generated method stub
	}

	public boolean isComponent(EObject eObject) {
		return eObject instanceof Safety;
	}
}