package com.sovtech.tests;

import com.sovtech.pages.ContactUs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContactUsTest {

    private WebDriver webDriver;
    private ContactUs contactUs;

    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        String chromeDriverPath = System.getProperty("user.dir");
        String chromeVersion = System.getProperty("chromeVersion") != null ? System.getProperty("chromeVersion") : "94";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath + "\\src\\main\\resources\\chromedriver\\chromedriver_" + chromeVersion + ".exe");

        this.webDriver = new ChromeDriver(options);
        this.contactUs = new ContactUs(this.webDriver);
    }

    @Test
    public void completeForm() {
        contactUs.goTo();
        contactUs.navigateToContactUs();
        contactUs.captureForm("Test Name", "test@sovtech.com", "0712345678", 3, "Please get back to me asap!");
        contactUs.clickCheckBox();
        contactUs.submitForm();
    }

    @AfterTest
    public void after() {
        this.webDriver.quit();
    }
}
