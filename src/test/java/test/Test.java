package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import pages.HomePage;
import pages.SearchResultPage;
import pages.ShoppingCartPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class Test extends BaseTest {

    private static final long DEFAULT_WAITING_TIME = 90;
    WebDriver driver;


    @DataProvider(name = "data-provider", parallel = true)
    public Object[][] dpMethod(){
        return new Object[][] {{"laptop", "HP", 200000}, {"акумулятор", "HP", 1500}, {"клавіатура", "HP",900}, {"принтер", "HP", 6000}, {"монітор", "HP", 19000}};
    }

    @org.testng.annotations.Test (dataProvider = "data-provider")
    public void checkBasketList(String searchText, String searchBrend, int price) throws InterruptedException {
        HomePage homePage = getHomePage();
        homePage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        homePage.isSearchFieldVisible();
        homePage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        homePage.enterTextToSearchField(searchText);
        SearchResultPage searchResultPage = getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        //getSearchResultPage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getSearchResultPage().isSearchFieldVisible());
        // Thread.sleep(1000);
        searchResultPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME,getSearchResultPage().getSearchField());
        searchResultPage.searchBrend(searchBrend);
        searchResultPage.takeCheckBox();
        searchResultPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        searchResultPage.takeExpensiveItem();
        searchResultPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        //Thread.sleep(1000);
        searchResultPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME,getSearchResultPage().getSearchField());
        searchResultPage.clickCartButtonOnFirstProduct();
        //Thread.sleep(1000);
        homePage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, getHomePage().getHeaderCartButton());
        homePage.clickHeaderCartButton();
        ShoppingCartPage shoppingCartPage = getShoppingCartPage();
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, getShoppingCartPage().getElementPrice());
       // getHomePage().moveToNextWindow();
        // getShoppingCartPage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        Assert.assertTrue(shoppingCartPage.getPrice()>price);

    }
}
