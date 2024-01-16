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

//Mobile.startApplication('.//APPS//PhoneCash_2.0.76_15062022_2095_debug.apk', false)
try {
    Mobile.tap(findTestObject('Welcome and Login Page Objects/Welcome Page/SkipBtn'), GlobalVariable.TimeOut)
}
catch (Exception ex) {
} 

Mobile.setText(findTestObject('Welcome and Login Page Objects/Login Page/User_Name'), GlobalVariable.MobileNumber, GlobalVariable.TimeOut)

Mobile.hideKeyboard()

Mobile.setText(findTestObject('Welcome and Login Page Objects/Login Page/M-pin'), GlobalVariable.MPin, 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Login_BTN'), 0)

//String ActiveCode = CustomKeywords.'db_operations.LoginDBOperations.returnActivationCode'(GlobalVariable.MobileNumber)
String ActiveCode = '69736'

Mobile.setText(findTestObject('Welcome and Login Page Objects/Login Page/Activation_Code_Field'), ActiveCode, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/OK-BTN_Activation-Code'), GlobalVariable.TimeOut)

Mobile.waitForElementPresent(findTestObject('Welcome and Login Page Objects/Login Page/ok_activation_code'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/ok_activation_code'), GlobalVariable.TimeOut)

//Mobile.delay(30, FailureHandling.CONTINUE_ON_FAILURE)

try {
	Mobile.waitForElementPresent(findTestObject('Welcome and Login Page Objects/Login Page/Cancel-Version-BTN'), 5)
	Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Cancel-Version-BTN'), 5)
}
catch (Exception ex) {
}

//Mobile.delay(30, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.waitForElementPresent(findTestObject('Close-Reciept/ok-Btn'), 5)

//Mobile.waitForElementPresent(findTestObject('Welcome and Login Page Objects/Login Page/Cancel-Version-BTN'), GlobalVariable.TimeOut)
//Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/OK-BTN_Activation-Code'), GlobalVariable.TimeOut)
//Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Cancel-Version-BTN'), GlobalVariable.TimeOut)

//Mobile.verifyElementVisible(findTestObject('Close-Reciept/ok-Btn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Close-Reciept/ok-Btn'),  GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Close-Reciept/ok-Btn'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut, FailureHandling.CONTINUE_ON_FAILURE)

