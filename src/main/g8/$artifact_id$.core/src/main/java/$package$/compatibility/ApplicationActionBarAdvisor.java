package $package$.compatibility;

import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.ide.IIDEActionConstants;
import org.eclipse.ui.internal.provisional.application.IActionBarConfigurer2;

@SuppressWarnings("restriction")
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	IWorkbenchWindow window;
	
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
        
        window = configurer.getWindowConfigurer().getWindow();

    }

    protected void makeActions(IWorkbenchWindow window) {
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    }
    
    @Override
    protected void fillCoolBar(ICoolBarManager coolBar) {
		IActionBarConfigurer2 actionBarConfigurer = (IActionBarConfigurer2) getActionBarConfigurer();
        { // Set up the context Menu
            //coolbarPopupMenuManager = new MenuManager();
			//coolbarPopupMenuManager.add(new ActionContributionItem(lockToolBarAction));
            //coolbarPopupMenuManager.add(new ActionContributionItem(editActionSetAction));
            //coolBar.setContextMenuManager(coolbarPopupMenuManager);
            //IMenuService menuService = (IMenuService) window.getService(IMenuService.class);
            //menuService.populateContributionManager(coolbarPopupMenuManager, "popup:windowCoolbarContextMenu"); //\$NON-NLS-1\$
        }
        coolBar.add(new GroupMarker(IIDEActionConstants.GROUP_FILE));
        { // File Group
            IToolBarManager fileToolBar = actionBarConfigurer.createToolBarManager();
            fileToolBar.add(new Separator(IWorkbenchActionConstants.NEW_GROUP));
            //fileToolBar.add(newWizardDropDownAction);
            fileToolBar.add(new GroupMarker(IWorkbenchActionConstants.NEW_EXT));
            fileToolBar.add(new GroupMarker(
                    IWorkbenchActionConstants.SAVE_GROUP));
            //fileToolBar.add(saveAction);
            //fileToolBar.add(saveAllAction);
            fileToolBar
                    .add(new GroupMarker(IWorkbenchActionConstants.SAVE_EXT));
            //fileToolBar.add(getPrintItem());
            fileToolBar
                    .add(new GroupMarker(IWorkbenchActionConstants.PRINT_EXT));

            fileToolBar
                    .add(new Separator(IWorkbenchActionConstants.BUILD_GROUP));
            fileToolBar
                    .add(new GroupMarker(IWorkbenchActionConstants.BUILD_EXT));
            fileToolBar.add(new Separator(
                    IWorkbenchActionConstants.MB_ADDITIONS));

            // Add to the cool bar manager
            coolBar.add(actionBarConfigurer.createToolBarContributionItem(fileToolBar,
                    IWorkbenchActionConstants.TOOLBAR_FILE));
        }

        coolBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));

        coolBar.add(new GroupMarker(IIDEActionConstants.GROUP_NAV));
        { // Navigate group
            IToolBarManager navToolBar = actionBarConfigurer.createToolBarManager();
            navToolBar.add(new Separator(
                    IWorkbenchActionConstants.HISTORY_GROUP));
            navToolBar.add(new GroupMarker(IWorkbenchActionConstants.GROUP_APP));
            //navToolBar.add(backwardHistoryAction);
            //navToolBar.add(forwardHistoryAction);
            navToolBar.add(new Separator(IWorkbenchActionConstants.PIN_GROUP));
            //navToolBar.add(getPinEditorItem());

            // Add to the cool bar manager
            coolBar.add(actionBarConfigurer.createToolBarContributionItem(navToolBar,
                    IWorkbenchActionConstants.TOOLBAR_NAVIGATE));
        }

        coolBar.add(new GroupMarker(IWorkbenchActionConstants.GROUP_EDITOR));
     
        coolBar.add(new GroupMarker(IWorkbenchActionConstants.GROUP_HELP));
        
        { // Help group
            IToolBarManager helpToolBar = actionBarConfigurer.createToolBarManager();
            helpToolBar.add(new Separator(IWorkbenchActionConstants.GROUP_HELP));
//            helpToolBar.add(searchComboItem);
              // Add the group for applications to contribute
            helpToolBar.add(new GroupMarker(IWorkbenchActionConstants.GROUP_APP));
            // Add to the cool bar manager
            coolBar.add(actionBarConfigurer.createToolBarContributionItem(helpToolBar,
                    IWorkbenchActionConstants.TOOLBAR_HELP));
        }
    }
    
}
