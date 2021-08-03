package com.greenfoxacademy.masterwork;

import static org.assertj.core.api.Assertions.*;

import com.greenfoxacademy.masterwork.Pages.HomePage;
import com.greenfoxacademy.masterwork.Pages.RegisterPage;
import com.greenfoxacademy.masterwork.Pages.UserPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

@Feature("Registration feature")
public class TC02_Registration_Success extends BaseTest {
    Logger LOG = LoggerFactory.getLogger(TC02_Registration_Success.class);

    @Test
    @DisplayName("#TC02_REGISTRATION_02 - Successful registration")
    @Description("Successful registration to Greenfox test-automation-blog with valid data")
    public void successfulRegistration() {
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        UserPage userPage = new UserPage(driver);
        LOG.info("Opening page...");
        homePage.open();
        LOG.info("Page successfully opened.");
        LOG.info("Navigating to register page.");
        homePage.getRegisterMenuButton().click();
        LOG.info("Attempting registration with given data.");
        registerPage.register("TestUser", "Jane", "Doe", "JaneD@gmail.com", "JDoe1234");
        LOG.info("Checking if user got redirected to user page.");
        assertThat(userPage.getTitle()).isEqualTo("Jane Doe | Greenfox test-automation-blog");
        LOG.info("Checking if users name is displayed correctly.");
        assertThat(userPage.getUsersName().isDisplayed()).isTrue();
        assertThat(userPage.getUsersName().getText()).isEqualTo("Jane Doe");
        Allure.addAttachment("User page displayed after successful registration.", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        LOG.info("Registration attempt successful.");
    }
}