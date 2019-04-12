package com.epam.e2.businessObjects;

import com.epam.e2.pageObjects.HomePageObjects;
import com.epam.e2.pageObjects.LoginPageObjects;

public class LoginBO {

    HomePageObjects homePageObjects;
    LoginPageObjects loginPageObjects;

    public LoginBO() {
        this.homePageObjects = new HomePageObjects();
        this.loginPageObjects = new LoginPageObjects();
    }

    public LoginBO login(String email, String password) {
        homePageObjects
                .act_clickSignInButton();
        loginPageObjects
                .act_enterEmail(email)
                .act_enterPassword(password)
                .act_clickSubmitButton()
                .ver_successfulLoginMessagePresence();
        return this;
    }

}