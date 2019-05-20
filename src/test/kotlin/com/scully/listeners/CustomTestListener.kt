package com.scully.listeners

import com.codeborne.selenide.Screenshots
import com.codeborne.selenide.WebDriverRunner
import io.qameta.allure.Attachment
import org.testng.ITestContext
import org.testng.ITestListener
import org.testng.ITestResult
import java.nio.file.Files

class CustomTestListener : ITestListener {

    override fun onTestStart(result: ITestResult) {}

    override fun onTestSuccess(result: ITestResult) {
        `Screen shot`()
        `HTML Source Code`()
    }


    override fun onTestFailure(result: ITestResult) {
        `Screen shot`()
        `HTML Source Code`()
    }

    override fun onTestSkipped(result: ITestResult) {}

    override fun onTestFailedButWithinSuccessPercentage(result: ITestResult) {}

    override fun onStart(context: ITestContext) {}

    override fun onFinish(context: ITestContext) {}

    @Attachment(type = "text/html")
    private fun `HTML Source Code`(): String {
        return WebDriverRunner.source()
    }

    @Attachment(type = "image/png")
    private fun `Screen shot`(): ByteArray {
        val screenShot = Screenshots.takeScreenShotAsFile()
        return Files.readAllBytes(screenShot.toPath())
    }

}