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

public class LoanableFilePage extends BaseTest {

    private final WebDriver driver;

    public LoanableFilePage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private static final By processButton = By.xpath("//div[@class='side-nav-item-title' and normalize-space(text())='Process']");
    private static final By loanableFileButton = By.xpath("//a[@href=\"/MarginXWeb/Process/Loanable/Index\"]");
    private static final By dateInput  = By.id("generatedDate");
    private static final By brokerDropDown = By.id("brokerCode");
    private static final By generateButton = By.xpath("//input[@value=\"Generate\"]");



    //Actions
    public void selectDate(String dateValue) {
        WebElement dateElement = driver.findElement(dateInput);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1];", dateElement, dateValue);
    }

    public void selectBrokerFromDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesBrokerBtn = wait.until(ExpectedConditions.elementToBeClickable(brokerDropDown));
        Select brokerSelect = new Select(valuesBrokerBtn);
        brokerSelect.selectByVisibleText(" All Brokers ");
    }

    public void clickGenerateButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement generateBtn = wait.until(ExpectedConditions.elementToBeClickable(generateButton));
        generateBtn.click();
    }

    public void clickProcessButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement processBtn = wait.until(ExpectedConditions.elementToBeClickable(processButton));
        processBtn.click();
    }

    public void clickLoanableFileButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loanableFileBtn = wait.until(ExpectedConditions.elementToBeClickable(loanableFileButton));
        loanableFileBtn.click();
    }


}
