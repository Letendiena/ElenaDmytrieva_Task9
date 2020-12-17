package ai.skillo;

import ai.skillo.data.Account;
import ai.skillo.data.AccountFactory;
import ai.skillo.pages.MainPage;
import ai.skillo.pages.RegistrationPage;
import ai.skillo.service.RegistrationService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {

  private static WebDriver driver = null;

  private Account accountForRegistration = AccountFactory.getAccountForRegistration();

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
  public void registerAccountPageCanBeOpen() {
    Boolean titleValue = RegistrationService.registerAccountPage(driver, accountForRegistration)
        .isRegisterAccountDisplayed();
    Assert.assertTrue(titleValue, "User can't open register account page!");
  }

  @Test(priority = 2)
  public void registerTest() {
    String titleValue = RegistrationService.registerAccount(driver, accountForRegistration)
        .getSuccessTitleValue();
    Assert.assertEquals(titleValue, RegistrationPage.SUCCESS_TITLE_VALUE,
        "Page title is not correct!");
  }

  @Test(priority = 3)
  public void registerNotPossibleWithoutPrivacyPolicyConfirmation() {
    Boolean titleValue = RegistrationService
        .privacyPolicyConfirmation(driver, accountForRegistration)
        .getAlertPrivacyPolicy();
    Assert.assertTrue(titleValue, "Privacy policy confirmation alert is not dispalyed!");
  }

  @AfterMethod
  public void closeBrowser() {
    driver.quit();
  }
}
