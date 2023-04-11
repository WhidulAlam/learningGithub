package data;

import org.testng.annotations.DataProvider;

public class DataStoreApr {
    @DataProvider(name = "RealAprRate")
    public Object[][] storeRealAprRate(){
        return new Object[][]{
                {"200000", "15000", "3", "3.130%"},
        };
    }
}
