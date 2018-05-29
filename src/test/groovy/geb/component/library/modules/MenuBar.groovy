package geb.component.library.modules

import geb.Module

class MenuBar extends Module {

   static content = {
      mainMenuOption(wait: true) { option -> $('li.hasdrop').$('a', text: iContains("${option}")) }
      subMenuOption(wait: true) { option -> $('li.hassubdrop').$('a', text: iContains("${option}")) }

      gamesMenuOption(wait: true) { mainMenuOption('games') }
      buyNowMenuOption(wait: true) { mainMenuOption('buy now') }

      borderlands2SubMenuOption(wait: true) { subMenuOption('Borderlands 2') }
   }
}
