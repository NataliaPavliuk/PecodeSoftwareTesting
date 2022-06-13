package Decorator;

import businessObject.CheckFilters;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class TextInput extends AbstractElement{
    public static Logger logger = Logger.getLogger((CheckFilters.class).toString());
    public TextInput(WebElement webElement) {
        super(webElement);
    }
    public void mySendKeys(CharSequence... charSequence){
        webElement.clear();
        logger.info("Field cleared");
        webElement.sendKeys(charSequence);
    }
}
