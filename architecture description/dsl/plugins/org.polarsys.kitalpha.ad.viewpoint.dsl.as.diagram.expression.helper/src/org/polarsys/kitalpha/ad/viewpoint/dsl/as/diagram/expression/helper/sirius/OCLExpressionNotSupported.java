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


package org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius;

/**
 * Temporary exception. It is used until OCL expression will be supported
 * 
 * @author Boubekeur Zendagui
 */
public class OCLExpressionNotSupported extends RuntimeException {

	/**
	 * id
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor
	 */
	public OCLExpressionNotSupported() {
		super("OCL expression are not supported");
	}

}
