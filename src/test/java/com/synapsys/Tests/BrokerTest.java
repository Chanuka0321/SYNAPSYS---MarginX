package com.synapsys.Tests;

import com.synapsys.Base.BaseTest;
import com.synapsys.Pages.BranchPage;
import com.synapsys.Pages.BrokerPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokerTest extends BaseTest {

    private BrokerPage brokerPage;

    @BeforeMethod
    public void setupLoginTest() throws InterruptedException {
        login("ChanukaM","20@TC*sa");  //Use the reusable Login Method
        brokerPage = new BrokerPage(driver);
    }

    @Test(testName = "Verify tha user can redirect to the customers screen", priority = 2)
    public void redirectToTheBrokerScreen() throws InterruptedException{
        brokerPage.clickMasterdatabutton();
        brokerPage.clickBrokerButton();

        //Expected Result
        String expectedUrl = "https://iam-qa.synapsys.lk:57575/MarginXWeb/masterdata/StockBrokers/index";
        //Actual Result
        String actualUrl = brokerPage.getBrokerHomeScreenUrl();
        //Compare Actual Result and Expected Result
        Assert.assertEquals(actualUrl, expectedUrl,"User Not Redirect To The Broker Home Screen!");
    }

    @Test(testName = "Verify the user can redirect to the broker create screen", priority = 2)
    public void redirectToTheBrokerCreateScreen() throws InterruptedException{
        brokerPage.clickMasterdatabutton();
        brokerPage.clickBrokerButton();
        brokerPage.clickBrokerCreateButton();

        //Expected Result
        String expectedUrl = "https://iam-qa.synapsys.lk:57575/MarginXWeb/masterdata/StockBrokers/create";
        //Actual Result
        String actualUrl1 = brokerPage.getBrokerCreateScreenUrl();
        //Compare Actual Result and Expected Result
        Assert.assertEquals(actualUrl1, expectedUrl, "User Not Redirect to the Broker Create Screen!");
    }

    @Test(testName = "Verify the user can create a new broker", priority = 2)
    public void createNewBroker() throws InterruptedException{
        brokerPage.clickMasterdatabutton();
        brokerPage.clickBrokerButton();
        brokerPage.clickBrokerCreateButton();
        brokerPage.enterBrokerCode("BKO");
        brokerPage.enterBrokerName("Kaveesha Silva");
        brokerPage.enterAddress("12/45 Pannipitiya Road, Kadawatha.");
        brokerPage.enterNotificationEmail("kaveesha.gimhana@gmail.com");
        brokerPage.selectSettlementBankDropdown();
        brokerPage.selectSettlementBankBranchDropdown();
        brokerPage.selectSettlementAccountTypeDropdown();
        brokerPage.enterAccountNo("8882992837");
        brokerPage.clickSAVEButton();

        //Expected  Result
        String expectedBrokerSuccessMessage = "×\n" +
                "Success - Stock Broker Created Successfully.";
        //Actual Result
        String actualBrokerSuccessMessage = brokerPage.getBrokerCreateSuccessMessage();
        //Compare
        Assert.assertEquals(actualBrokerSuccessMessage, expectedBrokerSuccessMessage, "Success Message Not match!");

    }


}
