//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.transposer.analyser.extension;

import org.eclipse.egf.emf.pattern.base.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.codegen.ecore.genmodel.impl.*;
import org.eclipse.emf.codegen.ecore.genmodel.generator.*;
import org.eclipse.emf.codegen.util.*;
import org.eclipse.emf.ecore.util.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class Class extends org.polarsys.kitalpha.emde.egf.model.Class {
	protected static String nl;

	public static synchronized Class create(String lineSeparator) {
		nl = lineSeparator;
		Class result = new Class();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "package ";
	protected final String TEXT_3 = ";";
	protected final String TEXT_4 = NL;
	protected final String TEXT_5 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL
			+ " * A representation of the model object '<em><b>";
	protected final String TEXT_6 = "</b></em>'." + NL + " * <!-- end-user-doc -->";
	protected final String TEXT_7 = NL + " *" + NL + " * <!-- begin-model-doc -->" + NL + " * ";
	protected final String TEXT_8 = NL + " * <!-- end-model-doc -->";
	protected final String TEXT_9 = NL + " *";
	protected final String TEXT_10 = NL + " * <p>" + NL + " * The following features are supported:" + NL + " * <ul>";
	protected final String TEXT_11 = NL + " *   <li>{@link ";
	protected final String TEXT_12 = "#";
	protected final String TEXT_13 = " <em>";
	protected final String TEXT_14 = "</em>}</li>";
	protected final String TEXT_15 = NL + " * </ul>" + NL + " * </p>";
	protected final String TEXT_16 = NL + " * @see ";
	protected final String TEXT_17 = "#get";
	protected final String TEXT_18 = "()";
	protected final String TEXT_19 = NL + " * @model ";
	protected final String TEXT_20 = NL + " *        ";
	protected final String TEXT_21 = NL + " * @model";
	protected final String TEXT_22 = NL + " * @extends ";
	protected final String TEXT_23 = NL + " * @generated" + NL + " */";
	protected final String TEXT_24 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL
			+ " * An implementation of the model object '<em><b>";
	protected final String TEXT_25 = "</b></em>'." + NL + " * <!-- end-user-doc -->" + NL + " * <p>";
	protected final String TEXT_26 = NL + " * The following features are implemented:" + NL + " * <ul>";
	protected final String TEXT_27 = NL + " * </ul>";
	protected final String TEXT_28 = NL + " * </p>" + NL + " *" + NL + " * @generated" + NL + " */";
	protected final String TEXT_29 = NL + "public";
	protected final String TEXT_30 = " abstract";
	protected final String TEXT_31 = " class ";
	protected final String TEXT_32 = NL + "public interface ";
	protected final String TEXT_33 = NL + "{";
	protected final String TEXT_34 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
	protected final String TEXT_35 = " copyright = ";
	protected final String TEXT_36 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
	protected final String TEXT_37 = " mofDriverNumber = \"";
	protected final String TEXT_38 = "\";";
	protected final String TEXT_39 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL
			+ "\tprivate static final long serialVersionUID = 1L;" + NL;
	protected final String TEXT_40 = NL + "\t/**" + NL
			+ "\t * An array of objects representing the values of non-primitive features." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */"
			+ NL + "\tprotected Object[] ";
	protected final String TEXT_41 = ";" + NL;
	protected final String TEXT_42 = NL + "\t/**" + NL
			+ "\t * A bit field representing the indices of non-primitive feature values." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */"
			+ NL + "\tprotected int ";
	protected final String TEXT_43 = NL + "\t/**" + NL
			+ "\t * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set."
			+ NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
	protected final String TEXT_44 = " = 0;" + NL;
	protected final String TEXT_45 = "  ";
	protected final String TEXT_46 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final int ";
	protected final String TEXT_47 = " = ";
	protected final String TEXT_48 = ".getFeatureID(";
	protected final String TEXT_49 = ") - ";
	protected final String TEXT_50 = "public";
	protected final String TEXT_51 = "protected";
	protected final String TEXT_52 = " ";
	protected final String TEXT_53 = "()" + NL + "\t{" + NL + "\t\tsuper();";
	protected final String TEXT_54 = NL + "\t\t";
	protected final String TEXT_55 = " |= ";
	protected final String TEXT_56 = "_EFLAG";
	protected final String TEXT_57 = "_DEFAULT";
	protected final String TEXT_58 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_59 = NL + "\t@Override";
	protected final String TEXT_60 = NL + "\tprotected ";
	protected final String TEXT_61 = " eStaticClass()" + NL + "\t{" + NL + "\t\treturn ";
	protected final String TEXT_62 = ";" + NL + "\t}" + NL;
	protected final String TEXT_63 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_64 = NL + "\t@SuppressWarnings(\"unchecked\")";
	protected final String TEXT_65 = NL + "\tpublic ";
	protected final String TEXT_66 = " eInverseAdd(";
	protected final String TEXT_67 = " otherEnd, int featureID, ";
	protected final String TEXT_68 = " msgs)" + NL + "\t{" + NL + "\t\tswitch (featureID";
	protected final String TEXT_69 = ")" + NL + "\t\t{";
	protected final String TEXT_70 = NL + "\t\t\tcase ";
	protected final String TEXT_71 = ":";
	protected final String TEXT_72 = NL + "\t\t\t\treturn ((";
	protected final String TEXT_73 = "(";
	protected final String TEXT_74 = ".InternalMapView";
	protected final String TEXT_75 = ")";
	protected final String TEXT_76 = "()).eMap()).basicAdd(otherEnd, msgs);";
	protected final String TEXT_77 = NL + "\t\t\t\treturn (";
	protected final String TEXT_78 = "()).basicAdd(otherEnd, msgs);";
	protected final String TEXT_79 = NL + "\t\t\t\tif (eInternalContainer() != null)" + NL
			+ "\t\t\t\t\tmsgs = eBasicRemoveFromContainer(msgs);";
	protected final String TEXT_80 = NL + "\t\t\t\treturn basicSet";
	protected final String TEXT_81 = "((";
	protected final String TEXT_82 = ")otherEnd, msgs);";
	protected final String TEXT_83 = NL + "\t\t\t\treturn eBasicSetContainer(otherEnd, ";
	protected final String TEXT_84 = ", msgs);";
	protected final String TEXT_85 = NL + "\t\t\t\t";
	protected final String TEXT_86 = " = (";
	protected final String TEXT_87 = ")eVirtualGet(";
	protected final String TEXT_88 = ");";
	protected final String TEXT_89 = "basicGet";
	protected final String TEXT_90 = "();";
	protected final String TEXT_91 = NL + "\t\t\t\tif (";
	protected final String TEXT_92 = " != null)";
	protected final String TEXT_93 = NL + "\t\t\t\t\tmsgs = ((";
	protected final String TEXT_94 = ").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
	protected final String TEXT_95 = ", null, msgs);";
	protected final String TEXT_96 = ").eInverseRemove(this, ";
	protected final String TEXT_97 = ", ";
	protected final String TEXT_98 = ".class, msgs);";
	protected final String TEXT_99 = NL + "\t\t}";
	protected final String TEXT_100 = NL + "\t\treturn super.eInverseAdd(otherEnd, featureID, msgs);";
	protected final String TEXT_101 = NL + "\t\treturn eDynamicInverseAdd(otherEnd, featureID, msgs);";
	protected final String TEXT_102 = NL + "\t}" + NL;
	protected final String TEXT_103 = " eInverseRemove(";
	protected final String TEXT_104 = ")((";
	protected final String TEXT_105 = "()).eMap()).basicRemove(otherEnd, msgs);";
	protected final String TEXT_106 = ".Internal.Wrapper)";
	protected final String TEXT_107 = "()).featureMap()).basicRemove(otherEnd, msgs);";
	protected final String TEXT_108 = "()).basicRemove(otherEnd, msgs);";
	protected final String TEXT_109 = NL + "\t\t\t\treturn eBasicSetContainer(null, ";
	protected final String TEXT_110 = NL + "\t\t\t\treturn basicUnset";
	protected final String TEXT_111 = "(msgs);";
	protected final String TEXT_112 = "(null, msgs);";
	protected final String TEXT_113 = NL + "\t\treturn super.eInverseRemove(otherEnd, featureID, msgs);";
	protected final String TEXT_114 = NL + "\t\treturn eDynamicInverseRemove(otherEnd, featureID, msgs);";
	protected final String TEXT_115 = " eBasicRemoveFromContainerFeature(";
	protected final String TEXT_116 = " msgs)" + NL + "\t{" + NL + "\t\tswitch (eContainerFeatureID()";
	protected final String TEXT_117 = ":" + NL + "\t\t\t\treturn eInternalContainer().eInverseRemove(this, ";
	protected final String TEXT_118 = NL + "\t\treturn super.eBasicRemoveFromContainerFeature(msgs);";
	protected final String TEXT_119 = NL + "\t\treturn eDynamicBasicRemoveFromContainer(msgs);";
	protected final String TEXT_120 = NL + "\tpublic Object eGet(int featureID, boolean resolve, boolean coreType)" + NL
			+ "\t{" + NL + "\t\tswitch (featureID";
	protected final String TEXT_121 = NL + "\t\t\t\treturn ";
	protected final String TEXT_122 = "() ? Boolean.TRUE : Boolean.FALSE;";
	protected final String TEXT_123 = NL + "\t\t\t\treturn new ";
	protected final String TEXT_124 = "());";
	protected final String TEXT_125 = NL + "\t\t\t\tif (resolve) return ";
	protected final String TEXT_126 = "();" + NL + "\t\t\t\treturn basicGet";
	protected final String TEXT_127 = NL + "\t\t\t\tif (coreType) return ((";
	protected final String TEXT_128 = "()).eMap();" + NL + "\t\t\t\telse return ";
	protected final String TEXT_129 = NL + "\t\t\t\tif (coreType) return ";
	protected final String TEXT_130 = "();" + NL + "\t\t\t\telse return ";
	protected final String TEXT_131 = "().map();";
	protected final String TEXT_132 = "()).featureMap();" + NL + "\t\t\t\treturn ";
	protected final String TEXT_133 = "();" + NL + "\t\t\t\treturn ((";
	protected final String TEXT_134 = ".Internal)";
	protected final String TEXT_135 = "()).getWrapper();";
	protected final String TEXT_136 = NL + "\t\treturn super.eGet(featureID, resolve, coreType);";
	protected final String TEXT_137 = NL + "\t\treturn eDynamicGet(featureID, resolve, coreType);";
	protected final String TEXT_138 = NL + "\tpublic void eSet(int featureID, Object newValue)" + NL + "\t{" + NL
			+ "\t\tswitch (featureID";
	protected final String TEXT_139 = NL + "\t\t\t\t((";
	protected final String TEXT_140 = ".Internal)((";
	protected final String TEXT_141 = "()).featureMap()).set(newValue);";
	protected final String TEXT_142 = "()).set(newValue);";
	protected final String TEXT_143 = ".Setting)((";
	protected final String TEXT_144 = "()).eMap()).set(newValue);";
	protected final String TEXT_145 = ".Setting)";
	protected final String TEXT_146 = "().clear();" + NL + "\t\t\t\t";
	protected final String TEXT_147 = "().addAll((";
	protected final String TEXT_148 = "<? extends ";
	protected final String TEXT_149 = ">";
	protected final String TEXT_150 = ")newValue);";
	protected final String TEXT_151 = NL + "\t\t\t\tset";
	protected final String TEXT_152 = "(((";
	protected final String TEXT_153 = ")newValue).";
	protected final String TEXT_154 = NL + "\t\t\t\t// begin-extension-code" + NL + "\t\t\t\tif (newValue == null";
	protected final String TEXT_155 = " || newValue instanceof ";
	protected final String TEXT_156 = ") {" + NL + "\t\t\t\t// end-extension-code" + NL + "\t\t\t\t\tset";
	protected final String TEXT_157 = ")newValue);" + NL + "\t\t\t\t// begin-extension-code" + NL + "\t\t\t\t}" + NL
			+ "\t\t\t\t// end-extension-code";
	protected final String TEXT_158 = NL + "          set";
	protected final String TEXT_159 = "(newValue);";
	protected final String TEXT_160 = NL + "\t\t\t\treturn;";
	protected final String TEXT_161 = NL + "\t\tsuper.eSet(featureID, newValue);";
	protected final String TEXT_162 = NL + "\t\teDynamicSet(featureID, newValue);";
	protected final String TEXT_163 = NL + "\tpublic int eBaseStructuralFeatureID(int derivedFeatureID, Class";
	protected final String TEXT_164 = " baseClass)" + NL + "\t{";
	protected final String TEXT_165 = NL + "\t\tif (baseClass == ";
	protected final String TEXT_166 = ".class)" + NL + "\t\t{" + NL + "\t\t\tswitch (derivedFeatureID";
	protected final String TEXT_167 = ")" + NL + "\t\t\t{";
	protected final String TEXT_168 = NL + "\t\t\t\tcase ";
	protected final String TEXT_169 = ": return ";
	protected final String TEXT_170 = NL + "\t\t\t\tdefault: return -1;" + NL + "\t\t\t}" + NL + "\t\t}";
	protected final String TEXT_171 = NL + "\t\treturn super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);"
			+ NL + "\t}";
	protected final String TEXT_172 = NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_173 = NL + "\tpublic int eDerivedStructuralFeatureID(int baseFeatureID, Class";
	protected final String TEXT_174 = ".class)" + NL + "\t\t{" + NL + "\t\t\tswitch (baseFeatureID)" + NL + "\t\t\t{";
	protected final String TEXT_175 = ".class)" + NL + "\t\t{" + NL + "\t\t\tswitch (baseFeatureID";
	protected final String TEXT_176 = NL + "\t\treturn super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);"
			+ NL + "\t}" + NL;
	protected final String TEXT_177 = NL + "\tprotected Object[] eVirtualValues()" + NL + "\t{" + NL + "\t\treturn ";
	protected final String TEXT_178 = ";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->"
			+ NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_179 = NL + "\tprotected void eSetVirtualValues(Object[] newValues)" + NL + "\t{" + NL
			+ "\t\t";
	protected final String TEXT_180 = " = newValues;" + NL + "\t}" + NL;
	protected final String TEXT_181 = NL + "\tprotected int eVirtualIndexBits(int offset)" + NL + "\t{" + NL
			+ "\t\tswitch (offset)" + NL + "\t\t{";
	protected final String TEXT_182 = " :" + NL + "\t\t\t\treturn ";
	protected final String TEXT_183 = NL + "\t\t\tdefault :" + NL + "\t\t\t\tthrow new IndexOutOfBoundsException();"
			+ NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_184 = NL + "\tprotected void eSetVirtualIndexBits(int offset, int newIndexBits)" + NL
			+ "\t{" + NL + "\t\tswitch (offset)" + NL + "\t\t{";
	protected final String TEXT_185 = " :" + NL + "\t\t\t\t";
	protected final String TEXT_186 = " = newIndexBits;" + NL + "\t\t\t\tbreak;";
	protected final String TEXT_187 = NL + "\t\t\tdefault :" + NL + "\t\t\t\tthrow new IndexOutOfBoundsException();"
			+ NL + "\t\t}" + NL + "\t}" + NL;
	protected final String TEXT_188 = NL + "\tpublic String toString()" + NL + "\t{" + NL
			+ "\t\tif (eIsProxy()) return super.toString();" + NL + "" + NL
			+ "\t\tStringBuffer result = new StringBuffer(super.toString());";
	protected final String TEXT_189 = NL + "\t\tresult.append(\" (";
	protected final String TEXT_190 = ": \");";
	protected final String TEXT_191 = NL + "\t\tresult.append(\", ";
	protected final String TEXT_192 = NL + "\t\tif (eVirtualIsSet(";
	protected final String TEXT_193 = ")) result.append(eVirtualGet(";
	protected final String TEXT_194 = ")); else result.append(\"<unset>\");";
	protected final String TEXT_195 = NL + "\t\tif (";
	protected final String TEXT_196 = " & ";
	protected final String TEXT_197 = "_ESETFLAG) != 0";
	protected final String TEXT_198 = "ESet";
	protected final String TEXT_199 = ") result.append((";
	protected final String TEXT_200 = "_EFLAG) != 0); else result.append(\"<unset>\");";
	protected final String TEXT_201 = ") result.append(";
	protected final String TEXT_202 = "_EFLAG_VALUES[(";
	protected final String TEXT_203 = "_EFLAG) >>> ";
	protected final String TEXT_204 = "_EFLAG_OFFSET]); else result.append(\"<unset>\");";
	protected final String TEXT_205 = "); else result.append(\"<unset>\");";
	protected final String TEXT_206 = NL + "\t\tresult.append(eVirtualGet(";
	protected final String TEXT_207 = "));";
	protected final String TEXT_208 = NL + "\t\tresult.append((";
	protected final String TEXT_209 = "_EFLAG) != 0);";
	protected final String TEXT_210 = NL + "\t\tresult.append(";
	protected final String TEXT_211 = "_EFLAG_OFFSET]);";
	protected final String TEXT_212 = NL + "\t\tresult.append(')');" + NL + "\t\treturn result.toString();" + NL + "\t}"
			+ NL;
	protected final String TEXT_213 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int hash = -1;"
			+ NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL
			+ "\t * @generated" + NL + "\t */" + NL + "\tpublic int getHash()" + NL + "\t{" + NL + "\t\tif (hash == -1)"
			+ NL + "\t\t{" + NL + "\t\t\t";
	protected final String TEXT_214 = " theKey = getKey();" + NL
			+ "\t\t\thash = (theKey == null ? 0 : theKey.hashCode());" + NL + "\t\t}" + NL + "\t\treturn hash;" + NL
			+ "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->"
			+ NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setHash(int hash)" + NL + "\t{" + NL
			+ "\t\tthis.hash = hash;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
	protected final String TEXT_215 = " getKey()" + NL + "\t{";
	protected final String TEXT_216 = NL + "\t\treturn new ";
	protected final String TEXT_217 = "(getTypedKey());";
	protected final String TEXT_218 = NL + "\t\treturn getTypedKey();";
	protected final String TEXT_219 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setKey(";
	protected final String TEXT_220 = " key)" + NL + "\t{";
	protected final String TEXT_221 = NL + "\t\tgetTypedKey().addAll(";
	protected final String TEXT_222 = "key);";
	protected final String TEXT_223 = NL + "\t\tsetTypedKey(key);";
	protected final String TEXT_224 = NL + "\t\tsetTypedKey(((";
	protected final String TEXT_225 = ")key).";
	protected final String TEXT_226 = NL + "\t\tsetTypedKey((";
	protected final String TEXT_227 = ")key);";
	protected final String TEXT_228 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
	protected final String TEXT_229 = " getValue()" + NL + "\t{";
	protected final String TEXT_230 = "(getTypedValue());";
	protected final String TEXT_231 = NL + "\t\treturn getTypedValue();";
	protected final String TEXT_232 = " setValue(";
	protected final String TEXT_233 = " value)" + NL + "\t{" + NL + "\t\t";
	protected final String TEXT_234 = " oldValue = getValue();";
	protected final String TEXT_235 = NL + "\t\tgetTypedValue().clear();" + NL + "\t\tgetTypedValue().addAll(";
	protected final String TEXT_236 = "value);";
	protected final String TEXT_237 = NL + "\t\tsetTypedValue(value);";
	protected final String TEXT_238 = NL + "\t\tsetTypedValue(((";
	protected final String TEXT_239 = ")value).";
	protected final String TEXT_240 = NL + "\t\tsetTypedValue((";
	protected final String TEXT_241 = ")value);";
	protected final String TEXT_242 = NL + "\t\treturn oldValue;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */";
	protected final String TEXT_243 = " getEMap()" + NL + "\t{" + NL + "\t\t";
	protected final String TEXT_244 = " container = eContainer();" + NL + "\t\treturn container == null ? null : (";
	protected final String TEXT_245 = ")container.eGet(eContainmentFeature());" + NL + "\t}" + NL;
	protected final String TEXT_246 = NL + "} //";
	protected final String TEXT_247 = NL;

	public Class() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

		// add initialisation of the pattern variables (declaration has been already done).

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;
		Node.Container currentNode = ctx.getNode();

		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_247);
		stringBuffer.append(TEXT_247);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		/**
		 * <copyright>
		 *
		 * Copyright (c) 2002-2020 IBM Corporation and others.
		 * This program and the accompanying materials are made available under the
		 * terms of the Eclipse Public License 2.0 which is available at
		 * http://www.eclipse.org/legal/epl-2.0
		 * 
		 * SPDX-License-Identifier: EPL-2.0
		 *
		 * Contributors:
		 *   IBM - Initial API and implementation
		 *
		 * </copyright>
		 */

		final GenClass genClass = (GenClass) ((Object[]) argument)[0];
		final GenPackage genPackage = genClass.getGenPackage();
		final GenModel genModel = genPackage.getGenModel();
		final boolean isJDK50 = genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50;
		final boolean isInterface = Boolean.TRUE.equals(((Object[]) argument)[1]);
		final boolean isImplementation = Boolean.TRUE.equals(((Object[]) argument)[2]);
		final String publicStaticFinalFlag = isImplementation ? "public static final " : "";
		final String singleWildcard = isJDK50 ? "<?>" : "";
		final String negativeOffsetCorrection = genClass.hasOffsetCorrection()
				? " - " + genClass.getOffsetCorrectionField(null)
				: "";
		final String positiveOffsetCorrection = genClass.hasOffsetCorrection()
				? " + " + genClass.getOffsetCorrectionField(null)
				: "";
		stringBuffer.append(TEXT_1);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderJava" args="parameter:argument"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("argument", parameter);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_XHLrsCwtEd-jc5T-XaRJlg",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		if (isInterface) {
			stringBuffer.append(TEXT_2);
			stringBuffer.append(genPackage.getInterfacePackageName());
			stringBuffer.append(TEXT_3);
		} else {
			stringBuffer.append(TEXT_2);
			stringBuffer.append(genPackage.getClassPackageName());
			stringBuffer.append(TEXT_3);
		}
		stringBuffer.append(TEXT_4);
		genModel.markImportLocation(stringBuffer, genPackage);
		if (isImplementation) {
			genClass.addClassPsuedoImports();
		}
		stringBuffer.append(TEXT_4);
		if (isInterface) {
			stringBuffer.append(TEXT_5);
			stringBuffer.append(genClass.getFormattedName());
			stringBuffer.append(TEXT_6);
			if (genClass.hasDocumentation()) {
				stringBuffer.append(TEXT_7);
				stringBuffer.append(genClass.getDocumentation(genModel.getIndentation(stringBuffer)));
				stringBuffer.append(TEXT_8);
			}
			stringBuffer.append(TEXT_9);
			if (!genClass.getGenFeatures().isEmpty()) {
				stringBuffer.append(TEXT_10);
				for (GenFeature genFeature : genClass.getGenFeatures()) {
					if (!genFeature.isSuppressedGetVisibility()) {
						stringBuffer.append(TEXT_11);
						stringBuffer.append(genClass.getQualifiedInterfaceName());
						stringBuffer.append(TEXT_12);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_13);
						stringBuffer.append(genFeature.getFormattedName());
						stringBuffer.append(TEXT_14);
					}
				}
				stringBuffer.append(TEXT_15);
			}
			stringBuffer.append(TEXT_9);
			if (!genModel.isSuppressEMFMetaData()) {
				stringBuffer.append(TEXT_16);
				stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
				stringBuffer.append(TEXT_17);
				stringBuffer.append(genClass.getClassifierAccessorName());
				stringBuffer.append(TEXT_18);
			}
			if (!genModel.isSuppressEMFModelTags()) {
				boolean first = true;
				for (StringTokenizer stringTokenizer = new StringTokenizer(genClass.getModelInfo(),
						"\n\r"); stringTokenizer.hasMoreTokens();) {
					String modelInfo = stringTokenizer.nextToken();
					if (first) {
						first = false;
						stringBuffer.append(TEXT_19);
						stringBuffer.append(modelInfo);
					} else {
						stringBuffer.append(TEXT_20);
						stringBuffer.append(modelInfo);
					}
				}
				if (first) {
					stringBuffer.append(TEXT_21);
				}
			}
			if (genClass.needsRootExtendsInterfaceExtendsTag()) {
				stringBuffer.append(TEXT_22);
				stringBuffer.append(genModel.getImportedName(genModel.getRootExtendsInterface()));
			}
			stringBuffer.append(TEXT_23);
		} else {
			stringBuffer.append(TEXT_24);
			stringBuffer.append(genClass.getFormattedName());
			stringBuffer.append(TEXT_25);
			if (!genClass.getImplementedGenFeatures().isEmpty()) {
				stringBuffer.append(TEXT_26);
				for (GenFeature genFeature : genClass.getImplementedGenFeatures()) {
					stringBuffer.append(TEXT_11);
					stringBuffer.append(genClass.getQualifiedClassName());
					stringBuffer.append(TEXT_12);
					stringBuffer.append(genFeature.getGetAccessor());
					stringBuffer.append(TEXT_13);
					stringBuffer.append(genFeature.getFormattedName());
					stringBuffer.append(TEXT_14);
				}
				stringBuffer.append(TEXT_27);
			}
			stringBuffer.append(TEXT_28);
		}
		if (isImplementation) {
			stringBuffer.append(TEXT_29);
			if (genClass.isAbstract()) {
				stringBuffer.append(TEXT_30);
			}
			stringBuffer.append(TEXT_31);
			stringBuffer.append(genClass.getClassName());
			stringBuffer.append(genClass.getTypeParameters().trim());
			stringBuffer.append(genClass.getClassExtends());
			stringBuffer.append(genClass.getClassImplements());
		} else {
			stringBuffer.append(TEXT_32);
			stringBuffer.append(genClass.getInterfaceName());
			stringBuffer.append(genClass.getTypeParameters().trim());
			stringBuffer.append(genClass.getInterfaceExtends());
		}
		stringBuffer.append(TEXT_33);
		if (genModel.hasCopyrightField()) {
			stringBuffer.append(TEXT_34);
			stringBuffer.append(publicStaticFinalFlag);
			stringBuffer.append(genModel.getImportedName("java.lang.String"));
			stringBuffer.append(TEXT_35);
			stringBuffer.append(genModel.getCopyrightFieldLiteral());
			stringBuffer.append(TEXT_3);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_4);
		}
		if (isImplementation && genModel.getDriverNumber() != null) {
			stringBuffer.append(TEXT_36);
			stringBuffer.append(genModel.getImportedName("java.lang.String"));
			stringBuffer.append(TEXT_37);
			stringBuffer.append(genModel.getDriverNumber());
			stringBuffer.append(TEXT_38);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_4);
		}
		if (isImplementation && genClass.isJavaIOSerializable()) {
			stringBuffer.append(TEXT_39);
		}
		if (isImplementation && genModel.isVirtualDelegation()) {
			String eVirtualValuesField = genClass.getEVirtualValuesField();
			if (eVirtualValuesField != null) {
				stringBuffer.append(TEXT_40);
				stringBuffer.append(eVirtualValuesField);
				stringBuffer.append(TEXT_41);
			}
			{
				List<String> eVirtualIndexBitFields = genClass.getEVirtualIndexBitFields(new ArrayList<String>());
				if (!eVirtualIndexBitFields.isEmpty()) {
					for (String eVirtualIndexBitField : eVirtualIndexBitFields) {
						stringBuffer.append(TEXT_42);
						stringBuffer.append(eVirtualIndexBitField);
						stringBuffer.append(TEXT_41);
					}
				}
			}
		}
		if (isImplementation && genClass.isModelRoot() && genModel.isBooleanFlagsEnabled()
				&& genModel.getBooleanFlagsReservedBits() == -1) {
			stringBuffer.append(TEXT_43);
			stringBuffer.append(genModel.getBooleanFlagsField());
			stringBuffer.append(TEXT_44);
		}
		if (isImplementation && !genModel.isReflectiveDelegation()) {
			for (GenFeature genFeature : genClass.getDeclaredFieldGenFeatures()) {
				stringBuffer.append(TEXT_4);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Class.Class.declaredFieldGenFeature.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

					InternalPatternContext ictx = (InternalPatternContext) ctx;
					new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
					stringBuffer.setLength(0);

					final Map<String, Object> callParameters = new HashMap<String, Object>();
					callParameters.put("genFeature", genFeature);
					callParameters.put("genClass", genClass);
					callParameters.put("genPackage", genPackage);
					callParameters.put("genModel", genModel);
					callParameters.put("isJDK50", isJDK50);
					callParameters.put("isInterface", isInterface);
					callParameters.put("isImplementation", isImplementation);
					callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
					callParameters.put("singleWildcard", singleWildcard);
					callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
					callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
					CallHelper.executeWithParameterInjection(
							"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0jpGTmJ-Ed-FqczH3ESmRw",
							new ExecutionContext((InternalPatternContext) ctx), callParameters);
					stringBuffer.setLength(0);
				}

				//Class/declaredFieldGenFeature.override.javajetinc
				stringBuffer.append(TEXT_45);
			}
		}
		if (isImplementation && genClass.hasOffsetCorrection() && !genClass.getImplementedGenFeatures().isEmpty()) {
			stringBuffer.append(TEXT_46);
			stringBuffer.append(genClass.getOffsetCorrectionField(null));
			stringBuffer.append(TEXT_47);
			stringBuffer.append(genClass.getQualifiedClassifierAccessor());
			stringBuffer.append(TEXT_48);
			stringBuffer.append(genClass.getImplementedGenFeatures().get(0).getQualifiedFeatureAccessor());
			stringBuffer.append(TEXT_49);
			stringBuffer.append(genClass.getQualifiedFeatureID(genClass.getImplementedGenFeatures().get(0)));
			stringBuffer.append(TEXT_41);
		}
		if (isImplementation && genClass.hasOffsetCorrection() && !genModel.isReflectiveDelegation()) {
			for (GenFeature genFeature : genClass.getImplementedGenFeatures()) {
				GenFeature reverseFeature = genFeature.getReverse();
				if (reverseFeature != null && reverseFeature.getGenClass().hasOffsetCorrection()) {
					stringBuffer.append(TEXT_46);
					stringBuffer.append(genClass.getOffsetCorrectionField(genFeature));
					stringBuffer.append(TEXT_47);
					stringBuffer.append(reverseFeature.getGenClass().getQualifiedClassifierAccessor());
					stringBuffer.append(TEXT_48);
					stringBuffer.append(reverseFeature.getQualifiedFeatureAccessor());
					stringBuffer.append(TEXT_49);
					stringBuffer.append(reverseFeature.getGenClass().getQualifiedFeatureID(reverseFeature));
					stringBuffer.append(TEXT_41);
				}
			}
		}
		if (isImplementation) {
			stringBuffer.append(TEXT_34);
			if (genModel.isPublicConstructors()) {
				stringBuffer.append(TEXT_50);
			} else {
				stringBuffer.append(TEXT_51);
			}
			stringBuffer.append(TEXT_52);
			stringBuffer.append(genClass.getClassName());
			stringBuffer.append(TEXT_53);
			for (GenFeature genFeature : genClass.getFlagGenFeaturesWithDefault()) {
				stringBuffer.append(TEXT_54);
				stringBuffer.append(genClass.getFlagsField(genFeature));
				stringBuffer.append(TEXT_55);
				stringBuffer.append(genFeature.getUpperName());
				stringBuffer.append(TEXT_56);
				if (!genFeature.isBooleanType()) {
					stringBuffer.append(TEXT_57);
				}
				stringBuffer.append(TEXT_3);
			}
			stringBuffer.append(TEXT_58);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_59);
			}
			stringBuffer.append(TEXT_60);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EClass"));
			stringBuffer.append(TEXT_61);
			stringBuffer.append(genClass.getQualifiedClassifierAccessor());
			stringBuffer.append(TEXT_62);
		}
		stringBuffer.append(TEXT_4);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Class.Class.reflectiveDelegation.override" args="genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("genClass", genClass);
			callParameters.put("genPackage", genPackage);
			callParameters.put("genModel", genModel);
			callParameters.put("isJDK50", isJDK50);
			callParameters.put("isInterface", isInterface);
			callParameters.put("isImplementation", isImplementation);
			callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
			callParameters.put("singleWildcard", singleWildcard);
			callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
			callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0kFyMGJ-Ed-FqczH3ESmRw",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		//Class/reflectiveDelegation.override.javajetinc
		new Runnable() {
			public void run() {
				for (GenFeature genFeature : (isImplementation ? genClass.getImplementedGenFeatures()
						: genClass.getDeclaredGenFeatures())) {
					stringBuffer.append(TEXT_4);
					{
						//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Class.Class.genFeature.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

						InternalPatternContext ictx = (InternalPatternContext) ctx;
						new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
						stringBuffer.setLength(0);

						final Map<String, Object> callParameters = new HashMap<String, Object>();
						callParameters.put("genFeature", genFeature);
						callParameters.put("genClass", genClass);
						callParameters.put("genPackage", genPackage);
						callParameters.put("genModel", genModel);
						callParameters.put("isJDK50", isJDK50);
						callParameters.put("isInterface", isInterface);
						callParameters.put("isImplementation", isImplementation);
						callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
						callParameters.put("singleWildcard", singleWildcard);
						callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
						callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
						CallHelper.executeWithParameterInjection(
								"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0kO8IGJ-Ed-FqczH3ESmRw",
								new ExecutionContext((InternalPatternContext) ctx), callParameters);
						stringBuffer.setLength(0);
					}

					//Class/genFeature.override.javajetinc
				} //for
			}
		}.run();
		for (GenOperation genOperation : (isImplementation ? genClass.getImplementedGenOperations()
				: genClass.getDeclaredGenOperations())) {
			stringBuffer.append(TEXT_4);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Class.Class.genOperation.override" args="genOperation:genOperation,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genOperation", genOperation);
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				callParameters.put("isJDK50", isJDK50);
				callParameters.put("isInterface", isInterface);
				callParameters.put("isImplementation", isImplementation);
				callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
				callParameters.put("singleWildcard", singleWildcard);
				callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
				callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
				CallHelper.executeWithParameterInjection(
						"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0tBrwGJ-Ed-FqczH3ESmRw",
						new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class/implementedGenOperation.override.javajetinc
		} //for
		if (isImplementation && !genModel.isReflectiveDelegation()
				&& genClass.implementsAny(genClass.getEInverseAddGenFeatures())) {
			stringBuffer.append(TEXT_63);
			if (genModel.useGenerics()) {
				for (GenFeature genFeature : genClass.getEInverseAddGenFeatures()) {
					if (genFeature.isUncheckedCast(genClass)) {
						stringBuffer.append(TEXT_64);
						break;
					}
				}
			}
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_59);
			}
			stringBuffer.append(TEXT_65);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
			stringBuffer.append(TEXT_66);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
			stringBuffer.append(TEXT_67);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
			stringBuffer.append(TEXT_68);
			stringBuffer.append(negativeOffsetCorrection);
			stringBuffer.append(TEXT_69);
			for (GenFeature genFeature : genClass.getEInverseAddGenFeatures()) {
				stringBuffer.append(TEXT_70);
				stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
				stringBuffer.append(TEXT_71);
				if (genFeature.isListType()) {
					String cast = "(" + genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList")
							+ (!genModel.useGenerics() ? ")"
									: "<" + genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject") + ">)("
											+ genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList")
											+ "<?>)");
					if (genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes()) {
						stringBuffer.append(TEXT_72);
						stringBuffer.append(cast);
						stringBuffer.append(TEXT_73);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
						stringBuffer.append(TEXT_74);
						stringBuffer.append(genFeature.getImportedMapTemplateArguments(genClass));
						stringBuffer.append(TEXT_75);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_76);
					} else {
						stringBuffer.append(TEXT_77);
						stringBuffer.append(cast);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_78);
					}
				} else if (genFeature.isContainer()) {
					stringBuffer.append(TEXT_79);
					if (genFeature.isBasicSet()) {
						stringBuffer.append(TEXT_80);
						stringBuffer.append(genFeature.getAccessorName());
						stringBuffer.append(TEXT_81);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_82);
					} else {
						stringBuffer.append(TEXT_83);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_84);
					}
				} else {
					if (genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
						stringBuffer.append(TEXT_85);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_52);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_86);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_87);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_88);
					} else if (genFeature.isVolatile()
							|| genClass.getImplementingGenModel(genFeature).isDynamicDelegation()) {
						stringBuffer.append(TEXT_85);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_52);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_47);
						if (genFeature.isResolveProxies()) {
							stringBuffer.append(TEXT_89);
							stringBuffer.append(genFeature.getAccessorName());
						} else {
							stringBuffer.append(genFeature.getGetAccessor());
						}
						stringBuffer.append(TEXT_90);
					}
					stringBuffer.append(TEXT_91);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_92);
					if (genFeature.isEffectiveContains()) {
						stringBuffer.append(TEXT_93);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
						stringBuffer.append(TEXT_75);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_94);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(negativeOffsetCorrection);
						stringBuffer.append(TEXT_95);
					} else {
						GenFeature reverseFeature = genFeature.getReverse();
						GenClass targetClass = reverseFeature.getGenClass();
						String reverseOffsetCorrection = targetClass.hasOffsetCorrection()
								? " + " + genClass.getOffsetCorrectionField(reverseFeature)
								: "";
						stringBuffer.append(TEXT_93);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
						stringBuffer.append(TEXT_75);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_96);
						stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
						stringBuffer.append(reverseOffsetCorrection);
						stringBuffer.append(TEXT_97);
						stringBuffer.append(targetClass.getRawImportedInterfaceName());
						stringBuffer.append(TEXT_98);
					}
					stringBuffer.append(TEXT_80);
					stringBuffer.append(genFeature.getAccessorName());
					stringBuffer.append(TEXT_81);
					stringBuffer.append(genFeature.getImportedType(genClass));
					stringBuffer.append(TEXT_82);
				}
			}
			stringBuffer.append(TEXT_99);
			if (genModel.isMinimalReflectiveMethods()) {
				stringBuffer.append(TEXT_100);
			} else {
				stringBuffer.append(TEXT_101);
			}
			stringBuffer.append(TEXT_102);
		}
		if (isImplementation && !genModel.isReflectiveDelegation()
				&& genClass.implementsAny(genClass.getEInverseRemoveGenFeatures())) {
			stringBuffer.append(TEXT_63);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_59);
			}
			stringBuffer.append(TEXT_65);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
			stringBuffer.append(TEXT_103);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
			stringBuffer.append(TEXT_67);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
			stringBuffer.append(TEXT_68);
			stringBuffer.append(negativeOffsetCorrection);
			stringBuffer.append(TEXT_69);
			for (GenFeature genFeature : genClass.getEInverseRemoveGenFeatures()) {
				stringBuffer.append(TEXT_70);
				stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
				stringBuffer.append(TEXT_71);
				if (genFeature.isListType()) {
					if (genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes()) {
						stringBuffer.append(TEXT_72);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
						stringBuffer.append(singleWildcard);
						stringBuffer.append(TEXT_104);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
						stringBuffer.append(TEXT_74);
						stringBuffer.append(genFeature.getImportedMapTemplateArguments(genClass));
						stringBuffer.append(TEXT_75);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_105);
					} else if (genFeature.isWrappedFeatureMapType()) {
						stringBuffer.append(TEXT_72);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
						stringBuffer.append(singleWildcard);
						stringBuffer.append(TEXT_104);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
						stringBuffer.append(TEXT_106);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_107);
					} else {
						stringBuffer.append(TEXT_72);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
						stringBuffer.append(singleWildcard);
						stringBuffer.append(TEXT_75);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_108);
					}
				} else if (genFeature.isContainer() && !genFeature.isBasicSet()) {
					stringBuffer.append(TEXT_109);
					stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
					stringBuffer.append(positiveOffsetCorrection);
					stringBuffer.append(TEXT_84);
				} else if (genFeature.isUnsettable()) {
					stringBuffer.append(TEXT_110);
					stringBuffer.append(genFeature.getAccessorName());
					stringBuffer.append(TEXT_111);
				} else {
					stringBuffer.append(TEXT_80);
					stringBuffer.append(genFeature.getAccessorName());
					stringBuffer.append(TEXT_112);
				}
			}
			stringBuffer.append(TEXT_99);
			if (genModel.isMinimalReflectiveMethods()) {
				stringBuffer.append(TEXT_113);
			} else {
				stringBuffer.append(TEXT_114);
			}
			stringBuffer.append(TEXT_102);
		}
		if (isImplementation && !genModel.isReflectiveDelegation()
				&& genClass.implementsAny(genClass.getEBasicRemoveFromContainerGenFeatures())) {
			stringBuffer.append(TEXT_63);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_59);
			}
			stringBuffer.append(TEXT_65);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
			stringBuffer.append(TEXT_115);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
			stringBuffer.append(TEXT_116);
			stringBuffer.append(negativeOffsetCorrection);
			stringBuffer.append(TEXT_69);
			for (GenFeature genFeature : genClass.getEBasicRemoveFromContainerGenFeatures()) {
				GenFeature reverseFeature = genFeature.getReverse();
				GenClass targetClass = reverseFeature.getGenClass();
				String reverseOffsetCorrection = targetClass.hasOffsetCorrection()
						? " + " + genClass.getOffsetCorrectionField(reverseFeature)
						: "";
				stringBuffer.append(TEXT_70);
				stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
				stringBuffer.append(TEXT_117);
				stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
				stringBuffer.append(reverseOffsetCorrection);
				stringBuffer.append(TEXT_97);
				stringBuffer.append(targetClass.getRawImportedInterfaceName());
				stringBuffer.append(TEXT_98);
			}
			stringBuffer.append(TEXT_99);
			if (genModel.isMinimalReflectiveMethods()) {
				stringBuffer.append(TEXT_118);
			} else {
				stringBuffer.append(TEXT_119);
			}
			stringBuffer.append(TEXT_102);
		}
		if (isImplementation && !genModel.isReflectiveDelegation()
				&& genClass.implementsAny(genClass.getEGetGenFeatures())) {
			stringBuffer.append(TEXT_63);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_59);
			}
			stringBuffer.append(TEXT_120);
			stringBuffer.append(negativeOffsetCorrection);
			stringBuffer.append(TEXT_69);
			for (GenFeature genFeature : genClass.getEGetGenFeatures()) {
				stringBuffer.append(TEXT_70);
				stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
				stringBuffer.append(TEXT_71);
				if (genFeature.isPrimitiveType()) {
					if (isJDK50) {
						stringBuffer.append(TEXT_121);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_90);
					} else if (genFeature.isBooleanType()) {
						stringBuffer.append(TEXT_121);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_122);
					} else {
						stringBuffer.append(TEXT_123);
						stringBuffer.append(genFeature.getObjectType(genClass));
						stringBuffer.append(TEXT_73);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_124);
					}
				} else if (genFeature.isResolveProxies() && !genFeature.isListType()) {
					stringBuffer.append(TEXT_125);
					stringBuffer.append(genFeature.getGetAccessor());
					stringBuffer.append(TEXT_126);
					stringBuffer.append(genFeature.getAccessorName());
					stringBuffer.append(TEXT_90);
				} else if (genFeature.isMapType()) {
					if (genFeature.isEffectiveSuppressEMFTypes()) {
						stringBuffer.append(TEXT_127);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
						stringBuffer.append(TEXT_74);
						stringBuffer.append(genFeature.getImportedMapTemplateArguments(genClass));
						stringBuffer.append(TEXT_75);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_128);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_90);
					} else {
						stringBuffer.append(TEXT_129);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_130);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_131);
					}
				} else if (genFeature.isWrappedFeatureMapType()) {
					stringBuffer.append(TEXT_127);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_106);
					stringBuffer.append(genFeature.getGetAccessor());
					stringBuffer.append(TEXT_132);
					stringBuffer.append(genFeature.getGetAccessor());
					stringBuffer.append(TEXT_90);
				} else if (genFeature.isFeatureMapType()) {
					stringBuffer.append(TEXT_129);
					stringBuffer.append(genFeature.getGetAccessor());
					stringBuffer.append(TEXT_133);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_134);
					stringBuffer.append(genFeature.getGetAccessor());
					stringBuffer.append(TEXT_135);
				} else {
					stringBuffer.append(TEXT_121);
					stringBuffer.append(genFeature.getGetAccessor());
					stringBuffer.append(TEXT_90);
				}
			}
			stringBuffer.append(TEXT_99);
			if (genModel.isMinimalReflectiveMethods()) {
				stringBuffer.append(TEXT_136);
			} else {
				stringBuffer.append(TEXT_137);
			}
			stringBuffer.append(TEXT_102);
		}
		if (isImplementation && !genModel.isReflectiveDelegation()
				&& genClass.implementsAny(genClass.getESetGenFeatures())) {
			stringBuffer.append(TEXT_63);
			if (genModel.useGenerics()) {
				for (GenFeature genFeature : genClass.getESetGenFeatures()) {
					if (genFeature.isUncheckedCast(genClass) && !genFeature.isFeatureMapType()
							&& !genFeature.isMapType()) {
						stringBuffer.append(TEXT_64);
						break;
					}
				}
			}
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_59);
			}
			stringBuffer.append(TEXT_138);
			stringBuffer.append(negativeOffsetCorrection);
			stringBuffer.append(TEXT_69);
			for (GenFeature genFeature : genClass.getESetGenFeatures()) {
				stringBuffer.append(TEXT_70);
				stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
				stringBuffer.append(TEXT_71);
				if (genFeature.isListType()) {
					if (genFeature.isWrappedFeatureMapType()) {
						stringBuffer.append(TEXT_139);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
						stringBuffer.append(TEXT_140);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
						stringBuffer.append(TEXT_106);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_141);
					} else if (genFeature.isFeatureMapType()) {
						stringBuffer.append(TEXT_139);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
						stringBuffer.append(TEXT_134);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_142);
					} else if (genFeature.isMapType()) {
						if (genFeature.isEffectiveSuppressEMFTypes()) {
							stringBuffer.append(TEXT_139);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
							stringBuffer.append(TEXT_143);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
							stringBuffer.append(TEXT_74);
							stringBuffer.append(genFeature.getImportedMapTemplateArguments(genClass));
							stringBuffer.append(TEXT_75);
							stringBuffer.append(genFeature.getGetAccessor());
							stringBuffer.append(TEXT_144);
						} else {
							stringBuffer.append(TEXT_139);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
							stringBuffer.append(TEXT_145);
							stringBuffer.append(genFeature.getGetAccessor());
							stringBuffer.append(TEXT_142);
						}
					} else {
						stringBuffer.append(TEXT_85);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_146);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_147);
						stringBuffer.append(genModel.getImportedName("java.util.Collection"));
						if (isJDK50) {
							stringBuffer.append(TEXT_148);
							stringBuffer.append(genFeature.getListItemType(genClass));
							stringBuffer.append(TEXT_149);
						}
						stringBuffer.append(TEXT_150);
					}
				} else if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_151);
					stringBuffer.append(genFeature.getAccessorName());
					stringBuffer.append(TEXT_152);
					stringBuffer.append(genFeature.getObjectType(genClass));
					stringBuffer.append(TEXT_153);
					stringBuffer.append(genFeature.getPrimitiveValueFunction());
					stringBuffer.append(TEXT_124);
				} else {
					if (genFeature.getTypeGenDataType() == null || !genFeature.getTypeGenDataType().isObjectType()
							|| !genFeature.getRawType().equals(genFeature.getType(genClass))) {
						stringBuffer.append(TEXT_154);
						if (!genFeature.hasGenericType()) {
							stringBuffer.append(TEXT_155);
							stringBuffer.append(genFeature.getObjectType(genClass));
						}
						stringBuffer.append(TEXT_156);
						stringBuffer.append(genFeature.getAccessorName());
						stringBuffer.append(TEXT_81);
						stringBuffer.append(genFeature.getObjectType(genClass));
						stringBuffer.append(TEXT_157);
					} else {
						stringBuffer.append(TEXT_158);
						stringBuffer.append(genFeature.getAccessorName());
						stringBuffer.append(TEXT_159);
					}
				}
				stringBuffer.append(TEXT_160);
			}
			stringBuffer.append(TEXT_99);
			if (genModel.isMinimalReflectiveMethods()) {
				stringBuffer.append(TEXT_161);
			} else {
				stringBuffer.append(TEXT_162);
			}
			stringBuffer.append(TEXT_102);
		}
		if (isImplementation && !genModel.isReflectiveDelegation()
				&& genClass.implementsAny(genClass.getEUnsetGenFeatures())) {
			stringBuffer.append(TEXT_4);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Class.Class.eUnset.override" args="genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				callParameters.put("isJDK50", isJDK50);
				callParameters.put("isInterface", isInterface);
				callParameters.put("isImplementation", isImplementation);
				callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
				callParameters.put("singleWildcard", singleWildcard);
				callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
				callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
				CallHelper.executeWithParameterInjection(
						"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0uN-kGJ-Ed-FqczH3ESmRw",
						new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class/eUnset.override.javajetinc
		}
		if (isImplementation && !genModel.isReflectiveDelegation()
				&& genClass.implementsAny(genClass.getEIsSetGenFeatures())) {
			stringBuffer.append(TEXT_4);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Class.Class.eIsSet.override" args="genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				callParameters.put("isJDK50", isJDK50);
				callParameters.put("isInterface", isInterface);
				callParameters.put("isImplementation", isImplementation);
				callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
				callParameters.put("singleWildcard", singleWildcard);
				callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
				callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
				CallHelper.executeWithParameterInjection(
						"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0uXvkGJ-Ed-FqczH3ESmRw",
						new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class/eIsSet.override.javajetinc
		}
		if (isImplementation && (!genClass.getMixinGenFeatures().isEmpty()
				|| genClass.hasOffsetCorrection() && !genClass.getGenFeatures().isEmpty())) {
			if (!genClass.getMixinGenFeatures().isEmpty()) {
				stringBuffer.append(TEXT_63);
				if (genModel.useClassOverrideAnnotation()) {
					stringBuffer.append(TEXT_59);
				}
				stringBuffer.append(TEXT_163);
				stringBuffer.append(singleWildcard);
				stringBuffer.append(TEXT_164);
				for (GenClass mixinGenClass : genClass.getMixinGenClasses()) {
					stringBuffer.append(TEXT_165);
					stringBuffer.append(mixinGenClass.getRawImportedInterfaceName());
					stringBuffer.append(TEXT_166);
					stringBuffer.append(negativeOffsetCorrection);
					stringBuffer.append(TEXT_167);
					for (GenFeature genFeature : mixinGenClass.getGenFeatures()) {
						stringBuffer.append(TEXT_168);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(TEXT_169);
						stringBuffer.append(mixinGenClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(TEXT_3);
					}
					stringBuffer.append(TEXT_170);
				}
				stringBuffer.append(TEXT_171);
			}
			stringBuffer.append(TEXT_172);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_59);
			}
			stringBuffer.append(TEXT_173);
			stringBuffer.append(singleWildcard);
			stringBuffer.append(TEXT_164);
			for (GenClass mixinGenClass : genClass.getMixinGenClasses()) {
				stringBuffer.append(TEXT_165);
				stringBuffer.append(mixinGenClass.getRawImportedInterfaceName());
				stringBuffer.append(TEXT_174);
				for (GenFeature genFeature : mixinGenClass.getGenFeatures()) {
					stringBuffer.append(TEXT_168);
					stringBuffer.append(mixinGenClass.getQualifiedFeatureID(genFeature));
					stringBuffer.append(TEXT_169);
					stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
					stringBuffer.append(positiveOffsetCorrection);
					stringBuffer.append(TEXT_3);
				}
				stringBuffer.append(TEXT_170);
			}
			if (genClass.hasOffsetCorrection() && !genClass.getGenFeatures().isEmpty()) {
				stringBuffer.append(TEXT_165);
				stringBuffer.append(genClass.getRawImportedInterfaceName());
				stringBuffer.append(TEXT_175);
				stringBuffer.append(negativeOffsetCorrection);
				stringBuffer.append(TEXT_167);
				for (GenFeature genFeature : genClass.getGenFeatures()) {
					stringBuffer.append(TEXT_168);
					stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
					stringBuffer.append(TEXT_169);
					stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
					stringBuffer.append(positiveOffsetCorrection);
					stringBuffer.append(TEXT_3);
				}
				stringBuffer.append(TEXT_170);
			}
			stringBuffer.append(TEXT_176);
		}
		if (isImplementation && genModel.isVirtualDelegation()) {
			String eVirtualValuesField = genClass.getEVirtualValuesField();
			if (eVirtualValuesField != null) {
				stringBuffer.append(TEXT_63);
				if (genModel.useClassOverrideAnnotation()) {
					stringBuffer.append(TEXT_59);
				}
				stringBuffer.append(TEXT_177);
				stringBuffer.append(eVirtualValuesField);
				stringBuffer.append(TEXT_178);
				if (genModel.useClassOverrideAnnotation()) {
					stringBuffer.append(TEXT_59);
				}
				stringBuffer.append(TEXT_179);
				stringBuffer.append(eVirtualValuesField);
				stringBuffer.append(TEXT_180);
			}
			{
				List<String> eVirtualIndexBitFields = genClass.getEVirtualIndexBitFields(new ArrayList<String>());
				if (!eVirtualIndexBitFields.isEmpty()) {
					List<String> allEVirtualIndexBitFields = genClass
							.getAllEVirtualIndexBitFields(new ArrayList<String>());
					stringBuffer.append(TEXT_63);
					if (genModel.useClassOverrideAnnotation()) {
						stringBuffer.append(TEXT_59);
					}
					stringBuffer.append(TEXT_181);
					for (int i = 0; i < allEVirtualIndexBitFields.size(); i++) {
						stringBuffer.append(TEXT_70);
						stringBuffer.append(i);
						stringBuffer.append(TEXT_182);
						stringBuffer.append(allEVirtualIndexBitFields.get(i));
						stringBuffer.append(TEXT_3);
					}
					stringBuffer.append(TEXT_183);
					if (genModel.useClassOverrideAnnotation()) {
						stringBuffer.append(TEXT_59);
					}
					stringBuffer.append(TEXT_184);
					for (int i = 0; i < allEVirtualIndexBitFields.size(); i++) {
						stringBuffer.append(TEXT_70);
						stringBuffer.append(i);
						stringBuffer.append(TEXT_185);
						stringBuffer.append(allEVirtualIndexBitFields.get(i));
						stringBuffer.append(TEXT_186);
					}
					stringBuffer.append(TEXT_187);
				}
			}
		}
		if (!genClass.hasImplementedToStringGenOperation() && isImplementation && !genModel.isReflectiveDelegation()
				&& !genModel.isDynamicDelegation() && !genClass.getToStringGenFeatures().isEmpty()) {
			stringBuffer.append(TEXT_63);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_59);
			}
			stringBuffer.append(TEXT_188);
			{
				boolean first = true;
				for (GenFeature genFeature : genClass.getToStringGenFeatures()) {
					if (first) {
						first = false;
						stringBuffer.append(TEXT_189);
						stringBuffer.append(genFeature.getName());
						stringBuffer.append(TEXT_190);
						stringBuffer.append(genModel.getNonNLS());
					} else {
						stringBuffer.append(TEXT_191);
						stringBuffer.append(genFeature.getName());
						stringBuffer.append(TEXT_190);
						stringBuffer.append(genModel.getNonNLS());
					}
					if (genFeature.isUnsettable() && !genFeature.isListType()) {
						if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
							stringBuffer.append(TEXT_192);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_193);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_194);
							stringBuffer.append(genModel.getNonNLS());
						} else {
							if (genClass.isFlag(genFeature)) {
								if (genFeature.isBooleanType()) {
									stringBuffer.append(TEXT_195);
									if (genClass.isESetFlag(genFeature)) {
										stringBuffer.append(TEXT_73);
										stringBuffer.append(genClass.getESetFlagsField(genFeature));
										stringBuffer.append(TEXT_196);
										stringBuffer.append(genFeature.getUpperName());
										stringBuffer.append(TEXT_197);
									} else {
										stringBuffer.append(genFeature.getUncapName());
										stringBuffer.append(TEXT_198);
									}
									stringBuffer.append(TEXT_199);
									stringBuffer.append(genClass.getFlagsField(genFeature));
									stringBuffer.append(TEXT_196);
									stringBuffer.append(genFeature.getUpperName());
									stringBuffer.append(TEXT_200);
									stringBuffer.append(genModel.getNonNLS());
								} else {
									stringBuffer.append(TEXT_195);
									if (genClass.isESetFlag(genFeature)) {
										stringBuffer.append(TEXT_73);
										stringBuffer.append(genClass.getESetFlagsField(genFeature));
										stringBuffer.append(TEXT_196);
										stringBuffer.append(genFeature.getUpperName());
										stringBuffer.append(TEXT_197);
									} else {
										stringBuffer.append(genFeature.getUncapName());
										stringBuffer.append(TEXT_198);
									}
									stringBuffer.append(TEXT_201);
									stringBuffer.append(genFeature.getUpperName());
									stringBuffer.append(TEXT_202);
									stringBuffer.append(genClass.getFlagsField(genFeature));
									stringBuffer.append(TEXT_196);
									stringBuffer.append(genFeature.getUpperName());
									stringBuffer.append(TEXT_203);
									stringBuffer.append(genFeature.getUpperName());
									stringBuffer.append(TEXT_204);
									stringBuffer.append(genModel.getNonNLS());
								}
							} else {
								stringBuffer.append(TEXT_195);
								if (genClass.isESetFlag(genFeature)) {
									stringBuffer.append(TEXT_73);
									stringBuffer.append(genClass.getESetFlagsField(genFeature));
									stringBuffer.append(TEXT_196);
									stringBuffer.append(genFeature.getUpperName());
									stringBuffer.append(TEXT_197);
								} else {
									stringBuffer.append(genFeature.getUncapName());
									stringBuffer.append(TEXT_198);
								}
								stringBuffer.append(TEXT_201);
								stringBuffer.append(genFeature.getSafeName());
								stringBuffer.append(TEXT_205);
								stringBuffer.append(genModel.getNonNLS());
							}
						}
					} else {
						if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
							stringBuffer.append(TEXT_206);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							if (!genFeature.isListType() && !genFeature.isReferenceType()) {
								stringBuffer.append(TEXT_97);
								stringBuffer.append(genFeature.getEDefault());
							}
							stringBuffer.append(TEXT_207);
						} else {
							if (genClass.isFlag(genFeature)) {
								if (genFeature.isBooleanType()) {
									stringBuffer.append(TEXT_208);
									stringBuffer.append(genClass.getFlagsField(genFeature));
									stringBuffer.append(TEXT_196);
									stringBuffer.append(genFeature.getUpperName());
									stringBuffer.append(TEXT_209);
								} else {
									stringBuffer.append(TEXT_210);
									stringBuffer.append(genFeature.getUpperName());
									stringBuffer.append(TEXT_202);
									stringBuffer.append(genClass.getFlagsField(genFeature));
									stringBuffer.append(TEXT_196);
									stringBuffer.append(genFeature.getUpperName());
									stringBuffer.append(TEXT_203);
									stringBuffer.append(genFeature.getUpperName());
									stringBuffer.append(TEXT_211);
								}
							} else {
								stringBuffer.append(TEXT_210);
								stringBuffer.append(genFeature.getSafeName());
								stringBuffer.append(TEXT_88);
							}
						}
					}
				}
			}
			stringBuffer.append(TEXT_212);
		}
		if (isImplementation && genClass.isMapEntry()) {
			GenFeature keyFeature = genClass.getMapEntryKeyFeature();
			GenFeature valueFeature = genClass.getMapEntryValueFeature();
			String objectType = genModel.getImportedName("java.lang.Object");
			String keyType = isJDK50 ? keyFeature.getObjectType(genClass) : objectType;
			String valueType = isJDK50 ? valueFeature.getObjectType(genClass) : objectType;
			String eMapType = genModel.getImportedName("org.eclipse.emf.common.util.EMap")
					+ (isJDK50 ? "<" + keyType + ", " + valueType + ">" : "");
			stringBuffer.append(TEXT_213);
			stringBuffer.append(objectType);
			stringBuffer.append(TEXT_214);
			stringBuffer.append(keyType);
			stringBuffer.append(TEXT_215);
			if (!isJDK50 && keyFeature.isPrimitiveType()) {
				stringBuffer.append(TEXT_216);
				stringBuffer.append(keyFeature.getObjectType(genClass));
				stringBuffer.append(TEXT_217);
			} else {
				stringBuffer.append(TEXT_218);
			}
			stringBuffer.append(TEXT_219);
			stringBuffer.append(keyType);
			stringBuffer.append(TEXT_220);
			if (keyFeature.isListType()) {
				stringBuffer.append(TEXT_221);
				if (!genModel.useGenerics()) {
					stringBuffer.append(TEXT_73);
					stringBuffer.append(genModel.getImportedName("java.util.Collection"));
					stringBuffer.append(TEXT_75);
				}
				stringBuffer.append(TEXT_222);
			} else if (isJDK50) {
				stringBuffer.append(TEXT_223);
			} else if (keyFeature.isPrimitiveType()) {
				stringBuffer.append(TEXT_224);
				stringBuffer.append(keyFeature.getObjectType(genClass));
				stringBuffer.append(TEXT_225);
				stringBuffer.append(keyFeature.getPrimitiveValueFunction());
				stringBuffer.append(TEXT_124);
			} else {
				stringBuffer.append(TEXT_226);
				stringBuffer.append(keyFeature.getImportedType(genClass));
				stringBuffer.append(TEXT_227);
			}
			stringBuffer.append(TEXT_228);
			stringBuffer.append(valueType);
			stringBuffer.append(TEXT_229);
			if (!isJDK50 && valueFeature.isPrimitiveType()) {
				stringBuffer.append(TEXT_216);
				stringBuffer.append(valueFeature.getObjectType(genClass));
				stringBuffer.append(TEXT_230);
			} else {
				stringBuffer.append(TEXT_231);
			}
			stringBuffer.append(TEXT_228);
			stringBuffer.append(valueType);
			stringBuffer.append(TEXT_232);
			stringBuffer.append(valueType);
			stringBuffer.append(TEXT_233);
			stringBuffer.append(valueType);
			stringBuffer.append(TEXT_234);
			if (valueFeature.isListType()) {
				stringBuffer.append(TEXT_235);
				if (!genModel.useGenerics()) {
					stringBuffer.append(TEXT_73);
					stringBuffer.append(genModel.getImportedName("java.util.Collection"));
					stringBuffer.append(TEXT_75);
				}
				stringBuffer.append(TEXT_236);
			} else if (isJDK50) {
				stringBuffer.append(TEXT_237);
			} else if (valueFeature.isPrimitiveType()) {
				stringBuffer.append(TEXT_238);
				stringBuffer.append(valueFeature.getObjectType(genClass));
				stringBuffer.append(TEXT_239);
				stringBuffer.append(valueFeature.getPrimitiveValueFunction());
				stringBuffer.append(TEXT_124);
			} else {
				stringBuffer.append(TEXT_240);
				stringBuffer.append(valueFeature.getImportedType(genClass));
				stringBuffer.append(TEXT_241);
			}
			stringBuffer.append(TEXT_242);
			if (genModel.useGenerics()) {
				stringBuffer.append(TEXT_64);
			}
			stringBuffer.append(TEXT_65);
			stringBuffer.append(eMapType);
			stringBuffer.append(TEXT_243);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
			stringBuffer.append(TEXT_244);
			stringBuffer.append(eMapType);
			stringBuffer.append(TEXT_245);
		}
		stringBuffer.append(TEXT_4);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Class.Class.insert" args="genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("genClass", genClass);
			callParameters.put("genPackage", genPackage);
			callParameters.put("genModel", genModel);
			callParameters.put("isJDK50", isJDK50);
			callParameters.put("isInterface", isInterface);
			callParameters.put("isImplementation", isImplementation);
			callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
			callParameters.put("singleWildcard", singleWildcard);
			callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
			callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0ug5gGJ-Ed-FqczH3ESmRw",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_246);
		stringBuffer.append(isInterface ? " " + genClass.getInterfaceName() : genClass.getClassName());
		// TODO fix the space above
		genModel.emitSortedImports();
		stringBuffer.append(TEXT_4);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}
}