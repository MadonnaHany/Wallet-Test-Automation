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

//Mobile.startExistingApplication(GlobalVariable.APP_Package)
//
//WebUI.callTestCase(findTestCase('1-Login and Forget Pin/TC01-Login with valid mobile number and valid pin'), [('mobilenumber') : '01089478965'
//        , ('MPin') : '147258', ('ActivationCode') : '69736', ('mobilenumber_DB') : '201089478965'], FailureHandling.STOP_ON_FAILURE)
'Select the Service Name'
MobileTestObject el

boolean elementfound

if (CaseType == 'Insufficient amount') {
    CustomKeywords.'db_operations.RechargeDBOperations.updateTheDailyLimit'(5000, GlobalVariable.MobileNumber)

    CustomKeywords.'db_operations.MyWalletDBOperations.updateTheAccountBalance'(0, GlobalVariable.MobileNumber)
} else if (CaseType == 'Exceeded daily limit') {
    CustomKeywords.'db_operations.RechargeDBOperations.updateTheDailyLimit'(0, GlobalVariable.MobileNumber)
} else if ((CaseType == 'Amount Deducted') || (CaseType == 'Invalid Mobile')) {
    CustomKeywords.'db_operations.RechargeDBOperations.updateTheDailyLimit'(5000, GlobalVariable.MobileNumber)

    CustomKeywords.'db_operations.MyWalletDBOperations.updateTheAccountBalance'(1000, GlobalVariable.MobileNumber)
}

double balanceamountbefore_recharge = CustomKeywords.'db_operations.MyWalletDBOperations.GetBalance'(GlobalVariable.MobileNumber)

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

'Select Provider Service Type'
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

//Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), Phone, 5)




Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), Phone, 5)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MobileNumberConfirmTextBox'), Phone, 0)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ConfirmBtn'), GlobalVariable.TimeOut)

WebUI.callTestCase(findTestCase('Shared_Testcases/try to make transaction with valid M-Pin'), [('TransactionStatus') : ''
        , ('ExpectedMessage') : Expected_Message], FailureHandling.CONTINUE_ON_FAILURE)

if (CaseType == 'Amount Deducted') {
    double balanceamountafter_recharge = CustomKeywords.'db_operations.MyWalletDBOperations.GetBalance'(GlobalVariable.MobileNumber)

    Mobile.verifyLessThan(balanceamountafter_recharge, balanceamountbefore_recharge)
} else {
    double balanceamountafter_recharge = CustomKeywords.'db_operations.MyWalletDBOperations.GetBalance'(GlobalVariable.MobileNumber)

    Mobile.verifyEqual(balanceamountafter_recharge, balanceamountbefore_recharge)
	
         if (CaseType == 'Exceeded daily limit') {
		CustomKeywords.'db_operations.RechargeDBOperations.updateTheDailyLimit'(3000, GlobalVariable.MobileNumber)}
}

CustomKeywords.'db_operations.RechargeDBOperations.updateTheDailyLimit'(5000, GlobalVariable.MobileNumber)

CustomKeywords.'db_operations.MyWalletDBOperations.updateTheAccountBalance'(5000, GlobalVariable.MobileNumber)

//Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), 0)

