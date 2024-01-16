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
CustomKeywords.'customkeywords.Keywords.selectSpecificElementFromWithinList'(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/btcsList-Fld'), 'Cash out OTP')

//verify redirect to correct screen

Mobile.verifyElementVisible(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/cashout otp description'),GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/android.widget.Button - Get OTP'), GlobalVariable.TimeOut)
//verify popup is displyed to enter amount

Mobile.verifyElementVisible(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/android.widget.TextView - Enter Amount'),GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/TxtBox_Amount'), '  ',GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/android.widget.Button - OK'), GlobalVariable.TimeOut)

//verify error mssg is displyed

Mobile.verifyElementVisible(findTestObject('Object Repository/CashoutOtpPageObjects/NewTestCasesObjs/android.widget.TextView - Enter valid amount'),GlobalVariable.TimeOut)




