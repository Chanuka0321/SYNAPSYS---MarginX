package com.synapsys.Pages;

import com.synapsys.Base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Integer.parseInt;

public class ApprovalConsolePage extends BaseTest {

    private final WebDriver driver;

    public ApprovalConsolePage(WebDriver driver){
        this.driver = driver;
    }

    //Locators
    private static final By approvalConsoleButton = By.xpath("//a[@href='/MarginXWeb/ApprovalConsole/ApprovalConsole/Index']");
    private static final By selectValuesFromModuleDropdown = By.id("mType");
    private static final By selectValuesFromStatusDropdown = By.id("statusId");
    private static final By searchField = By.xpath("//input[@aria-controls='cycle1']");
    private static final By searchResult = By.xpath("//td[@class='sorting_1']");
    private static final By viewButton = By.xpath("//i[@class='fa fa-list-alt fa-2x fore-color-cyan icon-blue']");
    private static final By approveViewBranchDetailsScreen = By.xpath("//h5[@class='title']");
    private static final By approveComment = By.id("approvedComment");
    private static final By approvedButton = By.xpath("//input[@value='Approve']");
    private static final By approvedBranchSuccessMessage1 = By.xpath("//div[@class='alert alert-success']");
    private static final By approvedBrokerSuccessMessage = By.xpath("//div[@class='alert alert-success']");
    private static final By approvedInvestmentAdvisorSuccessMessage = By.xpath("//div[@class='alert alert-success']");



    //Actions
    public void clickApprovalConsoleButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement approvalConsoleBtn = wait.until(ExpectedConditions.elementToBeClickable(approvalConsoleButton));
        approvalConsoleBtn.click();
    }

    public String getApprovedConsoleScreenBranchViewScreen(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement branchDetailsScreen = wait.until(ExpectedConditions.elementToBeClickable(approveViewBranchDetailsScreen));
        return branchDetailsScreen.getText();
    }

    public void clickApproveViewButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement approveViewBtn = wait.until(ExpectedConditions.elementToBeClickable(viewButton));
        approveViewBtn.click();
    }

    public void clickApprovedButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement approvedBtn = wait.until(ExpectedConditions.elementToBeClickable(approvedButton));
        approvedBtn.click();
    }

    public String getApprovalConsoleScreenUrl() {
        return driver.getCurrentUrl();
    }

    public void setSelectValuesFromModuleDd(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesModuleBtn = wait.until(ExpectedConditions.elementToBeClickable(selectValuesFromModuleDropdown));
        Select moduleSelect = new Select(valuesModuleBtn);
        moduleSelect.selectByVisibleText("Branch");
    }

    public void setSelectValuesFromStatusDd(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesStatusBtn = wait.until(ExpectedConditions.elementToBeClickable(selectValuesFromStatusDropdown));
        Select statusSelect = new Select(valuesStatusBtn);
        statusSelect.selectByVisibleText("Create");
    }

    //Scroll Up
    public void scrollUp(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
    }

    public void enterSearchBranchName(String branchName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBoxField = wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchBoxField.sendKeys(branchName);
    }

    public String getSearchResult(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchResultBranch = wait.until(ExpectedConditions.elementToBeClickable(searchResult));
        return searchResultBranch.getText();
    }

    public void enterApprovedComment(String comment){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement approvedcomment = wait.until(ExpectedConditions.visibilityOfElementLocated(approveComment));
        approvedcomment.sendKeys(comment);
    }

    public String getBranchApprovedSuccessMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement approvedBranchSuccessMessage = wait.until(ExpectedConditions.elementToBeClickable(approvedBranchSuccessMessage1));
        return approvedBranchSuccessMessage.getText();
    }

    public void setSelectValuesFromModuleDd1(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesModuleBtn = wait.until(ExpectedConditions.elementToBeClickable(selectValuesFromModuleDropdown));
        Select moduleSelect = new Select(valuesModuleBtn);
        moduleSelect.selectByVisibleText("Brokers");
    }

    public void enterSearchBroker(String brokername){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBoxField = wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchBoxField.sendKeys(brokername);
    }

    public String getBrokerApprovedSuccessMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement approvedBrokerSuccessMessage1 = wait.until(ExpectedConditions.elementToBeClickable(approvedBrokerSuccessMessage));
        return approvedBrokerSuccessMessage1.getText();
    }

    public void setSelectAdvisorFromModuleDd(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesModuleBtn = wait.until(ExpectedConditions.elementToBeClickable(selectValuesFromModuleDropdown));
        Select moduleSelect = new Select(valuesModuleBtn);
        moduleSelect.selectByVisibleText("Investment Advisors");
    }

    public void enterSearchInvestmentAdvisor(String investmentAdvisorCode){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBoxField = wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchBoxField.sendKeys(investmentAdvisorCode);
    }

    public String getInvestmentAdvisorApprovedSuccessMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement approvedAdvisorSuccessMessage1 = wait.until(ExpectedConditions.elementToBeClickable(approvedInvestmentAdvisorSuccessMessage));
        return approvedAdvisorSuccessMessage1.getText();
    }






}

