package com.sovtech.pages;

import common.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUs {

    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(how = How.CSS, using = "img[src='https://www.sovtech.co.za/wp-content/uploads/sites/29/2019/07/sovtech_logo-2.png']")
    WebElement imageLogo;

    @FindBy(css = "a[href='https://www.sovtech.co.za/contact-us/']")
    WebElement contactUsLink;

    @FindBy(name = "your_name")
    WebElement name;

    @FindBy(id = "hs-form-iframe-0")
    WebElement formFrame;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "mobilephone")
    WebElement phoneNumber;

    @FindBy(name = "numemployees")
    WebElement numOfEmployee;

    @FindBy(name = "message")
    WebElement message;

    @FindBy(how = How.CSS, using = "textarea[name*='LEGAL_CONSENT.subscription_type']")
    WebElement checkbox;

    @FindBy(how = How.CSS, using = "input[type='submit']")
    WebElement submitContactUsForm;

    public ContactUs(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 60);
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 30), this);
    }

    public void goTo() {
        Common.goToPage(this.driver, this.wait, Common.URL, imageLogo);
    }

    public void navigateToContactUs() {
        Common.buttonClick(this.contactUsLink, this.wait);
    }

    public void captureForm(String name, String email, String phoneNumber, int index, String message) {

        driver.switchTo().frame(this.formFrame);
        Common.enterText(this.name, this.wait, name);
        Common.enterText(this.email, this.wait, email);
        Common.enterText(this.phoneNumber, this.wait, phoneNumber);
        Common.dropdownSelect(this.numOfEmployee, this.wait, index >= 0 && index <= 6 ? index : 0);
        Common.enterText(this.message, this.wait, message);
    }

    public void captureForm(String name, String email, String phoneNumber, String option, boolean byValue, String message) {
        Common.enterText(this.name, this.wait, name);
        Common.enterText(this.email, this.wait, email);
        Common.enterText(this.phoneNumber, this.wait, phoneNumber);
        Common.dropdownSelect(this.numOfEmployee, this.wait, option, byValue);
        Common.enterText(this.message, this.wait, message);
    }

    public void submitForm() {
        Common.buttonClick(this.submitContactUsForm, this.wait);
    }

}
