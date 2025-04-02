package com.synapsys.Pages;

import com.synapsys.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerPage extends BaseTest {

    private final WebDriver driver;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private static final By masterDataButton = By.xpath("//div[@class='side-nav-item level-0 collapsed'][1]");
    private static final By customerButton = By.xpath("//a[@label='Customers']");
    private static final By createCustomerButton = By.xpath("//a[@href='/MarginXWeb/masterdata/Customer/create']");
    private static final By marginTradingToggleButton = By.xpath("//label[@for='marginTrading']");
    private static final By branchNameFromDropDown = By.id("branchId");
    private static final By titleFromDropDown = By.id("title");
    private static final By initialsField = By.id("initials");
    private static final By namesDenotedByInitialsField = By.id("firstName");
    private static final By surnameField = By.id("lastName");
    private static final By nationalityFromDropDown = By.id("nationality");
    private static final By occupationField = By.id("occupation");
    private static final By dateOfBirthField = By.id("dateOfBirth");
    private static final By nicField = By.id("nicNo");
    private static final By registrationDateField = By.id("registrationDate");
    private static final By maritalStatusFromDropDown = By.id("maritalStatus");
    private static final By mailAddressField = By.id("mailAddress");
    private static final By permanentAddressField = By.id("permanentAddress");
    private static final By telephoneNoField = By.id("telNo");
    private static final By mobileNoField = By.id("mobileNo");
    private static final By emailField = By.id("email");
    private static final By nextButton = By.id("next-button");


    //Actions

    public void clickMasterdatabutton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement masterdataBtn = wait.until(ExpectedConditions.elementToBeClickable(masterDataButton));
        masterdataBtn.click();
    }

    public void clickCustomerButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement customerBtn = wait.until(ExpectedConditions.elementToBeClickable(customerButton));
        customerBtn.click();
    }

    public String getCustomerHomeScreenUrl() {
        return driver.getCurrentUrl(); //Capture the current URL after Login
    }

    public void clickCREATECUSTOMERButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement createCustomerBtn = wait.until(ExpectedConditions.elementToBeClickable(createCustomerButton));
        createCustomerBtn.click();
    }

    public String getCustomerDetailsScreenUrl() {
        return driver.getCurrentUrl(); //Capture the current URL after Login
    }

    public void clickMarginTradingToggleButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement marginTradingBtn = wait.until(ExpectedConditions.elementToBeClickable(marginTradingToggleButton));
        marginTradingBtn.click();
    }

    public void selectBranchNameFromBranchNameDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesBranchNameBtn = wait.until(ExpectedConditions.elementToBeClickable(branchNameFromDropDown));
        Select branchNameSelect = new Select(valuesBranchNameBtn);
        branchNameSelect.selectByVisibleText("Gampaha");
    }

    public void selectTitleFromTitleDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesTitleBtn = wait.until(ExpectedConditions.elementToBeClickable(titleFromDropDown));
        Select titleSelect = new Select(valuesTitleBtn);
        titleSelect.selectByVisibleText("Mr");
    }

    public void enterInitials(String initials) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement initialsInput = wait.until(ExpectedConditions.visibilityOfElementLocated(initialsField));
        initialsInput.sendKeys(initials);
    }

    public void enterNamesDenotedByInitials(String namesDenotedInitials) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement namesDenotedInitialsInput = wait.until(ExpectedConditions.visibilityOfElementLocated(namesDenotedByInitialsField));
        namesDenotedInitialsInput.sendKeys(namesDenotedInitials);
    }

    public void enterSurName(String surname) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement surnameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(surnameField));
        surnameInput.sendKeys(surname);
    }

    public void selectNationalityDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesTitleBtn = wait.until(ExpectedConditions.elementToBeClickable(nationalityFromDropDown));
        Select nationalitySelect = new Select(valuesTitleBtn);
        nationalitySelect.selectByVisibleText("SL");
    }

    public void enterOccupation(String occupation) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement occupationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(occupationField));
        occupationInput.sendKeys(occupation);
    }

    public void enterDateOfBirth(String dateOfBirth) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dateOfBirthInput = wait.until(ExpectedConditions.visibilityOfElementLocated(dateOfBirthField));
        dateOfBirthInput.sendKeys(dateOfBirth);
    }

    public void enterNic(String nic) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nicInput = wait.until(ExpectedConditions.visibilityOfElementLocated(nicField));
        nicInput.sendKeys(nic);
    }

    public void enterRegistrationDate(String registrationDate) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement registrationDateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(registrationDateField));
        registrationDateInput.sendKeys(registrationDate);
    }

    public void selectMaritalStatusDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesTitleBtn = wait.until(ExpectedConditions.elementToBeClickable(maritalStatusFromDropDown));
        Select maritalStatusSelect = new Select(valuesTitleBtn);
        maritalStatusSelect.selectByVisibleText("Married");
    }

    public void enterMailAddress(String mailAddress) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mailAddressInput = wait.until(ExpectedConditions.visibilityOfElementLocated(mailAddressField));
        mailAddressInput.sendKeys(mailAddress);
    }

    public void enterPermenentAddress(String permanentAddress) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement permanentAddressInput = wait.until(ExpectedConditions.visibilityOfElementLocated(permanentAddressField));
        permanentAddressInput.sendKeys(permanentAddress);
    }

    public void enterTelephoneNo(String telephoneNo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement telephoneNoInput = wait.until(ExpectedConditions.visibilityOfElementLocated(telephoneNoField));
        telephoneNoInput.sendKeys(telephoneNo);
    }

    public void enterMobileNo(String mobileNo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mobileNoInput = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNoField));
        mobileNoInput.sendKeys(mobileNo);
    }

    public void enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailInput.sendKeys(email);
    }

    public void clickNEXTButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextBtn.click();
    }






}
