package com.bdd.manager;

import com.bdd.enumerations.BrowserType;
import com.bdd.common.UserActions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    public Hooks() {
    }

    public Hooks(UserActions userActions) {
        this.userActions = userActions;
    }

    private UserActions userActions;
    public static Scenario scenario;

    @Before
    public void beforeChrome() {
        if (Boolean.parseBoolean(userActions.getDriverManager().getProperty("useGrid"))) {
            userActions.getDriverManager().launchApplication(userActions.getDriverManager().getProperty("url"), BrowserType.GRID_CHROME);
        } else {
            userActions.getDriverManager().launchApplication(userActions.getDriverManager().getProperty("url"), BrowserType.valueOf(userActions.getDriverManager().getProperty("browserName")));
        }
    }

    @After
    public void afterChrome(Scenario scenario) {
        if (Boolean.parseBoolean(userActions.getDriverManager().getProperty("captureScreenshotUpOnFailedDueToScriptIssue")) &&scenario.getStatus().toString().contentEquals(Status.FAILED.toString()) && userActions.getDriverManager().getDriver() != null) {
            scenario.attach(((TakesScreenshot) userActions.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES), "image/png", "failed screenshot");
        }
        userActions.quit();
    }

}
