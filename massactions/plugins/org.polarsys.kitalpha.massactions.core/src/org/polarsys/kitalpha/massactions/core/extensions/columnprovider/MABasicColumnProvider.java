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
package org.polarsys.kitalpha.massactions.core.extensions.columnprovider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.polarsys.kitalpha.massactions.core.column.IMAColumn;
import org.polarsys.kitalpha.massactions.core.column.primitive.DateColumn;
import org.polarsys.kitalpha.massactions.core.column.primitive.EnumColumn;
import org.polarsys.kitalpha.massactions.core.column.primitive.MAPrimitiveColumn;
import org.polarsys.kitalpha.massactions.core.helper.ColumnProviderHelper;
import org.polarsys.kitalpha.massactions.core.helper.container.PossibleFeature;

/**
 * The default implementation for a column provider.
 * 
 * @author Sandu Postaru
 *
 */
public class MABasicColumnProvider extends AbstractMAColumnProvider {

  @Override
  public Collection<IMAColumn> getColumnValues(Collection<PossibleFeature> commonPossibleFeatures,
      Collection<EObject> data) {

    List<IMAColumn> columns = new ArrayList<>();

    for (PossibleFeature possibleFeature : commonPossibleFeatures) {

      EStructuralFeature feature = possibleFeature.getFeature();
      MAPrimitiveColumn column = null;

      if (ColumnProviderHelper.isReferenceType(feature)) {
        // references are ignored here
        // if needed they should enabled through a custom column provider
        continue;
      } else if (ColumnProviderHelper.isDateType(feature)) {
        column = new DateColumn();
      } else if (ColumnProviderHelper.isEnumType(feature)) {
        column = new EnumColumn();
      } else {
        column = new MAPrimitiveColumn();
      }

      column.setPossibleFeature(possibleFeature);
      columns.add(column);
    }

    return columns;
  }

}
