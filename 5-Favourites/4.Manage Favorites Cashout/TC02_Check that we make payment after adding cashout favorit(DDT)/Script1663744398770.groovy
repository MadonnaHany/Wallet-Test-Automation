import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.builtin.PinchToZoomInAtPositionKeyword as PinchToZoomInAtPositionKeyword
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

/*
WebUI.callTestCase(findTestCase('1-Login and Forget Pin/TC01-Login with valid mobile number and valid pin'), [('mobilenumber') : '01089478965'
        , ('MPin') : '147258', ('ActivationCode') : '69736', ('mobilenumber_DB') : '201089478965'], FailureHandling.STOP_ON_FAILURE)
*/
Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/MyFavoritesIcon'), GlobalVariable.TimeOut)

try {
    Mobile.delay(25, FailureHandling.STOP_ON_FAILURE)

    Mobile.tap(findTestObject('FavouriteBillsPageObjects/OkBtn'), 15)
}
catch (Exception ex) {
    KeywordUtil.logInfo('Element is not present!')
} 

Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Cashout-Tap'), GlobalVariable.TimeOut)

/*int count_1 = 500

while (count_1 >= 0) {
    try {
        Mobile.delay(2)

        boolean loading_present = Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Loading-Screen'), 
            15, FailureHandling.STOP_ON_FAILURE)

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
int count = 5

boolean isNoElementList

while (count >= 0) {
    try {
        isNoElementList = Mobile.verifyElementExist(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/No-Favorit-Item-List'), 
            15, FailureHandling.STOP_ON_FAILURE)
    }
    catch (Exception ex) {
    } 
    
    if (isNoElementList) {
        Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Pluse Icon'), 0)

        FavouriteName = CustomKeywords.'customkeywords.Keywords.GenerateRandomMobNumber'(5)

        //          MobileNumber = CustomKeywords.'customkeywords.Keywords.GenerateRandomMobNumber'(5)
        Mobile.setText(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Favorite-Name'), FavouriteName, 
            GlobalVariable.TimeOut)

        Mobile.setText(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Agent-Number'), MobileNumber, 
            0)

        Mobile.setText(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Re-Entering-Agent-Number'), 
            MobileNumber, 0)

        Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Save-Btn'), 0)

        Mobile.delay(10)

        Mobile.verifyElementText(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/Favorites-AddedPopup'), 
            SuccessfullMessage)

        Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/FavoriteOkBtn'), 0)

        'Validate the favorit is added in my favorites section tap'
        int count_2 = 0

        boolean elementfound

        Mobile.delay(10)

        while (count_2 >= 0) {
            el = findTestObject('Object Repository/Menu Tap Page Objects/My Favorites/Cashout Page Objects/Favorit-List-Names')

            elementfound = true

            //CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameIDThenClick'(el, FavouriteName)
            Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/First_Item_Favorit'), GlobalVariable.TimeOut)

            if (elementfound) {
                break
            } else {
                count_2--

                CustomKeywords.'customkeywords.Keywords.ScrollDown'()
            }
        }
        
        if (elementfound == false) {
            KeywordUtil.markFailed(' the purchase favorit is not in the list') //Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/First_Item_Favorit'), GlobalVariable.TimeOut)
        } else {
            Mobile.verifyElementText(findTestObject('Menu Tap Page Objects/My Favorites/Cashout Page Objects/bill_name'), 
                FavouriteName, FailureHandling.CONTINUE_ON_FAILURE)

            break
        }
    } else {
        el = findTestObject('Object Repository/Menu Tap Page Objects/My Favorites/Cashout Page Objects/favBillingAccountList-Flds')

        Mobile.scrollToText(favName)

        CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameIDThenClick'(el, favName)

        break
    }
}

Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Payment Page Objects/Make-Payment-Btn'), GlobalVariable.TimeOut)

Mobile.delay(30, FailureHandling.STOP_ON_FAILURE)

/*wallet_name = Mobile.getText(findTestObject('Menu Tap Page Objects/My Favorites/Payment Page Objects/payment-Method-Text'), 
    GlobalVariable.TimeOut)

assert wallet_name.isEmpty() == false
*/
'Validate that invalid amount'
Mobile.setText(findTestObject('Menu Tap Page Objects/My Favorites/Payment Page Objects/Cashout-Withdraw-Amount'), InvalidAmount, 
    GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Payment Page Objects/ContinuBtn'), GlobalVariable.TimeOut)

//Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Favorites/Payment Page Objects/Valid_amount_value_alert'), 
//  5)

/*Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Payment Method List'), 20)
Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut)
*/
Mobile.clearText(findTestObject('Menu Tap Page Objects/My Favorites/Payment Page Objects/Cashout-Withdraw-Amount'), GlobalVariable.TimeOut)

'validate the amount within range'
Mobile.setText(findTestObject('Menu Tap Page Objects/My Favorites/Payment Page Objects/Cashout-Withdraw-Amount'), amount, 
    GlobalVariable.TimeOut)

//Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Payment Method List'), 20)
//Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut)
Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletSlct'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 20)

Mobile.setText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/WithdrowallAmount'),
	ValidAmount, 12)
//Mobile.tap(findTestObject('CashoutMainPageObjects/myWalletsItemsLst'), 20)
Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Payment Page Objects/ContinuBtn'), GlobalVariable.TimeOut)

//Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/My Wallet Page Objects/Cashout Page Objects/Confirm-Cashout'),
//	GlobalVariable.TimeOut)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Favorites/Payment Page Objects/Confirm-Payment-transaction'), 
    GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Payment Page Objects/Confirm-Payment-transaction'), GlobalVariable.TimeOut)

if (Pin.isEmpty()) {
    Pin = GlobalVariable.MPin
}

WebUI.callTestCase(findTestCase('Shared_Testcases/try to make transaction with valid M-Pin'), [('TransactionStatus') : ExpectedMessage
        , ('ExpectedMessage') : ExpectedMessage, ('Pin') : Pin], FailureHandling.CONTINUE_ON_FAILURE)

ExpectedMessage

if ((ExpectedMessage == 'Successful transaction') || (ExpectedMessage == 'Successful Transaction')){
      Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Payment Page Objects/CloseBtn'), 0)
    'Check the payment added with previous transactions'
    Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Favorites/Payment Page Objects/previous-payment-records'), 
        GlobalVariable.TimeOut)

    Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Payment Page Objects/payment-chart icon'), GlobalVariable.TimeOut)

    Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Favorites/Payment Page Objects/Payment-Chart'), 
        GlobalVariable.TimeOut, FailureHandling.CONTINUE_ON_FAILURE)
} else {
    Mobile.tap(findTestObject('Menu Tap Page Objects/My Favorites/Payment Page Objects/CloseBtn'), GlobalVariable.TimeOut)
}

