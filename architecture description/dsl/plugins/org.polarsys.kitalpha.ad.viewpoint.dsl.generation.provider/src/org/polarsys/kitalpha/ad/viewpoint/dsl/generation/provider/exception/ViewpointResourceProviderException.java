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

package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.provider.exception;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.provider.message.Messages;

/**
 * @author Boubekeur Zendagui
 */

public class ViewpointResourceProviderException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Viewpoint is Null
	 */
	public static final int IS_NULL= 10;
	
	/**
	 * At least one core resource is not available (either ecore, genmodel or 
	 * genchain)
	 */
	public static final int NO_CORE_RESOURCE_AVAILABLE= 20;
	
	/**
	 * Exception integer ID
	 */
	private int id_;
	
	/**
	 * 
	 * @param viewpoint
	 */
	public ViewpointResourceProviderException(int id) {
		super();
		id_ = id;
	}
	
	public boolean isCritical() {
		switch (id_) {
		// Critical cases   
		case IS_NULL:
			return true;
		}
		return false;
	}
	
	@Override
	public String getMessage() {
		String message = "";
		switch (id_) {
			case IS_NULL:
				message = Messages.ViewpointIsNull;
			break;
			case NO_CORE_RESOURCE_AVAILABLE:
				message = Messages.NoCoreResourceAvailable;
			break;
		}
		return message;
	}
	
	public int getId() {
		return id_;
	}

}
