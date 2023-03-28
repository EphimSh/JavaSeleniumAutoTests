package POM;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.time.Duration;

import static POM.AbstractTest.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreatePostTest extends AbstractPositiveTest {

    private String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam at hendrerit nisi, sed aliquet quam. Sed pulvinar augue nec sapien consequat, non pretium arcu fermentum. Sed euismod quam libero, non malesuada purus efficitur ac. Sed eu leo dolor.";
    private static WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(15));

    @BeforeEach
    void goToCreatePost(){
        UserPostsPage userPostsPage = new UserPostsPage(getWebDriver());
        userPostsPage.clickOnNewPostButton();
    }


    @Test
    void createPost() throws ParseException {
        CreatePostPage createPostPage = new CreatePostPage(getWebDriver());
        createPostPage.putTextInTitle("ayo");
        createPostPage.putTextInDescription(lorem);
        createPostPage.putTextInContent(lorem);
        createPostPage.clickSaveButton();
        PostPage postPage = new PostPage(getWebDriver());
        assertTrue(postPage.getH1().getText().contains("ayo"));

    }

    @AfterEach
     void delete(){
        PostPage postPage = new PostPage(getWebDriver());
        postPage.deletePost();
        wait.until(ExpectedConditions.titleContains("Symfony Blog"));
        assertTrue(getWebDriver().getTitle().contains("Symfony Blog"));
    }
}
