package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LocatorHelper {

    static {
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"sticky-wrapper\"]/header/div/div[1]/div[1]/a/img")
    public static WebElement imageLogo;

    @FindBy(css = "a[href*=https://www.sovtech.co.za/contact-us/]")
    public static WebElement contactUsLink;

    @FindBy(name = "your_name")
    public static WebElement name;

    @FindBy(name = "email")
    public static WebElement email;

    @FindBy(name = "mobilephone")
    public static WebElement phoneNumber;

    @FindBy(name = "numemployees")
    public static WebElement numOfEmployee;

    @FindBy(name = "message")
    public static WebElement message;

    @FindBy(how = How.CSS, using = "textarea[name^='LEGAL_CONSENT.subscription_type']")
    public static WebElement checkbox;

    @FindBy(how = How.CLASS_NAME, using = "input[class^='hs-button primary large']")
    public static WebElement submitContactUsForm;
}
