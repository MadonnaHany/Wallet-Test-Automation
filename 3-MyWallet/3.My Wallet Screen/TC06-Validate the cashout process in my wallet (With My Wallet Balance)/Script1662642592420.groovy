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

/*
WebUI.callTestCase(findTestCase('1-Login and Forget Pin/TC01-Login with valid mobile number and valid pin'), [('mobilenumber') : GlobalVariable.MobileNumber
        , ('MPin') : GlobalVariable.MPin, ('ActivationCode') : '69736', ('mobilenumber_DB') : '201089478965'], FailureHandling.STOP_ON_FAILURE)
*/

CustomKeywords.'db_operations.RechargeDBOperations.updateTheDailyLimit'(5000, GlobalVariable.MobileNumber)

CustomKeywords.'db_operations.MyWalletDBOperations.updateTheAccountBalance'(100, GlobalVariable.MobileNumber)

CustomKeywords.'customkeywords.Keywords.ScrollUp'()
	
Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/MyWalletIcon'), GlobalVariable.TimeOut)

CustomKeywords.'customkeywords.Keywords.ScrollUp'()

MyWalletName = Mobile.getText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/MyWalletAccount'), 5)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/MyWalletAccount'), 0)

Mobile.delay(7)

String AccBalanceTxt = Mobile.getText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/AccountBalanceField'), 
    0)

MyWalletBalance = (AccBalanceTxt.split(' ')[0]).toDouble()

double MyWalletnewBalance = MyWalletBalance + 10

double WithdrowalAmount = MyWalletnewBalance - MyWalletBalance

WithdrowalAmountLessThanBalance = WithdrowalAmount.toString()

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Icon'), 0)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Agent Number Field'), 
    ValidAgentNumber, 12)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Re-Enter Agent Number'), 
    ValidAgentNumber, 12)
Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 20)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/WithdrowallAmount'), 
    WithdrowalAmountLessThanBalance, 12)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/ContinueBtn'), 
    0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Confirm-Cashout'), 
    GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Cofirm-with-Pin'), 
    GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Cofirm-with-Pin'), 
    GlobalVariable.MPin, 12)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/MPIN-OK-BTN'), 
    0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/RatePopUpSkipBtn'), 
    GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/cash_out_receipt_status'), 
    0)

Mobile.verifyEqual(TransactionStatus.equalsIgnoreCase(SuccesfullTransaction), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/CloseCashout'), 
    0)

Mobile.delay(7)

AccBalanceTxt = Mobile.getText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/AccountBalanceField'), 
    0)

double MyWalletBalanceAfter = (AccBalanceTxt.split(' ')[0]).toDouble()

Mobile.verifyLessThan(MyWalletBalanceAfter, MyWalletBalance)

//String ExceededAmount = (MyWalletBalanceAfter + 1000).toString()
'Validate that transaction limit is exceed the daily limit'
Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Icon'), 0)

DailyLimit = CustomKeywords.'db_operations.MyWalletDBOperations.GetDailyLimit'(GlobalVariable.MobileNumber)

if (MyWalletBalanceAfter < DailyLimit) {
    Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Agent Number Field'), 
        ValidAgentNumber, 12)

    Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Re-Enter Agent Number'), 
        ValidAgentNumber, 12)

    Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/WithdrowallAmount'), 
        (MyWalletBalanceAfter + 1).toString(), 12)

    Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/ContinueBtn'), 
        0)

    Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Confirm-Cashout'), 
        GlobalVariable.TimeOut)

    Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Cofirm-with-Pin'), 
        GlobalVariable.TimeOut)

    Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Cofirm-with-Pin'), 
        GlobalVariable.MPin, 12)

    Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/MPIN-OK-BTN'), 
        0)

    Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/RatePopUpSkipBtn'), 
        GlobalVariable.TimeOut)

    TransactionStatus = Mobile.getText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/cash_out_receipt_status'), 
        0)

    Mobile.verifyEqual(TransactionStatus.contains(InsuffecientFunds), true,, FailureHandling.CONTINUE_ON_FAILURE)

    Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), 5)
} else {
    Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Agent Number Field'), 
        ValidAgentNumber, 12)

    Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Re-Enter Agent Number'), 
        ValidAgentNumber, 12)

    Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/WithdrowallAmount'), 
        (DailyLimit + 1).toString(), 12)

    Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/ContinueBtn'), 
        0)

    Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Confirm-Cashout'), 
        GlobalVariable.TimeOut)

    Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Cofirm-with-Pin'), 
        GlobalVariable.TimeOut)

    Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Cofirm-with-Pin'), 
        GlobalVariable.MPin, 12)

    Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/MPIN-OK-BTN'), 
        0)

    Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/RatePopUpSkipBtn'), 
        GlobalVariable.TimeOut)

    TransactionStatus = Mobile.getText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/cash_out_receipt_status'), 
        0)
7
    Mobile.verifyEqual(TransactionStatus.equalsIgnoreCase(ExceededAmount), true, FailureHandling.CONTINUE_ON_FAILURE)

    Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), 5)
}

