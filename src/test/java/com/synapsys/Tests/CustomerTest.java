package com.synapsys.Tests;

import com.synapsys.Base.BaseTest;
import com.synapsys.Pages.BranchPage;
import com.synapsys.Pages.CustomerPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    private CustomerPage customerPage;
    private BranchPage branchPage;

    @BeforeMethod
    public void setupLoginTest() throws InterruptedException {
        login("ChanukaM","20@TC*sa");  //Use the reusable Login Method
        customerPage = new CustomerPage(driver);
    }

    @Test(testName = "Verify tha user can redirect to the customers screen", priority = 2)
    public void redirectToTheCustomerHomeScreen() throws InterruptedException{
        customerPage.clickMasterdatabutton();
        customerPage.clickCustomerButton();

        //Expected Result
        String expectedUrl = "https://iam-qa.synapsys.lk:57575/MarginXWeb/masterdata/Customer/index";
        //Actual Result
        String actualUrl = customerPage.getCustomerHomeScreenUrl();
        //Compare Actual Result and Expected Result
        Assert.assertEquals(actualUrl, expectedUrl,"User Not Redirect To The Customer Home Screen!");
    }

    @Test(testName = "Verify the user can redirect to the 'Customer Details' screen", priority = 2)
    public void redirectToTheCustomerDetailsScreen() throws InterruptedException{
        customerPage.clickMasterdatabutton();
        customerPage.clickCustomerButton();
        customerPage.clickCREATECUSTOMERButton();

        //Expected Result
        String expectedUrl = "https://iam-qa.synapsys.lk:57575/MarginXWeb/masterdata/Customer/create";
        //Actual Result
        String actualUrl = customerPage.getCustomerDetailsScreenUrl();
        //Compare Actual Result and Expected Result
        Assert.assertEquals(actualUrl, expectedUrl,"User Not Redirect To The Customer Details Screen!");
    }

    @Test(testName = "Verify the user can create a new customer", priority = 2)
    public void createNewCustomer() throws InterruptedException{
        customerPage.clickMasterdatabutton();
        customerPage.clickCustomerButton();
        customerPage.clickCREATECUSTOMERButton();
        customerPage.clickMarginTradingToggleButton();
        customerPage.selectBranchNameFromBranchNameDropdown();
        customerPage.selectTitleFromTitleDropdown();
        customerPage.enterInitials("M.K.D.I.R");
        customerPage.enterNamesDenotedByInitials("Madawala Keralage Dinusha Ishadini");
        customerPage.enterSurName("Rathnayake");
        customerPage.selectNationalityDropdown();
        customerPage.enterOccupation("Employed");
        customerPage.enterDateOfBirth("21-03-1998");
        customerPage.enterNic("972938047V");
        customerPage.enterRegistrationDate("01-04-2025");
        customerPage.selectMaritalStatusDropdown();
        customerPage.enterMailAddress("No 12/56 Kaduruwela, Malabe");
        customerPage.enterPermenentAddress("Colombo");
        customerPage.enterTelephoneNo("0789152630");
        customerPage.enterMobileNo("0749103658");
        customerPage.enterEmail("nayanajith.mandawela@gmail.com");
        customerPage.clickNEXTButton();

    }

}
