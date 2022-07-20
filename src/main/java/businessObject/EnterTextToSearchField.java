package businessObject;

import pages.HomePage;

import java.util.logging.Logger;


public class EnterTextToSearchField {
    public static Logger logger = Logger.getLogger((CheckFilters.class).toString());
    public void enterText(HomePage homePage, long DEFAULT_WAITING_TIME, String search ){
        homePage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        homePage.getSearchButton();
        homePage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        homePage.enterTextToDestinationField(search);
        logger.info("text written in search field");
    }
}
