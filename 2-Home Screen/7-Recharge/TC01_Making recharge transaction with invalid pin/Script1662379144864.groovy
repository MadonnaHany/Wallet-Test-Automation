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
import com.kms.katalon.core.testobject.MobileTestObject as MobileTestObject

//WebUI.callTestCase(findTestCase('1-Login and Forget Pin/TC01-Login with valid mobile number and valid pin'), [('mobilenumber') : GlobalVariable.MobileNumber
//     , ('MPin') : GlobalVariable.MPin, ('ActivationCode') : '69736', ('mobilenumber_DB') : '201089478965'], FailureHandling.STOP_ON_FAILURE)

'Select the Service Name'
MobileTestObject el

boolean elementfound

int count = 5

while (count >= 0) {
    el = findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Recharge/Service-Name')

    elementfound = CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameIDThenClick'(el, Service_Name)

    if (elementfound) {
        break
    } else {
        count--

        Mobile.swipe(743, 529, 41, 529)
    }
}

//Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut)
//Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/TelecomAndInternetTab'), GlobalVariable.TimeOut)
'Select the Service Type'
int count_2 = 5

while (count_2 >= 0) {
    el = findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Recharge/Service-Type')

    elementfound = CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameIDThenClick'(el, Service_Type)

    if (elementfound) {
        break
    } else {
        count_2--

        CustomKeywords.'customkeywords.Keywords.ScrollDown'()
    }
}

'Select Provider Name'
int count_3 = 5

while (count_3 >= 0) {
    el = findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Recharge/Provider_Name')

    elementfound = CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameIDThenClick'(el, Provider_Name)

    if (elementfound) {
        break
    } else {
        count_3--

        CustomKeywords.'customkeywords.Keywords.ScrollDown'()
    }
}

int count_4 = 5

while (count_4 >= 0) {
    el = findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Recharge/Provider_Service_Type')

    elementfound = CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameIDThenClick'(el, Provider_Service_Type)

    if (elementfound) {
        break
    } else {
        count_4--

        CustomKeywords.'customkeywords.Keywords.ScrollDown'()
    }
}

//Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneTab'), 5)
//Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneRechrgeTab'), 0)
Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), Phone, 5)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/android.widget.EditText (1)'), Phone, 0)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), 0)

//
int count_5 = 5

while (count_5 >= 0) {
    el = findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Recharge/Amount_Slap')

    elementfound = CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameIDThenClick'(el, Recharge_Amount)

    if (elementfound) {
        break
    } else {
        count_5--

        CustomKeywords.'customkeywords.Keywords.ScrollDown'()
    }
}

//Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/SlabTab'), 0)
Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), 0)

//'entering valid M-Pin'
//WebUI.callTestCase(findTestCase('Shared_Testcases/try to make with in valid M-Pin'), [('InvalidPin') : '123456', ('TransactionStatus') : ''
//        , ('InvalidMpinError') : 'invalid M-PIN'], FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/M-Pin'), InvalidPin, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/M-Pin-OkBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Skip-Rating'), GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/Reciept-Status'),GlobalVariable.TimeOut)

Mobile.verifyEqual(TransactionStatus.contains(InvalidMpinError), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Purchase Page Objects/ClosePurchaseReciept'), GlobalVariable.TimeOut)

