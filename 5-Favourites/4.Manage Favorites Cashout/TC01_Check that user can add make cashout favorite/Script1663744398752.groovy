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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

//WebUI.callTestCase(findTestCase('1-Login and Forget Pin/TC01-Login with valid mobile number and valid pin'), [('mobilenumber') : '01089478965'
 //       , ('MPin') : '147258', ('ActivationCode') : '69736', ('mobilenumber_DB') : '201089478965'], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/MyFavoritesIcon'), GlobalVariable.TimeOut)

/*try {
	Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)
	Mobile.tap(findTestObject('FavouriteBillsPageObjects/OkBtn'), 15)
}
catch (Exception ex) {
	KeywordUtil.logInfo("Element is not present!")
}
*/
Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Cashout-Tap'), GlobalVariable.TimeOut)
  
/*
 int count_1 = 500

while (count_1 >= 0) {
	try {
		Mobile.delay(2)

		boolean loading_present = Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Loading-Screen'),
			10, FailureHandling.STOP_ON_FAILURE)

		if (loading_present) {
			count_1--

			continue
		}
	}
	catch (Exception ex) {
		break
	}
}
*/
'Deleting Previously created favs if any'

try {
	Mobile.verifyElementExist(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/No-Favorit-Item-List'),
		5)
}
catch (Exception exception) {
	CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameIDThenClick'(findTestObject('Object Repository/Menu Tap Page Objects/My Favorites/Cashout Page Objects/Favorit-List-Names'),
		Mobile.getText(findTestObject('Object Repository/Menu Tap Page Objects/My Favorites/Cashout Page Objects/Favorit-List-Names'),
			5))

	Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/editFavNameIcon'), 0)

	Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/DeleteFavouritIcon'), 0)

	Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Confirmation-Delete'),
		GlobalVariable.TimeOut, FailureHandling.CONTINUE_ON_FAILURE)

	Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/ConfirmDeleteFavoritOKBtn'), 0)
	
	/* while (count_1 >= 0) {
		try {
			Mobile.delay(2)
	
			boolean loading_present = Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Loading-Screen'),
				0, FailureHandling.STOP_ON_FAILURE)
	
			if (loading_present) {
				count_1--
	
				continue
			}
		}
		catch (Exception ex) {
			break
		}
	}
	*/
}

Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Pluse Icon'), GlobalVariable.TimeOut)

'Validate that cancel button is worked successfully'
Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Cancel-Btn'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Pluse Icon'), GlobalVariable.TimeOut,
	FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Pluse Icon'), GlobalVariable.TimeOut)

'Validate that back button is worked successfully'
Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/back-Button'), GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Pluse Icon'), GlobalVariable.TimeOut,
	FailureHandling.CONTINUE_ON_FAILURE)

'validate that we cashout with valid data'
Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Pluse Icon'), 0)

FavouriteName = CustomKeywords.'customkeywords.Keywords.GenerateRandomString'(5)

MobileNumber = CustomKeywords.'customkeywords.Keywords.GenerateRandomMobNumber'(5)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Favorite-Name'), FavouriteName, GlobalVariable.TimeOut)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Agent-Number'), MobileNumber, 0)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Re-Entering-Agent-Number'), MobileNumber,
	0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Save-Btn'), 0)

Mobile.verifyElementText(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Favorites-AddedPopup'),
	SuccessfullMessage)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/FavoriteOkBtn'), GlobalVariable.TimeOut)

MobileTestObject el

int count = 4

boolean elementfound

System.out.println ("fav name is of is " + FavouriteName)

'Validate the favorit is added in my favorites section tap'
while (count >= 0) {
	el = findTestObject('Object Repository/Menu Tap Page Objects/My Favorites/Cashout Page Objects/Favorit-List-Names')

	elementfound = CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameIDThenClick'(el, FavouriteName)

	if (elementfound) {
		break
	} else {
		count--

		CustomKeywords.'customkeywords.Keywords.ScrollDown'()
	}
}
//Mobile.waitForElementPresent(findTestObject('Object Repository/Menu Tap Page Objects/My Favorites/Cashout Page Objects/Favorit-List-Names') , GlobalVariable.TimeOut)
if (elementfound == false) {
	KeywordUtil.markFailed(' the purchase favorit is not in the list')
} else {
	Mobile.verifyElementText(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/bill_name'), FavouriteName,
		FailureHandling.CONTINUE_ON_FAILURE)

	'Validate we can edit favorit name '
	Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/editFavNameIcon'), 0)

	NewFavoritName = (FavouriteName + 'Test')

	Mobile.setText(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/EditFavName-Field'), NewFavoritName,
		0)

	Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Save-Favorit NameIcon'), 0)

	Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/bill_name'), GlobalVariable.TimeOut,
		FailureHandling.CONTINUE_ON_FAILURE)

	Mobile.verifyElementText(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/bill_name'), NewFavoritName,
		FailureHandling.CONTINUE_ON_FAILURE)

	'Validate we can delete favorit successfully'
	Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/editFavNameIcon'), 0)

	Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/DeleteFavouritIcon'), 0)

	Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Confirmation-Delete'),
		GlobalVariable.TimeOut, FailureHandling.CONTINUE_ON_FAILURE)

	Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/ConfirmDeleteFavoritOKBtn'), 0)

	Mobile.delay(15)

	boolean isNoElementList

	while (count >= 0) {
		
		try {
		isNoElementList = Mobile.verifyElementExist(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/No-Favorit-Item-List'),
			5, FailureHandling.STOP_ON_FAILURE)
		
		}catch(Exception ex) {
			
			
		}
		if (isNoElementList) {
			break
		} else {
			try {
				el = findTestObject('Object Repository/Menu Tap Page Objects/My Favorites/Cashout Page Objects/Favorit-List-Names')

				elementfound = CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameIDThenClick'(el, FavouriteName)

				if (elementfound) {
					break
				} else {
					count--

					CustomKeywords.'customkeywords.Keywords.ScrollDown'()
				}
			}
			catch (Exception ex) {
				break
			}
		}
	}
	
	if ((elementfound == false) || (isNoElementList == true)) {
		KeywordUtil.markPassed(' the purchase favorit is deleted from the list')
	}
}

