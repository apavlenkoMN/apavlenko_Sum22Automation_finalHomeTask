package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{



    public MainPage(WebDriver driver){
        super(driver); //вызвать родительский конструктор

    }

    public LoginPage goToAuthPage(){
        driver.findElement(By.linkText("Form Authentication")).click();
        return new LoginPage(driver);
    }

    public DOMPage goToDOMPage(){
        driver.findElement(By.linkText("Challenging DOM")).click();
        return new DOMPage(driver);
    }

    public HoversPage goToHoversPage(){
        driver.findElement(By.linkText("Hovers")).click();
        return new HoversPage(driver);
    }


    public DownloadFilePage goToDownloadFilePage(){
        driver.findElement(By.linkText("File Download")).click();
        return new DownloadFilePage(driver);
    }

    public UploadFilePage goToUploadFilePage(){
        driver.findElement(By.linkText("File Upload")).click();
        return new UploadFilePage(driver);
    }



   // https://the-internet.herokuapp.com/


}
