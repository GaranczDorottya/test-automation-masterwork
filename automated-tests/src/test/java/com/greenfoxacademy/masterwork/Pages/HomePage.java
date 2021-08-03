package com.greenfoxacademy.masterwork.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@id=\"menu-item-45\"]/a")
    WebElement registerMenuButton;

    @FindBy(xpath = "//*[@id=\"menu-item-44\"]/a")
    WebElement loginMenuButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/a")
    WebElement olderPostsButton;

    @FindBy(xpath = "//*[@id=\"menu-item-72\"]/a")
    WebElement logoutMenuButton;

    public WebElement getRegisterMenuButton() {
        return registerMenuButton;
    }

    public WebElement getLoginMenuButton() {
        return loginMenuButton;
    }

    public WebElement getOlderPostsButton() {
        return olderPostsButton;
    }

    public WebElement getLogoutMenuButton() {
        return logoutMenuButton;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void open() {
        driver.get("http://test-automation-blog.greenfox.academy/");
        wait.until(ExpectedConditions.elementToBeClickable(registerMenuButton));
    }
}
