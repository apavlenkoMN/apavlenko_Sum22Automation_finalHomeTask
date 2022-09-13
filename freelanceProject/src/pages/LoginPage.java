package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{


    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "button.radius")
    private WebElement submit;

    public LoginPage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage setUsername(String name){
        username.clear();
        username.sendKeys(name);
        return this;
    }

    public LoginPage setPassword(String pass){
        password.clear();
        password.sendKeys(pass);
        return this;
    }

    public SecurePage clickLogin(){
        submit.click();
        return new SecurePage(driver);
    }

    public SecurePage login(String name, String pass){
        setUsername(name);
        setPassword(pass);
        clickLogin();
        return new SecurePage(driver);
    }


}
