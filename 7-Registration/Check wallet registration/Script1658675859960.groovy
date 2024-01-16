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

Mobile.delay(30, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.hideKeyboard()

CustomKeywords.'customkeywords.Keywords.ScrollDown'()

Mobile.tap(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.TextView - check wallet registration'), 
    0)

Mobile.delay(5, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.setText(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.EditText'), 
    registeredmobnumber, 5)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.Button - Check'), 
    0)

Mobile.setText(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.EditText (1)'), 
    '1', GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.EditText (2)'), 
    '2', 0)

Mobile.setText(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.EditText (3)'), 
    '3', 0)

Mobile.setText(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.EditText (4)'), 
    '4', 0)

Mobile.setText(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.EditText (5)'), 
    '5', 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.Button - Continue'), 
    50)

String actualtext = Mobile.getText(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.TextView - Mobile Number already has a wallet in NBE'), 
    GlobalVariable.TimeOut)

Mobile.verifyEqual(actualtext.contains(ExpectedText), true, FailureHandling.CONTINUE_ON_FAILURE)

/*Mobile.verifyElementText(findTestObject('Registration Page Objects/Registration Objects/android.widget.TextView - Mobile Number already has a wallet in NBE'), 
    ExpectedText)
*/
Mobile.tap(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.Button - Cancel'), 
    0)

Mobile.delay(20, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'customkeywords.Keywords.ScrollDown'()

Mobile.tap(findTestObject('Registration Page Objects/Registration Objects/android.widget.TextView - check wallet registration (1)'), 
    0)

Mobile.setText(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.EditText (6)'), 
    unregisterdmobnumber, 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.Button - Check (1)'), 
    0)

try {
    Mobile.setText(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.EditText (7)'), 
        '1', 20)
}
catch (Exception ex) {
    Mobile.tap(findTestObject('Object Repository/Registration Page Objects/Registration Objects/Error-Ok-Btn'), 20)

    Mobile.delay(35)

    Mobile.tap(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.Button - Check (1)'), 
        20)
} 

Mobile.setText(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.EditText (7)'), 
    '1', 10)

Mobile.setText(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.EditText (8)'), 
    '2', 10)

Mobile.setText(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.EditText (9)'), 
    '3', 10)

Mobile.setText(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.EditText (10)'), 
    '4', 10)

Mobile.setText(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.EditText (11)'), 
    '5', 10)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/Registration Page Objects/Registration Objects/android.widget.Button - Continue (1)'), 
    5)

String walletStatus = Mobile.getText(findTestObject('Object Repository/Registration Page Objects/Registration Objects/Title-Status'), 
    GlobalVariable.TimeOut)

assert walletStatus.contains(NoWalletRegister) == true

Mobile.tap(findTestObject('Registration Page Objects/Registration Objects/android.widget.Button - Cancel'), 10)

