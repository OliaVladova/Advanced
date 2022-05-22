package SoftUni.Advanced.SetsAndMapsExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> elements = new TreeSet<>();
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            String[] element = scanner.nextLine().split("\\s+");
            elements.addAll(Arrays.asList(element));

        }
        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
