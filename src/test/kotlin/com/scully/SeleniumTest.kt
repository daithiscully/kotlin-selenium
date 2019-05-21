package com.scully

import com.codeborne.selenide.Selenide.open
import mu.KotlinLogging
import org.testng.annotations.Test

class SeleniumTest : BaseTest() {

    private val log = KotlinLogging.logger {}

    @Test
    fun `Test a google search for Metallica`() {
        log.info { "Running the First Selenium Test" }
        println("Thread: " + Thread.currentThread().name)
        open("/", GooglePage::class.java)
            .searchFor("metallica")
            .ensureResultsContains("Metallica")
    }

}