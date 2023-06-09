package page_object;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RealApr extends NavigationBar {
    private final By CalculatorTab= By.xpath("//label[text()='Calculator']");
    private final By HomePriceInputField= By.name("HomeValue");
    private final By DownPaymentInputField= By.name("DownPayment");
    private final By DownPaymentDollar= By.id("DownPaymentSel0");
    private final By InterestRateInputField= By.name("Interest");
    private final By CalculateRateButton= By.name("calculate");
    private final By ActualAprRate= By.xpath("//*[@id='analysisDiv']/table/tbody/tr/td/strong[text()='Actual APR:']/../../td[2]/strong");

    private static final Logger LOGGER= LogManager.getLogger(RealApr.class);

    public RealApr(WebDriver driver){
        super(driver);
    }

    public RealApr waitForPageToLoad(){
        LOGGER.debug("Waiting for the page to load");
        ActOn.wait(driver, CalculatorTab).waitForElementToBeDisplayed();
        return this;
    }

    public RealApr typeOfHomePrice(String value){
        LOGGER.debug("Typing the Home Price Value:" + value);
        ActOn.element(driver, HomePriceInputField).setValue(value);
        return this;
    }
    public RealApr typeDownPayment(String value){
        LOGGER.debug("Typing the down payment value:"+ value);
        ActOn.element(driver, DownPaymentInputField).setValue(value);
        return this;
    }

    public RealApr clickDownPaymentInDollars() {
        LOGGER.debug("Clicking on the $ Radio button");
        ActOn.element(driver, DownPaymentDollar).click();
        return this;
    }

    public  RealApr typeInterestRate(String value) {
        LOGGER.debug("Typing the InterestRate Value:" + value);
        ActOn.element(driver, InterestRateInputField).setValue(value);
        return this;
    }

    public RealApr clickOnCalculateButton() {
        LOGGER.debug("Clicking on calculate button");
        ActOn.element(driver, CalculateRateButton).click();
        return this;
    }

    public RealApr validateRealAprRate(String expectedValue){
        LOGGER.debug("Validate the real APR rate is:" + expectedValue);
        String actualRealAprRate= ActOn.element(driver, ActualAprRate).getTextValue();
        Assert.assertEquals(actualRealAprRate, expectedValue);
        return this;
    }
}
