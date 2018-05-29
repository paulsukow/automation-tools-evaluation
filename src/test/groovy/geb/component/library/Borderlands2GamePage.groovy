package geb.component.library

import geb.Page

class Borderlands2GamePage extends Page {

   static at = { title == "Borderlands - Borderlands 2" }

   static content = {
      buyNowMenuOption(wait: true) { $('li.hasdrop').$('a', text: iContains('buy now')) }
      borderlands2SubMenuOption(wait: true) { $('li.hassubdrop').$('a', text: iContains('Borderlands 2')) }
   }
}
