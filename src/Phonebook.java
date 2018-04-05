import java.io.*;
import java.util.Scanner;

public class Phonebook {
private static Scanner scanner = new Scanner(System.in);
private static Entry[] entries;
private static int entryIndex;

static {
    entries = new Entry[200];
    entryIndex = 0;
}

public static void main(String[] args) {
    String commandString;

    commandString = "";
    loadPhoneBook();
    System.out.println("Codes are entered as 1 to 8 characters.");
    System.out.println("Use \"e\" for enter, \"f\" for find, \"l\" for list, \"q\" for quit.");

    while (!commandString.equals("q")) {
        System.out.print("Command: ");
        commandString = scanner.nextLine().toLowerCase();

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

    for (Entry iEntry : entries) {
        if (iEntry != null && iEntry.codeName.equals(codeName)) {
            //We are going to update the entry
            System.out.print("Enter number: ");
            number = scanner.nextLine();
            System.out.print("Enter notes: ");
            notes = scanner.nextLine();
            iEntry.number = number;
            iEntry.notes = notes;
            System.out.println();
            return;
        }
    }

    if (entryIndex > 200) {
        System.out.println("Can't add any more entries due to the 200 limit project constraints!");
        return;
    }
    System.out.print("Enter number: ");
    number = scanner.nextLine();
    System.out.print("Enter notes: ");
    notes = scanner.nextLine();
    entries[entryIndex++] = new Entry(codeName, number, notes);
    System.out.println();
}

private static void findEntry(String codeName) {
    for (Entry iEntry : entries) {
        if (iEntry != null && iEntry.codeName.equals(codeName)) {
            System.out.println(iEntry);
            return;
        }
    }

    System.out.println("** No entry with code " + codeName);
}

private static void listAllEntries() {
    for (Entry iEntry : entries) {
        if (iEntry != null) {
            System.out.println(iEntry);
            System.out.println();
        }
    }
}

private static void savePhoneBook() {
    File file = new File(System.getProperty("user.dir") + "/PhoneBook.dir");

    if (!file.exists()) {
        try {
            if (!file.createNewFile()) {
                System.out.println("File already exists!");
            }
        } catch (IOException exc) {
            System.out.println("Failed to create a new phone book file.\n" + exc);
            System.exit(1);
        }
    }

    try (PrintStream stream = new PrintStream(file)) {
        for (Entry iEntry : entries) {
            if (iEntry != null) {
                stream.print(iEntry);
                stream.println();
            }
        }
    } catch (FileNotFoundException exc) {
        System.out.println("Failed to find the file. " + exc);
        System.exit(1);
    }
}

private static void loadPhoneBook() {
    String codeName, number, notes;
    File file = new File(System.getProperty("user.dir") + "/PhoneBook.dir");

    if (!file.exists())
        return;

    try (Scanner scanner = new Scanner(file)) {
        while (scanner.hasNext()) {
            if (entryIndex > 200) {
                System.out.println("Ignoring rhe rest of the file due to the 200 limit project constraints!");
                break;
            }

            codeName = scanner.nextLine().substring(3);
            number = scanner.nextLine().substring(3);
            notes = scanner.nextLine().substring(3);
            entries[entryIndex++] = new Entry(codeName, number, notes);
        }
    } catch (FileNotFoundException exc) {
        System.out.println("Failed to find the file.\n" + exc);
    }
}
}
