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
