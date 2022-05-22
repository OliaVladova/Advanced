package SoftUni.Advanced.SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> guestsList = new TreeSet<>();
        while (!input.equals("PARTY")) {
            String guests = input;
            guestsList.add(guests);
            input = scanner.nextLine();
        }
        String coming = scanner.nextLine();
        while (!coming.equals("END")) {
            String currGuest = coming;
            guestsList.remove(currGuest);
            coming = scanner.nextLine();
        }
        int absent = guestsList.size();
        System.out.println(absent);
        for (String guest:guestsList) {
            System.out.println(guest);
        }
    }
}
