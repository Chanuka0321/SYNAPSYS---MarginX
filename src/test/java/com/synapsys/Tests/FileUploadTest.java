package com.synapsys.Tests;

import com.synapsys.Base.BaseTest;
import com.synapsys.Pages.FileUploadPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    private FileUploadPage fileUploadPage;

    @BeforeMethod
    public void setupLoginTest() throws InterruptedException {
        login("ChanukaM","20@TC*sa");  //Use the reusable Login Method
        fileUploadPage = new FileUploadPage(driver);
    }

    @Test(testName = "Verify the user can upload CDS Lodgment file", priority = 2)
    public void uploadCDSLodgmentFile() throws InterruptedException{
        fileUploadPage.clickProcessButton();
        fileUploadPage.clickFileUploadButton();
        fileUploadPage.clickUploadFileButton();

        fileUploadPage.selectCategoryFromCategoryDropdown();
        fileUploadPage.selectFileTypeFromFileTypeDropdown();
        fileUploadPage.selectBrokerFromBrokerDropdown();
        fileUploadPage.clickChooseFileButton("C:\\Users\\ChanukaM\\Desktop\\Sampath MarginX Automation Files\\M Senarathna (Sampath)\\M Senarathna (Sampath)\\CDS Lodgemet.txt");
        fileUploadPage.clickUploadButton();
    }

    @Test(testName = "Verify the user can add file", priority = 2)
    public void uploadDailyTransactionFile() throws InterruptedException{
        fileUploadPage.clickProcessButton();
        fileUploadPage.clickFileUploadButton();
        fileUploadPage.clickUploadFileButton();
        fileUploadPage.selectCategoryFromCategoryDropdown();
        fileUploadPage.selectFileTypeFromFileTypeDropdown1();
        fileUploadPage.selectBrokerFromBrokerDropdown2();
        fileUploadPage.clickChooseFileButton("C:\\Users\\ChanukaM\\Desktop\\Sampath MarginX Automation Files\\M Senarathna (Sampath)\\M Senarathna (Sampath)\\daily transaction (SDW).txt");
        fileUploadPage.clickUploadButton();
    }

    @Test(testName = "Verify the user can add market price file", priority = 2)
    public void uploadMarketPriceFile() throws InterruptedException{
        fileUploadPage.clickProcessButton();
        fileUploadPage.clickFileUploadButton();
        fileUploadPage.clickUploadFileButton();
        fileUploadPage.selectCategoryFromCategoryDropdown2();
        fileUploadPage.selectFileTypeFromFileTypeDropdown2();
        fileUploadPage.clickChooseFileButton("C:\\Users\\ChanukaM\\Desktop\\Sampath MarginX Automation Files\\M Senarathna (Sampath)\\M Senarathna (Sampath)\\Closed market (SDW).txt");
        fileUploadPage.clickUploadButton();
    }

    @Test(testName = "Verify the user can validate the uploaded LDS Codgment File", priority = 3)
    public void validateCDSLodgmentFile() throws InterruptedException{
        fileUploadPage.clickProcessButton();
        fileUploadPage.clickFileUploadButton();
        fileUploadPage.selectCDSLodgementFile();
        Thread.sleep(200);
        fileUploadPage.clickValidateButton();
        fileUploadPage.clickValidateButton2();

        //Expected  Result
        String expectedSuccessMessage = "Success - Successfully Validated.";
        //Actual Result
        String actualSuccessMessage = fileUploadPage.getSuccessMessage();
        //Compare
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Success Message Not match!");
    }

    @Test(testName = "Verify the user can validate the uploaded Daily Transaction File", priority = 3)
    public void validateDailyTransactionFile() throws InterruptedException{
        fileUploadPage.clickProcessButton();
        fileUploadPage.clickFileUploadButton();
        fileUploadPage.selectDailyTransactionFile();
        Thread.sleep(200);
        fileUploadPage.clickValidateButton();
        fileUploadPage.clickValidateButton2();

        //Expected  Result
        String expectedSuccessMessage = "×\n" +
                "Success - Successfully Validated.";
        //Actual Result
        String actualSuccessMessage = fileUploadPage.getSuccessMessage();
        //Compare
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Success Message Not match!");
    }

    @Test(testName = "Verify the user can validate the uploaded Market Price File", priority = 3)
    public void validateMarketPriceFile() throws InterruptedException{
        fileUploadPage.clickProcessButton();
        fileUploadPage.clickFileUploadButton();
        fileUploadPage.selectMarketPriceFile();
        Thread.sleep(200);
        fileUploadPage.clickValidateButton();
        fileUploadPage.clickValidateButton2();

        //Expected  Result
        String expectedSuccessMessage = "×\n" +
                "Success - Successfully Validated.";
        //Actual Result
        String actualSuccessMessage = fileUploadPage.getSuccessMessage();
        //Compare
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Success Message Not match!");
    }

}
