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
package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.conf.doc;

import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.helper.configuration.VpDslConfigurationHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpconf.Configuration;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpconf.ConfigurationElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpconf.ExtensionGeneratrionConfiguration;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpconf.Generation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Viewpoint;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.manager.VpdslDescriptionModelManager;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.conf.doc.model.docGenConfiguration.DocumentationGenerationConfiguration;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.conf.element.IGenerationElementInnerConfiguration;
import org.polarsys.kitalpha.doc.gen.business.ecore.genchain.DocgenGenchainExtension.KitalphaDocumentationGeneration;

/**
 * @author Boubekeur Zendagui
 */
public class DocGenGenerationConfiguration implements IGenerationElementInnerConfiguration {

	/*
	 * (non-Javadoc)
	 * @see org.polarsys.kitalpha.ad.viewpoint.dsl.generation.conf.element.IGenerationElementConfiguration#getElementClass()
	 */
	@Override
	public Class<? extends GenerationElement> getElementClass() {
		return KitalphaDocumentationGeneration.class;
	}

	/*
	 * (non-Javadoc)
	 * @see org.polarsys.kitalpha.ad.viewpoint.dsl.generation.conf.element.IGenerationElementConfiguration#isRelevant(org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain, org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement)
	 */
	@Override
	public boolean isRelevant(GenerationChain generationchain, GenerationElement element) {
		Viewpoint viewpoint = VpdslDescriptionModelManager.INSTANCE.getVpDescriptionElement();
		return generateDocumenationFor(viewpoint);
	}

	/*
	 * (non-Javadoc)
	 * @see org.polarsys.kitalpha.ad.viewpoint.dsl.generation.conf.element.IGenerationElementInnerConfiguration#configure(org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement)
	 */
	@Override
	public void configure(GenerationElement element) {
	}
	
	/**
	 * 
	 * @param anyModelElement
	 * @return
	 */
	private static boolean generateDocumenationFor(EObject anyModelElement){
		boolean result = false;
		Configuration vpConf = VpDslConfigurationHelper.getViewpointConfiguration(anyModelElement);
		EList<ConfigurationElement> vpConfigurationElements = vpConf.getVpConfigurationElements();
		if (vpConfigurationElements != null && !vpConfigurationElements.isEmpty())
		{
			for (ConfigurationElement configurationElement : vpConfigurationElements) 
			{
				if (configurationElement instanceof Generation)
				{
					EList<ExtensionGeneratrionConfiguration> ownedExtGenConf = ((Generation) configurationElement).getOwnedExtensionGenConf();
					if (ownedExtGenConf != null && !ownedExtGenConf.isEmpty())
					{
						for (ExtensionGeneratrionConfiguration extGenConf : ownedExtGenConf) 
						{
							if (extGenConf instanceof DocumentationGenerationConfiguration)
							{
								result = ((DocumentationGenerationConfiguration) extGenConf).isEcoreToHtml();
								break;
							}
						}
					}
				}
				if (result) {
					break;
				}
			}
		}
		return result;
	}
}
