package com.synapsys.Pages;

import com.synapsys.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrokerPage extends BaseTest {

    private final WebDriver driver;

    public BrokerPage(WebDriver driver){
        this.driver = driver;
    }

    //Locators
    private static final By masterDataButton = By.xpath("//div[@class='side-nav-item level-0 collapsed'][1]");
    private static final By brokerButton = By.xpath("//a[@label='Brokers']");
    private static final By brokerCreateButton = By.xpath("//a[@href='/MarginXWeb/masterdata/StockBrokers/create']");
    private static final By brokerCodeField = By.id("brokerCode");
    private static final By brokerNameField = By.id("brokerName");
    private static final By addressField = By.id("address");
    private static final By notificationEmailField = By.id("email");
    private static final By settlementBankDropDown = By.id("cbank");
    private static final By settlementBankBranchDropDown = By.id("cbranchType");
    private static final By settlementAccountTypeDropDown = By.id("caccountType");
    private static final By settlementAccountNoField = By.id("caccountNo");
    private static final By saveButtonField = By.xpath("//input[@type=\"submit\"]");
    private static final By brokerCreatedSuccessMessage = By.xpath("//div[@class='alert alert-success']");


    //Actions
    public void clickMasterdatabutton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement masterdataBttn = wait.until(ExpectedConditions.elementToBeClickable(masterDataButton));
        masterdataBttn.click();
    }

    public void clickBrokerButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement brokerBtn = wait.until(ExpectedConditions.elementToBeClickable(brokerButton));
        brokerBtn.click();
    }

    public String getBrokerHomeScreenUrl() {
        return driver.getCurrentUrl(); //Capture the current URL after Login
    }

    public void clickBrokerCreateButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement brokerCreateBtn = wait.until(ExpectedConditions.elementToBeClickable(brokerCreateButton));
        brokerCreateBtn.click();
    }

    public String getBrokerCreateScreenUrl() {
        return driver.getCurrentUrl(); //Capture the current URL after Login
    }

    public void enterBrokerCode(String brokerCode){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement brokerCodeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(brokerCodeField));
        brokerCodeInput.sendKeys(brokerCode);
    }

    public void enterBrokerName(String brokerName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement brokerNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(brokerNameField));
        brokerNameInput.sendKeys(brokerName);
    }

    public void enterAddress(String address){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addressInput = wait.until(ExpectedConditions.visibilityOfElementLocated(addressField));
        addressInput.sendKeys(address);
    }

    public void enterNotificationEmail(String email){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement notificationEmailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(notificationEmailField));
        notificationEmailInput.sendKeys(email);
    }

    public void selectSettlementBankDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesTitleBtn = wait.until(ExpectedConditions.elementToBeClickable(settlementBankDropDown));
        Select settlementBankSelect = new Select(valuesTitleBtn);
        settlementBankSelect.selectByVisibleText("Commercial Bank");
    }

    public void selectSettlementBankBranchDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesTitleBtn = wait.until(ExpectedConditions.elementToBeClickable(settlementBankBranchDropDown));
        Select settlementBankBranchSelect = new Select(valuesTitleBtn);
        settlementBankBranchSelect.selectByVisibleText("Gampaha");
    }

    public void selectSettlementAccountTypeDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesTitleBtn = wait.until(ExpectedConditions.elementToBeClickable(settlementAccountTypeDropDown));
        Select settlementAccountTypeSelect = new Select(valuesTitleBtn);
        settlementAccountTypeSelect.selectByVisibleText("Saving");
    }

    public void enterAccountNo(String accountNo){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement settlementAccountNoInput = wait.until(ExpectedConditions.visibilityOfElementLocated(settlementAccountNoField));
        settlementAccountNoInput.sendKeys(accountNo);
    }

    public void scrollUp(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
    }

    public void clickSAVEButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveButtonField));
        saveBtn.click();
    }

    public String getBrokerCreateSuccessMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMsgElement = wait.until(ExpectedConditions.elementToBeClickable(brokerCreatedSuccessMessage));
        return successMsgElement .getText();
    }




}
