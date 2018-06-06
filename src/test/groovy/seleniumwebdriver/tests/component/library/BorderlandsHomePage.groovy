package seleniumwebdriver.tests.component.library

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class BorderlandsHomePage {

   private static final String BORDERLANDS_HOME_PAGE_TITLE = "Borderlands - Home Page"

   private WebDriver driver

   BorderlandsHomePage(WebDriver driver) {
      this.driver = driver
   }

   public boolean isOpen() {
      WebDriverWait wait = new WebDriverWait(driver, 10)
      return wait.until(ExpectedConditions.titleIs(BORDERLANDS_HOME_PAGE_TITLE))
   }

   public openGamesDropDown() {
      Actions actions = new Actions(driver)
      actions.moveToElement(gamesMenuOption()).build().perform()
   }

   private WebElement gamesMenuOption() {
      return driver.findElement(By.linkText("GAMES"))
   }

   public WebElement borderlands2SubMenuOption() {
      driver.findElement(By.linkText("BORDERLANDS 2"))
   }
}
