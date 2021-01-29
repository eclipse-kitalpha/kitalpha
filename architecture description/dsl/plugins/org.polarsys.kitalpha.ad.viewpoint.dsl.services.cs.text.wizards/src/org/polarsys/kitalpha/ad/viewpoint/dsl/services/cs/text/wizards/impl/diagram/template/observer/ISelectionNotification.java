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
package org.polarsys.kitalpha.ad.viewpoint.dsl.services.cs.text.wizards.impl.diagram.template.observer;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class;

/**
 * The subject of the observer pattern. It is responsible to notify
 * observers that a class is choosen by the user, in order to 
 * update template.
 * 
 * @author Faycal Abka
 *
 */
public interface ISelectionNotification {
	
	void registerObserver(IObserver observer);
	void unregisterObserver(IObserver observer);
	void notifyObservators(Class vpClass);
}
