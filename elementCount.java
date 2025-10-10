	public static int elementCount(WebDriver driver, String locator) {
		List<WebElement> list = driver.findElements(By.xpath(locator));
		int count = list.size();
		// System.out.println("Total jobs count: " + count);
		return count;
	}
