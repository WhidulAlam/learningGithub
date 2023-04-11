package data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataStoreMultiple {
    @DataProvider(name = "MultipleColumnValue")
    public Object[][] storeMultipleColumnValue(){
        return new Object[][]{
                {"Rifat", "FL", 55555},
                {"Farid", "NY", 11444},
                {"Anowar", "NY", 11432}

        };
    }

    @Test(dataProvider = "MultipleColumnValue")
    public void run(String name, String state, int zipCode){
        System.out.println("Name is: " + name);
        System.out.println("State name is: " + state);
        System.out.println("Zip code is: " + zipCode);
    }
}
