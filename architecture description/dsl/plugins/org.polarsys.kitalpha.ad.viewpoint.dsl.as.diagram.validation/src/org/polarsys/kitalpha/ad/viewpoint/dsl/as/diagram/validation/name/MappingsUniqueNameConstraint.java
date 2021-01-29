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

package org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.validation.name;

import java.util.ArrayList;
import java.util.List;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.validation.extension.ICoreConstraintContribution;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.AbstractEdge;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.AbstractNode;

/**
 * @author Boubekeur Zendagui
 */

public class MappingsUniqueNameConstraint implements ICoreConstraintContribution {
	
	@Override
	public boolean isObjectInScope(Object object) {
		return object instanceof AbstractNode
				|| object instanceof AbstractEdge;
	}

	@Override
	public List<String> brothersEStructuralFeatures() {
		List<String> result = new ArrayList<String>();
		result.add("diagram_Elements");
		result.add("owned_nodes");
		result.add("owned_boderednodes");
		return result;
	}

}
