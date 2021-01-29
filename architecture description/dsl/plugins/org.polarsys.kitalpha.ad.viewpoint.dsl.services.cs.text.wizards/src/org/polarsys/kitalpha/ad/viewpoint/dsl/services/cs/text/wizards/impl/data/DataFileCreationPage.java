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
/**
 * Copyright (c) THALES, 2012. All rights reserved.
 */
package org.polarsys.kitalpha.ad.viewpoint.dsl.services.cs.text.wizards.impl.data;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.resources.FileExtension;
import org.polarsys.kitalpha.ad.viewpoint.dsl.services.cs.text.wizards.AbstractFileCreationPage;


/**
 * 
 * @author Amine Lajmi
 *
 */
public class DataFileCreationPage extends AbstractFileCreationPage {
		 	 
	public DataFileCreationPage(IStructuredSelection selection) {
		 super(selection);
		 setTitle(Messages.DataFileCreationPage_Title);
		 setDescription(Messages.DataFileCreationPage_Description); 
		 setFileExtension(FileExtension.DATA_EXTENSION);
	 }

	@Override
	public void initializeProperties() {
		setFileName(((DataWizard)getWizard()).getVpShortName() + "." + FileExtension.DATA_EXTENSION);
	}
}
