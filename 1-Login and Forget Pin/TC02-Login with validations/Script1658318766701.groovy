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

try {
    Mobile.delay(10)

    Mobile.tap(findTestObject('Welcome and Login Page Objects/Welcome Page/SkipBtn'), GlobalVariable.TimeOut)
}
catch (Exception ex) {
} 

Mobile.delay(25, FailureHandling.STOP_ON_FAILURE)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Login_BTN'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Welcome and Login Page Objects/Login Page/MobileNoErrorMsg'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Welcome and Login Page Objects/Login Page/PINErrorMsg'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Welcome and Login Page Objects/Login Page/User_Name'), ValidUserName, 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Login_BTN'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Welcome and Login Page Objects/Login Page/PINErrorMsg'), GlobalVariable.TimeOut)

Mobile.clearText(findTestObject('Welcome and Login Page Objects/Login Page/User_Name'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Welcome and Login Page Objects/Login Page/M-pin'), ValidPin, 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Login_BTN'), 0)

Mobile.verifyElementVisible(findTestObject('Welcome and Login Page Objects/Login Page/MobileNoErrorMsg'), GlobalVariable.TimeOut)

Mobile.clearText(findTestObject('Welcome and Login Page Objects/Login Page/M-pin'), 0)

Mobile.setText(findTestObject('Welcome and Login Page Objects/Login Page/User_Name'), ValidUserName, 0)

Mobile.setText(findTestObject('Welcome and Login Page Objects/Login Page/M-pin'), InValidPin, 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Login_BTN'), 0)

String ActiveCode = CustomKeywords.'db_operations.LoginDBOperations.returnActivationCode'(mobilenumber_DB)

Mobile.setText(findTestObject('Welcome and Login Page Objects/Login Page/Activation_Code_Field'), ActiveCode, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/OK-BTN_Activation-Code'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/ok_activation_code'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Welcome and Login Page Objects/Login Page/ErrorMsg'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/ErrorMsgOkBtn'), 0)

Mobile.clearText(findTestObject('Welcome and Login Page Objects/Login Page/User_Name'), GlobalVariable.TimeOut)

'check pin eye to show and hide written pin'
Mobile.setText(findTestObject('Welcome and Login Page Objects/Login Page/M-pin'), GlobalVariable.MPin, 0)

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Eye-Icon'), 0)

Mobile.verifyElementText(findTestObject('Welcome and Login Page Objects/Login Page/M-pin'), GlobalVariable.MPin)

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Eye-Icon'), 0)

Mobile.verifyElementText(findTestObject('Welcome and Login Page Objects/Login Page/M-pin'), '••••••')

