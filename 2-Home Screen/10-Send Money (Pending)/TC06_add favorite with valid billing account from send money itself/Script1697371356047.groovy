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

CustomKeywords.'customkeywords.Keywords.selectSpecificElementFromWithinList'(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/btcsList-Fld'), 'Send Money')

String BillingAcct=	CustomKeywords.'db_operations.RechargeDBOperations.GetMobileNumForSendingMoney'()

FavoritName = CustomKeywords.'customkeywords.Keywords.GenerateRandomString'(5)

try {
Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), BillingAcct, GlobalVariable.TimeOut)
}

catch (Exception ex){
	Mobile.tap(findTestObject('CashoutMainPageObjects/android.widget.Button - OK'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)
	Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), BillingAcct, GlobalVariable.TimeOut)
	
	}
Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MobileNumberConfirmTextBox'), BillingAcct,
	GlobalVariable.TimeOut)


Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('CashoutMainPageObjects/withdrawlAmountTxt'), '1', GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/AddToFavouriteCheckBox'), 0)

Mobile.setText(findTestObject('Object Repository/send Money/FavoriteName_TxtFld'), FavoritName, 5)


Mobile.tap(findTestObject('CashoutMainPageObjects/ContinuBtn'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Payment Page Objects/AddToFavoruiteMsg'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/AddToFavoriteOKBtn'), 0)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/BackBtn'), GlobalVariable.TimeOut)

'Validate the Existing Favorit Name with the same mobile'

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/mobileNumber'), BillingAcct, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Recharge Page Objects/Payment Page Objects/MobileNumberConfirmTextBox'), BillingAcct,
	GlobalVariable.TimeOut)
Mobile.setText(findTestObject('Object Repository/send Money/FavoriteName_TxtFld'), FavoritName, 5)

Mobile.tap(findTestObject('CashoutMainPageObjects/ContinuBtn'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Recharge Page Objects/Payment Page Objects/AddToFavoruiteErrorMsg'), GlobalVariable.TimeOut,
	FailureHandling.CONTINUE_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Recharge Page Objects/Payment Page Objects/AddToFavoruiteErrorMsg'), ExistingFavorit,
	FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/AddToFavoruiteErrorOKBtn'), 0)

'Validate when we cancel return to home screen'
// new
Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/CancelBtn'), 0)

Mobile.verifyElementVisible(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Home-Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/MyFavoritesIcon'), 0)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/OkBtn'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Object Repository/send Money/FriendsTab_Fav'), GlobalVariable.TimeOut)

int count_5 = 5

'Validate the favorit is added in my favorites section tap'
while (count_5 >= 0) {
	el = findTestObject('Object Repository/send Money/FavName_friends')

	elementfound = CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameIDThenClick'(el, FavoritName)

	if (elementfound) {
		break
	} else {
		count_5--

		CustomKeywords.'customkeywords.Keywords.ScrollDown'()
	}
}

//Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Favorites/Bills Favorites Sec/Empty-Payment'), GlobalVariable.TimeOut,
  // FailureHandling.CONTINUE_ON_FAILURE)



