package com.cybertek.Tests.Test1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {
    @Test(dataProvider = "getData")
    public void dataProviderTest(String username, String password) {
        System.out.println(username);
        System.out.println(password);
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[3][2];
        data[0][0] = "user-1";
        data[0][1] = "password-1";
        data[1][0] = "user-2";
        data[1][1] = "password-2";
        data[2][0] = "user-3";
        data[2][1] = "password-3";

        return data;
    }
}
