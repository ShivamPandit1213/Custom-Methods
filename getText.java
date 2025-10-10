	public static String getText(WebDriver driver, String locator) {
		WebElement locatorWeb = driver.findElement(By.xpath(locator));
		String text = locatorWeb.getText();
		System.out.println("Attribute value_thread: " + text);
//		if (text.equals(null)) {
//			driver.findElement(By.xpath("//label[text()='Email ID / Username']"));
//		}
		return text;
	}
