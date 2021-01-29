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

package org.polarsys.kitalpha.ad.ta.emf.definition;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.portfolio.genchain.extension.ExtensionHelper;
import org.polarsys.kitalpha.ad.ta.extension.TargetApplicationAdapter;
import org.polarsys.kitalpha.doc.gen.business.ecore.genchain.extension.KitalphaDocumentationExtension;
import org.polarsys.kitalpha.emde.genchain.EmdeGenerationExtension;

/**
 * @author Boubekeur Zendagui
 */

public class EMFTargetApplication extends TargetApplicationAdapter {

	@Override
	public List<ExtensionHelper> getGenerationExtensionHelpers() {
		List<ExtensionHelper> result = new ArrayList<ExtensionHelper>();
		result.add(new EmdeGenerationExtension());
		result.add(new KitalphaDocumentationExtension());
		return result;
	}

}
