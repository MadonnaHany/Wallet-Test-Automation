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

//WebUI.callTestCase(findTestCase('1-Login and Forget Pin/TC01-Login with valid mobile number and valid pin'), [('mobilenumber') : GlobalVariable.MobileNumber
//        , ('MPin') : GlobalVariable.MPin, ('ActivationCode') : '69736', ('mobilenumber_DB') : '201089478965'], FailureHandling.STOP_ON_FAILURE)

//old line
//CustomKeywords.'customkeywords.Keywords.selectSpecificElementFromWithinListWithBackwardsSwipe'(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/btcsList-Fld'), 'Cash Out')

//new check
//if (GlobalVariable.APP_Package=='com.emeint.android.mwallet.bm.test')
//	{
//		CustomKeywords.'customkeywords.Keywords.selectSpecificElementFromWithinList'(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/btcsList-Fld'), 'Cash Out')
//		
//	}
//	else {
//		CustomKeywords.'customkeywords.Keywords.selectSpecificElementFromWithinListWithBackwardsSwipe'(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/btcsList-Fld'), 'Cash Out')
//	
//	}


//Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Cashout-Icon'), GlobalVariable.TimeOut)
// new code
CustomKeywords.'customkeywords.Keywords.selectSpecificElementFromWithinList'(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/btcsList-Fld'), 'Cash Out')
try
{
   Mobile.setText(findTestObject('CashoutMainPageObjects/agentNumberTxt'), ValidMobileNumber, GlobalVariable.TimeOut)
}
catch (Exception ex){
	Mobile.tap(findTestObject('CashoutMainPageObjects/android.widget.Button - OK'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)
	
}

Mobile.setText(findTestObject('CashoutMainPageObjects/agentNumberTxt'), ValidMobileNumber, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('CashoutMainPageObjects/agentNumberTxt'), ValidMobileNumber, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('CashoutMainPageObjects/reEnterAgentNumberTxt'), ValidMobileNumber, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('CashoutMainPageObjects/withdrawlAmountTxt'),'   ', 10)

// new line 
//string continueBtnEnabled=Mobile.verifyElementAttributeValue((findTestObject('CashoutMainPageObjects/ContinuBtn')), 'enabled', 'false', 10)

 continueBtnEnabled=Mobile.getAttribute(findTestObject('CashoutMainPageObjects/ContinuBtn'), 'enabled', GlobalVariable.TimeOut)

	
if(continueBtnEnabled)
	{ 
       Mobile.tap(findTestObject('CashoutMainPageObjects/ContinuBtn'), 10, FailureHandling.STOP_ON_FAILURE)
	}

String message = Mobile.getText(findTestObject('CashoutMainPageObjects/withdrawlAmountErrorMessageTxt'),10)
	
Mobile.verifyEqual(message.contains(ErrorMssg), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.pressBack()
	
