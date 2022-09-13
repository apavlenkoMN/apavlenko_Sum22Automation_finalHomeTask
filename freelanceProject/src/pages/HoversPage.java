package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HoversPage extends BasePage{


    @FindBy(xpath = "//h3[text()='Hovers']")
    private WebElement title;

    @FindBy(xpath = "//h5[text()='name: user1']")
    private WebElement user1;

    @FindBy(xpath = "//h5[text()='name: user2']")
    private WebElement user2;

    @FindBy(xpath = "//h5[text()='name: user3']")
    private WebElement user3;

    @FindBy(css = ".figure")
    private WebElement item1;


    @FindBy(xpath = "//div[2][contains(@class, 'figure')]")
    private WebElement item2;

    @FindBy(xpath = "//div[3][contains(@class, 'figure')]")
    private WebElement item3;


    public HoversPage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
    }


    public WebElement getUser1(){
        return item1;
    }

    public WebElement getUser2(){
        return item2;
    }

    public WebElement getUser3(){
        return item3;
    }


    public void hoverToUser1AndStore(){
        Actions actions = new Actions(driver);
        actions.moveToElement(item1).build().perform();
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(B));
        //return this;
    }

    public HoversPage hoverToUser2AndStore(){

        Actions actions = new Actions(driver);
        actions.moveToElement(item2).build().perform();

        return this;
    }

    public HoversPage hoverToUser3AndStore(){

        Actions actions = new Actions(driver);
        actions.moveToElement(item3).build().perform();

        return this;
    }


    public boolean titleIsDisplayed(){

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Hovers']")));

        return title.isDisplayed();
    }

    public void checkAllUsers(){
        List<WebElement> elements = driver.findElements(By.cssSelector(".figure"));
        Actions actions = new Actions(driver);
        for (int i=0; i<elements.size(); i++){
            actions.moveToElement(elements.get(i)).build().perform();
            String text = elements.get(i).findElement(By.cssSelector(".figcaption > h5")).getText();
            Assert.assertEquals(text, "name: user" + (i + 1));
        }
    }




}
