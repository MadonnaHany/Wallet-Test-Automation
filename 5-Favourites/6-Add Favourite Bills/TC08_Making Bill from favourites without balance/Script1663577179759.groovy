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
import com.kms.katalon.core.testobject.MobileTestObject as MobileTestObject

'Select the Service Name'
MobileTestObject el

boolean elementfound

if (CaseType == 'Insufficient amount') {
    CustomKeywords.'db_operations.RechargeDBOperations.updateTheDailyLimit'(5000, GlobalVariable.MobileNumber)

    CustomKeywords.'db_operations.MyWalletDBOperations.updateTheAccountBalance'(0, GlobalVariable.MobileNumber)
} else if (CaseType == 'Exceeded daily limit') {
    CustomKeywords.'db_operations.RechargeDBOperations.updateTheDailyLimit'(0, GlobalVariable.MobileNumber)
} else if ((CaseType == 'Amount Deducted') || (CaseType == 'Invalid Mobile')) {
    CustomKeywords.'db_operations.RechargeDBOperations.updateTheDailyLimit'(5000, GlobalVariable.MobileNumber)

    CustomKeywords.'db_operations.MyWalletDBOperations.updateTheAccountBalance'(1000, GlobalVariable.MobileNumber)
}

double balanceamountbefore_recharge = CustomKeywords.'db_operations.MyWalletDBOperations.GetBalance'(GlobalVariable.MobileNumber)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/MyFavorites_Icon'), GlobalVariable.TimeOut)

try {
	Mobile.delay(25, FailureHandling.STOP_ON_FAILURE)
	Mobile.tap(findTestObject('FavouriteBillsPageObjects/OkBtn'), 10)
}
catch (Exception ex) {
	KeywordUtil.logInfo("Element is not present!")
}

Mobile.tap(findTestObject('FavouriteBillsPageObjects/Bills-Tap'), GlobalVariable.TimeOut)

Mobile.waitForElementPresent(findTestObject('FavouriteBillsPageObjects/BillerName'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/BillerName'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/MakePaymentBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/PaymentMethodDrp'), 0)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/paymentLastOption-Fld'), 0)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), GlobalVariable.TimeOut)

//el = findTestObject('FavouriteBillsPageObjects/amountList-Flds')
//CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameIDThenClick'(el, amount)
//Mobile.setText(findTestObject('FavouriteBillsPageObjects/amount'), amount, 20)
//Mobile.tap(findTestObject('FavouriteBillsPageObjects/Amount-Ok-Pop'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), GlobalVariable.TimeOut)

WebUI.callTestCase(findTestCase('Shared_Testcases/try to make transaction with valid M-Pin'), [('TransactionStatus') : ''
        , ('ExpectedMessage') : Expected_Message], FailureHandling.CONTINUE_ON_FAILURE)

if (CaseType == 'Amount Deducted') {
    double balanceamountafter_recharge = CustomKeywords.'db_operations.MyWalletDBOperations.GetBalance'(GlobalVariable.MobileNumber)

    Mobile.verifyLessThan(balanceamountafter_recharge, balanceamountbefore_recharge)
} else {
    double balanceamountafter_recharge = CustomKeywords.'db_operations.MyWalletDBOperations.GetBalance'(GlobalVariable.MobileNumber)

    Mobile.verifyEqual(balanceamountafter_recharge, balanceamountbefore_recharge)
}

CustomKeywords.'db_operations.RechargeDBOperations.updateTheDailyLimit'(2000, GlobalVariable.MobileNumber)

CustomKeywords.'db_operations.MyWalletDBOperations.updateTheAccountBalance'(2000, GlobalVariable.MobileNumber)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/ClosePurchaseReciept'), 0)

