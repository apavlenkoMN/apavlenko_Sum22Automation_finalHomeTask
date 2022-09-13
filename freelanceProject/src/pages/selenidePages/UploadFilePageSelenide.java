package pages.selenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class UploadFilePageSelenide {


    SelenideElement pageTitle = $("h3");

    SelenideElement fileUploadLink = $("#file-upload");
    SelenideElement uploadButton = $("#file-submit");


    public UploadFilePageSelenide open() {
        Selenide.open("https://the-internet.herokuapp.com/upload");
        pageTitle.isDisplayed();
        return this;
    }



    public String getPageTitle() {
        pageTitle.isDisplayed();
        return pageTitle.getText();
        //  $("h3").shouldHave(Condition.text(title));

    }

    public UploadFilePageSelenide selectFile(String path){
      //  fileUploadLink.sendKeys(path);
        fileUploadLink.shouldBe(Condition.visible).setValue(path);
        return this;
    }

    public UploadFilePageSelenide clickUpload(){
        uploadButton.shouldBe(Condition.visible).click();
        return this;
    }

    public UploadFilePageSelenide upload(String path){
        selectFile(path);
        clickUpload();
        return new UploadFilePageSelenide();
    }



}
