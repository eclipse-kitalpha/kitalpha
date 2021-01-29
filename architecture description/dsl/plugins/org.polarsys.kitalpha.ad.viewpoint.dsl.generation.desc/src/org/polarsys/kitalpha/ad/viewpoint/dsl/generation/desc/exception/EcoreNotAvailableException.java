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

package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.exception;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.log.ViewpointDslLogger;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util.ECoreFileInformation;

public class EcoreNotAvailableException extends Exception {

	/**
	 * Exception ID
	 */
	private static final long serialVersionUID = 7641525179169992614L;
	
	private ECoreFileInformation _eCoreFileInformation;

	/**
	 * Default constructor 
	 * @param eCoreFileInformation {@link ECoreFileInformation} object containing information about the ecore model
	 */
	public EcoreNotAvailableException(ECoreFileInformation eCoreFileInformation) {
		_eCoreFileInformation = eCoreFileInformation; 
	}
	
	/**
	 * Output a log error in the console 
	 */
	public void logErrorMessage(){
		String ecoreLocaltion = _eCoreFileInformation.getEcoreFileURI().toFileString();
		ViewpointDslLogger.doLogError("Invalid generation state: ecore "+ecoreLocaltion+" is not available");
	}
}
