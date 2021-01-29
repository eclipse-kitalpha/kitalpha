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
package org.polarsys.kitalpha.model.common.scrutiny.analyzer;

/**
 * @author Faycal Abka
 */
public class ModelScrutinyException extends Exception {

	private static final long serialVersionUID = 7014705563026180357L;
	
	public ModelScrutinyException(String message){
		super(message);
	}
}
