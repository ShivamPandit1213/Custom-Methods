/**
	 * All-in-one utility method: Reads a locator string from the properties file by its key,
	 * parses its prefix (if any), and returns the appropriate Selenium 'By' object.
	 * * Supported prefixes: id:, css:, name:, class:, xpath:
	 * Default fallback: XPath (if no prefix is provided)
	 *
	 * @param locatorKey The name of the variable in the properties file (e.g., "searchBox")
	 * @return A Selenium By object ready to be used with driver.findElement()
	 */
	public By getLocator(String locatorKey) {
		
		// 1. Fetch the raw string value associated with the key from locator.properties
		// Example: If locatorKey is "searchBox", locatorValue might be "name:q"
		String locatorValue = LocatorReader.getLocator(locatorKey);

		// Fail fast: Stop the test immediately if the key doesn't exist in the file
		if (locatorValue == null || locatorValue.isEmpty()) {
			throw new IllegalArgumentException("Locator key '" + locatorKey + "' not found or is empty in properties file!");
		}

		// 2. Identify the locator strategy by checking its prefix.
		// We use substring() to strip the prefix away so Selenium only gets the pure, valid locator.
		if (locatorValue.startsWith("id:")) {
			// Strip the first 3 characters ("id:") and return the rest as By.id
			return By.id(locatorValue.substring(3));
			
		} else if (locatorValue.startsWith("css:")) {
			// Strip the first 4 characters ("css:") and return the rest as By.cssSelector
			return By.cssSelector(locatorValue.substring(4));
			
		} else if (locatorValue.startsWith("name:")) {
			// Strip the first 5 characters ("name:") and return the rest as By.name
			return By.name(locatorValue.substring(5));
			
		} else if (locatorValue.startsWith("class:")) {
			// Strip the first 6 characters ("class:") and return the rest as By.className
			return By.className(locatorValue.substring(6));
			
		} else if (locatorValue.startsWith("xpath:")) {
			// Strip the first 6 characters ("xpath:") and return the rest as By.xpath
			return By.xpath(locatorValue.substring(6)); 
			
		} else {
			// 3. DEFAULT BEHAVIOR: If no prefix was typed in the properties file, 
			// assume the entire string is a standard XPath.
			return By.xpath(locatorValue);
		}
	}
