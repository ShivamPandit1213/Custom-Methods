/**
	 * METHOD 1: The "Worker" Method (Parameterized)
	 * Captures a screenshot and saves it with a custom name.
	 * * @param fileNamePrefix A custom string to prepend to the file name (e.g., "LoginError_").
	 * @return The File object representing the saved screenshot.
	 * @throws IOException If there is an issue writing the file to the disk.
	 */
	public File getScreenshot(String fileNamePrefix) throws IOException {
		
		// 1. Define the target directory where screenshots will be saved
		File screenshotDir = new File("src/test/resources/screenshots");
		
		// 2. Check if directory exists. If not, create it and any missing parent folders.
		if (!screenshotDir.exists()) {
			screenshotDir.mkdirs();
			System.out.println("Screenshot folder created.");
		}

		// 3. Defensive Check: If another script accidentally passes 'null', use a default.
		if (fileNamePrefix == null) {
			fileNamePrefix = "Screenshot_";
		}

		// 4. Generate a unique timestamp to ensure old screenshots aren't overwritten
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
		// 5. Tell Selenium to take the picture and store it in system memory (temp file)
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		// 6. Combine the directory, custom prefix, timestamp, and .png extension into a final path
		File destination = new File(screenshotDir, fileNamePrefix + timestamp + ".png");
		
		// 7. Move the image from temporary memory to your permanent project folder
		FileUtils.copyFile(source, destination);
		
		// 8. Print the location to the console and return the file object
		System.out.println("\nScreenshot captured: " + destination);
		return destination;
	}

	/**
	 * METHOD 2: The "Convenience" Method (Overloaded)
	 * Captures a screenshot using a default naming convention.
	 * * @return The File object representing the saved screenshot.
	 * @throws IOException If there is an issue writing the file to the disk.
	 */
	public File getScreenshot() throws IOException {
		// Acts as a shortcut: immediately calls Method 1 and hands it a default prefix
		return getScreenshot("Screenshot_"); 
	}
