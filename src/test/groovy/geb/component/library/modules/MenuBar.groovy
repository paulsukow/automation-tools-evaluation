package geb.component.library.modules

import geb.Module

class MenuBar extends Module {

   static content = {
      gamesMenuOption(wait: true) { $('li.hasdrop').$('a', text: iContains('games')) }
      borderlands2SubMenuOption(wait: true) { $('li.hassubdrop').$('a', text: iContains('Borderlands 2')) }

      buyNowMenuOption(wait: true) { $('li.hasdrop').$('a', text: iContains('buy now')) }
      borderlands2SubMenuOption(wait: true) { $('li.hassubdrop').$('a', text: iContains('Borderlands 2')) }
   }
}
