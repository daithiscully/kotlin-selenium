package com.scully.listeners

import com.codeborne.selenide.Configuration.*
import org.testng.ISuite
import org.testng.ISuiteListener

class SetUpSelenideListener : ISuiteListener {

    override fun onStart(suite: ISuite) {
        baseUrl = "https://google.com"
        remote = "http://localhost:4444/wd/hub"
        reportsFolder = "target/selenide-reports"
        headless = true
        fastSetValue = true
    }

    override fun onFinish(suite: ISuite) {
    }
}