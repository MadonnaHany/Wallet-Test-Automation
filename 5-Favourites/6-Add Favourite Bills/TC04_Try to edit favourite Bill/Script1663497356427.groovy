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
	Mobile.delay(25, FailureHandling.STOP_ON_FAILURE)
    Mobile.tap(findTestObject('FavouriteBillsPageObjects/OkBtn'), GlobalVariable.TimeOut)
}
catch (Exception ex) {
    KeywordUtil.logInfo('Element is not present!')
} 
*/
Mobile.tap(findTestObject('FavouriteBillsPageObjects/Bills-Tap'), GlobalVariable.TimeOut)

Mobile.waitForElementPresent(findTestObject('FavouriteBillsPageObjects/BillerName'), GlobalVariable.TimeOut)

String FirstFavName = Mobile.getText(findTestObject('FavouriteBillsPageObjects/FavouriteNameList'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/BillerName'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/EditFavouriteIcon'), GlobalVariable.TimeOut)

Mobile.setText(findTestObject('FavouriteBillsPageObjects/EditBillNameTxt'), addToFavoriteName + System.nanoTime(), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/ConfirmEditBtn'), GlobalVariable.TimeOut)

Mobile.waitForElementPresent(findTestObject('FavouriteBillsPageObjects/CancelFavouriteDetailsPage'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/CancelFavouriteDetailsPage'), GlobalVariable.TimeOut)

String FirstFavNameAfterEdit = Mobile.getText(findTestObject('FavouriteBillsPageObjects/FavouriteNameList'), GlobalVariable.TimeOut)

Mobile.verifyMatch(FirstFavNameAfterEdit, FirstFavName, true, FailureHandling.STOP_ON_FAILURE)

Mobile.pressBack()

//Mobile.waitForElementPresent(findTestObject('FavouriteBillsPageObjects/Home-Icon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('FavouriteBillsPageObjects/Home-Icon'), GlobalVariable.TimeOut)

