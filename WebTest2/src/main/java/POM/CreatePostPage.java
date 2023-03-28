package POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreatePostPage extends AbstractPage {
    Actions action = new Actions(getWebDriver());
    @FindBy(css="input[type='text']")
    private WebElement title;
    @FindBy(css="textarea[class*='text-field']")
    private WebElement description;
    @FindBy(css="#create-item > div > div > div:nth-child(3) > div > label > span > textarea")
    private WebElement content;
    @FindBy(css="input[type='date']")
    private WebElement date;
    @FindBy(css="div[class*='submit'] button")
    private WebElement saveButton;


    public CreatePostPage(WebDriver driver) {
        super(driver);
    }

    void putTextInTitle(String text){
        action.click(getTitle())
                .sendKeys(text)
                .build().perform();

    }
    void putTextInDescription(String text){
        action.click(getDescription())
                .sendKeys(text)
                .build().perform();

    }
    void putTextInContent(String text){
        action.click(getContent())
                .sendKeys(text)
                .build().perform();

    }

    void clickSaveButton(){
        action.click(getSaveButton())
                .click().build().perform();
    }


    public WebElement getTitle() {
        return title;
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getContent() {
        return content;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }
}
