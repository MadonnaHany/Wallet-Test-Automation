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
CustomKeywords.'customkeywords.Keywords.ScrollUp'()

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/MyWalletIcon'), GlobalVariable.TimeOut)

//CartName = Mobile.getText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/CardNameList'), 5)

CustomKeywords.'customkeywords.Keywords.ScrollUp'()

MyWalletName = Mobile.getText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/MyWalletAccount'), 5)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/MyWalletAccount'), 0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Icon'), 0)

'Validate the happy path scenarion for cash out with validations'
Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Agent Number Field'), 
    ValidAgentNumber, 12)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Re-Enter Agent Number'), 
    ValidAgentNumber, 12)

Mobile.hideKeyboard()

'Select Payment Method with card'
Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Payment Method List'), 
    5)

/*CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameID'(findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/CardNameList'), 
    CartName)
*/
Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/select-the-payment-method (card)'), 10)

'SetInvalidAmount'
Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/WithdrowallAmount'), 
    InvalidAmount, 12)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/ContinueBtn'), 
    0)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/InvalidWithdrowalAmount'), 
    0)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/WithdrowallAmount'), 
    ValidAmount, 12)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/ContinueBtn'), 
    0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Confirm-Cashout'), 
    GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Cofirm-with-Pin'), 
    GlobalVariable.TimeOut)

'Empty Pin'
Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/MPIN-OK-BTN'), 
    0)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/InvalidPinErrorLessThan6'), 
    0)

'Cashout with Invalid M-Pin'
Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Cofirm-with-Pin'), 
    InvalidPin, 12)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/MPIN-OK-BTN'), 
    0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/RatePopUpSkipBtn'), 
    GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/cash_out_receipt_status'), 
    0)

Mobile.verifyEqual(TransactionStatus.contains(InvalidMpinError), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/CloseCashout'), 
    0)

'Cashout with Valid M-Pin'
Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Icon'), 0)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Agent Number Field'), 
    ValidAgentNumber, 12)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Re-Enter Agent Number'), 
    ValidAgentNumber, 12)

'Select Payment Method with card'
Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Payment Method List'), 
    0)

/*CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameID'(findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/CardNameList'), 
    CartName)
*/
Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/select-the-payment-method (card)'), 10)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/WithdrowallAmount'), 
    ValidAmount, 12)

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

Mobile.verifyMatch(TransactionStatus , SuccesfullTransaction, true, FailureHandling.CONTINUE_ON_FAILURE)

'Validate in case agent number is wrong'
Mobile.tap(findTestObject('CashoutMainPageObjects/CloseCashoutReciept'), 0)

'Validate the cashout in wallet statement'
String CashoutWalletStatement = Mobile.getText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout-walletstatement'), 
    GlobalVariable.TimeOut)

//Mobile.verifyEqual(CashoutWalletStatement.contains('Cash out'), true,FailureHandling.CONTINUE_ON_FAILURE)
Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Icon'), 0)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Agent Number Field'), 
    InvalidAgentNumber, 12)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Re-Enter Agent Number'), 
    InvalidAgentNumber, 12)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Payment Method List'), 
    0)

/*CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameID'(findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/CardNameList'), 
    CartName)
*/
Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/select-the-payment-method (card)'), 10)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/WithdrowallAmount'), 
    ValidAmount, 12)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/ContinueBtn'), 
    0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Confirm-Cashout'), 
    GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Cofirm-with-Pin'), 
    GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Cofirm-with-Pin'), 
    GlobalVariable.MPin, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/MPIN-OK-BTN'), 
    0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/RatePopUpSkipBtn'), 
    GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/cash_out_receipt_status'), 
    0)

Mobile.tap(findTestObject('CashoutMainPageObjects/CloseCashoutReciept'), 0)

