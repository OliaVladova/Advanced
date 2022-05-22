package SoftUni.Advanced.SetsAndMapsExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> usernames = new LinkedHashSet<>();

        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            String user = scanner.nextLine();
            usernames.add(user);
        }
        for (String user:usernames) {
            System.out.println(user);
        }
    }
}
