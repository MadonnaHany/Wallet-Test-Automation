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

CustomKeywords.'customkeywords.Keywords.selectSpecificElementFromWithinList'(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/btcsList-Fld'), 'Cash Out')

try
{
   Mobile.setText(findTestObject('CashoutMainPageObjects/agentNumberTxt'), ValidMobileNumber, GlobalVariable.TimeOut)
}

catch (Exception ex){
	Mobile.tap(findTestObject('CashoutMainPageObjects/android.widget.Button - OK'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)
}
Mobile.setText(findTestObject('CashoutMainPageObjects/agentNumberTxt'), ValidMobileNumber, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('CashoutMainPageObjects/reEnterAgentNumberTxt'), ValidMobileNumber, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('CashoutMainPageObjects/withdrawlAmountTxt'), '1',GlobalVariable.TimeOut)


Mobile.tap(findTestObject('CashoutMainPageObjects/ContinuBtn'), GlobalVariable.TimeOut)
////new
reviewMerchantNumber = Mobile.getText(findTestObject('CashoutMainPageObjects/MerchantNo_Reciept'),GlobalVariable.TimeOut)
////new
Mobile.verifyEqual(reviewMerchantNumber.contains(ValidMobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)


Mobile.tap(findTestObject('CashoutMainPageObjects/confirmBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('CashoutMainPageObjects/mPinTxt'), GlobalVariable.MPin, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/MPIN-OK-BTN'),
	GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Shared Test Cases Objects/Invalid M-PIN Page Objects/RatePopUpSkipBtn'), GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Object Repository/CashoutMainPageObjects/android.widget.TextView - Successful Transaction'),GlobalVariable.TimeOut)

Mobile.verifyEqual(TransactionStatus.contains(SuccessfullTransaction), true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Shared_Testcases/Try to rate trnx with writting reason'), [:], FailureHandling.STOP_ON_FAILURE)

//old code
//Mobile.setText(findTestObject('CashoutMainPageObjects/agentNumberTxt'), ValidMobileNumber, GlobalVariable.TimeOut)
//
//Mobile.setText(findTestObject('CashoutMainPageObjects/reEnterAgentNumberTxt'), ValidMobileNumber, 0)
//
//Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), 0, FailureHandling.STOP_ON_FAILURE)
//
//Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)
//
//Mobile.setText(findTestObject('CashoutMainPageObjects/withdrawlAmountTxt'), '1.6', 10)
//
//Mobile.verifyElementExist(findTestObject('CashoutMainPageObjects/withdrawlAmountErrorMessageTxt'), GlobalVariable.TimeOut)

