package com.greenfoxacademy.masterwork.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelloWorldPostPage {
    WebDriver driver;

    public HelloWorldPostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"main\"]/header/div/nav/ol/li[4]/a/span")
    WebElement button2;

    public WebElement getButton2() {
        return button2;
    }
}
