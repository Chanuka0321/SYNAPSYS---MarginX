package com.synapsys.Pages;

import com.synapsys.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InvestmentAdvisorPage extends BaseTest {

    private final WebDriver driver;

    public InvestmentAdvisorPage(WebDriver driver){
        this.driver = driver;
    }

    //Locators
    private static final By masterDataButton = By.xpath("//div[@class='side-nav-item level-0 collapsed'][1]");
    private static final By investmentAdvisorButton = By.xpath("//a[@label='Investment Advisors']");
    private static final By createINVESTMENTADVISORButton = By.xpath("//a[@href=\"/MarginXWeb/masterdata/InvestmentAdvisors/create\"]");
    private static final By stockBrokerDropDown = By.id("brokerCode");
    private static final By advisorCodeField = By.id("code");
    private static final By advisorNameField = By.id("name");
    private static final By contactNumberField = By.id("contact");
    private static final By emailField = By.id("email");
    private static final By saveButtonField = By.xpath("//input[@type=\"submit\"]");
    private static final By investmentAdvisorCreateSuccessMsg = By.xpath("//div[@class='alert alert-success']");



    //Actions
    public void clickMasterdataBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement masterdataBtn = wait.until(ExpectedConditions.elementToBeClickable(masterDataButton));
        masterdataBtn.click();
    }

    public void clickInvestmentAdvisorBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement investmentAdvisorBtn = wait.until(ExpectedConditions.elementToBeClickable(investmentAdvisorButton));
        investmentAdvisorBtn.click();
    }

    public String getInvestmentAdvisorHomeScreenUrl() {
        return driver.getCurrentUrl(); //Capture the current URL after Login
    }

    public void clickCREATEINVESTMENTADVISORBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement createInvestmentAdvisortButton = wait.until(ExpectedConditions.elementToBeClickable(createINVESTMENTADVISORButton));
        createInvestmentAdvisortButton.click();
    }

    public void selectStockBrokerDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesTitleBtn = wait.until(ExpectedConditions.elementToBeClickable(stockBrokerDropDown));
        Select stockBrokerSelect = new Select(valuesTitleBtn);
        stockBrokerSelect.selectByVisibleText("Vinod Perera");
    }

    public void enterAdvisorCode(String advisorCode){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement advisorCodeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(advisorCodeField));
        advisorCodeInput.sendKeys(advisorCode);
    }

    public void enterAdvisorName(String advisorName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement advisorNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(advisorNameField));
        advisorNameInput.sendKeys(advisorName);
    }

    public void enterContactNumber(String contactNo){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement contactFieldInput = wait.until(ExpectedConditions.visibilityOfElementLocated(contactNumberField));
        contactFieldInput.sendKeys(contactNo);
    }

    public void enterEmail(String email){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailFieldInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailFieldInput.sendKeys(email);
    }

    public void clickSAVEButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveButtonField));
        saveBtn.click();
    }

    public String getInvestmentAdvisorCreateSuccessMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement investmentAdvisorSuccessMsgElement = wait.until(ExpectedConditions.elementToBeClickable(investmentAdvisorCreateSuccessMsg));
        return investmentAdvisorSuccessMsgElement.getText();
    }


}
