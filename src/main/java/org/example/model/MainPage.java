package org.example.model;

import org.example.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void doLogin() {
        tryLogin(Utils.CORRECT_LOGIN, Utils.CORRECT_PASSWORD);
    }

    public void doWrongLogin() {
        tryLogin(Utils.CORRECT_LOGIN, Utils.WRONG_PASSWORD);
    }

    public void doLogout() {
        Actions actions = new Actions(driver);
        actions.moveToElement(Utils.getElementBySelector(driver, By.xpath("/html/body/header/div/div/ul/li[2]/a"))).perform();
        actions.moveToElement(Utils.getElementBySelector(driver, By.xpath("/html/body/header/div/div/ul/li[2]/ul/li[7]/a"))).click().perform();
        Utils.waitUntilPageLoads(driver, Duration.ofSeconds(10));
    }

    public void doFastSearch() {
        WebElement fastSearchButton = Utils.getElementBySelector(driver, By.xpath("/html/body/header/div/nav[2]/ul/li[2]/a"));
        fastSearchButton.click();
        WebElement searchInput = Utils.getElementBySelector(driver, By.xpath("/html/body/header/div/nav[2]/ul/li[2]/ul/li/form/input"));
        WebElement searchButton = Utils.getElementBySelector(driver, By.xpath("/html/body/header/div/nav[2]/ul/li[2]/ul/li/form/button"));
        searchInput.sendKeys(Utils.SEARCH_INPUT);
        searchButton.click();
    }

    public String goToPost() {
        WebElement firstPost = Utils.getElementBySelector(driver, By.xpath("/html/body/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div/a"));
        String title = Utils.getElementBySelector(driver, By.xpath("/html/body/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div/div[1]/h2/a/span[1]")).getText();
        firstPost.click();
        return title;
    }

    private void tryLogin(CharSequence login, CharSequence password) {
        WebElement loginButton = Utils.getElementBySelector(driver, By.xpath("/html/body/header/div/div/ul/li/a"));
        loginButton.click();
        WebElement loginInput = Utils.getElementBySelector(driver, By.xpath("/html/body/section/div/div/div[2]/div[1]/form/input[4]']"));
        WebElement loginPassword = Utils.getElementBySelector(driver, By.xpath("/html/body/section/div/div/div[2]/div[1]/form/input[5]"));
        WebElement authButton = Utils.getElementBySelector(driver, By.xpath("/html/body/section/div/div/div[2]/div[1]/form/button"));
        loginInput.clear();
        loginPassword.clear();
        loginInput.sendKeys(login);
        loginPassword.sendKeys(password);
        authButton.click();
    }
}

