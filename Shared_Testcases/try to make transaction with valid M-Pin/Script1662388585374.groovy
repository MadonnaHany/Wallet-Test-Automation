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
import com.kms.katalon.core.webui.keyword.builtin.TakeAreaScreenshotKeyword as TakeAreaScreenshotKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Mobile.setText(findTestObject('Shared Test Cases Objects/Invalid M-PIN Page Objects/Cofirm-with-Pin'), Pin, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Shared Test Cases Objects/Invalid M-PIN Page Objects/MPIN-OK-BTN'), 0)

//Mobile.delay(50, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.waitForElementPresent(findTestObject('Shared Test Cases Objects/Invalid M-PIN Page Objects/RatePopUpSkipBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Shared Test Cases Objects/Invalid M-PIN Page Objects/RatePopUpSkipBtn'), GlobalVariable.TimeOut)

TransactionStatus = Mobile.getText(findTestObject('Shared Test Cases Objects/Invalid M-PIN Page Objects/Transaction_receipt_status'), 
    GlobalVariable.TimeOut)

System.out.print('Transaction status is : ' + TransactionStatus)

System.out.print('Expected status is : ' + ExpectedMessage)

//Mobile.verifyMatch(TransactionStatus , (ExpectedMessage) , true)
boolean actual = Mobile.verifyEqual(TransactionStatus.contains(ExpectedMessage) , true, FailureHandling.CONTINUE_ON_FAILURE)

if (actual == false) {
    Mobile.takeScreenshot('.\\Reports\\RecieptErrorStatus.png', FailureHandling.CONTINUE_ON_FAILURE)
}

try {
    Mobile.delay(8, FailureHandling.CONTINUE_ON_FAILURE)

    Mobile.tap(findTestObject('Close-Reciept/Done-Btn'), 10)
}
catch (Exception e) {
Mobile.pressBack()
Mobile.pressBack()
Mobile.pressBack()
} 

