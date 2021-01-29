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
 ******************************************************************************/

package org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.validation.domain;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.validation.extension.IAdditionalConstraint;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.validation.extension.ValidationStatus;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.validation.message.Messages;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.validation.util.MappingUtils;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.AbstractNode;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.DiagramElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.NodeDomainElement;

/**
 * @author Boubekeur Zendagui
 */

public class AbstractNodeDomain implements IAdditionalConstraint {

	private static final int Flag_NullDomain = 1;
	private static final int Flag_NullDomainClass = 2;
	private static final int Flag_BothQueryAndAssociation = 3;
	private static final int Flag_NeitherQueryAndAssociation  = 4;

	@Override
	public boolean isObjectInScope(Object object) {
		return object instanceof AbstractNode;
	}
	
	@Override
	public ValidationStatus validationRules(Object data) {
		if (! MappingUtils.isImport(data))
		{
			AbstractNode abstractNode = (AbstractNode) data;
			NodeDomainElement domain = abstractNode.getThe_domain();
			if (domain == null) {
				return ValidationStatus.getErrorStatusWithRuleFlag(Flag_NullDomain);
			} else
			{
				if (domain.getDomain_Class() == null) {
					return ValidationStatus.getErrorStatusWithRuleFlag(Flag_NullDomainClass);
				}
				
				if (domain.getChlidren_list() == null && 
						(domain.getQuery() == null || domain.getQuery().trim().length() == 0)) {
					return ValidationStatus.getErrorStatusWithRuleFlag(Flag_NeitherQueryAndAssociation);
				}
				
				if (domain.getChlidren_list() != null && 
						(domain.getQuery() != null && domain.getQuery().trim().length() > 0)) {
					return ValidationStatus.getErrorStatusWithRuleFlag(Flag_BothQueryAndAssociation);
				}
			}
		}
		
		return ValidationStatus.Ok;
	}

	@Override
	public String getMessage(ValidationStatus status, Object object) {
		String nodeName = ((DiagramElement) object).getName();

		if (nodeName == null || nodeName.trim().length() == 0)
		 {
			nodeName = "a "+ ((EObject)object).eClass().getName(); //$NON-NLS-1$
		}
		
		int flag = Integer.parseInt(status.getRuleFlag().toString());
		switch (flag) {
			case Flag_NullDomain:
				return Messages.bind(Messages.Validation_Domain_NullDomain , nodeName);
			
			case Flag_NullDomainClass:
				return  Messages.bind(Messages.Validation_Domain_NullDomainClass , nodeName);
			
			case Flag_NeitherQueryAndAssociation:
				return Messages.bind(Messages.Validation_Domain_Node_NeitherQueryOrAssociation , nodeName);
			
			case Flag_BothQueryAndAssociation:
				return Messages.bind(Messages.Validation_Domain_Node_BothQueryAndAssociation , nodeName);
			
			default:
				return Messages.Validation_NoMessage;
		}

		
	}
}
