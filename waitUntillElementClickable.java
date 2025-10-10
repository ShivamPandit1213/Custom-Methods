	public static WebElement waitUntillElementClickable(WebDriver driver, String locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		locatorWeb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		if (locatorWeb.isDisplayed()) {
			System.out.println("Element is visible.");
			if (locatorWeb.isEnabled()) {
				System.out.println("Element is clickable.");
			} else {
				System.err.println("Element is not clickable.");
			}
		} else {
			System.err.println("Element is not visible.");
		}
		return locatorWeb;
	}
