package com.bdd.steps;

import com.bdd.common.UserActions;
import com.bdd.model.ComputerDetails;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppStepDefinitions extends BaseStepDefinitions {
    public AppStepDefinitions(UserActions userActions) {
        super(userActions);
    }

    static final Logger LOGGER = LoggerFactory.getLogger(AppStepDefinitions.class);

    ComputerDetails computerDetails = new ComputerDetails();

    @Given("user clicks on add a new computer button")
    public void userClicksOnAddANewComputerButton() {
        addComputerPage = homePage.addANewComputer();
    }

    @And("User enter new computer details")
    public void userEnterNewComputerDetails() {

    }
    @And("User enter new computer with {string} details")
    public void userEnterNewComputerWithDetails(String type) {
        switch(type){
            case "Valid":
                computerDetails.setComputerName(getUserActions().getFaker().name().firstName());
                computerDetails.setCompany("Apple Inc.");
                break;
            case "Empty computerName":
                computerDetails.setComputerName("");
                computerDetails.setComputerName("Apple Inc.");
                break;
        }
        addComputerPage.provideComputerDetails(computerDetails);
    }

    @When("User clicks on create new computer")
    public void userClicksOnCreateNewComputer() {
        homePage = addComputerPage.clickOnCreateThisComputer();
    }

    @Then("User verify new computer details are added in the homepage table")
    public void userVerifyNewComputerDetailsAreAddedInTheHomepageTable() {
        ComputerDetails actualComputerDetails = homePage.getComputerDetailsFromTable(computerDetails.getComputerName());
        Assert.assertEquals(computerDetails,actualComputerDetails);
    }

    @Then("User verify error message displayed as {string}")
    public void userVerifyErrorMessageDisplayedAs(String errorMessage) {
        Assert.assertEquals(homePage.textDisplayed(errorMessage),1);
    }

    @Then("User verify message displayed with {string}")
    public void userVerifyAlertMessageDisplayedWith(String message) {
        Assert.assertEquals("Message with computer name is not displayed",message.replace("{computerName}",computerDetails.getComputerName()),homePage.getAlertMessage());
    }

    @Given("User filter the computer with existing name {string}")
    public void userFilterTheComputerWithExistingName(String name) {
        homePage.filterData(name);
    }

    @And("User fetch the data from search results with name {string}")
    public void userFetchTheDataFromSearchResultsWithName(String name) {
        computerDetails = homePage.getComputerDetailsFromTable(name);
    }

    @When("User clicks on existing name {string}")
    public void userClicksOnExistingName(String name) {
        editComputerPage = homePage.editComputerFromTable(name);
    }

    @And("User edit company data with {string}")
    public void userEditCompanyDataWith(String companyName) {
        editComputerPage.selectCompany(companyName);
        editComputerPage.clickOnSaveThisComputer();
    }

    @And("User clicks on delete button")
    public void userClicksOnDeleteButton() {
        editComputerPage.clickOnDeleteThisComputer();
    }
}
