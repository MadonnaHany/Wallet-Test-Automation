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
Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Cashout-Icon'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('CashoutMainPageObjects/Agent-Name-Field'), AgentNumber, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('CashoutMainPageObjects/re-enter_agent Name'), AgentNumber, 0)

Mobile.setText(findTestObject('CashoutMainPageObjects/Withdrowal Amount Field'), WithdowalAmount, 0)

Mobile.tap(findTestObject('CashoutMainPageObjects/ContinuBtn'), 0)

Mobile.tap(findTestObject('CashoutMainPageObjects/Confirm Cashout'), 5)

Mobile.setText(findTestObject('CashoutMainPageObjects/Enter-Pin'), GlobalVariable.MPin, 5)

Mobile.tap(findTestObject('CashoutMainPageObjects/Confirm-Btn'), 0)

Mobile.tap(findTestObject('CashoutMainPageObjects/Skip-Rating'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutMainPageObjects/CloseCashoutReciept'), 5)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/Home Icon'), GlobalVariable.TimeOut)

