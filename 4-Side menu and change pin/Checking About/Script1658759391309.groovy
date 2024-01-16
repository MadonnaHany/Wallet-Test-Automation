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
Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Side-Menu_Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Side Menu Page Objects/Side Menu Page/About Tab'), 0)

Mobile.tap(findTestObject('Side Menu Page Objects/About Page/AboutWalletApplicationTab'), 0)

String aboutWalletText = Mobile.getText(findTestObject('Object Repository/Side Menu Page Objects/About Page/AboutWalletAppText'), 
    GlobalVariable.TimeOut)

//assert !(aboutWalletText.isEmpty()) == true
Mobile.verifyEqual(!(aboutWalletText.isEmpty()), true, FailureHandling.CONTINUE_ON_FAILURE)

//assert aboutWalletText.contains('bills') == true
'Validate the about is shown as English'
Mobile.verifyEqual(aboutWalletText.contains('bills'), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Side Menu Page Objects/About Page/BackBtn'), 0)

'Validate the terms and conditions is there not empty '
Mobile.tap(findTestObject('Side Menu Page Objects/About Page/TermsAndConditionTab'), GlobalVariable.TimeOut)

String TermsAndConditionText = Mobile.getText(findTestObject('Side Menu Page Objects/About Page/TermsAndConditionsText'), 
    15)

assert !(TermsAndConditionText.isEmpty()) == true

'Validate the about is shown as English'
Mobile.verifyEqual((TermsAndConditionText.contains('Conditions')), true)

Mobile.tap(findTestObject('Side Menu Page Objects/About Page/BackBtn'), 0)

Mobile.tap(findTestObject('Side Menu Page Objects/About Page/AboutThisAppTab'), 5)

Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/About Page/AppDeffText'), 5)

Mobile.tap(findTestObject('Side Menu Page Objects/About Page/BackBtn'), 0)

Mobile.tap(findTestObject('Side Menu Page Objects/About Page/Rate UsonGoogle PlayTab'), 5)

Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/About Page/PopUpMsg'), 5)

Mobile.tap(findTestObject('Side Menu Page Objects/About Page/PopUpCancelBtn'), 0)

Mobile.tap(findTestObject('Side Menu Page Objects/About Page/Rate UsonFaceBookTab'), 0)

Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/About Page/PopUpMsg'), 5)

Mobile.tap(findTestObject('Side Menu Page Objects/About Page/PopUpCancelBtn'), 0)

Mobile.tap(findTestObject('Side Menu Page Objects/About Page/BackBtn'), 0)

Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Home-Icon'), 5)

