package geb.tests

import geb.component.library.AgeVerificationPage
import geb.component.library.BorderlandsHomePage
import geb.spock.GebReportingSpec

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

      then: "you are redirected the the borderlands home page"
      browser.at(BorderlandsHomePage)
   }
}
