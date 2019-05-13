package com.scully

import com.codeborne.selenide.CollectionCondition.size
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selectors.byClassName
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selectors.withText
import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.Selenide.`$`
import io.qameta.allure.Step


class SearchResultsPage {

    val results: ElementsCollection
        @Step("Get All results as a collection")
        get() = `$$`(byClassName("rc")).filterBy(visible)

    @Step("Validate Results contain the following text: {text}")
    fun ensureResultsContains(text: String): SearchResultsPage {
        `$`(withText(text)).shouldBe(visible)
        return this
    }

    @Step("Validate Results have a size of: {size}")
    fun ensureResultsHaveSize(sizeR: Int): SearchResultsPage {
        results.shouldHave(size(sizeR))
        return this
    }
}