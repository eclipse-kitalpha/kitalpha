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
package org.polarsys.kitalpha.massactions.visualize.table.layer.row;

import org.eclipse.nebula.widgets.nattable.grid.layer.RowHeaderLayer;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.polarsys.kitalpha.massactions.core.table.layer.body.IMABodyLayer;
import org.polarsys.kitalpha.massactions.core.table.layer.row.MARowHeaderLayer;
import org.polarsys.kitalpha.massactions.visualize.data.provider.MVImageRowHeaderDataProvider;

public class MVRowHeaderLayer extends MARowHeaderLayer {

  public MVRowHeaderLayer(IMABodyLayer bodyLayerStack) {
    super(bodyLayerStack);
  }
  
  @Override
  protected ILayer initializeLayer() {
    
    rowHeaderDataProvider = new MVImageRowHeaderDataProvider(bodyLayerStack.getBodyDataProvider());
    DataLayer rowHeaderDataLayer = new DataLayer(rowHeaderDataProvider, DEFAULT_COLUMN_WIDTH, DEFAULT_ROW_HEIGHT);
    rowHeaderLayer = new RowHeaderLayer(rowHeaderDataLayer, bodyLayerStack.getViewportLayer(),
        bodyLayerStack.getSelectionLayer());

    return rowHeaderLayer;    
  }

}
