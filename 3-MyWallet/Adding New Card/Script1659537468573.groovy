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

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/MyWalletIcon'), GlobalVariable.TimeOut)

'Verify the card is adding successfully'
Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/AddCardIcon'), GlobalVariable.TimeOut)

try {
    Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/maxCardsAlert-Msg'), 
        2)

    Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/oK-Btn'), GlobalVariable.TimeOut)

    Mobile.delay(2)

    CustomKeywords.'customkeywords.Keywords.ScrollDown'()

    CustomKeywords.'customkeywords.Keywords.ScrollDown'()

    CustomKeywords.'customkeywords.Keywords.selectSpecificElementFromWithinList'(findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/CardNameList'), 
        Mobile.getText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/LastCardName'), 5))

    Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/editcardimageview'), 
        5)

    Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/removeCard'), GlobalVariable.TimeOut)

    Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/Confirm-Delete'), GlobalVariable.TimeOut)

    Mobile.waitForElementPresent(findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/CardNameList'), 
        GlobalVariable.TimeOut)

    CustomKeywords.'customkeywords.Keywords.ScrollUp'()

    CustomKeywords.'customkeywords.Keywords.ScrollUp'()

    Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/AddCardIcon'), GlobalVariable.TimeOut)
}
catch (Exception e) {
} 

'Verify the adding valid card'
//Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/AddCardIcon'), GlobalVariable.TimeOut)
try {
	ValidCard = ('52643901234' + CustomKeywords.'customkeywords.Keywords.GenerateRandomMobNumber'(5))

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/cardnumber'), ValidCard, GlobalVariable.TimeOut)
Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/cardEliase'), cardEliase, 0)

GlobalVariable.PublicCardName = cardEliase
Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/Add_This_CardBtn'), 0)

Mobile.delay(7, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/card-added-message'),
	GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/backToMyWallet'), 0)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/AddCardIcon'), GlobalVariable.TimeOut)

boolean actualresults = CustomKeywords.'customkeywords.Keywords.isElementTextPresent_Mobile'(findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/CardNameList'),
	cardEliase)

//assert actualresults == true
GlobalVariable.PublicCardName = cardEliase

Mobile.tap(findTestObject('Menu Tap Page Objects/Home Icon'), 0)

Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut)
}

catch (Exception e) {

ValidCard = ('52643901234' + CustomKeywords.'customkeywords.Keywords.GenerateRandomMobNumber'(5))

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/cardnumber'), ValidCard, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/ExpiryDate'), ValidExpirayDate, 
    0)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/cardEliase'), cardEliase, 0)

GlobalVariable.PublicCardName = cardEliase

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/Add_This_CardBtn'), 0)

Mobile.delay(7, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/card-added-message'), 
    GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/backToMyWallet'), 0)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/AddCardIcon'), GlobalVariable.TimeOut)

boolean actualresults = CustomKeywords.'customkeywords.Keywords.isElementTextPresent_Mobile'(findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/CardNameList'), 
    cardEliase)

//assert actualresults == true
GlobalVariable.PublicCardName = cardEliase

Mobile.tap(findTestObject('Menu Tap Page Objects/Home Icon'), 0)

Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Payment_Icon'), GlobalVariable.TimeOut)
}
