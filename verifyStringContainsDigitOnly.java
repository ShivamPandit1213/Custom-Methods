	public void verifyStringContainsDigitOnly(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		String text = element.getText();
		if (NumberUtils.isDigits(text)) {
			System.out.println("Copied value text '" + text + "' is digit number.");
		} else {
			System.out.println("Copied value text '" + text + "' is not digit number.");
		}
	}
