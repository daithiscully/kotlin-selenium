package com.scully

import com.codeborne.selenide.Selenide.open
import mu.KotlinLogging
import org.testng.annotations.Test

class SecondSeleniumTest : BaseTest() {

    @Test
    fun testOne() {
        logger.info { "Running the Second Selenium Test" }
        println("Thread: " + Thread.currentThread().name)
        open("/", GooglePage::class.java)
            .searchFor("Trivium")
            .ensureResultsContains("Trivium Pillars of Serpents")
    }

}