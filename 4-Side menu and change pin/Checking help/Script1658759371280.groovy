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
import com.kms.katalon.core.testobject.MobileTestObject as MobileTestObject
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
'Validate the contact us section in the help'
Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Side-Menu_Icon'), 0)

Mobile.tap(findTestObject('Side Menu Page Objects/Side Menu Page/Help Tab'), 0)

try {
    Mobile.delay(6, FailureHandling.STOP_ON_FAILURE)

    Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Help Page/Top-Questions-Sec'), 5, FailureHandling.CONTINUE_ON_FAILURE)

    /*'customkeywords.Keywords.selectSpecificElementFromWithinListWithScrollDown'(
		MobileTestObject elementsList
	 , 	String expectedText	,'By topic',FailureHandling.CONTINUE_ON_FAILURE)
*/
//    CustomKeywords.'customkeywords.Keywords.ScrollDown'()
//    Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Help Page/ByTopicTitle'), 12, FailureHandling.CONTINUE_ON_FAILURE)

    'Verify the top questions section'
    Mobile.tap(findTestObject('Side Menu Page Objects/Help Page/Top-Questions-Sec'), 0)

    Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Help Page/RateBar'), 0 //    Mobile.tap(findTestObject('Side Menu Page Objects/Help Page/RateBar'), 0)
        //    Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Help Page/RatingPopup'), GlobalVariable.TimeOut, FailureHandling.CONTINUE_ON_FAILURE)
        ) //    Mobile.tap(findTestObject('Side Menu Page Objects/Help Page/OK-Popup-Rating'), GlobalVariable.TimeOut)
    //	Mobile.tap(findTestObject('Side Menu Page Objects/Help Page/OK-Popup-Rating'), GlobalVariable.TimeOut)
    //	Mobile.tap(findTestObject('Side Menu Page Objects/Help Page/BackBtn'), GlobalVariable.TimeOut)
}
catch (Exception ex) {
    Mobile.tap(findTestObject('Side Menu Page Objects/Help Page/OK-Popup-Rating'), 0)
} 

Mobile.tap(findTestObject('Side Menu Page Objects/Help Page/BackBtn'), GlobalVariable.TimeOut)

while (true) {
	
	try {
	
	Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Help Page/ByTopicTitle'), 5)
	
	break
	
	}
	
	catch (Exception e) {
	
	CustomKeywords.'customkeywords.Keywords.ScrollDown'()
	
	continue
	
	}
	
	}

Mobile.tap(findTestObject('Side Menu Page Objects/Help Page/By-Topic-Sections'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Help Page/Top-Question'), 0, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Side Menu Page Objects/Help Page/Top-Question'), 0)

Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Help Page/Rated-Top-Question'), GlobalVariable.TimeOut, 
    FailureHandling.CONTINUE_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Help Page/PhoneTextBox'), GlobalVariable.TimeOut)

//Mobile.tap(findTestObject('Side Menu Page Objects/Help Page/PhoneTextBox'), 0)
//Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Help Page/dialPad'), 5)
Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Help Page/FaceBookIcon'), 5)

Mobile.verifyElementAttributeValue(findTestObject('Side Menu Page Objects/Help Page/FaceBookIcon'), 'enabled', 'true', 5, 
    FailureHandling.CONTINUE_ON_FAILURE)

/*Mobile.tap(findTestObject('Side Menu Page Objects/Help Page/FaceBookIcon'), 0)

Mobile.delay(7)


Mobile.switchToWebView()

String url = WebUI.getUrl()

WebUI.verifyEqual(url.contains('NBE'), true)
Mobile.pressBack()
Mobile.switchToNative()
*/
try {
Mobile.verifyElementVisible(findTestObject('Side Menu Page Objects/Help Page/TwitterIcon'), 5)

Mobile.verifyElementAttributeValue(findTestObject('Side Menu Page Objects/Help Page/TwitterIcon'), 'clickable', 'true', 
    5, FailureHandling.CONTINUE_ON_FAILURE)
}
catch (Exception e) {
}