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
Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Side-Menu_Icon'), 0)

Mobile.tap(findTestObject('Side Menu Page Objects/Side Menu Page/Share your opinion'), 5)

Mobile.tap(findTestObject('Side Menu Page Objects/Share Idea Page/IdeaSubmitButton'), 0)

Mobile.verifyElementAttributeValue(findTestObject('Side Menu Page Objects/Share Idea Page/IdeaSubmitButton'), 'enabled', 
    'true', 10, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Side Menu Page Objects/Share Idea Page/CategoryList'), 0)

Mobile.tap(findTestObject('Side Menu Page Objects/Share Idea Page/FirstCategoryOption'), 0)

Mobile.tap(findTestObject('Side Menu Page Objects/Share Idea Page/IdeaSubmitButton'), 0)

Mobile.verifyElementAttributeValue(findTestObject('Side Menu Page Objects/Share Idea Page/IdeaSubmitButton'), 'enabled', 
    'true', 10, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.setText(findTestObject('Side Menu Page Objects/Share Idea Page/TypeIdeaTextField'), ideaname, 6)

Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Side Menu Page Objects/Share Idea Page/IdeaSubmitButton'), 0)

Mobile.verifyElementAttributeValue(findTestObject('Side Menu Page Objects/Share Idea Page/IdeaSubmitButton'), 'enabled', 
    'true', 10, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.setText(findTestObject('Side Menu Page Objects/Share Idea Page/EmaIlTextField'), Email, 6)

Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Side Menu Page Objects/Share Idea Page/IdeaSubmitButton'), 3)

Mobile.delay(30, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Share Idea Page/ConfirmationMsg'), GlobalVariable.TimeOut)

Mobile.verifyElementText(findTestObject('Side Menu Page Objects/Share Idea Page/ConfirmationMsg'), SubmitMessage)

Mobile.tap(findTestObject('Side Menu Page Objects/Share Idea Page/ConfirmationMsgOkBtn'), 15)

Mobile.delay(15, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Home-Icon'), GlobalVariable.TimeOut)

