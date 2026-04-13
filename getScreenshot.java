// 1. Parameterized method (Custom prefix)
	public File getScreenshot(String fileNamePrefix) throws IOException {
		File screenshotDir = new File("src/test/resources/screenshots");
		if (!screenshotDir.exists()) {
			screenshotDir.mkdirs();
			System.out.println("Screenshot folder created.");
		}

		// Fallback just in case someone passes a null value
		if (fileNamePrefix == null) {
			fileNamePrefix = "Screenshot_";
		}

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		// Use the parameterized prefix here
		File destination = new File(screenshotDir, fileNamePrefix + timestamp + ".png");
		
		FileUtils.copyFile(source, destination);
		System.out.println("\nScreenshot captured: " + destination);
		return destination;
	}

	// 2. Overloaded method (Default behavior)
	public File getScreenshot() throws IOException {
		// Calls the main method and passes the default prefix
		return getScreenshot("Screenshot_"); 
	}
