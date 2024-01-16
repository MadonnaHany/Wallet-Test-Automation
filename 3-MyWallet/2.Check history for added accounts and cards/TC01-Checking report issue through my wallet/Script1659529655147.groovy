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
CardName = GlobalVariable.PublicCardName

WebUI.callTestCase(findTestCase('Validate the account has card'), [('CardName') : CardName], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('3-MyWallet/Making-Transaction(Vodafon Recharge) without rating'), [('Phone') : '0120000200'
        , ('TransactionStatus') : 'Successful transaction', ('PaymentMethod') : CardName], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/MyWalletIcon'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/MyWalletAccount'), GlobalVariable.TimeOut)

CustomKeywords.'customkeywords.Keywords.selectSpecificElementFromWithinList'(findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/CardNameList'),
	GlobalVariable.PublicCardName)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/LastTransactionLog'), 
    GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/LastTransactionLog'), 0)

WebUI.callTestCase(findTestCase('Shared_Testcases/try to report issue with transaction with validations'), [('Email') : 'mtest@test.com'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.pressBack()

Mobile.pressBack()

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/Home Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/Home Icon'), 0)

