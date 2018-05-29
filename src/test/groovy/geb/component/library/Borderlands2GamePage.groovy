package geb.component.library

import geb.Page
import geb.component.library.modules.MenuBar

class Borderlands2GamePage extends Page {

   static at = { title == "Borderlands - Borderlands 2" }

   static content = {
      menuBar { module MenuBar }
   }
}
