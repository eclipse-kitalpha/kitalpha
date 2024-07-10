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
package org.polarsys.kitalpha.richtext.nebula.widget;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.Platform;
import org.eclipse.nebula.widgets.richtext.RichTextEditorConfiguration;
import org.eclipse.swt.widgets.Display;

/**
 * 
 * @author Faycal Abka
 *
 */
public class MDENebulaRichTextConfiguration extends RichTextEditorConfiguration {

	private final Map<String, List<String>> allItems;
	private final Collection<String> removedItems;
	private final StringBuffer toolbarGroup;

	public MDENebulaRichTextConfiguration() {
		this.allItems = new LinkedHashMap<String, List<String>>();
		this.removedItems = new HashSet<>();
		this.toolbarGroup = new StringBuffer();
		setOption(MDERichTextConstants.CUSTOM_CONFIG, MDERichTextConstants.DEFAUTL_CUSTOM_CONFIG);
		setOption(RichTextEditorConfiguration.REMOVE_BUTTONS, ""); //$NON-NLS-1$
	}

	public void createToolbar() {
		initializeMDEToolbarGroups();
	}


	private void initializeMDEToolbarGroups(){
		setOption(RichTextEditorConfiguration.TOOLBAR_GROUPS, "[" //$NON-NLS-1$
				+ buildToolbarConfiguration()
				+ "]"); //$NON-NLS-1$
	}

	private String buildToolbarConfiguration(){
		toolbarGroup.setLength(0); //reset

		for(Entry<String, List<String>> e: allItems.entrySet()){
			String group = e.getKey();
			List<String> groupItems = e.getValue();

			toolbarGroup.append("{ ").append("name:'").append(group).append("'"); //$NON-NLS-1$ //$NON-NLS-2$
			if (!groupItems.isEmpty()){
				int size = groupItems.size();
				toolbarGroup.append(", groups: [ "); //$NON-NLS-1$
				for (String gi : groupItems) {
					toolbarGroup.append("'").append(gi).append("'"); //$NON-NLS-1$
					if (groupItems.indexOf(gi) != (size - 1)){
						toolbarGroup.append(","); //$NON-NLS-1$
					}
				}
				toolbarGroup.append("]"); //$NON-NLS-1$
			}
			toolbarGroup.append("},"); //$NON-NLS-1$
		}

		return toolbarGroup.toString();
	}

	public void initializeToolbarItem(String toolbar, String...items){
		if (!allItems.containsKey(toolbar)){
			allItems.put(toolbar, new ArrayList<String>());
			doAddItems(toolbar, items);
		} else {
			doAddItems(toolbar, items);
		}
	}

	private void doAddItems(String toolbar, String... items) {
		for (String item : items) {
			allItems.get(toolbar).add(item);
		}
	}

	public void removeToolbarItems(String... itemNames) {
		for (String item : itemNames) {
			removedItems.add(item);
		}

		StringBuilder builder = new StringBuilder("'"); //$NON-NLS-1$
		int size = removedItems.size();
		int i = 0;
		for (String removed : this.removedItems) {
			builder.append(removed);
			if (i != (size - 1)){
				builder.append(","); //$NON-NLS-1$
			}
			i++;
		}

		builder.append("'");
		setOption(RichTextEditorConfiguration.REMOVE_BUTTONS, builder.toString());
	}



	public void setToolbarPosition(String postion) {

		Assert.isNotNull(postion);
		Assert.isLegal(postion.equals(MDERichTextConstants.TOOLBAR_POSITION_TOP) || 
				postion.equals(MDERichTextConstants.TOOLBAR_POSITION_BOTTOM));

		setOption(MDERichTextConstants.TOOLBAR_POSITION, postion);
	}
	
	@Override
	public void customizeToolbar() {
		if (Platform.OS_LINUX.equals(Platform.getOS())) {
			Display.getCurrent().asyncExec(new Runnable() {

				@Override
				public void run() {
					MDENebulaRichTextConfiguration.super.customizeToolbar();
				}
			});
		} else {
			super.customizeToolbar();
		}
	}
}
