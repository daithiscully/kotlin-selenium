package com.scully

import com.codeborne.selenide.Selenide.open
import mu.KotlinLogging
import org.testng.annotations.Test

class SecondSeleniumTest : BaseTest() {

    @Test
    fun `Test a google search for Trivium`() {
        logger.info { "Running the Second Selenium Test" }
        println("Thread: " + Thread.currentThread().name)
        val searchResultsPage = open("/", GooglePage::class.java)
            .searchFor("Trivium")
        searchResultsPage.getResults()
        searchResultsPage.ensureResultsContains("Trivium Pillars of Serpents")
    }

}