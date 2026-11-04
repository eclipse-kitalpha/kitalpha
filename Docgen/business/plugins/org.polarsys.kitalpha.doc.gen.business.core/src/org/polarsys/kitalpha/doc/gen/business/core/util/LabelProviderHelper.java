/*******************************************************************************
 * Copyright (c) 2014, 2026 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.doc.gen.business.core.util;

import java.net.URL;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.polarsys.kitalpha.doc.gen.business.core.Activator;
import org.polarsys.kitalpha.doc.gen.business.core.messages.Messages;

public class LabelProviderHelper {
	private static final String PNG = "png";
	private static final String GIF = "gif";
	private static final String ICON_FOLDER_NAME = "icon";
	private static final NullProgressMonitor MONITOR = new NullProgressMonitor();

	protected LabelProviderHelper(){
		// Allow subclassing
	}
	
	public static void initImageRegistry() {
		GenDocExtendedImageRegistry.getInstance();
	}

	public static void disposeImageRegistry() {
		GenDocExtendedImageRegistry.getInstance().dispose();
	}

	public static String getText(EObject eObject) {
		String result = EObjectLabelProviderHelper.getText(eObject);
		if (result.equals(EObjectLabelProviderHelper.EMPTY_STRING)) {
			final Object eObjectLabelProvider = getIItemLabelProvider(eObject);
			if (eObjectLabelProvider instanceof IItemLabelProvider) {
				result = ((IItemLabelProvider) eObjectLabelProvider)
						.getText(eObject);
			}
		}
		return result;
	}

	public static Object getIItemLabelProvider(EObject eObject) {
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		Object result = null;
		try {
			result = adapterFactory.adapt(eObject, IItemLabelProvider.class);
		} catch (NullPointerException e) {
			Activator.logWarning(NLS.bind(Messages.warning_LabelProvider_GetText_NPE, eObject, e.getMessage()), e);
		}
		return result;
	}

	public static Object getImage(EObject eObject) {
		final Object eObjectLabelProvider = getIItemLabelProvider(eObject);
		if (eObjectLabelProvider instanceof IItemLabelProvider) {
			return ((IItemLabelProvider) eObjectLabelProvider)
					.getImage(eObject);
		}
		return null;
	}

	public static String getImageFileName(EObject eObject, String projectName, String folderName) {
		return getImageFileNameFromImageObject(getImage(eObject), projectName, folderName);
	}

	protected static String getImageFileNameFromImageObject(Object imageObject, String projectName, String folderName) {
		final Image image = getImageFromObject(imageObject);
		final String simpleFileName = getImageName(imageObject);
		final IFolder iconFolder = getIconFolder(projectName, folderName);
		IFile iconFile = iconFolder.getFile(simpleFileName);
		if (!iconFile.exists()) {
			String withoutFileExtension = iconFile.getLocation().toString()
					.replace(iconFile.getLocation().getFileExtension(), "");

			IFile iconFileTemp = createNewIconFile(image, withoutFileExtension);
			if (iconFileTemp != null) {
				iconFile = iconFileTemp;
			}
			try {
				iconFolder.refreshLocal(IResource.DEPTH_ONE, MONITOR);
			} catch (CoreException e) {
				Activator.logWarning(e.getMessage(), e);
			}
		}
		return iconFile.getName();
	}

	private static String getImageName(Object imageObject) {
		String simpleFileName = "";
		if (imageObject instanceof URL) {
			simpleFileName = URI.createURI(((URL) imageObject).toString())
					.lastSegment();
		} else if (imageObject instanceof ComposedImage) {
			Object mainImageObject = ((ComposedImage) imageObject).getImages()
					.get(0);
			if (mainImageObject != null) {
				simpleFileName = "controlled_" + getImageName(mainImageObject);
			}
		}
		return simpleFileName;
	}

	private static Image getImageFromObject(Object object) {
		try {
			return GenDocExtendedImageRegistry.getInstance().getImage(object);
		} catch (Exception e) {
			Activator.logWarning(e.getMessage(), e);
			return null;
		}
	}

	private static IFile createNewIconFile(Image iconImage, String fileName) {
		if (iconImage != null) {
			final ImageLoader loader = new ImageLoader();
			loader.data = new ImageData[] { iconImage.getImageData() };
			try {
				// if image is encoded as more than 8-bits, then we save it into
				// png format.
				if (iconImage.getImageData().depth > 8) {
					fileName = fileName + PNG;
					loader.save(fileName, SWT.IMAGE_PNG);
				} else {
					fileName = fileName + GIF;
					loader.save(fileName, SWT.IMAGE_GIF);
				}
			} catch (Exception e) {
				Activator.logWarning(e.getMessage(), e);
			}
			return ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(
					new Path(fileName));
		}
		return null;
	}

	private static IFolder getIconFolder(String projectName, String folderName) {
		final IPath path = new Path(projectName).append(folderName);
		final IFolder pathFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
		if (!pathFolder.exists()) {
			try {
				pathFolder.create(true, true, MONITOR);
			} catch (CoreException e) {
				Activator.logWarning(e.getMessage(), e);
			}
		}
		final IContainer parent = pathFolder.getParent();
		final IPath iconPath = parent.getFullPath().append(ICON_FOLDER_NAME);
		final IFolder iconFolder = ResourcesPlugin.getWorkspace().getRoot()
				.getFolder(iconPath);
		if (iconFolder == null || ! iconFolder.exists()) {
			try {
				FileHelper.createContainers(MONITOR, iconFolder);
				iconFolder.create(true, true, MONITOR);
			} catch (CoreException e) {
				Activator.logWarning(e.getMessage(), e);
			}
		}
		return iconFolder;

	}
}
