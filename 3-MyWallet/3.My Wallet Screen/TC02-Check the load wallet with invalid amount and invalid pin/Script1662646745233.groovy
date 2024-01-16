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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

/*
WebUI.callTestCase(findTestCase('1-Login and Forget Pin/TC01-Login with valid mobile number and valid pin'), [('mobilenumber') : '01089478965'
        , ('MPin') : '147258', ('ActivationCode') : '69736', ('mobilenumber_DB') : '201089478965'], FailureHandling.STOP_ON_FAILURE)

*/

CustomKeywords.'customkeywords.Keywords.ScrollUp'()

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/MyWalletIcon'), GlobalVariable.TimeOut)

CustomKeywords.'customkeywords.Keywords.ScrollUp'()

CustomKeywords.'customkeywords.Keywords.ScrollUp'()

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/MyWalletAccount'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load-Wallet Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load Wallet Page Objects/Select-Payment-Method'), 
    0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load Wallet Page Objects/Payment-Method-Type'), 
    0)

'Validate the zero amount'
Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load Wallet Page Objects/Amount-Field'), 
    zero_Amount, 0)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load Wallet Page Objects/Invalid-Amount'), 
    10, FailureHandling.CONTINUE_ON_FAILURE)

'Validate the fraction amount'
Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load Wallet Page Objects/Amount-Field'), 
    Fraction_Amount, 0)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load Wallet Page Objects/Invalid-Amount'), 
    10, FailureHandling.CONTINUE_ON_FAILURE)

'put the valid amount'
Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load Wallet Page Objects/Amount-Field'), 
    Valid_Amount, 0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load Wallet Page Objects/ContinueBtn'), 
    0)

'Check Load Confirmation Account is Visible'
Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load Wallet Page Objects/Account-confirmation'), 
    GlobalVariable.TimeOut, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load Wallet Page Objects/ConfirmationBtn'), 
    0)

WebUI.callTestCase(findTestCase('Shared_Testcases/try to make with in valid M-Pin'), [('InvalidPin') : '123456', ('TransactionStatus') : ''
        , ('InvalidMpinError') : 'invalid M-PIN'], FailureHandling.STOP_ON_FAILURE)

'Validate the load wallet transaction in load wallet statement'
Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Load Wallet Page Objects/Done-Btn'), 
    0)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Wallet-Statement Page Objects/wallet-statement type'), 
    GlobalVariable.TimeOut, FailureHandling.CONTINUE_ON_FAILURE)

int count_1 = 5

boolean elementfound = false

while (count_1 >= 0) {
    MobileTestObject el = findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Wallet-Statement Page Objects/wallet-statement type')

    //  elementfound = CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameIDThenClick'(el, Wallet_Transaction_Statement)
    try {
        elementfound = CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameID'(el, Wallet_Transaction_Statement)

//        boolean noHistory = Mobile.verifyElementVisible(findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/EmptyList'), 
//            5, FailureHandling.CONTINUE_ON_FAILURE)

        if (elementfound) {
            break
        } else {
            count_1--

            CustomKeywords.'customkeywords.Keywords.ScrollDown'()

            continue
        }
    }
    catch (Exception e) {
    } 
}

if (elementfound == false) {
    KeywordUtil.markPassed(' the load wallet transaction is not in the list')
}