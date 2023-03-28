package POM;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserPostsTest extends AbstractPositiveTest{



    @Test
    void isValid(){
        UserPostsPage userPostsPage = new UserPostsPage(getWebDriver());
        assertTrue(userPostsPage.getUsername().getText().contains(getUsername()));
    }

    @Test
    void clickOnNotMyPosts(){
        UserPostsPage userPostsPage = new UserPostsPage(getWebDriver());
        userPostsPage.clickOnNotMyPostSwitcher();
        assertTrue(getWebDriver().getCurrentUrl().contains("?owner=notMe&sort=createdAt&order=ASC"));
    }

    @Test
    void clickOnNextPageIsWorking(){
        UserPostsPage userPostsPage = new UserPostsPage(getWebDriver());
        userPostsPage.clickOnNextPageButton();
        assertTrue(getWebDriver().getCurrentUrl().contains("?page=2"));
    }

    @Test
    void clickOnNextPageIsWorkingAndNotMyPosts(){
        UserPostsPage userPostsPage = new UserPostsPage(getWebDriver());
        userPostsPage.clickOnNotMyPostSwitcher();
        userPostsPage.clickOnNextPageButton();
        assertTrue(getWebDriver().getCurrentUrl().contains("?page=2"));
    }

    @Test
    void postCreating(){

    }


}
