import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
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

CustomKeywords.'customkeywords.Keywords.selectSpecificElementFromWithinList'(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/btcsList-Fld'), 'Send Money')

String BillingAcct=	CustomKeywords.'db_operations.RechargeDBOperations.GetMobileNumForSendingMoney'()

double BeforeTrnxBalance
BeforeTrnxBalance=CustomKeywords.'db_operations.MyWalletDBOperations.GetBalance'(GlobalVariable.MobileNumber)

try {
Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), BillingAcct, GlobalVariable.TimeOut)
}
catch (Exception ex){
	Mobile.tap(findTestObject('CashoutMainPageObjects/android.widget.Button - OK'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)
	Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), BillingAcct, GlobalVariable.TimeOut)
	
	}

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MobileNumberConfirmTextBox'), BillingAcct,
	GlobalVariable.TimeOut)


Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('CashoutMainPageObjects/withdrawlAmountTxt'), Amount, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutMainPageObjects/ContinuBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutMainPageObjects/confirmBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('CashoutMainPageObjects/mPinTxt'), '147258', GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/MPIN-OK-BTN'),
	GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

//try {

//Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)
//}
//catch(Exception ex) {
	Mobile.verifyElementVisible(findTestObject('Object Repository/send Money/smsNotify'),GlobalVariable.TimeOut)
	Mobile.tap(findTestObject('Object Repository/send Money/smsNotify_NOBtn'),GlobalVariable.TimeOut)
	Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)
	
	
//}


TransactionStatus = Mobile.getText(findTestObject('Shared Test Cases Objects/Invalid M-PIN Page Objects/Transaction_receipt_status'),GlobalVariable.TimeOut)

Mobile.verifyEqual(TransactionStatus.contains(SuccessfullTransaction), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Close-Reciept/Done-Btn'), GlobalVariable.TimeOut)

double AfterTrnxBalance
AfterTrnxBalance=CustomKeywords.'db_operations.MyWalletDBOperations.GetBalance'(GlobalVariable.MobileNumber)

 Mobile.verifyGreaterThan(BeforeTrnxBalance, AfterTrnxBalance)









