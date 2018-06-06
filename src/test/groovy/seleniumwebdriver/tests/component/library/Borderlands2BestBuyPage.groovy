package seleniumwebdriver.tests.component.library

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class Borderlands2BestBuyPage {
   private static final String BORDERLANDS_2_BEST_BUY_PAGE_TITLE = "Borderlands 2 - Mac - Best Buy"

   private WebDriver driver

   Borderlands2BestBuyPage(WebDriver driver) {
      this.driver = driver
   }

   public boolean isOpen() {
      WebDriverWait wait = new WebDriverWait(driver, 10)
      return wait.until(ExpectedConditions.titleIs(BORDERLANDS_2_BEST_BUY_PAGE_TITLE))
   }
}
