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
'Make purchase transaction with other amount'
Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/TelecomAndInternetTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneBillTab'), GlobalVariable.TimeOut)

//Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), ValidMobileNumber, GlobalVariable.TimeOut)

try
{
	Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), ValidMobileNumber, GlobalVariable.TimeOut)
}

 
catch (Exception ex){
	Mobile.tap(findTestObject('CashoutMainPageObjects/android.widget.Button - OK'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)
}

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), ValidMobileNumber, GlobalVariable.TimeOut)


Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MobileNumberConfirmTextBox'), ValidMobileNumber, 
    GlobalVariable.TimeOut)
Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)


Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), GlobalVariable.TimeOut)

reviewMobileNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/reviewTransactionMobileNumber'), 
    0)

Mobile.verifyEqual(reviewMobileNumber.contains(ValidMobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountTxt'), otherAmount, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountOkBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), pin, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/MPINOkBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept-Status'), 
    0)

Mobile.verifyEqual(TransactionStatus.equalsIgnoreCase(SuccessfullTransaction), true, FailureHandling.CONTINUE_ON_FAILURE)

walletNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/receiptWalletNumber'), GlobalVariable.TimeOut)

Mobile.verifyEqual(walletNumber.contains(GlobalVariable.MobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

reviewMobileNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/receiptMobileNumber'), GlobalVariable.TimeOut)

Mobile.verifyEqual(reviewMobileNumber.contains(ValidMobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), GlobalVariable.TimeOut)

'Make purchase transaction with other 0 amount'
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

reviewMobileNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/reviewTransactionMobileNumber'), 
    0)

Mobile.verifyEqual(reviewMobileNumber.contains(ValidMobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountTxt'), zeroAmount, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountOkBtn'), GlobalVariable.TimeOut)

errMsg = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountEmptyError'), GlobalVariable.TimeOut)

Mobile.verifyEqual(errMsg.contains(emptyAmountErr)|| errMsg.contains(emptyAmountErr).concat('.'), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.pressBack()

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), pin, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/MPINOkBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept-Status'), 
    GlobalVariable.TimeOut)

Mobile.verifyEqual(TransactionStatus.equalsIgnoreCase(SuccessfullTransaction), true, FailureHandling.CONTINUE_ON_FAILURE)

walletNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/receiptWalletNumber'), GlobalVariable.TimeOut)

Mobile.verifyEqual(walletNumber.contains(GlobalVariable.MobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

reviewMobileNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/receiptMobileNumber'), GlobalVariable.TimeOut)

Mobile.verifyEqual(reviewMobileNumber.contains(ValidMobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), GlobalVariable.TimeOut)

'Make purchase transaction with other empty amount'
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

reviewMobileNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/reviewTransactionMobileNumber'), 
    GlobalVariable.TimeOut)

Mobile.verifyEqual(reviewMobileNumber.contains(ValidMobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountTxt'), emptyAmount, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountOkBtn'), GlobalVariable.TimeOut)

errMsg = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountEmptyError'), GlobalVariable.TimeOut)

Mobile.verifyEqual(errMsg.contains(emptyAmountErr)|| errMsg.contains(emptyAmountErr).concat('.'), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.pressBack()

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), pin, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/MPINOkBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept-Status'), 
    GlobalVariable.TimeOut)

Mobile.verifyEqual(TransactionStatus.equalsIgnoreCase(SuccessfullTransaction), true, FailureHandling.CONTINUE_ON_FAILURE)

walletNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/receiptWalletNumber'), GlobalVariable.TimeOut)

Mobile.verifyEqual(walletNumber.contains(GlobalVariable.MobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

reviewMobileNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/receiptMobileNumber'), GlobalVariable.TimeOut)

Mobile.verifyEqual(reviewMobileNumber.contains(ValidMobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), GlobalVariable.TimeOut)

'Make purchase transaction with other amount smaller than the allowed range'
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

reviewMobileNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/reviewTransactionMobileNumber'), 
    0)

Mobile.verifyEqual(reviewMobileNumber.contains(ValidMobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountTxt'), smallAmount, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountOkBtn'), GlobalVariable.TimeOut)

//errMsg = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountEmptyError'), GlobalVariable.TimeOut)

//new line
errMsg = Mobile.getText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Out-RangeValueValidation'), GlobalVariable.TimeOut)


Mobile.verifyEqual(errMsg.contains(amountRangeErr), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.pressBack()

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), pin, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/MPINOkBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept-Status'), 
    GlobalVariable.TimeOut)

Mobile.verifyEqual(TransactionStatus.equalsIgnoreCase(SuccessfullTransaction), true, FailureHandling.CONTINUE_ON_FAILURE)

walletNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/receiptWalletNumber'), GlobalVariable.TimeOut)

Mobile.verifyEqual(walletNumber.contains(GlobalVariable.MobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

reviewMobileNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/receiptMobileNumber'), GlobalVariable.TimeOut)

Mobile.verifyEqual(reviewMobileNumber.contains(ValidMobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), GlobalVariable.TimeOut)

'Make purchase transaction with other amount greaater than the allowed range'
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

reviewMobileNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/reviewTransactionMobileNumber'), 
    0)

Mobile.verifyEqual(reviewMobileNumber.contains(ValidMobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountTxt'), bigAmount, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountOkBtn'), GlobalVariable.TimeOut)

//errMsg = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountEmptyError'), GlobalVariable.TimeOut)
//new line
errMsg = Mobile.getText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Out-RangeValueValidation'), GlobalVariable.TimeOut)


Mobile.verifyEqual(errMsg.contains(amountRangeErr), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.pressBack()

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), pin, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/MPINOkBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept-Status'), 
    GlobalVariable.TimeOut)

Mobile.verifyEqual(TransactionStatus.equalsIgnoreCase(SuccessfullTransaction), true, FailureHandling.CONTINUE_ON_FAILURE)

walletNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/receiptWalletNumber'), GlobalVariable.TimeOut)

Mobile.verifyEqual(walletNumber.contains(GlobalVariable.MobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

reviewMobileNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/receiptMobileNumber'), GlobalVariable.TimeOut)

Mobile.verifyEqual(reviewMobileNumber.contains(ValidMobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), GlobalVariable.TimeOut)

'Make purchase transaction with other fraction amount'
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

reviewMobileNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/reviewTransactionMobileNumber'), 
    GlobalVariable.TimeOut)

Mobile.verifyEqual(reviewMobileNumber.contains(ValidMobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountTxt'), fractionAmount, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/OtherAmountOkBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), pin, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/MPINOkBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept-Status'), 
    GlobalVariable.TimeOut)

Mobile.verifyEqual(TransactionStatus.equalsIgnoreCase(SuccessfullTransaction), true, FailureHandling.CONTINUE_ON_FAILURE)

walletNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/receiptWalletNumber'), GlobalVariable.TimeOut)

Mobile.verifyEqual(walletNumber.contains(GlobalVariable.MobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

reviewMobileNumber = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/receiptMobileNumber'), GlobalVariable.TimeOut)

Mobile.verifyEqual(reviewMobileNumber.contains(ValidMobileNumber), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), GlobalVariable.TimeOut)

