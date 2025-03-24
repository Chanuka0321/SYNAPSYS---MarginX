package com.synapsys.Pages;

import com.synapsys.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElementImpl;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage{

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Locators
    private static final By usernameField = By.id("Username");
    private static final By passwordField = By.id("Password");
    private static final By loginButton = By.xpath("//button[@name='button']");
    private static final By masterDataButton = By.xpath("//div[@class='side-nav-item level-0 collapsed'][1]");
    private static final By branchButton = By.xpath("//a[@label='Branch']");
    private static final By createBranchButton = By.xpath("//a[@class='btn btn-info pull-right']");

    //Actions
    public void enterUsername(String username){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameInput.sendKeys(username);
    }


    public void enterPassword(String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordInput.sendKeys(password);
    }

    public void clickLogin(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }

    public String getDashboardUrl(){
        return driver.getCurrentUrl(); //Capture the current URL after Login
    }

    public String getErrorMessage(){
        WebElement errorElement = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger']"))); //Change ID based an actual error element.
        return errorElement.getText();
    }
}

