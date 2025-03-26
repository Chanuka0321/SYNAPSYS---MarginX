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


}
