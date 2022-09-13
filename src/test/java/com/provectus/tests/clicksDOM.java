package com.provectus.tests;

import com.provectus.tests.FreelancePageObjects.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class clicksDOM extends BaseTest {


//    https://the-internet.herokuapp.com/challenging_dom - нужно кликнуть на каждую кнопку.
//    после этого нужно выбрать все значения из 4й колонки и вывести на экран

    private static WebDriver driver;
    public String url_login = "https://the-internet.herokuapp.com/challenging_dom";

    @Test(description = "clicks and values")
    public void clickButtons() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get(url_login);


        //simple way
        WebElement button1 = driver.findElement(By.xpath("//*/div[@class='row']/*/div[@class='example']/div[@class='row']/div/div/a[@class='button']"));
        //driver.findElement(By.xpath("//*/div[@class='row']/*/div[@class='example']/div[@class='row']/div/div/a[@class='button']")).click();
        button1.click();
        System.out.println(button1 + " was clicked");

        WebElement button2 = driver.findElement(By.xpath("//*/div[@class='row']/*/div[@class='example']/div[@class='row']/div/div/a[@class='button alert']"));
        button2.click();
        System.out.println(button2 + " was clicked");

        WebElement button3 = driver.findElement(By.xpath("//*/div[@class='row']/*/div[@class='example']/div[@class='row']/div/div/a[@class='button success']"));
        button3.click();
        System.out.println(button3 + " was clicked");

//
//        //advanced, but not working
//        List<WebElement> buttons = driver.findElements(By.xpath("//*/div[@class='row']/*/div[@class='example']/div[@class='row']/div/div/a"));
//
//        //buttons.get(0).click();
//
//        for (WebElement temp : buttons) {
//            temp.click();
//            System.out.println(temp + " was clicked");
//        }
//
//


        int columnNumber = 4;

        List<WebElement> columnElement = driver.findElements(By.xpath("//*/tr/td[" + columnNumber+"]"));

        System.out.println("values of column " + columnNumber);
        for (WebElement temp : columnElement) {
            System.out.println(temp.getText());
        }


        driver.quit();
    }








}
