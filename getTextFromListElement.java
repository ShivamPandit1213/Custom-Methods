	public static String getTextFromListElement(WebDriver driver, String xpath, int index) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    List<WebElement> elements = driver.findElements(By.xpath(xpath));
	    wait.until(ExpectedConditions.visibilityOfAllElements(elements));

	    try {
	        return elements.get(index).getText();
	    } catch (StaleElementReferenceException e) {
	        // Refetch on stale
	        elements = driver.findElements(By.xpath(xpath));
	        return elements.get(index).getText();
	    }
	}
