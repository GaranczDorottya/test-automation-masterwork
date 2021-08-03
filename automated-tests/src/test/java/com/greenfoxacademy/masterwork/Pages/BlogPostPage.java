package com.greenfoxacademy.masterwork.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BlogPostPage {
    WebDriver driver;
    List<WebElement> comments;

    public BlogPostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"main\"]/header/div/nav/ol/li[4]/a/span")
    WebElement button2;

    @FindBy(id = "comment")
    WebElement commentField;

    @FindBy(id = "comment-submit")
    WebElement commentSubmitButton;

    @FindBy(className = "comment-content")
    WebElement commentContent;

    public WebElement getCommentContent() {
        return commentContent;
    }

    public WebElement getCommentSubmitButton() {
        return commentSubmitButton;
    }

    public WebElement getCommentField() {
        return commentField;
    }

    public WebElement getButton2() {
        return button2;
    }

    public WebElement getLastCommentText() {
        comments = driver.findElements(By.className("comment-container"));
        String postId = comments.get(comments.size() - 1).getAttribute("id");
        return driver.findElement(By.xpath("//*[@id=\"" + postId + "\"]/article/div/div[3]/div/p"));
    }

    public WebElement getLastCommentStatus() {
        comments = driver.findElements(By.className("comment-container"));
        String postId = comments.get(comments.size() - 1).getAttribute("id");
        return driver.findElement(By.xpath("//*[@id=\"" + postId + "\"]/article/div/div[3]/p"));
    }
}
