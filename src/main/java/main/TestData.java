package main;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name="inputted")
    public Object[][] getObject()
    {
        Object[][] obj=new Object[2][2];
        {
            obj[0][0]="gvfbdhgv";
            obj[0][1]="fvbhf";
            obj[1][0]="fvf";
            obj[1][1]="vfvfvf";
        }
        return obj;
    }

}
