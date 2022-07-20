package businessObject;

import pages.HomePage;
import java.util.logging.Logger;

public class CheckFilters {
    public static Logger logger = Logger.getLogger((CheckFilters.class).toString());

    public void checkFilters(HomePage homePage, long DEFAULT_TIME){
        homePage.chooseDate();
        homePage.clickSearchButton(DEFAULT_TIME);
        logger.info("filters are checked");
    }

}
