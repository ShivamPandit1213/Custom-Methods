	// ===== GET CHILD WINDOW HANDLING AND SWITCH TO IT =====
	public static String switchToChildWindow(WebDriver driver, String parentWindow) {
	    Set<String> allWindows = driver.getWindowHandles();
	    for (String window : allWindows) {
	        // Check if it is not parent window
	        if (!window.equals(parentWindow)) {
	            driver.switchTo().window(window);
	            System.out.println("🔄 Switched to child window: " + driver.getTitle());
	            return window; // return immediately when child found
	        }
	    }

	    // If no child window found
	    System.err.println("⚠️ No child window found.");
	    return null;
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
