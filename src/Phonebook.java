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
        if (!commandString.isEmpty()) {
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
        commandString = scanner.nextLine();
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
            System.out.println();
            System.out.println("-- " + iEntry.codeName);
            System.out.println("-- " + iEntry.number);
            System.out.println("-- " + iEntry.notes);
            return;
        }
    }

    System.out.println("** No entry with code " + codeName);
}

private static void listAllEntries() {
    for (Entry iEntry : entries) {
        System.out.println();
        System.out.println("-- " + iEntry.codeName);
        System.out.println("-- " + iEntry.number);
        System.out.println("-- " + iEntry.notes);
    }
}

private static void loadPhoneBook() {
        /*File file = new File(System.getProperty("user.dir") + "/PhoneBook.dir");

        if (!file.exists()) {
            try {
                file.createNewFile();
                return;
            } catch (IOException exc) {
                System.exit(1);
            }
        }

        List<String> allLines = new ArrayList<>();

        try {
            allLines = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/PhoneBook.dir"));
        } catch (IOException exc) {
            System.exit(2);
        }

        for (String iString : allLines) {
            List<String> strings = iString.split(' ');
        }*/
}

private static void savePhoneBook() {

}
}
