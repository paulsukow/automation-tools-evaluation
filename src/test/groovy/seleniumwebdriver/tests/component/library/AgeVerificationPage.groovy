package seleniumwebdriver.tests.component.library

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

class AgeVerificationPage {

   private String pageTitle = "Borderlands - Age Verification"

   private WebDriver driver

   public AgeVerificationPage(WebDriver driver) {
      this.driver = driver
   }

   public String getPageTitle() {
      return pageTitle
   }

   public void selectBirthMonth(String month) {
      WebElement birthMonthElement = driver.findElement(By.name('birthmonth:'))
      Select birthMonthComboBox = new Select(birthMonthElement)
      birthMonthComboBox.selectByVisibleText(month)
   }

   public void selectBirthDay(String day) {
      WebElement birthDayElement = driver.findElement(By.name('birthday'))
      Select birthDayComboBox = new Select(birthDayElement)
      birthDayComboBox.selectByVisibleText(day)
   }

   public void selectBirthYear(String year) {
      WebElement birthYearElement = driver.findElement(By.name('birthyear'))
      Select birthYearComboBox = new Select(birthYearElement)
      birthYearComboBox.selectByVisibleText(year)
   }

   public void submit() {
      WebElement submitButton = driver.findElement(By.name('Submit'))
      submitButton.click()
   }

}
