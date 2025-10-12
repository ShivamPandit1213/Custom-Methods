	public void zoomIn(int zoomPercentage) throws InterruptedException {
		Thread.sleep(2000);
		// Zoom in by executing JavaScript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom = '" + zoomPercentage + "%';");
		// Set zoom level to the specified percentage
		System.out.println("Zoom in is performed to " + zoomPercentage + "%.");
		Thread.sleep(2000);
	}
