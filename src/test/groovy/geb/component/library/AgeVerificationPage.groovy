package geb.component.library

import geb.Page

class AgeVerificationPage extends Page {

   static url = "https://borderlandsthegame.com"

   static at = { title == "Borderlands - Age Verification" }

   static content = {
      birthMonth(wait: true) { $('select', name: 'birthmonth:') }
      birthDay(wait: true) { $('select', name: 'birthday') }
      birthYear(wait: true) { $('select', name: 'birthyear') }

      submitButton(wait: true) { $('input', name: 'Submit') }
   }
}
