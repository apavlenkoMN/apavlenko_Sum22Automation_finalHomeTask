package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy(xpath = "//a[contains(@href,'login')]")
    private WebElement loginLink;


    @FindBy(xpath = "//a[contains(@href,'register')]")
    private WebElement createAccountLink;

    @FindBy(xpath = "//div[contains(@class, 'home-page')]/h4")
    private WebElement titleText;


    public MainPage(WebDriver driver){
        super(driver); //вызвать родительский конструктор

    }

    public LoginPage openLoginPage(){
        loginLink.click();
        return new LoginPage(driver);
    }

//    public RegisterPage createNewAccount(){
//        createAccountLink.click();
//        return new RegisterPage(driver);
//    }

    public String checkTitle(){
        return  titleText.getText();
    }


}
