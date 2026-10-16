/*******************************************************************************
 * Copyright (c) 2014, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.polarsys.kitalpha.emde.extension.preferences;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.BackingStoreException;
import org.polarsys.kitalpha.emde.Activator;
import org.polarsys.kitalpha.emde.extension.DefaultModelExtensionManager;
import org.polarsys.kitalpha.emde.extension.ExtendedModel;
import org.polarsys.kitalpha.emde.extension.ExtensibleModel;
import org.polarsys.kitalpha.emde.extension.utils.Log;

/**
 * @author Thomas Guiu
 * 
 */
public class PreferenceModelExtensionManager extends DefaultModelExtensionManager {

	private static final String MODEL_DISABLED_PREFERENCE = "model.disabled_";

	@Override
	public void setExtensionModelDisabled(ExtensibleModel extensibleModel, ExtendedModel extendedModel, boolean disabled) {
		if (isExtensionModelDisabled(extendedModel) != disabled) {
			IEclipsePreferences prefs = getPreferencesRoot();
			prefs.putBoolean(computeKey(extendedModel), disabled);
			flushPreferences(prefs);
			fireExtensionEvent(extendedModel.getName(), !disabled);
		}
	}

	@Override
	public boolean isExtensionModelDisabled(ExtendedModel extendedModel) {
		return getPreferencesRoot().getBoolean(computeKey(extendedModel), true);
	}

	protected String computeKey(ExtendedModel extendedModel) {
		return MODEL_DISABLED_PREFERENCE + extendedModel.getQualifiedName();
	}

	static IEclipsePreferences getPreferencesRoot() {
		IEclipsePreferences root = (IEclipsePreferences) Platform.getPreferencesService().getRootNode().node(InstanceScope.SCOPE);
		return (IEclipsePreferences) root.node(Activator.getContext().getBundle().getSymbolicName());
	}

	static void flushPreferences(IEclipsePreferences prefs) {
		try {
			prefs.flush();
		} catch (BackingStoreException e) {
			Log.getDefault().logError(e);
		}
	}

}
