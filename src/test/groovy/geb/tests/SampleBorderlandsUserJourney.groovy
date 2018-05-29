package geb.tests

import geb.component.library.AgeVerificationPage
import geb.component.library.Borderlands2GamePage
import geb.component.library.BorderlandsHomePage
import geb.spock.GebReportingSpec
import org.openqa.selenium.interactions.Actions
import spock.lang.Stepwise

@Stepwise
class SampleBorderlandsUserJourney extends GebReportingSpec {

   def "should be able to reach the borderlands website by completing the age verification"() {
      when: "you go to the age verification page"
      browser.go(AgeVerificationPage.url)

      then: "you are at the age verification page"
      AgeVerificationPage ageVerificationPage = browser.at(AgeVerificationPage)

      when: "you enter a valid date of birth and click the submit button"
      ageVerificationPage.birthMonth = 'Jan'
      ageVerificationPage.birthDay = '01'
      ageVerificationPage.birthYear = '1970'

      ageVerificationPage.submitButton.click()

      then: "you are redirected to the borderlands home page"
      browser.at(BorderlandsHomePage)
   }

   def "should be able to navigate to the borderlands 2 game page"() {
      given: "you are at the borderlands home page"
      BorderlandsHomePage borderlandsHomePage = browser.at(BorderlandsHomePage)

      when: "you select the borderlands 2 game from the games menu"
      interact {
         moveToElement(borderlandsHomePage.gamesMenuOption)
      }
      borderlandsHomePage.borderlands2SubMenuOption.click()

      then: "you are redirected to the borderlands 2 game page"
      browser.at(Borderlands2GamePage)
   }
}
