package com.scully

import com.codeborne.selenide.CollectionCondition.size
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selectors.byClassName
import com.codeborne.selenide.Selectors.withText
import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.Selenide.`$`
import io.qameta.allure.Step
import mu.KotlinLogging

class SearchResultsPage : BasePage() {
    private val log = KotlinLogging.logger {}

    @Step("Get All results as a collection")
    fun getResults(): ElementsCollection {
        log.info { "Getting results" }
        return `$$`(byClassName("rc")).filterBy(visible)
    }

    @Step("Validate Results contain the following text: {text}")
    fun ensureResultsContains(text: String): SearchResultsPage {
        log.info { "Validating results contain at least one instance of '$text'" }
        `$`(withText(text)).shouldBe(visible)
        return this
    }

    @Step("Validate Results have a size of: {size}")
    fun ensureResultsHaveSize(expectedNumberOfResults: Int): SearchResultsPage {
        getResults().shouldHave(size(expectedNumberOfResults))
        return this
    }
}