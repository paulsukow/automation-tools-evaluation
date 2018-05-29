package geb.component.library

import geb.Page
import geb.component.library.modules.MenuBar

class BorderlandsHomePage extends Page {

   static at = { title == "Borderlands - Home Page" }

   static content = {
      menuBar { module MenuBar }
   }
}
