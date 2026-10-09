//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.emde.egf;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;

import org.eclipse.egf.model.pattern.Node.Container;
import org.eclipse.egf.model.pattern.Node.DataLeaf;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.IQuery;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import org.polarsys.kitalpha.emde.egf.utils.NodeHelper;

public class PluginXMLExtensionHook {

	public PluginXMLExtensionHook() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> genModelList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> targetPathNameList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object genModelParameter : genModelList) {
			for (Object targetPathNameParameter : targetPathNameList) {

				this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;
				this.targetPathName = (java.lang.String) targetPathNameParameter;

				if (preCondition(ctx)) {
					ctx.setNode(new Node.Container(currentNode, getClass()));
					orchestration((PatternContext) argument);

				}
			}
		}
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		method_createDOM(new StringBuffer(), ictx);
		method_mergeDOM(new StringBuffer(), ictx);
		method_call_extension(new StringBuffer(), ictx);
		method_writeDOM(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("genModel", this.genModel);
			parameterValues.put("targetPathName", this.targetPathName);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_mergeDOM(final StringBuffer out, final PatternContext ctx) throws Exception {
		// read existing plugin.xml and remove generated stuff
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(targetPathName));
		DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
		if (file.exists()) {
			Document existingDoc = docBuilder.parse(new InputSource(file.getContents()));
			org.w3c.dom.Node existingDocRoot = existingDoc.getElementsByTagName("plugin").item(0);
			NodeList childs = existingDocRoot.getChildNodes();
			for (int i = 0; i < childs.getLength(); i++) {
				org.w3c.dom.Node item = childs.item(i);
				if (item instanceof Comment && "@generated".equals(((Comment) item).getNodeValue())) {
					List<org.w3c.dom.Node> toRemove = new ArrayList<org.w3c.dom.Node>();
					for (int j = i; j < childs.getLength(); j++) {
						item = childs.item(j);
						toRemove.add(item);
						if (item instanceof Element)
							break;
					}
					for (org.w3c.dom.Node node : toRemove)
						existingDocRoot.removeChild(node);
				}
			}
			childs = existingDocRoot.getChildNodes();
			for (int i = 0; i < childs.getLength(); i++) {
				org.w3c.dom.Node item = childs.item(i);
				if (item instanceof Element) {
					org.w3c.dom.Node adoptNode = doc.importNode(item, true);
					root.appendChild(adoptNode);
				}
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "mergeDOM", out.toString());
	}

	protected void method_createDOM(final StringBuffer out, final PatternContext ctx) throws Exception {
		DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
		InternalPatternContext iictx = (InternalPatternContext) ctx;
		Container node = iictx.getNode();
		Container parent = (Container) node.getContainer(Container.class).getParent();
		DataLeaf leaf = NodeHelper.findLeaf(parent, "<plugin>");
		ctx.setValue("node", leaf);
		String flatten = leaf.getData();
		doc = docBuilder.parse(new InputSource(new StringReader(flatten)));

		// add @generated comments
		NodeList extensionList = doc.getElementsByTagName("extension");
		for (int i = 0; i < extensionList.getLength(); i++) {
			org.w3c.dom.Node item = extensionList.item(i);
			org.w3c.dom.Node parentNode = item.getParentNode();
			parentNode.insertBefore(doc.createTextNode("\n"), item);
			parentNode.insertBefore(doc.createComment("@generated"), item);
			parentNode.insertBefore(doc.createTextNode("\n  "), item);
		}
		root = (Element) doc.getElementsByTagName("plugin").item(0);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createDOM", out.toString());
	}

	protected void method_writeDOM(final StringBuffer out, final PatternContext ctx) throws Exception {
		Transformer xformer = TransformerFactory.newInstance().newTransformer();
		StringWriter writer = new StringWriter();
		Result result = new StreamResult(writer);
		xformer.transform(new DOMSource(doc), result);
		DataLeaf leaf = (DataLeaf) ctx.getValue("node");
		String text = writer.toString();
		// drop PI
		int index = text.indexOf("<plugin>");
		if (index != -1)
			text = "\n" + text.substring(index);
		leaf.setData(text);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "writeDOM", out.toString());
	}

	protected void method_call_extension(final StringBuffer out, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "call_extension", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenModel genModel;

	public void set_genModel(org.eclipse.emf.codegen.ecore.genmodel.GenModel genModel) {
		this.genModel = genModel;
	}

	protected java.lang.String targetPathName;

	public void set_targetPathName(java.lang.String targetPathName) {
		this.targetPathName = targetPathName;
	}

	protected org.w3c.dom.Document doc;

	public void set_doc(org.w3c.dom.Document doc) {
		this.doc = doc;
	}

	protected org.w3c.dom.Element root;

	public void set_root(org.w3c.dom.Element root) {
		this.root = root;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("genModel", this.genModel);
		parameters.put("targetPathName", this.targetPathName);
		return parameters;
	}

}
