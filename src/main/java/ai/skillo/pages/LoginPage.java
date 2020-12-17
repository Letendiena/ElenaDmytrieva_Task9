package ai.skillo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

  WebDriver driver;
  private String pageAddress = "https://electonicstore.com/index.php?route=account/login";

  @FindBy(xpath = "//input[@id = 'input-email']")
  private WebElement emailInput;

  @FindBy(xpath = "//input[@id = 'input-password']")
  private WebElement passwordInput;

  @FindBy(xpath = "//input[@value = 'Login']")
  private WebElement loginButton;

  public LoginPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  public LoginPage open() {
    driver.get(pageAddress);
    return this;
  }

  public LoginPage inputEmailValue(String value) {
    emailInput.sendKeys(value);
    return this;
  }

  public LoginPage inputPasswordValue(String value) {
    passwordInput.sendKeys(value);
    return this;
  }

  public MyAccountPage clickLoginButton() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    loginButton.click();
    return new MyAccountPage(driver);
  }
}

