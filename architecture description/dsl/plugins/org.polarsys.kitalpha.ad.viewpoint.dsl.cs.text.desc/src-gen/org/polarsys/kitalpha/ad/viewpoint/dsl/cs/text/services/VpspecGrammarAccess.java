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
package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.services.CommonGrammarAccess;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class VpspecGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class ViewpointElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Vpspec.Viewpoint");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cViewpointAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cViewpointKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cShortNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cShortNameIDTerminalRuleCall_2_0 = (RuleCall)cShortNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cNameKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cNameAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cNameSTRINGTerminalRuleCall_4_1_0 = (RuleCall)cNameAssignment_4_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cDescriptionKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cDescriptionAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cDescriptionEStringParserRuleCall_5_1_0 = (RuleCall)cDescriptionAssignment_5_1.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cExtendsKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cParentsAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final CrossReference cParentsViewpointCrossReference_6_1_0 = (CrossReference)cParentsAssignment_6_1.eContents().get(0);
		private final RuleCall cParentsViewpointFQNParserRuleCall_6_1_0_1 = (RuleCall)cParentsViewpointCrossReference_6_1_0.eContents().get(1);
		private final Group cGroup_6_2 = (Group)cGroup_6.eContents().get(2);
		private final Keyword cCommaKeyword_6_2_0 = (Keyword)cGroup_6_2.eContents().get(0);
		private final Assignment cParentsAssignment_6_2_1 = (Assignment)cGroup_6_2.eContents().get(1);
		private final CrossReference cParentsViewpointCrossReference_6_2_1_0 = (CrossReference)cParentsAssignment_6_2_1.eContents().get(0);
		private final RuleCall cParentsViewpointFQNParserRuleCall_6_2_1_0_1 = (RuleCall)cParentsViewpointCrossReference_6_2_1_0.eContents().get(1);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cAggregatesKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Assignment cDependenciesAssignment_7_1 = (Assignment)cGroup_7.eContents().get(1);
		private final CrossReference cDependenciesViewpointCrossReference_7_1_0 = (CrossReference)cDependenciesAssignment_7_1.eContents().get(0);
		private final RuleCall cDependenciesViewpointFQNParserRuleCall_7_1_0_1 = (RuleCall)cDependenciesViewpointCrossReference_7_1_0.eContents().get(1);
		private final Group cGroup_7_2 = (Group)cGroup_7.eContents().get(2);
		private final Keyword cCommaKeyword_7_2_0 = (Keyword)cGroup_7_2.eContents().get(0);
		private final Assignment cDependenciesAssignment_7_2_1 = (Assignment)cGroup_7_2.eContents().get(1);
		private final CrossReference cDependenciesViewpointCrossReference_7_2_1_0 = (CrossReference)cDependenciesAssignment_7_2_1.eContents().get(0);
		private final RuleCall cDependenciesViewpointFQNParserRuleCall_7_2_1_0_1 = (RuleCall)cDependenciesViewpointCrossReference_7_2_1_0.eContents().get(1);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cUsesViewpointKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Assignment cUseViewpointAssignment_8_1 = (Assignment)cGroup_8.eContents().get(1);
		private final CrossReference cUseViewpointViewpointCrossReference_8_1_0 = (CrossReference)cUseViewpointAssignment_8_1.eContents().get(0);
		private final RuleCall cUseViewpointViewpointFQNParserRuleCall_8_1_0_1 = (RuleCall)cUseViewpointViewpointCrossReference_8_1_0.eContents().get(1);
		private final Group cGroup_8_2 = (Group)cGroup_8.eContents().get(2);
		private final Keyword cCommaKeyword_8_2_0 = (Keyword)cGroup_8_2.eContents().get(0);
		private final Assignment cUseViewpointAssignment_8_2_1 = (Assignment)cGroup_8_2.eContents().get(1);
		private final CrossReference cUseViewpointViewpointCrossReference_8_2_1_0 = (CrossReference)cUseViewpointAssignment_8_2_1.eContents().get(0);
		private final RuleCall cUseViewpointViewpointFQNParserRuleCall_8_2_1_0_1 = (RuleCall)cUseViewpointViewpointCrossReference_8_2_1_0.eContents().get(1);
		private final Group cGroup_9 = (Group)cGroup.eContents().get(9);
		private final Keyword cUsesModelKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final Assignment cUseAnyEMFResourceAssignment_9_1 = (Assignment)cGroup_9.eContents().get(1);
		private final RuleCall cUseAnyEMFResourceEStringParserRuleCall_9_1_0 = (RuleCall)cUseAnyEMFResourceAssignment_9_1.eContents().get(0);
		private final Group cGroup_9_2 = (Group)cGroup_9.eContents().get(2);
		private final Keyword cCommaKeyword_9_2_0 = (Keyword)cGroup_9_2.eContents().get(0);
		private final Assignment cUseAnyEMFResourceAssignment_9_2_1 = (Assignment)cGroup_9_2.eContents().get(1);
		private final RuleCall cUseAnyEMFResourceEStringParserRuleCall_9_2_1_0 = (RuleCall)cUseAnyEMFResourceAssignment_9_2_1.eContents().get(0);
		private final Group cGroup_10 = (Group)cGroup.eContents().get(10);
		private final Keyword cUsesDiagramKeyword_10_0 = (Keyword)cGroup_10.eContents().get(0);
		private final Assignment cUseDiagramResourceAssignment_10_1 = (Assignment)cGroup_10.eContents().get(1);
		private final RuleCall cUseDiagramResourceEStringParserRuleCall_10_1_0 = (RuleCall)cUseDiagramResourceAssignment_10_1.eContents().get(0);
		private final Group cGroup_10_2 = (Group)cGroup_10.eContents().get(2);
		private final Keyword cCommaKeyword_10_2_0 = (Keyword)cGroup_10_2.eContents().get(0);
		private final Assignment cUseDiagramResourceAssignment_10_2_1 = (Assignment)cGroup_10_2.eContents().get(1);
		private final RuleCall cUseDiagramResourceEStringParserRuleCall_10_2_1_0 = (RuleCall)cUseDiagramResourceAssignment_10_2_1.eContents().get(0);
		private final Group cGroup_11 = (Group)cGroup.eContents().get(11);
		private final Keyword cUsesWorkspaceKeyword_11_0 = (Keyword)cGroup_11.eContents().get(0);
		private final Assignment cUseWorkspaceResourceAssignment_11_1 = (Assignment)cGroup_11.eContents().get(1);
		private final RuleCall cUseWorkspaceResourceEStringParserRuleCall_11_1_0 = (RuleCall)cUseWorkspaceResourceAssignment_11_1.eContents().get(0);
		private final Group cGroup_11_2 = (Group)cGroup_11.eContents().get(2);
		private final Keyword cCommaKeyword_11_2_0 = (Keyword)cGroup_11_2.eContents().get(0);
		private final Assignment cUseWorkspaceResourceAssignment_11_2_1 = (Assignment)cGroup_11_2.eContents().get(1);
		private final RuleCall cUseWorkspaceResourceEStringParserRuleCall_11_2_1_0 = (RuleCall)cUseWorkspaceResourceAssignment_11_2_1.eContents().get(0);
		private final Group cGroup_12 = (Group)cGroup.eContents().get(12);
		private final Keyword cUsesFilesystemKeyword_12_0 = (Keyword)cGroup_12.eContents().get(0);
		private final Assignment cUseFSResourceAssignment_12_1 = (Assignment)cGroup_12.eContents().get(1);
		private final RuleCall cUseFSResourceEStringParserRuleCall_12_1_0 = (RuleCall)cUseFSResourceAssignment_12_1.eContents().get(0);
		private final Group cGroup_12_2 = (Group)cGroup_12.eContents().get(2);
		private final Keyword cCommaKeyword_12_2_0 = (Keyword)cGroup_12_2.eContents().get(0);
		private final Assignment cUseFSResourceAssignment_12_2_1 = (Assignment)cGroup_12_2.eContents().get(1);
		private final RuleCall cUseFSResourceEStringParserRuleCall_12_2_1_0 = (RuleCall)cUseFSResourceAssignment_12_2_1.eContents().get(0);
		private final Group cGroup_13 = (Group)cGroup.eContents().get(13);
		private final Keyword cDataKeyword_13_0 = (Keyword)cGroup_13.eContents().get(0);
		private final Assignment cVP_DataAssignment_13_1 = (Assignment)cGroup_13.eContents().get(1);
		private final CrossReference cVP_DataDataCrossReference_13_1_0 = (CrossReference)cVP_DataAssignment_13_1.eContents().get(0);
		private final RuleCall cVP_DataDataFQNParserRuleCall_13_1_0_1 = (RuleCall)cVP_DataDataCrossReference_13_1_0.eContents().get(1);
		private final Group cGroup_14 = (Group)cGroup.eContents().get(14);
		private final Assignment cTypeAssignment_14_0 = (Assignment)cGroup_14.eContents().get(0);
		private final Keyword cTypeUIKeyword_14_0_0 = (Keyword)cTypeAssignment_14_0.eContents().get(0);
		private final Assignment cVP_AspectsAssignment_14_1 = (Assignment)cGroup_14.eContents().get(1);
		private final CrossReference cVP_AspectsUIDescriptionCrossReference_14_1_0 = (CrossReference)cVP_AspectsAssignment_14_1.eContents().get(0);
		private final RuleCall cVP_AspectsUIDescriptionFQNParserRuleCall_14_1_0_1 = (RuleCall)cVP_AspectsUIDescriptionCrossReference_14_1_0.eContents().get(1);
		private final Group cGroup_15 = (Group)cGroup.eContents().get(15);
		private final Assignment cTypeAssignment_15_0 = (Assignment)cGroup_15.eContents().get(0);
		private final Keyword cTypeDiagramsKeyword_15_0_0 = (Keyword)cTypeAssignment_15_0.eContents().get(0);
		private final Assignment cVP_AspectsAssignment_15_1 = (Assignment)cGroup_15.eContents().get(1);
		private final CrossReference cVP_AspectsDiagramSetCrossReference_15_1_0 = (CrossReference)cVP_AspectsAssignment_15_1.eContents().get(0);
		private final RuleCall cVP_AspectsDiagramSetFQNParserRuleCall_15_1_0_1 = (RuleCall)cVP_AspectsDiagramSetCrossReference_15_1_0.eContents().get(1);
		private final Group cGroup_16 = (Group)cGroup.eContents().get(16);
		private final Assignment cTypeAssignment_16_0 = (Assignment)cGroup_16.eContents().get(0);
		private final Keyword cTypeActivityExplorerKeyword_16_0_0 = (Keyword)cTypeAssignment_16_0.eContents().get(0);
		private final Assignment cVP_AspectsAssignment_16_1 = (Assignment)cGroup_16.eContents().get(1);
		private final CrossReference cVP_AspectsViewpointActivityExplorerCrossReference_16_1_0 = (CrossReference)cVP_AspectsAssignment_16_1.eContents().get(0);
		private final RuleCall cVP_AspectsViewpointActivityExplorerFQNParserRuleCall_16_1_0_1 = (RuleCall)cVP_AspectsViewpointActivityExplorerCrossReference_16_1_0.eContents().get(1);
		private final Group cGroup_17 = (Group)cGroup.eContents().get(17);
		private final Assignment cTypeAssignment_17_0 = (Assignment)cGroup_17.eContents().get(0);
		private final Keyword cTypeServicesKeyword_17_0_0 = (Keyword)cTypeAssignment_17_0.eContents().get(0);
		private final Assignment cVP_AspectsAssignment_17_1 = (Assignment)cGroup_17.eContents().get(1);
		private final CrossReference cVP_AspectsServiceSetCrossReference_17_1_0 = (CrossReference)cVP_AspectsAssignment_17_1.eContents().get(0);
		private final RuleCall cVP_AspectsServiceSetFQNParserRuleCall_17_1_0_1 = (RuleCall)cVP_AspectsServiceSetCrossReference_17_1_0.eContents().get(1);
		private final Group cGroup_18 = (Group)cGroup.eContents().get(18);
		private final Assignment cTypeAssignment_18_0 = (Assignment)cGroup_18.eContents().get(0);
		private final Keyword cTypeBuildKeyword_18_0_0 = (Keyword)cTypeAssignment_18_0.eContents().get(0);
		private final Assignment cVP_AspectsAssignment_18_1 = (Assignment)cGroup_18.eContents().get(1);
		private final CrossReference cVP_AspectsBuildCrossReference_18_1_0 = (CrossReference)cVP_AspectsAssignment_18_1.eContents().get(0);
		private final RuleCall cVP_AspectsBuildFQNParserRuleCall_18_1_0_1 = (RuleCall)cVP_AspectsBuildCrossReference_18_1_0.eContents().get(1);
		private final Group cGroup_19 = (Group)cGroup.eContents().get(19);
		private final Assignment cTypeAssignment_19_0 = (Assignment)cGroup_19.eContents().get(0);
		private final Keyword cTypeConfigurationKeyword_19_0_0 = (Keyword)cTypeAssignment_19_0.eContents().get(0);
		private final Assignment cVP_AspectsAssignment_19_1 = (Assignment)cGroup_19.eContents().get(1);
		private final CrossReference cVP_AspectsConfigurationCrossReference_19_1_0 = (CrossReference)cVP_AspectsAssignment_19_1.eContents().get(0);
		private final RuleCall cVP_AspectsConfigurationFQNParserRuleCall_19_1_0_1 = (RuleCall)cVP_AspectsConfigurationCrossReference_19_1_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_20 = (Keyword)cGroup.eContents().get(20);
		
		/// ********************************************************************
		// * 							vpspec
		// * 
		// ******************************************************************** /
		//Viewpoint:
		//	{Viewpoint} 'Viewpoint' shortName=ID? '{' ('name:' name=STRING) ('description:' description=EString)? ('extends'
		//	parents+=[Viewpoint|FQN] (',' parents+=[Viewpoint|FQN])*)? ('aggregates' dependencies+=[Viewpoint|FQN] (','
		//	dependencies+=[Viewpoint|FQN])*)? ('uses viewpoint' useViewpoint+=[Viewpoint|FQN] (','
		//	useViewpoint+=[Viewpoint|FQN])*)? ('uses model' useAnyEMFResource+=EString (',' useAnyEMFResource+=EString)*)?
		//	('uses diagram' useDiagramResource+=EString (',' useDiagramResource+=EString)*)? ('uses workspace'
		//	useWorkspaceResource+=EString (',' useWorkspaceResource+=EString)*)? ('uses filesystem' useFSResource+=EString (','
		//	useFSResource+=EString)*)? ('Data' VP_Data=[vpdesc::Data|FQN])? (type+='UI' VP_Aspects+=[vpui::UIDescription|FQN])?
		//	(type+='Diagrams' VP_Aspects+=[vpdiagram::DiagramSet|FQN])? (type+='Activity-Explorer'
		//	VP_Aspects+=[activtyExplorer::ViewpointActivityExplorer|FQN])? (type+='Services'
		//	VP_Aspects+=[vpservices::ServiceSet|FQN])? (type+='Build' VP_Aspects+=[vpbuild::Build|FQN])? (type+='Configuration'
		//	VP_Aspects+=[vpconf::Configuration|FQN])? '}';
		@Override public ParserRule getRule() { return rule; }

		//{Viewpoint} 'Viewpoint' shortName=ID? '{' ('name:' name=STRING) ('description:' description=EString)? ('extends'
		//parents+=[Viewpoint|FQN] (',' parents+=[Viewpoint|FQN])*)? ('aggregates' dependencies+=[Viewpoint|FQN] (','
		//dependencies+=[Viewpoint|FQN])*)? ('uses viewpoint' useViewpoint+=[Viewpoint|FQN] (','
		//useViewpoint+=[Viewpoint|FQN])*)? ('uses model' useAnyEMFResource+=EString (',' useAnyEMFResource+=EString)*)?
		//('uses diagram' useDiagramResource+=EString (',' useDiagramResource+=EString)*)? ('uses workspace'
		//useWorkspaceResource+=EString (',' useWorkspaceResource+=EString)*)? ('uses filesystem' useFSResource+=EString (','
		//useFSResource+=EString)*)? ('Data' VP_Data=[vpdesc::Data|FQN])? (type+='UI' VP_Aspects+=[vpui::UIDescription|FQN])?
		//(type+='Diagrams' VP_Aspects+=[vpdiagram::DiagramSet|FQN])? (type+='Activity-Explorer'
		//VP_Aspects+=[activtyExplorer::ViewpointActivityExplorer|FQN])? (type+='Services'
		//VP_Aspects+=[vpservices::ServiceSet|FQN])? (type+='Build' VP_Aspects+=[vpbuild::Build|FQN])? (type+='Configuration'
		//VP_Aspects+=[vpconf::Configuration|FQN])? '}'
		public Group getGroup() { return cGroup; }

		//{Viewpoint}
		public Action getViewpointAction_0() { return cViewpointAction_0; }

		//'Viewpoint'
		public Keyword getViewpointKeyword_1() { return cViewpointKeyword_1; }

		//shortName=ID?
		public Assignment getShortNameAssignment_2() { return cShortNameAssignment_2; }

		//ID
		public RuleCall getShortNameIDTerminalRuleCall_2_0() { return cShortNameIDTerminalRuleCall_2_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }

		//('name:' name=STRING)
		public Group getGroup_4() { return cGroup_4; }

		//'name:'
		public Keyword getNameKeyword_4_0() { return cNameKeyword_4_0; }

		//name=STRING
		public Assignment getNameAssignment_4_1() { return cNameAssignment_4_1; }

		//STRING
		public RuleCall getNameSTRINGTerminalRuleCall_4_1_0() { return cNameSTRINGTerminalRuleCall_4_1_0; }

		//('description:' description=EString)?
		public Group getGroup_5() { return cGroup_5; }

		//'description:'
		public Keyword getDescriptionKeyword_5_0() { return cDescriptionKeyword_5_0; }

		//description=EString
		public Assignment getDescriptionAssignment_5_1() { return cDescriptionAssignment_5_1; }

		//EString
		public RuleCall getDescriptionEStringParserRuleCall_5_1_0() { return cDescriptionEStringParserRuleCall_5_1_0; }

		//('extends' parents+=[Viewpoint|FQN] (',' parents+=[Viewpoint|FQN])*)?
		public Group getGroup_6() { return cGroup_6; }

		//'extends'
		public Keyword getExtendsKeyword_6_0() { return cExtendsKeyword_6_0; }

		//parents+=[Viewpoint|FQN]
		public Assignment getParentsAssignment_6_1() { return cParentsAssignment_6_1; }

		//[Viewpoint|FQN]
		public CrossReference getParentsViewpointCrossReference_6_1_0() { return cParentsViewpointCrossReference_6_1_0; }

		//FQN
		public RuleCall getParentsViewpointFQNParserRuleCall_6_1_0_1() { return cParentsViewpointFQNParserRuleCall_6_1_0_1; }

		//(',' parents+=[Viewpoint|FQN])*
		public Group getGroup_6_2() { return cGroup_6_2; }

		//','
		public Keyword getCommaKeyword_6_2_0() { return cCommaKeyword_6_2_0; }

		//parents+=[Viewpoint|FQN]
		public Assignment getParentsAssignment_6_2_1() { return cParentsAssignment_6_2_1; }

		//[Viewpoint|FQN]
		public CrossReference getParentsViewpointCrossReference_6_2_1_0() { return cParentsViewpointCrossReference_6_2_1_0; }

		//FQN
		public RuleCall getParentsViewpointFQNParserRuleCall_6_2_1_0_1() { return cParentsViewpointFQNParserRuleCall_6_2_1_0_1; }

		//('aggregates' dependencies+=[Viewpoint|FQN] (',' dependencies+=[Viewpoint|FQN])*)?
		public Group getGroup_7() { return cGroup_7; }

		//'aggregates'
		public Keyword getAggregatesKeyword_7_0() { return cAggregatesKeyword_7_0; }

		//dependencies+=[Viewpoint|FQN]
		public Assignment getDependenciesAssignment_7_1() { return cDependenciesAssignment_7_1; }

		//[Viewpoint|FQN]
		public CrossReference getDependenciesViewpointCrossReference_7_1_0() { return cDependenciesViewpointCrossReference_7_1_0; }

		//FQN
		public RuleCall getDependenciesViewpointFQNParserRuleCall_7_1_0_1() { return cDependenciesViewpointFQNParserRuleCall_7_1_0_1; }

		//(',' dependencies+=[Viewpoint|FQN])*
		public Group getGroup_7_2() { return cGroup_7_2; }

		//','
		public Keyword getCommaKeyword_7_2_0() { return cCommaKeyword_7_2_0; }

		//dependencies+=[Viewpoint|FQN]
		public Assignment getDependenciesAssignment_7_2_1() { return cDependenciesAssignment_7_2_1; }

		//[Viewpoint|FQN]
		public CrossReference getDependenciesViewpointCrossReference_7_2_1_0() { return cDependenciesViewpointCrossReference_7_2_1_0; }

		//FQN
		public RuleCall getDependenciesViewpointFQNParserRuleCall_7_2_1_0_1() { return cDependenciesViewpointFQNParserRuleCall_7_2_1_0_1; }

		//('uses viewpoint' useViewpoint+=[Viewpoint|FQN] (',' useViewpoint+=[Viewpoint|FQN])*)?
		public Group getGroup_8() { return cGroup_8; }

		//'uses viewpoint'
		public Keyword getUsesViewpointKeyword_8_0() { return cUsesViewpointKeyword_8_0; }

		//useViewpoint+=[Viewpoint|FQN]
		public Assignment getUseViewpointAssignment_8_1() { return cUseViewpointAssignment_8_1; }

		//[Viewpoint|FQN]
		public CrossReference getUseViewpointViewpointCrossReference_8_1_0() { return cUseViewpointViewpointCrossReference_8_1_0; }

		//FQN
		public RuleCall getUseViewpointViewpointFQNParserRuleCall_8_1_0_1() { return cUseViewpointViewpointFQNParserRuleCall_8_1_0_1; }

		//(',' useViewpoint+=[Viewpoint|FQN])*
		public Group getGroup_8_2() { return cGroup_8_2; }

		//','
		public Keyword getCommaKeyword_8_2_0() { return cCommaKeyword_8_2_0; }

		//useViewpoint+=[Viewpoint|FQN]
		public Assignment getUseViewpointAssignment_8_2_1() { return cUseViewpointAssignment_8_2_1; }

		//[Viewpoint|FQN]
		public CrossReference getUseViewpointViewpointCrossReference_8_2_1_0() { return cUseViewpointViewpointCrossReference_8_2_1_0; }

		//FQN
		public RuleCall getUseViewpointViewpointFQNParserRuleCall_8_2_1_0_1() { return cUseViewpointViewpointFQNParserRuleCall_8_2_1_0_1; }

		//('uses model' useAnyEMFResource+=EString (',' useAnyEMFResource+=EString)*)?
		public Group getGroup_9() { return cGroup_9; }

		//'uses model'
		public Keyword getUsesModelKeyword_9_0() { return cUsesModelKeyword_9_0; }

		//useAnyEMFResource+=EString
		public Assignment getUseAnyEMFResourceAssignment_9_1() { return cUseAnyEMFResourceAssignment_9_1; }

		//EString
		public RuleCall getUseAnyEMFResourceEStringParserRuleCall_9_1_0() { return cUseAnyEMFResourceEStringParserRuleCall_9_1_0; }

		//(',' useAnyEMFResource+=EString)*
		public Group getGroup_9_2() { return cGroup_9_2; }

		//','
		public Keyword getCommaKeyword_9_2_0() { return cCommaKeyword_9_2_0; }

		//useAnyEMFResource+=EString
		public Assignment getUseAnyEMFResourceAssignment_9_2_1() { return cUseAnyEMFResourceAssignment_9_2_1; }

		//EString
		public RuleCall getUseAnyEMFResourceEStringParserRuleCall_9_2_1_0() { return cUseAnyEMFResourceEStringParserRuleCall_9_2_1_0; }

		//('uses diagram' useDiagramResource+=EString (',' useDiagramResource+=EString)*)?
		public Group getGroup_10() { return cGroup_10; }

		//'uses diagram'
		public Keyword getUsesDiagramKeyword_10_0() { return cUsesDiagramKeyword_10_0; }

		//useDiagramResource+=EString
		public Assignment getUseDiagramResourceAssignment_10_1() { return cUseDiagramResourceAssignment_10_1; }

		//EString
		public RuleCall getUseDiagramResourceEStringParserRuleCall_10_1_0() { return cUseDiagramResourceEStringParserRuleCall_10_1_0; }

		//(',' useDiagramResource+=EString)*
		public Group getGroup_10_2() { return cGroup_10_2; }

		//','
		public Keyword getCommaKeyword_10_2_0() { return cCommaKeyword_10_2_0; }

		//useDiagramResource+=EString
		public Assignment getUseDiagramResourceAssignment_10_2_1() { return cUseDiagramResourceAssignment_10_2_1; }

		//EString
		public RuleCall getUseDiagramResourceEStringParserRuleCall_10_2_1_0() { return cUseDiagramResourceEStringParserRuleCall_10_2_1_0; }

		//('uses workspace' useWorkspaceResource+=EString (',' useWorkspaceResource+=EString)*)?
		public Group getGroup_11() { return cGroup_11; }

		//'uses workspace'
		public Keyword getUsesWorkspaceKeyword_11_0() { return cUsesWorkspaceKeyword_11_0; }

		//useWorkspaceResource+=EString
		public Assignment getUseWorkspaceResourceAssignment_11_1() { return cUseWorkspaceResourceAssignment_11_1; }

		//EString
		public RuleCall getUseWorkspaceResourceEStringParserRuleCall_11_1_0() { return cUseWorkspaceResourceEStringParserRuleCall_11_1_0; }

		//(',' useWorkspaceResource+=EString)*
		public Group getGroup_11_2() { return cGroup_11_2; }

		//','
		public Keyword getCommaKeyword_11_2_0() { return cCommaKeyword_11_2_0; }

		//useWorkspaceResource+=EString
		public Assignment getUseWorkspaceResourceAssignment_11_2_1() { return cUseWorkspaceResourceAssignment_11_2_1; }

		//EString
		public RuleCall getUseWorkspaceResourceEStringParserRuleCall_11_2_1_0() { return cUseWorkspaceResourceEStringParserRuleCall_11_2_1_0; }

		//('uses filesystem' useFSResource+=EString (',' useFSResource+=EString)*)?
		public Group getGroup_12() { return cGroup_12; }

		//'uses filesystem'
		public Keyword getUsesFilesystemKeyword_12_0() { return cUsesFilesystemKeyword_12_0; }

		//useFSResource+=EString
		public Assignment getUseFSResourceAssignment_12_1() { return cUseFSResourceAssignment_12_1; }

		//EString
		public RuleCall getUseFSResourceEStringParserRuleCall_12_1_0() { return cUseFSResourceEStringParserRuleCall_12_1_0; }

		//(',' useFSResource+=EString)*
		public Group getGroup_12_2() { return cGroup_12_2; }

		//','
		public Keyword getCommaKeyword_12_2_0() { return cCommaKeyword_12_2_0; }

		//useFSResource+=EString
		public Assignment getUseFSResourceAssignment_12_2_1() { return cUseFSResourceAssignment_12_2_1; }

		//EString
		public RuleCall getUseFSResourceEStringParserRuleCall_12_2_1_0() { return cUseFSResourceEStringParserRuleCall_12_2_1_0; }

		//('Data' VP_Data=[vpdesc::Data|FQN])?
		public Group getGroup_13() { return cGroup_13; }

		//'Data'
		public Keyword getDataKeyword_13_0() { return cDataKeyword_13_0; }

		//VP_Data=[vpdesc::Data|FQN]
		public Assignment getVP_DataAssignment_13_1() { return cVP_DataAssignment_13_1; }

		//[vpdesc::Data|FQN]
		public CrossReference getVP_DataDataCrossReference_13_1_0() { return cVP_DataDataCrossReference_13_1_0; }

		//FQN
		public RuleCall getVP_DataDataFQNParserRuleCall_13_1_0_1() { return cVP_DataDataFQNParserRuleCall_13_1_0_1; }

		//(type+='UI' VP_Aspects+=[vpui::UIDescription|FQN])?
		public Group getGroup_14() { return cGroup_14; }

		//type+='UI'
		public Assignment getTypeAssignment_14_0() { return cTypeAssignment_14_0; }

		//'UI'
		public Keyword getTypeUIKeyword_14_0_0() { return cTypeUIKeyword_14_0_0; }

		//VP_Aspects+=[vpui::UIDescription|FQN]
		public Assignment getVP_AspectsAssignment_14_1() { return cVP_AspectsAssignment_14_1; }

		//[vpui::UIDescription|FQN]
		public CrossReference getVP_AspectsUIDescriptionCrossReference_14_1_0() { return cVP_AspectsUIDescriptionCrossReference_14_1_0; }

		//FQN
		public RuleCall getVP_AspectsUIDescriptionFQNParserRuleCall_14_1_0_1() { return cVP_AspectsUIDescriptionFQNParserRuleCall_14_1_0_1; }

		//(type+='Diagrams' VP_Aspects+=[vpdiagram::DiagramSet|FQN])?
		public Group getGroup_15() { return cGroup_15; }

		//type+='Diagrams'
		public Assignment getTypeAssignment_15_0() { return cTypeAssignment_15_0; }

		//'Diagrams'
		public Keyword getTypeDiagramsKeyword_15_0_0() { return cTypeDiagramsKeyword_15_0_0; }

		//VP_Aspects+=[vpdiagram::DiagramSet|FQN]
		public Assignment getVP_AspectsAssignment_15_1() { return cVP_AspectsAssignment_15_1; }

		//[vpdiagram::DiagramSet|FQN]
		public CrossReference getVP_AspectsDiagramSetCrossReference_15_1_0() { return cVP_AspectsDiagramSetCrossReference_15_1_0; }

		//FQN
		public RuleCall getVP_AspectsDiagramSetFQNParserRuleCall_15_1_0_1() { return cVP_AspectsDiagramSetFQNParserRuleCall_15_1_0_1; }

		//(type+='Activity-Explorer' VP_Aspects+=[activtyExplorer::ViewpointActivityExplorer|FQN])?
		public Group getGroup_16() { return cGroup_16; }

		//type+='Activity-Explorer'
		public Assignment getTypeAssignment_16_0() { return cTypeAssignment_16_0; }

		//'Activity-Explorer'
		public Keyword getTypeActivityExplorerKeyword_16_0_0() { return cTypeActivityExplorerKeyword_16_0_0; }

		//VP_Aspects+=[activtyExplorer::ViewpointActivityExplorer|FQN]
		public Assignment getVP_AspectsAssignment_16_1() { return cVP_AspectsAssignment_16_1; }

		//[activtyExplorer::ViewpointActivityExplorer|FQN]
		public CrossReference getVP_AspectsViewpointActivityExplorerCrossReference_16_1_0() { return cVP_AspectsViewpointActivityExplorerCrossReference_16_1_0; }

		//FQN
		public RuleCall getVP_AspectsViewpointActivityExplorerFQNParserRuleCall_16_1_0_1() { return cVP_AspectsViewpointActivityExplorerFQNParserRuleCall_16_1_0_1; }

		//(type+='Services' VP_Aspects+=[vpservices::ServiceSet|FQN])?
		public Group getGroup_17() { return cGroup_17; }

		//type+='Services'
		public Assignment getTypeAssignment_17_0() { return cTypeAssignment_17_0; }

		//'Services'
		public Keyword getTypeServicesKeyword_17_0_0() { return cTypeServicesKeyword_17_0_0; }

		//VP_Aspects+=[vpservices::ServiceSet|FQN]
		public Assignment getVP_AspectsAssignment_17_1() { return cVP_AspectsAssignment_17_1; }

		//[vpservices::ServiceSet|FQN]
		public CrossReference getVP_AspectsServiceSetCrossReference_17_1_0() { return cVP_AspectsServiceSetCrossReference_17_1_0; }

		//FQN
		public RuleCall getVP_AspectsServiceSetFQNParserRuleCall_17_1_0_1() { return cVP_AspectsServiceSetFQNParserRuleCall_17_1_0_1; }

		//(type+='Build' VP_Aspects+=[vpbuild::Build|FQN])?
		public Group getGroup_18() { return cGroup_18; }

		//type+='Build'
		public Assignment getTypeAssignment_18_0() { return cTypeAssignment_18_0; }

		//'Build'
		public Keyword getTypeBuildKeyword_18_0_0() { return cTypeBuildKeyword_18_0_0; }

		//VP_Aspects+=[vpbuild::Build|FQN]
		public Assignment getVP_AspectsAssignment_18_1() { return cVP_AspectsAssignment_18_1; }

		//[vpbuild::Build|FQN]
		public CrossReference getVP_AspectsBuildCrossReference_18_1_0() { return cVP_AspectsBuildCrossReference_18_1_0; }

		//FQN
		public RuleCall getVP_AspectsBuildFQNParserRuleCall_18_1_0_1() { return cVP_AspectsBuildFQNParserRuleCall_18_1_0_1; }

		//(type+='Configuration' VP_Aspects+=[vpconf::Configuration|FQN])?
		public Group getGroup_19() { return cGroup_19; }

		//type+='Configuration'
		public Assignment getTypeAssignment_19_0() { return cTypeAssignment_19_0; }

		//'Configuration'
		public Keyword getTypeConfigurationKeyword_19_0_0() { return cTypeConfigurationKeyword_19_0_0; }

		//VP_Aspects+=[vpconf::Configuration|FQN]
		public Assignment getVP_AspectsAssignment_19_1() { return cVP_AspectsAssignment_19_1; }

		//[vpconf::Configuration|FQN]
		public CrossReference getVP_AspectsConfigurationCrossReference_19_1_0() { return cVP_AspectsConfigurationCrossReference_19_1_0; }

		//FQN
		public RuleCall getVP_AspectsConfigurationFQNParserRuleCall_19_1_0_1() { return cVP_AspectsConfigurationFQNParserRuleCall_19_1_0_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_20() { return cRightCurlyBracketKeyword_20; }
	}
	
	
	private final ViewpointElements pViewpoint;
	
	private final Grammar grammar;

	private final CommonGrammarAccess gaCommon;

	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public VpspecGrammarAccess(GrammarProvider grammarProvider,
		CommonGrammarAccess gaCommon,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaCommon = gaCommon;
		this.gaTerminals = gaTerminals;
		this.pViewpoint = new ViewpointElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Vpspec".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	

	public CommonGrammarAccess getCommonGrammarAccess() {
		return gaCommon;
	}

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	/// ********************************************************************
	// * 							vpspec
	// * 
	// ******************************************************************** /
	//Viewpoint:
	//	{Viewpoint} 'Viewpoint' shortName=ID? '{' ('name:' name=STRING) ('description:' description=EString)? ('extends'
	//	parents+=[Viewpoint|FQN] (',' parents+=[Viewpoint|FQN])*)? ('aggregates' dependencies+=[Viewpoint|FQN] (','
	//	dependencies+=[Viewpoint|FQN])*)? ('uses viewpoint' useViewpoint+=[Viewpoint|FQN] (','
	//	useViewpoint+=[Viewpoint|FQN])*)? ('uses model' useAnyEMFResource+=EString (',' useAnyEMFResource+=EString)*)?
	//	('uses diagram' useDiagramResource+=EString (',' useDiagramResource+=EString)*)? ('uses workspace'
	//	useWorkspaceResource+=EString (',' useWorkspaceResource+=EString)*)? ('uses filesystem' useFSResource+=EString (','
	//	useFSResource+=EString)*)? ('Data' VP_Data=[vpdesc::Data|FQN])? (type+='UI' VP_Aspects+=[vpui::UIDescription|FQN])?
	//	(type+='Diagrams' VP_Aspects+=[vpdiagram::DiagramSet|FQN])? (type+='Activity-Explorer'
	//	VP_Aspects+=[activtyExplorer::ViewpointActivityExplorer|FQN])? (type+='Services'
	//	VP_Aspects+=[vpservices::ServiceSet|FQN])? (type+='Build' VP_Aspects+=[vpbuild::Build|FQN])? (type+='Configuration'
	//	VP_Aspects+=[vpconf::Configuration|FQN])? '}';
	public ViewpointElements getViewpointAccess() {
		return pViewpoint;
	}
	
	public ParserRule getViewpointRule() {
		return getViewpointAccess().getRule();
	}

	//EString:
	//	STRING | ID;
	public CommonGrammarAccess.EStringElements getEStringAccess() {
		return gaCommon.getEStringAccess();
	}
	
	public ParserRule getEStringRule() {
		return getEStringAccess().getRule();
	}

	//FQN:
	//	ID ("." => ID)*;
	public CommonGrammarAccess.FQNElements getFQNAccess() {
		return gaCommon.getFQNAccess();
	}
	
	public ParserRule getFQNRule() {
		return getFQNAccess().getRule();
	}

	//EBoolean ecore::EBoolean:
	//	'true' | 'false'
	public CommonGrammarAccess.EBooleanElements getEBooleanAccess() {
		return gaCommon.getEBooleanAccess();
	}
	
	public ParserRule getEBooleanRule() {
		return getEBooleanAccess().getRule();
	}

	//EInt ecore::EInt:
	//	INT
	public CommonGrammarAccess.EIntElements getEIntAccess() {
		return gaCommon.getEIntAccess();
	}
	
	public ParserRule getEIntRule() {
		return getEIntAccess().getRule();
	}

	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"' | "'" ('\\' . | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	'/ *'->'* /';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
