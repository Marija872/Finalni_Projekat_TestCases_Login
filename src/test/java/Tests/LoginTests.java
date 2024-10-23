package Tests;


import Base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test(priority = 10)
    public void verifyThatUserCanLogInWithStandardUser() {
        logIn("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(homepagePage.header.getText(), "Swag Labs");
        Assert.assertFalse(isElemDisplayed(loginPage.btnLogin));
    }

    @Test(priority = 10)
    public void verifyThatUserCanLogInWithLockedOutUser() {
        logIn("locked_out_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(homepagePage.header.getText(), "Swag Labs");
        Assert.assertFalse(isElemDisplayed(loginPage.btnLogin));}
    @Test(priority = 15)
    public void verifyThatUserCanLogInWithProblemUser() {
        logIn("problem_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(homepagePage.header.getText(), "Swag Labs");
        Assert.assertFalse(isElemDisplayed(loginPage.btnLogin));}
    @Test(priority = 20)
    public void verifyThatUserCanLogInWithPerformanceGlitchUser() {
        logIn("performance_glitch_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(homepagePage.header.getText(), "Swag Labs");
        Assert.assertFalse(isElemDisplayed(loginPage.btnLogin));}
    @Test(priority = 25)
    public void verifyThatUserCanLogInWithErrorUser() {
        logIn("error_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(homepagePage.header.getText(), "Swag Labs");
        Assert.assertFalse(isElemDisplayed(loginPage.btnLogin));}
    @Test(priority = 30)
    public void verifyThatUserCanLogInWithVisualUser() {
        logIn("visual_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(homepagePage.header.getText(), "Swag Labs");
        Assert.assertFalse(isElemDisplayed(loginPage.btnLogin));}
    @Test(priority = 30)
    public void verifyThatUserCanNotLoginWithoutUsername() {
        logIn("", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(isElemDisplayed(loginPage.btnLogin));
        Assert.assertTrue(isElemDisplayed(loginPage.msgError));
        Assert.assertEquals(loginPage.msgError.getText(), "Epic sadface: Username is required");}
    @Test(priority = 30)
    public void verifyThatUserCanNotLoginWithoutPassword() {
        logIn("standard_user", "");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(isElemDisplayed(loginPage.btnLogin));
        Assert.assertTrue(isElemDisplayed(loginPage.msgError));
        Assert.assertEquals(loginPage.msgError.getText(), "Epic sadface: Password is required");}
    @Test(priority = 30)
    public void verifyThatUsernameISCaseSensitive() {
        logIn("Standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(isElemDisplayed(loginPage.btnLogin));
        Assert.assertTrue(isElemDisplayed(loginPage.msgError));
        Assert.assertEquals(loginPage.msgError.getText(), "Epic sadface: Username and password do not match any user in this service");}
    @Test(priority = 30)
    public void verifyThatPasswordISCaseSensitive() {
        logIn("standard_user", "Secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(isElemDisplayed(loginPage.btnLogin));
        Assert.assertTrue(isElemDisplayed(loginPage.msgError));
        Assert.assertEquals(loginPage.msgError.getText(), "Epic sadface: Username and password do not match any user in this service");}
    @AfterMethod
    public void logOutAfterEachTest() {
        clearCookies();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}