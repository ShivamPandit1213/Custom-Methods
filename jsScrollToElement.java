	public void scrollToElement(String element) {
		WebElement scroll = driver.findElement(By.xpath(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll element into center
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", scroll);
	}
-------------------------------------------------------------------------------------------------------------------
	public void scrollToCenter(String locator) {
		// 1. Find the element using the String locator
	    WebElement element = driver.findElement(By.xpath(locator));
	    
	    // 2. Scroll to it
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}
-------------------------------------------------------------------------------------------------------------------
/**
 * Custom method to hover over a web element.
 * @param xpath The string locator of the element to hover over.
 */
public void hoverOverElement(String xpath) {
    WebElement element = driver.findElement(By.xpath(xpath));
    Actions action = new Actions(driver);
    action.moveToElement(element).perform();
    System.out.println("Hovered over element: " + xpath);
}
