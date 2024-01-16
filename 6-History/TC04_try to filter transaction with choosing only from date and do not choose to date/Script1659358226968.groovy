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

WebUI.callTestCase(findTestCase('6-History/Making-Transaction(Vodafon Recharge)'), [('Phone') : '0120000200'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/MyTransactions Icon'), 15)

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

//Mobile.verifyElementText(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FirstItemInTheLog'), TransactionN)
String actualText = Mobile.getText(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FirstItemInTheLog'), GlobalVariable.TimeOut)

Mobile.verifyMatch(actualText, TransactionN, true)

'try to filter transactions with from or to date'
Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FilterIcon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FromDateImage'), 0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/CalenderOk'), 0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FilterBtn'), GlobalVariable.TimeOut)

Mobile.delay(20, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FirstElementinFilterResult'), 
    GlobalVariable.TimeOut, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/CloseFilterResults'), 0)

Mobile.delay(20, FailureHandling.STOP_ON_FAILURE)
/*int count_1 = 500

while (count_1 >= 0) {
    try {
        Mobile.delay(2)

        boolean loading_present = Mobile.verifyElementVisible(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/Loading_Progress'), 
            0)

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
'to date'
Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FilterIcon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/ToDate'), 0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/CalenderOk'), 0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FilterBtn'), GlobalVariable.TimeOut)

Mobile.delay(20, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FirstElementinFilterResult'), 
    GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/CloseFilterResults'), 0)

Mobile.delay(20, FailureHandling.CONTINUE_ON_FAILURE)
/*while (count_1 >= 0) {
    try {
        Mobile.delay(2)

        boolean loading_present = Mobile.verifyElementVisible(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/Loading_Progress'), 
            0)

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
'From and to date'
Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FilterIcon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FromDateImage'), 0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/CalenderOk'), 0)

Mobile.tap(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/ToDate'), 0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/CalenderOk'), 0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FilterBtn'), GlobalVariable.TimeOut)

Mobile.delay(20, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FirstElementinFilterResult'), 
    GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/CloseFilterResults'), GlobalVariable.TimeOut)

/*while (count_1 >= 0) {
    try {
        Mobile.delay(2)

        boolean loading_present = Mobile.verifyElementVisible(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/Loading_Progress'), 
            0)

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
Mobile.delay(20, FailureHandling.CONTINUE_ON_FAILURE)

'try to filter with any date and open advanced search and don\'t choose any advanced filter options'

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FilterIcon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/AdvancedSearchLink'), 0)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/PaymentStatusFilter'), 5)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/PaymentType'), 0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/Payment-Type-(charge wallet option)'), 10)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FilterBtn'), GlobalVariable.TimeOut)

try {
    Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/NoMatchWithCriteria'), 
        GlobalVariable.TimeOut)

    Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/Ok-NofilterwitCriteriaPopup'), 0)
}
catch (Exception ex) {
    Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/CloseFilterResults'), 0)
} 
Mobile.delay(15, FailureHandling.CONTINUE_ON_FAILURE)
//Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FirstItemInTheLog'), 0)
/*PaymentStatus = Mobile.getText(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/Payment-Reciept-status'), 
    0)*/
//Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/BackBtn'), 0)
'try to filter with success transactions'
/*while (count_1 >= 0) {
    try {
        Mobile.delay(2)

        boolean loading_present = Mobile.verifyElementVisible(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/Loading_Progress'), 
            0)

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

try {
	Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/CancelBtn'), 15)
}
catch (Exception ex) {
	KeywordUtil.logInfo("Element is not present!")
	}
	
//Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/CancelBtn'), 15 ,FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FilterIcon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/AdvancedSearchLink'), 7)

Mobile.tap(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/PaymentStatusFilter'), 7)


CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameID'(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/PaymentStatusList'),
	Payment_Success_Status)
	

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/SuccessfulTransactionOption'), 10)

//Mobile.tap(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/PaymentStatusList'), 
// Payment_Success_Status, GlobalVariable.TimeOut)
Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FilterBtn'), GlobalVariable.TimeOut)

Mobile.delay(30, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FirstElementinFilterResult'), 
    GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/CloseFilterResults'), 0)

/*while (count_1 >= 0) {
    try {
        Mobile.delay(2)

        boolean loading_present = Mobile.verifyElementVisible(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/Loading_Progress'), 
            0)

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

/*Mobile.tap(findTestObject('CashoutOtpPageObjects/NewTestCasesObjs/Home Screen Page Objects/Home-Icon'), 30)

WebUI.callTestCase(findTestCase('6-History/Making Cashout (Failed Transaction)'), [('AgentNumber') : '0120000300', ('WithdowalAmount') : '10'
        , ('CashoutDeclined') : 'Declined transaction'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/MyTransactions Icon'), 15)

Mobile.delay(10, FailureHandling.CONTINUE_ON_FAILURE)


'try to filter with any date and open advanced search and don\'t choose any advanced filter options'
Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FilterIcon'), 5)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FirstItemInTheLog'), 0)

PaymentStatus = Mobile.getText(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/Cashout-Transaction-reciept-status'), 
    20)

Mobile.tap(findTestObject('Recharge Page Objects/Payment Page Objects/BackBtn'), 20)
*/
//Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/CancelBtn'), GlobalVariable.TimeOut)
Mobile.delay(20, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FilterIcon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/AdvancedSearchLink'), 0)

Mobile.tap(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/PaymentStatusFilter'), 0)

CustomKeywords.'customkeywords.Keywords.getTextForElementWithTheSameID'(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/PaymentStatusList'), 
    Payment_Declined_Status)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/DeclinedTransactionOption'), 0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FilterBtn'), GlobalVariable.TimeOut)

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FirstElementinFilterResult'), 
    GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/CloseFilterResults'), 0)

//Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
/*while (count_1 >= 0) {
    try {
        Mobile.delay(2)

        boolean loading_present = Mobile.verifyElementVisible(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/Loading_Progress'), 
            0)

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
'filter with transaction with card or wallet'

//Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/CancelBtn'), GlobalVariable.TimeOut)
'Filter with card'
Mobile.delay(20, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FilterIcon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/AdvancedSearchLink'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/PaymentMethodFilter'), 
    5)

Mobile.tap(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/PaymentMethodFilter'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/select-the-payment-method (card)'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FilterBtn'), GlobalVariable.TimeOut)

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FirstElementinFilterResult'), 
    GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/CloseFilterResults'), 0)

Mobile.delay(20, FailureHandling.CONTINUE_ON_FAILURE)
/*while (count_1 >= 0) {
    try {
        Mobile.delay(2)

        boolean loading_present = Mobile.verifyElementVisible(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/Loading_Progress'), 
            0)

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
//Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/CancelBtn'), GlobalVariable.TimeOut)
'Filter with my wallet'
Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FilterIcon'), GlobalVariable.TimeOut)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/AdvancedSearchLink'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/PaymentMethodFilter'), 
    5)

Mobile.tap(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/PaymentMethodFilter'), 0)

Mobile.tap(findTestObject('Object Repository/Menu Tap Page Objects/My Transactions Page Objects/Select-The-Payment-Method(my wallet)'), 
    0)

Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/FilterBtn'), GlobalVariable.TimeOut)

try {
    Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/NoMatchWithCriteria'), 
        GlobalVariable.TimeOut)

    Mobile.tap(findTestObject('Menu Tap Page Objects/My Transactions Page Objects/Ok-NofilterwitCriteriaPopup'), 0)
}
catch (Exception ex) {
} 
