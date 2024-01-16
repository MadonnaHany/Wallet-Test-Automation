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

'Make purchase transaction with invalid mabile number'
Mobile.tap(findTestObject('FavouriteBillsPageObjects/MyFavorites_Icon'), GlobalVariable.TimeOut)

/*try {
	Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)
    Mobile.tap(findTestObject('FavouriteBillsPageObjects/OkBtn'), 10)
}
catch (Exception ex) {
    KeywordUtil.logInfo('Element is not present!')
} 
*/
Mobile.tap(findTestObject('FavouriteBillsPageObjects/Bills-Tap'), GlobalVariable.TimeOut)

Mobile.waitForElementPresent(findTestObject('FavouriteBillsPageObjects/BillerName'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/BillerName'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/MakePaymentBtn'), GlobalVariable.TimeOut)
Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/PaymentMethodDrp'), 15)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/paymentOption-Fld'), 15)
Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Payment Page Objects/SlabTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/SlabTab'), GlobalVariable.TimeOut)

//el = findTestObject('FavouriteBillsPageObjects/amountList-Flds')
//
//CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameIDThenClick'(el, amount)
//Mobile.setText(findTestObject('FavouriteBillsPageObjects/amount'), amount, GlobalVariable.TimeOut)
//Mobile.tap(findTestObject('FavouriteBillsPageObjects/Amount-Ok-Pop'), 0, FailureHandling.STOP_ON_FAILURE)

//Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), 0)

//Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/M-Pin'), GlobalVariable.MPin, 5)
Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn_Prepaid'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), GlobalVariable.MPin, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/M-Pin-OkBtn'), 0)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

String TransactionStatus = Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept-Status'), 
    0)

Mobile.verifyMatch(TransactionStatus, SuccessfullTransaction, true ,FailureHandling.CONTINUE_ON_FAILURE)
//Mobile.verifyEqual(TransactionStatus.contains(SuccessfullTransaction), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/ClosePurchaseReciept'), 10)

Mobile.waitForElementPresent(findTestObject('FavouriteBillsPageObjects/CancelFavouriteDetailsPage'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/CancelFavouriteDetailsPage'), GlobalVariable.TimeOut)

'Make Purchase with invalid pin'
Mobile.tap(findTestObject('FavouriteBillsPageObjects/MyFavorites_Icon'), GlobalVariable.TimeOut)

Mobile.waitForElementPresent(findTestObject('FavouriteBillsPageObjects/BillerName'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/BillerName'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/MakePaymentBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/PaymentMethodDrp'), 15)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/paymentOption-Fld'), 15)
Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), GlobalVariable.TimeOut)

//el = findTestObject('FavouriteBillsPageObjects/amountList-Flds')
//CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameIDThenClick'(el, amount)
//Mobile.setText(findTestObject('FavouriteBillsPageObjects/amount'), amount, 0)
//Mobile.tap(findTestObject('FavouriteBillsPageObjects/Amount-Ok-Pop'), 0, FailureHandling.STOP_ON_FAILURE)

//Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), 0)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Payment Page Objects/SlabTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/SlabTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn_Prepaid'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), InvalidPin, 5)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/MPINOkBtn'), 0)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept-Status'), 
    0)

Mobile.verifyEqual(TransactionStatus.contains(InvalidMpinError), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/ClosePurchaseReciept'), 10)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/CancelFavouriteDetailsPage'), GlobalVariable.TimeOut)

'Make Purchase with empty pin'
Mobile.tap(findTestObject('FavouriteBillsPageObjects/MyFavorites_Icon'), GlobalVariable.TimeOut)

Mobile.waitForElementPresent(findTestObject('FavouriteBillsPageObjects/BillerName'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/BillerName'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/MakePaymentBtn'), GlobalVariable.TimeOut)
Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/PaymentMethodDrp'), 15)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/paymentOption-Fld'), 15)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), GlobalVariable.TimeOut)

//el = findTestObject('FavouriteBillsPageObjects/amountList-Flds')
//CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameIDThenClick'(el, amount)
//Mobile.setText(findTestObject('FavouriteBillsPageObjects/amount'), amount, 0)
//Mobile.tap(findTestObject('FavouriteBillsPageObjects/Amount-Ok-Pop'), 0, FailureHandling.STOP_ON_FAILURE)
//Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), 0)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Payment Page Objects/SlabTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/SlabTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn_Prepaid'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), emptyPin, 5)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/MPINOkBtn'), 0)

String errorMsg = Mobile.getText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/M-Pin-error'), GlobalVariable.TimeOut)

Mobile.verifyEqual(errorMsg.contains(pinError), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(2)

Mobile.pressBack()

Mobile.delay(2)

Mobile.pressBack()

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/ClosePurchaseReciept'), 0)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/CancelFavouriteDetailsPage'), GlobalVariable.TimeOut)

'Make purchase transaction with M-pin greater than 6 digit'
Mobile.tap(findTestObject('FavouriteBillsPageObjects/MyFavorites_Icon'), GlobalVariable.TimeOut)

Mobile.waitForElementPresent(findTestObject('FavouriteBillsPageObjects/BillerName'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/BillerName'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/MakePaymentBtn'), GlobalVariable.TimeOut)
Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/PaymentMethodDrp'), 15)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/paymentOption-Fld'), 15)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), GlobalVariable.TimeOut)

//el = findTestObject('FavouriteBillsPageObjects/amountList-Flds')
//
//CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameIDThenClick'(el, amount)
//Mobile.setText(findTestObject('FavouriteBillsPageObjects/amount'), amount, 0)
//Mobile.tap(findTestObject('FavouriteBillsPageObjects/Amount-Ok-Pop'), 0, FailureHandling.STOP_ON_FAILURE)
//Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), 0)
//Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/MPINOkBtn'), 0)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Payment Page Objects/SlabTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/SlabTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn_Prepaid'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), pinGreaterThan6, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), GlobalVariable.MPin, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/M-Pin-OkBtn'), 0)

//Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), pinGreaterThan6, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept-Status'), 
    0)

Mobile.verifyMatch(TransactionStatus, SuccessfullTransaction, true ,FailureHandling.CONTINUE_ON_FAILURE)

//Mobile.verifyEqual(TransactionStatus.contains(SuccessfullTransaction), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/ClosePurchaseReciept'), 0)

