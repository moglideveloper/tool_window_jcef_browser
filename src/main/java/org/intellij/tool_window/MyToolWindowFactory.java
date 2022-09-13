package org.intellij.tool_window;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MyToolWindowFactory implements ToolWindowFactory {

    MyToolWindowFactory() {
        System.out.println("creating instance of MyToolWindowFactory");
    }

    private JPanel createBrowserPanel(Project project) {

        System.out.println("creating browser panel");

        final DefaultActionGroup toolBarActionGroup = new DefaultActionGroup();
        ActionManager actionManager = ActionManager.getInstance();

        AnAction loadHtmlAction = actionManager.getAction("LoadHtmlActionId");
        toolBarActionGroup.addAction(loadHtmlAction);

        AnAction loadMarkdownAction = actionManager.getAction("LoadMarkdownActionId");
        toolBarActionGroup.addAction(loadMarkdownAction);

        ActionToolbar actionToolbar = actionManager.createActionToolbar(ActionPlaces.TOOLWINDOW_TITLE, toolBarActionGroup, true);


        BrowserService browserService = project.getService(BrowserService.class);
        JPanel browserPanel = new JPanel() ;
        browserPanel.setLayout( new BorderLayout());
        browserPanel.add(BorderLayout.NORTH, actionToolbar.getComponent()) ;
        browserPanel.add(BorderLayout.CENTER, browserService.browser.getComponent()) ;

        actionToolbar.setTargetComponent(browserPanel);

        return browserPanel;
    }

    /**
     * Create the tool window content.
     *
     * @param project    current project
     * @param toolWindow current tool window
     */
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {

        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();

        String title = "1st button : load html, 2nd button : load markdown" ;
        JPanel browserPanel = createBrowserPanel(project);
        Content content = contentFactory.createContent(browserPanel, title, false);

        toolWindow.getContentManager().addContent(content);
    }
}