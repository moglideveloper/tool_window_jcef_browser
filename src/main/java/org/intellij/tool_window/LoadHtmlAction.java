package org.intellij.tool_window;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.intellij.plugins.markdown.ui.preview.jcef.MarkdownJCEFHtmlPanel;
import org.jetbrains.annotations.NotNull;

public class LoadHtmlAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        System.out.println("loading html...");
        BrowserService browserService = e.getProject().getService(BrowserService.class);
        MarkdownJCEFHtmlPanel browser = browserService.browser;

        browser.loadURL("https://raw.githubusercontent.com/moglideveloper/static-files/master/sample.html");
        browser.getComponent().invalidate();
    }
}
