package PublicMethods;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PublicMethods {
	WebDriver driver;
	WebElement element;
	Actions action;
	String string;
	WebDriverWait wait;

	// Constructor to accept WebDriver
	public PublicMethods(WebDriver driver) {
		this.driver = driver;
		this.action = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
	}
---------------------------------------------------------------------------------------------------------
// 1. Parameterized method (Custom prefix)
	public File getScreenshot(String fileNamePrefix) throws IOException {
		File screenshotDir = new File("src/test/resources/screenshots");
		if (!screenshotDir.exists()) {
			screenshotDir.mkdirs();
			System.out.println("Screenshot folder created.");
		}

		// Fallback just in case someone passes a null value
		if (fileNamePrefix == null) {
			fileNamePrefix = "Screenshot_";
		}

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		// Use the parameterized prefix here
		File destination = new File(screenshotDir, fileNamePrefix + timestamp + ".png");
		
		FileUtils.copyFile(source, destination);
		System.out.println("\nScreenshot captured: " + destination);
		return destination;
	}

	// 2. Overloaded method (Default behavior)
	public File getScreenshot() throws IOException {
		// Calls the main method and passes the default prefix
		return getScreenshot("Screenshot_"); 
	}
	public WebElement actionToPerform(WebDriver driver, String locator) throws Throwable {
		element = driver.findElement(By.xpath(locator));
		Thread.sleep(2000);
		return element;
	}
---------------------------------------------------------------------------------------------------------
		public void scrollToTop(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll to top
		js.executeScript("window.scrollTo(0, 0);");
	}

	public void scrollToBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll to bottom
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	public void scrollToElement(String element) {
		WebElement scroll = driver.findElement(By.xpath(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll element into center
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", scroll);
	}
	
	public WebElement moveToElement(WebDriver driver, String locator) throws Throwable {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		getScreenshot();
		WebElement element = driver.findElement(By.xpath(locator));
		action.moveToElement(element).perform();
		Thread.sleep(2000);
		getScreenshot();
		System.out.println("Focus moved to desired element");
		return element;
	}

	public String waitUnitlElementVisible(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		if (element.isDisplayed()) {
			System.out.println("Element is visible.");
		} else {
			System.out.println("Element is not visible.");
		}
		return locator;
	}

	public void verifyElementVisible(WebDriver driver, String locatorVariable)
			throws NullPointerException, Throwable {
		// Storing value of "locatorValue" into variable "elementToVerify"
		WebElement elementToVerify = driver.findElement(By.xpath(locatorVariable));
		// WebElement elementToVerify is used to access method
		if (elementToVerify.isDisplayed()) {
			// elementToVerify.isDisplayed() - [true/false]
			System.out.println(elementToVerify.getText() + " is visible :" + elementToVerify.isDisplayed());
		} else {
			System.err.println("Element" + " is not visible.");
		}
	}

	public void zoomOut(int zoomPercentage) throws InterruptedException {
		// Zoom out by executing JavaScript
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom = '" + zoomPercentage + "%';"); // Set zoom level to 80%
		System.out.println("Zoom out " + zoomPercentage + " is performed by size.");
		Thread.sleep(2000);
	}

	public void zoomIn(int zoomPercentage) throws InterruptedException {
		Thread.sleep(2000);
		// Zoom in by executing JavaScript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom = '" + zoomPercentage + "%';");
		// Set zoom level to the specified percentage
		System.out.println("Zoom in is performed to " + zoomPercentage + "%.");
		Thread.sleep(2000);
	}

	public int totalRowCount(String locator) {
		// Find element available according to given path
		List<WebElement> rowCount = driver.findElements(By.xpath(locator));
		int totalRowCount = rowCount.size();
		// Get Total Column count through [tag-sibling] element.size();
		System.out.println("Total Column Count : " + totalRowCount);
		return totalRowCount;
	}

	public int totalElementCount(String locator) {
		// Find element available according to given path
		List<WebElement> columnCount = driver.findElements(By.xpath(locator));
		int totalColumnCount = columnCount.size();
		// Get Total Column count through [tag-sibling] element.size();
		System.out.println("Total Elements Count : " + totalColumnCount);
		return totalColumnCount;
	}

	public String replaceSpace(String stringSpace) {
		System.out.println("\nString given : " + stringSpace);
		if (stringSpace.contains(" ")) {
			string = stringSpace.replace(" ", "");
			System.out.println("\nString after remove space : " + string);
		}
		return string;
	}

	public String replaceComma(String replaceComma) {
		System.out.println("\nString given : " + replaceComma);
		if (replaceComma.contains(",")) {
			string = replaceComma.replace(",", "");
			System.out.println("\nString after remove comma : " + string);
		}
		return string;
	}

	public String replaceAlphabatesFromString(String stringAlphabatesString) {
		// Remove all alphabetic characters (a-z, A-Z)
		System.out.println("\nGiven String : " + stringAlphabatesString); // Original String: Showing1to50of2261
		string = stringAlphabatesString.replaceAll("[a-zA-Z]", "");
		// Print the result
		System.out.println("\nAfter remove all alphabetic characters : " + string); // After remove all alphabetic
		System.out.println("\nAfter remove all alphabetic characters length : " + string.length()); // characters:
																									// 1502261
		return string;
	}

	public String truncateString(int prefixToBeRemoved, int suffixToBeStored, String stringToBeTruncate) {
		// Removes the first 3 characters
		String afterRemovePrefix = stringToBeTruncate.substring(prefixToBeRemoved);
		System.out.println("\nGiven String : " + stringToBeTruncate);
		System.out.println("Given String length : " + stringToBeTruncate.length());
		System.out.println("Removed digits " + prefixToBeRemoved + " from starting, In String : " + afterRemovePrefix); // After
																														// 2261
		// Used for store Prefix value - in starting
		System.out.println("After removing prefix value from String length : " + afterRemovePrefix.length());
		string = afterRemovePrefix.length() > suffixToBeStored ? afterRemovePrefix.substring(0, suffixToBeStored)
				: afterRemovePrefix;
		// String Character store from String - After character count complete, rest
		// character removed
		System.out.println("\nBefore Remove Suffix : " + afterRemovePrefix);// Final String : Showing1to50of2261
		System.out.println("After Remove Suffix : " + string); // Final String : 18
		System.out.println("After Remove Suffix length : " + string.length());
		return string;
	}

	public String replaceSpecialCharacters(String stringSpecialCharacters) {
		System.out.println("\nBefore remove Special Characters : " + stringSpecialCharacters);
		System.out.println("\nBefore remove Special Characters length : " + stringSpecialCharacters.length());
		// This will retain only alphanumeric characters (a-z, A-Z, 0-9) and space
		String string = stringSpecialCharacters.replaceAll("[^a-zA-Z0-9 ]", "");
		System.out.println("After remove Special Characters : " + string);
		return string;
	}

	public int stringConvertToInteger(String stringToConvert) {
		int convertedInteger = Integer.valueOf(stringToConvert);
		System.out.println("\nAfter convert String into Integer : " + convertedInteger);
		return convertedInteger;
	}

	public void verifyTextIsInteger(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		String text = element.getText();
		if (NumberUtils.isDigits(text)) {
			System.out.println("Copied value text '" + text + "' is digit number.");
		} else {
			System.out.println("Copied value text '" + text + "' is not digit number.");
		}
	}

	public void fileExistThenDelete(String filePathInSystem, String fileName) {
		// Define the path to the Downloads folder and the file name
//        String fileLocation = System.getProperty("user.home") + "/Downloads/"; // Use appropriate path for other OS
//        String fileName = "Agent_Trr_Data.csv"; // The expected file name

		// Create a File object
		File file = new File(filePathInSystem + fileName);
		// Check if the file exists
		if (file.exists()) {
			// Attempt to delete the file
			if (file.delete()) {
				System.out.println("\nFile '" + fileName + "' is deleted successfully.");
			} else {
				System.out.println("Failed to delete the file.");
			}
		} else {
			System.err.println("\nFile '" + fileName + "' does not exist.");
		}
	}

	public void verifyFileExistAtLocation(String filePathInSystem, String fileName) {
		File file = new File(filePathInSystem+fileName);
		if (!file.exists()) {
			// Print File does not exist at location.
			System.err.println(fileName+" does not exist at location "+filePathInSystem+".");
		} else {
			// Print File exists at given Path.
			System.out.println("File exists on location : " + filePathInSystem);
		}
	}
	
	public String fileUploadOnWeb(String filePathInSystem, String fileName, String inputLocator) throws Throwable {
		File file = new File(filePathInSystem+fileName);
		if (!file.exists()) {
			// Print File does not exist at location.
			System.err.println(fileName+" does not exist at location : "+filePathInSystem);
			Thread.sleep(2000);
			getScreenshot();
		} else {
			// Print File exists at given Path.
			System.out.println("File exists on location : " + filePathInSystem);
			// Select tagType - input
			WebElement element = driver.findElement(By.xpath(inputLocator));
			element.sendKeys(filePathInSystem+fileName);
			System.out.println("File uploaded successfully!");
			Thread.sleep(10000); // Average time for file Upload
			getScreenshot();
		}
		return fileName;
	}
	
	public void verifyFileUploaded(String locator, String fileName) {
		// div[@class='doc_name']
		WebElement uploadedLocator = driver.findElement(By.xpath(locator));
		String uploadedFileName = uploadedLocator.getText();
		System.out.println("Uploaded File Name : "+uploadedFileName);
		System.out.println("File Name : "+fileName);
		Assert.assertEquals(fileName, uploadedFileName, "File Name does not match");
		
		//div[text()='file-example_PDF_1MB.pdf'] -> FileName - file-example_PDF_1MB.pdf
		String locator2 = "//div[text()='"+fileName+"']";
		WebElement element = driver.findElement(By.xpath(locator2));
		Assert.assertTrue(element.isDisplayed(), "Element is not visible");
		
	}
	
	String parentWindowSessionId;
	public String windowHandleMethod() throws Throwable {
		// Copy Parent Window Session
		parentWindowSessionId = driver.getWindowHandle();
		System.out.println("\nParent window session id : " + parentWindowSessionId);
		getScreenshot();
		return parentWindowSessionId; // Return Parent Window Session Id
	}

	public WebDriver windowHandlesMethod(String parentWindowSessionId, String toClickOnLocator) throws Throwable {
		WebElement elementTriggerWindow = driver.findElement(By.xpath(toClickOnLocator));
		action.moveToElement(elementTriggerWindow);
		elementTriggerWindow.click();

		System.out.println("\nSwitch to new window - LogIn (Child Window)");
		// new Window Launched - with Log-In Form
		Set<String> sessionIds = driver.getWindowHandles();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // Ensure new window has opened
		System.out.println("Session Ids : " + sessionIds);

		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(parentWindowSessionId)) {
				driver.switchTo().window(windowHandle);
				System.out.println("Switched to new window with session id: " + windowHandle);
			}
		}
		return driver;
	}
	
//	String fileName = "Test3";
//	String fieldLocator = "//input[@placeholder='Name your File']";
	public void singleEditRecordCreate(String fileName, String fieldLocator) throws Throwable {
		System.out.println("\nfileName : "+fileName);
		System.out.println("fieldLocator : "+fieldLocator);
		element = moveToElement(driver, fieldLocator);
		element.sendKeys(fileName);
		getScreenshot();
		element.sendKeys(Keys.ENTER);
		System.out.println("Created file name : "+fileName);
		//return fileName;
	}
}
