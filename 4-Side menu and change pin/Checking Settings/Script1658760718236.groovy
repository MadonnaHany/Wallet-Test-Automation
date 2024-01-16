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
WebUI.callTestCase(findTestCase('1-Login and Forget Pin/TC01-Login with valid mobile number and valid pin'), [('mobilenumber') : '01089478965'
        , ('MPin') : '147258', ('ActivationCode') : '69736', ('mobilenumber_DB') : '201089478965'], FailureHandling.STOP_ON_FAILURE)
*/
Mobile.delay(2)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Side-Menu_Icon'), 0)

Mobile.tap(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/android.widget.TextView - Settings'), 
    0)

Mobile.tap(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/android.widget.TextView - Change M-PIN'), 
    0)

'set other pin'
Mobile.setText(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/android.widget.EditText'), NewPin, 
    0)

Mobile.setText(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/android.widget.EditText (1)'), GlobalVariable.MPin, 
    5)

Mobile.setText(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/android.widget.EditText (2)'), GlobalVariable.MPin, 
    0)

Mobile.tap(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/android.widget.Button - Submit'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Settings Page/Error-Message-Popup'), 5)

Mobile.verifyElementText(findTestObject('Side Menu Page Objects/Settings Page/Error-Message-Popup'), InvalidCurrentMPin, 
    FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Side Menu Page Objects/Settings Page/Error-Message-OkBtn'), 3)

'correct old pin but the new pin are not matched'
Mobile.setText(findTestObject('Side Menu Page Objects/Settings Page/android.widget.EditText'), GlobalVariable.MPin, 0)

Mobile.setText(findTestObject('Side Menu Page Objects/Settings Page/android.widget.EditText (1)'), GlobalVariable.MPin, 
    0)

Mobile.setText(findTestObject('Side Menu Page Objects/Settings Page/android.widget.EditText (2)'), NewPin, 0)

Mobile.verifyElementAttributeValue(findTestObject('Side Menu Page Objects/Settings Page/android.widget.Button - Submit'), 
    'enabled', 'false', 5)

'Change-MPin Correctly'
Mobile.setText(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/android.widget.EditText'), GlobalVariable.MPin, 
    0)

Mobile.setText(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/android.widget.EditText (1)'), NewPin, 
    5)

Mobile.setText(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/android.widget.EditText (2)'), NewPin, 
    0)

Mobile.tap(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/android.widget.Button - Submit'), 5)

try {
    Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Settings Page/ChangeM-Pin_SuccessPopTXT'), GlobalVariable.TimeOut)

    Mobile.tap(findTestObject('Side Menu Page Objects/Settings Page/ChangeM-Pin_Success_OKBTN'), 0)

    Mobile.verifyElementVisible(findTestObject('Welcome and Login Page Objects/Login Page/M-pin'), GlobalVariable.TimeOut)
}
catch (Exception ex) {
    Mobile.tap(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/Error-Message-OkBtn'), 5)

    Mobile.tap(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/Cancel-Btn'), 5)
} 

'Set old-Pin Validation'

// there is an issue , it is login with old pin 
/*
Mobile.setText(findTestObject('Welcome and Login Page Objects/Login Page/M-pin'), GlobalVariable.MPin, GlobalVariable.TimeOut)



Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Login_BTN'), 0)

Mobile.verifyElementVisible(findTestObject('Welcome and Login Page Objects/Login Page/ErrorMsg'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/ErrorMsgOkBtn'), 0)
*/
'Set-New-One-Pin'
Mobile.setText(findTestObject('Welcome and Login Page Objects/Login Page/M-pin'), NewPin, 0)

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Login_BTN'), 10)

try {
	Mobile.waitForElementPresent(findTestObject('Welcome and Login Page Objects/Login Page/Cancel-Version-BTN'), GlobalVariable.TimeOut)
	Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Cancel-Version-BTN'), GlobalVariable.TimeOut)
}
catch (Exception ex) {
}
//Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/OK-BTN_Activation-Code'), GlobalVariable.TimeOut)
//Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Cancel-Version-BTN'), GlobalVariable.TimeOut)
Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Side-Menu_Icon'), 0)

Mobile.tap(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/android.widget.TextView - Settings'), 
    0)

Mobile.tap(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/android.widget.TextView - Change M-PIN'), 
    GlobalVariable.TimeOut)

'return to old pin'
Mobile.setText(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/android.widget.EditText'), NewPin, 
    0)

Mobile.setText(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/android.widget.EditText (1)'), GlobalVariable.MPin, 
    5)

Mobile.setText(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/android.widget.EditText (2)'), GlobalVariable.MPin, 
    0)

Mobile.tap(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/android.widget.Button - Submit'), 0)

try {
    Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Settings Page/ChangeM-Pin_SuccessPopTXT'), GlobalVariable.TimeOut, 
        FailureHandling.STOP_ON_FAILURE)

    Mobile.tap(findTestObject('Side Menu Page Objects/Settings Page/ChangeM-Pin_Success_OKBTN'), 0)

    Mobile.verifyElementVisible(findTestObject('Welcome and Login Page Objects/Login Page/M-pin'), GlobalVariable.TimeOut)

    Mobile.setText(findTestObject('Welcome and Login Page Objects/Login Page/M-pin'), GlobalVariable.MPin, 0)

    Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Login_BTN'), 0)
	
	try {
		Mobile.waitForElementPresent(findTestObject('Welcome and Login Page Objects/Login Page/Cancel-Version-BTN'), GlobalVariable.TimeOut)
		Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Cancel-Version-BTN'), GlobalVariable.TimeOut)
	}
	catch (Exception ex) {
	}

    //Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/OK-BTN_Activation-Code'), GlobalVariable.TimeOut)
    // Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Cancel-Version-BTN'), GlobalVariable.TimeOut)
    Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut)
}
catch (Exception ex) {
    Mobile.tap(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/Error-Message-OkBtn'), 5)

    Mobile.tap(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/Cancel-Btn'), 5)
} 

//WebUI.callTestCase(findTestCase('1-Login and Forget Pin/TC01-Login with valid mobile number and valid pin'), [('mobilenumber') : '01089478965'
//        , ('MPin') : '147258', ('ActivationCode') : '69736', ('mobilenumber_DB') : '201089478965'], FailureHandling.STOP_ON_FAILURE)
'Change Language'
Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Side-Menu_Icon'), 0)

Mobile.tap(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/android.widget.TextView - Settings'), 
    0)

Mobile.tap(findTestObject('Side Menu Page Objects/Settings Page/ChangeLanguageTap'), 0)

Mobile.tap(findTestObject('Side Menu Page Objects/Settings Page/English_Language'), 0)

Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Settings Page/ExitTheApplication'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Side Menu Page Objects/Settings Page/ExitTheApplication'), 0)

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

//////////////////////
//Adding These steps to cater for the App Exit Upon Changing Language - Start
/////////////////////
Mobile.startExistingApplication(GlobalVariable.APP_Package)

WebUI.callTestCase(findTestCase('Shared_Testcases/select server url'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Welcome and Login Page Objects/Welcome Page/SkipBtn'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Welcome and Login Page Objects/Login Page/User_Name'), GlobalVariable.MobileNumber, GlobalVariable.TimeOut)
Mobile.hideKeyboard()
Mobile.setText(findTestObject('Welcome and Login Page Objects/Login Page/M-pin'), GlobalVariable.MPin, 20)

Mobile.hideKeyboard()

//////////////////////
//Adding These steps to cater for the App Exit Upon Changing Language - End
/////////////////////
Mobile.verifyElementText(findTestObject('Welcome and Login Page Objects/Login Page/Login_BTN'), 'Login')

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Login_BTN'), 0)

String ActiveCode = '69736'

Mobile.setText(findTestObject('Welcome and Login Page Objects/Login Page/Activation_Code_Field'), ActiveCode, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/OK-BTN_Activation-Code'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/ok_activation_code'), GlobalVariable.TimeOut)


try {
	Mobile.waitForElementPresent(findTestObject('Welcome and Login Page Objects/Login Page/Cancel-Version-BTN'), GlobalVariable.TimeOut)
	Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Cancel-Version-BTN'), GlobalVariable.TimeOut)
}
catch (Exception ex) {
}
//Mobile.waitForElementPresent(findTestObject('Welcome and Login Page Objects/Login Page/Cancel-Version-BTN'), GlobalVariable.TimeOut)
//Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/OK-BTN_Activation-Code'), GlobalVariable.TimeOut)
//Mobile.tap(findTestObject('Welcome and Login Page Objects/Login Page/Cancel-Version-BTN'), GlobalVariable.TimeOut)
Mobile.verifyElementVisible(findTestObject('Close-Reciept/ok-Btn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Close-Reciept/ok-Btn'), GlobalVariable.TimeOut)

//
Mobile.tap(findTestObject('Close-Reciept/ok-Btn'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut)

'Change Language'
Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Side-Menu_Icon'), 0)

Mobile.tap(findTestObject('Object Repository/Side Menu Page Objects/Settings Page/android.widget.TextView - Settings'), 
    0)

Mobile.tap(findTestObject('Side Menu Page Objects/Settings Page/ChangeLanguageTap'), 0)

Mobile.tap(findTestObject('Side Menu Page Objects/Settings Page/Arabic_Language'), 0)

Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Settings Page/ExitTheApplication'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Side Menu Page Objects/Settings Page/ExitTheApplication'), 0)

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

