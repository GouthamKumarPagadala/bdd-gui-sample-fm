package com.bdd.steps;

import com.bdd.common.UserActions;
import com.bdd.pageobjects.AddComputerPage;
import com.bdd.pageobjects.EditComputerPage;
import com.bdd.pageobjects.HomePage;

public class BaseStepDefinitions {

    public BaseStepDefinitions(UserActions userActions) {
        this.userActions = userActions;
        homePage =new HomePage(userActions);
    }

    private UserActions userActions;

    public UserActions getUserActions() {
        return userActions;
    }

    public HomePage homePage;

    public EditComputerPage editComputerPage;

    public AddComputerPage addComputerPage;

}
