package geb.component.library

import geb.Page
import geb.component.library.modules.MenuBar

class BuyBorderlands2Page extends Page {

   static at = { title == "Borderlands - Buy Borderlands 2" }

   static content = {
      menuBar { module MenuBar }

      borderlands2GameTile(wait: true) { $('li[id="borderlands-2"]') }

      selectBoxMenu(wait: true) { menuName ->
         borderlands2GameTile.$('div.selectBox', text: iContains("${menuName}"))
      }
      selectBoxItem(wait: true) { itemName ->
         $('ul.dropDown').$('li', text: iContains("${itemName}"))
      }

      choosePlatformMenu { selectBoxMenu('Choose Platform') }
      macOption { selectBoxItem('Mac') }

      chooseRetailerMenu { selectBoxMenu('Choose Retailer') }
      bestBuyOption { selectBoxItem('Best Buy') }
   }
}
