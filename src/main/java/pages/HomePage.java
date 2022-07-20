package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private final By destinationFieldBy = By.id("ss");
    private final By dateFieldBy = By.xpath("//span[contains(@class,'sb-date-field__icon')]");
    private final By dateStartFieldBy = By.xpath("//td[@data-date='2022-08-01']");
    private final By dateEndFieldBy = By.xpath("//td[@data-date='2022-08-30']");
    private final By searchButtonBy = By.xpath("//span[@class='js-sb-submit-text ']");
    private final WebDriver driver;
    
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public WebElement getSearchButton() {
        return driver.findElement(searchButtonBy);
    }

    public void enterTextToDestinationField(final String searchText) {
        driver.findElement(destinationFieldBy).sendKeys(searchText);
    }

    public void chooseDate(){
        driver.findElement(dateFieldBy).click();
        driver.findElement(dateStartFieldBy).click();
        driver.findElement(dateEndFieldBy).click();
    }

    public void clickSearchButton(long DEFAULT_TIME){
        waitVisibilityOfElement(DEFAULT_TIME, getSearchButton());
        waitForElementIsClickable(DEFAULT_TIME, getSearchButton());
        driver.findElement(searchButtonBy).click();
    }
}
