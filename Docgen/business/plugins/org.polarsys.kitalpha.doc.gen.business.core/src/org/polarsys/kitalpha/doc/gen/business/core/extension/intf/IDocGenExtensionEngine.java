/*******************************************************************************
 * Copyright (c) 2016-2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.doc.gen.business.core.extension.intf;

import java.util.Collection;
import java.util.Map;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;

/**
 * Specification of the engine which allows execution of contributed patterns
 * @author Faycal Abka
 *
 */
public interface IDocGenExtensionEngine {
	
	/**
	 * Execute the pattern specified in {@code patternURI} parameter with {@code ctx} context and
	 * {@code params} parameters
	 * @param patternURI uri of the pattern to execute
	 * @param ctx context of the pattern to execute
	 * @param params parameters of the pattern to execute
	 */
	void execute(String patternURI, PatternContext ctx, Map<String, Object> params);
	
	/**
	 * Execute the pattern {@code pattern} with {@code ctx} context and
	 * {@code params} parameters
	 * @param pattern to execute
	 * @param ctx ctx context of the pattern to execute
	 * @param params parameters of the pattern to execute
	 */
	void execute(Pattern pattern, PatternContext ctx, Map<String, Object> params);
	
	/**
	 * Execute all patterns in {@code patterns} with {@code ctx} context and
	 * {@code params} parameters
	 * @param patterns
	 * @param ctx ctx context of the pattern to execute
	 * @param params parameters of the pattern to execute
	 */
	void execute(Collection<Pattern> patterns, PatternContext ctx, Map<String, Object> params);
	
	/**
	 * Execute all contribued patterns with {@code ctx} context and {@code params} parameters
	 * @param ctx context of the pattern to execute
	 * @param params parameters of the pattern to execute
	 */
	void execute(PatternContext ctx, Map<String, Object> params);
	
	/**
	 * Apply (i.e. execute) all contributed patterns in the topic with  {@code ctx} context and {@code params} parameters
	 * @param topic
	 * @param ctx context of the pattern to execute
	 * @param params parameters of the pattern to execute
	 */
	void apply(String topic, PatternContext ctx, Map<String, Object> params);
	
	
	void execute(String patternURI, PatternContext ctx, Map<String, Object> params, StringBuffer stringBuffer);
	
	void execute(Pattern pattern, PatternContext ctx, Map<String, Object> params, StringBuffer stringBuffer);
	
	void execute(Collection<Pattern> patterns, PatternContext ctx, Map<String, Object> params, StringBuffer stringBuffer);
	
	void execute(PatternContext ctx, Map<String, Object> params, StringBuffer stringBuffer);
	
	void apply(String topic, PatternContext ctx, Map<String, Object> params, StringBuffer stringBuffer);
}
