package SoftUni.Advanced.FunctionalProgrammingExercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        List<Integer> numbersCheck = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            numbers.add(i);
        }

        Predicate<Integer> printing = number -> {
            for (int i = 0; i < numbersCheck.size(); i++) {
                if (number % numbersCheck.get(i) != 0) {
                    return false;
                }
            }
            return true;
        };
        numbers.stream().filter(printing).forEach(e -> System.out.printf("%d ",e));

    }
}
