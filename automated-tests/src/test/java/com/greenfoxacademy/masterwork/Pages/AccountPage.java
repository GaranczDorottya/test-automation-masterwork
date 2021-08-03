package com.greenfoxacademy.masterwork.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/article/div/div/div/form/div[2]/div/div[3]/div/a")
    WebElement viewProfileLink;

    public WebElement getViewProfileLink() {
        return viewProfileLink;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
