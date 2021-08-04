package com.greenfoxacademy.masterwork;

import com.greenfoxacademy.masterwork.Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private Properties properties;

    protected HomePage homePage;
    protected SecondBlogPage secondPage;
    protected BlogPostPage blogPostPage;
    protected DailyArchivesJuly02Page archivePage;
    protected AccountPage accountPage;
    protected LoginPage loginPage;
    protected PrivacyPage privacyPage;
    protected RegisterPage registerPage;
    protected UserPage userPage;
    protected LogoutPage logoutPage;

    @BeforeAll
    public void setup() throws IOException {
        properties = new Properties();
        InputStream propertiesStream = this.getClass().getResourceAsStream("/test.properties");
        properties.load(propertiesStream);
        String browser = properties.getProperty("browser");

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);

        homePage = new HomePage(driver);
        secondPage = new SecondBlogPage(driver);
        blogPostPage = new BlogPostPage(driver);
        archivePage = new DailyArchivesJuly02Page(driver);
        accountPage = new AccountPage(driver);
        loginPage = new LoginPage(driver);
        privacyPage = new PrivacyPage(driver);
        registerPage = new RegisterPage(driver);
        userPage = new UserPage(driver);
        logoutPage = new LogoutPage(driver);
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
