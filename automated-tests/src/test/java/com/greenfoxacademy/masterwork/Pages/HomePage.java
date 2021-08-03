package com.greenfoxacademy.masterwork.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    List<WebElement> postsOnPage;

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

    @FindBy(xpath = "//*[@id=\"menu-item-85\"]/a")
    WebElement accountMenuButton;

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

    public WebElement getAccountMenuButton() {
        return accountMenuButton;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void open() {
        driver.get("http://test-automation-blog.greenfox.academy/");
        wait.until(ExpectedConditions.elementToBeClickable(registerMenuButton));
    }

    public Date getDateOfLastListedPost() throws ParseException {
        postsOnPage = driver.findElements(By.id("blog-entries"));
        WebElement issueDate = driver.findElement(By.className("meta-date"));
        DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);
        Date lastPostsDate = null;
        for (int i = 0; i < postsOnPage.size(); i++) {
            if (i == postsOnPage.size() - 1) {
                StringBuilder temp = new StringBuilder(issueDate.getText());
                temp.delete(0, temp.indexOf("\n") + 1);
                lastPostsDate = dateFormat.parse(temp.toString());
            }
        }
        return lastPostsDate;
    }
}
