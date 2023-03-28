package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserPostsPage extends AbstractPage {
    private WebDriverWait wait = new WebDriverWait(getWebDriver(),Duration.ofSeconds(10));

    @FindBy(css = "li[class*='svelte-1rc85o5 mdc-menu-surface--anchor']")
    private WebElement username;

    @FindBy(css = "button[class*='mdc-switch']")
    private WebElement notMyPostsSwitcher;

    @FindBy(css = "div[class*='mdc-form-field'] button[class*='mdc-icon-button']")
    private WebElement orderSwitcherASCDESC;

    @FindBy(css = "div[class*='button-block'] button")
    private WebElement newPostButton;

    @FindBy(css = "div[class*='pagination svelte-d01pfs']")
    private WebElement errorBlock;

    @FindBy(css = "div[class*='container svelte'] p")
    private WebElement errorMessage;

    @FindBy(css = "span[class*='mdc-deprecated-list-item__text']")
    private WebElement userProfile;

    @FindBy(css = "div a[href*='page=2']")
    private WebElement nextPageButton;

    public UserPostsPage(WebDriver driver){
        super(driver);
    }


    public void clickOnUserProfile(){
        Actions action = new Actions(getWebDriver());
        action.click(getUsername()).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getUserProfile()));
        action.click(getUserProfile()).build().perform();
        wait.until(ExpectedConditions.titleContains("Profile"));

    }

    public void clickOnNewPostButton(){
        Actions action = new Actions(getWebDriver());
        action.click(getNewPostButton()).build().perform();
        wait.until(ExpectedConditions.urlContains("/posts/create"));
    }


    public void clickOnNotMyPostSwitcher(){
        Actions action = new Actions(getWebDriver());
        action.click(getNotMyPostsSwitcher()).build().perform();
        wait.until(ExpectedConditions.urlContains("?owner=notMe&sort=createdAt&order=ASC"));
    }

    public void clickOnNextPageButton(){
        Actions action = new Actions(getWebDriver());
        action.click(getNextPageButton()).build().perform();
        wait.until(ExpectedConditions.urlContains("page=2"));
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getNewPostButton() {
        return newPostButton;
    }

    public WebElement getNotMyPostsSwitcher() {
        return notMyPostsSwitcher;
    }

    public WebElement getOrderSwitcherASCDESC() {
        return orderSwitcherASCDESC;
    }

    public WebElement getErrorBlock() {
        return errorBlock;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getUserProfile() {
        return userProfile;
    }

    public WebElement getNextPageButton() {
        return nextPageButton;
    }
}
