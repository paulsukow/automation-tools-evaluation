package geb.tests

import geb.component.library.AgeVerificationPage
import geb.spock.GebReportingSpec

class SampleBorderlandsUserJourney extends GebReportingSpec {

   def "should be able to reach the borderlands website by completing the age verification"() {
      when: "you go to the age verification page"
      browser.go(AgeVerificationPage.url)

      then: "you are at the age verification page"
      at AgeVerificationPage

   }
}
