package com.epam.e2.helper;

import com.codeborne.selenide.Condition;
import com.epam.e2.pageObjects.LoginPageObjects;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class WaitHelper {

    public static void waitForElementPresence(String locator, int timeOutSeconds) {
        log.info("Waiting for element with locator \"" + locator + "\" presence, timeout = " + timeOutSeconds + " seconds.");
        $(By.xpath(locator)).waitUntil(Condition.visible, timeOutSeconds * 1000);
    }

}