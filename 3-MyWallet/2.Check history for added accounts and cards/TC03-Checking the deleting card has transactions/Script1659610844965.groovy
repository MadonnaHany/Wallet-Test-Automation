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

/*
WebUI.callTestCase(findTestCase('1-Login and Forget Pin/TC01-Login with valid mobile number and valid pin'), [('mobilenumber') : GlobalVariable.MobileNumber
        , ('MPin') : GlobalVariable.MPin, ('ActivationCode') : '69736', ('mobilenumber_DB') : '201089478965'], FailureHandling.STOP_ON_FAILURE)
*/
CardName = CustomKeywords.'customkeywords.Keywords.GenerateRandomString'(6)

WebUI.callTestCase(findTestCase('3-MyWallet/Adding New Card'), [('ValidCard') : '5264391234567892', ('ValidExpirayDate') : '05/28'
        , ('cardEliase') : CardName], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('3-MyWallet/Making-Transaction(Vodafon Recharge) without rating'), [('Phone') : '0120000200'
        , ('TransactionStatus') : 'Successful transaction', ('PaymentMethod') : CardName], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/MyWalletIcon'), GlobalVariable.TimeOut)

Mobile.delay(2)

CustomKeywords.'customkeywords.Keywords.ScrollDown'()

CustomKeywords.'customkeywords.Keywords.ScrollDown'()

MobileTestObject el = findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/CardNameList')

int countElbefore = CustomKeywords.'customkeywords.Keywords.getElementsNumberByXPath_Mobile'(el)

CustomKeywords.'customkeywords.Keywords.selectSpecificElementFromWithinList'(findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/CardNameList'), 
    CardName)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/editcardimageview'), 5)

try {
    Mobile.delay(10, FailureHandling.CONTINUE_ON_FAILURE)
	Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/removeCard'), 20)
//	Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/removeCard1'), 20, FailureHandling.CONTINUE_ON_FAILURE)
}
catch (Exception ex) {
	Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/removeCard1'), 20)
} 

//Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/removeCard'), GlobalVariable.TimeOut)
Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/Confirm-Delete'), GlobalVariable.TimeOut)

Mobile.delay(40, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/CardNameList'), 15)

el = findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/CardNameList')

int countElAfter = CustomKeywords.'customkeywords.Keywords.getElementsNumberByXPath_Mobile'(el)

