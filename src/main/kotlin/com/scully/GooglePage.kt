package com.scully

import com.codeborne.selenide.Selectors.byName
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.page
import io.qameta.allure.Step
import mu.KotlinLogging

class GooglePage : BasePage() {
    private val log = KotlinLogging.logger {}

    @Step("Search for: {text}")
    fun searchFor(text: String): SearchResultsPage {
        log.info { "Searching for $text" }
        `$`(byName("q"))
            .setValue(text)
            .pressEnter()
        return page(SearchResultsPage::class.java)
    }
}