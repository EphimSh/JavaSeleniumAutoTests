package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PostPage extends AbstractPage {
    private WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
    private Actions action = new Actions(getWebDriver());

    @FindBy(css = "h1[class*='svelte-tv8alb']")
    private WebElement h1;
    @FindBy(css = "content svelte-tv8alb")
    private WebElement content;
    @FindBy(css = "div[class*='actions'] :nth-child(2)")
    private WebElement deleteButton;

    public PostPage(WebDriver driver) {
        super(driver);
    }

    void deletePost() {
        wait.until(ExpectedConditions.elementToBeClickable(getDeleteButton()));
        action.click(getDeleteButton())
                .build().perform();
    }

    public WebElement getH1() {
        return h1;
    }

    public WebElement getContent() {
        return content;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }
}
