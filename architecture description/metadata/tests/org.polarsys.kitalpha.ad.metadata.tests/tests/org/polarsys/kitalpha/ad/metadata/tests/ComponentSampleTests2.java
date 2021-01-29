/*******************************************************************************
 * Copyright (c) 2016, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.polarsys.kitalpha.ad.metadata.tests;


import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.Version;
import org.polarsys.kitalpha.ad.metadata.commands.SetViewpointFilterCommand;
import org.polarsys.kitalpha.ad.metadata.commands.SetViewpointUsageCommand;
import org.polarsys.kitalpha.ad.metadata.commands.UpdateViewpointVersionCommand;
import org.polarsys.kitalpha.ad.metadata.helpers.MetadataHelper;
import org.polarsys.kitalpha.ad.metadata.helpers.ViewpointMetadata;
import org.polarsys.kitalpha.resourcereuse.helper.ResourceHelper;
import org.polarsys.kitalpha.resourcereuse.helper.ResourceReuse;

import junit.framework.TestCase;


/**
 * @author Thomas Guiu
 * 
 */
public class ComponentSampleTests2 extends ModelTests {


	public ComponentSampleTests2() {
		super("/org.polarsys.kitalpha.ad.metadata.tests/resource/My.componentsample");
	}

	public void testHelper1() throws Exception {
		assertFalse(helper.isReferenced("org.polarsys.kitalpha.vp.componentsampleperformance"));
		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
		
		SetViewpointFilterCommand cmd = new SetViewpointFilterCommand(set, "org.polarsys.kitalpha.vp.componentsampleperformance", true);
		cmd.execute();
		
		assertFalse(helper.isReferenced("org.polarsys.kitalpha.vp.componentsampleperformance"));
		// the viewpoint is not referenced
		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
	}
	
	public void testHelper2() throws Exception {
		assertFalse(helper.isReferenced("org.polarsys.kitalpha.vp.componentsampleperformance"));
		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
		
		org.polarsys.kitalpha.resourcereuse.model.Resource resource = ResourceReuse.createHelper().getResource("org.polarsys.kitalpha.vp.componentsampleperformance");
		helper.reference(resource, null);
		SetViewpointFilterCommand cmd = new SetViewpointFilterCommand(set, "org.polarsys.kitalpha.vp.componentsampleperformance", true);
		cmd.execute();
		
		assertTrue(helper.isReferenced("org.polarsys.kitalpha.vp.componentsampleperformance"));
		assertTrue(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
	}
	
	public void testHelper3() throws Exception {
		assertFalse(helper.isReferenced("org.polarsys.kitalpha.vp.componentsampleperformance"));
		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
		
		org.polarsys.kitalpha.resourcereuse.model.Resource resource = ResourceReuse.createHelper().getResource("org.polarsys.kitalpha.vp.componentsampleperformance");
		helper.reference(resource, null);
		SetViewpointFilterCommand cmd = new SetViewpointFilterCommand(set, "org.polarsys.kitalpha.vp.componentsampleperformance", true);
		cmd.execute();
		cmd.undo();
		
		assertTrue(helper.isReferenced("org.polarsys.kitalpha.vp.componentsampleperformance"));
		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
	}
	
	public void testHelper4() throws Exception {
		assertFalse(helper.isReferenced("org.polarsys.kitalpha.vp.componentsampleperformance"));
		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
		
		org.polarsys.kitalpha.resourcereuse.model.Resource resource = ResourceReuse.createHelper().getResource("org.polarsys.kitalpha.vp.componentsampleperformance");
		helper.reference(resource, null);
		SetViewpointFilterCommand cmd = new SetViewpointFilterCommand(set, "org.polarsys.kitalpha.vp.componentsampleperformance", true);
		cmd.execute();
		cmd = new SetViewpointFilterCommand(set, "org.polarsys.kitalpha.vp.componentsampleperformance", false);
		cmd.execute();
		
		assertTrue(helper.isReferenced("org.polarsys.kitalpha.vp.componentsampleperformance"));
		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
	}
	
	public void testHelper5() throws Exception {
		assertFalse(helper.isReferenced("org.polarsys.kitalpha.vp.componentsampleperformance"));
		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
		
		org.polarsys.kitalpha.resourcereuse.model.Resource resource = ResourceReuse.createHelper().getResource("org.polarsys.kitalpha.vp.componentsampleperformance");
		SetViewpointUsageCommand cmd = new SetViewpointUsageCommand(set, resource,null, true);
		cmd.execute();
		
		Map<String, Version> viewpointReferences = helper.getViewpointReferences();
		assertNotNull(viewpointReferences);
		Version version2 = viewpointReferences.get("org.polarsys.kitalpha.vp.componentsampleperformance");

		assertNull(version2);
		assertTrue(helper.isReferenced("org.polarsys.kitalpha.vp.componentsampleperformance"));
		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
	}
	
	public void testHelper6() throws Exception {
		assertFalse(helper.isReferenced("org.polarsys.kitalpha.vp.componentsampleperformance"));
		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
		
		org.polarsys.kitalpha.resourcereuse.model.Resource resource = ResourceReuse.createHelper().getResource("org.polarsys.kitalpha.vp.componentsampleperformance");
		Version version = new Version(5,6,7);
		SetViewpointUsageCommand cmd = new SetViewpointUsageCommand(set, resource, version, true);
		cmd.execute();
		
		Map<String, Version> viewpointReferences = helper.getViewpointReferences();
		assertNotNull(viewpointReferences);
		Version version2 = viewpointReferences.get("org.polarsys.kitalpha.vp.componentsampleperformance");
		assertNotNull(version2);
		assertEquals(version, version2);

		assertTrue(helper.isReferenced("org.polarsys.kitalpha.vp.componentsampleperformance"));
		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
	}
	

	public void testHelper7() throws Exception {
		assertFalse(helper.isReferenced("org.polarsys.kitalpha.vp.componentsampleperformance"));
		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
		
		org.polarsys.kitalpha.resourcereuse.model.Resource resource = ResourceReuse.createHelper().getResource("org.polarsys.kitalpha.vp.componentsampleperformance");
		SetViewpointUsageCommand cmd = new SetViewpointUsageCommand(set, resource,null, true);
		cmd.execute();
		cmd.undo();

		assertFalse(helper.isReferenced("org.polarsys.kitalpha.vp.componentsampleperformance"));
		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
	}
	
	public void testHelper8() throws Exception {
		assertFalse(helper.isReferenced("org.polarsys.kitalpha.vp.componentsampleperformance"));
		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
		
		org.polarsys.kitalpha.resourcereuse.model.Resource resource = ResourceReuse.createHelper().getResource("org.polarsys.kitalpha.vp.componentsampleperformance");
		helper.reference(resource, null);

		Version version = new Version(5,6,7);
		UpdateViewpointVersionCommand cmd = new UpdateViewpointVersionCommand(set, resource, version);
		cmd.execute();
		
		Map<String, Version> viewpointReferences = helper.getViewpointReferences();
		assertNotNull(viewpointReferences);
		Version version2 = viewpointReferences.get("org.polarsys.kitalpha.vp.componentsampleperformance");
		assertNotNull(version2);
		assertEquals(version, version2);

		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
	}
	
	public void testHelper9() throws Exception {
		assertFalse(helper.isReferenced("org.polarsys.kitalpha.vp.componentsampleperformance"));
		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
		
		org.polarsys.kitalpha.resourcereuse.model.Resource resource = ResourceReuse.createHelper().getResource("org.polarsys.kitalpha.vp.componentsampleperformance");
		helper.reference(resource, null);

		Version version = new Version(5,6,7);
		UpdateViewpointVersionCommand cmd = new UpdateViewpointVersionCommand(set, resource, version);
		cmd.execute();
		cmd.undo();
		
		Map<String, Version> viewpointReferences = helper.getViewpointReferences();
		assertNotNull(viewpointReferences);
		Version version2 = viewpointReferences.get("org.polarsys.kitalpha.vp.componentsampleperformance");
		assertNull(version2);

		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
	}
	
	public void testHelper10() throws Exception {
		assertFalse(helper.isReferenced("org.polarsys.kitalpha.vp.componentsampleperformance"));
		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
		
		Version version = new Version(5,6,7);
		org.polarsys.kitalpha.resourcereuse.model.Resource resource = ResourceReuse.createHelper().getResource("org.polarsys.kitalpha.vp.componentsampleperformance");
		helper.reference(resource, version);

		UpdateViewpointVersionCommand cmd = new UpdateViewpointVersionCommand(set, resource, null);
		cmd.execute();
		
		Map<String, Version> viewpointReferences = helper.getViewpointReferences();
		assertNotNull(viewpointReferences);
		Version version2 = viewpointReferences.get("org.polarsys.kitalpha.vp.componentsampleperformance");
		assertNull(version2);

		assertFalse(helper.isInactive("org.polarsys.kitalpha.vp.componentsampleperformance"));
	}
}
