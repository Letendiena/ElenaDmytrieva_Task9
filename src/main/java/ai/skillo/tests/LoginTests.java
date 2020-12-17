package ai.skillo.tests;

import ai.skillo.data.Account;
import ai.skillo.data.AccountFactory;
import ai.skillo.pages.MyAccountPage;
import ai.skillo.pages.RegistrationPage;
import ai.skillo.service.LoginService;
import ai.skillo.service.RegistrationService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {

  private static WebDriver driver = null;

  private Account accountForLogin = AccountFactory.getAccountForLogin();
  private Account accountForWrongLogin = AccountFactory.getAccountForWrongLogin();

  @BeforeMethod
  public void initBrowser() {
    System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--ignore-ssl-errors=yes");
    options.addArguments("--ignore-certificate-errors");
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
  }

  @Test(priority = 1)
  public void confirmLoginWithRegisteredAccount() {
    String titleValue = LoginService.loginAccountPage(driver, accountForLogin)
        .getTitleValue();
    Assert.assertEquals(titleValue, MyAccountPage.MY_ACCOUNT_TITLE, "Page title is not correct!");
  }

  @Test(priority = 2)
  public void impossibleLoginWithNotRegisteredAccount1() {
    String titleValue = LoginService.loginWrongAccountPage(driver, accountForWrongLogin)
        .getReturningCustomerLocator();
    Assert.assertEquals(titleValue, MyAccountPage.MY_RETURNING_CUSTOMER,
        "No warning red title displayed: No match for E-Mail Address and/or Password");
  }

  @Test(priority = 3)
  public void logoutIsWorking() {
    String titleValue = LoginService.logoutAccountPage(driver, accountForLogin)
        .getTitleLogoutValue();
    Assert.assertEquals(titleValue, MyAccountPage.MY_ACCOUNT_LOGOUT_TITLE,
        "Logout page title is not correct!");
  }

  @AfterMethod
  public void closeBrowser() {
    driver.quit();
  }
}

