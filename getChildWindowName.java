	public static String getChildWindowName(WebDriver driver, String parentWindow) throws Throwable {
//		Set<String> sessionId = driver.getWindowHandles();
		String childName = null;
//		System.out.println("All window sessionId: "+sessionId);
		Set<String> allWindows = driver.getWindowHandles();
		for (String newChild : allWindows) {
			if (!newChild.equals(parentWindow)) {
				driver = driver.switchTo().window(newChild);
				childName = getTitle(driver);
				System.out.println("\nChild Window Name: " + driver);
				break;
			}
		}
		return childName;
	}

_________________________________________________________________________________________

		public WebDriver getWindowHandles(String parentWindowSessionId, String toClickOnLocator) throws Throwable {
		WebElement elementTriggerWindow = driver.findElement(By.xpath(toClickOnLocator));
		action.moveToElement(elementTriggerWindow);
		elementTriggerWindow.click();

		System.out.println("\nSwitch to new window - LogIn (Child Window)");
		// new Window Launched - with Log-In Form
		Set<String> sessionIds = driver.getWindowHandles();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // Ensure new window has opened
		System.out.println("Session Ids : " + sessionIds);

		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(parentWindowSessionId)) {
				driver.switchTo().window(windowHandle);
				System.out.println("Switched to new window with session id: " + windowHandle);
			}
		}
		return driver;
	}
