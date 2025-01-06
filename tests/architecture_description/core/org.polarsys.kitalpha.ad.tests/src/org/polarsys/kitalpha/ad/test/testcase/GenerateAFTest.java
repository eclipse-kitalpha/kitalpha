package org.polarsys.kitalpha.ad.test.testcase;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.internal.resources.Marker;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.pde.core.plugin.IExtensions;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.ui.wizards.datatransfer.FileSystemStructureProvider;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.junit.BeforeClass;
import org.junit.Test;
import org.polarsys.capella.test.framework.helpers.IResourceHelpers;
import org.polarsys.kitalpha.ad.af.dsl.as.servicies.action.popup.GenerateArchitectureFramework;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.adapter.IContractProvider;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.helper.egf.ContractHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.helper.egf.InvokeActivityHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.launcher.manager.GeneratorLuncherManager;
import org.polarsys.kitalpha.ad.viewpoint.dsl.services.action.popup.ActionsUtils;

public class GenerateAFTest {

  static String afdslFileLocation = "model/sample.afdesc";
  static String projectExplorerViewId = "org.eclipse.ui.navigator.ProjectExplorer";
  static String popupMenuExtensionId = "org.eclipse.ui.popupMenus";
  private static final URI DEFAULT_LAUNCHER_URI = URI.createURI(
      "platform:/plugin/org.polarsys.kitalpha.ad.af.dsl.generation.desc/egf/AFGeneratorLauncher.fcore#_fVL0kOoJEeKQgpgMDnmvmA");

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    File testProject = IResourceHelpers.getFileOrFolderInTestPlugin(GenerateAFTest.class,
        "model/org.polarsys.kitalpha.af.sample.afdsl");
    File testProjectFileLocation = IResourceHelpers.getFileOrFolderInTestPlugin(GenerateAFTest.class,
        "model/org.polarsys.kitalpha.af.sample.afdsl/.project");

    // Ensure that the welcome page is closed
    IIntroPart introPart = PlatformUI.getWorkbench().getIntroManager().getIntro();
    PlatformUI.getWorkbench().getIntroManager().closeIntro(introPart);

    // Load project description from external project and create the project into the workspace
    IProjectDescription description = null;
    try {
      description = ResourcesPlugin.getWorkspace()
          .loadProjectDescription(new Path(testProjectFileLocation.getCanonicalPath()));
    } catch (FileNotFoundException e) {
      fail("Test project not found in model/org.polarsys.kitalpha.af.sample.afdesc");
    }

    IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(description.getName());
    project.create(description, null);

    IOverwriteQuery overwriteQuery = new IOverwriteQuery() {
      public String queryOverwrite(String file) {
        return ALL;
      }
    };
    // Import the content of the external project into the newly created workspace project
    ImportOperation importOperation = new ImportOperation(project.getFullPath(), testProject,
        FileSystemStructureProvider.INSTANCE, overwriteQuery);
    importOperation.setCreateContainerStructure(false);
    importOperation.run(new NullProgressMonitor());

    project.open(null);
  }

  @Test
  public void test() {
    // Ensure that the project has been successfully imported
    IProject myProject = null;
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    for (IProject project : root.getProjects()) {
      if (project.getName().equals("org.polarsys.kitalpha.af.sample.afdsl")) {
        myProject = project;
        break;
      }
    }

    if (myProject == null) {
      fail("Project not found");
    }

    // Find the afdslFile
    IResource afdslFile = myProject.findMember(afdslFileLocation);
    if (afdslFile == null) {
      fail("afdsl file not found");
    }

    // Ensure that the project explorer view is visible
    IWorkbenchPage currentPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    IViewPart view = null;
    try {
      view = currentPage.showView(projectExplorerViewId);
    } catch (PartInitException e) {
      fail("Could not show view " + projectExplorerViewId);
    }

    // Select the afdsl file
    StructuredSelection selection = new StructuredSelection(new Object[] { afdslFile });
    view.getSite().getSelectionProvider().setSelection(selection);

    // Disable autobuild
    IWorkspace workspace = ResourcesPlugin.getWorkspace();
    IWorkspaceDescription desc = workspace.getDescription();
    boolean isAutoBuilding = desc.isAutoBuilding();
    if (isAutoBuilding == true) {
      desc.setAutoBuilding(false);
      try {
        workspace.setDescription(desc);
      } catch (CoreException e) {
        fail("Couldn't disable autobuild");
      }
    }

    // Disable decorators
    IDecoratorManager manager = PlatformUI.getWorkbench().getDecoratorManager();

    try {
      manager.setEnabled("org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.desc.ui.vpdesc.decorator", false);
      manager.setEnabled("org.eclipse.mylyn.tasks.ui.decorators.task", false);
      manager.setEnabled("org.eclipse.ui.VirtualResourceDecorator", false);
      manager.setEnabled("org.eclipse.jdt.ui.buildpath.decorator", false);
      manager.setEnabled("org.eclipse.ui.SymlinkDecorator", false);
      manager.setEnabled("org.eclipse.ui.LinkedResourceDecorator", false);
      manager.setEnabled("org.eclipse.egit.ui.internal.decorators.GitLightweightDecorator", false);
      manager.setEnabled("org.eclipse.jdt.internal.ui.without.test.code.decorator", false);
      manager.setEnabled("org.eclipse.ui.ContentTypeDecorator", false);
      manager.setEnabled("org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.desc.ui.decorator1", false);

    } catch (CoreException e1) {
      // fail("Could not disable decorators");
      // Shouldn't be a failure if decorators cannot be disabled
    }

    generateArchitectureFramework(selection);

    while (PlatformUI.getWorkbench().getDisplay().readAndDispatch()) {
      // Do nothing, just wait
    }

    String afProjectName = "org.polarsys.kitalpha.af.sample";
    String fcProjectName = "org.polarsys.kitalpha.af.sample.fc";

    Map<String, IPluginModelBase> collectedWorkspaceProjects = collectWorkspaceProjects();

    assertTrue(collectedWorkspaceProjects.containsKey(afProjectName));
    assertTrue(collectedWorkspaceProjects.containsKey(fcProjectName));

    // Test AF plugin
    IPluginModelBase model = collectedWorkspaceProjects.get(afProjectName);
    if (model == null)
      fail("Could not find AF plugin");
    IResource underlyingResource = model.getUnderlyingResource();
    IProject project = underlyingResource.getProject();

    IFile fileToFind = (IFile) project.findMember("models/sample.af");
    if (fileToFind == null || !fileToFind.exists())
      fail("Could not find af file in " + afProjectName);
    fileToFind = (IFile) project.findMember("models/sample.generationchain");
    if (fileToFind == null || !fileToFind.exists())
      fail("Could not find generationchain file in " + afProjectName);

    // Test FC plugin
    model = collectedWorkspaceProjects.get(fcProjectName);
    if (model == null)
      fail("Could not find FC plugin");
    underlyingResource = model.getUnderlyingResource();
    project = underlyingResource.getProject();

    fileToFind = (IFile) project.findMember("model/sample.fcore");
    if (fileToFind == null || !fileToFind.exists())
      fail("Could not find fcore file in " + fcProjectName);

    // Ensure that plugin.xml properly contains a fcore extension , with fcore id =
    // "sample"
    IExtensions extensions = model.getExtensions();
    EXTENSIONS_LOOP: for (IPluginExtension pluginExtension : extensions.getExtensions()) {
      if (pluginExtension.getPoint().equals("org.eclipse.egf.core.fcore")) {
        IPluginObject[] children = pluginExtension.getChildren();
        for (IPluginObject child : children) {
          String childName = child.getName();
          if (child instanceof IPluginElement && childName.equals("fcore")) {
            IPluginElement element = (IPluginElement) child;
            String tagsValue = element.getAttribute("id").getValue();
            if (!tagsValue.equals("model/sample.fcore")) {
              fail("incorrect extention point: we should have fcore id = model/sample.fcore");
            }
            break EXTENSIONS_LOOP;
          }
        }
      }
    }

    refreshAndBuildWorkspace();

    // Ensure that workspace is properly built and there are no error markers
    IMarker[] markers = null;
    try {
      markers = workspace.getRoot().findMarkers(IMarker.MARKER, true, IResource.DEPTH_INFINITE);
    } catch (CoreException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

    List<Marker> errorMarkers = Arrays.stream(markers).filter(imarker -> imarker instanceof Marker)
        .map(Marker.class::cast)
        // Filter only error markers
        .filter(marker -> {
          try {
            Object attribute = marker.getAttribute(IMarker.SEVERITY);
            if (attribute == null)
              return false;
            return (int) attribute == IMarker.SEVERITY_ERROR;
          } catch (CoreException e1) {
            return false;
          }
        }).collect(Collectors.toList());

    assertTrue(errorMarkers.isEmpty());

  }

  protected void refreshAndBuildWorkspace() {
    final IWorkspace workspace = ResourcesPlugin.getWorkspace();
    synchronized (this) {
      Job job = new Job("Refresh And Build") {
        @Override
        public IStatus run(IProgressMonitor monitor) {
          try {
            workspace.getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            workspace.build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
          } catch (CoreException e) {
            e.printStackTrace();
            return Status.CANCEL_STATUS;
          }
          return Status.OK_STATUS;
        }
      };
      job.setUser(true);
      job.schedule();
      try {
        job.join();
      } catch (InterruptedException e) {
        fail("Job Interrupted");
      }

    }
    while (PlatformUI.getWorkbench().getDisplay().readAndDispatch()) {
      // Do nothing, just wait
    }
  }

  protected Map<String, IPluginModelBase> collectWorkspaceProjects() {
    Map<String, IPluginModelBase> map = new HashMap<String, IPluginModelBase>();
    for (IPluginModelBase model : PDECore.getDefault().getModelManager().getWorkspaceModels()) {
      IResource underlyingResource = model.getUnderlyingResource();
      IProject project = underlyingResource.getProject();
      String pluginName = project.getName();
      map.put(pluginName, model);
    }
    return map;
  }

  protected void generateArchitectureFramework(IStructuredSelection selection) {
    String vpGenerationId = "Viewpoint Generation";
    URI modelURI = ActionsUtils.getDomainURI(selection);

    Activity vpGeneratorLauncher = InvokeActivityHelper.getActivity(DEFAULT_LAUNCHER_URI); // $NON-NLS-1$

    // Prepare the factory component.
    FactoryComponent factoryComponent = (FactoryComponent) vpGeneratorLauncher;
    ContractHelper.setDomain(factoryComponent, "model", modelURI);
    ContractHelper.setBooleanContract(factoryComponent, "package.af", true); //$NON-NLS-1$

    Diagnostic diagnostic = Diagnostician.INSTANCE.validate(factoryComponent);
    if (diagnostic.getSeverity() != Diagnostic.ERROR) {
      synchronized (this) {
        try {
          ActivityManagerProducer producer = EGFProducerPlugin.getActivityManagerProducer(factoryComponent);
          final IActivityManager activityManager = producer.createActivityManager(factoryComponent);
          activityManager.initializeContext();
          Job job = new Job(vpGenerationId) {
            @Override
            public IStatus run(IProgressMonitor monitor) {
              try {
                activityManager.invoke(monitor);
                activityManager.dispose();

              } catch (InvocationException e) {
                fail("Invocation Exception");
              }
              return Status.OK_STATUS;
            }
          };
          job.setUser(true);
          job.schedule();
          try {
            job.join();
            while (PlatformUI.getWorkbench().getDisplay().readAndDispatch()) {
              // Do nothing, just wait
            }
          } catch (InterruptedException e) {
            fail("Job Interrupted");
          }
        } catch (InvocationException e) {
          fail("Invocation Exception");
        } catch (CoreException e) {
          fail("Core Exception");
        }
      }
    }
  }

}
