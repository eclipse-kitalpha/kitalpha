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
package org.polarsys.kitalpha.emde.egf.utils;

import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.pattern.Node.Container;
import org.eclipse.egf.model.pattern.Node.DataLeaf;

/**
 * @author Thomas Guiu
 * 
 */
public class NodeHelper {
	public static Node.DataLeaf findLeaf(Container node, String text) {
		for (Node child : node.getChildren()) {
			if (child instanceof Container) {
				DataLeaf found = findLeaf((Container) child, text);
				if (found != null) {
					return found;
				}
			}
			if (child instanceof DataLeaf) {
				DataLeaf leaf = (DataLeaf) child;
				String data = leaf.getData();
				if (data != null && data.contains(text)) {
					return leaf;
				}
			}
		}
		return null;

	}
}
