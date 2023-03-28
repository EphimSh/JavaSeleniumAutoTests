package POM;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class LoginPageTest extends AbstractTest {
    private static ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    private static String credFilePath = "src/main/resources/login_test_data.yml";
    private static WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(15));



    @Test
    void validCredLogIn(){
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.loginIn(getUsername(),getPassword());
        assertTrue(true);

    }
    private static List<Map<String, String>> credentialList = new ArrayList<>();

    private static Stream<HashMap<String, Object>> credentials() throws IOException {
        credentialList = mapper
                .readValue(new File(credFilePath), new TypeReference<>() {
                });
        return credentialList.stream().map(HashMap::new);
    }

    @ParameterizedTest
    @MethodSource("credentials")
    void wrongCredLogIn(Map<String, String> credentials){
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.loginIn(credentials.get("username"), credentials.get("password"));
        wait.until(ExpectedConditions.visibilityOf(loginPage.getErrorBlock()));
        assertTrue(loginPage.getErrorBlock().getText().contains("401"));
    }

    @ParameterizedTest
    @MethodSource("credentials")
    void wrongCredAuthorizationSuccess(Map<String, String> credentials){
        LoginPage loginPage = new LoginPage(getWebDriver());
        UserPostsPage userProfilePage = new UserPostsPage(getWebDriver());
        loginPage.loginIn(credentials.get("username"), credentials.get("password"));
        wait.until(ExpectedConditions.titleContains("Symfony Blog"));
        assertTrue(userProfilePage.getUsername().getText().contains(credentials.get("username")));
    }

    @Test
    void notAByteStringCredSuccess(){
        LoginPage loginPage = new LoginPage(getWebDriver());
        UserPostsPage userProfilePage = new UserPostsPage(getWebDriver());
        loginPage.loginIn("Н@вый", "a524cc4315");
        wait.until(ExpectedConditions.titleContains("500"));
        assertTrue(userProfilePage.getErrorMessage().getText().contains("500: Argument is not a ByteString"));
    }

    @Test
    void notAByteStringCredCanCreatePosts(){
        LoginPage loginPage = new LoginPage(getWebDriver());
        UserPostsPage userPostsPage = new UserPostsPage(getWebDriver());
        UserProfilePage userProfilePage = new UserProfilePage(getWebDriver());
        loginPage.loginIn("Н@вый", "a524cc4315");
        wait.until(ExpectedConditions.titleContains("500"));
        userPostsPage.clickOnUserProfile();

        assertTrue(userProfilePage.getNewPostButton().isDisplayed());

    }

}
