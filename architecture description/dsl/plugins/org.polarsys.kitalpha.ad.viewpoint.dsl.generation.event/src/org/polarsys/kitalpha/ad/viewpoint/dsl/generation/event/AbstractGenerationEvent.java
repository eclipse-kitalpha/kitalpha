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

package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.event;

import java.util.EventObject;

import org.eclipse.egf.model.fcore.Activity;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.event.manager.GenerationEventManager;

/**
 * @author Boubekeur Zendagui
 */

public abstract class AbstractGenerationEvent extends EventObject {
	
	private static final long serialVersionUID = 8900085456659444778L;
	private EGenerarationEventKind _kind;
	private Activity _source;
	
	/**
	 * Hidden constructor.
	 * @param arg0
	 */
	public AbstractGenerationEvent(Activity source) {
		super(source);
		setSource(source);
	}
	
	public void fire(){
		GenerationEventManager.getInstance().notifyGenerationListener(this);
	}

	/**
	 * 
	 * @return
	 */
	public EGenerarationEventKind getKind(){
		return _kind;
	}
	
	/**
	 * 
	 * @param kind
	 */
	public void setKind(EGenerarationEventKind kind){
		_kind = kind;
	}
	
	/**
	 * 
	 * @return
	 */
	public Activity getSource(){
		return _source;
	}
	
	/**
	 * 
	 * @param activity
	 */
	public void setSource(Activity activity){
		_source = activity;
	}
}
