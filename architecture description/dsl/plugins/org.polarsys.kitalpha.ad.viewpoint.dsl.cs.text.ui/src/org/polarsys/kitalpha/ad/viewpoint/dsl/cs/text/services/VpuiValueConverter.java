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
package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.services;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.common.services.Ecore2XtextTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;

/**
 * 
 * @author Amine Lajmi
 *
 */
public class VpuiValueConverter extends Ecore2XtextTerminalConverters{
	
	@ValueConverter(rule = "FQN")
	public IValueConverter<String> getFQNNameConverter() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			protected String internalToValue(String string, INode node) throws ValueConverterException {
				StringBuilder result = new StringBuilder();
				for(ILeafNode leaf: node.getLeafNodes()) {
					if (!leaf.isHidden()) {
						if (leaf.getGrammarElement() instanceof Keyword) {
							result.append(leaf.getText());
						} else {
							result.append(ID().toValue(leaf.getText(), leaf));
						}
					}
				}
				return result.toString();
			}

			@Override
			protected String internalToString(String value) {
				String[] splitted = value.split("\\.");
				StringBuilder result = new StringBuilder(value.length());
				for(int i = 0; i < splitted.length; i++) {
					if (i != 0) {
						result.append('.');
					}
					//trim
					result.append(ID().toString(splitted[i].replaceAll(" ", "")));
				}
				return result.toString();
			}
		};
	}
}
