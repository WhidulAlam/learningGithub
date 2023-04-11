package testNG_Maven;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utilities.SqlConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMaven2 {
    private static final Logger LOGGER= LogManager.getLogger(TestMaven2.class);

    @Test
    public void testDatabaseValues() throws SQLException{
        ResultSet rs= SqlConnector.readData("Select * From monthly_mortgage");
        try{
            while (rs.next()){
                System.out.println("The home price is:" + rs.getString("homevalue"));
                System.out.println("The down payment is: " + rs.getString("downpayment"));
                System.out.println("The loan amount is: " + rs.getString("loanamount"));
                System.out.println("The property tax is:" + rs.getString("propertytax"));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
