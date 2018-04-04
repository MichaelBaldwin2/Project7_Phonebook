import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phonebook {
private static Scanner scanner = new Scanner(System.in);
private static List<Entry> entries = new ArrayList<>();

public static void main(String[] args) {
	String commandString;

	commandString = "";
	loadPhoneBook();
	System.out.println("Codes are entered as 1 to 8 characters.");
	System.out.println("Use \"e\" for enter, \"f\" for find, \"l\" for list, \"q\" for quit.");

	while (!commandString.equals("q")) {
		commandString = scanner.nextLine();

		if (!commandString.isEmpty()) {
			if (commandString.length() > 8) {
				System.out.println("Codes have to be between 1 and 8 characters in length.");
				System.out.println("Use \"e\" for enter, \"f\" for find, \"l\" for list, \"q\" for quit.");
				continue;
			}

			switch (commandString.substring(0, 1)) {
				case "e":
					addNewEntry(commandString.substring(2));
					break;
				case "f":
					findEntry(commandString.substring(2));
					break;
				case "l":
					listAllEntries();
					break;
				case "q":
					//Do nothing, the while loop will quit
					break;
				default:
					System.out.println("Input was not recognized. Please try again.");
					System.out.println("Use \"e\" for enter, \"f\" for find, \"l\" for list, \"q\" for quit.");
					break;
			}
		}
	}

	savePhoneBook();
}

private static void addNewEntry(String codeName) {
	String number, notes;

	System.out.print("Enter number: ");
	number = scanner.nextLine();
	System.out.print("Enter notes: ");
	notes = scanner.nextLine();
	entries.add(new Entry(codeName, number, notes));
	System.out.println();
}

private static void findEntry(String codeName) {
	for (Entry iEntry : entries) {
		if (iEntry.codeName.equals(codeName)) {
			System.out.println(iEntry);
			return;
		}
	}

	System.out.println("** No entry with code " + codeName);
}

private static void listAllEntries() {
	for (Entry iEntry : entries) {
		System.out.println(iEntry);
	}
}

private static void loadPhoneBook() {
	File file = new File(System.getProperty("user.dir") + "/PhoneBook.dir");

	if (!file.exists())
		return;

	List<String> allLines = new ArrayList<>();

	try {
		allLines = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/PhoneBook.dir"));
	} catch (IOException exc) {
		System.out.println("Failed to read the phone book file.\n" + exc);
		System.exit(2);
	}

	for (String iString : allLines) {
		List<String> strings = iString.split(' ');
	}
}

private static void savePhoneBook() {
	File file = new File(System.getProperty("user.dir") + "/PhoneBook.dir");

	if (!file.exists()) {
		try {
			file.createNewFile();
		} catch (IOException exc) {
			System.out.println("Failed to create a new phone book file.\n" + exc);
			System.exit(1);
		}
	}

	Writer
}
}
