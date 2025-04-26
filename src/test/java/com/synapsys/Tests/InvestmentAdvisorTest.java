package com.synapsys.Tests;

import com.synapsys.Base.BaseTest;
import com.synapsys.Pages.BrokerPage;
import com.synapsys.Pages.InvestmentAdvisorPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InvestmentAdvisorTest extends BaseTest {

    private InvestmentAdvisorPage investmentAdvisorPage;

    @BeforeMethod
    public void setupLoginTest() throws InterruptedException {
        login("ChanukaM","20@TC*sa");  //Use the reusable Login Method
        investmentAdvisorPage = new InvestmentAdvisorPage(driver);
    }

    @Test(testName = "Verify tha user can redirect to the investment advisor screen", priority = 2)
    public void redirectToTheInvestmentAdvisorScreen() {
        investmentAdvisorPage.clickMasterdataBtn();
        investmentAdvisorPage.clickInvestmentAdvisorBtn();

        //Expected Result
        String expectedUrl = "https://iam-qa.synapsys.lk:57575/MarginXWeb/masterdata/InvestmentAdvisors/index";
        //Actual Result
        String actualUrl = investmentAdvisorPage.getInvestmentAdvisorHomeScreenUrl();
        //Compare Actual Result and Expected Result
        Assert.assertEquals(actualUrl, expectedUrl,"User Not Redirect To The Investment Advisor Home Screen!");
    }

    @Test(testName = "Verify the user can create a new investment advisor", priority = 2)
    public void createNewInvestmentAdvisor() throws InterruptedException{
        investmentAdvisorPage.clickMasterdataBtn();
        investmentAdvisorPage.clickInvestmentAdvisorBtn();
        investmentAdvisorPage.clickCREATEINVESTMENTADVISORBtn();
        investmentAdvisorPage.selectStockBrokerDropdown();
        investmentAdvisorPage.enterAdvisorCode("HDB49");
        investmentAdvisorPage.enterAdvisorName("Chamini Vidanagamage");
        investmentAdvisorPage.enterContactNumber("0761832549");
        investmentAdvisorPage.enterEmail("chamini.vidanagamage@gmail.com");
        investmentAdvisorPage.clickSAVEButton();

        //Expected  Result
        String expectedInvestmentAdvisorSuccessMsg = "×\n" +
                "Success - Investment Advisor Created Successfully.";
        //Actual Result
        String actualInvestmentAdvisorSuccessMessage = investmentAdvisorPage.getInvestmentAdvisorCreateSuccessMessage();
        //Compare
        Assert.assertEquals(actualInvestmentAdvisorSuccessMessage, expectedInvestmentAdvisorSuccessMsg, "Success Message Not match!");
    }
}
