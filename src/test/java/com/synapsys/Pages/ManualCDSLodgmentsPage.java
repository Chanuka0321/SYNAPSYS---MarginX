package com.synapsys.Pages;

import com.synapsys.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManualCDSLodgmentsPage extends BaseTest {

    private final WebDriver driver;

    public ManualCDSLodgmentsPage(WebDriver driver) {
        this.driver = driver;
    }


    //Locators
    private static final By processButton = By.xpath("//div[@class='side-nav-item-title' and normalize-space(text())='Process']");
    private static final By manualCDSLodgmentsButton = By.xpath("//a[@href=\"/MarginXWeb/Process/ManualCDSLodgments/Create\"]");
    private static final By branchDropDown = By.id("branchId");
    private static final By brokerDropDown = By.id("brokerId");
    private static final By customerDropDown = By.id("customerId");
    private static final By companyCodeDropDown = By.id("listedCompanyId");
    private static final By additionTypeDropDown = By.id("buySellTypeId");
    private static final By quantityField = By.id("quantity");
    private static final By addButton = By.id("add");


    //Actions
    public void clickProcessButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement processBtn = wait.until(ExpectedConditions.elementToBeClickable(processButton));
        processBtn.click();
    }

    public void clickManualCDSLodgmentButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement manualCDSLodgmentsBtn = wait.until(ExpectedConditions.elementToBeClickable(manualCDSLodgmentsButton));
        manualCDSLodgmentsBtn.click();
    }

    public void selectBranchFromBranchDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesBranchBtn = wait.until(ExpectedConditions.elementToBeClickable(branchDropDown));
        Select branchSelect = new Select(valuesBranchBtn);
        branchSelect.selectByVisibleText("Gampaha");
    }

    public void selectStockBrokerFromStockBrokerDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesBrokerBtn = wait.until(ExpectedConditions.elementToBeClickable(brokerDropDown));
        Select brokerSelect = new Select(valuesBrokerBtn);
        brokerSelect.selectByVisibleText("HDL Broker");
    }

    public void selectCustomerFromCustomerDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesCustomerBtn = wait.until(ExpectedConditions.elementToBeClickable(customerDropDown));
        Select customerSelect = new Select(valuesCustomerBtn);
        customerSelect.selectByVisibleText("Dr MD Jayawardane 985632145-LC-00");
    }

    public void selectCompanyCodeFromCompanyCodeDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesCompanyCodeBtn = wait.until(ExpectedConditions.elementToBeClickable(companyCodeDropDown));
        Select companyCodeSelect = new Select(valuesCompanyCodeBtn);
        companyCodeSelect.selectByVisibleText("Daraz - AABN-W-0403");
    }

    public void selectAdditionTypeFromAdditionTypeDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement additionTypeBtn = wait.until(ExpectedConditions.elementToBeClickable(additionTypeDropDown));
        Select additionTypeSelect = new Select(additionTypeBtn);
        additionTypeSelect.selectByVisibleText("Addition");
    }

    public void enterQuantity(String quantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityField));
        quantityInput.sendKeys(quantity);
    }

    public void clickADDButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addBtn.click();
    }



}
