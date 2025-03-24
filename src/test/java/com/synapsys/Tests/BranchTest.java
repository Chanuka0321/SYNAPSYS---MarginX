package com.synapsys.Tests;

import com.beust.ah.A;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.synapsys.Base.BaseTest;
import com.synapsys.Pages.BranchPage;
import com.synapsys.Pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.transform.sax.SAXResult;

public class BranchTest extends BaseTest {

    private BranchPage branchPage;


    @BeforeMethod
    public void setupLoginTest() throws InterruptedException {
        login("ChanukaM","20@TC*sa");  //Use the reusable Login Method
        branchPage = new BranchPage(driver);
    }

    @Test(testName = "Verify to the user navigate to Branch home screen after clicking the branch button on master data", priority = 2)
    public void redirectToBranchHome() throws InterruptedException {
        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();

        //Expected Result
        String expectedUrl = "https://iam-qa.synapsys.lk:57575/MarginXWeb/masterdata/Branches/index"; //Change as needed
        //Actual Result
        String actualUrl = branchPage.getBranchHomeScreenUrl();
        //Compare Results
        Assert.assertEquals(actualUrl, expectedUrl, "User Not Redirect To The Branch Home Screen!");
    }

    @Test(testName = "Verify to the user navigate to Branch Create screen after clicking the create branch button on master data", priority = 2)
    public void redirectToBranchCreateScreen() throws InterruptedException {

        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();

        //Expected Result
        String expectedUrl = "https://iam-qa.synapsys.lk:57575/MarginXWeb/masterdata/branches/create";
        //Actual Result
        String actualUrl = branchPage.getBranchCreateScreenUrl();
        //Compare Results
        Assert.assertEquals(actualUrl, expectedUrl, "User Not Redirect To The Branch Create Screen!");

    }

    @Test(testName = "Verify the user can create a new branch", priority = 1)
    public void createNewBranch () throws InterruptedException {
        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();
        branchPage.enterBranchCode("LDK938");
        branchPage.enterBranchName("Mawanella DFCC");
        branchPage.enterAddress("No 52/78 Rathnapura road, Mawanella.");
        branchPage.enterEmail("mawanella.synapsys@dfcc.lk");
        branchPage.enterTelephone("0775198345");
        branchPage.enterFax("0116198523");
        branchPage.enterExecutiveCredit("1,000.00");
        branchPage.enterExecutiveCreditEmail("mawanella.synapsys@gmail.com");
        branchPage.enterComment("Please Approved this Branch.");
        Thread.sleep(2000);
        branchPage.clickBranchSaveButton();
        Thread.sleep(1000);

        //Expected Result
        String expectedMessage = "×\n" +
                "Success - Branch Created Successfully.";
        //Actual Result
        String actualMessage = branchPage.getCreateSuccessMessage1();
        //Compare
        //Assert.assertEquals(ex, expectedUrl, "User Not Redirect To The Branch Create Screen!");
        Assert.assertEquals(actualMessage, expectedMessage, "Success Message Not match!");
    }

    @Test(testName = "Verify the user cannot create a new branch without entering branch code", priority = 2)
    public void createBranchEmptyBranchCode() throws InterruptedException{

        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();
        branchPage.enterBranchCode("");
        branchPage.enterBranchName("Head Office DFCC");
        branchPage.enterAddress("No 12/157 Nawam Mawatha, Nugegoda");
        branchPage.enterEmail("headofficedfcc.synapsys@dfcc.lk");

        Thread.sleep(2000);
        branchPage.clickBranchSaveButton();
        Thread.sleep(1000);

        //Expected Result
        String expectedRequiredBranchCodeMsg = "Please Input a Valid Branch Code.";
        //Actual Result
        String actualRequiredBranchCodeMsg = branchPage.getBranchCodeValidationMessage();
        //Compare
        Assert.assertEquals(actualRequiredBranchCodeMsg, expectedRequiredBranchCodeMsg,"Branch Code Required Validation Message is Not Match!");

    }

    @Test(testName = "Verify the user cannot create a new branch without entering branch name", priority = 2)
    public void createBranchEmptyBranchname() throws InterruptedException{
        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();
        branchPage.enterBranchName("");

        Thread.sleep(2000);
        branchPage.clickBranchSaveButton();
        Thread.sleep(1000);

        String expectedRequiredBranchNameMsg = "Please Input a Branch Name.";
        String actutalRequiredBranchNameMsg = branchPage.getBranchNameValidationMessage();
        Assert.assertEquals(actutalRequiredBranchNameMsg, expectedRequiredBranchNameMsg, "Branch Name Required Validation Message Not Match!");
    }

    @Test(testName = "Verify the user cannot create a new branch without entering address", priority = 2)
    public void createBranchEmptyAddress() throws InterruptedException {
        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();
        branchPage.enterAddress("");

        Thread.sleep(2000);
        branchPage.clickBranchSaveButton();
        Thread.sleep(1000);


        String expectedRequiredAddressMsg = "Please Input an Address.";
        String actualRequiredAddressMsg = branchPage.getAddressValidationMessage();
        Assert.assertEquals(actualRequiredAddressMsg, expectedRequiredAddressMsg,"Address Required Validation Message Not Match!");
    }

    @Test(testName = "Verify the user cannot create a new branch without entering email", priority = 2)
    public void createBranchEmptyEmail() throws InterruptedException{
        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();
        branchPage.enterEmail("");

        Thread.sleep(2000);
        branchPage.clickBranchSaveButton();
        Thread.sleep(1000);

        //Expected Result
        String expectedRequiredEmailMsg = "Please Input a Valid Email.";
        String actualRequiredEmailMsg = branchPage.getEmailValidationMessage();
        Assert.assertEquals(actualRequiredEmailMsg, expectedRequiredEmailMsg, "Address Required Validation Message Not Match!");
    }

    @Test(testName = "Verify the user can add special characters to Branch Code filed", priority = 2)
    public void createBranchCodeWithSpecialCharacter() throws InterruptedException{
        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();
        branchPage.enterBranchCode("!@#$");

        Thread.sleep(2000);
        branchPage.clickBranchSaveButton();
        Thread.sleep(1000);

        //Expected Result
        String expectedRequiredBranchCodeMsg = "Please Input a Valid Branch Code.";
        String actualRequiredBranchCodeMsg = branchPage.getBranchCodeValidationMessage();
        Assert.assertEquals(actualRequiredBranchCodeMsg, expectedRequiredBranchCodeMsg,"Branch Code Required Validation Message is Not Match!");
    }

    @Test(testName = "Validate the format of 'Address' field", priority = 2)
    public void addressFieldFormat() throws InterruptedException{
        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();
        branchPage.enterBranchCode("NBC938");
        branchPage.enterBranchName("Ampara 1");
        branchPage.enterAddress("No 12.158\n" +
                "Malwana Road\n" +
                "Mirigama");
        branchPage.enterEmail("deniyayasivali.synapsys@dfcc.lk");

        Thread.sleep(2000);
        branchPage.clickBranchSaveButton();
        Thread.sleep(1000);

        //Expected Result
        String expectedMessage = "×\n" +
                "Success - Branch Created Successfully.";
        //Actual Result
        String actualMessage = branchPage.getCreateSuccessMessage1();
        //Compare
        //Assert.assertEquals(ex, expectedUrl, "User Not Redirect To The Branch Create Screen!");
        Assert.assertEquals(actualMessage, expectedMessage, "Success Message Not match!");

    }

    @Test(testName = "Verify the user can add invalid email format for email field", priority = 2)
    public void invalidEmailAddress() throws InterruptedException{
        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();
        branchPage.enterEmail("Pothuhara.dfccgmail.com");

        Thread.sleep(2000);
        branchPage.clickBranchSaveButton();
        Thread.sleep(1000);

        //Expected Result
        String expectedRequiredEmailMsg = "Please Input a Valid Email.";
        String actualRequiredEmailMsg = branchPage.getEmailValidationMessage();
        Assert.assertEquals(actualRequiredEmailMsg, expectedRequiredEmailMsg, "Address Required Validation Message Not Match!");
    }

    @Test(testName = "Verify the user can add invalid telephone number", priority = 2)
    public void invalidTelephoneNo() throws InterruptedException{
        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();
        branchPage.enterTelephone("0765");

        Thread.sleep(2000);
        branchPage.clickBranchSaveButton();
        Thread.sleep(1000);

        String expectedRequiredTelephoneMsg = "Please Enter a Valid Phone Number.";
        String actualRequiredTelephoneMsg = branchPage.getTelephoneNoValidationMessage();
        Assert.assertEquals(actualRequiredTelephoneMsg, expectedRequiredTelephoneMsg,"Telephone Required Message Not Match!");

    }

    @Test(testName = "Verify the user can enter the charcters for the fax number", priority = 2)
    public void invalidFaxNo() throws InterruptedException{
        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();
        branchPage.enterFax("011");

        Thread.sleep(2000);
        branchPage.clickBranchSaveButton();
        Thread.sleep(1000);

        String expectedRequiredFaxMsg = "Please Enter a Valid Fax Number.";
        String actualRequiredFaxMsg = branchPage.getFaxNoValidationMessage();
        Assert.assertEquals(actualRequiredFaxMsg, expectedRequiredFaxMsg,"Fax Required Message Not Match!");
    }

    @Test(testName = "Verify the user can add Existing Branch Code", priority = 2)
    public void existingBranchCode() throws InterruptedException{
        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();
        branchPage.enterBranchCode("008E");

        Thread.sleep(2000);
        branchPage.clickBranchSaveButton();
        Thread.sleep(1000);

        String expectedExistingBranchCodeValidationMsg = "Existing Code. Enter a New Code.";
        String actualExistingBranchCodeValidationMsg = branchPage.getBranchCodeValidationMessages();
        Assert.assertEquals(actualExistingBranchCodeValidationMsg, expectedExistingBranchCodeValidationMsg, "Existing Branch Code Validation Message Not Match!");
    }

    @Test(testName = " Verify the user can add Existing Branch Name", priority = 2)
        public void existingBranchName() throws InterruptedException{
        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();
        branchPage.enterBranchName("Dickwella");

        Thread.sleep(2000);
        branchPage.clickBranchSaveButton();
        Thread.sleep(1000);

        String expectedExistingBranchNameValidationMsg = "Existing Name. Enter a New Name.";
        String actualExistingBranchNameValidationMsg = branchPage.getBranchNameValidationMessages();
        Assert.assertEquals(actualExistingBranchNameValidationMsg, expectedExistingBranchNameValidationMsg, "User can added Existing Branch Name!");
    }


    @Test(testName = "Verify the user can add invalid executive email address", priority = 2)
    public void invalidExecutiveEmail() throws InterruptedException{
        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();
        branchPage.enterExecutiveCreditEmail("thejan.kodithuwakkugmail.com");
        Thread.sleep(2000);
        branchPage.clickBranchSaveButton();
        Thread.sleep(1000);

        String expectedResultInvalidExecutiveEmail ="Please Input a Valid Email.";
        String actualResultInvalidExecutiveEmail = branchPage.getExecutiveCreditEmail();
        Assert.assertEquals(actualResultInvalidExecutiveEmail, expectedResultInvalidExecutiveEmail,"Executive Required Messages not Match!");
    }

    @Test(testName = "Validate the format of 'Comment' field", priority = 2)
    public void commentFieldFormat() throws InterruptedException{
        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();
        branchPage.enterBranchCode("HBD837");
        branchPage.enterBranchName("Kai Beach");
        branchPage.enterAddress("No 120, Nalla Road, Hakurukumbura, Mirigama");
        branchPage.enterEmail("junglebeach.synapsys@dfcc.lk");
        branchPage.enterTelephone("0716183469");
        branchPage.enterFax("0114316082");
        branchPage.enterExecutiveCredit("1,000.00");
        branchPage.enterExecutiveCreditEmail("dulani.ekanayake@gmail.com");
        branchPage.enterComment("Test512@\n" +
                "colombo\n" +
                "created the branch successfully.");
        Thread.sleep(2000);
        branchPage.clickBranchSaveButton();
        Thread.sleep(1000);

        String expectedCommentFieldFormat = "×\n" +
                "Success - Branch Created Successfully.";
        //Actual Result
        String actualCommentFieldFormat = branchPage.getCreateSuccessMessage1();
        //Compare
        //Assert.assertEquals(ex, expectedUrl, "User Not Redirect To The Branch Create Screen!");
        Assert.assertEquals(actualCommentFieldFormat, expectedCommentFieldFormat, "Success Message Not match!");
    }

    @Test(testName = " Verify the user can add Existing Executive Credit Email", priority = 2)
    public void existingExecutiveCreditEmail() throws InterruptedException{
        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();
        branchPage.enterExecutiveCreditEmail("chanuka0321@gmail.com");

        Thread.sleep(2000);
        branchPage.clickBranchSaveButton();
        Thread.sleep(1000);

        String expectedExistingExecutiveCreditEmail = "Existing Executive Credit Email. Enter a new Credit Email.";
        String actualExistingExecutiveCreditEmail = branchPage.existingExecutiveCreditEmail();
        Assert.assertEquals(actualExistingExecutiveCreditEmail, expectedExistingExecutiveCreditEmail,"Existing Executive Email Validation Message is Not Match!");
    }

    @Test(testName = " Verify the user can add Existing Telephone Number", priority = 2)
    public void existingTelephoneNo() throws InterruptedException{
        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();
        branchPage.enterTelephone("3216543215");

        Thread.sleep(2000);
        branchPage.clickBranchSaveButton();
        Thread.sleep(1000);

        String expectedexistingTelephoneNo = "Existing Telephone Number. Enter a new Telephone Number.";
        String actualexistingTelephoneNo = branchPage.existingTelephoneNo();
        Assert.assertEquals(actualexistingTelephoneNo, expectedexistingTelephoneNo,"Existing Telephone No Validation Message is Not Match");
    }

    @Test(testName = " Verify the user can add Existing Email Address.", priority = 2)
    public void existingEmailAddress() throws InterruptedException{
        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();
        branchPage.enterBranchCode("NCB928");
        branchPage.enterBranchName("Jungle Beach");
        branchPage.enterAddress("No 120, Nalla Road, Hakurukumbura, Mirigama");
        branchPage.enterEmail("chanuka0321@gmail.com");

        Thread.sleep(2000);
        branchPage.clickBranchSaveButton();
        Thread.sleep(1000);

        String expectedExistingEmailAddressValidationMsg = "Existing Email. Enter a new Email.";
        String actualExistingEmailAddress = branchPage.existingEmailAddress();
        Assert.assertEquals(actualExistingEmailAddress, expectedExistingEmailAddressValidationMsg,"Existing Email Address Messages Not Match");
    }

    @Test(testName = "Validate the functionality of 'CLEAR' button at the create screen", priority = 2)
    public void clearButton() throws InterruptedException{
        branchPage.clickMasterdatabutton();
        branchPage.clickBranchButton();
        branchPage.clickCreateBranchButton();
        branchPage.enterBranchCode("JNW0192");
        branchPage.enterBranchName("Kuruwita Erathna");
        branchPage.enterAddress("Rathnapura");
        branchPage.enterEmail("kuruwitaerathna.synapsys@dfcc.lk");
        branchPage.enterTelephone("0715436925");
        branchPage.enterFax("0112430895");
        branchPage.enterExecutiveCredit("1,000.00");
        branchPage.enterExecutiveCreditEmail("senuri.rodrigo@gmail.com");
        branchPage.enterComment("Please Approved this Branch Before ToNight.");

        Thread.sleep(2000);
        branchPage.clickClearButton();
        Thread.sleep(1000);

        String expectedResultClearBtn = "";
        String actualResultClearBtn = branchPage.expectedEmptyBranchCode();
        Assert.assertEquals(actualResultClearBtn, expectedResultClearBtn,"Branch Code Field is Not Cleared");
    }
}

