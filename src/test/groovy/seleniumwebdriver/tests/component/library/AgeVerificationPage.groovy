package seleniumwebdriver.tests.component.library

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

class AgeVerificationPage {

   private static final String AGE_VERIFICATION_PAGE_TITLE = "Borderlands - Age Verification"

   private WebDriver driver

   public AgeVerificationPage(WebDriver driver) {
      this.driver = driver
   }

   public boolean isOpen() {
      return driver.getTitle() == AGE_VERIFICATION_PAGE_TITLE
   }

   public void selectBirthMonth(String month) {
      birthMonthComboBox().selectByVisibleText(month)
   }

   private Select birthMonthComboBox() {
      WebElement birthMonthElement = driver.findElement(By.name('birthmonth:'))
      return new Select(birthMonthElement)
   }

   public void selectBirthDay(String day) {
      birthdayComboBox().selectByVisibleText(day)
   }

   private Select birthdayComboBox() {
      WebElement birthDayElement = driver.findElement(By.name('birthday'))
      return new Select(birthDayElement)
   }

   public void selectBirthYear(String year) {
      birthYearComboBox().selectByVisibleText(year)
   }

   private Select birthYearComboBox() {
      WebElement birthYearElement = driver.findElement(By.name('birthyear'))
      return new Select(birthYearElement)
   }

   public void submit() {
      submitButton().click()
   }

   private WebElement submitButton() {
      driver.findElement(By.name('Submit'))
   }

}
