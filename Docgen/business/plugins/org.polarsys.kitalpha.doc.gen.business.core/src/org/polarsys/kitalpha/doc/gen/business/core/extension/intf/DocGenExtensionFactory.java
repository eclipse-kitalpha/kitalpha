/*******************************************************************************
 * Copyright (c) 2016-2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.doc.gen.business.core.extension.intf;

import org.polarsys.kitalpha.doc.gen.business.core.extension.imp.DocGenExtensionEngine;
import org.polarsys.kitalpha.doc.gen.business.core.extension.imp.DocGenExtensionManager;

/**
 * Factory to instantiate infrastructures to access/execute contributions
 * @author Faycal Abka
 *
 */
public class DocGenExtensionFactory {
	
	/**
	 * Hidden constructor
	 */
	private DocGenExtensionFactory() {
	}
	
	/**
	 * @return singleton of Doc Gen extension manager
	 */
	public static IDocGenExtension getDocGenExtensionManager(){
		return DocGenExtensionManager.getInstance();
	}
	
	/**
	 * @return a new Doc Gen Extension engine to execute patterns
	 */
	public static IDocGenExtensionEngine newDocGenExtensionEngine(){
		return new DocGenExtensionEngine();
	}

}
