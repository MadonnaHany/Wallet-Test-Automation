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

Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Re-Enter Mobile Number-txt field'), ValidMobileNumber, 
    GlobalVariable.TimeOut)
Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Pmt method DDL'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/PmtMethodOption'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/continue button'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/AmountField-Popup'), AmountField, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Amount-Ok-Button'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/ConfirmBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/M-Pin'), GlobalVariable.MPin, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/M-Pin-OkBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept-Status'), 
    0)

Mobile.verifyEqual(TransactionStatus.contains(SuccessfullTransaction), true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Shared_Testcases/try to report issue with transaction with validations'), [('Email') : 'mtest@test.com'], 
    FailureHandling.STOP_ON_FAILURE)

