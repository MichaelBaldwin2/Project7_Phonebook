import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phonebook {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Entry> entries = new ArrayList<Entry>();

    public static void main(String[] args) {
        loadPhoneBook();

        String commandString = "";
        System.out.println("Codes are entered as 1 to 8 characters.");
        System.out.println("Use \"e\" for enter, \"f\" for find, \"l\" for list, \"q\" for quit.");

        while (!commandString.equals("q")) {
            commandString = scanner.nextLine();

            switch (commandString) {
                case "e":
                    addNewEntry(commandString.substring(2));
                    break;
                case "f":
                    findEntry(scanner.next());
                    break;
                case "l":
                    listAllEntries();
                    break;
                case "q":
                    //Do nothing, the while loop will quit
                    break;
            }
        }

        savePhoneBook();
    }

    private static void addNewEntry(String codeName) {
        System.out.println("Enter number: ");
        String number = scanner.next();
        System.out.println("Enter notes: ");
        String notes = scanner.next();
        entries.add(new Entry(codeName, number, notes));
    }

    private static void findEntry(String name) {

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
