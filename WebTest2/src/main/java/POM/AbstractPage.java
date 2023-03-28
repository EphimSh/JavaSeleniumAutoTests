package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    private WebDriver webDriver;

    public AbstractPage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }
    protected WebDriver getWebDriver(){return this.webDriver;}
}
