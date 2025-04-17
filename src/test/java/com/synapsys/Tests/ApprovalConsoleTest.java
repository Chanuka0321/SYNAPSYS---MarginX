package com.synapsys.Tests;

import com.synapsys.Base.BaseTest;
import com.synapsys.Pages.ApprovalConsolePage;
import com.synapsys.Pages.BranchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApprovalConsoleTest extends BaseTest {

    private ApprovalConsolePage approvalConsolePage;
    private BranchPage branchPage;

    @BeforeMethod
    public void setupLoginTest() throws InterruptedException{
        login("Chanuka99", "20@TC*sa");
        approvalConsolePage = new ApprovalConsolePage(driver);
    }

    @Test(testName = "Verify the user can navigate to the Approval Console Home Screen", priority = 1)
    public void redirectToApprovalConsoleHome() throws InterruptedException{
        approvalConsolePage.scrollUp();
        Thread.sleep(1000);
        approvalConsolePage.clickApprovalConsoleButton();

        //Expected Result
        String expectedUrl = "https://iam-qa.synapsys.lk:57575/MarginXWeb/ApprovalConsole/ApprovalConsole/Index"; //Change as needed
        //Actual Result
        String actualUrl = approvalConsolePage.getApprovalConsoleScreenUrl();
        //Compare Results
        Assert.assertEquals(actualUrl, expectedUrl, "User Not Redirect To The Approval Console Screen!");
    }

    @Test(testName = "Verify the user searched branch name displayed in the grid", priority = 2)
    public void selectDropDownValues() throws InterruptedException {
        approvalConsolePage.scrollUp();
        Thread.sleep(1000);
        approvalConsolePage.clickApprovalConsoleButton();
        approvalConsolePage.setSelectValuesFromModuleDd();
        approvalConsolePage.setSelectValuesFromStatusDd();

        approvalConsolePage.enterSearchBranchName("NHF213");

        //Expected Result
        String expectedSearchResult = "NHF213";
        //Actual Result
        String actualSearchResult = approvalConsolePage.getSearchResult();
        //Compare Results
        Assert.assertEquals(actualSearchResult, expectedSearchResult, "Search Branch displayed in the grid!");
    }

    @Test(testName = "Verify the user navigate to the view branch screen", priority = 2)
    public void approvedBranch() throws InterruptedException{
        approvalConsolePage.scrollUp();
        Thread.sleep(1000);
        approvalConsolePage.clickApprovalConsoleButton();
        approvalConsolePage.setSelectValuesFromModuleDd();
        approvalConsolePage.setSelectValuesFromStatusDd();
        approvalConsolePage.enterSearchBranchName("NHF213");

        approvalConsolePage.clickApproveViewButton();

        //Expected Result
        String expectedBranchResult = "View Branch";
        //Actual Result
        String actualBranchResult = approvalConsolePage.getApprovedConsoleScreenBranchViewScreen();
        //Compare Results
        Assert.assertEquals(actualBranchResult, expectedBranchResult, "User navigate to the View Branch Screen!");
    }

    @Test(testName = "Verify the user can approve the created branch", priority = 2)
    public void approveBranch() throws InterruptedException{
        approvalConsolePage.scrollUp();
        Thread.sleep(1000);
        approvalConsolePage.clickApprovalConsoleButton();
        approvalConsolePage.setSelectValuesFromModuleDd();
        approvalConsolePage.setSelectValuesFromStatusDd();
        approvalConsolePage.enterSearchBranchName("BGC765");
        approvalConsolePage.clickApproveViewButton();
        approvalConsolePage.enterApprovedComment("Ok");
        approvalConsolePage.clickApprovedButton();

        //Expected Result
        String expectedApprovedBranchResult = "×\n" +
                "Success - Branch Approved Successfully.";
        //Actual Result
        String actualBranchResult = approvalConsolePage.getBranchApprovedSuccessMessage();
        //Compare Results
        Assert.assertEquals(actualBranchResult, expectedApprovedBranchResult, "Success message not same!");
    }

    @Test(testName = "Verify the user can approve the created broker", priority = 2)
    public void approveBroker() throws InterruptedException{
        approvalConsolePage.scrollUp();
        Thread.sleep(1000);
        approvalConsolePage.clickApprovalConsoleButton();
        approvalConsolePage.setSelectValuesFromModuleDd1();
        approvalConsolePage.setSelectValuesFromStatusDd();
        approvalConsolePage.enterSearchBroker("055");
        approvalConsolePage.clickApproveViewButton();
        approvalConsolePage.enterApprovedComment("Ok");
        approvalConsolePage.clickApprovedButton();

        //Expected Result
        String expectedApprovedBranchResult = "×\n" +
                "Success - Stock Broker Approved Successfully.";
        //Actual Result
        String actualBranchResult = approvalConsolePage.getBrokerApprovedSuccessMessage();
        //Compare Results
        Assert.assertEquals(actualBranchResult, expectedApprovedBranchResult, "Success message not same!");
    }


}
