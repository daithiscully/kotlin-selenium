package com.scully.listeners

import com.codeborne.selenide.Screenshots
import com.codeborne.selenide.WebDriverRunner
import com.google.common.io.Files
import io.qameta.allure.Attachment
import org.testng.ITestContext
import org.testng.ITestListener
import org.testng.ITestResult

import java.io.IOException

class CustomTestListener : ITestListener {

    override fun onTestStart(result: ITestResult) {

    }

    override fun onTestSuccess(result: ITestResult) {
        try {
            this.screenShot()
        } catch (e: IOException) {
            throw RuntimeException("Error creating screenshot")
        }

        this.capturePageSource()
    }

    override fun onTestFailure(result: ITestResult) {
        try {
            this.screenShot()
        } catch (e: IOException) {
            throw RuntimeException("Error creating screenshot")
        }

        this.capturePageSource()
    }

    override fun onTestSkipped(result: ITestResult) {

    }

    override fun onTestFailedButWithinSuccessPercentage(result: ITestResult) {

    }

    override fun onStart(context: ITestContext) {

    }

    override fun onFinish(context: ITestContext) {}


    @Attachment(type = "text/html")
    private fun capturePageSource(): String {
        return WebDriverRunner.source()
    }

    @Attachment(type = "image/png")
    @Throws(IOException::class)
    private fun screenShot(): ByteArray {
        val screenShot = Screenshots.takeScreenShotAsFile()
        return Files.toByteArray(screenShot)
    }

}