package seleniumwebdriver

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
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

   WebDriver driver

   def setup() {
      driver = new ChromeDriver()
      driver.manage().timeouts().implicitlyWait(10, SECONDS)
   }

   def "test"() {
      when:
      driver.get('http://www.google.com')

      then:
      driver.title == "Google"
   }

//   def "should be able to reach the borderlands website by completing the age verification"() {
//      given: "you are at the age verification page"
//
//      when: "you enter a valid date of birth and click the submit button"
//
//      then: "you are redirected to the borderlands home page"
//   }
//
//   def "should be able to navigate to the borderlands 2 game page"() {
//      given: "you are at the borderlands home page"
//
//      when: "you select the borderlands 2 game from the games menu"
//
//      then: "you are redirected to the borderlands 2 game page"
//   }
//
//   def "should be able to reach the buy borderlands 2 page"() {
//      given: "you are at the borderlands 2 game page"
//
//      when: "you click on the buy now button"
//
//      then: "you are redirected to the buy borderlands 2 page"
//   }
//
//   def "should be able to select platform and reach the best buy website to buy borderlands 2"() {
//      given: "you are at the buy borderlands 2 page"
//
//      when: "you choose mac as the platform"
//
//      and: "you chose best buy as the retailer"
//
//      then: "a new tab opens to buy the game at best buy"
//   }

   def cleanup() {
      driver.quit()
   }
}
