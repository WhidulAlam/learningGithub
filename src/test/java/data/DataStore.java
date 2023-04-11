package data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataStore {
    @DataProvider(name = "SingleColumnValue")
    public Object[][] storeSingleColumnValue(){
        return new Object[][]{
                {"Rifat"},
                {"Farid"},
                {"Anowar"}

        };
    }

    @Test(dataProvider = "SingleColumnValue")
    public void run(String name){
        System.out.println("Name is: " + name);
    }
}
