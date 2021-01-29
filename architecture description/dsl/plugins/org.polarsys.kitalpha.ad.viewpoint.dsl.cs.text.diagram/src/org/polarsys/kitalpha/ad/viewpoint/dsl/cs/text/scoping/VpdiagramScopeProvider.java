/*******************************************************************************
 * Copyright (c) 2017, 2020 Thales Global Services S.A.S.
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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.sirius.diagram.description.ConditionalEdgeStyleDescription;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.DiagramElementMapping;
import org.eclipse.sirius.diagram.description.EdgeMapping;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.diagram.description.style.BeginLabelStyleDescription;
import org.eclipse.sirius.diagram.description.style.CenterLabelStyleDescription;
import org.eclipse.sirius.diagram.description.style.ContainerStyleDescription;
import org.eclipse.sirius.diagram.description.style.EdgeStyleDescription;
import org.eclipse.sirius.diagram.description.style.EndLabelStyleDescription;
import org.eclipse.sirius.diagram.description.style.NodeStyleDescription;
import org.eclipse.sirius.viewpoint.description.ColorDescription;
import org.eclipse.sirius.viewpoint.description.style.BasicLabelStyleDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.AbstractNode;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.BorderedNode;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.DiagramElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.VpdiagramPackage;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.ColorCustomization;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.helper.ColorsUseCasesHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.util.ProjectUtil;

import com.google.common.base.Predicate;


/**
 * 
 * @author Amine Lajmi
 * 		   Faycal Abka
 *
 */
public class VpdiagramScopeProvider extends AbstractDeclarativeScopeProvider {

	/**
	 * Scope of the vpdiagram sublanguage
	 */
	IScope scope_LocalClass_class(EObject context, EReference reference) {
		
		final EObject context2 = context;
		return new FilteringScope(delegateGetScope(context, reference),
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d) {
						return (d.getEObjectOrProxy() instanceof org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class 
								&& ProjectUtil.areInSameProject(context2, d.getEObjectOrProxy()));
					}
				});
	}
	
	IScope scope_ExternalClass_class(EObject context, EReference reference) {
		return new FilteringScope(delegateGetScope(context, reference),
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d) {
						return (d.getEObjectOrProxy() instanceof EClass);
					}
				});
	}
	
	IScope scope_NodeDomainElement_domain_Class(EObject context, EReference reference) {
		
		final EObject context2 = context;
		return new FilteringScope(delegateGetScope(context, reference),
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d) {
						return (d.getEObjectOrProxy() instanceof org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class
								&& ProjectUtil.areInSameProject(context2, d.getEObjectOrProxy()));
					}
				});
	}
	
	IScope scope_NodeDomainElement_chlidren_list(EObject context, EReference reference) {
		
		final EObject context2 = context;
		return new FilteringScope(delegateGetScope(context, reference),
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d) {
						return (d.getEObjectOrProxy() instanceof org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.LocalClassAssociation
								&& ProjectUtil.areInSameProject(context2, d.getEObjectOrProxy()));
					}
				});
	}
	
	
	IScope scope_ExternalAssociation_reference(EObject context, EReference reference) {
		
		final EObject context2 = context;
		return new FilteringScope(delegateGetScope(context, reference),
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d) {
						return VpdiagramScopeHelper.selectExternalAssociation(context2, d);
					}
					
		});
	}
	
	
	IScope scope_LocalAssociation_reference(EObject context, EReference reference) {
		
		final EObject context2 = context;
		
		return new FilteringScope(delegateGetScope(context, reference),
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d) {
						 return VpdiagramScopeHelper.selectLocalAssociation(context2, d);
					}
				});
	}
	
	IScope scope_DomainElement_attribute(EObject context, EReference reference) {
		
		final EObject context2 = context;
		return new FilteringScope(delegateGetScope(context, reference),
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d) {
						return (d.getEObjectOrProxy() instanceof org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Attribute 
								&& ProjectUtil.areInSameProject(context2, d.getEObjectOrProxy()));
					}
				});
	}
	
	IScope scope_DiagramExtension_extented_diagram(EObject context, EReference reference) {
		return new FilteringScope(delegateGetScope(context, reference),
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d) {
						return (d.getEObjectOrProxy() instanceof DiagramDescription);
					}
				});
	}
	
	IScope scope_Edge_source(EObject context, EReference reference) {
		
		final EObject context2 = context;
		return new FilteringScope(delegateGetScope(context, reference),
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d) {
						return (d.getEObjectOrProxy() instanceof DiagramElement && ProjectUtil.areInSameProject(context2, d.getEObjectOrProxy()));
					}
				});
	}
	
	IScope scope_Edge_target(EObject context, EReference reference) {
		
		final EObject context2 = context;
		return new FilteringScope(delegateGetScope(context, reference),
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d) {
						return (d.getEObjectOrProxy() instanceof DiagramElement && ProjectUtil.areInSameProject(context2, d.getEObjectOrProxy()));
					}
				});
	}
	
	IScope scope_EdgeImport_imports(EObject context, EReference reference) {
		
		final EObject context2 = context;
		final EReference reference2 = reference;
		
		return new FilteringScope(delegateGetScope(context, reference),
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d) {
						
						EObject diagramExtension = VpDiagramHelper.getDiagramContainerInstanceType(context2, VpdiagramPackage.eINSTANCE.getDiagramExtension());
						
						if (diagramExtension != null) {
							return VpDiagramHelper.isValidEdge(d.getEObjectOrProxy(), diagramExtension, reference2);
						}
						
						return (d.getEObjectOrProxy() instanceof EdgeMapping);
					}
				});
	}
	
	IScope scope_Node_imports(EObject context, EReference reference) {
		
		final EObject context2 = context;
		final EReference reference2 = reference;
		
		return new FilteringScope(delegateGetScope(context, reference),
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d) {
						
						EObject diagramExtension = VpDiagramHelper.getDiagramContainerInstanceType(context2, VpdiagramPackage.eINSTANCE.getDiagramExtension());
						
						if (diagramExtension != null) {
							return VpDiagramHelper.isValidNode(d.getEObjectOrProxy(), diagramExtension, reference2);
						}
						
						return (d.getEObjectOrProxy() instanceof NodeMapping);
					}
				});
	}
	
	IScope scope_BorderedNode_imports(EObject context, EReference reference) {
		
		final EObject context2 = context;
		final EReference reference2 = reference;
		
		return new FilteringScope(delegateGetScope(context, reference),
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d) {
						
						EObject diagramExtension = VpDiagramHelper.getDiagramContainerInstanceType(context2, VpdiagramPackage.eINSTANCE.getDiagramExtension());
						
						if (diagramExtension != null) {
							return VpDiagramHelper.isValidNode(d.getEObjectOrProxy(), diagramExtension, reference2);
						}
						
						return (d.getEObjectOrProxy() instanceof NodeMapping);
					}
				});
	}
	
	IScope scope_Container_imports(EObject context, EReference reference) {
		
		final EObject context2 = context;
		final EReference reference2 = reference;
		
		return new FilteringScope(delegateGetScope(context, reference),
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d) {
						EObject diagramExtension = VpDiagramHelper.getDiagramContainerInstanceType(context2, VpdiagramPackage.eINSTANCE.getDiagramExtension());
						
						if (diagramExtension != null) {
							return VpDiagramHelper.isValidContainerMapping(d.getEObjectOrProxy(), diagramExtension, reference2);
						}
						
						return (d.getEObjectOrProxy() instanceof ContainerMapping);
					}
				});
	}
	
	IScope scope_Action_tool_For(EObject context, EReference reference) {
		
		final EObject context2 = context;
		return new FilteringScope(delegateGetScope(context, reference),
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d) {
						return (d.getEObjectOrProxy() instanceof DiagramElement && ProjectUtil.areInSameProject(context2, d.getEObjectOrProxy()));
					}
				});
	}
	
	IScope scope_ContainerChildren_reused_nodes(EObject context, EReference reference){
		
		final EObject context2 = context;
		return new FilteringScope(delegateGetScope(context, reference), 
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d){
						return (d.getEObjectOrProxy() instanceof AbstractNode && ProjectUtil.areInSameProject(context2, d.getEObjectOrProxy()));
					}
				});
	}
	
	
	IScope scope_NodeChildren_reused_boderednodes(EObject context, EReference reference){
		
		final EObject context2 = context;
		return new FilteringScope(delegateGetScope(context, reference), 
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d){
						return (d.getEObjectOrProxy() instanceof BorderedNode && ProjectUtil.areInSameProject(context2, d.getEObjectOrProxy()));
					}
				});
	}
	
	IScope scope_EdgeStyleCustomization_appliedOn(EObject context, EReference reference){
		return new FilteringScope(delegateGetScope(context, reference), 
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d){
						return d.getEObjectOrProxy() instanceof EdgeStyleDescription || 
								d.getEObjectOrProxy() instanceof ConditionalEdgeStyleDescription;
					}
		});
	}
	
	IScope scope_EdgeStyleCustomization_centeredSourceMappings(EObject context, EReference reference){
		return new FilteringScope(delegateGetScope(context, reference), 
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d){
						return d.getEObjectOrProxy() instanceof DiagramElementMapping;
					}
		});
	}
	
	IScope scope_EdgeStyleCustomization_centeredTargetMappings(EObject context, EReference reference){
		return new FilteringScope(delegateGetScope(context, reference), 
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d){
						return d.getEObjectOrProxy() instanceof DiagramElementMapping;
					}
		});
	}
	
	IScope scope_EdgeStyleCustomization_beginLabelStyleDescription(EObject context, EReference reference){
		return new FilteringScope(delegateGetScope(context, reference), 
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d){
						return d.getEObjectOrProxy() instanceof BeginLabelStyleDescription;
					}
		});
	}
	
	IScope scope_EdgeStyleCustomization_centerLabelStyleDescription(EObject context, EReference reference){
		return new FilteringScope(delegateGetScope(context, reference), 
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d){
						return d.getEObjectOrProxy() instanceof CenterLabelStyleDescription;
					}
		});
	}
	
	IScope scope_EdgeStyleCustomization_endLabelStyleDescription(EObject context, EReference reference){
		return new FilteringScope(delegateGetScope(context, reference), 
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d){
						return d.getEObjectOrProxy() instanceof EndLabelStyleDescription;
					}
		});
	}
	
	IScope scope_ColorCustomization_appliedOn(EObject context, EReference reference){
		final EObject context2 = context;
		return new FilteringScope(delegateGetScope(context, reference), 
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d){
						if (context2 instanceof ColorCustomization){
							EObject candidate = d.getEObjectOrProxy();
							return ColorsUseCasesHelper.acceptColor((ColorCustomization)context2, candidate);
						}
						return false;
					}
		});
	}
	
	IScope scope_LabelCustomization_appliedOn(EObject context, EReference reference){
		return new FilteringScope(delegateGetScope(context, reference), 
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d){
						return d.getEObjectOrProxy() instanceof BasicLabelStyleDescription;
					}
		});
	}
	
	IScope scope_LabelCustomization_color(EObject context, EReference reference){
		return new FilteringScope(delegateGetScope(context, reference), 
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d){
						return d.getEObjectOrProxy() instanceof ColorDescription;
					}
		});
	}
	
	
	IScope scope_ColorCustomization_color(EObject context, EReference reference){
		return new FilteringScope(delegateGetScope(context, reference), 
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d){
						return d.getEObjectOrProxy() instanceof ColorDescription;
					}
		});
	}
	
	
	IScope scope_ContainerStyleCustomization_appliedOn(EObject context, EReference reference){
		return new FilteringScope(delegateGetScope(context, reference), 
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d){
						return d.getEObjectOrProxy() instanceof ContainerStyleDescription;
					}
		});
	}
	
	IScope scope_NodeStyleCustomization_appliedOn(EObject context, EReference reference){
		return new FilteringScope(delegateGetScope(context, reference), 
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d){
						return d.getEObjectOrProxy() instanceof NodeStyleDescription;
					}
		});
	}

	IScope scope_MappingBasedDecorator_externalMappings(EObject context, EReference reference){
		return new FilteringScope(delegateGetScope(context, reference), 
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d){
						return d.getEObjectOrProxy() instanceof DiagramElementMapping;
					}
		});
	}

	IScope scope_MappingBasedDecorator_internalMappings(EObject context, EReference reference){
		return new FilteringScope(delegateGetScope(context, reference), 
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d){
						return d.getEObjectOrProxy() instanceof DiagramElement;
					}
		});
	}

	IScope scope_SemanticBasedDecorator_domain(EObject context, EReference reference){
		return new FilteringScope(delegateGetScope(context, reference), 
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription d){
						return d.getEObjectOrProxy() instanceof EClass;
					}
		});
	}
}
