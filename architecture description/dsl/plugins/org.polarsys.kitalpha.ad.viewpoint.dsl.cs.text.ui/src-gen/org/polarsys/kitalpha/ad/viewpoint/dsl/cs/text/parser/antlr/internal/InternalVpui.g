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
grammar InternalVpui;

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
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.services.VpuiGrammarAccess;

}

@parser::members {

 	private VpuiGrammarAccess grammarAccess;
 	
    public InternalVpuiParser(TokenStream input, VpuiGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "UserInterface";	
   	}
   	
   	@Override
   	protected VpuiGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleUserInterface
entryRuleUserInterface returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getUserInterfaceRule()); }
	 iv_ruleUserInterface=ruleUserInterface 
	 { $current=$iv_ruleUserInterface.current; } 
	 EOF 
;

// Rule UserInterface
ruleUserInterface returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getUserInterfaceAccess().getUserInterfaceAction_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getUserInterfaceAccess().getImportsImportParserRuleCall_1_0()); 
	    }
		lv_imports_1_0=ruleImport		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUserInterfaceRule());
	        }
       		add(
       			$current, 
       			"imports",
        		lv_imports_1_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Vpui.Import");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getUserInterfaceAccess().getUiDescriptionAspectParserRuleCall_2_0()); 
	    }
		lv_uiDescription_2_0=ruleAspect		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUserInterfaceRule());
	        }
       		set(
       			$current, 
       			"uiDescription",
        		lv_uiDescription_2_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Vpui.Aspect");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleImport
entryRuleImport returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getImportRule()); }
	 iv_ruleImport=ruleImport 
	 { $current=$iv_ruleImport.current; } 
	 EOF 
;

// Rule Import
ruleImport returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='import' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceFQNParserRuleCall_1_0()); 
	    }
		lv_importedNamespace_1_0=ruleFQN		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getImportRule());
	        }
       		set(
       			$current, 
       			"importedNamespace",
        		lv_importedNamespace_1_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.FQN");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleAspect
entryRuleAspect returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAspectRule()); }
	 iv_ruleAspect=ruleAspect 
	 { $current=$iv_ruleAspect.current; } 
	 EOF 
;

// Rule Aspect
ruleAspect returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

    { 
        newCompositeNode(grammarAccess.getAspectAccess().getUIDescriptionParserRuleCall()); 
    }
    this_UIDescription_0=ruleUIDescription
    { 
        $current = $this_UIDescription_0.current; 
        afterParserOrEnumRuleCall();
    }

;





// Entry rule entryRuleUIDescription
entryRuleUIDescription returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getUIDescriptionRule()); }
	 iv_ruleUIDescription=ruleUIDescription 
	 { $current=$iv_ruleUIDescription.current; } 
	 EOF 
;

// Rule UIDescription
ruleUIDescription returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getUIDescriptionAccess().getUIDescriptionAction_0(),
            $current);
    }
)	otherlv_1='UIDescription' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getUIDescriptionAccess().getUIDescriptionKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getUIDescriptionAccess().getNameFQNParserRuleCall_2_0()); 
	    }
		lv_name_2_0=ruleFQN		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUIDescriptionRule());
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
    	newLeafNode(otherlv_3, grammarAccess.getUIDescriptionAccess().getLeftCurlyBracketKeyword_3());
    }
((
(
ruleUI
)
)=>
(
		{ 
	        newCompositeNode(grammarAccess.getUIDescriptionAccess().getUIsUIParserRuleCall_4_0()); 
	    }
		lv_UIs_4_0=ruleUI		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUIDescriptionRule());
	        }
       		add(
       			$current, 
       			"UIs",
        		lv_UIs_4_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Vpui.UI");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_5='}' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getUIDescriptionAccess().getRightCurlyBracketKeyword_5());
    }
)
;







// Entry rule entryRuleUI
entryRuleUI returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getUIRule()); }
	 iv_ruleUI=ruleUI 
	 { $current=$iv_ruleUI.current; } 
	 EOF 
;

// Rule UI
ruleUI returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getUIAccess().getUIAction_0(),
            $current);
    }
)	otherlv_1='UI' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getUIAccess().getUIKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getUIAccess().getNameEStringParserRuleCall_2_0()); 
	    }
		lv_name_2_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUIRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EString");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getUIAccess().getUI_DataSourceDataSourceParserRuleCall_3_0()); 
	    }
		lv_UI_DataSource_3_0=ruleDataSource		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUIRule());
	        }
       		set(
       			$current, 
       			"UI_DataSource",
        		lv_UI_DataSource_3_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Vpui.DataSource");
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_4='{' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getUIAccess().getLeftCurlyBracketKeyword_4());
    }
(	otherlv_5='label:' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getUIAccess().getLabelKeyword_5_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getUIAccess().getLabelEStringParserRuleCall_5_1_0()); 
	    }
		lv_label_6_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUIRule());
	        }
       		set(
       			$current, 
       			"label",
        		lv_label_6_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EString");
	        afterParserOrEnumRuleCall();
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getUIAccess().getUI_ContainersUIContainerParserRuleCall_6_0()); 
	    }
		lv_UI_Containers_7_0=ruleUIContainer		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUIRule());
	        }
       		add(
       			$current, 
       			"UI_Containers",
        		lv_UI_Containers_7_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Vpui.UIContainer");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_8='}' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getUIAccess().getRightCurlyBracketKeyword_7());
    }
)
;





// Entry rule entryRuleUIContainer
entryRuleUIContainer returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getUIContainerRule()); }
	 iv_ruleUIContainer=ruleUIContainer 
	 { $current=$iv_ruleUIContainer.current; } 
	 EOF 
;

// Rule UIContainer
ruleUIContainer returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getUIContainerAccess().getUIContainerAction_0(),
            $current);
    }
)	otherlv_1='Container' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getUIContainerAccess().getContainerKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getUIContainerAccess().getNameEStringParserRuleCall_2_0()); 
	    }
		lv_name_2_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUIContainerRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EString");
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_3='{' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getUIContainerAccess().getLeftCurlyBracketKeyword_3());
    }
(	otherlv_4='label:' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getUIContainerAccess().getLabelKeyword_4_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getUIContainerAccess().getLabelEStringParserRuleCall_4_1_0()); 
	    }
		lv_label_5_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUIContainerRule());
	        }
       		set(
       			$current, 
       			"label",
        		lv_label_5_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EString");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_6='description:' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getUIContainerAccess().getDescriptionKeyword_5_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getUIContainerAccess().getDescriptionEStringParserRuleCall_5_1_0()); 
	    }
		lv_description_7_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUIContainerRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_7_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EString");
	        afterParserOrEnumRuleCall();
	    }

)
))?((
(
		{ 
	        newCompositeNode(grammarAccess.getUIContainerAccess().getUI_fieldsUIFieldParserRuleCall_6_0_0()); 
	    }
		lv_UI_fields_8_0=ruleUIField		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUIContainerRule());
	        }
       		add(
       			$current, 
       			"UI_fields",
        		lv_UI_fields_8_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Vpui.UIField");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getUIContainerAccess().getUI_fieldsUIFieldParserRuleCall_6_1_0()); 
	    }
		lv_UI_fields_9_0=ruleUIField		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUIContainerRule());
	        }
       		add(
       			$current, 
       			"UI_fields",
        		lv_UI_fields_9_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Vpui.UIField");
	        afterParserOrEnumRuleCall();
	    }

)
)*)?((
(
		{ 
	        newCompositeNode(grammarAccess.getUIContainerAccess().getSubContainersUIContainerParserRuleCall_7_0_0()); 
	    }
		lv_subContainers_10_0=ruleUIContainer		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUIContainerRule());
	        }
       		add(
       			$current, 
       			"subContainers",
        		lv_subContainers_10_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Vpui.UIContainer");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getUIContainerAccess().getSubContainersUIContainerParserRuleCall_7_1_0()); 
	    }
		lv_subContainers_11_0=ruleUIContainer		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUIContainerRule());
	        }
       		add(
       			$current, 
       			"subContainers",
        		lv_subContainers_11_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Vpui.UIContainer");
	        afterParserOrEnumRuleCall();
	    }

)
)*)?	otherlv_12='}' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getUIContainerAccess().getRightCurlyBracketKeyword_8());
    }
)
;





// Entry rule entryRuleDataSource
entryRuleDataSource returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getDataSourceRule()); }
	 iv_ruleDataSource=ruleDataSource 
	 { $current=$iv_ruleDataSource.current; } 
	 EOF 
;

// Rule DataSource
ruleDataSource returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

    { 
        newCompositeNode(grammarAccess.getDataSourceAccess().getLocalClassParserRuleCall()); 
    }
    this_LocalClass_0=ruleLocalClass
    { 
        $current = $this_LocalClass_0.current; 
        afterParserOrEnumRuleCall();
    }

;





// Entry rule entryRuleLocalClass
entryRuleLocalClass returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getLocalClassRule()); }
	 iv_ruleLocalClass=ruleLocalClass 
	 { $current=$iv_ruleLocalClass.current; } 
	 EOF 
;

// Rule LocalClass
ruleLocalClass returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getLocalClassAccess().getLocalClassAction_0(),
            $current);
    }
)	otherlv_1='for' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getLocalClassAccess().getForKeyword_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getLocalClassRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getLocalClassAccess().getUI_For_LocalClassClassCrossReference_2_0()); 
	    }
		ruleFQN		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleUIField
entryRuleUIField returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getUIFieldRule()); }
	 iv_ruleUIField=ruleUIField 
	 { $current=$iv_ruleUIField.current; } 
	 EOF 
;

// Rule UIField
ruleUIField returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getUIFieldAccess().getUIFieldAction_0(),
            $current);
    }
)	otherlv_1='Field' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getUIFieldAccess().getFieldKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getUIFieldAccess().getNameEStringParserRuleCall_2_0()); 
	    }
		lv_name_2_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUIFieldRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EString");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3='label:' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getUIFieldAccess().getLabelKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getUIFieldAccess().getLabelEStringParserRuleCall_3_1_0()); 
	    }
		lv_label_4_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUIFieldRule());
	        }
       		set(
       			$current, 
       			"label",
        		lv_label_4_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EString");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_5='description:' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getUIFieldAccess().getDescriptionKeyword_4_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getUIFieldAccess().getDescriptionEStringParserRuleCall_4_1_0()); 
	    }
		lv_description_6_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUIFieldRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_6_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Common.EString");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_7=',' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getUIFieldAccess().getCommaKeyword_4_2());
    }
)?(	otherlv_8='type' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getUIFieldAccess().getTypeKeyword_5_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getUIFieldAccess().getTypeUI_Field_TypeEnumRuleCall_5_1_0()); 
	    }
		lv_type_9_0=ruleUI_Field_Type		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUIFieldRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_9_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Vpui.UI_Field_Type");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_10=',' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getUIFieldAccess().getCommaKeyword_6());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getUIFieldAccess().getMappingFieldMappingParserRuleCall_7_0()); 
	    }
		lv_Mapping_11_0=ruleFieldMapping		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUIFieldRule());
	        }
       		set(
       			$current, 
       			"Mapping",
        		lv_Mapping_11_0, 
        		"org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.Vpui.FieldMapping");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleFieldMapping
entryRuleFieldMapping returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFieldMappingRule()); }
	 iv_ruleFieldMapping=ruleFieldMapping 
	 { $current=$iv_ruleFieldMapping.current; } 
	 EOF 
;

// Rule FieldMapping
ruleFieldMapping returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getFieldMappingAccess().getFieldMappingAction_0(),
            $current);
    }
)	otherlv_1='mapped-to' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getFieldMappingAccess().getMappedToKeyword_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getFieldMappingRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getFieldMappingAccess().getUI_Field_Mapped_ToAbstractFeatureCrossReference_2_0()); 
	    }
		ruleFQN		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)?)
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









// Rule UI_Field_Type
ruleUI_Field_Type returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='text' 
	{
        $current = grammarAccess.getUI_Field_TypeAccess().getTextEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getUI_Field_TypeAccess().getTextEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='textarea' 
	{
        $current = grammarAccess.getUI_Field_TypeAccess().getTextareaEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getUI_Field_TypeAccess().getTextareaEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='checkbox' 
	{
        $current = grammarAccess.getUI_Field_TypeAccess().getCheckboxEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getUI_Field_TypeAccess().getCheckboxEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='radiobox' 
	{
        $current = grammarAccess.getUI_Field_TypeAccess().getRadioboxEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getUI_Field_TypeAccess().getRadioboxEnumLiteralDeclaration_3()); 
    }
)
    |(	enumLiteral_4='simpleChoiceList' 
	{
        $current = grammarAccess.getUI_Field_TypeAccess().getSimpleChoiceListEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_4, grammarAccess.getUI_Field_TypeAccess().getSimpleChoiceListEnumLiteralDeclaration_4()); 
    }
)
    |(	enumLiteral_5='multipleChoiceList' 
	{
        $current = grammarAccess.getUI_Field_TypeAccess().getMultipleChoiceListEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_5, grammarAccess.getUI_Field_TypeAccess().getMultipleChoiceListEnumLiteralDeclaration_5()); 
    }
)
    |(	enumLiteral_6='richtext' 
	{
        $current = grammarAccess.getUI_Field_TypeAccess().getRichtextEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_6, grammarAccess.getUI_Field_TypeAccess().getRichtextEnumLiteralDeclaration_6()); 
    }
));



RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


