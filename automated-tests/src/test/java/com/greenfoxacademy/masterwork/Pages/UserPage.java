package com.greenfoxacademy.masterwork.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"content\"]/article/div/div/div/div[2]/div[3]/div[1]/div[1]/a")
    WebElement usersName;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getUsersName() {
        return usersName;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
