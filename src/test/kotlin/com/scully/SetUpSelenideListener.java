package com.scully;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.fastSetValue;
import static com.codeborne.selenide.Configuration.headless;
import static com.codeborne.selenide.Configuration.remote;
import static com.codeborne.selenide.Configuration.reportsFolder;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SetUpSelenideListener implements ISuiteListener {

  @Override
  public void onStart(ISuite suite) {
    SelenideLogger.addListener("allure", new AllureSelenide());
    baseUrl = "https://google.com";
    remote = "http://localhost:4444/wd/hub";
    reportsFolder = "target/selenide-reports";
    headless = true;
    fastSetValue = true;
  }

  @Override
  public void onFinish(ISuite suite) {
    SelenideLogger.removeListener("allure");
  }
}