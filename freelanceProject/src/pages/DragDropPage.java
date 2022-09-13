package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DragDropPage extends BasePage{


    @FindBy(id = "draggable")
    private WebElement draggable;

    @FindBy(id = "droppable")
    private WebElement droppable;

    @FindBy(xpath = "//h5[text()='name: user2']")
    private WebElement user2;


    public DragDropPage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
    }




    public void dragAndDrop(){


        Assert.assertTrue(droppable.getText().contains("Drop here"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable,draggable).build().perform();

        Assert.assertTrue(droppable.getText().contains("Dropped!"));
    }

    public void dragAndDrop2(){

        Assert.assertTrue(droppable.getText().contains("Drop here"));

        Actions actions = new Actions(driver);
        actions.moveToElement(draggable).clickAndHold()
                .moveToElement(droppable).release()
                .build().perform();

        Assert.assertTrue(droppable.getText().contains("Dropped!"));
    }







}
