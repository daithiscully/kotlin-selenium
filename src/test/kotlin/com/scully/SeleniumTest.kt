package com.scully

import com.codeborne.selenide.Selenide.open
import mu.KotlinLogging
import org.testng.annotations.Test

class SeleniumTest : BaseTest() {


    @Test
    fun testOne() {
        logger.info { "Running the First Selenium Test" }
        println("Thread: " + Thread.currentThread().name)
        open("/", GooglePage::class.java)
            .searchFor("metallica")
            .ensureResultsContains("Metallica")
    }

}