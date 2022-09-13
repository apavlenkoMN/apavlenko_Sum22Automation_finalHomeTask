package pages.selenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DownloadFilePageSelenide {

    public DownloadFilePageSelenide open() {
        Selenide.open("https://the-internet.herokuapp.com/download");
        pageTitle.isDisplayed();
        return this;
    }

//        public DownloadFilePageSelenide(WebDriver driver){
//
//        super(driver);
//        PageFactory.initElements(driver, this);
//    }
//

    SelenideElement firstFile = $x("//div[contains(@class, 'example')]/a");
    SelenideElement txtFile = $x("//div[contains(@class, 'example')]/a[contains(text(),'txt')]");


    SelenideElement pageTitle = $("h3");


    public String getPageTitle() {
        pageTitle.isDisplayed();
        return pageTitle.getText();
      //  $("h3").shouldHave(Condition.text(title));

       // return pageTitle.getText();
    }

    public DownloadFilePageSelenide downloadFile() {
        firstFile.click();
      //  $x("//div[contains(@class, 'example')]/a").click();
        return this;
    }

    public String getFileName() {
        return txtFile.getText();
    }

    public DownloadFilePageSelenide downloadTXTFile() {

        try {
            txtFile.shouldBe(Condition.visible).click();
        } catch (Exception e) {
            System.out.println("there is no txt file in the list");
        }
    return this;
    }
}
