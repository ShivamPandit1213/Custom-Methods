	public static WebElement waitForElementVisible(WebDriver driver, String locator) throws Exception {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		locatorWeb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		if (locatorWeb.isDisplayed()) {
			String text = locatorWeb.getText();
			if (!text.equals(null)) {
				System.out.println(text+" visible on current page");
			} else {
			System.out.println("Element visible: " + locatorWeb);
			getScreenshot(driver);
		} 
