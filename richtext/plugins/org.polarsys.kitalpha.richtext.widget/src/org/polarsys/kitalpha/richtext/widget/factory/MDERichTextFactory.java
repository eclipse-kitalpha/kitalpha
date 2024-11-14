/*******************************************************************************
 * Copyright (c) 2017, 2023 Thales Global Services S.A.S.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License 2.0 which is available at
 *  http://www.eclipse.org/legal/epl-2.0
 *  
 *  SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.richtext.widget.factory;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IExecutionListener;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.Platform;
import org.eclipse.nebula.widgets.richtext.RichTextEditorConfiguration;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.polarsys.kitalpha.richtext.common.intf.MDERichTextWidget;
import org.polarsys.kitalpha.richtext.common.util.MDERichTextHelper;
import org.polarsys.kitalpha.richtext.nebula.widget.MDENebulaBasedRichTextWidget;
import org.polarsys.kitalpha.richtext.nebula.widget.MDENebulaRichTextConfiguration;
import org.polarsys.kitalpha.richtext.nebula.widget.MDERichTextConstants;
import org.polarsys.kitalpha.richtext.widget.MDERichtextWidgetEditorImpl;
import org.polarsys.kitalpha.richtext.widget.MDERichtextWidgetImpl;
import org.polarsys.kitalpha.richtext.widget.editor.tools.OpenInEditorHandler;
import org.polarsys.kitalpha.richtext.widget.helper.MDERichtextWidgetHelper;
import org.polarsys.kitalpha.richtext.widget.internal.Activator;
import org.polarsys.kitalpha.richtext.widget.tools.handlers.AddImageHandler;
import org.polarsys.kitalpha.richtext.widget.tools.handlers.AddLinkHandler;
import org.polarsys.kitalpha.richtext.widget.tools.handlers.ClearContentHandler;
import org.polarsys.kitalpha.richtext.widget.tools.handlers.RefreshHandler;
import org.polarsys.kitalpha.richtext.widget.tools.handlers.SaveContentHandler;
import org.polarsys.kitalpha.richtext.widget.tools.utils.Constants;

/**
 * Factory to create and configure MDE rich Text
 * 
 * @author Faycal Abka
 * @author Minh Tu TON THAT
 *
 */
public class MDERichTextFactory {
	
	private final MDENebulaRichTextConfiguration configuration;
	
	public MDERichTextFactory(){
		this.configuration = new MDENebulaRichTextConfiguration();
		initializeDefaultConfiguration();
	}
	
	
	/**
	 * Create a factory with basepath to handle relative path
	 * @param basePath
	 */
	public MDERichTextFactory(String basePath){
		this();
		setBaseHrefPath(basePath);
	}
	
	
	/**
	 * Put a list of configurations here
	 */
	protected void initializeDefaultConfiguration() {
		configuration.setOption(MDERichTextConstants.READ_ONLY_MODE, false);
		configuration.setOption(MDERichTextConstants.IMAGE_PREVIEW, " ");
		configuration.setOption(MDERichTextConstants.PAST_FROM_MS_WORD_PROMPT_CLEANUP, true);
	}

	public MDERichTextWidget createEditorRichTextWidget(Composite parent){
		
		if (MDERichTextConfigurableFactory.isConfigurableRTEActivated())
		{
			MDERichTextConfigurableFactory configurableFactory = new MDERichTextConfigurableFactory();
			return configurableFactory.createPreferencesCompliantRichTextWidget(parent);
		}
		
		initializeMDEDefaultToolbar(false);
		MDERichtextWidgetEditorImpl widget = MDERichtextWidgetHelper.getInstance().getEditorWidgetContribution(parent, configuration); 
		
		if (widget == null)
		  widget = new MDERichtextWidgetEditorImpl(parent, configuration);

		addEditorToolbarItems(widget);

		return widget;

	}
	
	public MDERichTextWidget createEditorRichTextWidget(Composite parent, int style){
		
		if (MDERichTextConfigurableFactory.isConfigurableRTEActivated())
		{
			MDERichTextConfigurableFactory configurableFactory = new MDERichTextConfigurableFactory();
			return configurableFactory.createPreferencesCompliantRichTextWidget(parent);
		}
		
		initializeMDEDefaultToolbar(false);

		MDERichtextWidgetEditorImpl widget = new MDERichtextWidgetEditorImpl(parent, configuration, style);

		addEditorToolbarItems(widget);

		return widget;

	}
	
	
	public MDERichTextWidget createDefaultRichTextWidget(Composite parent){
		
		if (MDERichTextConfigurableFactory.isConfigurableRTEActivated())
		{
			MDERichTextConfigurableFactory configurableFactory = new MDERichTextConfigurableFactory();
			return configurableFactory.createPreferencesCompliantRichTextWidget(parent);
		}
		
		initializeMDEDefaultToolbar(true);
		
		removeUselessItemFromToolbar();
		
		MDERichtextWidgetImpl widget = new MDERichtextWidgetImpl(parent, configuration);
		
		addToolbarItems(widget);
		
		return widget;
	}
	
	
	public MDERichTextWidget createDefaultRichTextWidget(Composite parent, int style){
		
		if (MDERichTextConfigurableFactory.isConfigurableRTEActivated())
		{
			MDERichTextConfigurableFactory configurableFactory = new MDERichTextConfigurableFactory();
			return configurableFactory.createPreferencesCompliantRichTextWidget(parent);
		}
		
		initializeMDEDefaultToolbar(true);
		
		removeUselessItemFromToolbar();
		
		MDERichtextWidgetImpl widget = new MDERichtextWidgetImpl(parent, configuration, style);
		
		addToolbarItems(widget);
		
		initEditorItemStates(widget);
		
		return widget;
	}
	
	public MDERichTextWidget createMinimalRichTextWidget(Composite parent){
		
		if (MDERichTextConfigurableFactory.isConfigurableRTEActivated())
		{
			MDERichTextConfigurableFactory configurableFactory = new MDERichTextConfigurableFactory();
			return configurableFactory.createPreferencesCompliantRichTextWidget(parent);
		}
		
		initializeMDEMinimalToolbar();
		
		removeUselessItemFromToolbar();
		
    MDERichtextWidgetImpl widget = new MDERichtextWidgetImpl(parent, configuration) {
        IExecutionListener executionListener = null;

        @Override
        protected void installListeners() {
            super.installListeners();

            executionListener = new IExecutionListener() {
                @Override
                public void preExecute(final String commandId, final ExecutionEvent event) {
                    if (!isEditorDisposed() && hasFocus()) {
                        saveContent();
                    }
                }

                @Override
                public void postExecuteSuccess(final String commandId, final Object returnValue) {
                    if (!isEditorDisposed() && hasFocus()) {
                        setDirtyStateUpdated(false);
                    }
                }

                @Override
                public void postExecuteFailure(final String commandId, final ExecutionException exception) {
                    // Do nothing
                }

                @Override
                public void notHandled(final String commandId, final NotHandledException exception) {
                    // Do nothing
                }
            };

            // Since minimal rich text widget does not contribute a Saveable, it needs to listen to Save/SaveAll
            // events itself
            ICommandService commandSvc = PlatformUI.getWorkbench().getAdapter(ICommandService.class);
            Command saveCommand = commandSvc.getCommand(IWorkbenchCommandConstants.FILE_SAVE);
            Command saveAllCommand = commandSvc.getCommand(IWorkbenchCommandConstants.FILE_SAVE_ALL);

            saveCommand.addExecutionListener(executionListener);
            saveAllCommand.addExecutionListener(executionListener);
        }

        @Override
        public void dispose() {
            if (executionListener != null) {
                ICommandService commandSvc = PlatformUI.getWorkbench().getAdapter(ICommandService.class);
                Command saveCommand = commandSvc.getCommand(IWorkbenchCommandConstants.FILE_SAVE);
                Command saveAllCommand = commandSvc.getCommand(IWorkbenchCommandConstants.FILE_SAVE_ALL);

                saveCommand.removeExecutionListener(executionListener);
                saveAllCommand.removeExecutionListener(executionListener);
                executionListener = null;
            }

            super.dispose();
        }    };
		
		addToolbarItems(widget);
		
		initEditorItemStates(widget);
		
		return widget;
	}
	
	public MDERichTextWidget createMinimalRichTextWidget(Composite parent, int style){
		
		if (MDERichTextConfigurableFactory.isConfigurableRTEActivated())
		{
			MDERichTextConfigurableFactory configurableFactory = new MDERichTextConfigurableFactory();
			return configurableFactory.createPreferencesCompliantRichTextWidget(parent);
		}
		
		initializeMDEMinimalToolbar();
		
		removeUselessItemFromToolbar();
		
		MDERichtextWidgetImpl widget = new MDERichtextWidgetImpl(parent, configuration, style);
		
		addToolbarItems(widget);
		
		initEditorItemStates(widget);
		
		return widget;
	}
	
	private void removeUselessItemFromToolbar() {
		configuration.removeToolbarItems(MDERichTextConstants.LINK, 
				MDERichTextConstants.ANCHOR, 
				MDERichTextConstants.STRIKE,
				MDERichTextConstants.PASTE_FROM_WORD);
	}

	/**
	 * Don't add open in editor tool
	 * @param widget
	 */
	protected void addEditorToolbarItems(MDENebulaBasedRichTextWidget widget) {
		widget.addToolbarItem(widget, MDERichTextConstants.MDE_SAVE, MDERichTextConstants.MDE_SAVE,
				"Save editor content", MDERichTextConstants.MDE_SAVE_TOOLBAR, Constants.SAVE_IMAGE_ICON, new SaveContentHandler());
		
		if (!Platform.OS_LINUX.equals(Platform.getOS()) || Boolean.getBoolean("org.polarsys.kitalpha.richtext.webkit.gtk.compatibility.workaround.disable")) {
		widget.addToolbarItem(widget, MDERichTextConstants.MDE_REFRESH, MDERichTextConstants.MDE_REFRESH,
				"Refresh editor", MDERichTextConstants.MDE_REFRESH, Constants.REFRESH_IMAGE_ICON, new RefreshHandler());
		}
		
		widget.addToolbarItem(widget, MDERichTextConstants.MDE_CLEAN, 
				MDERichTextConstants.MDE_CLEAN, MDERichTextConstants.MDE_CLEAN, 
				MDERichTextConstants.MDE_CLEAN_TOOLBAR, Constants.CLEAR_ICON, new ClearContentHandler());
		
		widget.addToolbarItem(widget, MDERichTextConstants.MDE_ADDLINK, 
				MDERichTextConstants.MDE_ADDLINK, "Link", MDERichTextConstants.MDE_LINKS_TOOLBAR, 
				Constants.ADD_LINK_ICON, new AddLinkHandler());
		
		widget.addToolbarItem(widget, MDERichTextConstants.MDE_ADDIMAGE, 
				MDERichTextConstants.MDE_ADDIMAGE, "Add Image", MDERichTextConstants.MDE_LINKS_TOOLBAR, 
				Constants.ADD_IMAGE_ICON, new AddImageHandler());
	}

	protected void addToolbarItems(MDENebulaBasedRichTextWidget widget) {
		
		widget.addToolbarItem(widget, MDERichTextConstants.MDE_OPEN_EDITOR, MDERichTextConstants.MDE_OPEN_EDITOR, "Open in Editor", //$NON-NLS-1$ 
				MDERichTextConstants.MDE_ENABLE_EDITING_TOOLBAR,
				MDERichTextHelper.getURL(Activator.PLUGIN_ID, "icons/openInEditor.gif"), //$NON-NLS-1$
				new OpenInEditorHandler());
			
		widget.addToolbarItem(widget, MDERichTextConstants.MDE_SAVE, MDERichTextConstants.MDE_SAVE, "Save editor",
				MDERichTextConstants.MDE_SAVE_TOOLBAR, Constants.SAVE_IMAGE_ICON, new SaveContentHandler());

		
		if (!Platform.OS_LINUX.equals(Platform.getOS()) || Boolean.getBoolean("org.polarsys.kitalpha.richtext.webkit.gtk.compatibility.workaround.disable")) {
		widget.addToolbarItem(widget, MDERichTextConstants.MDE_REFRESH, MDERichTextConstants.MDE_REFRESH,
				"Refresh editor", MDERichTextConstants.MDE_REFRESH, Constants.REFRESH_IMAGE_ICON, new RefreshHandler());
		}
		
		addEditorToolbarItems(widget);
	}


	/**
	 * Initialize default toolbar items
	 * @return this factory
	 */
	protected MDERichTextFactory initializeMDEDefaultToolbar(boolean addOpenInEditor) {
		
		if (addOpenInEditor){
			configuration.initializeToolbarItem(MDERichTextConstants.MDE_ENABLE_EDITING_TOOLBAR, MDERichTextConstants.MDE_OPEN_EDITOR);
		}
		configuration.initializeToolbarItem(MDERichTextConstants.MDE_SAVE_TOOLBAR, MDERichTextConstants.MDE_SAVE);
		
		if (!Platform.OS_LINUX.equals(Platform.getOS()) || Boolean.getBoolean("org.polarsys.kitalpha.richtext.webkit.gtk.compatibility.workaround.disable")) {
		configuration.initializeToolbarItem(MDERichTextConstants.MDE_REFRESH, MDERichTextConstants.MDE_REFRESH);
		}
		
		configuration.initializeToolbarItem(MDERichTextConstants.STYLES_TOOLBAR);
		configuration.initializeToolbarItem(MDERichTextConstants.CLIPBOARD_TOOLBAR);
		configuration.initializeToolbarItem(MDERichTextConstants.MDE_CLEAN_TOOLBAR, MDERichTextConstants.MDE_CLEAN);
		configuration.initializeToolbarItem(MDERichTextConstants.BASIC_STYLES_GROUP, 
				MDERichTextConstants.BOLD, MDERichTextConstants.ITALIC, 
				MDERichTextConstants.UNDERLINE, MDERichTextConstants.SUBSCRIPT, 
				MDERichTextConstants.SUPERSCRIPT);
		configuration.initializeToolbarItem(MDERichTextConstants.COLORS_TOOLBAR);
		configuration.initializeToolbarItem(MDERichTextConstants.PARAGRAPH_TOOLBAR, 
				MDERichTextConstants.LIST_GROUP, MDERichTextConstants.INDENT_GROUP);
		configuration.initializeToolbarItem(MDERichTextConstants.EDITING_TOOLBAR, MDERichTextConstants.FIND);
		configuration.initializeToolbarItem(MDERichTextConstants.MDE_LINKS_TOOLBAR, MDERichTextConstants.MDE_ADDLINK);
		configuration.initializeToolbarItem(MDERichTextConstants.MDE_LINKS_TOOLBAR, MDERichTextConstants.MDE_ADDIMAGE);

		removeUselessItemFromToolbar();
		
		return this;
	}

	

	protected MDERichTextFactory initializeMDEMinimalToolbar(){
		configuration.initializeToolbarItem(MDERichTextConstants.MDE_ENABLE_EDITING_TOOLBAR, MDERichTextConstants.MDE_OPEN_EDITOR);
		configuration.initializeToolbarItem(MDERichTextConstants.MDE_SAVE_TOOLBAR, MDERichTextConstants.MDE_SAVE);
		if (!Platform.OS_LINUX.equals(Platform.getOS()) || Boolean.getBoolean("org.polarsys.kitalpha.richtext.webkit.gtk.compatibility.workaround.disable")) {
		    configuration.initializeToolbarItem(MDERichTextConstants.MDE_REFRESH, MDERichTextConstants.MDE_REFRESH);
		}
		configuration.initializeToolbarItem(MDERichTextConstants.STYLES_TOOLBAR);
		configuration.initializeToolbarItem(MDERichTextConstants.CLIPBOARD_TOOLBAR);
		configuration.initializeToolbarItem(MDERichTextConstants.BASIC_STYLES_GROUP, 
				MDERichTextConstants.LIST_GROUP);
		configuration.initializeToolbarItem(MDERichTextConstants.MDE_LINKS_TOOLBAR, MDERichTextConstants.MDE_ADDLINK);
		return this;
	}
	
	
	private void initEditorItemStates(MDERichTextWidget editor) {
		editor.setToolbarItemState(MDERichTextConstants.MDE_EDITABLE, MDERichTextConstants.STATE_ON);
	}
	
	/**
	 * See: {@link org.polarsys.kitalpha.richtext.widget.factories.MDERichTextFactory.initializeToolbarItem(String, String...)}
	 * @param toolbar
	 * @param items
	 * @return
	 */
	public MDERichTextFactory initializeToolbarItem(String toolbar, String... items){
		configuration.initializeToolbarItem(toolbar, items);
		return this;
	}
	
	/**
	 * Set the color of the toolbar
	 * @param hexaCode with format: #XXXXXX and X is hexadecimal number [0-F]. Otherwise, the behavior is unexpected
	 * @return this factory
	 */
	public MDERichTextFactory setToolbarColor(String hexaCode){
		Assert.isNotNull(hexaCode);
		configuration.setOption(MDERichTextConstants.TOOLBAR_COLOR, hexaCode);
		return this;
	}
	
	/**
	 * Set default configuration file of the underlying editor
	 * cf. CKEditor configuration for more information about configuration of the
	 * editor
	 * @param path
	 * @return this factory
	 */
	public MDERichTextFactory setConfigurationFile(String path){
		configuration.setOption(MDERichTextConstants.CUSTOM_CONFIG, path);
		return this;
	}
	
	public MDERichTextFactory setToolbarPosition(String position){
		configuration.setToolbarPosition(position);
		return this;
	}
	
	public MDERichTextFactory setBaseHrefPath(String basePath){
		configuration.setOption(MDERichTextConstants.BASE_HREF, basePath);
		return this;
	}
	
	public RichTextEditorConfiguration getConfiguration(){
		return configuration;
	}
	
}
