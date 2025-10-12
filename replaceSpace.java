	public String replaceSpace(String stringSpace) {
		System.out.println("\nString given : " + stringSpace);
		if (stringSpace.contains(" ")) {
			string = stringSpace.replace(" ", "");
			System.out.println("\nString after remove space : " + string);
		}
		return string;
	}
