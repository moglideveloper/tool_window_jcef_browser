<ins>**Below are important actions to refer :-**</ins>

https://github.com/moglideveloper/tool_window_jcef_browser/blob/master/src/main/java/org/intellij/tool_window/LoadHtmlAction.java


```
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        System.out.println("loading html...");
        BrowserService browserService = e.getProject().getService(BrowserService.class);
        MarkdownJCEFHtmlPanel browser = browserService.browser;

        browser.loadURL("https://raw.githubusercontent.com/moglideveloper/static-files/master/sample.html");
        browser.getComponent().invalidate();
    }
```

https://github.com/moglideveloper/tool_window_jcef_browser/blob/master/src/main/java/org/intellij/tool_window/LoadMarkdownAction.java


```
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        System.out.println("loading markdown...");
        BrowserService browserService = e.getProject().getService(BrowserService.class);
        MarkdownJCEFHtmlPanel browser = browserService.browser;

        browser.loadURL("https://raw.githubusercontent.com/moglideveloper/static-files/master/sample.md");
        browser.getComponent().invalidate();
    }
```