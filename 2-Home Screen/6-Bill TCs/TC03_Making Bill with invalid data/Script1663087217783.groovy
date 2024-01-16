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

//Mobile.startExistingApplication(GlobalVariable.APP_Package)
//WebUI.callTestCase(findTestCase('1-Login and Forget Pin/TC01-Login with valid mobile number and valid pin'), [('mobilenumber') : '01089478965'
//        , ('MPin') : '147258', ('ActivationCode') : '69736', ('mobilenumber_DB') : '201089478965'], FailureHandling.STOP_ON_FAILURE)
'Make purchase transaction with invalid mabile number'
Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/TelecomAndInternetTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneBillTab'), GlobalVariable.TimeOut)

//Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), InvalidMobileNumber, GlobalVariable.TimeOut)

try
{
	Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), InvalidMobileNumber, GlobalVariable.TimeOut)
}

 
catch (Exception ex){
	Mobile.tap(findTestObject('CashoutMainPageObjects/android.widget.Button - OK'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)
}

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), InvalidMobileNumber, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MobileNumberConfirmTextBox'), InvalidMobileNumber, 
    GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), 0)

Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/M-Pin'), GlobalVariable.MPin, 5)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/M-Pin-OkBtn'), 0)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept-Status'), 
    0)

Mobile.verifyEqual(TransactionStatus.contains(SuccessfullTransaction), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), 0)

'Make Purchase with invalid pin'
Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/TelecomAndInternetTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneBillTab'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), ValidMobileNumber, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MobileNumberConfirmTextBox'), ValidMobileNumber, 
    GlobalVariable.TimeOut)
Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)


Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), 0)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), InvalidPin, 5)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/MPINOkBtn'), 0)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept-Status'), 
    0)

Mobile.verifyEqual(TransactionStatus.contains(InvalidMpinError), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), 0)

'Make Purchase without enter mobile number'
Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/TelecomAndInternetTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneBillTab'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), emptyMobileNumber, GlobalVariable.TimeOut)

// new code started
continueBtnEnabled=Mobile.getAttribute(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), 'enabled', 10)

	
if(continueBtnEnabled)
	{
	   Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), 10, FailureHandling.STOP_ON_FAILURE)
	}

//end
errorMsg = Mobile.getText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/empty-Mobile-validation'), 0)

Mobile.verifyEqual(errorMsg.contains(emptyMobileNumberError), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), 0)

'Make Purchase with empty pin'
Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/TelecomAndInternetTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneBillTab'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), ValidMobileNumber, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MobileNumberConfirmTextBox'), ValidMobileNumber, 
    GlobalVariable.TimeOut)
Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)


Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), 0)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), emptyPin, 5)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/MPINOkBtn'), 0)

errorMsg = Mobile.getText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/M-Pin-error'), GlobalVariable.TimeOut)

//Mobile.verifyEqual(errorMsg.contains(pinError), true, FailureHandling.CONTINUE_ON_FAILURE)

//new code
Mobile.verifyEqual(errorMsg.equalsIgnoreCase(pinError), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.pressBack()

Mobile.delay(2)

Mobile.pressBack()

Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), GlobalVariable.TimeOut)

'Make purchase transaction with M-pin greater than 6 digit'
Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/TelecomAndInternetTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneBillTab'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), ValidMobileNumber, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MobileNumberConfirmTextBox'), ValidMobileNumber, 
    GlobalVariable.TimeOut)
Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)


Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), 0)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), pinGreaterThan6, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/MPINOkBtn'), 0)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept-Status'), 
    0)

Mobile.verifyEqual(TransactionStatus.contains(SuccessfullTransaction), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), 0)

'Make purchase transaction with mismatch mabile number'
Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/TelecomAndInternetTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneBillTab'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), ValidMobileNumber, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MobileNumberConfirmTextBox'), InvalidMobileNumber, 
    GlobalVariable.TimeOut)
Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)


Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)

// new code started
continueBtnEnabled=Mobile.getAttribute(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), 'enabled', 10)

if(continueBtnEnabled)
	{
	   Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), 10, FailureHandling.STOP_ON_FAILURE)
	}

//end

mismatchError = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/MismatchMobileError'), 0)

// new
Mobile.verifyEqual(mismatchError.contains(mismatchErr), true, FailureHandling.CONTINUE_ON_FAILURE)


Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), 0)

