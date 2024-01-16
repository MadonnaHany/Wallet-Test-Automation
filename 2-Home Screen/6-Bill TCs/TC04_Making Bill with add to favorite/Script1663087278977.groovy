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
//
//WebUI.callTestCase(findTestCase('1-Login and Forget Pin/TC01-Login with valid mobile number and valid pin'), [('mobilenumber') : '01089478965'
//        , ('MPin') : '147258', ('ActivationCode') : '69736', ('mobilenumber_DB') : '201089478965'], FailureHandling.STOP_ON_FAILURE)
'Make purchase transaction with add favourite'
Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/TelecomAndInternetTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneBillTab'), GlobalVariable.TimeOut)

String mobile = '011' + System.nanoTime()

//Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), mobile, GlobalVariable.TimeOut)
try
{
	Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), mobile, GlobalVariable.TimeOut)
}

 
catch (Exception ex){
	Mobile.tap(findTestObject('CashoutMainPageObjects/android.widget.Button - OK'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)
}

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), mobile, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MobileNumberConfirmTextBox'), mobile, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/AddToFavouriteCheckBox'), 0)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/FavoriteName'), addToFavoriteName + System.nanoTime(), 
    0)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), GlobalVariable.TimeOut)

FavoriteMsg = Mobile.getText(findTestObject('FavouriteBillsPageObjects/FavouriteSuccessMsg'), GlobalVariable.TimeOut)

Mobile.verifyEqual(FavoriteMsg.contains(addToFavoriteSuccessMsg), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/SuccessMsgOkBtn'), GlobalVariable.TimeOut)

reviewMobileNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/reviewTransactionMobileNumber'), 
    0)

Mobile.verifyEqual(reviewMobileNumber.contains(mobile), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), 0)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), pin, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/MPINOkBtn'), 0)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept-Status'), 
    0)

Mobile.verifyEqual(TransactionStatus.contains(SuccessfullTransaction), true, FailureHandling.CONTINUE_ON_FAILURE)

walletNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/receiptWalletNumber'), 0)

Mobile.verifyEqual(walletNumber.contains(GlobalVariable.MobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

reviewMobileNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/receiptMobileNumber'), 0)

Mobile.verifyEqual(reviewMobileNumber.contains(mobile), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), 0)

'Make purchase transaction with add to favourite without Alias'
Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/TelecomAndInternetTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneBillTab'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), ValidMobileNumber, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MobileNumberConfirmTextBox'), ValidMobileNumber, 
    GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/AddToFavouriteCheckBox'), 0)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/FavoriteName'), addToFavoriteEmptyName, 0)

Mobile.hideKeyboard()

// new code started
continueBtnEnabled=Mobile.getAttribute(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), 'enabled', 10)

if (continueBtnEnabled=='true')
	{
	   Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), 10, FailureHandling.STOP_ON_FAILURE)
	   Mobile.verifyElementExist(findTestObject('Recharge Page Objects/Payment Page Objects/Error_emptyFavName'), GlobalVariable.TimeOut)
	   Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/android.widget.Button - OK'), 0)
	}
	
else if (continueBtnEnabled=='false'){
	FavoriteMsg = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/AddToFavouriteAliasEmptyError'),GlobalVariable.TimeOut)		
		 
	Mobile.verifyEqual(FavoriteMsg.equalsIgnoreCase(emptyFavoriteNameErrMsg), true, FailureHandling.CONTINUE_ON_FAILURE)
}
//end

//FavoriteMsg = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/AddToFavouriteAliasEmptyError'),GlobalVariable.TimeOut)

//Mobile.verifyEqual(FavoriteMsg.equalsIgnoreCase(emptyFavoriteNameErrMsg), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/AddToFavouriteCheckBox'), GlobalVariable.TimeOut)

Mobile.verifyElementNotExist(findTestObject('Recharge Page Objects/Payment Page Objects/FavoriteName'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), GlobalVariable.TimeOut)

reviewMobileNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/reviewTransactionMobileNumber'), 
    0)

Mobile.verifyEqual(reviewMobileNumber.contains(ValidMobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), 0)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), pin, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/MPINOkBtn'), 0)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept-Status'),
	0)

Mobile.verifyEqual(TransactionStatus.contains(SuccessfullTransaction), true, FailureHandling.CONTINUE_ON_FAILURE)

walletNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/receiptWalletNumber'), 0)

Mobile.verifyEqual(walletNumber.contains(GlobalVariable.MobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

reviewMobileNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/receiptMobileNumber'), 0)

Mobile.verifyEqual(reviewMobileNumber.contains(ValidMobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), 0)


