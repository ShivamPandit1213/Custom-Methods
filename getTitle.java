	public static String getTitle(WebDriver driver) throws Exception {
//		String windowName = driver.getWindowHandle();
//		System.out.println("Parent window name: "+windowName);
		String parentWindow = driver.getTitle();
		System.out.println("Parent page title is: " + parentWindow);
		return parentWindow;
	}
