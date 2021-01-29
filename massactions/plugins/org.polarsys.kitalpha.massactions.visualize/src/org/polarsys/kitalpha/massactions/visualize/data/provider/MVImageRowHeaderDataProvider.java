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
package org.polarsys.kitalpha.massactions.visualize.data.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.nebula.widgets.nattable.data.IRowDataProvider;
import org.eclipse.swt.graphics.Image;
import org.polarsys.kitalpha.massactions.core.data.provider.MAImageRowHeaderDataProvider;
import org.polarsys.kitalpha.massactions.visualize.helpers.container.UnfoldedRowObject;

public class MVImageRowHeaderDataProvider extends MAImageRowHeaderDataProvider {

  public MVImageRowHeaderDataProvider(IRowDataProvider<EObject> bodyDataProvider) {
    super(bodyDataProvider);
  }

  @Override
  protected Image extractImage(EObject object) {

    // for UnfoldedObjects use the same image as their source object
    if (object instanceof UnfoldedRowObject) {
      EObject source = ((UnfoldedRowObject) object).getSource();
      return extractImage(source);
    }

    return super.extractImage(object);
  }

}
