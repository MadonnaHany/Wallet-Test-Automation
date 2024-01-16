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

//WebUI.callTestCase(findTestCase('1-Login and Forget Pin/TC01-Login with valid mobile number and valid pin'), [('mobilenumber') : GlobalVariable.MobileNumber, ('MPin') : GlobalVariable.MPin, ('ActivationCode') : '69736', ('mobilenumber_DB') : '201089478965'], FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/TelecomAndInternetTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneTab'), 5)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneRechrgeTab'), 0)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), Phone, 5)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/android.widget.EditText (1)'), Phone, 0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Payment Method List'),
	5)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/Select-The-Payment-Method(my wallet)'), 0)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), 0)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Payment Page Objects/SlabTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/SlabTab'), 0)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), 0)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), GlobalVariable.MPin, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/MPINOkBtn'), 0)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/RateUs Page Objects/SkipBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/RateUs Page Objects/RateBar'), 0)

Mobile.tap(findTestObject('Recharge Page Objects/RateUs Page Objects/FirstOptionOfRateReasons'), 0)

CustomKeywords.'customkeywords.Keywords.ScrollDown'()

Mobile.tap(findTestObject('Recharge Page Objects/RateUs Page Objects/SubmitBtn'), 0)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/RateUs Page Objects/ThanksRatingMsg'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/RateUs Page Objects/ThanksRatingCloseBtn'), 0)

