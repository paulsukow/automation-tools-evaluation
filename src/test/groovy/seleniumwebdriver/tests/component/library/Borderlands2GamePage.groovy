package seleniumwebdriver.tests.component.library

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class Borderlands2GamePage {

   private static final String BORDERLANDS_GAME_PAGE_TITLE = "Borderlands - Borderlands 2"

   private WebDriver driver

   Borderlands2GamePage(WebDriver driver) {
      this.driver = driver
   }

   public boolean isOpen() {
      WebDriverWait wait = new WebDriverWait(driver, 10)
      return wait.until(ExpectedConditions.titleIs(BORDERLANDS_GAME_PAGE_TITLE))
   }

   public openBuyNowDropDown() {
      Actions actions = new Actions(driver)
      actions.moveToElement(buyNowMenuOption()).build().perform()
   }

   private WebElement buyNowMenuOption() {
      return driver.findElement(By.cssSelector("li.hasdrop .buy-text"))
   }

   public WebElement borderlands2SubMenuOption() {
      driver.findElement(By.linkText("BORDERLANDS 2"))
   }
}
