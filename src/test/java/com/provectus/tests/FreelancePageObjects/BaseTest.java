package com.provectus.tests.FreelancePageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.MainPage;

public class BaseTest {

    protected WebDriver driver;


    @BeforeClass
    public void setUp(){

        System.out.println("starting");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        System.out.println("closing");
    }

    public MainPage openApp(){
        driver.get("https://the-internet.herokuapp.com");
        return new MainPage(driver);
    }

}
