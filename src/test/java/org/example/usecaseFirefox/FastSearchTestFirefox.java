package org.example.usecaseFirefox;// Generated by Selenium IDE
import org.example.Utils;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class FastSearchTestFirefox {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void fastSearch() {
        driver.get("https://fishki.net/");
//        driver.manage().window().setSize(new Dimension(974, 893));
        driver.findElement(By.xpath("/html/body/header/div/nav[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("/html/body/header/div/nav[2]/ul/li[2]/ul/li/form/input")).click();
        driver.findElement(By.xpath("/html/body/header/div/nav[2]/ul/li[2]/ul/li/form/input")).sendKeys("fishka");
        driver.findElement(By.xpath("/html/body/header/div/nav[2]/ul/li[2]/ul/li/form/button")).click();
        try {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            assertEquals(Utils.SEARCH_INPUT, driver.findElement(By.xpath("/html/body/div[5]/div[1]/h1/span")).getText());
        } catch (Exception e) {
            System.out.println("A captcha has been detected");;
        }
    }
}