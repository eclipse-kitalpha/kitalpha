//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.emde.egf.model;

import org.polarsys.kitalpha.emde.egf.helper.*;
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

public class ResourceClass extends org.eclipse.egf.emf.pattern.model.ResourceClass {
	protected static String nl;

	public static synchronized ResourceClass create(String lineSeparator) {
		nl = lineSeparator;
		ResourceClass result = new ResourceClass();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "package ";
	protected final String TEXT_3 = ";" + NL;
	protected final String TEXT_4 = NL + NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL
			+ " * The <b>Resource </b> associated with the package." + NL + " * <!-- end-user-doc -->" + NL
			+ " * @see ";
	protected final String TEXT_5 = NL + " * ";
	protected final String TEXT_6 = NL + " * @generated" + NL + " */";
	protected final String TEXT_7 = NL + "@Deprecated";
	protected final String TEXT_8 = NL + "public class ";
	protected final String TEXT_9 = " extends ";
	protected final String TEXT_10 = NL + "{";
	protected final String TEXT_11 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
	protected final String TEXT_12 = " copyright = ";
	protected final String TEXT_13 = ";";
	protected final String TEXT_14 = NL;
	protected final String TEXT_15 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */  " + NL + "\tprivate ";
	protected final String TEXT_16 = "<Object> lookupTable = new ";
	protected final String TEXT_17 = "<Object>();" + NL + "  " + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */  " + NL + "\tprivate ";
	protected final String TEXT_18 = " parserPool = new ";
	protected final String TEXT_19 = "();  " + NL + "  " + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */  " + NL + "\tprivate ";
	protected final String TEXT_20 = "<Object, Object> nameToFeatureMap = new ";
	protected final String TEXT_21 = "<Object, Object>();" + NL + "\t";
	protected final String TEXT_22 = NL + "\t/**" + NL + "\t * Creates an instance of the resource." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL
			+ "\t * @param uri the URI of the new resource." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
	protected final String TEXT_23 = "(URI uri)" + NL + "\t{" + NL + "\t\tsuper(uri);" + NL + "\t}\t";
	protected final String TEXT_24 = NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_25 = NL + "\t@Override";
	protected final String TEXT_26 = NL + "\tprotected ";
	protected final String TEXT_27 = " createXMLSave() {";
	protected final String TEXT_28 = NL + "\t\treturn new ";
	protected final String TEXT_29 = "(createXMLHelper());";
	protected final String TEXT_30 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_31 = " createXMLHelper() {";
	protected final String TEXT_32 = "(this);";
	protected final String TEXT_33 = "\t" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->"
			+ NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_34 = " createXMLLoad() {";
	protected final String TEXT_35 = "((";
	protected final String TEXT_36 = ") createXMLHelper());";
	protected final String TEXT_37 = "\t" + NL + "\t}\t";
	protected final String TEXT_38 = NL + "\tprotected boolean useIDAttributes() {" + NL + "\t\treturn false;" + NL
			+ "\t}";
	protected final String TEXT_39 = NL + "\tprotected boolean useUUIDs() {" + NL + "\t\treturn true;" + NL + "\t}";
	protected final String TEXT_40 = NL + "\tprotected void init() {" + NL + "\t\tsuper.init();";
	protected final String TEXT_41 = NL + "\t\tsetTrackingModification(true);";
	protected final String TEXT_42 = NL + "\t\tsetEncoding(\"UTF-8\"); ";
	protected final String TEXT_43 = NL + "\t\tsetXMIVersion(\"2.1\"); ";
	protected final String TEXT_44 = NL + "\t\t// Save Options" + NL + "\t\tgetDefaultSaveOptions().put(";
	protected final String TEXT_45 = ".OPTION_CONFIGURATION_CACHE, Boolean.TRUE);" + NL
			+ "\t\tgetDefaultSaveOptions().put(";
	protected final String TEXT_46 = ".OPTION_USE_CACHED_LOOKUP_TABLE, lookupTable);    " + NL
			+ "\t\tgetDefaultSaveOptions().put(";
	protected final String TEXT_47 = ".OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);" + NL
			+ "\t\tgetDefaultSaveOptions().put(";
	protected final String TEXT_48 = ".OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);"
			+ NL + "\t\tgetDefaultSaveOptions().put(";
	protected final String TEXT_49 = ".OPTION_SAVE_TYPE_INFORMATION, new ";
	protected final String TEXT_50 = "() {" + NL + "\t\t\tpublic boolean shouldSaveType(";
	protected final String TEXT_51 = " objectType, ";
	protected final String TEXT_52 = " featureType, ";
	protected final String TEXT_53 = " feature) {" + NL + "\t\t\t\treturn objectType != featureType && objectType != ";
	protected final String TEXT_54 = ".Literals.ANY_TYPE;" + NL + "\t\t\t}" + NL + "" + NL
			+ "\t\t\tpublic boolean shouldSaveType(";
	protected final String TEXT_55 = " objectType, EClass featureType, ";
	protected final String TEXT_56 = ".Literals.ANY_TYPE;" + NL + "\t\t\t}" + NL + "\t\t});" + NL
			+ "\t\tgetDefaultSaveOptions().put(";
	protected final String TEXT_57 = ".OPTION_LINE_WIDTH, new Integer(80));" + NL + "\t\tgetDefaultSaveOptions().put(";
	protected final String TEXT_58 = ".OPTION_URI_HANDLER, new ";
	protected final String TEXT_59 = ".PlatformSchemeAware());" + NL + "\t\tgetDefaultSaveOptions().put(";
	protected final String TEXT_60 = ".OPTION_EXTENDED_META_DATA, Boolean.TRUE);";
	protected final String TEXT_61 = NL + "\t\tgetDefaultSaveOptions().put(";
	protected final String TEXT_62 = ".OPTION_USE_XMI_TYPE, Boolean.TRUE);";
	protected final String TEXT_63 = "\t\t\t\t\t\t        " + NL + "\t\t// Load Options" + NL
			+ "\t\tgetDefaultLoadOptions().put(";
	protected final String TEXT_64 = ".OPTION_DEFER_ATTACHMENT, Boolean.FALSE);" + NL
			+ "\t\tgetDefaultLoadOptions().put(";
	protected final String TEXT_65 = ".OPTION_DEFER_IDREF_RESOLUTION, Boolean.FALSE);" + NL
			+ "\t\tgetDefaultLoadOptions().put(";
	protected final String TEXT_66 = ".OPTION_USE_DEPRECATED_METHODS, Boolean.TRUE);" + NL
			+ "\t\tgetDefaultLoadOptions().put(";
	protected final String TEXT_67 = ".OPTION_USE_PARSER_POOL, parserPool);" + NL + "\t\tgetDefaultLoadOptions().put(";
	protected final String TEXT_68 = ".OPTION_USE_XML_NAME_TO_FEATURE_MAP, nameToFeatureMap);" + NL
			+ "\t\tgetDefaultLoadOptions().put(";
	protected final String TEXT_69 = ".OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);" + NL
			+ "\t\tgetDefaultLoadOptions().put(";
	protected final String TEXT_70 = ".OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);" + NL
			+ "\t\tgetDefaultLoadOptions().put(";
	protected final String TEXT_71 = ".OPTION_EXTENDED_META_DATA, Boolean.TRUE);\t\t" + NL + "\t}" + NL + "\t" + NL
			+ "\t" + NL + "\t// override to integrate the bug fix" + NL
			+ "\t// https://bugs.eclipse.org/bugs/show_bug.cgi?id=412753. The bug has been" + NL
			+ "\t// resolved in EMF 2.9.1 and 2.10" + NL + "\t";
	protected final String TEXT_72 = NL + "\tprotected void detachedHelper(";
	protected final String TEXT_73 = " eObject) {" + NL + "\t\tif (useIDs() && unloadingContents == null) {" + NL
			+ "\t\t\tif (useUUIDs()) {" + NL + "\t\t\t\tDETACHED_EOBJECT_TO_ID_MAP.put(eObject, getID(eObject));" + NL
			+ "\t\t\t}" + NL + "" + NL + "\t\t\tif (idToEObjectMap != null && eObjectToIDMap != null) {" + NL
			+ "\t\t\t\tsetID(eObject, null);" + NL + "\t\t\t}" + NL + "\t\t}" + NL
			+ "\t\tresourceImplDetachedHelper(eObject);" + NL + "\t}" + NL + "" + NL + "\t// Duplicated from" + NL
			+ "\t// org.eclipse.emf.ecore.resource.impl.ResourceImpl.detachedHelper(EObject)" + NL
			+ "\tprivate void resourceImplDetachedHelper(";
	protected final String TEXT_74 = " eObject) {" + NL + "\t\tMap<String, EObject> map = getIntrinsicIDToEObjectMap();"
			+ NL + "\t\tif (map != null) {" + NL + "\t\t\tString id = ";
	protected final String TEXT_75 = ".getID(eObject);" + NL + "\t\t\tif (id != null) {" + NL
			+ "\t\t\t\tmap.remove(id);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL
			+ "\t\tif (isTrackingModification()) {" + NL
			+ "\t\t\teObject.eAdapters().remove(modificationTrackingAdapter);" + NL + "\t\t}" + NL + "\t}" + NL + "\t"
			+ NL;
	protected final String TEXT_76 = NL + "\t/**" + NL
			+ "\t * A load option that turns of the use of the generate data converters." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */"
			+ NL + "\tpublic static final String OPTION_USE_DATA_CONVERTER = \"USE_DATA_CONVERTER\"; ";
	protected final String TEXT_77 = NL + "\tpublic void doLoad(InputStream inputStream, ";
	protected final String TEXT_78 = " options) throws IOException" + NL + "\t{" + NL
			+ "\t\tif (options != null && Boolean.TRUE.equals(options.get(OPTION_USE_DATA_CONVERTER)))" + NL + "\t\t{"
			+ NL + "\t\t  getContents().add" + NL + "\t\t\t (load" + NL + "\t\t\t\t (new InputSource(inputStream), "
			+ NL + "\t\t\t\t  (";
	protected final String TEXT_79 = ")options.get(XMLResource.OPTION_PARSER_FEATURES), " + NL + "\t\t\t\t  (";
	protected final String TEXT_80 = ")options.get(XMLResource.OPTION_PARSER_PROPERTIES), " + NL
			+ "\t\t\t\t  Boolean.TRUE.equals(options.get(XMLResource.OPTION_USE_LEXICAL_HANDLER))).eContainer());" + NL
			+ "\t\t}" + NL + "\t\telse" + NL + "\t\t{  " + NL + "\t\t\tsuper.doLoad(inputStream, options);" + NL
			+ "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_81 = NL + "\tpublic void doLoad(InputSource inputSource, ";
	protected final String TEXT_82 = " options) throws IOException" + NL + "\t{" + NL
			+ "\t\tif (options != null && Boolean.TRUE.equals(options.get(OPTION_USE_DATA_CONVERTER)))" + NL + "\t\t{"
			+ NL + "\t\t  getContents().add" + NL + "\t\t\t (load" + NL + "\t\t\t\t (inputSource," + NL + "\t\t\t\t  (";
	protected final String TEXT_83 = ")options.get(XMLResource.OPTION_PARSER_PROPERTIES), " + NL
			+ "\t\t\t\t  Boolean.TRUE.equals(options.get(XMLResource.OPTION_USE_LEXICAL_HANDLER))).eContainer());" + NL
			+ "\t\t}" + NL + "\t\telse" + NL + "\t\t{  " + NL + "\t\t\tsuper.doLoad(inputSource, options);" + NL
			+ "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL
			+ "\tprotected static final XMLParserPool parserPool = new XMLParserPoolImpl();" + NL + "" + NL + "\t/**"
			+ NL + "\t * Loads an instance from the input." + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @param inputSource the input from which to load." + NL
			+ "\t * @param features a map of the parser features and their values." + NL
			+ "\t * @param properties a map of a parser properties and their values." + NL
			+ "\t * @param useLexicalHandler whether a lexical handler should be used during loading." + NL
			+ "\t * @return the root object; for the case of a document root, the child of that document root is return."
			+ NL + "\t * @throws ParserConfigurationException" + NL + "\t * @throws SAXException" + NL
			+ "\t * @generated" + NL + "\t */" + NL + "\tpublic static EObject load(InputSource inputSource, ";
	protected final String TEXT_84 = " features, ";
	protected final String TEXT_85 = " properties, boolean useLexicalHandler) throws IOException" + NL + "\t{" + NL
			+ "\t\t";
	protected final String TEXT_86 = " requiredFeatures = new ";
	protected final String TEXT_87 = "();" + NL
			+ "\t\trequiredFeatures.put(\"http://xml.org/sax/features/namespaces\", Boolean.TRUE); ";
	protected final String TEXT_88 = " " + NL + "\t\tif (features != null)" + NL + "\t\t{" + NL
			+ "\t\t\trequiredFeatures.putAll(features);" + NL + "\t\t}" + NL + "\t\t" + NL
			+ "\t\tif (properties == null)" + NL + "\t\t{" + NL + "\t\t\tproperties = Collections.";
	protected final String TEXT_89 = "emptyMap()";
	protected final String TEXT_90 = "EMPTY_MAP";
	protected final String TEXT_91 = ";" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tSAXParser saxParser = null;" + NL
			+ "\t\ttry" + NL + "\t\t{" + NL
			+ "\t\t\tsaxParser = parserPool.get(requiredFeatures, properties, useLexicalHandler);" + NL
			+ "\t\t\tfinal FrameFactory.DocumentRootStackFrame documentRoot = FrameFactory.INSTANCE.pushDocumentRoot(null, null);"
			+ NL + "\t\t\tXMLTypeResourceImpl.Handler handler = new XMLTypeResourceImpl.Handler(documentRoot);" + NL
			+ "\t\t\tsaxParser.parse(inputSource, handler);";
	protected final String TEXT_92 = NL
			+ "\t\t\treturn (EObject)((EObject)FrameFactory.INSTANCE.popDocumentRoot(documentRoot)).eContents().get(0);";
	protected final String TEXT_93 = NL
			+ "\t\t\treturn FrameFactory.INSTANCE.popDocumentRoot(documentRoot).eContents().get(0);";
	protected final String TEXT_94 = NL + "\t\t}" + NL + "\t\tcatch (Exception exception)" + NL + "\t\t{" + NL
			+ "\t\t\tthrow new IOWrappedException(exception);" + NL + "\t\t}" + NL + "\t\tfinally" + NL + "\t\t{" + NL
			+ "\t\t\tparserPool.release(saxParser, requiredFeatures, properties, useLexicalHandler);" + NL + "\t\t}"
			+ NL + "\t}" + NL;
	protected final String TEXT_95 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL
			+ "\tpublic final static class FrameFactory" + NL + "\t{" + NL + "\t\t/**" + NL
			+ "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL
			+ "\t\t */" + NL + "\t\tpublic static final FrameFactory INSTANCE = new FrameFactory();" + NL + "\t";
	protected final String TEXT_96 = NL + "\t\t/**" + NL + "\t\t * <!-- begin-user-doc -->" + NL
			+ "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
	protected final String TEXT_97 = "StackFrame ";
	protected final String TEXT_98 = " ";
	protected final String TEXT_99 = NL + "\t\t/**" + NL + "\t\t * <!-- begin-user-doc -->" + NL
			+ "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
	protected final String TEXT_100 = "StackFrame push";
	protected final String TEXT_101 = "(";
	protected final String TEXT_102 = " previous, Attributes attributes)" + NL + "\t\t{" + NL + "\t\t\t ";
	protected final String TEXT_103 = "StackFrame result";
	protected final String TEXT_104 = " = ";
	protected final String TEXT_105 = " == null ? new ";
	protected final String TEXT_106 = "StackFrame() : ";
	protected final String TEXT_107 = ";" + NL + "\t\t\t ";
	protected final String TEXT_108 = " = null;" + NL + "\t\t\t result";
	protected final String TEXT_109 = ".pushOnto(previous);" + NL + "\t\t\t result";
	protected final String TEXT_110 = ".handleAttributes(attributes);" + NL + "\t\t\t return result";
	protected final String TEXT_111 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL
			+ "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL
			+ "\t\t */" + NL + "\t\tpublic ";
	protected final String TEXT_112 = " pop";
	protected final String TEXT_113 = ")" + NL + "\t\t{" + NL + "\t\t\t";
	protected final String TEXT_114 = " result";
	protected final String TEXT_115 = "Value = ";
	protected final String TEXT_116 = ".pop";
	protected final String TEXT_117 = "();" + NL + "\t\t\tthis.";
	protected final String TEXT_118 = ";" + NL + "\t\t\treturn result";
	protected final String TEXT_119 = "Value;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL
			+ "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL
			+ "\t\t */" + NL + "\t\tpublic static class ";
	protected final String TEXT_120 = "StackFrame extends ";
	protected final String TEXT_121 = NL + "\t\t{" + NL + "\t\t\t/**" + NL + "\t\t\t * <!-- begin-user-doc -->" + NL
			+ "\t\t\t * <!-- end-user-doc -->" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL
			+ "\t\t\tprotected ";
	protected final String TEXT_122 = " the";
	protected final String TEXT_123 = ";" + NL + "\t\t";
	protected final String TEXT_124 = NL + "\t\t\t/**" + NL + "\t\t\t * <!-- begin-user-doc -->" + NL
			+ "\t\t\t * <!-- end-user-doc -->" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL
			+ "\t\t\tprotected ";
	protected final String TEXT_125 = ".FrameFactory.";
	protected final String TEXT_126 = NL + "\t\t\t/**" + NL + "\t\t\t * <!-- begin-user-doc -->" + NL
			+ "\t\t\t * <!-- end-user-doc -->" + NL + "\t\t\t * @generated" + NL + "\t\t\t */";
	protected final String TEXT_127 = NL + "\t\t\t@Override";
	protected final String TEXT_128 = NL + "\t\t\tpublic void handleAttributes(Attributes attributes)" + NL + "\t\t\t{";
	protected final String TEXT_129 = NL + "\t\t\t\tString theValue = attributes.getValue(";
	protected final String TEXT_130 = ", \"";
	protected final String TEXT_131 = "\");";
	protected final String TEXT_132 = NL + "\t\t\t\ttheValue = attributes.getValue(";
	protected final String TEXT_133 = NL + "\t\t\t\tif (theValue != null)" + NL + "\t\t\t\t{";
	protected final String TEXT_134 = NL + "\t\t\t\t\tthe";
	protected final String TEXT_135 = ".set";
	protected final String TEXT_136 = ".create";
	protected final String TEXT_137 = "(theValue));";
	protected final String TEXT_138 = ")";
	protected final String TEXT_139 = ".createFromString(";
	protected final String TEXT_140 = ", theValue));";
	protected final String TEXT_141 = NL + "\t\t\t\t}";
	protected final String TEXT_142 = NL + "\t\t\t\t// There are attributes to handle.";
	protected final String TEXT_143 = NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\t/**" + NL
			+ "\t\t\t * <!-- begin-user-doc -->" + NL + "\t\t\t * <!-- end-user-doc -->" + NL + "\t\t\t * @generated"
			+ NL + "\t\t\t */";
	protected final String TEXT_144 = NL + "\t\t\tpublic ";
	protected final String TEXT_145 = " startElement(String namespace, String localName, String qName, Attributes attributes) throws SAXException"
			+ NL + "\t\t\t{";
	protected final String TEXT_146 = NL + "\t\t\t\t";
	protected final String TEXT_147 = "else ";
	protected final String TEXT_148 = "if (\"";
	protected final String TEXT_149 = "\".equals(localName) && ";
	protected final String TEXT_150 = ".equals(namespace))" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\treturn ";
	protected final String TEXT_151 = ".FrameFactory.INSTANCE.push";
	protected final String TEXT_152 = "(this, attributes);" + NL + "\t\t\t\t}";
	protected final String TEXT_153 = NL
			+ "\t\t\t\treturn super.startElement(namespace, localName, qName, attributes);";
	protected final String TEXT_154 = NL + "\t\t\t\telse" + NL + "\t\t\t\t{" + NL
			+ "\t\t\t\t\treturn super.startElement(namespace, localName, qName, attributes);" + NL + "\t\t\t\t}";
	protected final String TEXT_155 = NL + "\t\t\t}" + NL + "" + NL + "\t\t\t/**" + NL
			+ "\t\t\t * <!-- begin-user-doc -->" + NL + "\t\t\t * <!-- end-user-doc -->" + NL + "\t\t\t * @generated"
			+ NL + "\t\t\t */";
	protected final String TEXT_156 = NL + "\t\t\tpublic void endElement(";
	protected final String TEXT_157 = " child) throws SAXException" + NL + "\t\t\t{";
	protected final String TEXT_158 = "if (child == ";
	protected final String TEXT_159 = ")" + NL + "\t\t\t\t{";
	protected final String TEXT_160 = ".";
	protected final String TEXT_161 = "().add(";
	protected final String TEXT_162 = ".FrameFactory.INSTANCE.pop";
	protected final String TEXT_163 = "));";
	protected final String TEXT_164 = NL + "\t\t\t\t\t";
	protected final String TEXT_165 = " = null;" + NL + "\t\t\t\t}";
	protected final String TEXT_166 = NL + "\t\t\t\tsuper.endElement(child);";
	protected final String TEXT_167 = NL + "\t\t\t\telse" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tsuper.endElement(child);"
			+ NL + "\t\t\t\t}";
	protected final String TEXT_168 = NL + "\t\t\tpublic void create()" + NL + "\t\t\t{" + NL + "\t\t\t\tthe";
	protected final String TEXT_169 = "();" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\t/**" + NL
			+ "\t\t\t * <!-- begin-user-doc -->" + NL + "\t\t\t * <!-- end-user-doc -->" + NL + "\t\t\t * @generated"
			+ NL + "\t\t\t */" + NL + "\t\t\tprotected ";
	protected final String TEXT_170 = "()" + NL + "\t\t\t{" + NL + "\t\t\t\tpop();" + NL + "\t\t\t\t";
	protected final String TEXT_171 = "Value = the";
	protected final String TEXT_172 = ";" + NL + "\t\t\t\tthe";
	protected final String TEXT_173 = " = null;" + NL + "\t\t\t\treturn result";
	protected final String TEXT_174 = "Value;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t}" + NL;
	protected final String TEXT_175 = " push";
	protected final String TEXT_176 = "() : ";
	protected final String TEXT_177 = ")" + NL + "\t\t{";
	protected final String TEXT_178 = NL + "\t\t\t";
	protected final String TEXT_179 = ".popValue());";
	protected final String TEXT_180 = "Value = ((";
	protected final String TEXT_181 = ", ";
	protected final String TEXT_182 = ".popValue())).";
	protected final String TEXT_183 = "();";
	protected final String TEXT_184 = "Value = (";
	protected final String TEXT_185 = NL + "\t\t\tthis.";
	protected final String TEXT_186 = "Value;" + NL + "\t\t}" + NL;
	protected final String TEXT_187 = NL + "\t}" + NL;
	protected final String TEXT_188 = NL + "} //";
	protected final String TEXT_189 = NL;

	public ResourceClass() {
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

			this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_189);
		stringBuffer.append(TEXT_189);
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
		 * Copyright (c) 2002-2006 IBM Corporation and others.
		 * All rights reserved.   This program and the accompanying materials
		 * are made available under the terms of the Eclipse Public License v2.0
		 * which accompanies this distribution, and is available at
		 * http://www.eclipse.org/legal/epl-v20.html
		 *
		 * Contributors:
		 *   IBM - Initial API and implementation
		 */

		GenPackage genPackage = (GenPackage) argument;
		GenModel genModel = genPackage.getGenModel();
		ExtendedMetaData extendedMetaData = genModel.getExtendedMetaData();
		final boolean isJDK50 = genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50;
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

		stringBuffer.append(TEXT_2);
		stringBuffer.append(genPackage.getUtilitiesPackageName());
		stringBuffer.append(TEXT_3);
		genModel.getImportedName("org.eclipse.emf.common.util.URI");
		genModel.markImportLocation(stringBuffer);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(genPackage.getQualifiedResourceFactoryClassName());
		if (genPackage.hasAPITags()) {
			stringBuffer.append(TEXT_5);
			stringBuffer.append(genPackage.getAPITags(genModel.getIndentation(stringBuffer)));
		}
		stringBuffer.append(TEXT_6);
		if (isJDK50 && genPackage.hasAPIDeprecatedTag()) {
			stringBuffer.append(TEXT_7);
		}
		stringBuffer.append(TEXT_8);
		stringBuffer.append(genPackage.getResourceClassName());
		stringBuffer.append(TEXT_9);
		stringBuffer.append(genPackage.getImportedResourceBaseClassName());
		stringBuffer.append(TEXT_10);
		if (genModel.hasCopyrightField()) {
			stringBuffer.append(TEXT_11);
			stringBuffer.append(genModel.getImportedName("java.lang.String"));
			stringBuffer.append(TEXT_12);
			stringBuffer.append(genModel.getCopyrightFieldLiteral());
			stringBuffer.append(TEXT_13);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_14);
		}
		if (genPackage.getResource() == GenResourceKind.XML_LITERAL
				|| genPackage.getResource() == GenResourceKind.XMI_LITERAL) {
			stringBuffer.append(TEXT_15);
			stringBuffer.append(genModel.getImportedName("java.util.List"));
			stringBuffer.append(TEXT_16);
			stringBuffer.append(genModel.getImportedName("java.util.ArrayList"));
			stringBuffer.append(TEXT_17);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLParserPool"));
			stringBuffer.append(TEXT_18);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl"));
			stringBuffer.append(TEXT_19);
			stringBuffer.append(genModel.getImportedName("java.util.Map"));
			stringBuffer.append(TEXT_20);
			stringBuffer.append(genModel.getImportedName("java.util.HashMap"));
			stringBuffer.append(TEXT_21);
		}
		stringBuffer.append(TEXT_22);
		stringBuffer.append(genPackage.getResourceClassName());
		stringBuffer.append(TEXT_23);
		if (genPackage.getResource() == GenResourceKind.XML_LITERAL
				|| genPackage.getResource() == GenResourceKind.XMI_LITERAL) {
			if (genPackage.isExtensibleProviderFactory() || genPackage.isChildCreationExtenders()) {
				stringBuffer.append(TEXT_24);
				if (genModel.useClassOverrideAnnotation()) {
					stringBuffer.append(TEXT_25);
				}
				stringBuffer.append(TEXT_26);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLSave"));
				stringBuffer.append(TEXT_27);
				if (genPackage.getResource() == GenResourceKind.XML_LITERAL) {
					stringBuffer.append(TEXT_28);
					stringBuffer
							.append(genModel.getImportedName("org.polarsys.kitalpha.emde.xmi.XMLExtensionSaveImpl"));
					stringBuffer.append(TEXT_29);
				} else {
					stringBuffer.append(TEXT_28);
					stringBuffer
							.append(genModel.getImportedName("org.polarsys.kitalpha.emde.xmi.XMIExtensionSaveImpl"));
					stringBuffer.append(TEXT_29);
				}
				stringBuffer.append(TEXT_30);
				if (genModel.useClassOverrideAnnotation()) {
					stringBuffer.append(TEXT_25);
				}
				stringBuffer.append(TEXT_26);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLHelper"));
				stringBuffer.append(TEXT_31);
				if (genPackage.getResource() == GenResourceKind.XML_LITERAL) {
					stringBuffer.append(TEXT_28);
					stringBuffer
							.append(genModel.getImportedName("org.polarsys.kitalpha.emde.xmi.XMLExtensionHelperImpl"));
					stringBuffer.append(TEXT_32);
				} else {
					stringBuffer.append(TEXT_28);
					stringBuffer
							.append(genModel.getImportedName("org.polarsys.kitalpha.emde.xmi.XMIExtensionHelperImpl"));
					stringBuffer.append(TEXT_32);
				}
				stringBuffer.append(TEXT_33);
				if (genModel.useClassOverrideAnnotation()) {
					stringBuffer.append(TEXT_25);
				}
				stringBuffer.append(TEXT_26);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLLoad"));
				stringBuffer.append(TEXT_34);
				if (genPackage.getResource() == GenResourceKind.XML_LITERAL) {
					stringBuffer.append(TEXT_28);
					stringBuffer
							.append(genModel.getImportedName("org.polarsys.kitalpha.emde.xmi.XMLExtensionLoadImpl"));
					stringBuffer.append(TEXT_35);
					stringBuffer
							.append(genModel.getImportedName("org.polarsys.kitalpha.emde.xmi.XMLExtensionHelperImpl"));
					stringBuffer.append(TEXT_36);
				} else {
					stringBuffer.append(TEXT_28);
					stringBuffer
							.append(genModel.getImportedName("org.polarsys.kitalpha.emde.xmi.XMIExtensionLoadImpl"));
					stringBuffer.append(TEXT_35);
					stringBuffer
							.append(genModel.getImportedName("org.polarsys.kitalpha.emde.xmi.XMIExtensionHelperImpl"));
					stringBuffer.append(TEXT_36);
				}
				stringBuffer.append(TEXT_37);
			}
			if (ExtensionHelper.isUseIDAttributes(genPackage) == false) {
				stringBuffer.append(TEXT_24);
				if (genModel.useClassOverrideAnnotation()) {
					stringBuffer.append(TEXT_25);
				}
				stringBuffer.append(TEXT_38);
			}
			if (ExtensionHelper.isUseUUIDS(genPackage)) {
				stringBuffer.append(TEXT_24);
				if (genModel.useClassOverrideAnnotation()) {
					stringBuffer.append(TEXT_25);
				}
				stringBuffer.append(TEXT_39);
			}
			stringBuffer.append(TEXT_24);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_25);
			}
			stringBuffer.append(TEXT_40);
			if (ExtensionHelper.isTrackResourceModification(genPackage)) {
				stringBuffer.append(TEXT_41);
			}
			stringBuffer.append(TEXT_42);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_43);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_44);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_45);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_46);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_47);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
			stringBuffer.append(TEXT_48);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_49);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLSave.XMLTypeInfo"));
			stringBuffer.append(TEXT_50);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EClass"));
			stringBuffer.append(TEXT_51);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EClassifier"));
			stringBuffer.append(TEXT_52);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
			stringBuffer.append(TEXT_53);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xml.type.XMLTypePackage"));
			stringBuffer.append(TEXT_54);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EClass"));
			stringBuffer.append(TEXT_55);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
			stringBuffer.append(TEXT_53);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xml.type.XMLTypePackage"));
			stringBuffer.append(TEXT_56);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_57);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_58);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl"));
			stringBuffer.append(TEXT_59);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_60);
			if (genPackage.getResource() == GenResourceKind.XMI_LITERAL) {
				stringBuffer.append(TEXT_61);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMIResource"));
				stringBuffer.append(TEXT_62);
			}
			stringBuffer.append(TEXT_63);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_64);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_65);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_66);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_67);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_68);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_69);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_70);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_71);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_25);
			}
			stringBuffer.append(TEXT_72);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
			stringBuffer.append(TEXT_73);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
			stringBuffer.append(TEXT_74);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EcoreUtil"));
			stringBuffer.append(TEXT_75);
		}
		if (genPackage.isDataTypeConverters() && (genPackage.hasDocumentRoot()
				|| org.eclipse.emf.ecore.xml.type.XMLTypePackage.eNS_URI.equals(genPackage.getNSURI()))) {
			boolean isXMLTypePackage = org.eclipse.emf.ecore.xml.type.XMLTypePackage.eNS_URI
					.equals(genPackage.getNSURI());
			final String _Map = genModel.useGenerics() ? "Map<?, ?>" : "Map";
			final String _MapStringBoolean = genModel.useGenerics() ? "Map<String, Boolean>" : "Map";
			final String _MapStringWildcard = genModel.useGenerics() ? "Map<String, ?>" : "Map";
			if (!isXMLTypePackage) {
				genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource");
				genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLParserPool");
				genModel.getImportedName("org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl");
				genModel.getImportedName("java.io.InputStream");
				genModel.getImportedName("java.io.IOException");
				genModel.getImportedName("org.eclipse.emf.ecore.EObject");
				genModel.getImportedName("java.util.Collections");
				genModel.getImportedName("java.util.HashMap");
				genModel.getImportedName("java.util.Map");
				genModel.getImportedName("org.xml.sax.InputSource");
				genModel.getImportedName("javax.xml.parsers.SAXParser");
			}
			genModel.getImportedName("org.xml.sax.Attributes");
			genModel.getImportedName("org.xml.sax.SAXException");
			String _StackFrame = genModel.getImportedName("org.eclipse.emf.ecore.xml.type.util.XMLTypeResourceImpl")
					+ ".StackFrame";
			String _DataFrame = genModel.getImportedName("org.eclipse.emf.ecore.xml.type.util.XMLTypeResourceImpl")
					+ ".DataFrame";
			if (!isXMLTypePackage) {
				stringBuffer.append(TEXT_76);
				stringBuffer.append(genModel.getNonNLS());
				stringBuffer.append(TEXT_24);
				if (genModel.useClassOverrideAnnotation()) {
					stringBuffer.append(TEXT_25);
				}
				stringBuffer.append(TEXT_77);
				stringBuffer.append(_Map);
				stringBuffer.append(TEXT_78);
				stringBuffer.append(_MapStringBoolean);
				stringBuffer.append(TEXT_79);
				stringBuffer.append(_MapStringWildcard);
				stringBuffer.append(TEXT_80);
				if (genModel.useClassOverrideAnnotation()) {
					stringBuffer.append(TEXT_25);
				}
				stringBuffer.append(TEXT_81);
				stringBuffer.append(_Map);
				stringBuffer.append(TEXT_82);
				stringBuffer.append(_MapStringBoolean);
				stringBuffer.append(TEXT_79);
				stringBuffer.append(_MapStringWildcard);
				stringBuffer.append(TEXT_83);
				stringBuffer.append(_MapStringBoolean);
				stringBuffer.append(TEXT_84);
				stringBuffer.append(_MapStringWildcard);
				stringBuffer.append(TEXT_85);
				stringBuffer.append(_MapStringBoolean);
				stringBuffer.append(TEXT_86);
				stringBuffer.append(_MapStringBoolean.replaceAll("Map", "HashMap"));
				stringBuffer.append(TEXT_87);
				stringBuffer.append(genModel.getNonNLS());
				stringBuffer.append(TEXT_88);
				if (genModel.useGenerics()) {
					stringBuffer.append(TEXT_89);
				} else {
					stringBuffer.append(TEXT_90);
				}
				stringBuffer.append(TEXT_91);
				if (genModel.isSuppressEMFTypes()) {
					stringBuffer.append(TEXT_92);
				} else {
					stringBuffer.append(TEXT_93);
				}
				stringBuffer.append(TEXT_94);
			}
			stringBuffer.append(TEXT_95);
			for (GenClass genClass : genPackage.getGenClasses()) {
				stringBuffer.append(TEXT_96);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_97);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_3);
			}
			for (GenDataType genDataType : genPackage.getAllGenDataTypes()) {
				stringBuffer.append(TEXT_96);
				stringBuffer.append(_DataFrame);
				stringBuffer.append(TEXT_98);
				stringBuffer.append(genDataType.getSafeUncapName());
				stringBuffer.append(TEXT_3);
			}
			for (GenClass genClass : genPackage.getGenClasses()) {
				List<EStructuralFeature> attributes = extendedMetaData.getAllAttributes(genClass.getEcoreClass());
				List<EStructuralFeature> elements = extendedMetaData.getAllElements(genClass.getEcoreClass());
				stringBuffer.append(TEXT_99);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_100);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_101);
				stringBuffer.append(_StackFrame);
				stringBuffer.append(TEXT_102);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_103);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_104);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_105);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_106);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_107);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_108);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_109);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_110);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_111);
				stringBuffer.append(genClass.getImportedInterfaceName());
				stringBuffer.append(TEXT_112);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_101);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_97);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_113);
				stringBuffer.append(genClass.getImportedInterfaceName());
				stringBuffer.append(TEXT_114);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_115);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_116);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_117);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_104);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_118);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_119);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_120);
				stringBuffer.append(_StackFrame);
				stringBuffer.append(TEXT_121);
				stringBuffer.append(genClass.getImportedInterfaceName());
				stringBuffer.append(TEXT_122);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_123);
				for (GenFeature genFeature : genClass.getAllGenFeatures()) {
					String name = extendedMetaData.getName(genFeature.getEcoreFeature());
					if ((elements.contains(genFeature.getEcoreFeature())
							|| attributes.contains(genFeature.getEcoreFeature())) && name.indexOf(":") == -1) {
						if (genFeature.isReferenceType()) {
							stringBuffer.append(TEXT_124);
							stringBuffer.append(
									genFeature.getTypeGenClass().getGenPackage().getImportedResourceClassName());
							stringBuffer.append(TEXT_125);
							stringBuffer.append(genFeature.getTypeGenClass().getName());
							stringBuffer.append(TEXT_97);
							stringBuffer.append(genFeature.getSafeName());
							stringBuffer.append(TEXT_3);
						} else {
							stringBuffer.append(TEXT_124);
							stringBuffer.append(_DataFrame);
							stringBuffer.append(TEXT_98);
							stringBuffer.append(genFeature.getSafeName());
							stringBuffer.append(TEXT_123);
						}
					}
				}
				stringBuffer.append(TEXT_126);
				if (genModel.useClassOverrideAnnotation()) {
					stringBuffer.append(TEXT_127);
				}
				stringBuffer.append(TEXT_128);
				int count = 0;
				for (GenFeature genFeature : genClass.getAllGenFeatures()) {
					String name = extendedMetaData.getName(genFeature.getEcoreFeature());
					if (attributes.contains(genFeature.getEcoreFeature()) && !genFeature.isDerived()
							&& name.indexOf(":") == -1) {
						String namespace = Literals
								.toStringLiteral(extendedMetaData.getNamespace(genFeature.getEcoreFeature()), genModel);
						if ("null".equals(namespace))
							namespace = "\"\"";
						if (!genFeature.isReferenceType()) {
							GenClassifier genClassifier = genFeature.getTypeGenClassifier();
							if (count++ == 0) {
								stringBuffer.append(TEXT_129);
								stringBuffer.append(namespace);
								stringBuffer.append(TEXT_130);
								stringBuffer.append(name);
								stringBuffer.append(TEXT_131);
							} else {
								stringBuffer.append(TEXT_132);
								stringBuffer.append(namespace);
								stringBuffer.append(TEXT_130);
								stringBuffer.append(name);
								stringBuffer.append(TEXT_131);
							}
							stringBuffer.append(TEXT_133);
							if (genClassifier.getGenPackage().isDataTypeConverters()) {
								stringBuffer.append(TEXT_134);
								stringBuffer.append(genClass.getName());
								stringBuffer.append(TEXT_135);
								stringBuffer.append(genFeature.getAccessorName());
								stringBuffer.append(TEXT_101);
								stringBuffer
										.append(genClassifier.getGenPackage().getQualifiedFactoryInstanceAccessor());
								stringBuffer.append(TEXT_136);
								stringBuffer.append(genClassifier.getName());
								stringBuffer.append(TEXT_137);
							} else {
								stringBuffer.append(TEXT_134);
								stringBuffer.append(genClass.getName());
								stringBuffer.append(TEXT_135);
								stringBuffer.append(genFeature.getAccessorName());
								stringBuffer.append(TEXT_35);
								stringBuffer.append(genFeature.getImportedType(null));
								stringBuffer.append(TEXT_138);
								stringBuffer
										.append(genClassifier.getGenPackage().getQualifiedEFactoryInstanceAccessor());
								stringBuffer.append(TEXT_139);
								stringBuffer.append(genClassifier.getQualifiedClassifierAccessor());
								stringBuffer.append(TEXT_140);
							}
							stringBuffer.append(TEXT_141);
						}
					}
				}
				if (count == 0) {
					stringBuffer.append(TEXT_142);
				}
				stringBuffer.append(TEXT_143);
				if (genModel.useClassOverrideAnnotation()) {
					stringBuffer.append(TEXT_127);
				}
				stringBuffer.append(TEXT_144);
				stringBuffer.append(_StackFrame);
				stringBuffer.append(TEXT_145);
				count = 0;
				for (GenFeature genFeature : genClass.getAllGenFeatures()) {
					String name = extendedMetaData.getName(genFeature.getEcoreFeature());
					if (elements.contains(genFeature.getEcoreFeature()) && name.indexOf(":") == -1) {
						String namespace = Literals
								.toStringLiteral(extendedMetaData.getNamespace(genFeature.getEcoreFeature()), genModel);
						if ("null".equals(namespace))
							namespace = "\"\"";
						stringBuffer.append(TEXT_146);
						if (count++ != 0) {
							stringBuffer.append(TEXT_147);
						}
						stringBuffer.append(TEXT_148);
						stringBuffer.append(name);
						stringBuffer.append(TEXT_149);
						stringBuffer.append(namespace);
						stringBuffer.append(TEXT_150);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_104);
						stringBuffer.append(
								genFeature.getTypeGenClassifier().getGenPackage().getImportedResourceClassName());
						stringBuffer.append(TEXT_151);
						stringBuffer.append(genFeature.getTypeGenClassifier().getName());
						stringBuffer.append(TEXT_152);
					}
				}
				if (count == 0) {
					stringBuffer.append(TEXT_153);
				} else {
					stringBuffer.append(TEXT_154);
				}
				stringBuffer.append(TEXT_155);
				if (genModel.useClassOverrideAnnotation()) {
					stringBuffer.append(TEXT_127);
				}
				stringBuffer.append(TEXT_156);
				stringBuffer.append(_StackFrame);
				stringBuffer.append(TEXT_157);
				count = 0;
				for (GenFeature genFeature : genClass.getAllGenFeatures()) {
					String name = extendedMetaData.getName(genFeature.getEcoreFeature());
					if (elements.contains(genFeature.getEcoreFeature()) && name.indexOf(":") == -1) {
						stringBuffer.append(TEXT_146);
						if (count++ != 0) {
							stringBuffer.append(TEXT_147);
						}
						stringBuffer.append(TEXT_158);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_159);
						if (genFeature.isListType()) {
							stringBuffer.append(TEXT_134);
							stringBuffer.append(genClass.getName());
							stringBuffer.append(TEXT_160);
							stringBuffer.append(genFeature.getGetAccessor());
							stringBuffer.append(TEXT_161);
							stringBuffer.append(
									genFeature.getTypeGenClassifier().getGenPackage().getImportedResourceClassName());
							stringBuffer.append(TEXT_162);
							stringBuffer.append(genFeature.getTypeGenClassifier().getName());
							stringBuffer.append(TEXT_101);
							stringBuffer.append(genFeature.getSafeName());
							stringBuffer.append(TEXT_163);
						} else {
							stringBuffer.append(TEXT_134);
							stringBuffer.append(genClass.getName());
							stringBuffer.append(TEXT_135);
							stringBuffer.append(genFeature.getAccessorName());
							stringBuffer.append(TEXT_101);
							stringBuffer.append(
									genFeature.getTypeGenClassifier().getGenPackage().getImportedResourceClassName());
							stringBuffer.append(TEXT_162);
							stringBuffer.append(genFeature.getTypeGenClassifier().getName());
							stringBuffer.append(TEXT_101);
							stringBuffer.append(genFeature.getSafeName());
							stringBuffer.append(TEXT_163);
						}
						stringBuffer.append(TEXT_164);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_165);
					}
				}
				if (count == 0) {
					stringBuffer.append(TEXT_166);
				} else {
					stringBuffer.append(TEXT_167);
				}
				stringBuffer.append(TEXT_155);
				if (genModel.useClassOverrideAnnotation()) {
					stringBuffer.append(TEXT_127);
				}
				stringBuffer.append(TEXT_168);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_104);
				stringBuffer.append(genPackage.getQualifiedFactoryInstanceAccessor());
				stringBuffer.append(TEXT_136);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_169);
				stringBuffer.append(genClass.getImportedInterfaceName());
				stringBuffer.append(TEXT_112);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_170);
				stringBuffer.append(genClass.getImportedInterfaceName());
				stringBuffer.append(TEXT_114);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_171);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_172);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_173);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_174);
			}
			for (GenDataType genDataType : genPackage.getAllGenDataTypes()) {
				stringBuffer.append(TEXT_99);
				stringBuffer.append(_DataFrame);
				stringBuffer.append(TEXT_175);
				stringBuffer.append(genDataType.getName());
				stringBuffer.append(TEXT_101);
				stringBuffer.append(_StackFrame);
				stringBuffer.append(TEXT_102);
				stringBuffer.append(_DataFrame);
				stringBuffer.append(TEXT_114);
				stringBuffer.append(genDataType.getName());
				stringBuffer.append(TEXT_104);
				stringBuffer.append(genDataType.getSafeUncapName());
				stringBuffer.append(TEXT_105);
				stringBuffer.append(_DataFrame);
				stringBuffer.append(TEXT_176);
				stringBuffer.append(genDataType.getSafeUncapName());
				stringBuffer.append(TEXT_107);
				stringBuffer.append(genDataType.getSafeUncapName());
				stringBuffer.append(TEXT_108);
				stringBuffer.append(genDataType.getName());
				stringBuffer.append(TEXT_109);
				stringBuffer.append(genDataType.getName());
				stringBuffer.append(TEXT_110);
				stringBuffer.append(genDataType.getName());
				stringBuffer.append(TEXT_111);
				stringBuffer.append(genDataType.getImportedParameterizedInstanceClassName());
				stringBuffer.append(TEXT_112);
				stringBuffer.append(genDataType.getName());
				stringBuffer.append(TEXT_101);
				stringBuffer.append(_DataFrame);
				stringBuffer.append(TEXT_98);
				stringBuffer.append(genDataType.getSafeUncapName());
				stringBuffer.append(TEXT_177);
				if (genDataType.getGenPackage().isDataTypeConverters()) {
					stringBuffer.append(TEXT_178);
					stringBuffer.append(genDataType.getImportedParameterizedInstanceClassName());
					stringBuffer.append(TEXT_114);
					stringBuffer.append(genDataType.getName());
					stringBuffer.append(TEXT_115);
					stringBuffer.append(genDataType.getGenPackage().getQualifiedFactoryInstanceAccessor());
					stringBuffer.append(TEXT_136);
					stringBuffer.append(genDataType.getName());
					stringBuffer.append(TEXT_101);
					stringBuffer.append(genDataType.getSafeUncapName());
					stringBuffer.append(TEXT_179);
				} else if (genDataType.isPrimitiveType()
						&& genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
					stringBuffer.append(TEXT_178);
					stringBuffer.append(genDataType.getImportedInstanceClassName());
					stringBuffer.append(TEXT_114);
					stringBuffer.append(genDataType.getName());
					stringBuffer.append(TEXT_180);
					stringBuffer.append(genDataType.getObjectInstanceClassName());
					stringBuffer.append(TEXT_138);
					stringBuffer.append(genDataType.getGenPackage().getQualifiedEFactoryInstanceAccessor());
					stringBuffer.append(TEXT_139);
					stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
					stringBuffer.append(TEXT_181);
					stringBuffer.append(genDataType.getSafeUncapName());
					stringBuffer.append(TEXT_182);
					stringBuffer.append(genDataType.getPrimitiveValueFunction());
					stringBuffer.append(TEXT_183);
				} else {
					stringBuffer.append(TEXT_178);
					stringBuffer.append(genDataType.getImportedInstanceClassName());
					stringBuffer.append(TEXT_114);
					stringBuffer.append(genDataType.getName());
					stringBuffer.append(TEXT_184);
					stringBuffer.append(genDataType.getObjectInstanceClassName());
					stringBuffer.append(TEXT_138);
					stringBuffer.append(genDataType.getGenPackage().getQualifiedEFactoryInstanceAccessor());
					stringBuffer.append(TEXT_139);
					stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
					stringBuffer.append(TEXT_181);
					stringBuffer.append(genDataType.getSafeUncapName());
					stringBuffer.append(TEXT_179);
				}
				stringBuffer.append(TEXT_185);
				stringBuffer.append(genDataType.getSafeUncapName());
				stringBuffer.append(TEXT_104);
				stringBuffer.append(genDataType.getSafeUncapName());
				stringBuffer.append(TEXT_118);
				stringBuffer.append(genDataType.getName());
				stringBuffer.append(TEXT_186);
			}
			stringBuffer.append(TEXT_187);
		}
		stringBuffer.append(TEXT_188);
		stringBuffer.append(genPackage.getResourceClassName());
		genModel.emitSortedImports();
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}
}