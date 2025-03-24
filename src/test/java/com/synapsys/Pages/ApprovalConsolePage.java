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



    //Actions
    public void clickApprovalConsoleButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement approvalConsoleBtn = wait.until(ExpectedConditions.elementToBeClickable(approvalConsoleButton));
        approvalConsoleBtn.click();
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













}

