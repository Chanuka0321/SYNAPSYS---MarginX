package com.synapsys.Tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.synapsys.Base.BaseTest;
import com.synapsys.Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setup(){
        super.setup(); //Initialize WebDriver Before Navigating
        driver.get(getLoginUrl());
        loginPage = new LoginPage(driver);
    }

    @Test(testName = "Verify the user can log into valid username & password")
    public void testValidLogin() throws InterruptedException{
        login("ChanukaM", "20@TC*sa");

        //Expected Result
        String expectedUrl = "https://iam-qa.synapsys.lk:57575/MarginXWeb/Home"; //Change as needed
        //Actual Result
        String actualUrl = loginPage.getDashboardUrl();
        //Compare Results
        Assert.assertEquals(actualUrl, expectedUrl, "Login Failed: URL Mismatch!");
    }

    @Test(testName = "Verify the user cannot log into without password")
    public void loginwithonlyusername() throws InterruptedException{
        login("ChanukaM", "");
        loginPage.clickLogin();

        //Expected Result
        String expectedError = "Error\n" +
                "The Password field is required.";
        //Actual Result
        String actualError = loginPage.getErrorMessage();
        //Compare Results
        Assert.assertEquals(actualError, expectedError, "Error Message Mismatch!");
    }

    @Test(testName = "Verify the user cannot log into without password")
    public void loginwithonlypassword() throws InterruptedException{
        login("", "20@TC*sa");
        loginPage.clickLogin();

        //Expected Result
        String expectedError = "Error\n" +
                "The Username field is required.";
        //Actual Result
        String actualError = loginPage.getErrorMessage();
        //Compare Results
        Assert.assertEquals(actualError, expectedError, "Error Message Mismatch!");
    }

    @Test(testName = "Verify the user cannot log into without username and password")
    public void loginwithempty() throws InterruptedException{
        login("", "");
        loginPage.clickLogin();

        //Expected Result
        String expectedError = "Error\n" +
                "The Username field is required.\n" +
                "The Password field is required.";
        //Actual Result
        String actualError = loginPage.getErrorMessage();
        //Compare Results
        Assert.assertEquals(actualError, expectedError, "Error Message Mismatch!");
    }

}
