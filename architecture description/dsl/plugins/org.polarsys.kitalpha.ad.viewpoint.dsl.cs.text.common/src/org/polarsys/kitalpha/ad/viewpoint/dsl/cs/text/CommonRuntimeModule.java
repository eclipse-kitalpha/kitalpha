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

package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text;

import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.generator.CommonGenerator;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.generator.IViewpointSynchronizer;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.services.CommonValueConverter;


/**
 * 
 * @author Amine Lajmi
 *
 */
public class CommonRuntimeModule extends org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.AbstractCommonRuntimeModule {

	public Class<? extends IViewpointSynchronizer> bindIViewpointSynchronizer() {
		return CommonGenerator.class;
	}
	
	@Override
	public Class<? extends org.eclipse.xtext.conversion.IValueConverterService> bindIValueConverterService() {
		return CommonValueConverter.class;
	}
}
