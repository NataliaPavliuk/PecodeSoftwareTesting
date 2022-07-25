package businessObject;

import pages.LoginPage;
import java.util.logging.Logger;

public class TryLogin {
    public static Logger logger = Logger.getLogger((TryLogin.class).toString());

    public void tryLogin(LoginPage loginPage, String username, String password){
        loginPage.writeUsername(username);
        logger.info("Login entered");
        loginPage.writePassword(password);
        logger.info("Password entered");
        loginPage.clickLoginButton();
        logger.info("Login button clicked");
    }

}
