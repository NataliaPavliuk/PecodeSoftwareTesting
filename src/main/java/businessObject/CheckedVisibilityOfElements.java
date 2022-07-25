package businessObject;

import pages.LoginPage;

import java.util.logging.Logger;

public class CheckedVisibilityOfElements {
    public boolean isUsernameFieldVisible(LoginPage loginPage) {
        return loginPage.getUsernameField().isDisplayed();
    }
    public boolean isPasswordFieldVisible(LoginPage loginPage) {
        return loginPage.getPasswordField().isDisplayed();
    }
    public boolean isLoginButtonVisible(LoginPage loginPage) {
        return loginPage.getLoginButton().isDisplayed();
    }
    }

