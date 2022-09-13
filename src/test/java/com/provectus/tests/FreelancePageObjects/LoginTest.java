package com.provectus.tests.FreelancePageObjects;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SecurePage;

public class LoginTest extends BaseTest {


    @Test
    public void LoginTest(){

        SecurePage securePage = openApp().goToAuthPage()
                .setUsername("tomsmith")
                .setPassword("SuperSecretPassword!")
                .clickLogin();
        String alert = securePage.getAlertText();
        Assert.assertTrue(alert.contains("You logged into a secure area!"), "user should be logged in");

        securePage.logout();
//
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.setUsername("tomsmith");
//        loginPage.setPassword("SuperSecretPassword!");
//        loginPage.clickLogin();
//
//        System.out.println("1");
//        SecurePage securePage = new SecurePage(driver);
//
//
//        Assert.assertTrue(securePage.getAlertText().contains("You logged into a secure area!"), "user should be logged in");
//        System.out.println("2");
//        securePage.logout();

//        driver.quit();

    }
}
