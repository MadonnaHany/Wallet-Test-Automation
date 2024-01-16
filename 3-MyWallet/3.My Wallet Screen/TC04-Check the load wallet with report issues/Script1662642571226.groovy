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
WebUI.callTestCase(findTestCase('1-Login and Forget Pin/TC01-Login with valid mobile number and valid pin'), [('mobilenumber') : '01089478965'
        , ('MPin') : '147258', ('ActivationCode') : '69736', ('mobilenumber_DB') : '201089478965'], FailureHandling.STOP_ON_FAILURE)
*/

CustomKeywords.'customkeywords.Keywords.ScrollUp'()

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/MyWalletIcon'), GlobalVariable.TimeOut)

CustomKeywords.'customkeywords.Keywords.ScrollUp'()

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/MyWalletAccount'), 0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load-Wallet Icon'), 0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load Wallet Page Objects/Select-Payment-Method'), 
    0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load Wallet Page Objects/Payment-Method-Type'), 
    0)

'put the valid amount'
Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load Wallet Page Objects/Amount-Field'), 
    Valid_Amount, 0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load Wallet Page Objects/ContinueBtn'), 
    0)

'Check Load Confirmation Account is Visible'
Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load Wallet Page Objects/Account-confirmation'), 
    GlobalVariable.TimeOut, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load Wallet Page Objects/ConfirmationBtn'), 
    0)

WebUI.callTestCase(findTestCase('Shared_Testcases/try to make with in valid M-Pin'), [('InvalidPin') : '123456', ('TransactionStatus') : ''
        , ('InvalidMpinError') : 'invalid M-PIN'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Shared_Testcases/try to report issue with transaction with validations'), [('Email') : 'mtest@test.com'], 
    FailureHandling.STOP_ON_FAILURE)

