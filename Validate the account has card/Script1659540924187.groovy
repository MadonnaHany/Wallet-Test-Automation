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

try {
    Mobile.tap(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/MyWalletIcon'), GlobalVariable.TimeOut)

    Mobile.verifyElementVisible(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/FirstCartName'), 5)

    CardName = Mobile.getText(findTestObject('Menu Tap Page Objects/My Wallet Page Objects/FirstCartName'), 0)

    GlobalVariable.PublicCardName = CardName

    Mobile.tap(findTestObject('Menu Tap Page Objects/Home Icon'), 0)
}
catch (Exception ex) {
    CardName = CustomKeywords.'customkeywords.Keywords.GenerateRandomString'(9)

    WebUI.callTestCase(findTestCase('3-MyWallet/Adding New Card'), [('ValidCard') : '4567851234567892', ('ValidExpirayDate') : '05/28'
            , ('cardEliase') : CardName], FailureHandling.STOP_ON_FAILURE)

    Mobile.tap(findTestObject('Menu Tap Page Objects/Home Icon'), 0)
} 

