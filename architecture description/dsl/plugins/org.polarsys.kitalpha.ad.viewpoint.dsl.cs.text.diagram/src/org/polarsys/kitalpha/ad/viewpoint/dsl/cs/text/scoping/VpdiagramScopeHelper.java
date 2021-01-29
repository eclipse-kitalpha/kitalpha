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
package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.scoping;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.commondata.AbstractAssociation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.commondata.AbstractClass;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.commondata.ExternalAssociation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.commondata.ExternalClass;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.commondata.LocalClass;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractSuperClass;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.ExternalClassAssociation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.LocalClassAssociation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.LocalSuperClass;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.BorderedNode;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Container;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.EdgeDomainAssociation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.Node;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.NodeDomainElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.util.ProjectUtil;
import org.polarsys.kitalpha.emde.model.ElementExtension;
import org.polarsys.kitalpha.emde.model.EmdePackage;


/**
 * @author Faycal Abka
 *
 */

/*
 * FIXME: This is ugly class helper for the scope. Redefine it for better
 * performance and code reading
 */
public class VpdiagramScopeHelper {

	
	/*
	 * ***********************************
	 * 		External Associations
	 * ***********************************
	 */
	public static boolean selectExternalAssociation(EObject context,
			IEObjectDescription d) {		

		if (context instanceof ExternalAssociation){
			ExternalAssociation externalAssociation = (ExternalAssociation)context;
			NodeDomainElement nde = VpDiagramHelper.getNodeDomainElementFrom(externalAssociation);


			if (nde == null && externalAssociation.eContainer() instanceof EdgeDomainAssociation){
				return d.getEObjectOrProxy() instanceof EReference;
			}

			EObject ndeContainer = nde.eContainer();
			if (ndeContainer instanceof Container || ndeContainer instanceof Node || ndeContainer instanceof BorderedNode){

				AbstractClass domainClass = VpDiagramHelper.getDomain_class(nde); 
				AbstractClass containerDomainClass = VpDiagramHelper.getDomainContainerOfContainerOfElement(nde);

				if (domainClass == null){
					return d.getEObjectOrProxy() instanceof EReference;
				}

				if (containerDomainClass == null){
					//With import
					EClass eClass = VpDiagramHelper.getDomainContainerOfContainerOfElementExternal(nde);

					if (domainClass instanceof ExternalClass){
						ExternalClass externalDomainClass = (ExternalClass)domainClass;
						return handleExternalExternalAssociation(d, externalDomainClass.getClass_(), eClass);
					}

					if (domainClass instanceof LocalClass){
						LocalClass localDomainClass = (LocalClass)domainClass;
						return handleExternalLocalAssociation(d, localDomainClass.getClass_(), eClass);
					}

					return d.getEObjectOrProxy() instanceof EReference;
				}

				if (containerDomainClass instanceof ExternalClass){

					ExternalClass externalContainerDomainClass = (ExternalClass)containerDomainClass;

					if (domainClass instanceof ExternalClass){
						ExternalClass externalDomainClass = (ExternalClass)domainClass;

						return handleExternalExternalAssociation(d, externalDomainClass, externalContainerDomainClass);
					}

					if (domainClass instanceof LocalClass){
						LocalClass localDomainClass = (LocalClass)domainClass;
						return handExternalLocalAssociation(d, localDomainClass, externalContainerDomainClass);
					}
				}
			}
		}
		return d.getEObjectOrProxy() instanceof EReference;
	}
	

	private static boolean handExternalLocalAssociation(IEObjectDescription d,
			LocalClass localDomainClass,
			ExternalClass externalContainerDomainClass) {
		
		return handleExternalLocalAssociation(d, localDomainClass.getClass_(), externalContainerDomainClass.getClass_());
	}


	private static boolean handleExternalLocalAssociation(
			IEObjectDescription d, Class localClass, EClass externalEClass) {
		Collection<EClass> superEClasses = VpDiagramHelper.getExternalSuperClassEClasses(localClass);
		
		boolean result = false;
		for (EClass eClass : superEClasses) {
			result |= handleExternalExternalAssociation(d, eClass, externalEClass);
		}
		
		return result;
	}


	private static boolean handleExternalExternalAssociation(
			IEObjectDescription ieod, 
			ExternalClass externalDomainClass,
			ExternalClass externalContainerDomainClass) {
		
		return handleExternalExternalAssociation(ieod, externalDomainClass.getClass_(), externalContainerDomainClass.getClass_());
	}


	private static boolean handleExternalExternalAssociation(IEObjectDescription ieod, EClass domainEClass,
			EClass containerEClass) {
		
		if (domainEClass == null || containerEClass == null) {
			return false;
		} 
		
		
		EList<EReference> allReferencesContainerDomain = containerEClass.getEAllReferences();
		EList<EReference> filtredReferences = VpDiagramHelper.filterReferenceWithType(allReferencesContainerDomain, domainEClass);
		EList<EClass> typeRefClasses = new UniqueEList<EClass>();
		EList<String> refTypeNames = new UniqueEList<String>();
		
		for (EReference eReference : filtredReferences) {
			typeRefClasses.add((EClass) eReference.getEType());
			refTypeNames.add(eReference.getEType().getName());
		}
		
		
		EObject r = ieod.getEObjectOrProxy();
		EReference ref = null;
		
		if (r instanceof EReference) {
			ref = (EReference)r;
		}
		;
		return (ref != null) && ((refTypeNames.contains(ref.getEType().getName())) || ref.getEType() == EmdePackage.eINSTANCE.getElementExtension());
	}

	
	/*
	 * ***********************************
	 * 		Local Associations
	 * ***********************************
	 */
	
	public static boolean selectLocalAssociation(EObject context,
			IEObjectDescription d) {

		
		if (d.getEObjectOrProxy() instanceof LocalClassAssociation){
			if (context instanceof NodeDomainElement){
				NodeDomainElement nde =  (NodeDomainElement)context;

				
				EObject ndeContainer = nde.eContainer();
				if (ndeContainer instanceof Container || ndeContainer instanceof Node || ndeContainer instanceof BorderedNode){
					AbstractClass domainClass = VpDiagramHelper.getDomain_class(nde);
					AbstractClass containerDomainClass = VpDiagramHelper.getDomainContainerOfContainerOfElement(nde);

					if (domainClass == null) {
						return  d.getEObjectOrProxy() instanceof AbstractAssociation;
					}

					if (containerDomainClass == null){
						//With import
						EClass eClass = VpDiagramHelper.getDomainContainerOfContainerOfElementExternal(nde);
						
						if (domainClass instanceof ExternalClass){
							ExternalClass externalDomainClass = (ExternalClass)domainClass;
							return handleExternalExternalAssociation(d, externalDomainClass.getClass_(), eClass);
						}
						
						if (domainClass instanceof LocalClass){
							LocalClass localDomainClass = (LocalClass)domainClass;
							return handleExternalLocalAssociation(d, localDomainClass.getClass_(), eClass);
						}
						
						return d.getEObjectOrProxy() instanceof ElementExtension; 
					}

					if (containerDomainClass instanceof LocalClass){
						LocalClass containerLocalDomainClass = (LocalClass)containerDomainClass;

						if (domainClass instanceof LocalClass){
							LocalClass localDomainClass = (LocalClass)domainClass;

							return handleLocalLocalAssociation(d, localDomainClass, containerLocalDomainClass) 
									&& ProjectUtil.areInSameProject(context, d.getEObjectOrProxy());
						}

						if (domainClass instanceof ExternalClass){
							return d.getEObjectOrProxy() instanceof ElementExtension; 
						}
					}
				}
			}
		}

		return (d.getEObjectOrProxy() instanceof LocalClassAssociation || d.getEObjectOrProxy() instanceof ExternalClassAssociation) && ProjectUtil.areInSameProject(context, d.getEObjectOrProxy());
	}
	
	
	/*
	 * Local local domain classes
	 */

	private static boolean handleLocalLocalAssociation(IEObjectDescription d,
			LocalClass localDomainClass, LocalClass containerLocalDomainClass) {
		
		return  handleLocalLocalAssociation(d, localDomainClass.getClass_(), containerLocalDomainClass.getClass_());
	}

	private static boolean handleLocalLocalAssociation(IEObjectDescription d,
		Class localVpdescClass, Class containerVpdescClass) {
		
		if (localVpdescClass == null || containerVpdescClass == null) {
			return false;
		}
			
		Collection<org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractAssociation> availableAssociations = getAllAssociations(containerVpdescClass);
		filterWithType(availableAssociations, localVpdescClass);
		LocalClassAssociation lca = (LocalClassAssociation)d.getEObjectOrProxy();
		Class target  = lca.getLocalTarget();
		
		return (VpDiagramHelper.areEqualWithHerarchy(target, localVpdescClass)) && (availableAssociations.contains(lca));
	}
	
	
	private static Collection<org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractAssociation> getAllAssociations(Class containerDomain){
		Collection<org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractAssociation> associations =
				new HashSet<org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractAssociation>();

		
		associations.addAll(containerDomain.getVP_Classes_Associations());
		EList<AbstractSuperClass> superTypes = containerDomain.getInheritences();

		
		for (AbstractSuperClass abstractSuperClass : superTypes) {
			if (abstractSuperClass instanceof LocalSuperClass){
				LocalSuperClass lsc = (LocalSuperClass)abstractSuperClass;
				Class clazz = lsc.getSuperClass();
				associations.addAll(clazz.getVP_Classes_Associations());
				getAllAssociations_rec(associations, clazz);
			}
		}
		
		return associations;
	}
	
	
	static Collection<AbstractSuperClass> visited = new HashSet<AbstractSuperClass>();
	private static void getAllAssociations_rec(
			Collection<org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractAssociation> associations,
			Class clazz) {
		
		if (clazz == null) {
			return;
		}
		
		EList<AbstractSuperClass> superTypes = clazz.getInheritences();
		
		if (superTypes.isEmpty()) {
			return;
		}

		for (AbstractSuperClass abstractSuperClass : superTypes) {
			if (!visited.contains(abstractSuperClass)){
				if (abstractSuperClass instanceof LocalSuperClass){
					LocalSuperClass lsc = (LocalSuperClass)abstractSuperClass;
					Class clazz2 = lsc.getSuperClass();
					associations.addAll(clazz2.getVP_Classes_Associations());
					visited.add(abstractSuperClass);
					getAllAssociations_rec(associations, clazz);
				}
			}
		}
	}
	
	private static void filterWithType(Collection<org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractAssociation> associations,
			Class type){
		Collection<Class> hierarchyTypes = getHierarchyEClassifiersOf(type);
		
		Iterator<org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractAssociation> it = associations.iterator();
		
		while(it.hasNext()){
			org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractAssociation a = it.next();
			if (a instanceof LocalClassAssociation){
				LocalClassAssociation tmp = (LocalClassAssociation)a;
				if (!hierarchyTypes.contains(tmp.getLocalTarget())){
					it.remove();
				}
			}
		}
	}
	
	
	private static Collection<Class> getHierarchyEClassifiersOf(Class type){
		Collection<Class> eClasses = new HashSet<Class>();
		
		eClasses.add(type);
		
		EList<AbstractSuperClass> superClasses = type.getInheritences();
		
		for (AbstractSuperClass abstractSuperClass : superClasses) {
			if (abstractSuperClass instanceof LocalSuperClass){
				LocalSuperClass lsc = (LocalSuperClass)abstractSuperClass;
				Class clazz = lsc.getSuperClass();
				eClasses.add(clazz);
				getHierarchyEClassifiersOf_rec(eClasses, clazz);
			}
		}
		
		return eClasses;
	}
	
	private static void getHierarchyEClassifiersOf_rec(Collection<Class> eClasses,
			Class clazz) {
		EList<AbstractSuperClass> superClasses = clazz.getInheritences();
		
		if (superClasses.isEmpty()) {
			return;
		}
		
		for (AbstractSuperClass abstractSuperClass : superClasses) {
			if (abstractSuperClass instanceof LocalSuperClass){
				LocalSuperClass lsc = (LocalSuperClass)abstractSuperClass;
				Class clazz2 = lsc.getSuperClass();
				eClasses.add(clazz2);
				getHierarchyEClassifiersOf_rec(eClasses, clazz2);
			}
		}
		
	}
}
