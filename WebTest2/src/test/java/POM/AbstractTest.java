package POM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractTest {

    static WebDriver webDriver;
    private static String baseURL;
    private static InputStream configFile;
    private static String username;
    private static String password;


    @BeforeAll
    static void initTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Properties prop = new Properties();
        configFile = new FileInputStream("src/main/resources/my.properties");
        prop.load(configFile);

        baseURL = prop.getProperty("baseURL");
        username = prop.getProperty("username");
        password = prop.getProperty("password");

    }

    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow(() -> getWebDriver().navigate().to(getBaseURL()), "Не удается получить доступ к сайту");
        assertTrue(true);
    }


    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getBaseURL() {
        return baseURL;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }
}
