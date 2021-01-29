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
grammar InternalVpconf;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.services.VpconfGrammarAccess;

}

@parser::members {

 	private VpconfGrammarAccess grammarAccess;
 	
    public InternalVpconfParser(TokenStream input, VpconfGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Configuration";	
   	}
   	
   	@Override
   	protected VpconfGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleConfiguration
entryRuleConfiguration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getConfigurationRule()); }
	 iv_ruleConfiguration=ruleConfiguration 
	 { $current=$iv_ruleConfiguration.current; } 
	 EOF 
;

// Rule Configuration
ruleConfiguration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getConfigurationAccess().getConfigurationAction_0(),
            $current);
    }
)	otherlv_1='Configuration' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getConfigurationAccess().getConfigurationKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getConfigurationAccess().getNameFQNParserRuleCall_2_0()); 
	    }
		lv_name_2_0=ruleFQN		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConfigurationRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.FQN");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='{' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getConfigurationAccess().getLeftCurlyBracketKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getConfigurationAccess().getVpConfigurationElementsConfigurationElementParserRuleCall_4_0()); 
	    }
		lv_vpConfigurationElements_4_0=ruleConfigurationElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConfigurationRule());
	        }
       		add(
       			$current, 
       			"vpConfigurationElements",
        		lv_vpConfigurationElements_4_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Vpconf.ConfigurationElement");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_5='}' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getConfigurationAccess().getRightCurlyBracketKeyword_5());
    }
)
;





// Entry rule entryRuleConfigurationElement
entryRuleConfigurationElement returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getConfigurationElementRule()); }
	 iv_ruleConfigurationElement=ruleConfigurationElement 
	 { $current=$iv_ruleConfigurationElement.current; } 
	 EOF 
;

// Rule ConfigurationElement
ruleConfigurationElement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getConfigurationElementAccess().getTargetApplicationParserRuleCall_0()); 
    }
    this_TargetApplication_0=ruleTargetApplication
    { 
        $current = $this_TargetApplication_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getConfigurationElementAccess().getGenerationConfigurationParserRuleCall_1()); 
    }
    this_GenerationConfiguration_1=ruleGenerationConfiguration
    { 
        $current = $this_GenerationConfiguration_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getConfigurationElementAccess().getGenerationParserRuleCall_2()); 
    }
    this_Generation_2=ruleGeneration
    { 
        $current = $this_Generation_2.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getConfigurationElementAccess().getReleaseParserRuleCall_3()); 
    }
    this_Release_3=ruleRelease
    { 
        $current = $this_Release_3.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getConfigurationElementAccess().getViewConfigurationParserRuleCall_4()); 
    }
    this_ViewConfiguration_4=ruleViewConfiguration
    { 
        $current = $this_ViewConfiguration_4.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleTargetApplication
entryRuleTargetApplication returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTargetApplicationRule()); }
	 iv_ruleTargetApplication=ruleTargetApplication 
	 { $current=$iv_ruleTargetApplication.current; } 
	 EOF 
;

// Rule TargetApplication
ruleTargetApplication returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getTargetApplicationAccess().getTargetApplicationAction_0(),
            $current);
    }
)	otherlv_1='target' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getTargetApplicationAccess().getTargetKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTargetApplicationAccess().getTypeEStringParserRuleCall_2_0()); 
	    }
		lv_type_2_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTargetApplicationRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_2_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EString");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleGenerationConfiguration
entryRuleGenerationConfiguration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getGenerationConfigurationRule()); }
	 iv_ruleGenerationConfiguration=ruleGenerationConfiguration 
	 { $current=$iv_ruleGenerationConfiguration.current; } 
	 EOF 
;

// Rule GenerationConfiguration
ruleGenerationConfiguration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getGenerationConfigurationAccess().getGenerationConfigurationAction_0(),
            $current);
    }
)	otherlv_1='project' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getGenerationConfigurationAccess().getProjectKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGenerationConfigurationAccess().getProjectNameFQNParserRuleCall_2_0()); 
	    }
		lv_projectName_2_0=ruleFQN		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGenerationConfigurationRule());
	        }
       		set(
       			$current, 
       			"projectName",
        		lv_projectName_2_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.FQN");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3='nsuri' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getGenerationConfigurationAccess().getNsuriKeyword_3_0());
    }
(
(
		lv_nsuri_4_0=RULE_STRING
		{
			newLeafNode(lv_nsuri_4_0, grammarAccess.getGenerationConfigurationAccess().getNsuriSTRINGTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGenerationConfigurationRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"nsuri",
        		lv_nsuri_4_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
))?)
;





// Entry rule entryRuleGeneration
entryRuleGeneration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getGenerationRule()); }
	 iv_ruleGeneration=ruleGeneration 
	 { $current=$iv_ruleGeneration.current; } 
	 EOF 
;

// Rule Generation
ruleGeneration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getGenerationAccess().getGenerationAction_0(),
            $current);
    }
)	otherlv_1='generation' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getGenerationAccess().getGenerationKeyword_1());
    }
	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getGenerationAccess().getLeftCurlyBracketKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGenerationAccess().getOwnedDataGenerationConfGDataParserRuleCall_3_0()); 
	    }
		lv_ownedDataGenerationConf_3_0=ruleGData		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGenerationRule());
	        }
       		set(
       			$current, 
       			"ownedDataGenerationConf",
        		lv_ownedDataGenerationConf_3_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Vpconf.GData");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getGenerationAccess().getOwnedExtensionGenConfExtensionGeneratrionConfigurationParserRuleCall_4_0()); 
	    }
		lv_ownedExtensionGenConf_4_0=ruleExtensionGeneratrionConfiguration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGenerationRule());
	        }
       		add(
       			$current, 
       			"ownedExtensionGenConf",
        		lv_ownedExtensionGenConf_4_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Vpconf.ExtensionGeneratrionConfiguration");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_5='}' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getGenerationAccess().getRightCurlyBracketKeyword_5());
    }
)
;





// Entry rule entryRuleGData
entryRuleGData returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getGDataRule()); }
	 iv_ruleGData=ruleGData 
	 { $current=$iv_ruleGData.current; } 
	 EOF 
;

// Rule GData
ruleGData returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getGDataAccess().getGDataAction_0(),
            $current);
    }
)	otherlv_1='data' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getGDataAccess().getDataKeyword_1());
    }
	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getGDataAccess().getLeftParenthesisKeyword_2());
    }
((	otherlv_3='Model' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getGDataAccess().getModelKeyword_3_0_0());
    }
	otherlv_4=':' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getGDataAccess().getColonKeyword_3_0_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGDataAccess().getModelEBooleanParserRuleCall_3_0_2_0()); 
	    }
		lv_model_5_0=ruleEBoolean		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGDataRule());
	        }
       		set(
       			$current, 
       			"model",
        		lv_model_5_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EBoolean");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_6='Edit' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getGDataAccess().getEditKeyword_3_1_0());
    }
	otherlv_7=':' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getGDataAccess().getColonKeyword_3_1_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGDataAccess().getEditEBooleanParserRuleCall_3_1_2_0()); 
	    }
		lv_edit_8_0=ruleEBoolean		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGDataRule());
	        }
       		set(
       			$current, 
       			"edit",
        		lv_edit_8_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EBoolean");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_9='Editor' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getGDataAccess().getEditorKeyword_3_2_0());
    }
	otherlv_10=':' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getGDataAccess().getColonKeyword_3_2_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGDataAccess().getEditorEBooleanParserRuleCall_3_2_2_0()); 
	    }
		lv_editor_11_0=ruleEBoolean		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGDataRule());
	        }
       		set(
       			$current, 
       			"editor",
        		lv_editor_11_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EBoolean");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_12='Test' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getGDataAccess().getTestKeyword_3_3_0());
    }
	otherlv_13=':' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getGDataAccess().getColonKeyword_3_3_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGDataAccess().getTestEBooleanParserRuleCall_3_3_2_0()); 
	    }
		lv_test_14_0=ruleEBoolean		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGDataRule());
	        }
       		set(
       			$current, 
       			"test",
        		lv_test_14_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EBoolean");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_15='Javadoc' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getGDataAccess().getJavadocKeyword_3_4_0());
    }
	otherlv_16=':' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getGDataAccess().getColonKeyword_3_4_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGDataAccess().getJavaDocEBooleanParserRuleCall_3_4_2_0()); 
	    }
		lv_javaDoc_17_0=ruleEBoolean		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGDataRule());
	        }
       		set(
       			$current, 
       			"javaDoc",
        		lv_javaDoc_17_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EBoolean");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_18='OverwriteEcore' 
    {
    	newLeafNode(otherlv_18, grammarAccess.getGDataAccess().getOverwriteEcoreKeyword_3_5_0());
    }
	otherlv_19=':' 
    {
    	newLeafNode(otherlv_19, grammarAccess.getGDataAccess().getColonKeyword_3_5_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGDataAccess().getOverwriteEcoreEBooleanParserRuleCall_3_5_2_0()); 
	    }
		lv_overwriteEcore_20_0=ruleEBoolean		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGDataRule());
	        }
       		set(
       			$current, 
       			"overwriteEcore",
        		lv_overwriteEcore_20_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EBoolean");
	        afterParserOrEnumRuleCall();
	    }

)
))?)	otherlv_21=')' 
    {
    	newLeafNode(otherlv_21, grammarAccess.getGDataAccess().getRightParenthesisKeyword_4());
    }
)
;





// Entry rule entryRuleExtensionGeneratrionConfiguration
entryRuleExtensionGeneratrionConfiguration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getExtensionGeneratrionConfigurationRule()); }
	 iv_ruleExtensionGeneratrionConfiguration=ruleExtensionGeneratrionConfiguration 
	 { $current=$iv_ruleExtensionGeneratrionConfiguration.current; } 
	 EOF 
;

// Rule ExtensionGeneratrionConfiguration
ruleExtensionGeneratrionConfiguration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getExtensionGeneratrionConfigurationAccess().getDiagramGenerationConfigurationParserRuleCall_0()); 
    }
    this_DiagramGenerationConfiguration_0=ruleDiagramGenerationConfiguration
    { 
        $current = $this_DiagramGenerationConfiguration_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getExtensionGeneratrionConfigurationAccess().getDocumentationGenerationConfigurationParserRuleCall_1()); 
    }
    this_DocumentationGenerationConfiguration_1=ruleDocumentationGenerationConfiguration
    { 
        $current = $this_DocumentationGenerationConfiguration_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getExtensionGeneratrionConfigurationAccess().getModelsAirdGenerationConfigurationParserRuleCall_2()); 
    }
    this_ModelsAirdGenerationConfiguration_2=ruleModelsAirdGenerationConfiguration
    { 
        $current = $this_ModelsAirdGenerationConfiguration_2.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleDiagramGenerationConfiguration
entryRuleDiagramGenerationConfiguration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getDiagramGenerationConfigurationRule()); }
	 iv_ruleDiagramGenerationConfiguration=ruleDiagramGenerationConfiguration 
	 { $current=$iv_ruleDiagramGenerationConfiguration.current; } 
	 EOF 
;

// Rule DiagramGenerationConfiguration
ruleDiagramGenerationConfiguration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getDiagramGenerationConfigurationAccess().getDiagramGenerationConfigurationAction_0(),
            $current);
    }
)	otherlv_1='diagram' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getDiagramGenerationConfigurationAccess().getDiagramKeyword_1());
    }
	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getDiagramGenerationConfigurationAccess().getLeftParenthesisKeyword_2());
    }
(	otherlv_3='OverwriteOdesign' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getDiagramGenerationConfigurationAccess().getOverwriteOdesignKeyword_3_0());
    }
	otherlv_4=':' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getDiagramGenerationConfigurationAccess().getColonKeyword_3_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getDiagramGenerationConfigurationAccess().getOverwriteVSMEBooleanParserRuleCall_3_2_0()); 
	    }
		lv_overwriteVSM_5_0=ruleEBoolean		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDiagramGenerationConfigurationRule());
	        }
       		set(
       			$current, 
       			"overwriteVSM",
        		lv_overwriteVSM_5_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EBoolean");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_6=')' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getDiagramGenerationConfigurationAccess().getRightParenthesisKeyword_4());
    }
)
;





// Entry rule entryRuleDocumentationGenerationConfiguration
entryRuleDocumentationGenerationConfiguration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getDocumentationGenerationConfigurationRule()); }
	 iv_ruleDocumentationGenerationConfiguration=ruleDocumentationGenerationConfiguration 
	 { $current=$iv_ruleDocumentationGenerationConfiguration.current; } 
	 EOF 
;

// Rule DocumentationGenerationConfiguration
ruleDocumentationGenerationConfiguration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getDocumentationGenerationConfigurationAccess().getDocumentationGenerationConfigurationAction_0(),
            $current);
    }
)	otherlv_1='documentation' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getDocumentationGenerationConfigurationAccess().getDocumentationKeyword_1());
    }
	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getDocumentationGenerationConfigurationAccess().getLeftParenthesisKeyword_2());
    }
(	otherlv_3='EcoreToHtml:' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getDocumentationGenerationConfigurationAccess().getEcoreToHtmlKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getDocumentationGenerationConfigurationAccess().getEcoreToHtmlEBooleanParserRuleCall_3_1_0()); 
	    }
		lv_ecoreToHtml_4_0=ruleEBoolean		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocumentationGenerationConfigurationRule());
	        }
       		set(
       			$current, 
       			"ecoreToHtml",
        		lv_ecoreToHtml_4_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EBoolean");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_5=')' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getDocumentationGenerationConfigurationAccess().getRightParenthesisKeyword_4());
    }
)
;





// Entry rule entryRuleModelsAirdGenerationConfiguration
entryRuleModelsAirdGenerationConfiguration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getModelsAirdGenerationConfigurationRule()); }
	 iv_ruleModelsAirdGenerationConfiguration=ruleModelsAirdGenerationConfiguration 
	 { $current=$iv_ruleModelsAirdGenerationConfiguration.current; } 
	 EOF 
;

// Rule ModelsAirdGenerationConfiguration
ruleModelsAirdGenerationConfiguration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getModelsAirdGenerationConfigurationAccess().getAirdGenerationConfigurationAction_0(),
            $current);
    }
)	otherlv_1='ecore' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getModelsAirdGenerationConfigurationAccess().getEcoreKeyword_1());
    }
	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getModelsAirdGenerationConfigurationAccess().getLeftParenthesisKeyword_2());
    }
(	otherlv_3='aird' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getModelsAirdGenerationConfigurationAccess().getAirdKeyword_3_0());
    }
	otherlv_4=':' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getModelsAirdGenerationConfigurationAccess().getColonKeyword_3_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getModelsAirdGenerationConfigurationAccess().getGenRepresentationsEBooleanParserRuleCall_3_2_0()); 
	    }
		lv_genRepresentations_5_0=ruleEBoolean		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelsAirdGenerationConfigurationRule());
	        }
       		set(
       			$current, 
       			"genRepresentations",
        		lv_genRepresentations_5_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EBoolean");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_6=')' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getModelsAirdGenerationConfigurationAccess().getRightParenthesisKeyword_4());
    }
)
;





// Entry rule entryRuleRelease
entryRuleRelease returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getReleaseRule()); }
	 iv_ruleRelease=ruleRelease 
	 { $current=$iv_ruleRelease.current; } 
	 EOF 
;

// Rule Release
ruleRelease returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getReleaseAccess().getReleaseAction_0(),
            $current);
    }
)	otherlv_1='release' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getReleaseAccess().getReleaseKeyword_1());
    }
	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getReleaseAccess().getLeftCurlyBracketKeyword_2());
    }
(	otherlv_3='version' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getReleaseAccess().getVersionKeyword_3_0());
    }
	otherlv_4=':' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getReleaseAccess().getColonKeyword_3_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getReleaseAccess().getViewpointVersionVersionParserRuleCall_3_2_0()); 
	    }
		lv_viewpointVersion_5_0=ruleVersion		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReleaseRule());
	        }
       		set(
       			$current, 
       			"viewpointVersion",
        		lv_viewpointVersion_5_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Vpconf.Version");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_6='description' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getReleaseAccess().getDescriptionKeyword_4_0());
    }
	otherlv_7=':' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getReleaseAccess().getColonKeyword_4_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getReleaseAccess().getViewpointDescriptionEStringParserRuleCall_4_2_0()); 
	    }
		lv_viewpointDescription_8_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReleaseRule());
	        }
       		set(
       			$current, 
       			"viewpointDescription",
        		lv_viewpointDescription_8_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EString");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_9='execution' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getReleaseAccess().getExecutionKeyword_5_0());
    }
	otherlv_10='environments' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getReleaseAccess().getEnvironmentsKeyword_5_1());
    }
	otherlv_11=':' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getReleaseAccess().getColonKeyword_5_2());
    }
((
(
		lv_requiredExecutionEnvironment_12_0=RULE_STRING
		{
			newLeafNode(lv_requiredExecutionEnvironment_12_0, grammarAccess.getReleaseAccess().getRequiredExecutionEnvironmentSTRINGTerminalRuleCall_5_3_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getReleaseRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"requiredExecutionEnvironment",
        		lv_requiredExecutionEnvironment_12_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
)(	otherlv_13=',' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getReleaseAccess().getCommaKeyword_5_3_1_0());
    }
(
(
		lv_requiredExecutionEnvironment_14_0=RULE_STRING
		{
			newLeafNode(lv_requiredExecutionEnvironment_14_0, grammarAccess.getReleaseAccess().getRequiredExecutionEnvironmentSTRINGTerminalRuleCall_5_3_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getReleaseRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"requiredExecutionEnvironment",
        		lv_requiredExecutionEnvironment_14_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
))*))?	otherlv_15='}' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getReleaseAccess().getRightCurlyBracketKeyword_6());
    }
)
;





// Entry rule entryRuleViewConfiguration
entryRuleViewConfiguration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getViewConfigurationRule()); }
	 iv_ruleViewConfiguration=ruleViewConfiguration 
	 { $current=$iv_ruleViewConfiguration.current; } 
	 EOF 
;

// Rule ViewConfiguration
ruleViewConfiguration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getViewConfigurationAccess().getViewConfigurationAction_0(),
            $current);
    }
)	otherlv_1='view' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getViewConfigurationAccess().getViewKeyword_1());
    }
	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getViewConfigurationAccess().getLeftCurlyBracketKeyword_2());
    }
(	otherlv_3='visible' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getViewConfigurationAccess().getVisibleKeyword_3_0());
    }
	otherlv_4=':' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getViewConfigurationAccess().getColonKeyword_3_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getViewConfigurationAccess().getVisibleEBooleanParserRuleCall_3_2_0()); 
	    }
		lv_visible_5_0=ruleEBoolean		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getViewConfigurationRule());
	        }
       		set(
       			$current, 
       			"visible",
        		lv_visible_5_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EBoolean");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_6='activable' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getViewConfigurationAccess().getActivableKeyword_4_0());
    }
	otherlv_7=':' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getViewConfigurationAccess().getColonKeyword_4_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getViewConfigurationAccess().getActivableEBooleanParserRuleCall_4_2_0()); 
	    }
		lv_activable_8_0=ruleEBoolean		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getViewConfigurationRule());
	        }
       		set(
       			$current, 
       			"activable",
        		lv_activable_8_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EBoolean");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_9='}' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getViewConfigurationAccess().getRightCurlyBracketKeyword_5());
    }
)
;





// Entry rule entryRuleVersion
entryRuleVersion returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getVersionRule()); } 
	 iv_ruleVersion=ruleVersion 
	 { $current=$iv_ruleVersion.current.getText(); }  
	 EOF 
;

// Rule Version
ruleVersion returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_INT_0=RULE_INT    {
		$current.merge(this_INT_0);
    }

    { 
    newLeafNode(this_INT_0, grammarAccess.getVersionAccess().getINTTerminalRuleCall_0()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_0()); 
    }
(    this_INT_2=RULE_INT    {
		$current.merge(this_INT_2);
    }

    { 
    newLeafNode(this_INT_2, grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_1_0()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_1_1_0()); 
    }
    this_INT_4=RULE_INT    {
		$current.merge(this_INT_4);
    }

    { 
    newLeafNode(this_INT_4, grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_1_1_1()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1_1_1_2_0()); 
    }

    { 
        newCompositeNode(grammarAccess.getVersionAccess().getQualifierParserRuleCall_1_1_1_2_1()); 
    }
    this_Qualifier_6=ruleQualifier    {
		$current.merge(this_Qualifier_6);
    }

    { 
        afterParserOrEnumRuleCall();
    }
)?)?))?)
    ;





// Entry rule entryRuleQualifier
entryRuleQualifier returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getQualifierRule()); } 
	 iv_ruleQualifier=ruleQualifier 
	 { $current=$iv_ruleQualifier.current.getText(); }  
	 EOF 
;

// Rule Qualifier
ruleQualifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((    this_INT_0=RULE_INT    {
		$current.merge(this_INT_0);
    }

    { 
    newLeafNode(this_INT_0, grammarAccess.getQualifierAccess().getINTTerminalRuleCall_0_0()); 
    }

    |    this_ID_1=RULE_ID    {
		$current.merge(this_ID_1);
    }

    { 
    newLeafNode(this_ID_1, grammarAccess.getQualifierAccess().getIDTerminalRuleCall_0_1()); 
    }

    |
	kw='_' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQualifierAccess().get_Keyword_0_2()); 
    }
)(    this_INT_3=RULE_INT    {
		$current.merge(this_INT_3);
    }

    { 
    newLeafNode(this_INT_3, grammarAccess.getQualifierAccess().getINTTerminalRuleCall_1_0()); 
    }

    |    this_ID_4=RULE_ID    {
		$current.merge(this_ID_4);
    }

    { 
    newLeafNode(this_ID_4, grammarAccess.getQualifierAccess().getIDTerminalRuleCall_1_1()); 
    }

    |
	kw='_' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQualifierAccess().get_Keyword_1_2()); 
    }

    |
	kw='-' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQualifierAccess().getHyphenMinusKeyword_1_3()); 
    }
)*)
    ;





// Entry rule entryRuleEString
entryRuleEString returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getEStringRule()); } 
	 iv_ruleEString=ruleEString 
	 { $current=$iv_ruleEString.current.getText(); }  
	 EOF 
;

// Rule EString
ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_STRING_0=RULE_STRING    {
		$current.merge(this_STRING_0);
    }

    { 
    newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
    }

    |    this_ID_1=RULE_ID    {
		$current.merge(this_ID_1);
    }

    { 
    newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
    }
)
    ;





// Entry rule entryRuleFQN
entryRuleFQN returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getFQNRule()); } 
	 iv_ruleFQN=ruleFQN 
	 { $current=$iv_ruleFQN.current.getText(); }  
	 EOF 
;

// Rule FQN
ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
    }
(( RULE_ID)=>    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
    }
))*)
    ;





// Entry rule entryRuleEBoolean
entryRuleEBoolean returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getEBooleanRule()); } 
	 iv_ruleEBoolean=ruleEBoolean 
	 { $current=$iv_ruleEBoolean.current.getText(); }  
	 EOF 
;

// Rule EBoolean
ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='true' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 
    }

    |
	kw='false' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEBooleanAccess().getFalseKeyword_1()); 
    }
)
    ;







RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


