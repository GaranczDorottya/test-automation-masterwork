package com.greenfoxacademy.masterwork;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Commenting feature")
public class TC09_10_Parametrised_Data_Input extends BaseTest {
    Logger LOG = LoggerFactory.getLogger(TC09_10_Parametrised_Data_Input.class);

    @BeforeAll
    public void openPageAndLogin() {
        LOG.info("Opening page...");
        homePage.open();
        LOG.info("Page successfully opened.");
        LOG.info("Navigating to login page.");
        homePage.getLoginMenuButton().click();
        LOG.info("Logging in with given data.");
        loginPage.login("TestUser", "JDoe1234");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/blog_input_data.csv", numLinesToSkip = 1)
    @DisplayName("#TC09-#TC10_DATA_INPUT_02-03 - Writing a new comment from given parameter")
    @Description("Writing a new comment to the first and second listed posts using the content of the given CSV file.")
    public void writingCommentFromParameter(String id, String postIndex, String comment) throws InterruptedException {
//      If you would like to add more than one comment, you have to wait about 15 seconds between submitted comments.
        if (Integer.parseInt(id) > 1) {
            LOG.info("Navigating to home page.");
            homePage.open();
            Thread.sleep(15000);
        }
        LOG.info("Navigating to blogpost.");
        homePage.getContinueReadingButtonByIndex(postIndex).click();
        LOG.info("Filling comment field.");
        blogPostPage.getCommentField().sendKeys(comment);
        LOG.info("Submitting comment.");
        blogPostPage.getCommentSubmitButton().click();
        LOG.info("Verifying if comment is displayed.");
        assertThat(blogPostPage.getCommentContent().isDisplayed()).isTrue();
        LOG.info("Verifying if comment is awaiting moderation.");
        assertThat(blogPostPage.getLastCommentStatus().isDisplayed()).isTrue();
        LOG.info("Verifying if comments content.");
        assertThat(blogPostPage.getLastCommentText().getText()).isEqualTo(comment);
        LOG.info("Commenting was successful.");
    }
}
