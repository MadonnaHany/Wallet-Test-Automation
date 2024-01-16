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

Mobile.tap(findTestObject('FavouriteBillsPageObjects/MyFavorites_Icon'), GlobalVariable.TimeOut)

/*try {
    Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

    Mobile.tap(findTestObject('FavouriteBillsPageObjects/OkBtn'), 10)
}
catch (Exception ex) {
    KeywordUtil.logInfo('Element is not present!')
} 
*/
Mobile.tap(findTestObject('FavouriteBillsPageObjects/Bills-Tap'), GlobalVariable.TimeOut)

//Mobile.waitForElementPresent(findTestObject('FavouriteBillsPageObjects/BillerName'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/AddFavouritePlusIcon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/TelecomAndInternetTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneTab'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/VodafoneBillTab'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('FavouriteBillsPageObjects/FavouriteNameTxt'), addToFavoriteName + System.nanoTime(), GlobalVariable.TimeOut)

String mobile = '011' + System.nanoTime()

Mobile.setText(findTestObject('FavouriteBillsPageObjects/mobileNumber'), mobile, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('FavouriteBillsPageObjects/MobileNumberConfirmTextBox'), mobile, GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/ContinueBtn'), GlobalVariable.TimeOut)

FavoriteMsg = Mobile.getText(findTestObject('FavouriteBillsPageObjects/FavouriteSuccessMsg'), GlobalVariable.TimeOut)

Mobile.verifyEqual(FavoriteMsg.contains(addToFavoriteSuccessMsg), true, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/SuccessMsgOkBtn'), GlobalVariable.TimeOut)

Mobile.waitForElementPresent(findTestObject('FavouriteBillsPageObjects/Home-Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/Home-Icon'), GlobalVariable.TimeOut)

