	public static String extractMiddleDigits(String text, int leftRemove, int rightRemove) {
	    // Safety check
	    if (text.length() < (leftRemove + rightRemove)) {
	        throw new IllegalArgumentException("Not enough digits to truncate.");
	    }
	    // Truncate left and right
	    String result = text.substring(leftRemove, text.length() - rightRemove);
	    System.out.println("Truncated digits: " + result);
	    return result;
	}
