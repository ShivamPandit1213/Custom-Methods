	public void scrollToElement(String element) {
		WebElement scroll = driver.findElement(By.xpath(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll element into center
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", scroll);
	}
