package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{


    @FindBy(css = "input[type='text']")
    private WebElement login;

    @FindBy(css = "input[type='password']")
    private WebElement password;

    @FindBy(css = "button[class*='button']")
    private WebElement submitBtn;

    @FindBy(css = "div[class*='error-block'] h2")
    private WebElement errorBlock;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void logInButtonClick(){
        this.submitBtn.click();
    }

    public LoginPage setLogin(String login) {
        this.login.click();
        this.login.sendKeys(login);
        return this;
    }

    public LoginPage setPassword(String password) {
        this.password.click();
        this.password.sendKeys(password);
        return this;
    }

    public void loginIn(String username, String password) {
        Actions action = new Actions(getWebDriver());
        action.click(this.login).sendKeys(this.login, username).build().perform();
        action.click(this.password).sendKeys(this.password, password).build().perform();
        action.click(this.submitBtn).build().perform();

    }

    public WebElement getErrorBlock() {
        return errorBlock;
    }
}
