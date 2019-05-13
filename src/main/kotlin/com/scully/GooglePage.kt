package com.scully

import com.codeborne.selenide.Selectors.byName
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.page
import io.qameta.allure.Step

class GooglePage {

    @Step("Search for: {text}")
    fun searchFor(text: String): SearchResultsPage {
        `$`(byName("q")).setValue(text).pressEnter()
        return page(SearchResultsPage::class.java)
    }
}