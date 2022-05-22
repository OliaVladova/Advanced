package SoftUni.Advanced.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P2SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(", ");
        Function<String, Integer> parsing = Integer::valueOf;

        List<Integer> nums = Arrays
                .stream(numbers)
                .map(parsing)
                .collect(Collectors.toList());

        System.out.println("Count = " + nums.size());
        int sum = Arrays.stream(numbers). mapToInt(Integer::parseInt).sum();
        System.out.println("Sum = " + sum);
    }
}
