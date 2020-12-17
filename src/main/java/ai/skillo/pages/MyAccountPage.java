package ai.skillo.pages;

import javafx.scene.input.InputMethodTextRun;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage<myAccountTitle> {

  public static final String MY_ACCOUNT_TITLE = "My Account";
  public static final String MY_ACCOUNT_LOGOUT_TITLE = "Account Logout";
  public static final String MY_RETURNING_CUSTOMER = "Warning: No match for E-Mail Address and/or Password.";

  WebDriver driver;

  private String pageAddress = "https://electonicstore.com/index.php?route=account/account";

  private By myAccountTitleLocator = By
      .xpath("//*[@id = 'content']/h2[contains(text(), 'My Account')]");
  private By myAccountButtonLocator = By
      .xpath("//*[@class = 'list-inline']//a[contains(@title,'My Account')]");
  private By myAccountLogoutLocator = By
      .xpath("//*[@class = 'dropdown-menu dropdown-menu-right']//a[contains(text(),'Logout')]");
  private By myAccountTitleLogoutLocator = By.xpath("//div[@id = 'content']/h1");
  private By alertLoginLocator = By.xpath("//*[contains(@class, 'alert')]");
  private By logoLocator = By.xpath("//*[@id = 'logo']//*[text() = 'Your Store']");
  private By productLocatorMainPage = By.xpath("//*[@class = 'caption']//a");
  private By productLocatorProductPage = By.xpath("//*[@class = 'col-sm-4']/h1");

  public MyAccountPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getProductNameMainPageValue() {
    return driver.findElement(productLocatorMainPage).getText();
  }

  public MyAccountPage open() {
    driver.get(pageAddress);
    return this;
  }

  public String getTitleValue() {
    return driver.findElement(myAccountTitleLocator).getText();
  }

  public String getTitleLogoutValue() {
    return driver.findElement(myAccountTitleLogoutLocator).getText();
  }

  public MyAccountPage clickMyAccountButton() {
    driver.findElement(myAccountButtonLocator).click();
    return this;
  }

  public MyAccountPage clickLogoutButton() {
    driver.findElement(myAccountLogoutLocator).click();
    return this;
  }

  public MyAccountPage clickLogoButton() {
    driver.findElement(logoLocator).click();
    return this;
  }

  public MyAccountPage clickProductName() {
    driver.findElement(productLocatorMainPage).click();
    return this;
  }

  public String getProductNameProductPage() {
    return driver.findElement(productLocatorProductPage).getText();
  }

  public String getReturningCustomerLocator() {
    return driver.findElement(alertLoginLocator).getText();
  }
}
