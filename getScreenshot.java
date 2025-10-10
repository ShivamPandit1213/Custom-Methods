	public static File getScreenshot(WebDriver driver) throws IOException {
		File fileLocation = null;
		File flName = new File("./Screenshots");
		if (!flName.exists()) {
			flName.mkdirs(); // Create directory if it doesn't exist // Creates directory if not exists
			System.out.println("New Folder Created");
		}
		String timeFormat = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
		TakesScreenshot sc = (TakesScreenshot) driver;
		File fileType = sc.getScreenshotAs(OutputType.FILE);
		fileLocation = new File("src/test/resources/screenshots/Screenshot" + timeFormat + ".png");
		FileUtils.copyFile(fileType, fileLocation);
		return fileLocation;
	}
