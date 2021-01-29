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
package org.polarsys.kitalpha.validation.java.provider.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;

/**
 * Constants for the Java Constraint Extension.
 * 
 * @author Yann Mortier
 */
public class JavaConstraintExtension {
	
	public JavaConstraintExtension() {
		// Prevent instantiation
	}

    public static final String JAVA_CONSTRAINTS_ID = "org.polarsys.kitalpha.validation.java";
    
    public static final String JAVA_CONSTRAINT_CLASS = "Class";

    public static Collection<IConfigurationElement> getAllJavaConstraints() {
        return Arrays.asList(getExtensionElt(JAVA_CONSTRAINTS_ID));
    }

    public static Collection<IConfigurationElement> getConstraintsFromContributor(final String contributor) {
        List<IConfigurationElement> result = new LinkedList<IConfigurationElement>();
        for (IConfigurationElement configurationElement : getAllJavaConstraints()) {
            if (configurationElement.getNamespaceIdentifier().equals(contributor)) {
                result.add(configurationElement);
            }
        }
        return result;
    }

    private static IConfigurationElement[] getExtensionElt(String id) {
        IExtensionPoint point = Platform.getExtensionRegistry().getExtensionPoint(id);
        IExtension[] extensions = point.getExtensions();
        ArrayList<IConfigurationElement> configElements = new ArrayList<IConfigurationElement>();
        for (IExtension extension : extensions) {
            configElements.addAll(Arrays.asList(extension.getConfigurationElements()));
        }
        return configElements.toArray(new IConfigurationElement[] {});
    }

}
