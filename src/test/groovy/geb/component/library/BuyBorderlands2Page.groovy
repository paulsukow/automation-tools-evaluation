package geb.component.library

import geb.Page

class BuyBorderlands2Page extends Page {

   static at = { title == "Borderlands - Buy Borderlands 2" }

   static content = {
      borderlands2Game(wait: true) { $('li[id="borderlands-2"]') }

      choosePlatformMenu(wait: true) { borderlands2Game.$('div.selectBox', text: iContains('Choose Platform')) }
      macOption(wait: true) { $('ul.dropDown').$('li', text: iContains('Mac')) }

      chooseRetailerMenu(wait: true) { borderlands2Game.$('div.selectBox', text: iContains('Choose Retailer')) }
      bestBuyOption(wait: true) { $('ul.dropDown').$('li', text: iContains('Best Buy')) }
   }
}
