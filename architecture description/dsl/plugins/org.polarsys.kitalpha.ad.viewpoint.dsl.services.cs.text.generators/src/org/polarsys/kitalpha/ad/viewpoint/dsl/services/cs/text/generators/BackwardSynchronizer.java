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

package org.polarsys.kitalpha.ad.viewpoint.dsl.services.cs.text.generators;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResource;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.activityexplorer.model.viewpointActivityExplorer.ViewpointActivityExplorer;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpbuild.Build;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpconf.Configuration;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Aspect;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Data;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.DiagramSet;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIDescription;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.data.DataFactory;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.data.DataSpec;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.diagram.DiagramFactory;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.diagram.Diagrams;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.helpers.vpspec.CoreModelHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.services.Services;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.services.ServicesFactory;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui.UiFactory;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui.UserInterface;
import org.polarsys.kitalpha.ad.viewpoint.dsl.services.cs.text.generators.util.GeneratorsUtil;
import org.polarsys.kitalpha.ad.viewpoint.dsl.services.cs.text.generators.util.ReferenceUtil;

/**
 * 
 * @author Amine Lajmi,
 * Faycal Abka,
 * Arnaud Dieumegard
 *
 */
public class BackwardSynchronizer extends AbstractSynchronizer {
	
	
	@Override
	public EObject backwardSynchronize(Data data, Resource resource) {
		XtextResource textResource = (XtextResource) resource;
		String newContent = null;
		EObject clone = copier.get(data);
		if (textResource.getContents().isEmpty()) {
			DataSpec dataSpec = DataFactory.eINSTANCE.createDataSpec();
			dataSpec.setData((Data)clone);
			textResource.getContents().add(dataSpec);
		} else {
			EObject oldRoot = textResource.getContents().get(0);
			DataSpec dataSpec = DataFactory.eINSTANCE.createDataSpec();
			dataSpec.setData((Data)clone);
			EcoreUtil2.replace(oldRoot, dataSpec);
		}
		
		String serializationContent = textResource.getSerializer().serialize(clone);
		newContent = appendCopyRightHeader(clone, CoreModelHelper.getViewpointShortName(data))+ GeneratorsUtil.getExternalImportDataHeader((Data)clone) +  serializationContent;
		if (saveNewResource(textResource, newContent))
			return textResource.getContents().get(0);
		return null;
	}
	
	@Override
	public EObject backwardSynchronize(Configuration object, Resource target) {
		//no need for specific treatment
		return backwardSynchronize((EObject)object, target);
	}

	public EObject backwardSynchronize(UIDescription inputAspect, Resource resource) {
		XtextResource textResource = (XtextResource) resource;
		EcoreUtil.resolveAll(inputAspect);
		String newContent = null;
		EObject clone = copier.get(inputAspect);
		if (textResource.getContents().isEmpty()) {
			UserInterface ui = UiFactory.eINSTANCE.createUserInterface();
			ui.setUiDescription((Aspect)clone);
			textResource.getContents().add(ui);
		} else {
			EObject oldRoot = textResource.getContents().get(0);
			UserInterface ui = UiFactory.eINSTANCE.createUserInterface();
			ui.setUiDescription((Aspect)clone);
			EcoreUtil2.replace(oldRoot, ui);
		}
		ReferenceUtil.recoverReferences(inputAspect, copier);
		String serializationContent = textResource.getSerializer().serialize(clone);
		newContent = appendCopyRightHeader(clone, CoreModelHelper.getViewpointShortName(inputAspect)) + serializationContent;
		if (saveNewResource(textResource, newContent))
			return textResource.getContents().get(0);
		return null;
	}
	
	public EObject backwardSynchronize(DiagramSet inputAspect, Resource resource) {
		XtextResource textResource = (XtextResource) resource;
		String newContent = null;
		EObject clone = copier.get(inputAspect);
		if (textResource.getContents().isEmpty()) {
			Diagrams diag = DiagramFactory.eINSTANCE.createDiagrams();
			diag.setDiagrams((Aspect)clone);
			textResource.getContents().add(diag);
		} else {
			EObject oldRoot = textResource.getContents().get(0);
			Diagrams diag = DiagramFactory.eINSTANCE.createDiagrams();
			diag.setDiagrams((Aspect)clone);
			EcoreUtil2.replace(oldRoot, diag);
		}
		ReferenceUtil.recoverReferences(inputAspect, copier);
		String serializationContent = textResource.getSerializer().serialize(clone);
		newContent = appendCopyRightHeader(clone, CoreModelHelper.getViewpointShortName(inputAspect)) + GeneratorsUtil.getExternalImportDiagramHeader(inputAspect) + serializationContent;
		if (saveNewResource(textResource, newContent))
			return textResource.getContents().get(0);
		return null;
	}

	@Override
	public EObject backwardSynchronize(Build object, Resource target) {
		//no need for specific treatment
		return backwardSynchronize((EObject)object, target);
	}

	public EObject backwardSynchronize(List<Aspect> aspects, Resource resource) {
		XtextResource textResource = (XtextResource) resource;
		Services services = null;
		if (textResource.getContents().isEmpty()) {
			services = ServicesFactory.eINSTANCE.createServices();
			textResource.getContents().add(services);
		} else {
			EObject oldRoot = (Services) textResource.getContents().get(0);
			services = ServicesFactory.eINSTANCE.createServices();
			EcoreUtil2.replace(oldRoot, services);
		} 
		services.getServices().clear();
		for (Aspect as : aspects) {
			EObject clone = copier.get(as);
			if (clone!=null && validateObject(clone, textResource)) {
				services.getServices().add((Aspect) clone);
			}
		}
		String serializationContent = textResource.getSerializer().serialize(services);
		String shortName = CoreModelHelper.getViewpointShortName(aspects.get(0));
		String newContent = appendCopyRightHeader(services, shortName) + serializationContent;
		if (saveNewResource(textResource, newContent))
			return textResource.getContents().get(0);
		return null;
	}

	@Override
	public EObject backwardSynchronize(ViewpointActivityExplorer object, Resource target) {
		return backwardSynchronize((EObject)object, target);
	}
}
