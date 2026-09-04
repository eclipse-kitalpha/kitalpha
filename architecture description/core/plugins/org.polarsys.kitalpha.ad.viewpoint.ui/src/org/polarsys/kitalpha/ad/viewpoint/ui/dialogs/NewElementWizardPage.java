/*******************************************************************************
 * Copyright (c) 2014, 2026 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.polarsys.kitalpha.ad.viewpoint.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.dialogs.StatusInfo;
import org.eclipse.jdt.internal.ui.dialogs.TextFieldNavigationHandler;
import org.eclipse.jdt.internal.ui.wizards.NewWizardMessages;
import org.eclipse.jdt.internal.ui.wizards.TypedElementSelectionValidator;
import org.eclipse.jdt.internal.ui.wizards.TypedViewerFilter;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.LayoutUtil;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.StringDialogField;
import org.eclipse.jdt.ui.JavaElementComparator;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jdt.ui.StandardJavaElementContentProvider;
import org.eclipse.jdt.ui.wizards.NewTypeWizardPage;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.pde.internal.core.natures.PluginProject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.polarsys.kitalpha.ad.common.AD_Log;
import org.polarsys.kitalpha.ad.viewpoint.ui.Activator;
import org.polarsys.kitalpha.ad.viewpoint.ui.Messages;

public abstract class NewElementWizardPage extends NewTypeWizardPage {
	
	private final class LocalTypedElementSelectionValidator extends TypedElementSelectionValidator {
		private LocalTypedElementSelectionValidator(Class<?>[] acceptedTypes, boolean allowMultipleSelection) {
			super(acceptedTypes, allowMultipleSelection);
		}

		@Override
		public boolean isSelectedValid(Object element) {
			try {
				if (element instanceof IJavaProject) {
					IJavaProject jproject = (IJavaProject) element;
					IPath path = jproject.getProject().getFullPath();
					return (jproject.findPackageFragmentRoot(path) != null);
				} else if (element instanceof IPackageFragmentRoot) {
					return (((IPackageFragmentRoot) element).getKind() == IPackageFragmentRoot.K_SOURCE);
				}
				return true;
			} catch (JavaModelException e) {
				AD_Log.getDefault().logWarning(e); // just log, no UI in
													// validation
			}
			return false;
		}
	}

	protected static final String ELEMENT_NAME = "element.name";

	protected StringDialogField fElementNameDialogField;
	protected IStatus fElementNameStatus;

	public NewElementWizardPage(boolean isClass, String pageName) {
		super(isClass, pageName);
		fElementNameDialogField = new StringDialogField();
		fElementNameDialogField.setDialogFieldListener(field -> handleFieldChanged(ELEMENT_NAME));
		fElementNameDialogField.setLabelText(getElementLabel());

	}

	protected void createElementNameControls(Composite composite, int nColumns) {
		fElementNameDialogField.doFillIntoGrid(composite, nColumns - 1);
		DialogField.createEmptySpace(composite);
		Text text = fElementNameDialogField.getTextControl(null);
		LayoutUtil.setWidthHint(text, getMaxFieldWidth());
		TextFieldNavigationHandler.install(text);
	}

	public String getElementName() {
		return fElementNameDialogField.getText();
	}

	@Override
	protected void setFocus() {
		fElementNameDialogField.setFocus();
	}

	@Override
	protected String getTypeNameLabel() {
		return Messages.JavaRuleWizard_type_label;
	}

	public String getElementLabel() {
		return Messages.JavaRuleWizard_rule_label;
	}

	@Override
	protected void createTypeMembers(IType type, ImportsManager imports, IProgressMonitor monitor) throws CoreException {
		createInheritedMethods(type, false, true, imports, new SubProgressMonitor(monitor, 1));

		if (monitor != null) {
			monitor.done();
		}
	}

	protected void doStatusUpdate() {
		// status of all used components
		List<IStatus> allStatus = new ArrayList<>();

		collectStatus(allStatus);

		// the mode severe status will be displayed and the OK button
		// enabled/disabled.
		updateStatus((IStatus[]) allStatus.toArray(new IStatus[allStatus.size()]));
	}

	protected void collectStatus(List<IStatus> allStatus) {
		allStatus.add(fContainerStatus);
		allStatus.add(isEnclosingTypeSelected() ? fEnclosingTypeStatus : fPackageStatus);
		allStatus.add(fTypeNameStatus);
		allStatus.add(fModifierStatus);
		allStatus.add(fSuperClassStatus);
		allStatus.add(fSuperInterfacesStatus);
		allStatus.add(fElementNameStatus);
	}

	@Override
	protected void handleFieldChanged(String fieldName) {
		super.handleFieldChanged(fieldName);
		if (fieldName == ELEMENT_NAME) {
			fElementNameStatus = elementNameChanged();
		}
		doStatusUpdate();
	}

	protected IStatus elementNameChanged() {
		StatusInfo status = new StatusInfo();
		String text = fElementNameDialogField.getText();
		if (text == null || "".equals(text)){
			status.setError(Messages.NewCreationWizardPage_error1);
		}
		return status;
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			setFocus();
		}
	}

	/**
	 * The wizard owning this page is responsible for calling this method with
	 * the current selection. The selection is used to initialize the fields of
	 * the wizard page.
	 * 
	 * @param selection
	 *            used to initialize the fields
	 */
	public void init(IStructuredSelection selection) {
		IJavaElement jelem = getInitialJavaElement(selection);
		initContainerPage(jelem);
		initTypePage(jelem);
		doStatusUpdate();

		IDialogSettings dialogSettings = getDialogSettings();
		if (dialogSettings != null) {
			IDialogSettings section = dialogSettings.getSection(Activator.RULE_PROVIDER_WIZARD_SECTION);
			if (section != null) {
				String location = section.get(Activator.DEFAULT_LOCATION_KEY);
				if (location != null) {
					IResource findMember = ResourcesPlugin.getWorkspace().getRoot().findMember(location);
					if (findMember != null && findMember.exists()) {
						IJavaElement root = JavaCore.create(findMember);
						if (root != null && root.exists() && root instanceof IPackageFragmentRoot) {
							IPackageFragmentRoot root2 = (IPackageFragmentRoot) root;
							setPackageFragmentRoot(root2, true);
							String pack = section.get(Activator.DEFAULT_PACKAGE_KEY);
							if (pack != null) {

								IPackageFragment packg = root2.getPackageFragment(pack);
								if (packg != null && packg.exists()){
									setPackageFragment(packg, true);
								}
							}
						}
					}
				}
			}
		}

	}

	@Override
	protected IPackageFragmentRoot chooseContainer() {
		IJavaElement initElement = getPackageFragmentRoot();
		Class[] acceptedClasses = new Class[] { IPackageFragmentRoot.class, IJavaProject.class };
		TypedElementSelectionValidator validator = new LocalTypedElementSelectionValidator(acceptedClasses, false);

		acceptedClasses = new Class[] { IJavaModel.class, IPackageFragmentRoot.class, IJavaProject.class };
		ViewerFilter filter = new TypedViewerFilter(acceptedClasses) {
			@Override
			public boolean select(Viewer viewer, Object parent, Object element) {
				if (element instanceof IJavaProject) {
					IJavaProject jproj = (IJavaProject) element;
					try {
                        return jproj.getProject().hasNature(PluginProject.NATURE);
					} catch (CoreException e) {
						AD_Log.getDefault().logWarning(e); // just log, no UI in
															// validation
						return false;
					}
				}
				if (element instanceof IPackageFragmentRoot) {
					try {
						return (((IPackageFragmentRoot) element).getKind() == IPackageFragmentRoot.K_SOURCE);
					} catch (JavaModelException e) {
						AD_Log.getDefault().logWarning(e); // just log, no UI in
															// validation
						return false;
					}
				}
				return super.select(viewer, parent, element);
			}
		};

		StandardJavaElementContentProvider provider = new StandardJavaElementContentProvider();
		ILabelProvider labelProvider = new JavaElementLabelProvider(JavaElementLabelProvider.SHOW_DEFAULT);
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), labelProvider, provider);
		dialog.setValidator(validator);
		dialog.setComparator(new JavaElementComparator());
		dialog.setTitle(NewWizardMessages.NewContainerWizardPage_ChooseSourceContainerDialog_title);
		dialog.setMessage(NewWizardMessages.NewContainerWizardPage_ChooseSourceContainerDialog_description);
		dialog.addFilter(filter);
		dialog.setInput(JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()));
		dialog.setInitialSelection(initElement);
		dialog.setHelpAvailable(false);

		if (dialog.open() == Window.OK) {
			Object element = dialog.getFirstResult();
			if (element instanceof IJavaProject) {
				IJavaProject jproject = (IJavaProject) element;
				return jproject.getPackageFragmentRoot(jproject.getProject());
			} else if (element instanceof IPackageFragmentRoot) {
				return (IPackageFragmentRoot) element;
			}
			return null;
		}
		return null;
	}

}