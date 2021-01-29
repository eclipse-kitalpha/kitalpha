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
package org.polarsys.kitalpha.accuracy.componentsample.validation.constraints.startup;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.ui.IStartup;
import org.polarsys.kitalpha.accuracy.componentsample.validation.constraints.providers.JavaConstraintsProvider;
import org.polarsys.kitalpha.accuracy.componentsample.validation.constraints.providers.OCLConstraintsProvider;
import org.polarsys.kitalpha.validation.ocl.provider.generic.EValidatorAdapter;
import org.polarsys.kitalpha.validation.provider.generic.GenericConstraintProviderService;
import org.polarsys.kitalpha.vp.componentsample.ComponentSample.ComponentSamplePackage;

/**
 * 
 * @author Faycal Abka
 *
 */
public class Startup implements IStartup {

	@Override
	public void earlyStartup() {
		
		//force the registration of the metamodel
		ComponentSamplePackage.eINSTANCE.eClass();
		
		//Register all packages to the same validation adapter
		EValidatorAdapter validationAdaptor = new EValidatorAdapter();
		
		EValidator.Registry.INSTANCE.put(ComponentSamplePackage.eINSTANCE, validationAdaptor);
		GenericConstraintProviderService.getInstance().registerProvider(new OCLConstraintsProvider());
		GenericConstraintProviderService.getInstance().registerProvider(new JavaConstraintsProvider());
	}

}
