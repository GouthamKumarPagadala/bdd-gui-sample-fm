package com.bdd.common;

import com.bdd.manager.DriverManager;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Locale;

public class UserActions {
    private DriverManager driverManager = new DriverManager();
    private Faker faker = new Faker(new Locale("en-US"));

    public DriverManager getDriverManager() {
        return this.driverManager;
    }

    public Faker getFaker() {
        return faker;
    }

    public void quit() {
        this.driverManager.getDriver().quit();
    }

    public void selectByVisibleText(WebElement element, String value) {
        new Select(element).selectByVisibleText(value);
    }
}
