	public String replaceSpecialCharacters(String stringSpecialCharacters) {
		System.out.println("\nBefore remove Special Characters : " + stringSpecialCharacters);
		System.out.println("\nBefore remove Special Characters length : " + stringSpecialCharacters.length());
		// This will retain only alphanumeric characters (a-z, A-Z, 0-9) and space
		String string = stringSpecialCharacters.replaceAll("[^a-zA-Z0-9 ]", "");
		System.out.println("After remove Special Characters : " + string);
		return string;
	}
