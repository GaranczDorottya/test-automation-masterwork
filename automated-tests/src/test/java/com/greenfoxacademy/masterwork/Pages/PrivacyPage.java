package com.greenfoxacademy.masterwork.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrivacyPage {
    WebDriver driver;

    public PrivacyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"L2AGLb\"]/div")
    WebElement acceptCookiesButton;

    public WebElement getAcceptCookiesButton() {
        return acceptCookiesButton;
    }
}
