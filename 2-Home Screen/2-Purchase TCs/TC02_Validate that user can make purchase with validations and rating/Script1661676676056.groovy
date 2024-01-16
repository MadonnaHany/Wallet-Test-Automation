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

Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Mobile Number-txt field'), ValidMobileNumber, 
    GlobalVariable.TimeOut)

Mobile.clearText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Mobile Number-txt field'), 0)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Pmt method DDL'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/PmtMethodOption'), GlobalVariable.TimeOut)



if( GlobalVariable.APP_Package=='com.emeint.android.mwallet.test')
	
{
	Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/empty-Mobile-validation'), 1)


Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Mobile Number-txt field'), MobileNumberMissMatch1, 
    GlobalVariable.TimeOut)

Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Re-Enter Mobile Number-txt field'), MobileNumberMissMatch2, 
    GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/MissMatch-MobileValidation'), 
    GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Bill Number (Optional)'), 0)

Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Refrence Number (Optional)'), 
    0)

Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Mobile Number-txt field'), ValidMobileNumber, 
    GlobalVariable.TimeOut)

Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Re-Enter Mobile Number-txt field'), ValidMobileNumber, 
    GlobalVariable.TimeOut)
}

else {
	
	

	
	Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Re-Enter Mobile Number-txt field'), MobileNumberMissMatch2,
		0)
	
	Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/continue button'), GlobalVariable.TimeOut)
	
	Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/empty-Mobile-validation'), 1)
	
	Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Mobile Number-txt field'), MobileNumberMissMatch1,
		GlobalVariable.TimeOut)
	
	Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Re-Enter Mobile Number-txt field'), MobileNumberMissMatch2,
		GlobalVariable.TimeOut)
	
	Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/continue button'), GlobalVariable.TimeOut)
	
	
	Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/MissMatch-MobileValidation'),
		GlobalVariable.TimeOut)
	
	
	Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Bill Number (Optional)'), 0)
	
	Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Refrence Number (Optional)'),
		GlobalVariable.TimeOut)
	
	Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Mobile Number-txt field'), ValidMobileNumber,
		GlobalVariable.TimeOut)
	
	Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Re-Enter Mobile Number-txt field'), ValidMobileNumber,
		GlobalVariable.TimeOut)
	}
	
	


Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/continue button'), GlobalVariable.TimeOut)	

Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/AmountField-Popup'), AmountwithZero, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Amount-Ok-Button'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/AmountwithZeroValidation'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/AmountField-Popup'), AmountWithOutOfRange, 
    GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Amount-Ok-Button'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Out-RangeValueValidation'), GlobalVariable.TimeOut)

AccountBalance = CustomKeywords.'db_operations.MyWalletDBOperations.GetBalance'(GlobalVariable.MobileNumber)

Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/AmountField-Popup'), ValidAmount, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Amount-Ok-Button'), GlobalVariable.TimeOut)

'Validate the review transaction page'
ActualMobNumber = Mobile.getText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Review Transaction Page Objects/MobileNumber-Field'), 
    GlobalVariable.TimeOut)

Mobile.verifyEqual(ActualMobNumber, ValidMobileNumber)

String Purchase = Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Review Transaction Page Objects/Purchase-Amount'), 
    GlobalVariable.TimeOut)

Mobile.verifyEqual(Purchase.split(' ')[0], ValidAmount)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/ConfirmBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/M-Pin'), ErrorMPin, 5)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/M-Pin-OkBtn'), 0)

Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/M-Pin-error'), 0)

Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/M-Pin'), GlobalVariable.MPin, 5)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/M-Pin-OkBtn'), 0)

Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

'Validate the Transaction info (Walet Number)'
Mobile.verifyEqual(Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept Page Objects/WalletNumber-Field'), 
        GlobalVariable.TimeOut).toString(), GlobalVariable.MobileNumber, FailureHandling.CONTINUE_ON_FAILURE)

'Validate the Transaction info (Mobile Number)'
Mobile.verifyEqual(Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept Page Objects/Mobile-Number-Field'), 
        GlobalVariable.TimeOut).toString(), ValidMobileNumber, FailureHandling.CONTINUE_ON_FAILURE)

'Validate the Transaction info (Amount)'
Mobile.verifyEqual((Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept Page Objects/PurchaseAmountField'), 
        GlobalVariable.TimeOut).toString().split(' ')[0]).toString(), ValidAmount, FailureHandling.CONTINUE_ON_FAILURE)

'Validate the transaction status'
TransactionStatus = Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept-Status'), 
    0)

try {
    boolean transactionstatus = Mobile.verifyEqual(TransactionStatus.contains(SuccessfullTransaction), true, FailureHandling.CONTINUE_ON_FAILURE)

    if (transactionstatus) {
        AccountBalance_AfterAmountDeducted = CustomKeywords.'db_operations.MyWalletDBOperations.GetBalance'(GlobalVariable.MobileNumber)
		

        Mobile.verifyLessThan(AccountBalance_AfterAmountDeducted, AccountBalance, FailureHandling.CONTINUE_ON_FAILURE)
    } else {
    }
}
catch (Exception Ex) {
} 

WebUI.callTestCase(findTestCase('Shared_Testcases/Try to rate transaction with validations'), [:], FailureHandling.STOP_ON_FAILURE)

