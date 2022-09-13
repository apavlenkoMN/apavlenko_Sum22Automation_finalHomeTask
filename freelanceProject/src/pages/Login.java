package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Login {

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "button.radius")
    private WebElement submit;

    @FindBy(css = ".flash.success")
    private WebElement successMessage;

    @FindBy(css = ".flash.error")
    private WebElement error;

    @FindBy(tagName = "h2")
    private WebElement header;


    protected WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }


    public Login inputName (String name){
        userNameInput.sendKeys(name);
        return this;
    }

    public Login inputPass (String pass){
        password.sendKeys(pass);
        return this;
    }

    public Login clickLogin (){
        submit.click();
        return this;
    }

    public boolean isSuccessBannerVisible(){
        return successMessage.isDisplayed();
    }

    public boolean isErrorBannerVisible(){
        return error.isDisplayed();
    }

    public String getHeaderText(){
        return header.getText();
    }

//
//    public BaseLogin waitTillPageLoad(){
//        new WebDriverWait(driver, 22)
//                .until(ExpectedConditions
//                        .visibilityOfAllElements(
//                                submit,
//                                header
//                        ));
//        return new BaseLogin(driver);
//    }



}
