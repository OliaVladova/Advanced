package SoftUni.Advanced.MultidimensionalArraysExercises;

import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }
        int firstSum = 0;
        int secondSum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j==i){
                    firstSum+=matrix[i][j];
                }
                if ((j+i)==size-1){
                    secondSum+=matrix[i][j];
                }
            }
        }
        int difference = Math.abs(firstSum-secondSum);
        System.out.println(difference);
    }
}
