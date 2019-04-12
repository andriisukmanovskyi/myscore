package com.epam.e2.pageObjects;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import java.text.MessageFormat;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class HomePageObjects {

    private enum homePageUIElements {
        BTN_SIGN_IN("//div[@id='signIn']");

        private String myLocator;

        homePageUIElements(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }

        public String getWithParams(Object... params) {
            return MessageFormat.format(myLocator, params);
        }
    }

    /**
     * Method to click 'Sign in' button
     */
    public HomePageObjects act_clickSignInButton(){
        $(By.xpath(homePageUIElements.BTN_SIGN_IN.get())).click();
        log.info("Element with locator \"" + homePageUIElements.BTN_SIGN_IN.get() + "\" was clicked");
        return this;
    }

}