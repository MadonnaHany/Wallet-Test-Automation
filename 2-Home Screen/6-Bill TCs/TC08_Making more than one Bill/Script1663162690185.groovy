import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL as GLOBAL
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

double balanceamountbefore_recharge = CustomKeywords.'db_operations.MyWalletDBOperations.GetBalance'(GlobalVariable.MobileNumber)


'Make More Than One Bill from Home Screen'
Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/New Bill/NewBillBtn'), GlobalVariable.TimeOut)

Mobile.delay(3)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/New Bill/FirstBill'), GlobalVariable.TimeOut)

//Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/New Bill/SecondBill'), GlobalVariable.TimeOut)

Mobile.waitForElementAttributeValue(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/New Bill/PayBtn'), 'enabled', 'true', GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/New Bill/PayBtn'), GlobalVariable.TimeOut)

//new 
Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/android.widget.EditText - Select a payment method'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/android.widget.TextView - My Wallet'), GlobalVariable.TimeOut)



Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/New Bill/ContinueBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/New Bill/ConfirmPayBillsBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), GlobalVariable.MPin, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/MPINOkBtn'), 0)

Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), GlobalVariable.TimeOut)

double balanceamountafter_recharge = CustomKeywords.'db_operations.MyWalletDBOperations.GetBalance'(GlobalVariable.MobileNumber)

Mobile.verifyLessThan(balanceamountafter_recharge, balanceamountbefore_recharge)

