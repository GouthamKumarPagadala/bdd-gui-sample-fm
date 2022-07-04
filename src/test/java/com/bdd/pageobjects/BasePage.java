package com.bdd.pageobjects;

import com.bdd.common.UserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    private WebDriver driver;
    private UserActions userActions;

    public BasePage(UserActions userActions){
        this.driver=userActions.getDriverManager().getDriver();
        this.userActions=userActions;
        PageFactory.initElements(driver,this);
    }
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public UserActions getUserActions() {
        return userActions;
    }

}
