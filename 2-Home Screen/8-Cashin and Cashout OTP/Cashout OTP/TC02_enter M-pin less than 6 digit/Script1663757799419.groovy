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

//old line
//CustomKeywords.'customkeywords.Keywords.selectSpecificElementFromWithinListWithBackwardsSwipe'(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/btcsList-Fld'), 'Cash Out')

CustomKeywords.'customkeywords.Keywords.selectSpecificElementFromWithinList'(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/btcsList-Fld'), 'Cash Out')


//Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Cashout-Icon'), GlobalVariable.TimeOut)
try {
Mobile.setText(findTestObject('CashoutMainPageObjects/agentNumberTxt'), ValidMobileNumber, GlobalVariable.TimeOut)
}
catch(Exception ex) {
	Mobile.tap(findTestObject('CashoutMainPageObjects/android.widget.Button - OK'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)
	
}

Mobile.setText(findTestObject('CashoutMainPageObjects/agentNumberTxt'), ValidMobileNumber, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('CashoutMainPageObjects/reEnterAgentNumberTxt'), ValidMobileNumber, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('CashoutMainPageObjects/withdrawlAmountTxt'), '1', 10)

Mobile.tap(findTestObject('CashoutMainPageObjects/ContinuBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutMainPageObjects/confirmBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('CashoutMainPageObjects/mPinTxt'), '12', GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/MPIN-OK-BTN'), 
    GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

//old line
//Mobile.verifyElementText(findTestObject('CashoutMainPageObjects/mPinErrorMessageTxt'), 'Must consist of 6 numbers')

//new lines
String message = Mobile.getText(findTestObject('CashoutMainPageObjects/mPinErrorMessageTxt'),10)

Mobile.verifyEqual(message.contains(MpinErrorMssg), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.pressBack()

Mobile.delay(2)

Mobile.pressBack()
Mobile.pressBack()


