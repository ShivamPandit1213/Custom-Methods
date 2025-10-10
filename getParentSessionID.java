	static String parentWindowSessionId;
	public static String getWindowHandle(WebDriver driver) throws Throwable {
		// Copy Parent Window Session
		String parentWindowSessionId = driver.getWindowHandle();
		return parentWindowSessionId; // Return Parent Window Session Id
	}
