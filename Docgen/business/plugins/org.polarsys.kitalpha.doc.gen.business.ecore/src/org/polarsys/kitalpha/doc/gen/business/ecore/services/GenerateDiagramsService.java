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
package org.polarsys.kitalpha.doc.gen.business.ecore.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gmf.runtime.common.core.util.ObjectAdapter;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutService;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.dialect.command.RefreshRepresentationsCommand;
import org.eclipse.sirius.business.api.helper.SiriusResourceHelper;
import org.eclipse.sirius.business.api.session.ReloadingPolicy;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.api.session.danalysis.DAnalysisSession;
import org.eclipse.sirius.common.tools.api.resource.ResourceSetSync.ResourceStatus;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.business.api.refresh.CanonicalSynchronizer;
import org.eclipse.sirius.diagram.business.api.refresh.CanonicalSynchronizerFactory;
import org.eclipse.sirius.diagram.ui.tools.internal.part.OffscreenEditPartFactory;
import org.eclipse.sirius.tools.api.command.SiriusCommand;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelectionCallback;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.sirius.viewpoint.description.AnnotationEntry;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.polarsys.kitalpha.doc.gen.business.ecore.Activator;
import org.polarsys.kitalpha.doc.gen.business.ecore.helpers.AIRDDiagramGeneratorHelper;

@SuppressWarnings("restriction")
public class GenerateDiagramsService{

	// Ecore resource
	private Resource resource;
	private IPath path;
	private TransactionalEditingDomain editing_domain ;/*= EditingDomainService.getInstance().getEditingDomainProvider().getEditingDomain();*/
	private Collection<Viewpoint> viewpoints = null;

	private static final String GENERATED_DIAGRAM = "EcoreToolsExtra_ClassView";
	private static final String VIEWPOINT = "Viewpoint";

	private static final PreferencesHint preferencesHint = new PreferencesHint("org.eclipse.sirius.diagram.diagram");
	
	private static IProgressMonitor _monitor = new NullProgressMonitor();
	
	private Shell shell;
	private DiagramEditPart diagramEP;

	public GenerateDiagramsService(Resource resource, IPath path) {
		this.resource = resource;
		this.path = path;
		Display.getDefault().syncExec(new Runnable() 
		{
			@Override
			public void run() {
				shell = new Shell(Display.getDefault());
			}
		});
	}
	
	public void dispose() {
		Display.getDefault().syncExec(new Runnable() 
		{
			@Override
			public void run() {
				if (diagramEP != null){
					diagramEP.getViewer().getControl().dispose();
					diagramEP.deactivate();
				}
				shell.dispose();
			}
		});
		diagramEP = null;
		shell = null;
	}
	
	public URI generateAIRD(IProgressMonitor monitor) {
		if (null != monitor && _monitor != monitor) {
			_monitor = monitor;
		}
		
		try {
			// Prepare semantic resources
			final Collection<Resource> semantics = new ArrayList<Resource>();
			semantics.add(resource);

			// Get aird resource
			boolean createNewAIRD = false;
			URI airdUri = AIRDDiagramGeneratorHelper.getExistedURI(path);
			if (airdUri == null) 
			{
				airdUri = AIRDDiagramGeneratorHelper.generateURI(path);
				createNewAIRD = true;
			} 

			// Get a session to generate diagrams
			final Session localSession = SessionManager.INSTANCE.getSession(airdUri, _monitor);
			final DocgenEcoreSessionSavePolicy savingPolicy = new DocgenEcoreSessionSavePolicy(localSession);
			localSession.setSavingPolicy(savingPolicy);
			localSession.setReloadingPolicy(new ReloadingPolicy() {
                @Override
				public List<Action> getActions(Session session, Resource resource, ResourceStatus newStatus) {
                    return Collections.emptyList();
                }
            });
			
			editing_domain = localSession.getTransactionalEditingDomain();
			
			boolean sessionWasOpen = localSession.isOpen();
			if (! localSession.isOpen())
			{
				localSession.open(_monitor);
			}
			((DAnalysisSession) localSession).setAnalysisSelector(null);
			
			final CommandStack stack = localSession.getTransactionalEditingDomain().getCommandStack();
			
			// generate diagrams
			AirdGenerationRecordingCommand command = 
				new AirdGenerationRecordingCommand(localSession.getTransactionalEditingDomain(), localSession, createNewAIRD, semantics, _monitor);
			stack.execute(command);
			Collection<DRepresentationDescriptor> createdRepDescriptors = command.getCreatedRepresentationDescriptors();
			
			// Create an aird fragment and put in it all new generated representation
			URI fragmentUri = getFragmentUri();
			savingPolicy.setFragmentURI(fragmentUri);
			fragmentResource(localSession, fragmentUri , editing_domain, createdRepDescriptors);
			
			final Collection<DRepresentation> createdRepresentations = command.getCreatedRepresentation();
			// Layout the generated representations 
			layoutNewRepresentations(createdRepresentations);
			
//			 Save the session
			localSession.save(_monitor);
			if (! sessionWasOpen)
			{
				localSession.close(_monitor);
			}
			
			command.dispose();
			createdRepresentations.clear();
			stack.flush();
			return fragmentUri;
		} 
		catch (Exception e) 
		{
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error during aird generation", e));
		}
		return null;
	}
	
	private URI getFragmentUri(){
		EList<EObject> content = resource.getContents();
		String modelName = resource.getURI().trimFileExtension().lastSegment().toLowerCase();
		if (content != null && content.size() > 0)
		{
			EPackage ePackage = (EPackage)content.get(0);
			modelName = ePackage.getName().toLowerCase();
		}
		
		IPath fragmentPath = path; 
		fragmentPath = fragmentPath.append("diagrams");
		URI fUri = AIRDDiagramGeneratorHelper.generateURI(fragmentPath);
		fUri = fUri.trimFileExtension().trimSegments(1);
		return fUri.appendSegment(modelName).appendFileExtension("aird");
	}
	
	private void fragmentResource(Session session, URI fragmentResourceURI, TransactionalEditingDomain domain, Collection<DRepresentationDescriptor> movableRepresentations){
		_monitor.beginTask("Creating fragment : " + fragmentResourceURI.toString(), 1);
		ExtractRepresentationSilentCommand command = new ExtractRepresentationSilentCommand(session, fragmentResourceURI, domain, movableRepresentations);
		command.execute();
	}
	
	private void layoutNewRepresentations(final Collection<DRepresentation> createdRepresentations){
		// Layout generated Fragment
		_monitor.beginTask("Applying layout on representations ", 1);
		Display.getDefault().syncExec(new Runnable() 
		{
			@Override
			public void run() {
				for (DRepresentation dRepresentation : createdRepresentations) 
				{
					DSemanticDiagram semanticDiagram = (DSemanticDiagram) dRepresentation;
					if (semanticDiagram.getOwnedDiagramElements().size() > 1)
					{
						layout(semanticDiagram, null);
					}
				}
			}
		});
		_monitor.worked(1);
	}
	
	private Collection<Viewpoint> getViewpoints(Session session) {
		if (viewpoints == null) 
		{
			viewpoints = new ArrayList<Viewpoint>();
			for (Viewpoint v : ViewpointRegistry.getInstance().getViewpoints()) 
			{
				if (v.getName().equals(GENERATED_DIAGRAM)) 
				{
					Viewpoint vp = SiriusResourceHelper.getCorrespondingViewpoint(session, v);
					if (vp != null)
					{
						viewpoints.add(vp);
						break;
					}
				}
			}
		}
		return viewpoints;
	}

	private Collection<DSemanticDiagram> getNewDSemanticDiagrams(Resource airdResource, Collection<URI> newObject) {
		Collection<DSemanticDiagram> result = new UniqueEList<DSemanticDiagram>();

		for (DSemanticDiagram representation : getRepresentation(airdResource)) 
		{
			EObject target = ((DSemanticDiagram) representation).getTarget();
			if (newObject.contains(EcoreUtil.getURI(target))) {
				result.add((DSemanticDiagram) representation);
			}
		}
		return result;

	}

	/**
	 * Provides semantic object list from representations.
	 * 
	 * @param airdResource
	 *            the aird resource containing representations.
	 * @return all representation targets.
	 */
	private Collection<DSemanticDiagram> getRepresentation(Resource airdResource) {
		EObject airdResourceRoot = airdResource.getContents().get(0);
		if (airdResourceRoot instanceof DAnalysis) 
		{
			DAnalysis analysis = (DAnalysis) airdResourceRoot;
			final Collection<DSemanticDiagram> representation = getRepresentation(analysis);
			return representation;
		}
		return new UniqueEList<DSemanticDiagram>();
	}
	
	protected Collection<DSemanticDiagram> getRepresentation(DAnalysis analysis){
		Collection<DSemanticDiagram> result = new UniqueEList<DSemanticDiagram>();
		
		if (analysis != null)
		{
			// Handling the current DAnalysis views
			for (DView view : analysis.getOwnedViews()) 
			{
				for (DRepresentationDescriptor representationDesc : view.getOwnedRepresentationDescriptors()) 
				{
					DRepresentation representation = representationDesc.getRepresentation();
					if (representation instanceof DSemanticDecorator) {
						result.add((DSemanticDiagram) representation);
					}
				}
			}
			
			// Handling the referenced DAnalysis by the current one.
			final EList<DAnalysis> referencedDAnalysis = analysis.getReferencedAnalysis();
			for (DAnalysis dAnalysis : referencedDAnalysis) 
			{
				final Collection<DSemanticDiagram> representation = getRepresentation(dAnalysis);
				if (!representation.isEmpty())
				{
					result.addAll(representation);
				}
			}
		}
		return result;
	}

	private boolean isSupport(EObject object) {
		return object instanceof EClass;
	}

	/**
	 * Provides GMF diagram corresponding to Sirius representation.
	 * 
	 * @param representation
	 *            the Sirius representation.
	 * @param sessionResource
	 *            the session containing representation.
	 * @return
	 */
	private Diagram getDiagram(DRepresentation representation, Resource sessionResource) {
		for (AnnotationEntry annotationEntry : representation.getOwnedAnnotationEntries()) 
		{
			if (annotationEntry.getSource().equals("GMF_DIAGRAMS")) 
			{
				EObject data = annotationEntry.getData();
				
				if (data instanceof Diagram) {
					return (Diagram) data;
				}
			}
		}
		
		// In this case the GMF Diagram is not created yet
		Diagram diagram = ViewService.createDiagram(representation, VIEWPOINT, getPreferencesHint());
		
		for (AnnotationEntry annotationEntry : representation.getOwnedAnnotationEntries()) 
		{
			if (annotationEntry.getSource().equals("GMF_DIAGRAMS")) 
			{
				annotationEntry.setData(diagram);
				return diagram;
			}
		}		
		
		return null;
	}

	private static PreferencesHint getPreferencesHint() {
		return preferencesHint;
	}

	public void layout(final DSemanticDiagram semanticDiagram, final Resource sessionResource){
		Diagram gmfDiag = getDiagram(semanticDiagram, sessionResource);
		layoutGmfDiag(gmfDiag);
	}

	/**
	 * Layout all aird representations.
	 * @param airdUri
	 */
	public void layout(URI airdUri) {
		try {

			Resource ecoreResource = getResourceFromAvailableSiriusSessions(resource.getURI());
			if (ecoreResource == null && resource.isLoaded())
			{
				ecoreResource = resource;
			}
			else 
			{
				if (ecoreResource == null) {
					ecoreResource = editing_domain.getResourceSet().getResource(resource.getURI(), true);
				}
			}
			
			Collection<URI> semanticElements = new ArrayList<URI>();
			TreeIterator<EObject> iterator = ecoreResource.getAllContents();
			while (iterator.hasNext()) 
			{
				EObject current = iterator.next();
				if (isSupport(current)) {
					semanticElements.add(EcoreUtil.getURI(current));
				}
			}
			
			Resource sessionResource = editing_domain.getResourceSet().getResource(airdUri, true);
			
			for (DSemanticDiagram semanticDiagram : getNewDSemanticDiagrams(sessionResource, semanticElements)) 
			{
				Diagram gmfDiag = getDiagram(semanticDiagram, sessionResource);
				layoutGmfDiag(gmfDiag);
			}
			
			Map<Object, Object> options = new HashMap<Object, Object>();

			options.put(XMLResource.OPTION_USE_FILE_BUFFER, 
						Boolean.TRUE);
			
			options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF,
						XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
			
			sessionResource.save(options);
			sessionResource.unload();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Layout given gmf diagram.
	 * 
	 * @param gmfDiag
	 *            the GMF Diagram to layout.
	 */
	@SuppressWarnings("rawtypes")
	private void layoutGmfDiag(Diagram gmfDiag) {
		try {
			/** Initialization of the Diagram Edit Part **/
			
			if (diagramEP == null)
			{/** Create it if not done yet **/
				diagramEP = OffscreenEditPartFactory.getInstance().createDiagramEditPart(gmfDiag, shell, getPreferencesHint());
			}
			else
			{/** Put the current GMF diagram if the Diagram Edit Part was created**/
				diagramEP.setModel(gmfDiag);
				diagramEP.activate();
				diagramEP.refresh();
			}
			/** Preparing the diagram to apply layout **/
			diagramEP.getRoot().refresh();
			diagramEP.getFigure().validate();
			diagramEP.getRoot().refresh();
			diagramEP.getRoot().getViewer().flush();
			
			/** Applying an Auto-size command on all diagram elements**/
			List children = diagramEP.getChildren();
			for (Object object : children) 
			{
				if (object instanceof AbstractEditPart)
				{
					AbstractEditPart editPart = (AbstractEditPart) object;
					org.eclipse.gef.commands.Command command = editPart.getCommand(new Request(RequestConstants.REQ_AUTOSIZE));
					if (command != null && command.canExecute())
					{
						command.execute();
						command.dispose();
					}
				}
			}
			
			/** Invoking the layout on the current diagram **/
			List<Object> hints = new ArrayList<Object>(2);
			hints.add(LayoutType.DEFAULT);
			hints.add(diagramEP);
			IAdaptable layoutHint = new ObjectAdapter(hints);
			
			List layoutNodes = LayoutService.getInstance().getLayoutNodes(diagramEP, gmfDiag.getChildren());
			final Runnable layoutRun = LayoutService.getInstance().layoutLayoutNodes(layoutNodes, false, layoutHint);
			layoutRun.run();
			
			/** Cleaning data created to apply the layout on the current diagram **/
			diagramEP.deactivate();
			diagramEP.getViewer().flush();
			EditDomain editDomain = diagramEP.getViewer().getEditDomain();
			editDomain.getCommandStack().flush();
			((DiagramEditDomain) editDomain).removeViewer(diagramEP.getViewer());
			editing_domain.getCommandStack().flush();
			diagramEP.setModel(null);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
		}
	}

	class SynchronizeGMFModelCommand extends SiriusCommand {
		private CanonicalSynchronizer canonicalSynchronizer;

		public SynchronizeGMFModelCommand(TransactionalEditingDomain editing_domain,
											CanonicalSynchronizer canonicalSynchronizer) {
			super(editing_domain);
			this.canonicalSynchronizer = canonicalSynchronizer;
			this.canonicalSynchronizer.storeViewsToArrange(true);
		}

		@Override
		protected void doExecute() {
			canonicalSynchronizer.synchronize();
		}
	}

	/**
	 * 
	 * @param sessionUri
	 * @return
	 */
	private Resource getResourceFromAvailableSiriusSessions(URI sessionUri) {
		for (Session currentSession : SessionManager.INSTANCE.getSessions()) 
		{
			for (Resource resource : currentSession.getSemanticResources()) 
			{
				if (resource.getURI().equals(sessionUri)) {
					return resource;
				}
			}
		}
		return null;
	}
	
	/****************************************************************************************/
	
	
	

	/**
	 * A Recording command that manage Aird representation generation
	 */
	private class AirdGenerationRecordingCommand extends RecordingCommand{
		
		private Session _session;
		private boolean _newAird;
		private Collection<Resource> _semanticResources;
		private Collection<DRepresentation> _createdRepresentations;
		private Collection<DRepresentationDescriptor> _createdRepresentationDescriptors;
		private IProgressMonitor _monitor ;
		
		public AirdGenerationRecordingCommand(TransactionalEditingDomain editindDomain,
											  Session session,
											  boolean newAird,
											  Collection<Resource> semanticResources,
											  IProgressMonitor monitor) {
			super(editindDomain, "Diragms generation");
			_session = session;
			_newAird = newAird;
			_semanticResources = semanticResources;
			_createdRepresentations = new ArrayList<DRepresentation>();
			_createdRepresentationDescriptors = new ArrayList<DRepresentationDescriptor>();
			_monitor = monitor;
		}
		
		public Collection<DRepresentation> getCreatedRepresentation(){
			return _createdRepresentations;
		}
		
		public Collection<DRepresentationDescriptor> getCreatedRepresentationDescriptors(){
			return _createdRepresentationDescriptors;
		}
		
		
		@Override
		public void dispose() {
			_session = null;
			_semanticResources.clear();
			_monitor = null;
			super.dispose();
		}
		
		@Override
		protected void doExecute() {
			for (Resource currentResource : _semanticResources) 
			{
				_session.addSemanticResource(currentResource.getURI(), _monitor);
			}

			getViewpoints(_session);
			ViewpointSelectionCallback callback = new ViewpointSelectionCallback();
			for (Viewpoint viewpoint : viewpoints) 
			{
				if (! _session.getSelectedViewpoints(false).contains(viewpoint)) {
					callback.selectViewpoint(viewpoint, _session, _monitor);
				}
			}

			// Create aird contents and/or refresh them
			if (_newAird) 
			{
				for (Viewpoint viewpoint : viewpoints) 
				{
					EObject root = getElementFromSessionResource(_session, resource.getURI());
					if (root == null) {
						root = resource.getContents().get(0);
					}
					
					List<EClass> eClasses = getEClasses(root);
					for (EClass eClass : eClasses) 
					{
						String stepIndex = " (" + (eClasses.indexOf(eClass) * 5) + "/" + ( eClasses.size() * 5) + ")";
						_monitor.beginTask("Diagram generation for : " + (eClass).getName() + stepIndex, 1);
						Collection<DRepresentationDescriptor> newRepDescriptors = init(eClass, viewpoint, _session);
						if (newRepDescriptors.size() > 0)
						{
							refreshNewDiagramDescriptors(_session, newRepDescriptors);
							for (DRepresentationDescriptor dRepresentationDescriptor : newRepDescriptors) 
							{
								DRepresentation representation = dRepresentationDescriptor.getRepresentation();
								if (representation != null)
								{
									_createdRepresentations.add(representation);
								}
							}
							_createdRepresentationDescriptors.addAll(newRepDescriptors);
						}
					}
				}
//				refreshNewDiagram(_session);
			} 
			else 
			{
				Collection<DRepresentation> newRepresentation = refreshExistedDiagram(_session);
				if (newRepresentation.size() > 0) {
					_createdRepresentations.addAll(newRepresentation);
				}
				
				// FIXME: haldle _createdRepresentationDescriptors list
			}
		}
		
		private List<EClass> getEClasses(EObject root){
			List<EClass> result = new ArrayList<EClass>();
			
			if (root instanceof EPackage)
			{
				EList<EClassifier> eClassifiers = ((EPackage) root).getEClassifiers();
				for (EClassifier eClassifier : eClassifiers) 
				{
					if (eClassifier instanceof EClass) {
						result.add((EClass)eClassifier);
					}
				}
				
				EList<EPackage> eSubpackages = ((EPackage) root).getESubpackages();
				for (EPackage ePackage : eSubpackages) 
				{
					List<EClass> eClasses = getEClasses(ePackage);
					if (!eClasses.isEmpty())
					{
						result.addAll(eClasses);
					}
				}
			}
			
			return result;
		}
		
		/**
		 * 
		 * @param localSession
		 * @param resourceURI
		 * @return Element from localSession resource or null
		 */
		private EObject getElementFromSessionResource(final Session localSession, URI resourceURI) {
			EObject root = null;
			for (Resource currentResource : localSession.getSemanticResources()) 
			{
				if (currentResource.getURI().equals(resourceURI)) {
					root = currentResource.getContents().get(0);
				}
			}
			return root;
		}
		
		/**
		 * Initializing a new representation on given semantic element.
		 * 
		 * @param semanticObject
		 * @param viewpoint
		 * @param session
		 */
		private Collection<DRepresentationDescriptor> init(EObject semanticObject, Viewpoint viewpoint,Session session) {
			Collection<DRepresentationDescriptor> result = new ArrayList<DRepresentationDescriptor>();
			for (RepresentationDescription description : viewpoint.getOwnedRepresentations()) 
			{
				ENamedElement namedElement = (ENamedElement) semanticObject;
				String name = namedElement.getName() + " - " + description.getName();
				DRepresentation nRepresentation = 
						DialectManager.INSTANCE.createRepresentation(name, semanticObject, description, session, new NullProgressMonitor());
				DRepresentationDescriptor represnetationDescriptor = getRepresentationDescriptor(session, nRepresentation);
				if (null != represnetationDescriptor) {
					result.add(represnetationDescriptor);
				}
			}
			return result;
		}
		
		private DRepresentationDescriptor getRepresentationDescriptor(Session session, DRepresentation representation){
			Collection<DRepresentationDescriptor> repDescriptors = DialectManager.INSTANCE.getAllRepresentationDescriptors(session);
			for (DRepresentationDescriptor dRepresentationDescriptor : repDescriptors) 
			{
				if (dRepresentationDescriptor.getRepresentation().equals(representation)) {
					return dRepresentationDescriptor;
				}
			}
			
//			Collection<DView> ownedViews = session.getOwnedViews();
//			for (DView dView : ownedViews) 
//			{
//				EList<DRepresentationDescriptor> representationDescriptors = dView.getOwnedRepresentationDescriptors();
//				for (DRepresentationDescriptor dRepresentationDescriptor : representationDescriptors) 
//				{
//					if (dRepresentationDescriptor.getRepresentation().equals(representation))
//						return dRepresentationDescriptor;
//				}
//			}
			return null;
		}
		
		private Collection<DRepresentation> refreshExistedDiagram(final Session session) {
			// Add new diagrams for new semantic objects if needed
			Collection<EObject> newObject = findNewSemanticElements(session);
			Collection<URI> newObjectFragments = new ArrayList<URI>();
			Collection<DRepresentation> result = new ArrayList<DRepresentation>();
			List<EObject> list4TaskStep = new ArrayList<EObject>(newObject);
			for (Viewpoint viewpoint : getViewpoints(_session)) 
			{
				for (RepresentationDescription representationDescription : viewpoint.getOwnedRepresentations()) 
				{
					for (EObject object : list4TaskStep) 
					{
						newObjectFragments.add(EcoreUtil.getURI(object));
						if (object instanceof ENamedElement) 
						{
							String name = ((ENamedElement) object).getName() + " - " + representationDescription.getName();
							try
							{
								String stepIndex = " (" + (list4TaskStep.indexOf(object) * 5) + "/" + ( list4TaskStep.size() * 5) + ")";
								_monitor.beginTask("Diagram generation for : " + ((ENamedElement) object).getName() + stepIndex, 1);
								DRepresentation representation = DialectManager.INSTANCE.createRepresentation(name, object, representationDescription, session, new NullProgressMonitor());
								if (null != representation) {
									result.add(representation);
								}
							}
							catch (Exception e){
								e.printStackTrace();
							}
						}
					}
				}
			}
			list4TaskStep.clear();
			list4TaskStep = null;
			
			Collection<DSemanticDiagram> newSemanticDiagrams = getNewDSemanticDiagrams(session.getSessionResource(), newObjectFragments);
			for (final DSemanticDiagram diagram : newSemanticDiagrams) 
//			for (DRepresentation dRepresentation : result) 
			{
				refreshNewDSemanticDiagram(diagram, session);
			}
			
			return result;
		}
		
		private void refreshNewDiagram(final Session session, Collection<DRepresentation> representations) {
			CompoundCommand compoundCommand = new CompoundCommand();

			RefreshRepresentationsCommand refreshRepresentationsCommand = new RefreshRepresentationsCommand(editing_domain, _monitor, representations);
			compoundCommand.append(refreshRepresentationsCommand);
			editing_domain.getCommandStack().execute(compoundCommand);
			for (DRepresentation currentDRepresentation :  representations) 
			{
				if (currentDRepresentation instanceof DDiagram) {
					refreshNewDSemanticDiagram(currentDRepresentation, session);
				}
			}
		}
		
		private void refreshNewDiagramDescriptors(final Session session, Collection<DRepresentationDescriptor> repDescriptors) {
			CompoundCommand compoundCommand = new CompoundCommand();
			
			Collection<DRepresentation> representations = new ArrayList<DRepresentation>();
			for (DRepresentationDescriptor descriptor : repDescriptors) 
			{
				DRepresentation representation = descriptor.getRepresentation();
				if (representation != null)
				{
					representations.add(representation);
				}
			}

			RefreshRepresentationsCommand refreshRepresentationsCommand = new RefreshRepresentationsCommand(editing_domain, _monitor, representations);
			compoundCommand.append(refreshRepresentationsCommand);
			editing_domain.getCommandStack().execute(compoundCommand);
			for (DRepresentation currentDRepresentation :  representations) 
			{
				if (currentDRepresentation instanceof DDiagram) {
					refreshNewDSemanticDiagram(currentDRepresentation, session);
				}
			}
		}
		
		@SuppressWarnings("unused")
		private void refreshNewDiagram(final Session session) {
			CompoundCommand compoundCommand = new CompoundCommand();
			Collection<DRepresentation> representations = DialectManager.INSTANCE.getAllRepresentations(session);

			RefreshRepresentationsCommand refreshRepresentationsCommand = new RefreshRepresentationsCommand(editing_domain, _monitor, representations);
			compoundCommand.append(refreshRepresentationsCommand);
			editing_domain.getCommandStack().execute(compoundCommand);
			for (DRepresentation currentDRepresentation :  representations) 
			{
				if (currentDRepresentation instanceof DDiagram) {
					refreshNewDSemanticDiagram(currentDRepresentation, session);
				}
			}
		}
		
		private Collection<EObject> findNewSemanticElements(Session localSession) {
			List<EObject> oldList = new UniqueEList<EObject>();
			for (DSemanticDiagram diag : getRepresentation(localSession.getSessionResource())) 
			{
				EObject target = diag.getTarget();
				if (isSupport(target)) {
					oldList.add(target);
				}
			}
			EObject root = getElementFromSessionResource(localSession, resource.getURI());
			if (root == null) {
				root = resource.getContents().get(0);
			}
			
			
			final List<EClass> eClasses = getEClasses(root);
			eClasses.removeAll(oldList);
			return new ArrayList<EObject>(eClasses);
		}
		
		/**
		 * Refresh the new created representation.
		 * 
		 * @param representation
		 *            the Sirius representation.
		 * @param session
		 *            the session containing the representation.
		 */
		private void refreshNewDSemanticDiagram(DRepresentation representation, Session session) {
			DialectManager.INSTANCE.refresh(representation, new NullProgressMonitor());
			Diagram gmfDiag = getDiagram(representation, session.getSessionResource());
			if (gmfDiag == null) {
				gmfDiag = ViewService.createDiagram(representation, VIEWPOINT, getPreferencesHint());
			}
			
			CanonicalSynchronizer canonicalSynchronizer = CanonicalSynchronizerFactory.INSTANCE.createCanonicalSynchronizer(gmfDiag);
			Command synchronizeGMFModel = new SynchronizeGMFModelCommand(editing_domain, canonicalSynchronizer);
			editing_domain.getCommandStack().execute(synchronizeGMFModel);
		}
	}
}
