package SoftUni.Advanced.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P3CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> upper =  word -> Character.isUpperCase(word.charAt(0));
        List<String> words = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .filter(upper)
                .collect(Collectors.toList());

        System.out.println(words.size());
        words.forEach(System.out::println);
    }
}
