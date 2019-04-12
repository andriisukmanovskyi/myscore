package com.epam.e2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;

public class MyScoreAutomationBase {

    @BeforeMethod
    public void openBrowser() {
        Configuration.startMaximized = true;
        Selenide.open("https://www.myscore.ua");
    }

}