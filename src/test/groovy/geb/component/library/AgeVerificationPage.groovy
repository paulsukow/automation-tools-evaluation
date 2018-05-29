package geb.component.library

import geb.Page

class AgeVerificationPage extends Page {

   static url = "https://borderlandsthegame.com"

   static at = { title == "Borderlands - Age Verification" }

   static content = {

      birthMonth(wait: true) { $('div[name="birthMonth:"]') }
   }
}
