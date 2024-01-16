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

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/TelecomAndInternetTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneTab'), 5)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneRechrgeTab'), 0)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), Phone, 5)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/android.widget.EditText (1)'), Phone, 0)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/PaymentMethodDrp'), 0)

Mobile.delay(2)

CustomKeywords.'customkeywords.Keywords.ScrollDown'()

PaymentMethod = Mobile.getText(findTestObject('Recharge Page Objects/Payment Page Objects/paymentLastOption-Fld'), GlobalVariable.TimeOut)

CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameID'(findTestObject('Object Repository/Recharge Page Objects/Payment Page Objects/PaymentMethodList'), 
    PaymentMethod)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), 5)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Payment Page Objects/SlabTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/SlabTab'), 0)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MPINTextBox'), GlobalVariable.MPin, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/MPINOkBtn'), 0)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Payment Page Objects/RatePopUpSkipBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/RatePopUpSkipBtn'), 0)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/DoneBtn'), 12)

