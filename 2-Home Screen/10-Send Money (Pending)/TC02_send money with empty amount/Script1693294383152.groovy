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

CustomKeywords.'customkeywords.Keywords.selectSpecificElementFromWithinList'(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/btcsList-Fld'), 'Send Money')

String BillingAcct=	CustomKeywords.'db_operations.RechargeDBOperations.GetMobileNumForSendingMoney'()

try
{
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

Mobile.setText(findTestObject('CashoutMainPageObjects/withdrawlAmountTxt'),'  ', GlobalVariable.TimeOut)

continueBtnEnabled=Mobile.getAttribute(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), 'enabled', 10)

if (continueBtnEnabled=='true')
	{
	   Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), 10, FailureHandling.STOP_ON_FAILURE)
	  
	   errorMsg = Mobile.getText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/empty-Mobile-validation'), 0)
	   
	   Mobile.verifyEqual(errorMsg.contains(EmptyAmt), true, FailureHandling.CONTINUE_ON_FAILURE)	     
	}
	
else {
		 
	Mobile.verifyEqual(continueBtnEnabled, 'false', FailureHandling.CONTINUE_ON_FAILURE)
}
