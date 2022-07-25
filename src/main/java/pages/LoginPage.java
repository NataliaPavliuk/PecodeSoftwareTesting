package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final By usernameField=By.name("username");
    private final By passwordField=By.name("password");
    private final By loginButton=By.xpath("//input[@class='btn btn-success']");
    private final By errorMessageBy=By.xpath(" //div[@class='form-group has-error']//span[@class='help-block']");

    private final WebDriver driver;
    
    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    public WebElement getUsernameField() {
        return driver.findElement(usernameField);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    @Step("write username")
    public void writeUsername(String username){
        getUsernameField().sendKeys(username);
    }

    @Step("write password")
    public void writePassword(String password){
        getPasswordField().sendKeys(password);
    }

    @Step("click login button")
    public void clickLoginButton(){
        getLoginButton().click();
    }

    public String getErrorMessage(){
       return driver.findElement(errorMessageBy).getText();
    }

}
