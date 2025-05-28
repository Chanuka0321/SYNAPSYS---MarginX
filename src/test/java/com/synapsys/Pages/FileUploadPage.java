package com.synapsys.Pages;

import com.synapsys.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FileUploadPage extends BaseTest {

    private final WebDriver driver;

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private static final By processButton = By.xpath("//div[@class='side-nav-item-title' and normalize-space(text())='Process']");
    private static final By fileUploadButton = By.xpath("//a[@href=\"/MarginXWeb/Process/FileUpload/Index\"]");
    private static final By uploadFileButton = By.xpath("//a[@class=\"btn btn-info pull-right\"]");
    private static final By categoryDropdown = By.id("selectCategory");
    private static final By fileTypeDropdown = By.id("selectbasic");
    private static final By brokerDropDown = By.id("brokerCodeId");
    private static final By chooseFileButton = By.xpath("//input[@class=\"upload\"]");
    private static final By uploadButton = By.xpath("//button[@class=\"btn btn-info pull-left\"]");
    private static final By allFileUploadButton = By.xpath("//a[@href=\"/MarginXWeb/Process/FileUpload/index\"]");
    private static final By fileUploadFileTypeDropDown = By.id("fileType");
    private static final By validateButton = By.xpath("//i[@class=\"fa fa-list-alt fa-2x fore-color-cyan icon-blue\"]");
    private static final By validateButton2 = By.xpath("//button[@class=\"btn btn-info pull-right\"]");


    //Actions
    public void clickProcessButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement processBtn = wait.until(ExpectedConditions.elementToBeClickable(processButton));
        processBtn.click();
    }

    public void clickFileUploadButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fileUploadBtn = wait.until(ExpectedConditions.elementToBeClickable(fileUploadButton));
        fileUploadBtn.click();
    }

    public void clickUploadFileButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement uploadFileBtn = wait.until(ExpectedConditions.elementToBeClickable(uploadFileButton));
        uploadFileBtn.click();
    }

    public void selectCategoryFromCategoryDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesCategoryBtn = wait.until(ExpectedConditions.elementToBeClickable(categoryDropdown));
        Select categorySelect = new Select(valuesCategoryBtn);
        categorySelect.selectByVisibleText("Margin Trading");
    }

    public void selectFileTypeFromFileTypeDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fileTypeBtn = wait.until(ExpectedConditions.elementToBeClickable(fileTypeDropdown));
        Select fileTypeSelect = new Select(fileTypeBtn);
        fileTypeSelect.selectByVisibleText("CDS Lodgment Upload");
    }

    public void selectBrokerFromBrokerDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement brokerBtn = wait.until(ExpectedConditions.elementToBeClickable(brokerDropDown));
        Select brokerSelect = new Select(brokerBtn);
        brokerSelect.selectByVisibleText("SDW Broker");
    }

    public void clickChooseFileButton1(String s){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement choseFileBtn = wait.until(ExpectedConditions.elementToBeClickable(chooseFileButton));
        choseFileBtn.click();
    }
    public void clickChooseFileButton(String filePath) {
        WebElement uploadInput = driver.findElement(By.xpath("//input[@class=\"upload\"]"));
        uploadInput.sendKeys(filePath);
    }

    public void clickUploadButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement uploadBtn = wait.until(ExpectedConditions.elementToBeClickable(uploadButton));
        uploadBtn.click();
    }

    public void clickAllFileUploadButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement allFileUploadBtn = wait.until(ExpectedConditions.elementToBeClickable(allFileUploadButton));
        allFileUploadBtn.click();
    }

    public void selectFileTypeFromFileTypeDropdown1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fileType1Btn = wait.until(ExpectedConditions.elementToBeClickable(fileTypeDropdown));
        Select fileType1Select = new Select(fileType1Btn);
        fileType1Select.selectByVisibleText("CDS Daily Transaction Upload");
    }

    public void selectBrokerFromBrokerDropdown2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement broker2Btn = wait.until(ExpectedConditions.elementToBeClickable(brokerDropDown));
        Select broker2Select = new Select(broker2Btn);
        broker2Select.selectByVisibleText("SDW Broker");
    }

    public void selectCategoryFromCategoryDropdown2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuesCategory2Btn = wait.until(ExpectedConditions.elementToBeClickable(categoryDropdown));
        Select category2Select = new Select(valuesCategory2Btn);
        category2Select.selectByVisibleText("Common");
    }

    public void selectFileTypeFromFileTypeDropdown2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fileType2Btn = wait.until(ExpectedConditions.elementToBeClickable(fileTypeDropdown));
        Select fileType2Select = new Select(fileType2Btn);
        fileType2Select.selectByVisibleText("Market Price Upload");
    }

    public void selectCDSLodgementFile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement validationFileTypeSelect = wait.until(ExpectedConditions.elementToBeClickable(fileUploadFileTypeDropDown));
        Select fileTypeSelect = new Select(validationFileTypeSelect);
        fileTypeSelect.selectByVisibleText(" CDS Lodgment Upload ");
    }

    public void clickValidateButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement validateBtn = wait.until(ExpectedConditions.elementToBeClickable(validateButton));
        validateBtn.click();
    }

    public void clickValidateButton2(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement validateBtn2 = wait.until(ExpectedConditions.elementToBeClickable(validateButton2));
        validateBtn2.click();
    }

    public void selectDailyTransactionFile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement validationFileTypeSelect = wait.until(ExpectedConditions.elementToBeClickable(fileUploadFileTypeDropDown));
        Select fileTypeSelect = new Select(validationFileTypeSelect);
        fileTypeSelect.selectByVisibleText(" CDS Daily Transaction Upload ");
    }

    public void selectMarketPriceFile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement validationFileTypeSelect = wait.until(ExpectedConditions.elementToBeClickable(fileUploadFileTypeDropDown));
        Select fileTypeSelect = new Select(validationFileTypeSelect);
        fileTypeSelect.selectByVisibleText(" Market Price Upload ");
    }



}

