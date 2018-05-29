package seleniumwebdriver

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import spock.lang.Specification

import static java.util.concurrent.TimeUnit.SECONDS

class SampleBorderlandsUserJourneyWithSeleniumWebdriver extends Specification {

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

   def cleanup() {
      driver.quit()
   }
}
