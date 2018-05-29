package geb.component.library

import geb.Page

class BorderlandsHomePage extends Page {

   static at = { title == "Borderlands - Home Page" }

   static content = {
      gamesMenuOption(wait: true) { $('li.hasdrop').$('a', text: iContains('games')) }
      borderlands2SubMenuOption(wait: true) { $('li.hassubdrop').$('a', text: iContains('Borderlands 2')) }
   }
}
