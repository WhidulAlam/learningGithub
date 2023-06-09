package data;


import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_object.Home;
import utilities.ReadConfigFiles;

public class CalculateRatesParameterized {
    private static final Logger LOGGER = LogManager.getLogger(CalculateRatesParameterized.class);
    WebDriver driver;

    @BeforeMethod
    public void OpenBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        LOGGER.info("--------Test Name: Calculator Real APR------");
        String browserUrl = ReadConfigFiles.getPropertyValues("Url");
        ActOn.browser(driver).openBrowser(browserUrl);
    }

    @Test(dataProvider = "RealAprRate", dataProviderClass = DataStoreApr.class)
    public void calculateRealApr(String homePrice, String downPayment, String interestRate, String expectedApr) {
        new Home(driver)
                .mouseHoverToRates()
                .nagetiveToRealApr()
                .waitForPageToLoad()
                .typeOfHomePrice(homePrice)
                .clickDownPaymentInDollars()
                .typeDownPayment(downPayment)
                .typeInterestRate(interestRate)
                .clickOnCalculateButton()
                .validateRealAprRate(expectedApr);
    }

    public void closeBrowser() {

        ActOn.browser(driver).closeBrowser();
        LOGGER.info("--------End Test Case: Calculate Real APR");
    }
}
