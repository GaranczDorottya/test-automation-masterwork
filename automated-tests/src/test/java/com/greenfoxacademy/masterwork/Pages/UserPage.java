package com.greenfoxacademy.masterwork.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage {
    WebDriver driver;
    WebDriverWait wait;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
