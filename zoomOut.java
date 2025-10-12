	public void zoomOut(int zoomPercentage) throws InterruptedException {
		// Zoom out by executing JavaScript
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom = '" + zoomPercentage + "%';"); // Set zoom level to 80%
		System.out.println("Zoom out " + zoomPercentage + " is performed by size.");
		Thread.sleep(2000);
	}
