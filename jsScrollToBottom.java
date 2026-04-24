public void jsScrollToBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll to bottom
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
