package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DOMPage extends BasePage{


    @FindBy(xpath = "//*/div[@class='row']/*/div[@class='example']/div[@class='row']/div/div/a[@class='button']")
    private WebElement button1;

    @FindBy(xpath = "//*/div[@class='row']/*/div[@class='example']/div[@class='row']/div/div/a[@class='button alert']")
    private WebElement button2;

    @FindBy(xpath = "//*/div[@class='row']/*/div[@class='example']/div[@class='row']/div/div/a[@class='button success']")
    private WebElement button3;

    public DOMPage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void clickOnButtonsInOrder(){
        button1.click();
        System.out.println(button1 + " was clicked");
        button2.click();
        System.out.println(button2 + " was clicked");
        button3.click();
        System.out.println(button3 + " was clicked");

    }


    public DOMPage findAndPrintsElementsInColumnN(int columnNumber){

        List<WebElement> columnElement = driver.findElements(By.xpath("//*/tr/td[" + columnNumber+"]"));

        System.out.println("values of column " + columnNumber);
        for (WebElement temp : columnElement) {
            System.out.println(temp.getText());
        }

        return this;
    }

    public List<WebElement> findElementsInColumnN(int columnNumber){

        List<WebElement> columnElement = driver.findElements(By.xpath("//*/tr/td[" + columnNumber+"]"));
        return columnElement;
    }


}
