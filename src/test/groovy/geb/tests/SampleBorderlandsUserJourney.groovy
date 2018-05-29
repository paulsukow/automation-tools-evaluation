package geb.tests

import geb.component.library.AgeVerificationPage
import geb.component.library.Borderlands2GamePage
import geb.component.library.BorderlandsHomePage
import geb.component.library.BuyBorderlands2Page
import geb.spock.GebReportingSpec
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

   def "should be able to reach the buy borderlands 2 page"() {
      given: "you are at the borderlands 2 game page"
      Borderlands2GamePage borderlands2GamePage = browser.at(Borderlands2GamePage)

      when: "you click on the buy now button"
      interact {
         moveToElement(borderlands2GamePage.buyNowMenuOption)
      }
      borderlands2GamePage.borderlands2SubMenuOption.click()

      then: "you are redirected to the buy borderlands 2 page"
      BuyBorderlands2Page buyBorderlands2Page = browser.at(BuyBorderlands2Page)
   }

   def "should be able to select platform and reach the best buy website to buy borderlands 2"() {
      given: "you are at the buy borderlands 2 page"
      BuyBorderlands2Page buyBorderlands2Page = browser.at(BuyBorderlands2Page)

      when: "you choose mac as the platform"
      buyBorderlands2Page.choosePlatformMenu.click()
      buyBorderlands2Page.macOption.click()

      and: "you chose best buy as the retailer"
      buyBorderlands2Page.chooseRetailerMenu.click()
      buyBorderlands2Page.bestBuyOption.click()

      then: "a new tab opens to buy the game at best buy"
      withWindow({title == 'Borderlands 2 - Mac - Best Buy'}) {
        assert title == 'Borderlands 2 - Mac - Best Buy'
      }
   }
}
