package com.greenfoxacademy.masterwork.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage{
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user_login-46")
    WebElement usernameField;

    @FindBy(id = "first_name-46")
    WebElement firstNameField;

    @FindBy(id = "last_name-46")
    WebElement lastNameField;

    @FindBy(id = "user_email-46")
    WebElement emailField;

    @FindBy(id = "user_password-46")
    WebElement passwordField;

    @FindBy(id = "confirm_user_password-46")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//*[@id=\"um_field_46_privacy_statement\"]/div[2]/label/span[2]")
    WebElement acceptPrivacy;

    @FindBy(xpath = "//*[@id=\"content\"]/article/div/div/div/form/div[1]/div/div[8]/a")
    WebElement privacyLink;

    @FindBy(id = "um-submit-btn")
    WebElement registerButton;

    @FindBy(xpath = "//*[@id=\"um_field_46_user_password\"]/div[3]")
    WebElement passwordErrorMessage;

    public WebElement getUsernameField() {
        return usernameField;
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public WebElement getAcceptPrivacy() {
        return acceptPrivacy;
    }

    public WebElement getPrivacyLink() {
        return privacyLink;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public WebElement getPasswordErrorMessage() {
        return passwordErrorMessage;
    }

    public void register(String username, String firstName, String lastName, String email, String password){
        getUsernameField().sendKeys(username);
        getFirstNameField().sendKeys(firstName);
        getLastNameField().sendKeys(lastName);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(password);
        getAcceptPrivacy().click();
        getRegisterButton().submit();
    }
}