package com.bdd.pageobjects;

import com.bdd.common.UserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EditComputerPage extends AddComputerPage {

    static final Logger LOGGER = LoggerFactory.getLogger(EditComputerPage.class);
    public EditComputerPage( UserActions userActions) {
        super(userActions);
    }

    @FindBy(xpath = "//input[@value='Save this computer']")
    private WebElement saveThisComputerButton;

    @FindBy(xpath = "//input[@value='Delete this computer']")
    private WebElement deleteThisComputerButton;

    public void clickOnSaveThisComputer(){
        saveThisComputerButton.click();
    }

    public void clickOnDeleteThisComputer(){
        deleteThisComputerButton.click();
    }
}
