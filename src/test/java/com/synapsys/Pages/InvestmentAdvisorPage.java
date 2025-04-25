package com.synapsys.Pages;

import com.synapsys.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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


}
