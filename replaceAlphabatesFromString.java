	public String replaceAlphabatesFromString(String stringAlphabatesString) {
		// Remove all alphabetic characters (a-z, A-Z)
		System.out.println("\nGiven String : " + stringAlphabatesString); // Original String: Showing1to50of2261
		string = stringAlphabatesString.replaceAll("[a-zA-Z]", "");
		// Print the result
		System.out.println("\nAfter remove all alphabetic characters : " + string); // After remove all alphabetic
		System.out.println("\nAfter remove all alphabetic characters length : " + string.length()); // characters:
																									// 1502261
		return string;
	}
