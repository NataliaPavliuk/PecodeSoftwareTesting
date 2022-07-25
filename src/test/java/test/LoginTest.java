package test;

import businessObject.CheckedVisibilityOfElements;
import businessObject.TryLogin;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import util.JsonReader;

import java.lang.reflect.Method;

import static util.ExtendTestManager.startTest;

@Listeners(CustomerTestListener.class)
@Epic("Tests")
@Feature("Login Tests")
public class LoginTest extends BaseTest {

    @DataProvider(name = "dp")
    public Object[][] readJson() {
        JsonReader jsonReader = new JsonReader();
        jsonReader.jsonReader();
        JsonArray data = jsonReader.getData();
        int n = 2;
        String[][] arr = new String[n][data.size() - 1];
        for (int i = 0; i < data.size(); i++) {
            JsonObject field = (JsonObject) data.get(i);
            String username = (String) field.get("Username");
            String password = (String) field.get("Password");
            arr[i][0] = username + "," + password;
        }
        return arr;
        }


        @org.testng.annotations.Test(dataProvider = "dp", description = "Try login with a non-existent username")
        public void unsuccessfulLoginTest(String data, Method method) {
            startTest(method.getName(), "Try login");
            String[] fields = data.split(",");
            JsonReader jsonReader = new JsonReader();
            jsonReader.jsonReader();
            LoginPage loginPage = getLoginPage();
            CheckedVisibilityOfElements checkedVisibilityOfElements = new CheckedVisibilityOfElements();
            Assert.assertTrue(checkedVisibilityOfElements.isUsernameFieldVisible(loginPage));
            Assert.assertTrue(checkedVisibilityOfElements.isPasswordFieldVisible(loginPage));
            Assert.assertTrue(checkedVisibilityOfElements.isLoginButtonVisible(loginPage));
            new TryLogin().tryLogin(loginPage,fields[0], fields[1]);
            Assert.assertEquals(loginPage.getErrorMessage(), "No account found with that username.");
            Assert.assertFalse(checkedVisibilityOfElements.isLoginButtonVisible(loginPage));
        }
    }
