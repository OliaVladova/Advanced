package SoftUni.Advanced.FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        List<String> names = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        Predicate<String> areLess = name -> name.length() <= length;
        names.stream().filter(areLess).forEach(e -> System.out.println(e));
    }
}
