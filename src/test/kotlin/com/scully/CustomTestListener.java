package com.scully;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class CustomTestListener implements ITestListener {

  @Override
  public void onTestStart(ITestResult result) {

  }

  @Override
  public void onTestSuccess(ITestResult result) {
    try {
      this.screenShot();
    } catch (IOException e) {
      throw new RuntimeException("Error creating screenshot");
    }
    this.capturePageSource();
  }

  @Override
  public void onTestFailure(ITestResult result) {
    try {
      this.screenShot();
    } catch (IOException e) {
      throw new RuntimeException("Error creating screenshot");
    }
    this.capturePageSource();
  }

  @Override
  public void onTestSkipped(ITestResult result) {

  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

  }

  @Override
  public void onStart(ITestContext context) {

  }

  @Override
  public void onFinish(ITestContext context) {
  }


  @Attachment(type = "text/html")
  private String capturePageSource() {
    return WebDriverRunner.source();
  }

  @Attachment(type = "image/png")
  private byte[] screenShot() throws IOException {
    var screenShot = Screenshots.takeScreenShotAsFile();
    return Files.toByteArray(screenShot);
  }

}