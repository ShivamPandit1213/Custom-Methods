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
