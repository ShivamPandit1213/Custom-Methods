	public static void handleSlider(WebDriver driver, String element, int slidePixel) throws IOException, Throwable {
		WebElement slider = driver.findElement(By.xpath(element));
		getScreenshot(driver);
		// Create Actions class
		Actions action = new Actions(driver);
		action.clickAndHold(slider).moveByOffset(slidePixel, 0).release().perform(); // move 30px left
		Thread.sleep(2000);
//        // Move slider by offset (pixels)
//        action.clickAndHold(slider).moveByOffset(50, 0).release().perform(); // move 50px right
//        Thread.sleep(2000);
//        action.clickAndHold(slider).moveByOffset(-30, 0).release().perform(); // move 30px left

//        int width = slider.getSize().width;
//        int targetX = (int)(width * 0.7); // 70%
//        action.clickAndHold(slider).moveByOffset(targetX, 0).release().perform();
	}
