package com.greenfoxacademy.masterwork;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Logout feature")
public class TC15_Logout extends BaseTest {
    Logger LOG = LoggerFactory.getLogger(TC05_Login_Success.class);

    @Test
    @DisplayName("#TC15_LOGOUT - Successful logout")
    @Description("Successful logout from a logged-in account at Greenfox test-automation-blog")
    public void successfulLogout() {
        LOG.info("Opening page...");
        homePage.open();
        LOG.info("Page successfully opened.");
        LOG.info("Navigating to login page.");
        homePage.getLoginMenuButton().click();
        LOG.info("Logging in with given data.");
        loginPage.login("TestUser", "JDoe1234");
        LOG.info("Navigating to logout page.");
        homePage.getLogoutMenuButton().click();
        assertThat(logoutPage.getLogoutMessage().isDisplayed()).isTrue();
        LOG.info("Checking if log out link is displayed with correct text.");
        assertThat(logoutPage.getLogoutLink().isDisplayed()).isTrue();
        assertThat(logoutPage.getLogoutLink().getText()).isEqualTo("log out");
        LOG.info("Attempting logout");
        logoutPage.getLogoutLink().click();
        assertThat(loginPage.getTitle()).isEqualTo("Log In ‹ Greenfox test-automation-blog — WordPress");
        LOG.info("Logout attempt successful.");
    }
}
