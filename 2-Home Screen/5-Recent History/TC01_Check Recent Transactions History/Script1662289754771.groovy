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

WebUI.callTestCase(findTestCase('6-History/Making-Transaction(Vodafon Recharge)'), [('Phone') : '0120000200', ('TransactionStatus') : 'Successful transaction'], 
    FailureHandling.STOP_ON_FAILURE)

while (true) {
    try {
        Mobile.verifyElementVisible(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Recent History Page Objects/Recent-History-Items'), 
            2)
		
		break
    }
    catch (Exception e) {
        CustomKeywords.'customkeywords.Keywords.ScrollDown'()
		
		continue
    } 
}

MobileTestObject historyItems = findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Recent History Page Objects/Recent-History-Items')

actualHistoryNumber = CustomKeywords.'customkeywords.Keywords.getElementsNumberByXPath_Mobile'(historyItems)

'check that last 5 transaction display'
Mobile.verifyLessThanOrEqual(actualHistoryNumber, ExpectedActualHistoryItems, FailureHandling.STOP_ON_FAILURE)

'Verify the Icon of transaction is displayed on recent history transaction'
CustomKeywords.'customkeywords.Keywords.ScrollDown'()

Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Recent History Page Objects/Transaction Icon'), GlobalVariable.TimeOut)

//Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

'click on the last transaction'
Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Recent History Page Objects/LastItemTransaction'), GlobalVariable.TimeOut)

'Validate The Payment Mobile Number'
Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Recent History Page Objects/PaymentRecieptAccountNumber'), 
    GlobalVariable.TimeOut)

'Check the rate'
WebUI.callTestCase(findTestCase('Shared_Testcases/Try to rate transaction with validations'), [:], FailureHandling.STOP_ON_FAILURE)

'check that return to home screen after closing rating popup'
Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Recent History Page Objects/LastItemTransaction'), 
    GlobalVariable.TimeOut)

Mobile.delay(15, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Recent History Page Objects/LastItemTransaction'), GlobalVariable.TimeOut)

Mobile.delay(3)

CustomKeywords.'customkeywords.Keywords.ScrollDown'()

'Validate the transaction is rated in payment receipt'
Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Recent History Page Objects/RateBar'), 5, 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Shared_Testcases/try to report issue with transaction with validations'), [('Email') : 'mtest@test.com'], 
    FailureHandling.STOP_ON_FAILURE)

