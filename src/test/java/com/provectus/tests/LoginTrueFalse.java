package com.provectus.tests;

import com.provectus.tests.FreelancePageObjects.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LoginTrueFalse extends BaseTest {

//    @BeforeTest
//    public void before() {
//        driver = new ChromeDriver();
//    }
//
    @AfterTest
    public void tearDown()
            //anyway don't work in this case
    {
        if (driver != null){
            driver.quit();
        }
    }


    // https://the-internet.herokuapp.com/login - написать 2 теста, на корректный и некорректный логин.
    // В первом случае - проверить, что отображается сообщение "You logged into a secure area!",
    // во втором сообщение об ошибке логина/пароля


    private static WebDriver driver;
    public String url_login = "https://the-internet.herokuapp.com/login";

    @Test(description = "login should pass", priority = 10)
    public void LoginTestPass() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get(url_login);

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("SuperSecretPassword!");


        WebElement submit = driver.findElement(By.cssSelector("button.radius"));
        submit.click();

        WebElement result = driver.findElement(By.id("flash"));
        Assert.assertTrue(result.getText().contains("You logged into a secure area"));

        driver.quit();
    }


    @Test (description = "login should fail", priority = 20)
    public void LoginTestFail() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get(url_login);

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith2");

        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("SuperSecretPassword!2");


        WebElement submit = driver.findElement(By.cssSelector("button.radius"));
        submit.click();

        WebElement result = driver.findElement(By.id("flash"));
        Assert.assertTrue(result.getText().contains("Your username is invalid!"));
//        Assert.assertEquals(result.getText(), "Your username is invalid!");

        driver.quit();
    }


}
