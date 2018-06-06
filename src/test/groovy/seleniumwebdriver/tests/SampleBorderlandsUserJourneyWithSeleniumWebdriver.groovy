package seleniumwebdriver.tests

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import seleniumwebdriver.tests.component.library.*
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
      when: "you got to the borderlands website"
      driver.get("https://borderlandsthegame.com")

      then: "you are redirected to the borderlands age verification page"
      AgeVerificationPage ageVerificationPage = new AgeVerificationPage(driver)
      ageVerificationPage.isOpen()

      when: "you enter a valid date of birth and click the submit button"
      ageVerificationPage.selectBirthMonth('Jan')
      ageVerificationPage.selectBirthDay('01')
      ageVerificationPage.selectBirthYear('1970')
      ageVerificationPage.submit()

      then: "you are redirected to the borderlands home page"
      BorderlandsHomePage borderlandsHomePage = new BorderlandsHomePage(driver)
      borderlandsHomePage.isOpen()
   }

   def "should be able to navigate to the borderlands 2 game page"() {
      given: "you are at the borderlands home page"
      BorderlandsHomePage borderlandsHomePage = new BorderlandsHomePage(driver)

      when: "you select the borderlands 2 game from the games menu"
      borderlandsHomePage.openGamesDropDown()
      sleep(5000)
      borderlandsHomePage.borderlands2SubMenuOption().click()

      then: "you are redirected to the borderlands 2 game page"
      Borderlands2GamePage borderlands2GamePage = new Borderlands2GamePage(driver)
      borderlands2GamePage.isOpen()
   }

   def "should be able to reach the buy borderlands 2 page"() {
      given: "you are at the borderlands 2 game page"
      Borderlands2GamePage borderlands2GamePage = new Borderlands2GamePage(driver)
      sleep(5000)

      when: "you click on the buy now button"
      borderlands2GamePage.openBuyNowDropDown()
      sleep(5000)

      borderlands2GamePage.borderlands2SubMenuOption().click()

      then: "you are redirected to the buy borderlands 2 page"
      BuyBorderlands2Page buyBorderlands2Page = new BuyBorderlands2Page(driver)
      buyBorderlands2Page.isOpen()
   }

   def "should be able to select platform and reach the best buy website to buy borderlands 2"() {
      given: "you are at the buy borderlands 2 page"
      BuyBorderlands2Page buyBorderlands2Page = new BuyBorderlands2Page(driver)

      when: "you choose mac as the platform"
      buyBorderlands2Page.selectPlatformAsMac()

      and: "you chose best buy as the retailer"
      sleep(5000)
      buyBorderlands2Page.selectRetailerAsBestBuy()

      then: "a new tab opens to buy the game at best buy"
      driver.switchTo().window(driver.windowHandles.last())
      Borderlands2BestBuyPage borderlands2BestBuyPage = new Borderlands2BestBuyPage(driver)
      borderlands2BestBuyPage.isOpen()
   }

   def cleanupSpec() {
      driver.quit()
   }
}
