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
CustomKeywords.'customkeywords.Keywords.ScrollUp'()

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/MyWalletIcon'), 5)

CustomKeywords.'customkeywords.Keywords.ScrollUp'()

CustomKeywords.'customkeywords.Keywords.ScrollUp'()

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/MyWalletAccount'), GlobalVariable.TimeOut)

MobileTestObject el = findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/CardNameList')

int countElbefore = CustomKeywords.'customkeywords.Keywords.getElementsNumberByXPath_Mobile'(el)

'Verify the invalid card number and invalid expiry date'
Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/AddCardIcon'), GlobalVariable.TimeOut)

try {
	Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/maxCardsAlert-Msg'),
		2)

	Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/oK-Btn'), GlobalVariable.TimeOut)

	Mobile.delay(2)

	CustomKeywords.'customkeywords.Keywords.ScrollDown'()
	
	CustomKeywords.'customkeywords.Keywords.selectSpecificElementFromWithinList'(findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/CardNameList'),
		Mobile.getText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/LastCardName'),5))

	Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/editcardimageview'),
		5)

	try {
		Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/removeCard1'), 20)
		}
		catch(Exception e) {
			Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/removeCard'), 20)
			}
		
	Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/Confirm-Delete'), GlobalVariable.TimeOut)

	Mobile.waitForElementPresent(findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/CardNameList'), GlobalVariable.TimeOut)

	CustomKeywords.'customkeywords.Keywords.ScrollUp'()
	
	Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/AddCardIcon'), GlobalVariable.TimeOut)
}
catch (Exception e) {
}

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/cardnumber'), InvalidCardNumber, 
    GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/Add_This_CardBtn'), 0)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/invalidCardError'),
	0)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/cardnumber'), CardNotSupported, 
    10)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/Add_This_CardBtn'), 0)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/CardNotSupported'),
	GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/ExpiryDate'), InvalidExpiredDate, 
    0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/Add_This_CardBtn'), 0)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/InvalidExpiry'), 0)


Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/ExpiryDate'), ValidExpirayDate, 
    0)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/cardEliase'), cardEliase, 0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/Add_This_CardBtn'), 0)



Mobile.delay(2)

//Mobile.pressBack()

'Verify the adding valid card'
ValidCard = ('52643901234' + CustomKeywords.'customkeywords.Keywords.GenerateRandomMobNumber'(5))



cardEliase=CustomKeywords.'customkeywords.Keywords.GenerateRandomString'(5)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/cardnumber'), ValidCard, 20)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/ExpiryDate'), ValidExpirayDate, 
    0)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/cardEliase'), cardEliase, 0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/Add_This_CardBtn'), 0)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/card-added-message'), 
    GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/backToMyWallet'), 0)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/AddCardIcon'), GlobalVariable.TimeOut)

//boolean actualresults = CustomKeywords.'customkeywords.Keywords.isElementTextPresent_Mobile'(findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/CardNameList'), 
//    cardEliase)

//assert actualresults == true

String actualtext = Mobile.getText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/CardNumberList'), 5)

Mobile.verifyEqual(actualtext.contains('xxxx'), true)

'Validate the dublicate card'
Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/AddCardIcon'), 0)

try {
	Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/maxCardsAlert-Msg'),
		2)
	
	Mobile.delay(2)

	Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/oK-Btn'), GlobalVariable.TimeOut)
	
	Mobile.delay(2)
} catch (Exception exception) {
	
	Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/cardnumber'), ValidCard, 0)
	
	Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/ExpiryDate'), ValidExpirayDate,
		0)
	
	Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/cardEliase'), cardEliase, 0)
	
	Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/Add_This_CardBtn'), 0)
	
	try {
		'Check that message of adding card is not added'
		Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/card-added-message'),
			10)
	
		Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Screen/backToMyWallet'), 0)
	}
	catch (Exception ex) {
	
	}
}



'edit and delete the card'

CustomKeywords.'customkeywords.Keywords.ScrollDown'()

CustomKeywords.'customkeywords.Keywords.ScrollDown'()

CustomKeywords.'customkeywords.Keywords.selectSpecificElementFromWithinList'(findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/CardNameList'),
	cardEliase)

'edit the card'

Mobile.delay(2)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/editcardimageview'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/cardEliaseEditField'), 
    editablecardEliase, 0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/SaveIcon'), 0)

Mobile.verifyElementText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/cardEliaseEditField'), 
    editablecardEliase)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/editcardimageview'), 0)

try {
Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/removeCard1'), 
    20)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/removeCard1'), 20)
}
catch(Exception ex) {
	Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/removeCard'),
		20)
	
	Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/removeCard'), 20)
	}


Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/Card Operations Screen/Confirm-Delete'), GlobalVariable.TimeOut)

Mobile.waitForElementPresent(findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/CardNameList'), GlobalVariable.TimeOut)

el = findTestObject('Object Repository/Menu Tap Page Objects/My Wallet Page Objects/CardNameList')

int countElAfter = CustomKeywords.'customkeywords.Keywords.getElementsNumberByXPath_Mobile'(el)

//Mobile.verifyLessThan(countElAfter, countElbefore)
