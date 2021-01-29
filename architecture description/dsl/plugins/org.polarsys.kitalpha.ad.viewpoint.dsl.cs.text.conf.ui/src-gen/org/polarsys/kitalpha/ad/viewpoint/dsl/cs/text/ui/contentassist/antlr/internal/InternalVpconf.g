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
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;
	
}

@lexer::header {
package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.services.VpconfGrammarAccess;

}

@parser::members {
 
 	private VpconfGrammarAccess grammarAccess;
 	
    public void setGrammarAccess(VpconfGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }
    
    @Override
    protected String getValueForTokenName(String tokenName) {
    	return tokenName;
    }

}




// Entry rule entryRuleConfiguration
entryRuleConfiguration 
:
{ before(grammarAccess.getConfigurationRule()); }
	 ruleConfiguration
{ after(grammarAccess.getConfigurationRule()); } 
	 EOF 
;

// Rule Configuration
ruleConfiguration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getConfigurationAccess().getGroup()); }
(rule__Configuration__Group__0)
{ after(grammarAccess.getConfigurationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleConfigurationElement
entryRuleConfigurationElement 
:
{ before(grammarAccess.getConfigurationElementRule()); }
	 ruleConfigurationElement
{ after(grammarAccess.getConfigurationElementRule()); } 
	 EOF 
;

// Rule ConfigurationElement
ruleConfigurationElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getConfigurationElementAccess().getAlternatives()); }
(rule__ConfigurationElement__Alternatives)
{ after(grammarAccess.getConfigurationElementAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTargetApplication
entryRuleTargetApplication 
:
{ before(grammarAccess.getTargetApplicationRule()); }
	 ruleTargetApplication
{ after(grammarAccess.getTargetApplicationRule()); } 
	 EOF 
;

// Rule TargetApplication
ruleTargetApplication
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTargetApplicationAccess().getGroup()); }
(rule__TargetApplication__Group__0)
{ after(grammarAccess.getTargetApplicationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleGenerationConfiguration
entryRuleGenerationConfiguration 
:
{ before(grammarAccess.getGenerationConfigurationRule()); }
	 ruleGenerationConfiguration
{ after(grammarAccess.getGenerationConfigurationRule()); } 
	 EOF 
;

// Rule GenerationConfiguration
ruleGenerationConfiguration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getGenerationConfigurationAccess().getGroup()); }
(rule__GenerationConfiguration__Group__0)
{ after(grammarAccess.getGenerationConfigurationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleGeneration
entryRuleGeneration 
:
{ before(grammarAccess.getGenerationRule()); }
	 ruleGeneration
{ after(grammarAccess.getGenerationRule()); } 
	 EOF 
;

// Rule Generation
ruleGeneration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getGenerationAccess().getGroup()); }
(rule__Generation__Group__0)
{ after(grammarAccess.getGenerationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleGData
entryRuleGData 
:
{ before(grammarAccess.getGDataRule()); }
	 ruleGData
{ after(grammarAccess.getGDataRule()); } 
	 EOF 
;

// Rule GData
ruleGData
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getGDataAccess().getGroup()); }
(rule__GData__Group__0)
{ after(grammarAccess.getGDataAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleExtensionGeneratrionConfiguration
entryRuleExtensionGeneratrionConfiguration 
:
{ before(grammarAccess.getExtensionGeneratrionConfigurationRule()); }
	 ruleExtensionGeneratrionConfiguration
{ after(grammarAccess.getExtensionGeneratrionConfigurationRule()); } 
	 EOF 
;

// Rule ExtensionGeneratrionConfiguration
ruleExtensionGeneratrionConfiguration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getExtensionGeneratrionConfigurationAccess().getAlternatives()); }
(rule__ExtensionGeneratrionConfiguration__Alternatives)
{ after(grammarAccess.getExtensionGeneratrionConfigurationAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDiagramGenerationConfiguration
entryRuleDiagramGenerationConfiguration 
:
{ before(grammarAccess.getDiagramGenerationConfigurationRule()); }
	 ruleDiagramGenerationConfiguration
{ after(grammarAccess.getDiagramGenerationConfigurationRule()); } 
	 EOF 
;

// Rule DiagramGenerationConfiguration
ruleDiagramGenerationConfiguration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getDiagramGenerationConfigurationAccess().getGroup()); }
(rule__DiagramGenerationConfiguration__Group__0)
{ after(grammarAccess.getDiagramGenerationConfigurationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDocumentationGenerationConfiguration
entryRuleDocumentationGenerationConfiguration 
:
{ before(grammarAccess.getDocumentationGenerationConfigurationRule()); }
	 ruleDocumentationGenerationConfiguration
{ after(grammarAccess.getDocumentationGenerationConfigurationRule()); } 
	 EOF 
;

// Rule DocumentationGenerationConfiguration
ruleDocumentationGenerationConfiguration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getDocumentationGenerationConfigurationAccess().getGroup()); }
(rule__DocumentationGenerationConfiguration__Group__0)
{ after(grammarAccess.getDocumentationGenerationConfigurationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleModelsAirdGenerationConfiguration
entryRuleModelsAirdGenerationConfiguration 
:
{ before(grammarAccess.getModelsAirdGenerationConfigurationRule()); }
	 ruleModelsAirdGenerationConfiguration
{ after(grammarAccess.getModelsAirdGenerationConfigurationRule()); } 
	 EOF 
;

// Rule ModelsAirdGenerationConfiguration
ruleModelsAirdGenerationConfiguration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getModelsAirdGenerationConfigurationAccess().getGroup()); }
(rule__ModelsAirdGenerationConfiguration__Group__0)
{ after(grammarAccess.getModelsAirdGenerationConfigurationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRelease
entryRuleRelease 
:
{ before(grammarAccess.getReleaseRule()); }
	 ruleRelease
{ after(grammarAccess.getReleaseRule()); } 
	 EOF 
;

// Rule Release
ruleRelease
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getReleaseAccess().getGroup()); }
(rule__Release__Group__0)
{ after(grammarAccess.getReleaseAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleViewConfiguration
entryRuleViewConfiguration 
:
{ before(grammarAccess.getViewConfigurationRule()); }
	 ruleViewConfiguration
{ after(grammarAccess.getViewConfigurationRule()); } 
	 EOF 
;

// Rule ViewConfiguration
ruleViewConfiguration
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getViewConfigurationAccess().getGroup()); }
(rule__ViewConfiguration__Group__0)
{ after(grammarAccess.getViewConfigurationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleVersion
entryRuleVersion 
:
{ before(grammarAccess.getVersionRule()); }
	 ruleVersion
{ after(grammarAccess.getVersionRule()); } 
	 EOF 
;

// Rule Version
ruleVersion
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getVersionAccess().getGroup()); }
(rule__Version__Group__0)
{ after(grammarAccess.getVersionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleQualifier
entryRuleQualifier 
:
{ before(grammarAccess.getQualifierRule()); }
	 ruleQualifier
{ after(grammarAccess.getQualifierRule()); } 
	 EOF 
;

// Rule Qualifier
ruleQualifier
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getQualifierAccess().getGroup()); }
(rule__Qualifier__Group__0)
{ after(grammarAccess.getQualifierAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEString
entryRuleEString 
:
{ before(grammarAccess.getEStringRule()); }
	 ruleEString
{ after(grammarAccess.getEStringRule()); } 
	 EOF 
;

// Rule EString
ruleEString
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEStringAccess().getAlternatives()); }
(rule__EString__Alternatives)
{ after(grammarAccess.getEStringAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleFQN
entryRuleFQN 
:
{ before(grammarAccess.getFQNRule()); }
	 ruleFQN
{ after(grammarAccess.getFQNRule()); } 
	 EOF 
;

// Rule FQN
ruleFQN
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getFQNAccess().getGroup()); }
(rule__FQN__Group__0)
{ after(grammarAccess.getFQNAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEBoolean
entryRuleEBoolean 
:
{ before(grammarAccess.getEBooleanRule()); }
	 ruleEBoolean
{ after(grammarAccess.getEBooleanRule()); } 
	 EOF 
;

// Rule EBoolean
ruleEBoolean
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEBooleanAccess().getAlternatives()); }
(rule__EBoolean__Alternatives)
{ after(grammarAccess.getEBooleanAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ConfigurationElement__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConfigurationElementAccess().getTargetApplicationParserRuleCall_0()); }
	ruleTargetApplication
{ after(grammarAccess.getConfigurationElementAccess().getTargetApplicationParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getConfigurationElementAccess().getGenerationConfigurationParserRuleCall_1()); }
	ruleGenerationConfiguration
{ after(grammarAccess.getConfigurationElementAccess().getGenerationConfigurationParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getConfigurationElementAccess().getGenerationParserRuleCall_2()); }
	ruleGeneration
{ after(grammarAccess.getConfigurationElementAccess().getGenerationParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getConfigurationElementAccess().getReleaseParserRuleCall_3()); }
	ruleRelease
{ after(grammarAccess.getConfigurationElementAccess().getReleaseParserRuleCall_3()); }
)

    |(
{ before(grammarAccess.getConfigurationElementAccess().getViewConfigurationParserRuleCall_4()); }
	ruleViewConfiguration
{ after(grammarAccess.getConfigurationElementAccess().getViewConfigurationParserRuleCall_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ExtensionGeneratrionConfiguration__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExtensionGeneratrionConfigurationAccess().getDiagramGenerationConfigurationParserRuleCall_0()); }
	ruleDiagramGenerationConfiguration
{ after(grammarAccess.getExtensionGeneratrionConfigurationAccess().getDiagramGenerationConfigurationParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getExtensionGeneratrionConfigurationAccess().getDocumentationGenerationConfigurationParserRuleCall_1()); }
	ruleDocumentationGenerationConfiguration
{ after(grammarAccess.getExtensionGeneratrionConfigurationAccess().getDocumentationGenerationConfigurationParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getExtensionGeneratrionConfigurationAccess().getModelsAirdGenerationConfigurationParserRuleCall_2()); }
	ruleModelsAirdGenerationConfiguration
{ after(grammarAccess.getExtensionGeneratrionConfigurationAccess().getModelsAirdGenerationConfigurationParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Qualifier__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifierAccess().getINTTerminalRuleCall_0_0()); }
	RULE_INT
{ after(grammarAccess.getQualifierAccess().getINTTerminalRuleCall_0_0()); }
)

    |(
{ before(grammarAccess.getQualifierAccess().getIDTerminalRuleCall_0_1()); }
	RULE_ID
{ after(grammarAccess.getQualifierAccess().getIDTerminalRuleCall_0_1()); }
)

    |(
{ before(grammarAccess.getQualifierAccess().get_Keyword_0_2()); }

	'_' 

{ after(grammarAccess.getQualifierAccess().get_Keyword_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Qualifier__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifierAccess().getINTTerminalRuleCall_1_0()); }
	RULE_INT
{ after(grammarAccess.getQualifierAccess().getINTTerminalRuleCall_1_0()); }
)

    |(
{ before(grammarAccess.getQualifierAccess().getIDTerminalRuleCall_1_1()); }
	RULE_ID
{ after(grammarAccess.getQualifierAccess().getIDTerminalRuleCall_1_1()); }
)

    |(
{ before(grammarAccess.getQualifierAccess().get_Keyword_1_2()); }

	'_' 

{ after(grammarAccess.getQualifierAccess().get_Keyword_1_2()); }
)

    |(
{ before(grammarAccess.getQualifierAccess().getHyphenMinusKeyword_1_3()); }

	'-' 

{ after(grammarAccess.getQualifierAccess().getHyphenMinusKeyword_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EString__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); }
	RULE_STRING
{ after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); }
)

    |(
{ before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); }
	RULE_ID
{ after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EBoolean__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEBooleanAccess().getTrueKeyword_0()); }

	'true' 

{ after(grammarAccess.getEBooleanAccess().getTrueKeyword_0()); }
)

    |(
{ before(grammarAccess.getEBooleanAccess().getFalseKeyword_1()); }

	'false' 

{ after(grammarAccess.getEBooleanAccess().getFalseKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__Configuration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Configuration__Group__0__Impl
	rule__Configuration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Configuration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConfigurationAccess().getConfigurationAction_0()); }
(

)
{ after(grammarAccess.getConfigurationAccess().getConfigurationAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Configuration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Configuration__Group__1__Impl
	rule__Configuration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Configuration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConfigurationAccess().getConfigurationKeyword_1()); }

	'Configuration' 

{ after(grammarAccess.getConfigurationAccess().getConfigurationKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Configuration__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Configuration__Group__2__Impl
	rule__Configuration__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Configuration__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConfigurationAccess().getNameAssignment_2()); }
(rule__Configuration__NameAssignment_2)
{ after(grammarAccess.getConfigurationAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Configuration__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Configuration__Group__3__Impl
	rule__Configuration__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Configuration__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConfigurationAccess().getLeftCurlyBracketKeyword_3()); }

	'{' 

{ after(grammarAccess.getConfigurationAccess().getLeftCurlyBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Configuration__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Configuration__Group__4__Impl
	rule__Configuration__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Configuration__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConfigurationAccess().getVpConfigurationElementsAssignment_4()); }
(rule__Configuration__VpConfigurationElementsAssignment_4)*
{ after(grammarAccess.getConfigurationAccess().getVpConfigurationElementsAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Configuration__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Configuration__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Configuration__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConfigurationAccess().getRightCurlyBracketKeyword_5()); }

	'}' 

{ after(grammarAccess.getConfigurationAccess().getRightCurlyBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__TargetApplication__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TargetApplication__Group__0__Impl
	rule__TargetApplication__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetApplication__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTargetApplicationAccess().getTargetApplicationAction_0()); }
(

)
{ after(grammarAccess.getTargetApplicationAccess().getTargetApplicationAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TargetApplication__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TargetApplication__Group__1__Impl
	rule__TargetApplication__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetApplication__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTargetApplicationAccess().getTargetKeyword_1()); }

	'target' 

{ after(grammarAccess.getTargetApplicationAccess().getTargetKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TargetApplication__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TargetApplication__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetApplication__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTargetApplicationAccess().getTypeAssignment_2()); }
(rule__TargetApplication__TypeAssignment_2)
{ after(grammarAccess.getTargetApplicationAccess().getTypeAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__GenerationConfiguration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GenerationConfiguration__Group__0__Impl
	rule__GenerationConfiguration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GenerationConfiguration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGenerationConfigurationAccess().getGenerationConfigurationAction_0()); }
(

)
{ after(grammarAccess.getGenerationConfigurationAccess().getGenerationConfigurationAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GenerationConfiguration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GenerationConfiguration__Group__1__Impl
	rule__GenerationConfiguration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GenerationConfiguration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGenerationConfigurationAccess().getProjectKeyword_1()); }

	'project' 

{ after(grammarAccess.getGenerationConfigurationAccess().getProjectKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GenerationConfiguration__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GenerationConfiguration__Group__2__Impl
	rule__GenerationConfiguration__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__GenerationConfiguration__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGenerationConfigurationAccess().getProjectNameAssignment_2()); }
(rule__GenerationConfiguration__ProjectNameAssignment_2)
{ after(grammarAccess.getGenerationConfigurationAccess().getProjectNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GenerationConfiguration__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GenerationConfiguration__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GenerationConfiguration__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGenerationConfigurationAccess().getGroup_3()); }
(rule__GenerationConfiguration__Group_3__0)?
{ after(grammarAccess.getGenerationConfigurationAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__GenerationConfiguration__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GenerationConfiguration__Group_3__0__Impl
	rule__GenerationConfiguration__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GenerationConfiguration__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGenerationConfigurationAccess().getNsuriKeyword_3_0()); }

	'nsuri' 

{ after(grammarAccess.getGenerationConfigurationAccess().getNsuriKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GenerationConfiguration__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GenerationConfiguration__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GenerationConfiguration__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGenerationConfigurationAccess().getNsuriAssignment_3_1()); }
(rule__GenerationConfiguration__NsuriAssignment_3_1)
{ after(grammarAccess.getGenerationConfigurationAccess().getNsuriAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Generation__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Generation__Group__0__Impl
	rule__Generation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Generation__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGenerationAccess().getGenerationAction_0()); }
(

)
{ after(grammarAccess.getGenerationAccess().getGenerationAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Generation__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Generation__Group__1__Impl
	rule__Generation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Generation__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGenerationAccess().getGenerationKeyword_1()); }

	'generation' 

{ after(grammarAccess.getGenerationAccess().getGenerationKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Generation__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Generation__Group__2__Impl
	rule__Generation__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Generation__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGenerationAccess().getLeftCurlyBracketKeyword_2()); }

	'{' 

{ after(grammarAccess.getGenerationAccess().getLeftCurlyBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Generation__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Generation__Group__3__Impl
	rule__Generation__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Generation__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGenerationAccess().getOwnedDataGenerationConfAssignment_3()); }
(rule__Generation__OwnedDataGenerationConfAssignment_3)?
{ after(grammarAccess.getGenerationAccess().getOwnedDataGenerationConfAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Generation__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Generation__Group__4__Impl
	rule__Generation__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Generation__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGenerationAccess().getOwnedExtensionGenConfAssignment_4()); }
(rule__Generation__OwnedExtensionGenConfAssignment_4)*
{ after(grammarAccess.getGenerationAccess().getOwnedExtensionGenConfAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Generation__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Generation__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Generation__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGenerationAccess().getRightCurlyBracketKeyword_5()); }

	'}' 

{ after(grammarAccess.getGenerationAccess().getRightCurlyBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__GData__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group__0__Impl
	rule__GData__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getGDataAction_0()); }
(

)
{ after(grammarAccess.getGDataAccess().getGDataAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group__1__Impl
	rule__GData__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getDataKeyword_1()); }

	'data' 

{ after(grammarAccess.getGDataAccess().getDataKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group__2__Impl
	rule__GData__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getLeftParenthesisKeyword_2()); }

	'(' 

{ after(grammarAccess.getGDataAccess().getLeftParenthesisKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group__3__Impl
	rule__GData__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getGroup_3()); }
(rule__GData__Group_3__0)
{ after(grammarAccess.getGDataAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getRightParenthesisKeyword_4()); }

	')' 

{ after(grammarAccess.getGDataAccess().getRightParenthesisKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__GData__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3__0__Impl
	rule__GData__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getGroup_3_0()); }
(rule__GData__Group_3_0__0)?
{ after(grammarAccess.getGDataAccess().getGroup_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3__1__Impl
	rule__GData__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getGroup_3_1()); }
(rule__GData__Group_3_1__0)?
{ after(grammarAccess.getGDataAccess().getGroup_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3__2__Impl
	rule__GData__Group_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getGroup_3_2()); }
(rule__GData__Group_3_2__0)?
{ after(grammarAccess.getGDataAccess().getGroup_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group_3__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3__3__Impl
	rule__GData__Group_3__4
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getGroup_3_3()); }
(rule__GData__Group_3_3__0)?
{ after(grammarAccess.getGDataAccess().getGroup_3_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group_3__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3__4__Impl
	rule__GData__Group_3__5
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getGroup_3_4()); }
(rule__GData__Group_3_4__0)?
{ after(grammarAccess.getGDataAccess().getGroup_3_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group_3__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getGroup_3_5()); }
(rule__GData__Group_3_5__0)?
{ after(grammarAccess.getGDataAccess().getGroup_3_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__GData__Group_3_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3_0__0__Impl
	rule__GData__Group_3_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getModelKeyword_3_0_0()); }

	'Model' 

{ after(grammarAccess.getGDataAccess().getModelKeyword_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group_3_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3_0__1__Impl
	rule__GData__Group_3_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getColonKeyword_3_0_1()); }

	':' 

{ after(grammarAccess.getGDataAccess().getColonKeyword_3_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group_3_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getModelAssignment_3_0_2()); }
(rule__GData__ModelAssignment_3_0_2)
{ after(grammarAccess.getGDataAccess().getModelAssignment_3_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__GData__Group_3_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3_1__0__Impl
	rule__GData__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getEditKeyword_3_1_0()); }

	'Edit' 

{ after(grammarAccess.getGDataAccess().getEditKeyword_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group_3_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3_1__1__Impl
	rule__GData__Group_3_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getColonKeyword_3_1_1()); }

	':' 

{ after(grammarAccess.getGDataAccess().getColonKeyword_3_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group_3_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getEditAssignment_3_1_2()); }
(rule__GData__EditAssignment_3_1_2)
{ after(grammarAccess.getGDataAccess().getEditAssignment_3_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__GData__Group_3_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3_2__0__Impl
	rule__GData__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getEditorKeyword_3_2_0()); }

	'Editor' 

{ after(grammarAccess.getGDataAccess().getEditorKeyword_3_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group_3_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3_2__1__Impl
	rule__GData__Group_3_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getColonKeyword_3_2_1()); }

	':' 

{ after(grammarAccess.getGDataAccess().getColonKeyword_3_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group_3_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getEditorAssignment_3_2_2()); }
(rule__GData__EditorAssignment_3_2_2)
{ after(grammarAccess.getGDataAccess().getEditorAssignment_3_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__GData__Group_3_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3_3__0__Impl
	rule__GData__Group_3_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getTestKeyword_3_3_0()); }

	'Test' 

{ after(grammarAccess.getGDataAccess().getTestKeyword_3_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group_3_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3_3__1__Impl
	rule__GData__Group_3_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getColonKeyword_3_3_1()); }

	':' 

{ after(grammarAccess.getGDataAccess().getColonKeyword_3_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group_3_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getTestAssignment_3_3_2()); }
(rule__GData__TestAssignment_3_3_2)
{ after(grammarAccess.getGDataAccess().getTestAssignment_3_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__GData__Group_3_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3_4__0__Impl
	rule__GData__Group_3_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getJavadocKeyword_3_4_0()); }

	'Javadoc' 

{ after(grammarAccess.getGDataAccess().getJavadocKeyword_3_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group_3_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3_4__1__Impl
	rule__GData__Group_3_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getColonKeyword_3_4_1()); }

	':' 

{ after(grammarAccess.getGDataAccess().getColonKeyword_3_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group_3_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getJavaDocAssignment_3_4_2()); }
(rule__GData__JavaDocAssignment_3_4_2)
{ after(grammarAccess.getGDataAccess().getJavaDocAssignment_3_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__GData__Group_3_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3_5__0__Impl
	rule__GData__Group_3_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getOverwriteEcoreKeyword_3_5_0()); }

	'OverwriteEcore' 

{ after(grammarAccess.getGDataAccess().getOverwriteEcoreKeyword_3_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group_3_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3_5__1__Impl
	rule__GData__Group_3_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getColonKeyword_3_5_1()); }

	':' 

{ after(grammarAccess.getGDataAccess().getColonKeyword_3_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GData__Group_3_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GData__Group_3_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GData__Group_3_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getOverwriteEcoreAssignment_3_5_2()); }
(rule__GData__OverwriteEcoreAssignment_3_5_2)
{ after(grammarAccess.getGDataAccess().getOverwriteEcoreAssignment_3_5_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__DiagramGenerationConfiguration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DiagramGenerationConfiguration__Group__0__Impl
	rule__DiagramGenerationConfiguration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DiagramGenerationConfiguration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDiagramGenerationConfigurationAccess().getDiagramGenerationConfigurationAction_0()); }
(

)
{ after(grammarAccess.getDiagramGenerationConfigurationAccess().getDiagramGenerationConfigurationAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DiagramGenerationConfiguration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DiagramGenerationConfiguration__Group__1__Impl
	rule__DiagramGenerationConfiguration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DiagramGenerationConfiguration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDiagramGenerationConfigurationAccess().getDiagramKeyword_1()); }

	'diagram' 

{ after(grammarAccess.getDiagramGenerationConfigurationAccess().getDiagramKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DiagramGenerationConfiguration__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DiagramGenerationConfiguration__Group__2__Impl
	rule__DiagramGenerationConfiguration__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DiagramGenerationConfiguration__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDiagramGenerationConfigurationAccess().getLeftParenthesisKeyword_2()); }

	'(' 

{ after(grammarAccess.getDiagramGenerationConfigurationAccess().getLeftParenthesisKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DiagramGenerationConfiguration__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DiagramGenerationConfiguration__Group__3__Impl
	rule__DiagramGenerationConfiguration__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__DiagramGenerationConfiguration__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDiagramGenerationConfigurationAccess().getGroup_3()); }
(rule__DiagramGenerationConfiguration__Group_3__0)?
{ after(grammarAccess.getDiagramGenerationConfigurationAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DiagramGenerationConfiguration__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DiagramGenerationConfiguration__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DiagramGenerationConfiguration__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDiagramGenerationConfigurationAccess().getRightParenthesisKeyword_4()); }

	')' 

{ after(grammarAccess.getDiagramGenerationConfigurationAccess().getRightParenthesisKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__DiagramGenerationConfiguration__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DiagramGenerationConfiguration__Group_3__0__Impl
	rule__DiagramGenerationConfiguration__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DiagramGenerationConfiguration__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDiagramGenerationConfigurationAccess().getOverwriteOdesignKeyword_3_0()); }

	'OverwriteOdesign' 

{ after(grammarAccess.getDiagramGenerationConfigurationAccess().getOverwriteOdesignKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DiagramGenerationConfiguration__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DiagramGenerationConfiguration__Group_3__1__Impl
	rule__DiagramGenerationConfiguration__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DiagramGenerationConfiguration__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDiagramGenerationConfigurationAccess().getColonKeyword_3_1()); }

	':' 

{ after(grammarAccess.getDiagramGenerationConfigurationAccess().getColonKeyword_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DiagramGenerationConfiguration__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DiagramGenerationConfiguration__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DiagramGenerationConfiguration__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDiagramGenerationConfigurationAccess().getOverwriteVSMAssignment_3_2()); }
(rule__DiagramGenerationConfiguration__OverwriteVSMAssignment_3_2)
{ after(grammarAccess.getDiagramGenerationConfigurationAccess().getOverwriteVSMAssignment_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__DocumentationGenerationConfiguration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentationGenerationConfiguration__Group__0__Impl
	rule__DocumentationGenerationConfiguration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationGenerationConfiguration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationGenerationConfigurationAccess().getDocumentationGenerationConfigurationAction_0()); }
(

)
{ after(grammarAccess.getDocumentationGenerationConfigurationAccess().getDocumentationGenerationConfigurationAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentationGenerationConfiguration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentationGenerationConfiguration__Group__1__Impl
	rule__DocumentationGenerationConfiguration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationGenerationConfiguration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationGenerationConfigurationAccess().getDocumentationKeyword_1()); }

	'documentation' 

{ after(grammarAccess.getDocumentationGenerationConfigurationAccess().getDocumentationKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentationGenerationConfiguration__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentationGenerationConfiguration__Group__2__Impl
	rule__DocumentationGenerationConfiguration__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationGenerationConfiguration__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationGenerationConfigurationAccess().getLeftParenthesisKeyword_2()); }

	'(' 

{ after(grammarAccess.getDocumentationGenerationConfigurationAccess().getLeftParenthesisKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentationGenerationConfiguration__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentationGenerationConfiguration__Group__3__Impl
	rule__DocumentationGenerationConfiguration__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationGenerationConfiguration__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationGenerationConfigurationAccess().getGroup_3()); }
(rule__DocumentationGenerationConfiguration__Group_3__0)?
{ after(grammarAccess.getDocumentationGenerationConfigurationAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentationGenerationConfiguration__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentationGenerationConfiguration__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationGenerationConfiguration__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationGenerationConfigurationAccess().getRightParenthesisKeyword_4()); }

	')' 

{ after(grammarAccess.getDocumentationGenerationConfigurationAccess().getRightParenthesisKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__DocumentationGenerationConfiguration__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentationGenerationConfiguration__Group_3__0__Impl
	rule__DocumentationGenerationConfiguration__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationGenerationConfiguration__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationGenerationConfigurationAccess().getEcoreToHtmlKeyword_3_0()); }

	'EcoreToHtml:' 

{ after(grammarAccess.getDocumentationGenerationConfigurationAccess().getEcoreToHtmlKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentationGenerationConfiguration__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentationGenerationConfiguration__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationGenerationConfiguration__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationGenerationConfigurationAccess().getEcoreToHtmlAssignment_3_1()); }
(rule__DocumentationGenerationConfiguration__EcoreToHtmlAssignment_3_1)
{ after(grammarAccess.getDocumentationGenerationConfigurationAccess().getEcoreToHtmlAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ModelsAirdGenerationConfiguration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModelsAirdGenerationConfiguration__Group__0__Impl
	rule__ModelsAirdGenerationConfiguration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ModelsAirdGenerationConfiguration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModelsAirdGenerationConfigurationAccess().getAirdGenerationConfigurationAction_0()); }
(

)
{ after(grammarAccess.getModelsAirdGenerationConfigurationAccess().getAirdGenerationConfigurationAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModelsAirdGenerationConfiguration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModelsAirdGenerationConfiguration__Group__1__Impl
	rule__ModelsAirdGenerationConfiguration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ModelsAirdGenerationConfiguration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModelsAirdGenerationConfigurationAccess().getEcoreKeyword_1()); }

	'ecore' 

{ after(grammarAccess.getModelsAirdGenerationConfigurationAccess().getEcoreKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModelsAirdGenerationConfiguration__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModelsAirdGenerationConfiguration__Group__2__Impl
	rule__ModelsAirdGenerationConfiguration__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ModelsAirdGenerationConfiguration__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModelsAirdGenerationConfigurationAccess().getLeftParenthesisKeyword_2()); }

	'(' 

{ after(grammarAccess.getModelsAirdGenerationConfigurationAccess().getLeftParenthesisKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModelsAirdGenerationConfiguration__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModelsAirdGenerationConfiguration__Group__3__Impl
	rule__ModelsAirdGenerationConfiguration__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ModelsAirdGenerationConfiguration__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModelsAirdGenerationConfigurationAccess().getGroup_3()); }
(rule__ModelsAirdGenerationConfiguration__Group_3__0)?
{ after(grammarAccess.getModelsAirdGenerationConfigurationAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModelsAirdGenerationConfiguration__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModelsAirdGenerationConfiguration__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ModelsAirdGenerationConfiguration__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModelsAirdGenerationConfigurationAccess().getRightParenthesisKeyword_4()); }

	')' 

{ after(grammarAccess.getModelsAirdGenerationConfigurationAccess().getRightParenthesisKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__ModelsAirdGenerationConfiguration__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModelsAirdGenerationConfiguration__Group_3__0__Impl
	rule__ModelsAirdGenerationConfiguration__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ModelsAirdGenerationConfiguration__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModelsAirdGenerationConfigurationAccess().getAirdKeyword_3_0()); }

	'aird' 

{ after(grammarAccess.getModelsAirdGenerationConfigurationAccess().getAirdKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModelsAirdGenerationConfiguration__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModelsAirdGenerationConfiguration__Group_3__1__Impl
	rule__ModelsAirdGenerationConfiguration__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ModelsAirdGenerationConfiguration__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModelsAirdGenerationConfigurationAccess().getColonKeyword_3_1()); }

	':' 

{ after(grammarAccess.getModelsAirdGenerationConfigurationAccess().getColonKeyword_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModelsAirdGenerationConfiguration__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModelsAirdGenerationConfiguration__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ModelsAirdGenerationConfiguration__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModelsAirdGenerationConfigurationAccess().getGenRepresentationsAssignment_3_2()); }
(rule__ModelsAirdGenerationConfiguration__GenRepresentationsAssignment_3_2)
{ after(grammarAccess.getModelsAirdGenerationConfigurationAccess().getGenRepresentationsAssignment_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Release__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group__0__Impl
	rule__Release__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getReleaseAction_0()); }
(

)
{ after(grammarAccess.getReleaseAccess().getReleaseAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Release__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group__1__Impl
	rule__Release__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getReleaseKeyword_1()); }

	'release' 

{ after(grammarAccess.getReleaseAccess().getReleaseKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Release__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group__2__Impl
	rule__Release__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getLeftCurlyBracketKeyword_2()); }

	'{' 

{ after(grammarAccess.getReleaseAccess().getLeftCurlyBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Release__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group__3__Impl
	rule__Release__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getGroup_3()); }
(rule__Release__Group_3__0)?
{ after(grammarAccess.getReleaseAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Release__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group__4__Impl
	rule__Release__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getGroup_4()); }
(rule__Release__Group_4__0)?
{ after(grammarAccess.getReleaseAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Release__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group__5__Impl
	rule__Release__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getGroup_5()); }
(rule__Release__Group_5__0)?
{ after(grammarAccess.getReleaseAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Release__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getRightCurlyBracketKeyword_6()); }

	'}' 

{ after(grammarAccess.getReleaseAccess().getRightCurlyBracketKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__Release__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group_3__0__Impl
	rule__Release__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getVersionKeyword_3_0()); }

	'version' 

{ after(grammarAccess.getReleaseAccess().getVersionKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Release__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group_3__1__Impl
	rule__Release__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getColonKeyword_3_1()); }

	':' 

{ after(grammarAccess.getReleaseAccess().getColonKeyword_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Release__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getViewpointVersionAssignment_3_2()); }
(rule__Release__ViewpointVersionAssignment_3_2)
{ after(grammarAccess.getReleaseAccess().getViewpointVersionAssignment_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Release__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group_4__0__Impl
	rule__Release__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getDescriptionKeyword_4_0()); }

	'description' 

{ after(grammarAccess.getReleaseAccess().getDescriptionKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Release__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group_4__1__Impl
	rule__Release__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getColonKeyword_4_1()); }

	':' 

{ after(grammarAccess.getReleaseAccess().getColonKeyword_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Release__Group_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getViewpointDescriptionAssignment_4_2()); }
(rule__Release__ViewpointDescriptionAssignment_4_2)
{ after(grammarAccess.getReleaseAccess().getViewpointDescriptionAssignment_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Release__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group_5__0__Impl
	rule__Release__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getExecutionKeyword_5_0()); }

	'execution' 

{ after(grammarAccess.getReleaseAccess().getExecutionKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Release__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group_5__1__Impl
	rule__Release__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getEnvironmentsKeyword_5_1()); }

	'environments' 

{ after(grammarAccess.getReleaseAccess().getEnvironmentsKeyword_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Release__Group_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group_5__2__Impl
	rule__Release__Group_5__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getColonKeyword_5_2()); }

	':' 

{ after(grammarAccess.getReleaseAccess().getColonKeyword_5_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Release__Group_5__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group_5__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group_5__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getGroup_5_3()); }
(rule__Release__Group_5_3__0)
{ after(grammarAccess.getReleaseAccess().getGroup_5_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__Release__Group_5_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group_5_3__0__Impl
	rule__Release__Group_5_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group_5_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getRequiredExecutionEnvironmentAssignment_5_3_0()); }
(rule__Release__RequiredExecutionEnvironmentAssignment_5_3_0)
{ after(grammarAccess.getReleaseAccess().getRequiredExecutionEnvironmentAssignment_5_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Release__Group_5_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group_5_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group_5_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getGroup_5_3_1()); }
(rule__Release__Group_5_3_1__0)*
{ after(grammarAccess.getReleaseAccess().getGroup_5_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Release__Group_5_3_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group_5_3_1__0__Impl
	rule__Release__Group_5_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group_5_3_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getCommaKeyword_5_3_1_0()); }

	',' 

{ after(grammarAccess.getReleaseAccess().getCommaKeyword_5_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Release__Group_5_3_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Release__Group_5_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Release__Group_5_3_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getRequiredExecutionEnvironmentAssignment_5_3_1_1()); }
(rule__Release__RequiredExecutionEnvironmentAssignment_5_3_1_1)
{ after(grammarAccess.getReleaseAccess().getRequiredExecutionEnvironmentAssignment_5_3_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ViewConfiguration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ViewConfiguration__Group__0__Impl
	rule__ViewConfiguration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ViewConfiguration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getViewConfigurationAccess().getViewConfigurationAction_0()); }
(

)
{ after(grammarAccess.getViewConfigurationAccess().getViewConfigurationAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ViewConfiguration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ViewConfiguration__Group__1__Impl
	rule__ViewConfiguration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ViewConfiguration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getViewConfigurationAccess().getViewKeyword_1()); }

	'view' 

{ after(grammarAccess.getViewConfigurationAccess().getViewKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ViewConfiguration__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ViewConfiguration__Group__2__Impl
	rule__ViewConfiguration__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ViewConfiguration__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getViewConfigurationAccess().getLeftCurlyBracketKeyword_2()); }

	'{' 

{ after(grammarAccess.getViewConfigurationAccess().getLeftCurlyBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ViewConfiguration__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ViewConfiguration__Group__3__Impl
	rule__ViewConfiguration__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ViewConfiguration__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getViewConfigurationAccess().getGroup_3()); }
(rule__ViewConfiguration__Group_3__0)?
{ after(grammarAccess.getViewConfigurationAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ViewConfiguration__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ViewConfiguration__Group__4__Impl
	rule__ViewConfiguration__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ViewConfiguration__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getViewConfigurationAccess().getGroup_4()); }
(rule__ViewConfiguration__Group_4__0)?
{ after(grammarAccess.getViewConfigurationAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ViewConfiguration__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ViewConfiguration__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ViewConfiguration__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getViewConfigurationAccess().getRightCurlyBracketKeyword_5()); }

	'}' 

{ after(grammarAccess.getViewConfigurationAccess().getRightCurlyBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__ViewConfiguration__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ViewConfiguration__Group_3__0__Impl
	rule__ViewConfiguration__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ViewConfiguration__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getViewConfigurationAccess().getVisibleKeyword_3_0()); }

	'visible' 

{ after(grammarAccess.getViewConfigurationAccess().getVisibleKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ViewConfiguration__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ViewConfiguration__Group_3__1__Impl
	rule__ViewConfiguration__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ViewConfiguration__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getViewConfigurationAccess().getColonKeyword_3_1()); }

	':' 

{ after(grammarAccess.getViewConfigurationAccess().getColonKeyword_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ViewConfiguration__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ViewConfiguration__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ViewConfiguration__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getViewConfigurationAccess().getVisibleAssignment_3_2()); }
(rule__ViewConfiguration__VisibleAssignment_3_2)
{ after(grammarAccess.getViewConfigurationAccess().getVisibleAssignment_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ViewConfiguration__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ViewConfiguration__Group_4__0__Impl
	rule__ViewConfiguration__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ViewConfiguration__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getViewConfigurationAccess().getActivableKeyword_4_0()); }

	'activable' 

{ after(grammarAccess.getViewConfigurationAccess().getActivableKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ViewConfiguration__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ViewConfiguration__Group_4__1__Impl
	rule__ViewConfiguration__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ViewConfiguration__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getViewConfigurationAccess().getColonKeyword_4_1()); }

	':' 

{ after(grammarAccess.getViewConfigurationAccess().getColonKeyword_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ViewConfiguration__Group_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ViewConfiguration__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ViewConfiguration__Group_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getViewConfigurationAccess().getActivableAssignment_4_2()); }
(rule__ViewConfiguration__ActivableAssignment_4_2)
{ after(grammarAccess.getViewConfigurationAccess().getActivableAssignment_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Version__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Version__Group__0__Impl
	rule__Version__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_0()); }
	RULE_INT
{ after(grammarAccess.getVersionAccess().getINTTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Version__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Version__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVersionAccess().getGroup_1()); }
(rule__Version__Group_1__0)?
{ after(grammarAccess.getVersionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Version__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Version__Group_1__0__Impl
	rule__Version__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVersionAccess().getFullStopKeyword_1_0()); }

	'.' 

{ after(grammarAccess.getVersionAccess().getFullStopKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Version__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Version__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVersionAccess().getGroup_1_1()); }
(rule__Version__Group_1_1__0)
{ after(grammarAccess.getVersionAccess().getGroup_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Version__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Version__Group_1_1__0__Impl
	rule__Version__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_1_0()); }
	RULE_INT
{ after(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Version__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Version__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVersionAccess().getGroup_1_1_1()); }
(rule__Version__Group_1_1_1__0)?
{ after(grammarAccess.getVersionAccess().getGroup_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Version__Group_1_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Version__Group_1_1_1__0__Impl
	rule__Version__Group_1_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group_1_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVersionAccess().getFullStopKeyword_1_1_1_0()); }

	'.' 

{ after(grammarAccess.getVersionAccess().getFullStopKeyword_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Version__Group_1_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Version__Group_1_1_1__1__Impl
	rule__Version__Group_1_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group_1_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_1_1_1()); }
	RULE_INT
{ after(grammarAccess.getVersionAccess().getINTTerminalRuleCall_1_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Version__Group_1_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Version__Group_1_1_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group_1_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVersionAccess().getGroup_1_1_1_2()); }
(rule__Version__Group_1_1_1_2__0)?
{ after(grammarAccess.getVersionAccess().getGroup_1_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Version__Group_1_1_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Version__Group_1_1_1_2__0__Impl
	rule__Version__Group_1_1_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group_1_1_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVersionAccess().getFullStopKeyword_1_1_1_2_0()); }

	'.' 

{ after(grammarAccess.getVersionAccess().getFullStopKeyword_1_1_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Version__Group_1_1_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Version__Group_1_1_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group_1_1_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVersionAccess().getQualifierParserRuleCall_1_1_1_2_1()); }
	ruleQualifier
{ after(grammarAccess.getVersionAccess().getQualifierParserRuleCall_1_1_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Qualifier__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Qualifier__Group__0__Impl
	rule__Qualifier__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Qualifier__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifierAccess().getAlternatives_0()); }
(rule__Qualifier__Alternatives_0)
{ after(grammarAccess.getQualifierAccess().getAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Qualifier__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Qualifier__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Qualifier__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifierAccess().getAlternatives_1()); }
(rule__Qualifier__Alternatives_1)*
{ after(grammarAccess.getQualifierAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__FQN__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FQN__Group__0__Impl
	rule__FQN__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FQN__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); }
	RULE_ID
{ after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FQN__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FQN__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FQN__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFQNAccess().getGroup_1()); }
(rule__FQN__Group_1__0)*
{ after(grammarAccess.getFQNAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__FQN__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FQN__Group_1__0__Impl
	rule__FQN__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FQN__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); }

	'.' 

{ after(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FQN__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FQN__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FQN__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); }
(	RULE_ID)
{ after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}







rule__Configuration__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConfigurationAccess().getNameFQNParserRuleCall_2_0()); }
	ruleFQN{ after(grammarAccess.getConfigurationAccess().getNameFQNParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Configuration__VpConfigurationElementsAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConfigurationAccess().getVpConfigurationElementsConfigurationElementParserRuleCall_4_0()); }
	ruleConfigurationElement{ after(grammarAccess.getConfigurationAccess().getVpConfigurationElementsConfigurationElementParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TargetApplication__TypeAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTargetApplicationAccess().getTypeEStringParserRuleCall_2_0()); }
	ruleEString{ after(grammarAccess.getTargetApplicationAccess().getTypeEStringParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GenerationConfiguration__ProjectNameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGenerationConfigurationAccess().getProjectNameFQNParserRuleCall_2_0()); }
	ruleFQN{ after(grammarAccess.getGenerationConfigurationAccess().getProjectNameFQNParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GenerationConfiguration__NsuriAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGenerationConfigurationAccess().getNsuriSTRINGTerminalRuleCall_3_1_0()); }
	RULE_STRING{ after(grammarAccess.getGenerationConfigurationAccess().getNsuriSTRINGTerminalRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Generation__OwnedDataGenerationConfAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGenerationAccess().getOwnedDataGenerationConfGDataParserRuleCall_3_0()); }
	ruleGData{ after(grammarAccess.getGenerationAccess().getOwnedDataGenerationConfGDataParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Generation__OwnedExtensionGenConfAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGenerationAccess().getOwnedExtensionGenConfExtensionGeneratrionConfigurationParserRuleCall_4_0()); }
	ruleExtensionGeneratrionConfiguration{ after(grammarAccess.getGenerationAccess().getOwnedExtensionGenConfExtensionGeneratrionConfigurationParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GData__ModelAssignment_3_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getModelEBooleanParserRuleCall_3_0_2_0()); }
	ruleEBoolean{ after(grammarAccess.getGDataAccess().getModelEBooleanParserRuleCall_3_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GData__EditAssignment_3_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getEditEBooleanParserRuleCall_3_1_2_0()); }
	ruleEBoolean{ after(grammarAccess.getGDataAccess().getEditEBooleanParserRuleCall_3_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GData__EditorAssignment_3_2_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getEditorEBooleanParserRuleCall_3_2_2_0()); }
	ruleEBoolean{ after(grammarAccess.getGDataAccess().getEditorEBooleanParserRuleCall_3_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GData__TestAssignment_3_3_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getTestEBooleanParserRuleCall_3_3_2_0()); }
	ruleEBoolean{ after(grammarAccess.getGDataAccess().getTestEBooleanParserRuleCall_3_3_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GData__JavaDocAssignment_3_4_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getJavaDocEBooleanParserRuleCall_3_4_2_0()); }
	ruleEBoolean{ after(grammarAccess.getGDataAccess().getJavaDocEBooleanParserRuleCall_3_4_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GData__OverwriteEcoreAssignment_3_5_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGDataAccess().getOverwriteEcoreEBooleanParserRuleCall_3_5_2_0()); }
	ruleEBoolean{ after(grammarAccess.getGDataAccess().getOverwriteEcoreEBooleanParserRuleCall_3_5_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DiagramGenerationConfiguration__OverwriteVSMAssignment_3_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDiagramGenerationConfigurationAccess().getOverwriteVSMEBooleanParserRuleCall_3_2_0()); }
	ruleEBoolean{ after(grammarAccess.getDiagramGenerationConfigurationAccess().getOverwriteVSMEBooleanParserRuleCall_3_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentationGenerationConfiguration__EcoreToHtmlAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentationGenerationConfigurationAccess().getEcoreToHtmlEBooleanParserRuleCall_3_1_0()); }
	ruleEBoolean{ after(grammarAccess.getDocumentationGenerationConfigurationAccess().getEcoreToHtmlEBooleanParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ModelsAirdGenerationConfiguration__GenRepresentationsAssignment_3_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModelsAirdGenerationConfigurationAccess().getGenRepresentationsEBooleanParserRuleCall_3_2_0()); }
	ruleEBoolean{ after(grammarAccess.getModelsAirdGenerationConfigurationAccess().getGenRepresentationsEBooleanParserRuleCall_3_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Release__ViewpointVersionAssignment_3_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getViewpointVersionVersionParserRuleCall_3_2_0()); }
	ruleVersion{ after(grammarAccess.getReleaseAccess().getViewpointVersionVersionParserRuleCall_3_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Release__ViewpointDescriptionAssignment_4_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getViewpointDescriptionEStringParserRuleCall_4_2_0()); }
	ruleEString{ after(grammarAccess.getReleaseAccess().getViewpointDescriptionEStringParserRuleCall_4_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Release__RequiredExecutionEnvironmentAssignment_5_3_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getRequiredExecutionEnvironmentSTRINGTerminalRuleCall_5_3_0_0()); }
	RULE_STRING{ after(grammarAccess.getReleaseAccess().getRequiredExecutionEnvironmentSTRINGTerminalRuleCall_5_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Release__RequiredExecutionEnvironmentAssignment_5_3_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReleaseAccess().getRequiredExecutionEnvironmentSTRINGTerminalRuleCall_5_3_1_1_0()); }
	RULE_STRING{ after(grammarAccess.getReleaseAccess().getRequiredExecutionEnvironmentSTRINGTerminalRuleCall_5_3_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ViewConfiguration__VisibleAssignment_3_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getViewConfigurationAccess().getVisibleEBooleanParserRuleCall_3_2_0()); }
	ruleEBoolean{ after(grammarAccess.getViewConfigurationAccess().getVisibleEBooleanParserRuleCall_3_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ViewConfiguration__ActivableAssignment_4_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getViewConfigurationAccess().getActivableEBooleanParserRuleCall_4_2_0()); }
	ruleEBoolean{ after(grammarAccess.getViewConfigurationAccess().getActivableEBooleanParserRuleCall_4_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


