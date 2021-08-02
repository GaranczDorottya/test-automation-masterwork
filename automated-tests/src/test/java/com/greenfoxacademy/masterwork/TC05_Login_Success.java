package com.greenfoxacademy.masterwork;

import com.greenfoxacademy.masterwork.Pages.HomePage;
import com.greenfoxacademy.masterwork.Pages.LoginPage;
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

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Login feature")
public class TC05_Login_Success extends BaseTest {
    Logger LOG = LoggerFactory.getLogger(TC05_Login_Success.class);

    @Test
    @DisplayName("#TC05_LOGIN_02 - Successful login")
    @Description("Successful login to Greenfox test-automation-blog with valid data")
    public void successfulLogin() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        UserPage userPage = new UserPage(driver);
        LOG.info("Opening page...");
        homePage.open();
        LOG.info("Page successfully opened.");
        LOG.info("Navigating to login page.");
        homePage.getLoginMenuButton().click();
        LOG.info("Attempting login with given data.");
        loginPage.login("TestUser", "JDoe1234");
        assertThat(userPage.getTitle()).isEqualTo("Greenfox test-automation-blog – Hello, World! \uD83D\uDC4B");
        LOG.info("Login attempt successful.");
    }
}
