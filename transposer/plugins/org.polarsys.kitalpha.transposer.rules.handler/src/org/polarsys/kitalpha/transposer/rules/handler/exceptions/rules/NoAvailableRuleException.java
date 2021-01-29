/*******************************************************************************
 * Copyright (c) 2014, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/


package org.polarsys.kitalpha.transposer.rules.handler.exceptions.rules;

import org.polarsys.kitalpha.transposer.rules.handler.exceptions.mappings.MappingResolutionException;

/**
 * @author Franco Bergomi
 *
 */
public class NoAvailableRuleException extends RuleResolutionException{

  /**
   * 
   */
  private static final long serialVersionUID = -5239235660790456450L;
  
  private MappingResolutionException wrappedMappingResolutionException;
  
  public NoAvailableRuleException(){
    super();
  }
  
  public NoAvailableRuleException(MappingResolutionException mre_p){
    super();
    wrappedMappingResolutionException = mre_p;
  }
  
  /**
   * @see java.lang.Throwable#toString()
   */
  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("There are no available rules in your purpose : \n"); //$NON-NLS-1$
    sb.append(wrappedMappingResolutionException);
    return sb.toString();
  }
}
