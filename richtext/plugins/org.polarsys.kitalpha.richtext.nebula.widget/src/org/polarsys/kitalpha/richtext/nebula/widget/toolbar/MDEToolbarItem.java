/*******************************************************************************
 * Copyright (c) 2017, 2024 Thales Global Services S.A.S. and others
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License 2.0 which is available at
 *  http://www.eclipse.org/legal/epl-2.0
 *  
 *  SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 *  Obeo - Linux Webkit GTK compatibility
 ******************************************************************************/
package org.polarsys.kitalpha.richtext.nebula.widget.toolbar;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.nebula.widgets.richtext.toolbar.ToolbarButton;
import org.eclipse.swt.widgets.Display;
import org.polarsys.kitalpha.richtext.common.intf.MDERichTextWidget;

/**
 * 
 * @author Faycal Abka
 *
 */
public class MDEToolbarItem extends ToolbarButton {

	private final MDERichTextToolbarItemHandler handler;
	private final MDERichTextWidget richText;
	
	public MDEToolbarItem(MDERichTextWidget richtext, String name, String command, String label, String toolbar, URL iconPath, MDERichTextToolbarItemHandler handler) {
		super(name, command, label, toolbar, iconPath);
		this.richText = richtext;
		this.handler = handler;
	}
	

	@Override
	public final String getJavascriptToExecute() {
		return null;
	}
	
	@Override
	public final Object execute() {
		if (Platform.OS_LINUX.equals(Platform.getOS())) {
			Display.getCurrent().asyncExec(new Runnable() {

				@Override
				public void run() {
					executeHandler();
				}
			});
		} else {
				executeHandler();
				}
		return super.execute();
	}
	
	private void executeHandler() {
		if (handler != null) {
			handler.execute(richText);
		}
	}

}
