package geb.component.library

import geb.Page

class BuyBorderlands2Page extends Page {

   static at = { title == "Borderlands - Buy Borderlands 2" }

   static content = {
      borderlands2Game(wait: true) { $('li[id="borderlands-2"]') }
   }
}
