package com.scully

import com.codeborne.selenide.Selenide.open
import org.testng.annotations.Test

class SeleniumTest : BaseTest() {

    @Test
    fun testOne() {
        println("Thread: " + Thread.currentThread().name)
        open("/", GooglePage::class.java)
            .searchFor("rasputin")
            .ensureResultsContains("Grigori Rasputin")
    }

}