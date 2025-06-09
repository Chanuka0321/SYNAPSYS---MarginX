package com.synapsys.Tests;

import com.synapsys.Base.BaseTest;
import com.synapsys.Pages.FileUploadPage;
import com.synapsys.Pages.LoanableFilePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoanableFileTest extends BaseTest {

    private LoanableFilePage loanableFilePage;

    @BeforeMethod
    public void setupLoginTest() throws InterruptedException {
        login("ChanukaM","20@TC*sa");  //Use the reusable Login Method
        loanableFilePage = new LoanableFilePage(driver);
    }


    @Test(testName = "Verify the user can select date from date picker", priority = 2)
    public void selectDateFromDatePicker() throws InterruptedException{
        loanableFilePage.clickProcessButton();
        loanableFilePage.clickLoanableFileButton();
        loanableFilePage.selectDate("04-July-2022");
        loanableFilePage.selectBrokerFromDropdown();
        loanableFilePage.clickGenerateButton();
    }
}
