package pages.selenidePages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DynamicLoadingPage {

    public DynamicLoadingPage open() {
        Selenide.open("https://the-internet.herokuapp.com/dynamic_loading");
        return this;
    }


    SelenideElement pageTitle = $("h3");

    SelenideElement exampleText = $("h4");

  //  SelenideElement link1 = $("a").shouldHave(href("dynamic_loading/1"));
  //  SelenideElement link2 = $("a").shouldHave(href("dynamic_loading/2"));

      SelenideElement link1 = $x("//div[@class='example']/a[contains(text(),'Example 1')]");
      SelenideElement link2 = $x("//div[@class='example']/a[contains(text(),'Example 2')]");

    SelenideElement start = $x("//div[@id='start']/button");
    SelenideElement loading = $x("//div[@id='loading']");
    SelenideElement finish = $x("//div[@id='finish']");

    public String getPageTitle() {
        pageTitle.isDisplayed();
        return pageTitle.getText();
    }


    public DynamicLoadingPage openLink1(){
        link1.click();
        return this;
    }

    public DynamicLoadingPage openLink2(){
        link2.click();
        return this;
    }

    public DynamicLoadingPage goBackToStart(){
        open();
        return this;
    }


    public String getExampleText(){
        return exampleText.shouldBe(visible).getText();
    }

    public SelenideElement getStart(){
        return start;
    }

    public DynamicLoadingPage startAndCheck(){
        start.shouldBe(visible);
        start.click();
        loading.shouldBe(appear);
      //  $("#loading").waitUntil(visible, 50000).click();
        while (loading.isDisplayed()) {
           // loading.shouldBe(visible);
        }
        //loading.shouldNotBe(visible);
        finish.shouldBe(appear);
        finish.shouldBe(visible);
        finish.getText();
        return this;
    }

    public String getFinishText(){
        return finish.shouldBe(visible).getText();
    }


}
