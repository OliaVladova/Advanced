package SoftUni.Advanced.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;

public class P4AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Double> parsingDouble = Double::parseDouble;
        UnaryOperator<Double> addVAT = e -> e * 1.2;
        Consumer<Double> printer = num -> System.out.printf("%.2f\n", num);
        String[] prices = (scanner.nextLine().split(", "));

        System.out.println("Prices with VAT:");
        Arrays
                .stream(prices)
                .map(parsingDouble)
                .map(addVAT)
                .forEach(printer);
    }
}
