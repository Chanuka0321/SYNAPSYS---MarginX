package com.synapsys.Tests;

import com.synapsys.Base.BaseTest;
import com.synapsys.Pages.FileUploadPage;
import com.synapsys.Pages.ManualCDSLodgmentsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManualCDSLodgmentsTest extends BaseTest {


    private ManualCDSLodgmentsPage manualCDSLodgmentsPage;

    @BeforeMethod
    public void setupLoginTest() throws InterruptedException {
        login("ChanukaM","20@TC*sa");  //Use the reusable Login Method
        manualCDSLodgmentsPage = new ManualCDSLodgmentsPage(driver);
    }

    @Test(testName = "Verify the user can add Manual CDS Lodgment" , priority = 2)
    public void addToTheManualCDSLoggment() throws InterruptedException{
        manualCDSLodgmentsPage.clickProcessButton();
        manualCDSLodgmentsPage.clickManualCDSLodgmentButton();
        manualCDSLodgmentsPage.selectBranchFromBranchDropdown();
        manualCDSLodgmentsPage.selectStockBrokerFromStockBrokerDropdown();
        manualCDSLodgmentsPage.selectCustomerFromCustomerDropdown();
        manualCDSLodgmentsPage.selectCompanyCodeFromCompanyCodeDropdown();
        manualCDSLodgmentsPage.selectAdditionTypeFromAdditionTypeDropdown();
        manualCDSLodgmentsPage.enterQuantity("13");
        manualCDSLodgmentsPage.clickADDButton();
        Thread.sleep(100);

        manualCDSLodgmentsPage.clickVALIDATEButton();

        //Expected  Result
        String expectedBrokerSuccessMessage =  "×\n" +
                "Success - Manual Lodgment Validated Successfully.";
        //Actual Result
        String actualBrokerSuccessMessage = manualCDSLodgmentsPage.getValidateSuccessMessage1();
        //Compare
        Assert.assertEquals(actualBrokerSuccessMessage, expectedBrokerSuccessMessage, "Validation Success Message Not match!");
    }

}
