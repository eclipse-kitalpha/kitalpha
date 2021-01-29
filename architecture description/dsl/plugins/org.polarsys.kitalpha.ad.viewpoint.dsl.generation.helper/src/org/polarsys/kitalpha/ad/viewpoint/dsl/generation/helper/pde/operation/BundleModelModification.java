/*******************************************************************************
 * Copyright (c) 2016, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *    Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/

package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.helper.pde.operation;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.pde.core.IBaseModel;
import org.eclipse.pde.internal.core.ibundle.IBundle;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginModelBase;
import org.eclipse.pde.internal.ui.util.ModelModification;

/**
 * @author Boubekeur Zendagui
 */

@SuppressWarnings("restriction")
public class BundleModelModification extends ModelModification{
	private String _header;
	private String _value;
	private boolean _multiple = false;
	private Map<String, String> _headersMap;
	
	/**
	 * Simple-model modification constructor. It allows to modify only one header value.
	 * @param manifest manifest {@link IFile}
	 * @param header header id
	 * @param value header value
	 */
	public BundleModelModification(IFile manifest, String header, String value) {
		super(manifest);
		this._header = header;
		this._value = value;
	}
	
	/**
	 * Multi-model modification constructor. It allows to modify a set of headers values.
	 * @param manifest manifest {@link IFile}
	 * @param headers a Map of header and their values
	 */
	public BundleModelModification(IFile manifest, Map<String, String> headers) {
		super(manifest);
		_multiple = true;
		this._headersMap = headers;
	}
	
	@Override
	protected void modifyModel(IBaseModel model, IProgressMonitor innerMonitor) throws CoreException {
		if (!(model instanceof IBundlePluginModelBase)) 
		{
			return;
		}

		IBundlePluginModelBase bundleModel = (IBundlePluginModelBase) model;
		IBundle bundle = bundleModel.getBundleModel().getBundle();
		
		if (_multiple)
		{
			for (String key : _headersMap.keySet()) 
			{
				String headerValue = _headersMap.get(key);
				setHeader(bundle, key, headerValue);
			}
		}
		else
		{
			setHeader(bundle, _header, _value);
		}
	}
	
	private void setHeader(IBundle bundle, String header, String value){
		bundle.setHeader(header, value);
	}
}