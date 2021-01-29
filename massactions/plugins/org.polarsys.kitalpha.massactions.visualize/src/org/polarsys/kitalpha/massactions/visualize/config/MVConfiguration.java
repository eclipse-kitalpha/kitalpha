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
package org.polarsys.kitalpha.massactions.visualize.config;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.extension.glazedlists.groupBy.GroupByHeaderMenuConfiguration;
import org.polarsys.kitalpha.massactions.core.config.MAConfiguration;
import org.polarsys.kitalpha.massactions.core.config.MAMenuConfiguration;
import org.polarsys.kitalpha.massactions.core.config.MAThemeConfiguration;
import org.polarsys.kitalpha.massactions.core.table.layer.body.IMABodyLayer;
import org.polarsys.kitalpha.massactions.visualize.helpers.LayerExtractionHelper;
import org.polarsys.kitalpha.massactions.visualize.table.layer.groupby.IMVGroupByLayer;

/**
 * Configures the NatTable instance for Mass Visualization operations.
 * 
 * @author Sandu Postaru
 * 
 */
public class MVConfiguration extends MAConfiguration {

  public MVConfiguration(NatTable natTable, IConfigRegistry configRegistry) {
    super(natTable, configRegistry);
  }

  protected void addConfigurations() {
    super.addConfigurations();

    GroupByHeaderMenuConfiguration groupByLayer = createGroupByMenuConfiguration();
    natTable.addConfiguration(groupByLayer);
  }

  protected GroupByHeaderMenuConfiguration createGroupByMenuConfiguration() {
    IMVGroupByLayer groupByLayer = LayerExtractionHelper.extractGroupByLayer(natTable);
    return new GroupByHeaderMenuConfiguration(natTable, groupByLayer.getGroupByHeaderLayer());
  }

  protected MAMenuConfiguration createMenuConfiguration() {
    return new MVMenuConfiguration(natTable);
  }

  @Override
  protected MAThemeConfiguration createThemeConfiguration() {
    return new MVThemeConfiguration();
  }

  @Override
  protected IMABodyLayer getBodyLayer() {
    return LayerExtractionHelper.extractBodyLayer(natTable);
  }

}
