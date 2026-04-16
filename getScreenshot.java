/** Maximum Flexibility
Because both methods exist side-by-side, you give the person writing the test options without trapping them:
"I just need a quick picture:" They use getScreenshot(); (The second method handles it by providing the default name).
"I need to specifically label this major error:" They use getScreenshot("PaymentGatewayError_"); (The first method handles it directly).
/**
	 * METHOD 1: The "Worker" Method (Parameterized)
	 * Captures a screenshot and saves it with a custom name.
	 * * @param fileNamePrefix A custom string to prepend to the file name (e.g., "LoginError_").
	 * @return The File object representing the saved screenshot.
	 * @throws IOException If there is an issue writing the file to the disk.
	 */
	public File getScreenshot(String fileNamePrefix) throws IOException {
		
		File screenshotDir = new File("src/test/resources/screenshots");
		
		if (!screenshotDir.exists()) {
			/* * DEEP DIVE: mkdirs() vs mkdir()
			 * mkdirs() (plural) creates the "screenshots" folder PLUS any missing parent 
			 * folders (like "resources" or "test"). If we used mkdir() (singular) and the 
			 * "resources" folder didn't exist yet on a new machine, the code would crash.
			 */
			screenshotDir.mkdirs();
			System.out.println("Screenshot folder created.");
		}

		// Defensive Check: If another script accidentally passes 'null', use a default.
		if (fileNamePrefix == null) {
			fileNamePrefix = "Screenshot_";
		}

		/* * DEEP DIVE: Time Generation
		 * 1. Calendar.getInstance(): Calendar is an abstract class, so we can't use 'new Calendar()'. 
		 * This factory method gets a calendar initialized with the computer's current timezone and time.
		 * 2. .getTime(): Converts that calendar into a standard Java Date object.
		 * 3. SimpleDateFormat: Translates that raw Date object into a readable String 
		 * using the pattern provided (YearMonthDay_HourMinuteSecond) so files don't overwrite each other.
		 */
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
		/* * DEEP DIVE: Taking the Screenshot
		 * 1. (TakesScreenshot): This is "Type Casting". A standard WebDriver only knows how to 
		 * navigate and click. This tells Java "treat this driver like a camera for this one line."
		 * 2. OutputType.FILE: Tells Selenium to output the image as a physical file, 
		 * rather than raw binary code or a Base64 text string.
		 */
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		// Combine the directory, custom prefix, timestamp, and .png extension into a final path
		File destination = new File(screenshotDir, fileNamePrefix + timestamp + ".png");
		
		/* * DEEP DIVE: FileUtils.copyFile()
		 * Selenium initially saves screenshots in a hidden, temporary OS folder (which gets 
		 * deleted automatically by Windows/Mac later to save space). FileUtils safely duplicates 
		 * that temporary file into your permanent project directory before it disappears.
		 */
		FileUtils.copyFile(source, destination);
		
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
