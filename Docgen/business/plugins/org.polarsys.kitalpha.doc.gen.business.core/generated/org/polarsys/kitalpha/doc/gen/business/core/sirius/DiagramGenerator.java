//Generated with EGF 1.6.5.qualifier
package org.polarsys.kitalpha.doc.gen.business.core.sirius;

import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.business.api.query.DRepresentationQuery;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.doc.gen.business.core.sirius.util.diagram.*;
import org.polarsys.kitalpha.doc.gen.business.core.sirius.util.session.*;
import org.eclipse.core.runtime.*;
import org.eclipse.core.resources.*;
import org.eclipse.sirius.business.api.session.*;
import org.eclipse.draw2d.geometry.*;
import java.util.Map.Entry;
import org.polarsys.kitalpha.doc.gen.business.core.util.*;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.emf.ecore.resource.Resource;
import org.polarsys.kitalpha.doc.gen.business.core.preference.helper.DocgenDiagramPreferencesHelper;
import org.polarsys.kitalpha.doc.gen.business.core.extension.page.PageExtensionRegistry;

public class DiagramGenerator {
	protected static String nl;

	public static synchronized DiagramGenerator create(String lineSeparator) {
		nl = lineSeparator;
		DiagramGenerator result = new DiagramGenerator();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "\t<div>" + NL + "\t<p class=\"diagram-name\" id=\"";
	protected final String TEXT_2 = "\">";
	protected final String TEXT_3 = "</p>" + NL + "\t<p class=\"diagram\">" + NL + "\t\t<img src=\"";
	protected final String TEXT_4 = "/";
	protected final String TEXT_5 = "\" alt=\"";
	protected final String TEXT_6 = "\" usemap=\"#";
	protected final String TEXT_7 = "\" />" + NL + "\t\t" + NL + "\t\t<br/>" + NL + "\t\t<br/>" + NL
			+ "\t\t<map name=\"";
	protected final String TEXT_8 = NL + "\t\t\t<area shape=\"rect\" group=\"";
	protected final String TEXT_9 = "\" coords=\"";
	protected final String TEXT_10 = ",";
	protected final String TEXT_11 = "\" href=\"../";
	protected final String TEXT_12 = ".html#";
	protected final String TEXT_13 = "\" />";
	protected final String TEXT_14 = "\t\t" + NL + "\t\t</map>" + NL + "\t</p>" + NL
			+ "\t<p class=\"diagram-description\">";
	protected final String TEXT_15 = "</p>" + NL + "\t</div>";
	protected final String TEXT_16 = NL + "<p class=\"diagram-name\" id=\"";
	protected final String TEXT_17 = "</p>" + NL + "<p>image is missing</p>" + NL + "<p class=\"diagram-description\">";
	protected final String TEXT_18 = "</p>";
	protected final String TEXT_19 = NL;

	public DiagramGenerator() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;
		Node.Container currentNode = ctx.getNode();

		List<Object> projectNameList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> outputFolderList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> diagramList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> generatedFolderList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> fileNameServiceList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> helperList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object projectNameParameter : projectNameList) {
			for (Object outputFolderParameter : outputFolderList) {
				for (Object diagramParameter : diagramList) {
					for (Object generatedFolderParameter : generatedFolderList) {
						for (Object fileNameServiceParameter : fileNameServiceList) {
							for (Object helperParameter : helperList) {

								this.projectName = (java.lang.String) projectNameParameter;
								this.outputFolder = (java.lang.String) outputFolderParameter;
								this.diagram = (org.eclipse.sirius.diagram.DDiagram) diagramParameter;
								this.generatedFolder = (java.lang.String) generatedFolderParameter;
								this.fileNameService = (org.polarsys.kitalpha.doc.gen.business.core.util.IFileNameService) fileNameServiceParameter;
								this.helper = (org.polarsys.kitalpha.doc.gen.business.core.util.IDiagramHelper) helperParameter;

								if (preCondition(ctx)) {
									ctx.setNode(new Node.Container(currentNode, getClass()));
									orchestration(ctx);
								}

							}
						}
					}
				}
			}
		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_19);
		stringBuffer.append(TEXT_19);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_body(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("projectName", this.projectName);
			parameterValues.put("outputFolder", this.outputFolder);
			parameterValues.put("diagram", this.diagram);
			parameterValues.put("generatedFolder", this.generatedFolder);
			parameterValues.put("fileNameService", this.fileNameService);
			parameterValues.put("helper", this.helper);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected java.lang.String projectName = null;

	public void set_projectName(java.lang.String object) {
		this.projectName = object;
	}

	protected java.lang.String outputFolder = null;

	public void set_outputFolder(java.lang.String object) {
		this.outputFolder = object;
	}

	protected org.eclipse.sirius.diagram.DDiagram diagram = null;

	public void set_diagram(org.eclipse.sirius.diagram.DDiagram object) {
		this.diagram = object;
	}

	protected java.lang.String generatedFolder = null;

	public void set_generatedFolder(java.lang.String object) {
		this.generatedFolder = object;
	}

	protected org.polarsys.kitalpha.doc.gen.business.core.util.IFileNameService fileNameService = null;

	public void set_fileNameService(org.polarsys.kitalpha.doc.gen.business.core.util.IFileNameService object) {
		this.fileNameService = object;
	}

	protected org.polarsys.kitalpha.doc.gen.business.core.util.IDiagramHelper helper = null;

	public void set_helper(org.polarsys.kitalpha.doc.gen.business.core.util.IDiagramHelper object) {
		this.helper = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("projectName", this.projectName);
		parameters.put("outputFolder", this.outputFolder);
		parameters.put("diagram", this.diagram);
		parameters.put("generatedFolder", this.generatedFolder);
		parameters.put("fileNameService", this.fileNameService);
		parameters.put("helper", this.helper);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		// org.polarsys.kitalpha.doc.gen.business.core.Activator.getDefault().getLog().log(new Status(IStatus.INFO,
		//			org.polarsys.kitalpha.doc.gen.business.core.Activator.PLUGIN_ID, "Starting generate diagram :" + diagram.getName()));
		Session session = DiagramSessionHelper.getCurrentSession();
		IPath outputPath = new Path(projectName).append(outputFolder).append(generatedFolder);
		DiagramExport diagramExport = new DiagramExport(projectName, outputPath, diagram, session);
		Resource sessionResource = session.getSessionResource();
		String id = DiagramSessionHelper.getID(diagram);
		IFile imageFile;
		DRepresentationDescriptor result;
		String mapName;
		String diagramName;
		Boolean diagramDataCached = DiagramExportRegistry.getInstance().hasDataForDiagram(diagram);
		if (diagramDataCached) {
			imageFile = DiagramExportRegistry.getInstance().getDiagramRelatedRegistryObject(diagram).getFile();
			result = DiagramExportRegistry.getInstance().getDiagramRelatedRegistryObject(diagram)
					.getRepresentationDescriptor();
			mapName = DiagramExportRegistry.getInstance().getDiagramRelatedRegistryObject(diagram).getMapName();
			diagramName = DiagramExportRegistry.getInstance().getDiagramRelatedRegistryObject(diagram).getDiagramName();
		} else {
			imageFile = diagramExport.exportAsImage();
			DRepresentationQuery rep2descQuery = new DRepresentationQuery(diagram);
			result = rep2descQuery.getRepresentationDescriptor();
			mapName = id + "_PositionMap";
			diagramName = id;
			if (result != null) {
				mapName = result.getName() + "_" + mapName;
				diagramName = result.getName();
			}
			mapName = DocGenHtmlUtil.getValidFileName(mapName);
			diagramName = DocGenHtmlUtil.getValidFileName(diagramName);
		}

		if (imageFile != null && imageFile.exists()) {
			// Resolve FileNameServices and DiagramHelpers
			Collection<IDiagramHelper> diagramHelpers = new HashSet<IDiagramHelper>();
			Collection<IFileNameService> fileNameServices = new HashSet<IFileNameService>();
			for (String dom : PageExtensionRegistry.getInstance().getDomains()) {
				diagramHelpers.addAll(PageExtensionRegistry.getInstance().getDiagramHelpersExtensions(dom));
				fileNameServices.addAll(PageExtensionRegistry.getInstance().getFileNameServicesExtensions(dom));
			}

			CoordinatesCalculator calculator = new CoordinatesCalculator(imageFile, diagram, helper);
			calculator.contributeHelpers(diagramHelpers);
			Map<Rectangle, EObject> positionMap = calculator.getPositionMap();
			if (!diagramDataCached) {
				DiagramExportRegistry.getInstance().addEntry(diagram, imageFile, result, mapName, diagramName);
			}

			stringBuffer.append(TEXT_1);
			stringBuffer.append(id);
			stringBuffer.append(TEXT_2);
			stringBuffer.append(EscapeChars.forHTML(diagramName));
			stringBuffer.append(TEXT_3);
			stringBuffer.append(generatedFolder);
			stringBuffer.append(TEXT_4);
			stringBuffer.append(imageFile.getName());
			stringBuffer.append(TEXT_5);
			stringBuffer.append(EscapeChars.forHTML(diagramName));
			stringBuffer.append(TEXT_6);
			stringBuffer.append(mapName);
			stringBuffer.append(TEXT_7);
			stringBuffer.append(mapName);
			stringBuffer.append(TEXT_2);

			String fragment = null;
			String fileName = null;
			String modelName = null;

			for (Entry<Rectangle, EObject> entrySet : positionMap.entrySet()) {
				EObject value = entrySet.getValue();
				Rectangle rectangle = entrySet.getKey();
				Point topLeft = rectangle.getTopLeft();
				Point bottomRight = rectangle.getBottomRight();

				fragment = null;
				fileName = null;
				modelName = null;

				if (value instanceof DRepresentationDescriptor) {

					/*
					 * Handle navigable note
					 */

					DRepresentationDescriptor descriptor = (DRepresentationDescriptor) value;
					org.eclipse.sirius.diagram.DDiagram targetDiagram = DiagramSessionHelper.getDDiagram(descriptor);
					if (targetDiagram != null) {
						fragment = DiagramSessionHelper.getID(targetDiagram);
					} else {
						fragment = descriptor.getRepPath().getResourceURI().fragment();
					}
					fileName = fileNameService.getFileName(descriptor.getTarget());
					if (fileName.equals("unknown")) {
						String tmpFileName = fileName;
						for (IFileNameService fileNS : fileNameServices) {
							tmpFileName = fileNS.getFileName(descriptor.getTarget());
							if (tmpFileName != fileName) {
								fileName = tmpFileName;
								break;
							}
						}
					}
					modelName = DocGenHtmlUtil.getModelName(descriptor.getTarget());

				} else {

					fileName = fileNameService.getFileName(value);
					if (fileName.equals("unknown")) {
						String tmpFileName = fileName;
						for (IFileNameService fileNS : fileNameServices) {
							tmpFileName = fileNS.getFileName(value);
							if (tmpFileName != fileName) {
								fileName = tmpFileName;
								break;
							}
						}
					}
					fragment = helper.getElementId(value);
					rectangle = entrySet.getKey();
					topLeft = rectangle.getTopLeft();
					bottomRight = rectangle.getBottomRight();
					modelName = DocGenHtmlUtil.getModelName(value);

				}

				stringBuffer.append(TEXT_8);
				stringBuffer.append(fileName);
				stringBuffer.append(TEXT_9);
				stringBuffer.append(topLeft.x);
				stringBuffer.append(TEXT_10);
				stringBuffer.append(topLeft.y);
				stringBuffer.append(TEXT_10);
				stringBuffer.append(bottomRight.x);
				stringBuffer.append(TEXT_10);
				stringBuffer.append(bottomRight.y);
				stringBuffer.append(TEXT_11);
				stringBuffer.append(modelName);
				stringBuffer.append(TEXT_4);
				stringBuffer.append(fileName);
				stringBuffer.append(TEXT_12);
				stringBuffer.append(fragment);
				stringBuffer.append(TEXT_5);
				stringBuffer.append(fileName);
				stringBuffer.append(TEXT_13);
			}

			stringBuffer.append(TEXT_14);
			stringBuffer.append(helper.diagramDocumentationPostTraitement(((DSemanticDiagram) diagram).getTarget(),
					(result == null) ? "" : result.getDocumentation(), projectName, outputFolder));
			stringBuffer.append(TEXT_15);
		} else {
			if (diagramName != null && diagramName.isEmpty() == false)
				diagramName = EscapeChars.forHTML(diagramName);

			stringBuffer.append(TEXT_16);
			stringBuffer.append(sessionResource.getURIFragment(diagram));
			stringBuffer.append(TEXT_2);
			stringBuffer.append(diagramName);
			stringBuffer.append(TEXT_17);
			stringBuffer.append((result == null) ? "" : result.getDocumentation());
			stringBuffer.append(TEXT_18);

			org.polarsys.kitalpha.doc.gen.business.core.Activator.getDefault().getLog()
					.log(new Status(IStatus.ERROR, org.polarsys.kitalpha.doc.gen.business.core.Activator.PLUGIN_ID,
							"Error during diagram export action:" + diagramName));
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return DocgenDiagramPreferencesHelper.getExportDiagram();
	}
}