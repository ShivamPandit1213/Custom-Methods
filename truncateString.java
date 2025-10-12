	public String truncateString(int prefixToBeRemoved, int suffixToBeStored, String stringToBeTruncate) {
		// Removes the first 3 characters
		String afterRemovePrefix = stringToBeTruncate.substring(prefixToBeRemoved);
		System.out.println("\nGiven String : " + stringToBeTruncate);
		System.out.println("Given String length : " + stringToBeTruncate.length());
		System.out.println("Removed digits " + prefixToBeRemoved + " from starting, In String : " + afterRemovePrefix); // After
																														// 2261
		// Used for store Prefix value - in starting
		System.out.println("After removing prefix value from String length : " + afterRemovePrefix.length());
		string = afterRemovePrefix.length() > suffixToBeStored ? afterRemovePrefix.substring(0, suffixToBeStored)
				: afterRemovePrefix;
		// String Character store from String - After character count complete, rest
		// character removed
		System.out.println("\nBefore Remove Suffix : " + afterRemovePrefix);// Final String : Showing1to50of2261
		System.out.println("After Remove Suffix : " + string); // Final String : 18
		System.out.println("After Remove Suffix length : " + string.length());
		return string;
	}
