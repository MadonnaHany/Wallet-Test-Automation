import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Make purchase transaction with rating transaction'
Mobile.tap(findTestObject('FavouriteBillsPageObjects/MyFavorites_Icon'), GlobalVariable.TimeOut)

/*try {
	Mobile.delay(20, FailureHandling.STOP_ON_FAILURE)
	Mobile.tap(findTestObject('FavouriteBillsPageObjects/OkBtn'), 10)
}
catch (Exception ex) {
	KeywordUtil.logInfo("Element is not present!")
}
*/
Mobile.tap(findTestObject('FavouriteBillsPageObjects/Bills-Tap'), GlobalVariable.TimeOut)

Mobile.waitForElementPresent(findTestObject('FavouriteBillsPageObjects/BillerName'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/BillerName'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/MakePaymentBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/PaymentMethodDrp'), 0)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/paymentOption-Fld'), 0)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), GlobalVariable.TimeOut)

Mobile.delay(7, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Payment Page Objects/SlabTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/SlabTab'), GlobalVariable.TimeOut)


//el = findTestObject('FavouriteBillsPageObjects/amountList-Flds')
//CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameIDThenClick'(el, amount)
//Mobile.setText(findTestObject('FavouriteBillsPageObjects/amount'), amount, 0)
//Mobile.tap(findTestObject('FavouriteBillsPageObjects/Amount-Ok-Pop'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), 0)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), GlobalVariable.MPin, 5)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/MPINOkBtn'), 0)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

WebUI.callTestCase(findTestCase('Shared_Testcases/Try to rate transaction with validations'), [:], FailureHandling.STOP_ON_FAILURE)

