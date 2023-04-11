package automation_test.mortgage_calculator_parametrized;

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
import utilities.DateUtils;
import utilities.ReadConfigFiles;
import utilities.SqlConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateMonthlyPaymentPara {
    private static final Logger LOGGER = LogManager.getLogger(CalculateMonthlyPaymentPara.class);
    WebDriver driver;

    @BeforeMethod
    public void OpenBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        LOGGER.info("--------Test Name: Calculator Monthly Payment------");
        String browserUrl = ReadConfigFiles.getPropertyValues("Url");
        ActOn.browser(driver).openBrowser(browserUrl);
    }

    @Test
    public void CalculateMonthlyPayment() {
        String[] date = DateUtils.returnNextMonth();

        try {
            ResultSet rs = SqlConnector.readData("Select * From monthly_mortgage");
            while (rs.next()) {
                new Home(driver)
                        .typeOfHomePrice(rs.getString("homevalue"))
                        .typeDownPayment(rs.getString("downpayment"))
                        .clickDownPaymentInDollars()
                        .typeLoanAmount(rs.getString("loanamount"))
                        .typeInterestRate(rs.getString("interestrate"))
                        .typeLoanTermYears(rs.getString("loanterm"))
                        .selectMonth(date[0])
                        .typeYear(date[1])
                        .typePropertyTax(rs.getString("propertytax"))
                        .typePMI(rs.getString("pmi"))
                        .typeHomeOwnerInsurance(rs.getString("homeownerinsurance"))
                        .typeMonthlyHOA(rs.getString("monthlyhoa"))
                        .selectLoanType(rs.getString("loantype"))
                        .selectBuyOrRefinance(rs.getString("buyorrefi "))
                        .clickOnCalculateButton()
                        .validateTotalMonthlyPayment(rs.getString("totalmonthlypayment"));

            }
        } catch (SQLException e) {
            LOGGER.error("SQL read exception: " + e.getMessage());
        }
    }

    public void closeBrowser() {

        ActOn.browser(driver).closeBrowser();
        LOGGER.info("--------End Test Case: Calculate Monthly Payment");
    }
}
