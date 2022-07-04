package com.bdd.pageobjects;

import com.bdd.common.UserActions;
import com.bdd.model.ComputerDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;
import java.util.List;
import java.util.stream.IntStream;

public class HomePage extends BasePage {

    static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);
    public HomePage( UserActions userActions) {
        super(userActions);
    }

    @FindBy(id = "searchbox")
    private WebElement searchBox;

    @FindBy(id = "searchsubmit")
    private WebElement filterByName;

    @FindBy(id = "add")
    private WebElement addNewComputer;

    @FindBy(css=".alert-message")
    private WebElement alertMessage;

    public ComputerDetails getComputerDetailsFromTable(String name){
        List<WebElement> elements = this.getDriver().findElements(By.xpath("//table[contains(@class,'computers')]//td[1]/a[text()='"+name+"']/ancestor::tr[1]//td"));
        ComputerDetails computerDetails = new ComputerDetails();
        computerDetails.setComputerName(elements.get(0).getText());
        computerDetails.setIntroduced(elements.get(1).getText());
        computerDetails.setDiscontinued(elements.get(2).getText());
        computerDetails.setCompany(elements.get(3).getText());
        return computerDetails;
    }

    public EditComputerPage editComputerFromTable(String name){
        this.getDriver().findElement(By.xpath("//table[contains(@class,'computers')]//td[1]/a[text()='"+name+"']")).click();
        return new EditComputerPage(getUserActions());
    }

    public AddComputerPage addANewComputer(){
        addNewComputer.click();
        return new AddComputerPage(getUserActions());
    }

    public HomePage filterData(String name){
        searchBox.sendKeys(name);
        filterByName.click();
        return this;
    }

    public String getAlertMessage(){
        return alertMessage.getText();
    }

    public int textDisplayed(String name){
        return this.getDriver().findElements(By.xpath("//span[text()='"+name+"']")).size();
    }

}
