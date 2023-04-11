package previous_calculates;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculateMortgageRate{
    WebDriver driver;
    Select select;

    private final By HomeValueInputField=By.id("homeval");
    private final By DownPaymentInputField=By.id("downpayment");
    private final By SelectDownPamentInDollar=By.id("param[downpayment_type]");
    private final By LoanAmountInputField=By.id("loanamt");
    private final By InterestRateInputField=By.id("intrstsrate");
    private final By LoanTermInputField=By.id("loanterm");
    private final By StartMonthDropDown=By.id("param[start_month]");
    private final By StartYearInputField=By.id("start_year");
    private final By PropertyTaxInputField=By.id("pptytax");
    private final By PmiInputField=By.id("pmi");
    private final By HoiInputField=By.id("hoi");
    private final By HoaInputField=By.id("hoa");
    private final By LoanTypeDropDown=By.id("param[milserve]");
    private final By BuyOrRefiDropDown=By.id("param[refiorbuy]");
    private final By CalculateButton=By.id("cal");



    @BeforeMethod
    public void OpenBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(options);
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
    }
    public void enterData(){

    }
    @Test
    public void CalculateMonthlyPayment(){
        //Enter Home Value "300000"
        driver.findElement(By.id("homeval")).clear();
        driver.findElement(By.id("homeval")).sendKeys("300000");

        //Enter Down payment "60000'
        driver.findElement(By.id("downpayment")).clear();
        driver.findElement(By.id("downpayment")).sendKeys("60000");

        //Click on the radio button $
        driver.findElement(By.name("param[downpayment_type]")).click();

        //Enter loan amount "240000"
        driver.findElement(By.id("loanamt")).clear();
        driver.findElement(By.id("loanamt")).sendKeys("240000");

        //Enter interest rate "3%"
        driver.findElement(By.id("intrstsrate")).clear();
        driver.findElement(By.id("intrstsrate")).sendKeys("3");

        //Enter loan tearm 30 ysars;
        driver.findElement(By.id("loanterm")).clear();
        driver.findElement(By.id("loanterm")).sendKeys("30");

        //Select the start month "Apr"
        select= new Select(driver.findElement(By.name("param[start_month]")));
        select.selectByVisibleText("Apr");

        //Enter the year "2023"
        driver.findElement(By.id("start_year")).clear();
        driver.findElement(By.id("start_year")).sendKeys("2023");

        //Enter the property tax "5000"
        driver.findElement(By.id("pptytax")).clear();
        driver.findElement(By.id("pptytax")).sendKeys("5000");

        //Enter PMI "0.5"
        driver.findElement(By.id("pmi")).clear();
        driver.findElement(By.id("pmi")).sendKeys("0.5");

       // Enter HOI "100"
        driver.findElement(By.id("hoi")).clear();
        driver.findElement(By.id("hoi")).sendKeys("1000");

        // Enter Monthly HOA "100"
        driver.findElement(By.id("hoa")).clear();
        driver.findElement(By.id("hoa")).sendKeys("100");

        //Select loan type "FHA"
        select= new Select(driver.findElement(By.name("param[milserve]")));
        select.selectByVisibleText("FHA");

        //Select  "Buy" option
        select= new Select(driver.findElement(By.name("param[refiorbuy]")));
        select.selectByVisibleText("Buy");

        //Click on the Calculate Button
        driver.findElement(By.name("cal")).click();

        String expectedTotalMonthlyPayment= "1,611.85";
        String formattedXpath= String.format("//h3[text()='$%s']",expectedTotalMonthlyPayment);

        boolean present= driver.findElement(By.xpath(formattedXpath)).isDisplayed();

        //Validate that the Total Monthly Payment is $1611.85
        Assert.assertTrue(present,"Total Monthly Payment is not present");

    }

    @AfterMethod
    public void closeBrowser(){
        //driver.quit();
    }
}
