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

package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.resources.FileExtension;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.resources.ResourceHelper;


/**
 * 
 * @author Amine Lajmi
 *
 */
public class VpservicesMatchingStrategy implements IEditorMatchingStrategy {

	@Override
	public boolean matches(IEditorReference editorRef, IEditorInput input) {
		if (input instanceof FileEditorInput) {
			IWorkbenchPart part = editorRef.getPart(true);
			if (part instanceof XtextEditor) {
				XtextEditor editor = (XtextEditor) part;
				IEditorInput editorInput = editor.getEditorInput();
				if (!editorInput.equals(input)) {
					return false;
				}
			}
			FileEditorInput fInput = (FileEditorInput) input;
			String fileExtension = ResourceHelper.getFileExtension(fInput.getFile());
			if (fileExtension.equals(FileExtension.SERVICES_EXTENSION)) {
				return true;
			}
		}
		return false;
	}

}
