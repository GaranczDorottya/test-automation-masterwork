package com.greenfoxacademy.masterwork.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
    WebDriver driver;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/article/div/div/div/div[2]/div[3]/div[1]/div[1]/a")
    WebElement usersName;

    @FindBy(className = "um-faicon-cog")
    WebElement settingsButton;

    @FindBy(xpath = "//*[@id=\"content\"]/article/div/div/div/div[2]/div[1]/div/div/ul/li[1]/a")
    WebElement editProfileMenuButton;

    @FindBy(id = "um-meta-bio")
    WebElement userBioField;

    @FindBy(xpath = "//*[@id=\"content\"]/article/div/div/div/form/div[5]/div[1]/div[1]/input")
    WebElement updateProfileButton;

    @FindBy(xpath = "//*[@id=\"content\"]/article/div/div/div/div[2]/div[3]/div[2]")
    WebElement userBio;

    public WebElement getUserBio() {
        return userBio;
    }

    public WebElement getUpdateProfileButton() {
        return updateProfileButton;
    }

    public WebElement getUserBioField() {
        return userBioField;
    }

    public WebElement getSettingsButton() {
        return settingsButton;
    }

    public WebElement getEditProfileMenuButton() {
        return editProfileMenuButton;
    }

    public WebElement getUsersName() {
        return usersName;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
