package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends AbstractPage {
    @FindBy(css = "tbody[class*='mdc-data-table__content']")
    private WebElement table;

    @FindBy(css = "div[class*='actions svelte-vyyzan'] button[class*='button']")
    private WebElement newPostButton;

    @FindBy(css = "div[class*='mdc-form-field'] button[class*='mdc-icon-button']")
    private WebElement orderSwitcherASCDESC;

    @FindBy(css = "div.mdc-card__actions button:nth-child(2)")
    private WebElement seeNotMyPostsButton;

    @FindBy(css = "span[class*='mdc-deprecated-list-item__text']")
    private WebElement userProfile;

    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTable() {
        return table;
    }

    public WebElement getNewPostButton() {
        return newPostButton;
    }

    public WebElement getOrderSwitcherASCDESC() {
        return orderSwitcherASCDESC;
    }

    public WebElement getSeeNotMyPostsButton() {
        return seeNotMyPostsButton;
    }

    public WebElement getUserProfile() {
        return userProfile;
    }
}
