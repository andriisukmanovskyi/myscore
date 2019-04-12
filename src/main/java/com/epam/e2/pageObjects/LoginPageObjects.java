package com.epam.e2.pageObjects;

import com.codeborne.selenide.ex.SoftAssertionError;
import com.epam.e2.helper.WaitHelper;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import java.text.MessageFormat;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class LoginPageObjects {

    private enum loginPageUIElements {
        IPF_EMAIL("//input[@id='email']"),
        IPF_PASSWORD("//input[@id='passwd']"),
        BTN_SUBMIT("//div[contains(@class,'sign-up-form-element')]//input[@id='login']"),
        SUCCESSFUL_LOGIN_MESSAGE("//div[contains(@class,'message')]/div[contains(text(),'Ви успішно увійшли в обліковий запис.')]");

        private String myLocator;

        loginPageUIElements(String locator) {
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
     * Method to enter email into the input field
     */
    public LoginPageObjects act_enterEmail(String email) {
        $(By.xpath(loginPageUIElements.IPF_EMAIL.get())).setValue(email);
        log.info("Text '" + email + "' was entered into the input field with locator \"" + loginPageUIElements.IPF_EMAIL.get() + "\"");
        return this;
    }

    /**
     * Method to enter password into the input field
     */
    public LoginPageObjects act_enterPassword(String password) {
        $(By.xpath(loginPageUIElements.IPF_PASSWORD.get())).setValue(password);
        log.info("Text '" + password + "' was entered into the input field with locator \"" + loginPageUIElements.IPF_EMAIL.get() + "\"");
        return this;
    }

    /**
     * Method to click 'submit' button
     */
    public LoginPageObjects act_clickSubmitButton() {
        $(By.xpath(loginPageUIElements.BTN_SUBMIT.get())).click();
        log.info("Element with locator \"" + loginPageUIElements.BTN_SUBMIT.get() + "\" was clicked");
        return this;
    }

    /**
     * Method to verify successful login message presence
     */
    public LoginPageObjects ver_successfulLoginMessagePresence() {
        WaitHelper.waitForElementPresence(loginPageUIElements.SUCCESSFUL_LOGIN_MESSAGE.get(), 3);
        if (!$(By.xpath(loginPageUIElements.SUCCESSFUL_LOGIN_MESSAGE.get())).isDisplayed())
            throw new SoftAssertionError("Element with locator \"" + loginPageUIElements.SUCCESSFUL_LOGIN_MESSAGE + "\" is not displayed");
        log.info("Element with locator \"" + loginPageUIElements.SUCCESSFUL_LOGIN_MESSAGE.get() + "\" is displayed");
        return this;
    }

}