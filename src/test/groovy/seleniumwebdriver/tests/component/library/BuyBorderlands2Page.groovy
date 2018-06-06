package seleniumwebdriver.tests.component.library

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class BuyBorderlands2Page {

   private static final String BUY_BORDERLANDS_2_PAGE_TITLE = "Borderlands - Buy Borderlands 2"

   private WebDriver driver

   BuyBorderlands2Page(WebDriver driver) {
      this.driver = driver
   }

   public boolean isOpen() {
      WebDriverWait wait = new WebDriverWait(driver, 10)
      return wait.until(ExpectedConditions.titleIs(BUY_BORDERLANDS_2_PAGE_TITLE))
   }

   public void selectPlatformAsMac() {
      borderlands2PlatformDropDown().click()
      macOption().click()
   }

   private WebElement borderlands2PlatformDropDown() {
      return driver.findElement(By.cssSelector('#borderlands-2 #borderlands-2 div.platform'))
   }

   private WebElement macOption() {
      return driver.findElement(By.cssSelector("[style='display: block;'] #mac"))
   }

   public void selectRetailerAsBestBuy() {
      borderlands2RetailerDropDown().click()
      bestBuyOption().click()
   }

   private WebElement borderlands2RetailerDropDown() {
      return driver.findElement(By.cssSelector(".retailer"))
   }

   private WebElement bestBuyOption() {
      return driver.findElement(By.xpath("//p[contains(text(), 'Best Buy')]"))
   }
}
