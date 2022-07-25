package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import util.PropertiesReader;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {

    private WebDriver driver;
    private static final ThreadLocal<WebDriver> WEBDRIVER_THREADLOCAL = new ThreadLocal<>();

    @BeforeClass
    public void profileSetUp(){
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp(){
        String LOGIN_URL=new PropertiesReader().getURL();
        driver = new ChromeDriver();
        WEBDRIVER_THREADLOCAL.set(driver);
        driver = WEBDRIVER_THREADLOCAL.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(LOGIN_URL);
    }

@AfterMethod
    public void tearDown(){
    WebDriver driver = WEBDRIVER_THREADLOCAL.get();
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public LoginPage getLoginPage(){
        return new LoginPage(getDriver());
    }
}



