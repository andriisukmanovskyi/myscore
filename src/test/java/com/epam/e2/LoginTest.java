package com.epam.e2;

import com.epam.e2.businessObjects.LoginBO;
import com.epam.e2.pageObjects.HomePageObjects;
import com.epam.e2.pageObjects.LoginPageObjects;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends MyScoreAutomationBase {

    private static final String EMAIL = "andriisukmanovskyi@gmail.com";
    private static final String PASSWORD = "abc12345";

    LoginBO loginBO;

    @BeforeTest
    public void init() {
        loginBO = new LoginBO();
    }

    @Test
    public void verifyLogin() {
        loginBO.login(EMAIL, PASSWORD);
    }

}