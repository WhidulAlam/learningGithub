package previous_calculates;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculateRealAprRate {
    WebDriver driver;

    private final By RatesLink= By.linkText("Rates");
    private final By RealAprLink= By.linkText("Real APR");
    private final By CalculatorTab= By.xpath("//label[text()='Calculator']");
    private final By HomePriceInputField= By.name("HomeValue");
    private final By DownPaymentInputField= By.name("DownPayment");
    private final By DownPaymentDollar= By.id("DownPaymentSel0");
    private final By InterestRateInputField= By.name("Interest");
    private final By CalculateRateButton= By.name("calculate");
    private final By ActualAprRate= By.xpath("//*[@id='analysisDiv']/table/tbody/tr/td/strong[text()='Actual APR:']/../../td[2]/strong");

    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
    }
    public void navigateToRealApr(){

        //Mouse Hover to Rates Link
        Actions actions= new Actions(driver);
        actions.moveToElement(driver.findElement(RatesLink)).perform();

        //Click on Real Apr Link
        driver.findElement(RealAprLink).click();

        //Wait for the page to load
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(CalculatorTab));
    }
    public void enterData(){
        //Enter Home price "200000"
        driver.findElement(HomePriceInputField).clear();
        driver.findElement(HomePriceInputField).sendKeys("200000");

        //Enter Down Payment '"15000"
        driver.findElement(DownPaymentInputField).clear();
        driver.findElement(DownPaymentInputField).sendKeys("15000");

        //Click on the radio button of down payment in dollar $
        driver.findElement(DownPaymentDollar).click();

        //Enter the Interest Rate "3"
        driver.findElement(InterestRateInputField).clear();
        driver.findElement(InterestRateInputField).sendKeys("3");
    }
    @Test
    public void calculateRealApr(){
       navigateToRealApr();
        enterData();

        //Click on Calculate Button
        driver.findElement(CalculateRateButton).click();

        //Validate the Real Apr Rate is "3.130%"
        String actualRealAprRate= driver.findElement(ActualAprRate).getText();
        Assert.assertEquals(actualRealAprRate,"3.130%");
    }
    @AfterMethod
    public void CloseBrowser(){

        driver.quit();
    }
}
