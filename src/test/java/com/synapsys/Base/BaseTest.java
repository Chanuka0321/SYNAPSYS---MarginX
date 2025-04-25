package com.synapsys.Base;
import com.synapsys.Pages.LoginPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;



public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public void login(String username, String password) throws InterruptedException{
        driver.get(getLoginUrl());
        loginPage = new LoginPage(driver);
        //Thread.sleep(3000);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        //Thread.sleep(5000);

        waitForPageLoad();
    }

    public String getLoginUrl(){
        return "https://iam-qa.synapsys.lk:57575/MarginXWeb/Home";
    }

    private void waitForPageLoad(){
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
/*
    @AfterMethod
    public void teardown(){
        if (driver!=null){
            driver.quit();
        }
    }

 */



}
