package automation_test.mortgage_calculator;

import command_providers.ActOn;
import command_providers.AssertThat;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_object.Home;
import page_object.NavigationBar;

public class CalculateRealAprRate {
        WebDriver driver;

        @BeforeMethod
        public void openBrowser() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
        }



        @Test
        public void calculateRealApr(){
            new NavigationBar(driver)
                    .mouseHoverToRates()
                    .nagetiveToRealApr()
                    .waitForPageToLoad()
                    .typeOfHomePrice("200000")
                    .typeDownPayment("15000")
                    .clickDownPaymentInDollars()
                    .typeInterestRate("3")
                    .clickOnCalculateButton()
                    .validateRealAprRate("3.130%");
        }
        @AfterMethod
        public void CloseBrowser(){

            ActOn.browser(driver).closeBrowser();
        }

}
