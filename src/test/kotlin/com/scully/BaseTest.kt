package com.scully

import com.codeborne.selenide.testng.BrowserPerClass
import com.scully.listeners.CustomTestListener
import com.scully.listeners.SetUpSelenideListener
import mu.KotlinLogging
import org.testng.annotations.Listeners
import org.testng.annotations.Test

@Test
@Listeners(SetUpSelenideListener::class, CustomTestListener::class, BrowserPerClass::class)
abstract class BaseTest {
    val logger = KotlinLogging.logger {}
}

