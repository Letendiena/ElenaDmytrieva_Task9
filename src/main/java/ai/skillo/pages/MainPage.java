package ai.skillo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

  WebDriver driver;
  private String pageAddress = "https://electonicstore.com/";

  private By myAccountButtonLocator = By
      .xpath("//*[@class = 'list-inline']//a[contains(@title,'My Account')]");
  private By registerButtonLocator = By
      .xpath("//*[@class = 'list-inline']//a[contains(text(),'Register')]");
  private By loginButtonLocator = By
      .xpath("//*[@class = 'list-inline']//a[contains(text(),'Login')]");

  public MainPage(WebDriver driver) {
    this.driver = driver;
  }

  public MainPage open() {
    driver.get(pageAddress);
    return this;
  }

  public MainPage clickMyAccountButton() {
    driver.findElement(myAccountButtonLocator).click();
    return this;
  }

  public RegistrationPage clickRegistrationButton() {
    driver.findElement(registerButtonLocator).click();
    return new RegistrationPage(driver);
  }

  public LoginPage clickLogButton() {
    driver.findElement(loginButtonLocator).click();
    return new LoginPage(driver);
  }
}
