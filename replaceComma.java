	public String replaceComma(String replaceComma) {
		System.out.println("\nString given : " + replaceComma);
		if (replaceComma.contains(",")) {
			string = replaceComma.replace(",", "");
			System.out.println("\nString after remove comma : " + string);
		}
		return string;
	}
