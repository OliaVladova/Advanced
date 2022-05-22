package SoftUni.Advanced.SetsAndMapsExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizes = scanner.nextLine().split("\\s+");
        int first = Integer.parseInt(sizes[0]);
        int second = Integer.parseInt(sizes[1]);
        int times = first + second;
        LinkedHashSet<Integer> setOne = new LinkedHashSet<>();
        LinkedHashSet<Integer> setTwo = new LinkedHashSet<>();
        LinkedHashSet<Integer> setThree = new LinkedHashSet<>();

            for (int j = 0; j < first; j++) {
                int number = Integer.parseInt(scanner.nextLine());
                setOne.add(number);
            }
            for (int j = 0; j < second; j++) {
                int num = Integer.parseInt(scanner.nextLine());
                setTwo.add(num);
            }

        for (Integer number : setOne) {
            if (setTwo.contains(number)) {
                setThree.add(number);
            }
        }
        for (Integer num : setThree) {
            System.out.print(num + " ");
        }

    }
}
