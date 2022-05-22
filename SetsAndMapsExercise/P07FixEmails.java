package SoftUni.Advanced.SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> emailsList = new LinkedHashMap<>();

        while (true) {
            String name = scanner.nextLine();
            if (name.equals("stop")) {
                break;
            } else {
                String email = scanner.nextLine();
                if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                    emailsList.put(name, email);
                }
            }
        }
        for (Map.Entry<String, String> email : emailsList.entrySet()) {
            System.out.printf("%s -> %s\n",email.getKey(),email.getValue());
        }
    }
}
