package customkeywords

import java.time.Duration

import org.apache.commons.lang3.RandomStringUtils
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.MobileTestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.ConditionType

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.TouchAction
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption






class Keywords {


	@Keyword
	def String generatePinNumbers(int num) {

		Random random = new Random()

		return random.nextInt(10 ** num).toString()
	}


	@Keyword
	public static String GenerateRandomString(int count) {
		return  RandomStringUtils.randomAlphabetic(count);
	}


	@Keyword
	def String  GenerateRandomMobNumber(int count) {
		return (RandomStringUtils.randomNumeric(count));
	}

	@Keyword
	def horizontalSwipe() {
		AppiumDriver<?> driver=getCurrentSessionMobileDriver()
		Dimension dim = driver.manage().window().getSize();
		int height = dim.height
		int width = dim.width
		int y = (int)(height*0.10);
		int startx = (int)(width*0.80);
		int endx = (int)(width*0.10);
		//	new TouchAction(driver).press(PointOption.point(x, starty)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000))).moveTo(PointOption.point(x, endy)).release().perform()
		TouchAction action = new TouchAction(driver)
		action.press(PointOption.point(startx, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(endx, y)).release().perform()


	}


	@Keyword
	public void ScrollDown() throws InterruptedException {

		AppiumDriver<?> driver=getCurrentSessionMobileDriver()
		int pressX = driver.manage().window().getSize().width/2 ;
		// 4/5 of the screen as the bottom finger-press point
		int bottomY = driver.manage().window().getSize().height * 5/6 ;
		// just non zero point, as it didn't scroll to zero normally
		int topY = driver.manage().window().getSize().height / 7;
		//scroll with TouchAction by itself
		TouchAction action = new TouchAction(driver);

		action.longPress(PointOption.point(pressX,bottomY)).moveTo(PointOption.point(pressX,topY)).release().perform();
	}

	@Keyword
	public void ScrollUp() throws InterruptedException {

		AppiumDriver<?> driver=getCurrentSessionMobileDriver()
		int pressX = driver.manage().window().getSize().width/2 ;
		// 4/5 of the screen as the bottom finger-press point
		int bottomY = driver.manage().window().getSize().height * 5/6 ;
		// just non zero point, as it didn't scroll to zero normally
		int topY = driver.manage().window().getSize().height / 7;
		//scroll with TouchAction by itself
		TouchAction action = new TouchAction(driver);

		action.longPress(PointOption.point(pressX,topY)).moveTo(PointOption.point(pressX,bottomY)).release().perform();
	}


	@Keyword
	def String getTextForElementWithTheSameID(MobileTestObject to,String searchedElement){
		String FoundElement=null;

		try {

			//MobileTestObject Service;
			boolean  isPresent=false;
			boolean  isnotPresentonview=true;
			KeywordUtil.logInfo("Finding element with id:" + to.getObjectId())

			String ID=to.mobileLocator

			AppiumDriver<?> driver=getCurrentSessionMobileDriver()
			List<MobileElement> elements =driver.findElementsById(ID)

			for (MobileElement Service : elements) {
				'Get the text of each element in the list and store in to the "actual_Text" variable.'

				//emptylist2.add(Service)

				String actual_Text = Service.getText()

				KeywordUtil.logInfo("Element's Text is : " + actual_Text)


				if (actual_Text.contains(searchedElement)) {

					FoundElement=actual_Text
					Service.click()
					break


				} else {


					continue;

				}



			}
		}
		catch (Exception e) {
			KeywordUtil.markFailed("Object " + to.getObjectId() + " is not present")
		}

		return FoundElement
	}

	@Keyword
	def boolean isElementTextPresent_Mobile(MobileTestObject to,String searchedElement){



		boolean FoundElement=false;

		try {

			//MobileTestObject Service;
			boolean  isPresent=false;
			boolean  isnotPresentonview=true;
			KeywordUtil.logInfo("Finding element with id:" + to.getObjectId())

			String ID=to.mobileLocator

			AppiumDriver<?> driver=getCurrentSessionMobileDriver()
			List<MobileElement> elements =driver.findElementsById(ID)

			for (MobileElement Service : elements) {
				'Get the text of each element in the list and store in to the "actual_Text" variable.'

				//emptylist2.add(Service)

				String actual_Text = Service.getText()


				if (searchedElement.contains(actual_Text)) {

					FoundElement=true

					break


				} else {


					continue;

				}



			}
		}
		catch (Exception e) {
			KeywordUtil.markFailed("Object " + to.getObjectId() + " is not present")
		}

		return FoundElement

	}


	@Keyword
	def int getElementsNumber_Mobile(MobileTestObject element){

		int num=0;

		try {

			//MobileTestObject Service;
			boolean  isPresent=false;
			boolean  isnotPresentonview=true;
			KeywordUtil.logInfo("Finding element with id:" + element.getObjectId())

			String ID=element.mobileLocator

			AppiumDriver<?> driver=getCurrentSessionMobileDriver()
			List<MobileElement> elements =driver.findElementsById(ID)

			num	=elements.size()


		}catch(Exception ex) {

			KeywordUtil.markFailed("Object " + element.getObjectId() + " is not present")

		}

		return num

	}


	@Keyword
	def int getElementsNumberByXPath_Mobile(MobileTestObject element){

		int num=0;

		try {

			//MobileTestObject Service;
			boolean  isPresent=false;
			boolean  isnotPresentonview=true;
			KeywordUtil.logInfo("Finding element with id:" + element.getObjectId())

			String xpath=element.mobileLocator

			AppiumDriver<?> driver=getCurrentSessionMobileDriver()
			List<MobileElement> elements =driver.findElementsByXPath(xpath)

			num	=elements.size()


		}catch(Exception ex) {

			KeywordUtil.markFailed("Object " + element.getObjectId() + " is not present")

		}

		return num

	}

	@Keyword
	def boolean getTextForElementWithTheSameIDThenClick(MobileTestObject element,String searchedElement){

		boolean  isPresent=false;
		try {

			//MobileTestObject Service;

			boolean  isnotPresentonview=true;
			KeywordUtil.logInfo("Finding element with id:" + element.getObjectId())

			String ID=element.mobileLocator

			AppiumDriver<?> driver=getCurrentSessionMobileDriver()
			List<MobileElement> elements =driver.findElementsById(ID)

			for (MobileElement Service : elements) {
				'Get the text of each element in the list and store in to the "actual_Text" variable.'

				//emptylist2.add(Service)

				String actual_Text = Service.getText()

				System.out.println ("Text of element is " + actual_Text)

				if (searchedElement.equalsIgnoreCase(actual_Text)) {
					isPresent=true

					Service.click()
					break



				}

				else {


					continue;

				}



			}
		}
		catch (Exception e) {
			KeywordUtil.markFailed("Object " + element.getObjectId() + " is not present")
		}
		return isPresent

	}

	/**
	 * Get mobile driver for current session
	 * @return mobile driver for current session
	 */
	@Keyword
	def WebDriver getCurrentSessionMobileDriver() {
		return MobileDriverFactory.getDriver();
	}
	@Keyword
	def boolean checkIfAppActive()
	{
		boolean active
		AppiumDriver<?> driver=getCurrentSessionMobileDriver();
		ApplicationState state = driver.queryAppState(GlobalVariable.APP_Package);
		KeywordUtil.logInfo("Current Application state is : " + state);
		switch(state) {
			case GlobalVariable.APP_STATE_RUNNING_IN_FOREGROUND:
				KeywordUtil.logInfo("Application is running in Foreground");
				active = true
				break
			case GlobalVariable.APP_STATE_RUNNING_IN_BACKGROUND:
			default:
				KeywordUtil.logInfo("Oops, Application seems to be crashed.. restarting");
				active = false
				Mobile.startExistingApplication(GlobalVariable.APP_Package, FailureHandling.STOP_ON_FAILURE);
				break
		}
		return active
	}

	/**
	 * Method to perform Forward horizontal swipe on elements of a specific list
	 * @param elements
	 * @return
	 */
	@Keyword
	def dynamicHorizontalSwipe(TestObject elements) {
		AppiumDriver<?> driver=getCurrentSessionMobileDriver()
		int y = Mobile.getElementTopPosition(elements,GlobalVariable.TimeOut)
		int startx = Mobile.getDeviceWidth()/2
		int endx = Mobile.getElementLeftPosition(elements,GlobalVariable.TimeOut)
		TouchAction action = new TouchAction(driver)
		action.press(PointOption.point(startx, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(endx, y)).release().perform()
	}
	/**
	 * Method to perform Backwards horizontal swipe on elements of a specific list
	 * @param elements
	 * @return
	 */
	@Keyword
	def dynamicHorizontalBackwardsSwipe(TestObject elements) {
		AppiumDriver<?> driver=getCurrentSessionMobileDriver()
		int y = Mobile.getElementTopPosition(elements,GlobalVariable.TimeOut)
		int startx = Mobile.getDeviceWidth()/2
		int endx = Mobile.getElementWidth(elements,GlobalVariable.TimeOut)
		TouchAction action = new TouchAction(driver)
		action.press(PointOption.point(endx, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(startx, y)).release().perform()
	}
	/**
	 * Method to create test object out of a list of elements
	 * @param elements
	 * @param locator
	 * @return
	 */
	@Keyword
	def TestObject createTestObjectOutOfList(List<MobileElement> elements, String locator) {
		TestObject testObject = new TestObject();
		testObject.addProperty("xpath", ConditionType.EQUALS, locator);
		return testObject;
	}



	/**
	 * \Method to select a specific element from a list with left to right swipe
	 * @param elementsList
	 * @param expectedText
	 * @return
	 */
	@Keyword
	def selectSpecificElementFromWithinList(MobileTestObject elementsList, String expectedText){
		try {



			String actualText = ""
			boolean found = false
			String xpath = elementsList.mobileLocator
			AppiumDriver<?> driver=getCurrentSessionMobileDriver()
			while (true) {
				List<MobileElement> elements = driver.findElementsByXPath(xpath)
				for (MobileElement element : elements) {
					System.out.println ("Text of element is " + element.getText())
					actualText = element.getText().trim()
					if (actualText.equalsIgnoreCase(expectedText)) {
						found = true
						element.click()
						break
					}
				}
				if (found == true) {
					break
				}
				else if (found == false)  {
					dynamicHorizontalSwipe(createTestObjectOutOfList(elements,xpath))

				}

			}
		}
		catch (Exception e) {
			KeywordUtil.markFailed("Object " + elementsList.getObjectId() + " is not present")
		}
	}

	/**
	 * \Method to select a specific element from a list with scroll down
	 * @param elementsList
	 * @param expectedText
	 * @return
	 */
	@Keyword
	def selectSpecificElementFromWithinListWithScrollDown(MobileTestObject elementsList, String expectedText){
		try {



			String actualText = ""
			boolean found = false
			String xpath = elementsList.mobileLocator
			AppiumDriver<?> driver=getCurrentSessionMobileDriver()
			while (true) {
				List<MobileElement> elements = driver.findElementsByXPath(xpath)
				for (MobileElement element : elements) {
					System.out.println ("Text of element is " + element.getText())
					actualText = element.getText().trim()
					if (actualText.equalsIgnoreCase(expectedText)) {
						found = true
						element.click()
						break
					}
				}
				if (found == true) {
					break
				}
				else {
					ScrollDown()
				}
			}
		}
		catch (Exception e) {
			KeywordUtil.markFailed("Object " + elementsList.getObjectId() + " is not present")
		}
	}

	/**
	 * \Method to select a specific element from a list with right to left swipe
	 * @param elementsList
	 * @param expectedText
	 * @return
	 */
	@Keyword
	def selectSpecificElementFromWithinListWithBackwardsSwipe(MobileTestObject elementsList, String expectedText){
		try {



			String actualText = ""
			boolean found = false
			String xpath = elementsList.mobileLocator
			AppiumDriver<?> driver=getCurrentSessionMobileDriver()
			while (true) {
				List<MobileElement> elements = driver.findElementsByXPath(xpath)
				for (MobileElement element : elements) {
					System.out.println ("Text of element is " + element.getText())
					actualText = element.getText().trim()
					if (actualText.equalsIgnoreCase(expectedText)) {
						found = true
						element.click()
						break
					}
				}
				if (found == true) {
					break
				}
				else {
					dynamicHorizontalBackwardsSwipe(createTestObjectOutOfList(elements,xpath))
				}
			}
		}
		catch (Exception e) {
			KeywordUtil.markFailed("Object " + elementsList.getObjectId() + " is not present")
		}
	}
}