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

Mobile.tap(findTestObject('Side Menu Page Objects/Side Menu Page/Profile Tab'), 0)

Mobile.tap(findTestObject('Side Menu Page Objects/Profile Page/ProfilePicture'), 0)

Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Profile Page/TakePhotoOption'), 5)

Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Profile Page/ChoosePhotosOption'), 5)

Mobile.pressBack()

Mobile.tap(findTestObject('Side Menu Page Objects/Profile Page/EditIcon'), 5)

Mobile.clearText(findTestObject('Side Menu Page Objects/Profile Page/FullNameTextField'), 5, FailureHandling.STOP_ON_FAILURE)

try {
	Mobile.delay(10, FailureHandling.CONTINUE_ON_FAILURE)
	Mobile.tap(findTestObject('Side Menu Page Objects/Profile Page/ConfirmIcon'), 10, FailureHandling.CONTINUE_ON_FAILURE)
}
catch (Exception ex) {
	Mobile.tap(findTestObject('Side Menu Page Objects/Profile Page/ConfirmIcon1'), 10)
		
}

//Mobile.tap(findTestObject('Side Menu Page Objects/Profile Page/ConfirmIcon'), 10)

Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Profile Page/Error Msg'), 5)

Mobile.setText(findTestObject('Side Menu Page Objects/Profile Page/FullNameTextField'), FullName, 5)

Mobile.verifyElementAttributeValue(findTestObject('Side Menu Page Objects/Profile Page/mobileNumber'), 'enabled', 'false', 
    5)

try {
	Mobile.delay(10, FailureHandling.CONTINUE_ON_FAILURE)
	Mobile.tap(findTestObject('Side Menu Page Objects/Profile Page/ConfirmIcon'), 10, FailureHandling.CONTINUE_ON_FAILURE)
}
catch (Exception ex) {
	Mobile.tap(findTestObject('Side Menu Page Objects/Profile Page/ConfirmIcon1'), 10)
		
}
//Mobile.tap(findTestObject('Side Menu Page Objects/Profile Page/ConfirmIcon'), 5)

Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Profile Page/EditConfirmMsg'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Side Menu Page Objects/Profile Page/EditConfirmOKBtn'), 0)

String fullnamedisplayed = Mobile.getText(findTestObject('Object Repository/Side Menu Page Objects/Profile Page/DisplayedFullNameTxt'), 
    GlobalVariable.TimeOut)

//assert !(aboutWalletText.isEmpty()) == true
Mobile.verifyEqual(!(fullnamedisplayed.isEmpty()), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.verifyEqual(fullnamedisplayed.contains(FullName), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Side Menu Page Objects/Profile Page/EditIcon'), 5)

Mobile.clearText(findTestObject('Side Menu Page Objects/Profile Page/FullNameTextField'), 0)

try {
	Mobile.delay(10, FailureHandling.CONTINUE_ON_FAILURE)
	Mobile.tap(findTestObject('Side Menu Page Objects/Profile Page/CancelIcon'), 10, FailureHandling.CONTINUE_ON_FAILURE)
}
catch (Exception ex) {
	Mobile.tap(findTestObject('Side Menu Page Objects/Profile Page/CancelIcon1'), 10)
		
}
//Mobile.tap(findTestObject('Side Menu Page Objects/Profile Page/CancelIcon'), 5)

Mobile.verifyEqual(!(fullnamedisplayed.isEmpty()), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.verifyEqual(fullnamedisplayed.contains(FullName), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Side Menu Page Objects/Profile Page/BackBtn'), 0)

Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Home-Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Side-Menu_Icon'), 0)