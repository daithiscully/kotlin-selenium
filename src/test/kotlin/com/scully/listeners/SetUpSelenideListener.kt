package com.scully.listeners

import com.codeborne.selenide.Configuration.baseUrl
import com.codeborne.selenide.Configuration.fastSetValue
import com.codeborne.selenide.Configuration.headless
import com.codeborne.selenide.Configuration.remote
import com.codeborne.selenide.Configuration.reportsFolder
import com.codeborne.selenide.logevents.LogEventListener

import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.testng.ISuite
import org.testng.ISuiteListener

class SetUpSelenideListener : ISuiteListener {

    override fun onStart(suite: ISuite) {
        SelenideLogger.addListener("allure", AllureSelenide())
        baseUrl = "https://google.com"
        remote = "http://localhost:4444/wd/hub"
        reportsFolder = "target/selenide-reports"
        headless = true
        fastSetValue = true
    }

    override fun onFinish(suite: ISuite) {
        SelenideLogger.removeListener<LogEventListener>("allure")
    }
}