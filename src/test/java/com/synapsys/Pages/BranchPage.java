package com.synapsys.Pages;

import com.synapsys.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BranchPage extends BaseTest {

    private final WebDriver driver;

    public BranchPage(WebDriver driver){
        this.driver = driver;
    }

    //Locators
    private static final By masterDataButton = By.xpath("//div[@class='side-nav-item level-0 collapsed'][1]");
    private static final By branchButton = By.xpath("//a[@label='Branch']");
    private static final By createBranchButton = By.xpath("//a[@class='btn btn-info pull-right']");
    private static final By branchCodeField = By.id("code");
    private static final By branchNameField = By.id("branchName");
    private static final By addressField = By.id("address");
    private static final By emailField = By.id("email");
    private static final By telephoneField = By.id("phoneNo");
    private static final By faxField = By.id("faxcode");
    private static final By executiveCreditField = By.id("excredit");
    private static final By executiveCreditEmailField = By.id("exCreditEmail");
    private static final By branchCommentField = By.id("createdComment");
    private static final By branchSaveButton = By.xpath("//input[@value='Save']");
    private static final By branchCreateSuccessMessage = By.xpath("//div[@class='alert alert-success']");
    private static final By branchCodeValidationMessage = By.xpath("//span[@id='errCode']");
    private static final By branchNameValidationMessage = By.xpath("//span[@id='errBranchName']");
    private static final By telephoneNoValidationMessage = By.id("errPhoneNo");
    private static final By addressValidationMessage = By.id("errAddress");
    private static final By emailAddressValidationMessage = By.id("errEmail");
    private static final By faxValidationMessage = By.id("errFaxcode");
    private static final By existingBranchCodeValidationMessage = By.id("errCode");
    private static final By existingBranchNameValidationMessage = By.id("errBranchName");
    private static final By executiveCreditEmailValidationMessage = By.id("errExCreditEmail");
    private static final By existingExecutiveCreditEmailValidationMessage = By.id("errExCreditEmail");
    private static final By existingTelephoneNumberValidationMessage = By.id("errPhoneNo");
    private static final By existingEmailAddressValidationMessage = By.id("errEmail");
    private static final By clearButton = By.xpath("//input[@class=\"btn btn-warning clear\"]");
    private static final By emptyBranchCodeField = By.id("code");


    //Actions
    public void clickMasterdatabutton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement masterdataBtn = wait.until(ExpectedConditions.elementToBeClickable(masterDataButton));
        masterdataBtn.click();
    }

    public void clickBranchButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement branchBtn = wait.until(ExpectedConditions.elementToBeClickable(branchButton));
        branchBtn.click();
    }

    public void clickCreateBranchButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement createBranchBtn = wait.until(ExpectedConditions.elementToBeClickable(createBranchButton));
        createBranchBtn.click();
    }

    public void clickClearButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clearBranchBtn = wait.until(ExpectedConditions.elementToBeClickable(clearButton));
        clearBranchBtn.click();
    }

    public String getBranchHomeScreenUrl(){
        return driver.getCurrentUrl(); //Capture the current URL after Login
    }

    public String getBranchCreateScreenUrl(){
        return driver.getCurrentUrl();  //Capture the current URL after Login
    }

    public void enterBranchCode(String branchCode){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement branchCodeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(branchCodeField));
        branchCodeInput.sendKeys(branchCode);
    }

    public void enterBranchName(String branchName){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement branchNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(branchNameField));
        branchNameInput.sendKeys(branchName);
    }

    public void enterAddress(String address){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addressInput = wait.until(ExpectedConditions.visibilityOfElementLocated(addressField));
        addressInput.sendKeys(address);
    }

    public void enterEmail(String email){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailInput.sendKeys(email);
    }

    public void enterTelephone(String telephone){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement telephoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(telephoneField));
        telephoneInput.sendKeys(telephone);
    }

    public void enterFax(String fax){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement faxInput = wait.until(ExpectedConditions.visibilityOfElementLocated(faxField));
        faxInput.sendKeys(fax);
    }

    public void enterExecutiveCredit(String executiveCredit){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement executiveCreditInput = wait.until(ExpectedConditions.visibilityOfElementLocated(executiveCreditField));
        executiveCreditInput.sendKeys(executiveCredit);
    }

    public void enterExecutiveCreditEmail(String executiveCreditEmail){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement executiveCreditEmailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(executiveCreditEmailField));
        executiveCreditEmailInput.sendKeys(executiveCreditEmail);
    }

    public void enterComment(String commentB){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement commentBInput = wait.until(ExpectedConditions.visibilityOfElementLocated(branchCommentField));
        commentBInput.sendKeys(commentB);
    }

    public void clickBranchSaveButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement createBranchSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(branchSaveButton));
        createBranchSaveBtn.click();
    }

    public String getCreateSuccessMessage1(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMsgElement = wait.until(ExpectedConditions.elementToBeClickable(branchCreateSuccessMessage));
        return successMsgElement .getText();
    }

    public String getBranchCodeValidationMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement requiredMsgElement = wait.until(ExpectedConditions.elementToBeClickable(branchCodeValidationMessage));
        return requiredMsgElement.getText();
    }

    public String getBranchNameValidationMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement requiredMsgElement = wait.until(ExpectedConditions.elementToBeClickable(branchNameValidationMessage));
        return requiredMsgElement.getText();
    }

    public String getAddressValidationMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement requiredMsgElement = wait.until(ExpectedConditions.elementToBeClickable((addressValidationMessage)));
        return requiredMsgElement.getText();
    }

    public String getEmailValidationMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement requiredMsgElement = wait.until(ExpectedConditions.elementToBeClickable(emailAddressValidationMessage));
        return requiredMsgElement.getText();
    }

    public String getTelephoneNoValidationMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement requiredMsgElement = wait.until(ExpectedConditions.elementToBeClickable(telephoneNoValidationMessage));
        return requiredMsgElement.getText();
    }

    public String getFaxNoValidationMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement requiredMsgElement = wait.until(ExpectedConditions.elementToBeClickable(faxValidationMessage));
        return requiredMsgElement.getText();
    }

    public String getBranchCodeValidationMessages(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement requiredMsgElement = wait.until(ExpectedConditions.elementToBeClickable(existingBranchCodeValidationMessage));
        return requiredMsgElement.getText();
    }

    public String getBranchNameValidationMessages(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement requiredMsgElement = wait.until(ExpectedConditions.elementToBeClickable(existingBranchNameValidationMessage));
        return requiredMsgElement.getText();
    }

    public String getExecutiveCreditEmail(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement requiredMsgElement = wait.until(ExpectedConditions.elementToBeClickable(executiveCreditEmailValidationMessage));
        return requiredMsgElement.getText();
    }

    public String existingExecutiveCreditEmail(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement requiredMsgElement = wait.until(ExpectedConditions.elementToBeClickable(existingExecutiveCreditEmailValidationMessage));
        return requiredMsgElement.getText();
    }

    public String existingTelephoneNo(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement requiredMsgElement = wait.until(ExpectedConditions.elementToBeClickable(existingTelephoneNumberValidationMessage));
        return requiredMsgElement.getText();
    }

    public String existingEmailAddress(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement requiredMsgElement = wait.until(ExpectedConditions.elementToBeClickable(existingEmailAddressValidationMessage));
        return requiredMsgElement.getText();
    }

    public String expectedEmptyBranchCode(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement requiredMsgElement = wait.until(ExpectedConditions.elementToBeClickable(emptyBranchCodeField));
        return requiredMsgElement.getText();
    }








}
