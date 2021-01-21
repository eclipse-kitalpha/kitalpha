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

package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.desc.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

/**
 * @author Boubekeur Zendagui
 */

public class ENamedElementAnnotationHelper {
	
	public static final String KEY_DOCUMENTATION = "http://www.polarsys.org/kitalpha/ecore/documentation";

	public static final String ENTRY_DOCUMENTATION_KEY = "description";
	
	public static void annotate(ENamedElement namedElement, 
									String source, 
									String key, 
									String value,
									boolean replace){
		EList<EAnnotation> existingannotations = namedElement.getEAnnotations();

		if (existingannotations != null && existingannotations.size() > 0){

		}

		for (int i = 0; i < existingannotations.size(); i++) {
			if (existingannotations.get(i).getSource().trim().equals(source)){
				if (replace){
					namedElement.getEAnnotations().remove(i);
				}
			}
		}
		annotate(namedElement, source, key, value);
	}
	
	private static void annotate(ENamedElement namedElement, 
									String source, 
									String key, 
									String value){
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource(source);
		annotation.getDetails().add(CreateEntry(key, value));
		namedElement.getEAnnotations().add(annotation);
	}

	/**
	 * @param key
	 * @param value
	 */
	private static EStringToStringMapEntryImpl CreateEntry(String key, String value) {
		EStringToStringMapEntryImpl entry = 
			(EStringToStringMapEntryImpl) EcoreFactory.eINSTANCE.create(
										EcorePackage.eINSTANCE.getEStringToStringMapEntry());
		
		entry.setKey(key);
		entry.setValue(value);
		return entry;
	}

}
