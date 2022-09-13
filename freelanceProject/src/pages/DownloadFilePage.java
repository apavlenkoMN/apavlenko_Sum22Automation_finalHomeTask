package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadFilePage extends BasePage{


    @FindBy(tagName = "h3")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[contains(@class, 'example')]/a")
    private WebElement firstFile;


    @FindBy(xpath = "//div[contains(@class, 'example')]/a[contains(text(),'txt')]")
    private WebElement txtFile;



    public DownloadFilePage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
    }


    public String getPageTitle(){
        return pageTitle.getText();
    }

    public DownloadFilePage downloadFile(){
       firstFile.click();
        return this;
    }

    public String getFileName(){
        return txtFile.getText();
    }

    public DownloadFilePage downloadTXTFile(){

        try {
            txtFile.isDisplayed();
            txtFile.click();
        } catch (Exception e) {
            System.out.println("there is no txt file in the list");
        }



        return this;
    }

//
//    public DownloadFilePage clickUpload(){
//        uploadButton.click();
//        return this;
//    }
//
//    public SecurePage upload(String path){
//        selectFile(path);
//        clickUpload();
//        return new SecurePage(driver);
//    }



}
