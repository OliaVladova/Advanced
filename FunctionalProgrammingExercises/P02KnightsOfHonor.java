package SoftUni.Advanced.FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> name = e -> System.out.println("Sir " + e);
        List<String> people = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        people.forEach(name);
    }
}
