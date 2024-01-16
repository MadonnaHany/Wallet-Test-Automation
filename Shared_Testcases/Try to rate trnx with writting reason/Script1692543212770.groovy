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

'Validate that transaction is not rate after skipping'

Mobile.delay(3)

CustomKeywords.'customkeywords.Keywords.ScrollDown'()

Mobile.scrollToText('Not Rated', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Shared Test Cases Objects/Payment Reciept Rating Page Objects/RateStatusField'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Shared Test Cases Objects/Payment Reciept Rating Page Objects/SimpleRating'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/RateUs Page Objects/SkipBtn'), 0)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/RateUs Page Objects/Not-Rating-Element'), GlobalVariable.TimeOut,
	FailureHandling.CONTINUE_ON_FAILURE)

'Validate on rating transaction'
Mobile.tap(findTestObject('Shared Test Cases Objects/Payment Reciept Rating Page Objects/RateStatusField'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Shared Test Cases Objects/Payment Reciept Rating Page Objects/SimpleRating'), GlobalVariable.TimeOut)

CustomKeywords.'customkeywords.Keywords.ScrollDown'()

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Shared Test Cases Objects/Payment Reciept Rating Page Objects/last option in rating'), GlobalVariable.TimeOut)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'customkeywords.Keywords.ScrollDown'()

continueBtnEnabled=Mobile.getAttribute(findTestObject('Shared Test Cases Objects/Payment Reciept Rating Page Objects/Submit-Rating-Btn'), 'enabled', 10)

//KeywordUtil.logInfo('continueBtnEnabled is : ' + continueBtnEnabled)

Mobile.verifyEqual(continueBtnEnabled,'false',FailureHandling.CONTINUE_ON_FAILURE)


Mobile.setText(findTestObject('Shared Test Cases Objects/Payment Reciept Rating Page Objects/Type Your Comment'), RateComment, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Shared Test Cases Objects/Payment Reciept Rating Page Objects/Submit-Rating-Btn'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Shared Test Cases Objects/Payment Reciept Rating Page Objects/CloseRate'), GlobalVariable.TimeOut)


Mobile.verifyElementVisible(findTestObject('Shared Test Cases Objects/Payment Reciept Rating Page Objects/CloseRate'), GlobalVariable.TimeOut)

rateMsg = Mobile.getText(findTestObject('Shared Test Cases Objects/Payment Reciept Rating Page Objects/RatingMsg'), GlobalVariable.TimeOut)

Mobile.verifyEqual(rateMsg.contains(expectedMsg), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Shared Test Cases Objects/Payment Reciept Rating Page Objects/CloseRate'), 0)


