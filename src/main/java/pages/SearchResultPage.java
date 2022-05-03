package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage{
    @FindBy(xpath = "//div[@class='sidebar-search']//input[@name='searchline']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@data-id='HP']")
    private WebElement checkboxHP;

    @FindBy(xpath = "//option[contains(@value, 'expensive')]")
    private WebElement expensiveItem;

    @FindBy(xpath = " //button[@class='buy-button goods-tile__buy-button ng-star-inserted']")
    private WebElement cartButtons;


    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickCartButtonOnFirstProduct() {
       cartButtons.click();
   }

    public WebElement getSearchField() {
        return searchField;
    }

    public void takeExpensiveItem(){expensiveItem.click();}

    public void takeCheckBox(){checkboxHP.click();}
    public void searchBrend(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText, Keys.ENTER);;
    }
    }

