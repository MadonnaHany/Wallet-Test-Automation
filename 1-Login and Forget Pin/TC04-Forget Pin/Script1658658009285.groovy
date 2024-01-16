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
    Mobile.tap(findTestObject('Welcome and Login Page Objects/Welcome Page/SkipBtn'), GlobalVariable.TimeOut)
}
catch (Exception ex) {
} 

Mobile.delay(7)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/ForgotPasswordBtn'), GlobalVariable.TimeOut)

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Welcome and Login Page Objects/Forget Pin Page/UsernameTxtField'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Welcome and Login Page Objects/Forget Pin Page/CancelBtn'), GlobalVariable.TimeOut)

Mobile.delay(7, FailureHandling.STOP_ON_FAILURE)

Mobile.hideKeyboard()

Mobile.verifyElementVisible(findTestObject('Welcome and Login Page Objects/Login Page/Login_BTN'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/ForgotPasswordBtn'), 0)

Mobile.delay(5, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.setText(findTestObject('Welcome and Login Page Objects/Forget Pin Page/UsernameTxtField'), mobilenumber, GlobalVariable.TimeOut)

Mobile.delay(7, FailureHandling.STOP_ON_FAILURE)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Welcome and Login Page Objects/Forget Pin Page/NextBtn'), 0)

Mobile.tap(findTestObject('Welcome and Login Page Objects/Forget Pin Page/ResendCodeBtn'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Welcome and Login Page Objects/Forget Pin Page/Resend Message Text'), GlobalVariable.TimeOut)

String actualText = Mobile.getText(findTestObject('Welcome and Login Page Objects/Forget Pin Page/Resend Message Text'), GlobalVariable.TimeOut)

Mobile.verifyEqual(actualText.contains(ResendVerificationmsg),true, FailureHandling.CONTINUE_ON_FAILURE)

//Mobile.verifyElementText(findTestObject('Welcome and Login Page Objects/Forget Pin Page/Resend Message Text'), ResendVerificationmsg)

Mobile.tap(findTestObject('Welcome and Login Page Objects/Forget Pin Page/Resend Message OKBtn'), 0)

Mobile.setText(findTestObject('Welcome and Login Page Objects/Forget Pin Page/Code_Digit_1'), '1', 0)

Mobile.setText(findTestObject('Welcome and Login Page Objects/Forget Pin Page/Code_Digit_2'), '1', 0)

Mobile.setText(findTestObject('Welcome and Login Page Objects/Forget Pin Page/Code_Digit_3'), '1', 0)

Mobile.setText(findTestObject('Welcome and Login Page Objects/Forget Pin Page/Code_Digit_4'), '1', 0)

Mobile.setText(findTestObject('Welcome and Login Page Objects/Forget Pin Page/Code_Digit_5'), '1', 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Welcome and Login Page Objects/Forget Pin Page/ContinueBtn'), 0)

Mobile.setText(findTestObject('Welcome and Login Page Objects/Forget Pin Page/NewPinTextField'), NewPin, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Welcome and Login Page Objects/Forget Pin Page/NewPinReEnterTextField'), NewPin, 0)

Mobile.hideKeyboard()

