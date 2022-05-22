package SoftUni.Advanced.SetsAndMapsExercise;

import java.util.HashMap;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> phonebook = new HashMap<>();
        String contacts = scanner.nextLine();
        while (!contacts.equals("search")) {
            String[] contactInfo = contacts.split("-");
            String contact = contactInfo[0];
            String number = contactInfo[1];
            if (phonebook.containsKey(contact)) {
                phonebook.put(contact, number);
            } else {
                phonebook.put(contact, number);
            }
            contacts = scanner.nextLine();
        }
        String search = scanner.nextLine();
        while (!search.equals("stop")) {
            String name = search;
            if (phonebook.containsKey(name)) {
                System.out.printf("%s -> %s\n", name, phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.\n", name);
            }
            search = scanner.nextLine();
        }
    }
}
