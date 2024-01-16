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

WebUI.callTestCase(findTestCase('6-History/Making-Transaction(Vodafon Recharge)'), [('Phone') : '0120000200'], FailureHandling.STOP_ON_FAILURE)

//Mobile.tap(findTestObject('Close-Reciept/Done-Btn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/MyTransactions Icon'), 15)

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

//Mobile.verifyElementText(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FirstItemInTheLog'), TransactionN)
String actualText = Mobile.getText(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FirstItemInTheLog'), GlobalVariable.TimeOut)

Mobile.verifyMatch(actualText, TransactionN, true)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FirstItemInTheLog'), 5)

WebUI.callTestCase(findTestCase('Shared_Testcases/try to report issue with transaction with validations'), [('Email') : 'mtest@test.com'], 
    FailureHandling.STOP_ON_FAILURE)