/**
 * Copyright (c) 2009, 2020 Thales Corporate Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */

package org.polarsys.kitalpha.ad.viewpoint.emfvalidation.rules.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Thomas Guiu
 * 
 */
public class TargetsDialog extends ElementDialog {

	private final EPackage[] packages;

	public TargetsDialog(Shell shell, EPackage[] packages) {
		super(shell);
		this.packages = packages;
	}

	@Override
	protected void init() {
		List<Object> objs = new ArrayList<Object>();
		for (EPackage pack : packages) {
			objs.addAll(pack.getEClassifiers());
		}
		viewer.setInput(objs);
	}

	public EClassifier[] getResults() {
		return (EClassifier[]) selection.toList().toArray(new EClassifier[selection.size()]);
	}

	@Override
	protected String getDialogTitle() {
		return "Choose the classifier to use";
	}
}
