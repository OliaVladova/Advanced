package SoftUni.Advanced.FunctionalProgrammingLab;

import jdk.jshell.spi.SPIResolutionException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        List<Integer> numbers = new ArrayList<>();
        String type = scanner.nextLine();
        Predicate<Integer> filter;
        Consumer<Integer> printing = e -> System.out.print(e + " ");
        if (type.equals("odd")) {
            filter = e -> e % 2 != 0;
        } else {
            filter = e -> e % 2 == 0;
        }
        for (int i = start; i <= end; i++) {
            numbers.add(i);
        }
        numbers.stream().filter(filter).forEach(printing);


    }
}
