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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Mobile.delay(3)

CustomKeywords.'customkeywords.Keywords.ScrollDown'()
Mobile.delay(7)
Mobile.scrollToText('Report Issue', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Report Issue Page Objects/ReportIssueTab'), GlobalVariable.TimeOut)

//old code
//try {
//	 Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Report Issue Page Objects/emailAutoFillList-Flds'), 5)
//	
//	Mobile.pressBack()
//} catch (Exception e) {
//	KeywordUtil.logInfo('Element is not visible')
//}
Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Report Issue Page Objects/TransactionNoText'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Report Issue Page Objects/TransactionType'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Report Issue Page Objects/TransactionDate'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Report Issue Page Objects/EmailTextBox'), GlobalVariable.TimeOut)

Mobile.delay(20, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.setText(findTestObject('Recharge Page Objects/Report Issue Page Objects/EmailTextBox'), Email, 10)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Recharge Page Objects/Report Issue Page Objects/IssueTypeList'), 10)

Mobile.tap(findTestObject('Recharge Page Objects/Report Issue Page Objects/TypeListOption'), 0)

Mobile.delay(20, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.setText(findTestObject('Recharge Page Objects/Report Issue Page Objects/ShareWithUsTextBox'), 'there is issue', GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Report Issue Page Objects/ConfirmBtn'), GlobalVariable.TimeOut)

//Mobile.delay(50, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Report Issue Page Objects/ConfirmationMsg'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Report Issue Page Objects/ClosePopUpBtn'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Report Issue Page Objects/ReportIssueTab'), GlobalVariable.TimeOut)

'try to report issue about any transaction more than one time '
/*Mobile.tap(findTestObject('Recharge Page Objects/Report Issue Page Objects/ReportIssueTab'), GlobalVariable.TimeOut)

//old code
//try {
//	Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Report Issue Page Objects/emailAutoFillList-Flds'), 5)
//	
//	Mobile.pressBack()
//} catch (Exception e) {
//	KeywordUtil.logInfo('Element is not visible')
//}
Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Report Issue Page Objects/EmailTextBox'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Report Issue Page Objects/EmailTextBox'), Email, 10)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Recharge Page Objects/Report Issue Page Objects/IssueTypeList'), 0)

Mobile.tap(findTestObject('Recharge Page Objects/Report Issue Page Objects/TypeListOption'), 0)

Mobile.setText(findTestObject('Recharge Page Objects/Report Issue Page Objects/ShareWithUsTextBox'), 'there is issue', 10)

Mobile.tap(findTestObject('Recharge Page Objects/Report Issue Page Objects/ConfirmBtn'), 0)

Mobile.delay(60, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Report Issue Page Objects/ConfirmationMsg'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Report Issue Page Objects/ClosePopUpBtn'), 0)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Report Issue Page Objects/ReportIssueTab'), GlobalVariable.TimeOut)
*/
try {
    Mobile.tap(findTestObject('Close-Reciept/android.widget.Button - Done'), GlobalVariable.TimeOut)
}
catch (Exception ex) {
} 

