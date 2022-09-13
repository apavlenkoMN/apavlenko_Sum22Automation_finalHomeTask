package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecurePage extends BasePage{


    @FindBy(css = "a.button")
    private WebElement logoutButton;

    @FindBy(tagName = "h2")
    private WebElement pageTitle;

    @FindBy(id = "flash")
    private WebElement alertText;


    public SecurePage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SecurePage logout(){
        //driver.findElement(By.cssSelector("a.button")).click();
        logoutButton.click();
        return this;
    }

    public String getPageTitle(){

        //return driver.findElement(By.tagName("h2")).getText();
        return pageTitle.getText();
    }

    public String getAlertText(){


      //  return driver.findElement(By.cssSelector(".flash.success")).getText();
      //  return driver.findElement(By.id("flash")).getText();
        return alertText.getText();


    }
}
