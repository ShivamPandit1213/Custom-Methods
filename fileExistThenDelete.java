	public void fileExistThenDelete(String fileLocation, String fileName) {
		// Define the path to the Downloads folder and the file name
//        String fileLocation = System.getProperty("user.home") + "/Downloads/"; // Use appropriate path for other OS
//        String fileName = "Agent_Trr_Data.csv"; // The expected file name

		// Create a File object
		File file = new File(fileLocation + fileName);

		// Check if the file exists
		if (file.exists()) {
			// Attempt to delete the file
			if (file.delete()) {
				System.out.println("\nFile '" + fileName + "' is deleted successfully.");
			} else {
				System.out.println("Failed to delete the file.");
			}
		} else {
			System.err.println("\nFile '" + fileName + "' does not exist.");
		}
	}
