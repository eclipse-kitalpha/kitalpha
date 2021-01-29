/*******************************************************************************
 * Copyright (c) 2018, 2020  Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 *  Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.polarsys.kitalpha.massactions.core.ui.menu;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.ui.menu.PopupMenuBuilder;

/**
 * An extension of the default {@link PopupMenuBuilder}.
 * 
 * @author Sandu Postaru
 *
 */
public class MAPopupMenuBuilder extends PopupMenuBuilder {

  public static final String EDIT_SELECTION_MENU_ITEM_ID = "editSelectionMenuItem"; //$NON-NLS-1$
  public static final String REMOVE_SELECTION_MENU_ITEM_ID = "removeSelectionMenuItem"; //$NON-NLS-1$

  public MenuManager getMenuManager() {
    return menuManager;
  }
  
  public MAPopupMenuBuilder(NatTable parent) {
    super(parent);
  }
  
  public MAPopupMenuBuilder(NatTable parent, MenuManager menuManager) {
    super(parent, menuManager);
  }
    
  public MAPopupMenuBuilder withRemoveSelectionMenuItem() {
    return (MAPopupMenuBuilder) withMenuItemProvider(REMOVE_SELECTION_MENU_ITEM_ID,
        MAMenuItemProviders.createRemoveSelectionMenuItemProvider());
  }

}
