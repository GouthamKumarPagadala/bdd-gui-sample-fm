package com.bdd.pageobjects;

import com.bdd.common.UserActions;
import com.bdd.model.ComputerDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddComputerPage extends BasePage {

    static final Logger LOGGER = LoggerFactory.getLogger(AddComputerPage.class);
    public AddComputerPage(UserActions userActions) {
        super(userActions);
    }

    @FindBy(id = "name")
    private WebElement computerName;

    @FindBy(id="introduced")
    private WebElement introduced;

    @FindBy(id="discontinued")
    private WebElement discontinued;

    @FindBy(id="company")
    private WebElement company;

    @FindBy(xpath = "//input[@value='Create this computer']")
    private WebElement createThisComputerButton;

    @FindBy(xpath = "//a[text()='Cancel']")
    private WebElement cancelButton;

    public void provideComputerDetails(ComputerDetails computerDetails){
        LOGGER.info("Details entered: "+computerDetails.toString());
        if(computerDetails.getCompany()!=null){
            computerName.sendKeys(computerDetails.getComputerName());
        }
        if(computerDetails.getIntroduced()!=null){
            introduced.sendKeys(computerDetails.getIntroduced());
        }
        if(computerDetails.getDiscontinued()!=null){
            discontinued.sendKeys(computerDetails.getDiscontinued());
        }
        if(computerDetails.getCompany()!=null){
            selectCompany(computerDetails.getCompany());
        }
    }

    public void selectCompany(String name){
        Select se = new Select(company);
        se.selectByVisibleText(name);
    }

    public HomePage clickOnCreateThisComputer(){
        createThisComputerButton.click();
        return new HomePage(getUserActions());
    }

    public void clickOnCancelButton(){
        cancelButton.click();
    }


}
