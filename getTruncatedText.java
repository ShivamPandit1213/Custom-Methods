// "ID: #AB123456789"
  
// After removing special characters: "IDAB123456789"
// After removing letters: "123456789"
// Suppose digitLengthToBeRemoved = 3 → substring from index 3 → "456789"
// Convert to integer → 456789

public int getTruncatedText(WebDriver driver, int i, int digitLengthToBeRemoved, String locator) throws Throwable {
		String text;
		// WebDriver driver = LaunchBrowser.chromelaunch();
		// int i = digitLengthToBeRemoved;
		List<WebElement> list = driver.findElements(By.xpath(locator));
		// int j = i+1;
		text = list.get(i).getText();// in get method i+1 because indexing start from 0
		System.out.println("Element " + (i + 1) + ": " + text);
		text = text.replaceAll("[^a-zA-Z0-9]", "");// Replacing special character
		System.out.println("After replace special character: " + text);
		text = text.replaceAll("[a-zA-Z]", "");
		System.out.println("After replace alphabatic character: " + text);
		text = text.substring(digitLengthToBeRemoved);
		System.out.println("Final String: " + text);
		int length = Integer.valueOf(text);
		System.out.println("Final Integer: " + length);
		return length;
	}

String text; // Declares a String variable named 'text' to hold the text content from the web element.

// WebDriver driver = LaunchBrowser.chromelaunch();
// Commented-out line that presumably initializes the WebDriver by launching Chrome browser.
// Likely from a custom method named `chromelaunch()` inside a class called `LaunchBrowser`.

// int i = digitLengthToBeRemoved;
// Commented-out line that declares and initializes a variable 'i'.
// It looks like 'digitLengthToBeRemoved' is being used as an index for list access and substring later.

List<WebElement> list = driver.findElements(By.xpath(locator));
// Finds all web elements matching the given XPath 'locator' and stores them in a List called 'list'.

// int j = i + 1;
// Commented-out line: would store the value of i + 1 in variable j, likely unused.
// Maybe used for debugging or indexing display.

text = list.get(i).getText(); // in get method i+1 because indexing start from 0
// Retrieves the text of the i-th element in the list.
// The comment says "i+1" because user-facing indices start from 1, but list indices start from 0.
// Note: the actual code uses `get(i)` correctly — no need to write `i+1` here.

System.out.println("Element " + (i + 1) + ": " + text);
// Prints which element was retrieved and its text content.
// Adds 1 to 'i' in the message to make it user-friendly (humans count from 1).

text = text.replaceAll("[^a-zA-Z0-9]", ""); // Replacing special character
// Removes all **non-alphanumeric characters** from the string.
// `[^a-zA-Z0-9]` matches anything that's not a letter or digit.

System.out.println("After replace special character: " + text);
// Prints the text after special characters have been removed.

text = text.replaceAll("[a-zA-Z]", "");
// Removes all **alphabetic characters** from the string (only digits remain).

System.out.println("After replace alphabatic character: " + text);
// Prints the text after removing all letters, leaving only digits.

text = text.substring(digitLengthToBeRemoved);
// Cuts off the first `digitLengthToBeRemoved` digits from the beginning of the string.
// `substring(n)` returns the string from index `n` to the end.

System.out.println("Final String: " + text);
// Prints the final string after substring operation — should contain only the required digits.

int length = Integer.valueOf(text);
// Converts the final string into an integer and stores it in 'length'.

System.out.println("Final Integer: " + length);
// Prints the final integer value.

return length;
// Returns the integer — probably the final result of a method.
