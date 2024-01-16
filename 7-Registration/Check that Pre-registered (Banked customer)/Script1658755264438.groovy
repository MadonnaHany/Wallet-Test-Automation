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

Mobile.delay(20, FailureHandling.STOP_ON_FAILURE)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Registration Page Objects/Registration Objects/PessHereBtn'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Registration Page Objects/Registration Objects/MobileNumberTextField'), GlobalVariable.TimeOut)

UnregisterMobileNumber = ('010' + CustomKeywords.'customkeywords.Keywords.GenerateRandomMobNumber'(8))

Mobile.setText(findTestObject('Registration Page Objects/Registration Objects/MobileNumberTextField'), UnregisterMobileNumber, 
    0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Registration Page Objects/Registration Objects/ContinueBtn'), 0)

Mobile.setText(findTestObject('Registration Page Objects/Registration Objects/ActivationCodeTXT'), ActivationCode, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Registration Page Objects/Registration Objects/ContinueBtn'), 2)

Mobile.setText(findTestObject('Registration Page Objects/Registration Objects/First_Name'), FirstName, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Registration Page Objects/Registration Objects/Last_Name'), LastName, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Registration Page Objects/Registration Objects/NationalIdTextField'), NationalID, GlobalVariable.TimeOut)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Registration Page Objects/Registration Objects/AgreeCheckBox'), 0)

Mobile.tap(findTestObject('Registration Page Objects/Registration Objects/ContinueBtn'), 7)

Mobile.setText(findTestObject('Registration Page Objects/Registration Objects/Card_Number-Field'), Card_Number, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Registration Page Objects/Registration Objects/CardExpiryDate-Field'), Card_Expiry, 0)

Mobile.setText(findTestObject('Registration Page Objects/Registration Objects/CardCVV-Field'), Card_CVV, 0)

Mobile.setText(findTestObject('Registration Page Objects/Registration Objects/Card-Eliase-Field'), Card_Eliase, 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Registration Page Objects/Registration Objects/ContinueBtn'), 7)

//Mobile.tap(findTestObject('Registration Page Objects/Registration Objects/android.widget.Button - Cancel'), 5)

//Mobile.tap(findTestObject('Registration Page Objects/Registration Objects/Error-Ok-Btn'), 5)

Mobile.setText(findTestObject('Registration Page Objects/Registration Objects/MPin-Field'), GlobalVariable.MPin, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Registration Page Objects/Registration Objects/Re-Entering-MPIN'), GlobalVariable.MPin, 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Registration Page Objects/Registration Objects/Continue-To-Login'), GlobalVariable.TimeOut)

//Mobile.hideKeyboard()

//Mobile.waitForElementPresent(findTestObject('Welcome and Login Page Objects/Login Page/Login_BTN'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Welcome and Login Page Objects/Login Page/Login_BTN'), GlobalVariable.TimeOut)

