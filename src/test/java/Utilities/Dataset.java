package Utilities;

import org.testng.annotations.DataProvider;

public class Dataset {
    @DataProvider(name="data-provider-emi")
    public Object[][] setData(){
        return new Object[][]{
                {100000,9.0,2, 2.0, 4568.47, 9643.38, 2000, 109643.38},
                {325000,9.5,5,1.5,6825.6,84536.3,4875,409536.3},
                {450000,11.0,7,1.8,7705.1,197228.1,8100,647228.1},
                {99000000,10.0,4,1.25,2510895.76,21522996.48,1237500,120522996.48},
                {50000,12.0,9,2.2,759.21,31994.86,1100,81994.86}
        };
    }
}
