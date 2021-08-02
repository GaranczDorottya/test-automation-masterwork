package com.greenfoxacademy.masterwork;

import com.greenfoxacademy.masterwork.Pages.HomePage;
import com.greenfoxacademy.masterwork.Pages.LoginPage;
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

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Login feature")
public class TC04_Login_Fail extends BaseTest {
    Logger LOG = LoggerFactory.getLogger(TC04_Login_Fail.class);

    @Test
    @DisplayName("#TC04_LOGIN_01 - Unsuccessful login")
    @Description("Unsuccessful login to Greenfox test-automation-blog with empty password field")
    public void unsuccessfulLogin() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        LOG.info("Opening page...");
        homePage.open();
        LOG.info("Page successfully opened.");
        LOG.info("Navigating to login page.");
        homePage.getLoginMenuButton().click();
        LOG.info("Attempting login with given data.");
        loginPage.login("TestUser", "");
        LOG.info("Login attempt unsuccessful, waiting for error message to be displayed.");
        Allure.addAttachment("Failed login with empty password.", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        assertThat(loginPage.getLoginError().isDisplayed()).isTrue();
        LOG.info("Empty password error message displayed.");
        assertThat(loginPage.getLoginError().getText()).isEqualTo("Error: The password field is empty.");
        LOG.info("Content of error message verified.");
    }
}
