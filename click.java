	public static WebElement click(WebDriver driver, String locator) throws Throwable {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		locatorWeb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		if (locatorWeb.isDisplayed()) {
			getScreenshot(driver);
			locatorWeb.click();
			System.out.println("Login button selected");
		} else {
			driver.navigate().refresh();
			Thread.sleep(25);
			getScreenshot(driver);
			locatorWeb.click();
			System.out.println("Login button selected");
		}
		return locatorWeb;
	}
