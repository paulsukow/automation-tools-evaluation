package seleniumwebdriver

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait
import spock.lang.Specification
import spock.lang.Stepwise

import static java.util.concurrent.TimeUnit.SECONDS

@Stepwise
class SampleBorderlandsUserJourneyWithSeleniumWebdriver extends Specification {

   /*
   Sample user journey with Geb and the Borderlands video game website.
   This user journey is summarized as the following:
   You hear about the Borderlands 2 video game from a friend and decide to check it out.
   You navigate to the borderlands website and verify your age.
   From the home page, you navigate to the borderlands 2 game page where you can read about the game
   and look at screen shots.
   After looking at the game, you decide to buy the game for Mac from Best Buy.
   The user journey ends when the Best Buy page opens
   */

   private static WebDriver driver

   def setupSpec() {
      driver = new ChromeDriver()
      driver.manage().timeouts().implicitlyWait(10, SECONDS)
   }

   def "should be able to reach the borderlands website by completing the age verification"() {
//      given: "you are at the age verification page"
      when: "you got to the borderlands website"
      driver.get("https://borderlandsthegame.com")

      then: "you are redirected to the borderlands age verification page"
      driver.title == "Borderlands - Age Verification"

      when: "you enter a valid date of birth and click the submit button"
      WebElement birthMonthElement = driver.findElement(By.name('birthmonth:'))
      Select birthMonthComboBox = new Select(birthMonthElement)
      birthMonthComboBox.selectByVisibleText('Jan')

      WebElement birthDayElement = driver.findElement(By.name('birthday'))
      Select birthDayComboBox = new Select(birthDayElement)
      birthDayComboBox.selectByVisibleText('01')

      WebElement birthYearElement = driver.findElement(By.name('birthyear'))
      Select birthYearComboBox = new Select(birthYearElement)
      birthYearComboBox.selectByVisibleText('1970')

      WebElement submitButton = driver.findElement(By.name('Submit'))
      submitButton.click()

      then: "you are redirected to the borderlands home page"
      WebDriverWait wait = new WebDriverWait(driver, 10)
      wait.until(ExpectedConditions.titleIs("Borderlands - Home Page"))
   }

   def "should be able to navigate to the borderlands 2 game page"() {
//      given: "you are at the borderlands home page"

      when: "you select the borderlands 2 game from the games menu"
      WebElement gamesMenuOption = driver.findElement(By.linkText("GAMES"))
      Actions actions = new Actions(driver)
      actions.moveToElement(gamesMenuOption).build().perform()

      WebElement borderlands2SubMenuOption = driver.findElement(By.linkText("BORDERLANDS 2"))
      borderlands2SubMenuOption.click()

      then: "you are redirected to the borderlands 2 game page"
      WebDriverWait wait = new WebDriverWait(driver, 10)
      wait.until(ExpectedConditions.titleIs("Borderlands - Borderlands 2"))
   }

   def "should be able to reach the buy borderlands 2 page"() {
//      given: "you are at the borderlands 2 game page"

      when: "you click on the buy now button"
      WebElement buyNowMenuOption = driver.findElement(By.cssSelector("li.hasdrop .buy-text"))
      Actions actions = new Actions(driver)
      actions.moveToElement(buyNowMenuOption).build().perform()

      WebElement borderlands2SubMenuOption = driver.findElement(By.linkText("BORDERLANDS 2"))
      borderlands2SubMenuOption.click()

      then: "you are redirected to the buy borderlands 2 page"
      WebDriverWait wait = new WebDriverWait(driver, 10)
      wait.until(ExpectedConditions.titleIs("Borderlands - Buy Borderlands 2"))
   }

//   def "should be able to select platform and reach the best buy website to buy borderlands 2"() {
//      given: "you are at the buy borderlands 2 page"
//
//      when: "you choose mac as the platform"
//
//      and: "you chose best buy as the retailer"
//
//      then: "a new tab opens to buy the game at best buy"
//   }

   def cleanupSpec() {
      driver.quit()
   }
}
