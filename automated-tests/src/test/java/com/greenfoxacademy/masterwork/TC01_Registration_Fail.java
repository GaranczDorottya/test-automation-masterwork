package com.greenfoxacademy.masterwork;

import static org.assertj.core.api.Assertions.*;

import com.greenfoxacademy.masterwork.Pages.HomePage;
import com.greenfoxacademy.masterwork.Pages.RegisterPage;
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
public class TC01_Registration_Fail extends BaseTest {
    Logger LOG = LoggerFactory.getLogger(TC01_Registration_Fail.class);

    @Test
    @DisplayName("#TC01_REGISTRATION_01 - Unsuccessful registration")
    @Description("Unsuccessful registration to Greenfox test-automation-blog with invalid password")
    public void unsuccessfulRegistration() {
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        LOG.info("Opening page...");
        homePage.open();
        LOG.info("Page successfully opened.");
        LOG.info("Navigating to register page.");
        homePage.getRegisterMenuButton().click();
        LOG.info("Attempting registration with given data.");
        registerPage.register("TestUser", "Jane", "Doe", "JaneD@gmail.com", "jdoe1234");
        LOG.info("Attempt unsuccessful, waiting for error message to be displayed.");
        Allure.addAttachment("Failed registration with invalid password.", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        assertThat(registerPage.getPasswordErrorMessage().isDisplayed()).isTrue();
        LOG.info("Error message displayed.");
    }
}
