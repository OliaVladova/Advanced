package SoftUni.Advanced.MultidimensionalArraysExercises;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        char[][] palindrome = new char[3][3];
        char symbol = 'a';
        for (int i = 0; i < Integer.valueOf(input[0]); i++) {

            for (int j = 0; j < Integer.valueOf(input[1]); j++) {
                System.out.printf("%c%c%c ",symbol,(symbol+j),symbol);
            }
            symbol++;
            System.out.println();
        }
    }
}
