	public static void switchToWindow(WebDriver driver, String windowToSwitch) throws Throwable {
		Set<String> allWindows = driver.getWindowHandles();
		if (windowToSwitch.equals(allWindows)) {
			WebDriver newWindow = driver.switchTo().window(windowToSwitch);
			getTitle(driver);
			System.out.println("Window Name: " + newWindow);
		}
	}
