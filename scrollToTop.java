	public void scrollToTop(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll to top
		js.executeScript("window.scrollTo(0, 0);");
	}
