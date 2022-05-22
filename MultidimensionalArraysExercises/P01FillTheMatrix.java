package SoftUni.Advanced.MultidimensionalArraysExercises;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int dimensions = Integer.parseInt(input[0]);
        String type = input[1];

        switch (type) {
            case "A":
                int[][] matrixOne = matrixA(dimensions);
                printMatrix(matrixOne);
                break;
            case "B":
                int[][] matrixTwo = matrixB(dimensions);
                printMatrix(matrixTwo);
                break;
        }
    }

    public static int[][] matrixA(int dimensions) {
        int[][] matrix = new int[dimensions][dimensions];
        int number = 0;
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                number++;
                matrix[j][i] = number;
            }

        }
        return matrix;
    }

    public static int[][] matrixB(int dimensions) {
        int[][] matrix = new int[dimensions][dimensions];
        int num = 0;
        for (int i = 0; i < dimensions; i++) {

            if (i % 2 == 0) {
                for (int j = 0; j < dimensions; j++) {
                    num++;
                    matrix[j][i] = num ;
                }
            } else {
                for (int j = dimensions-1; j >= 0; j--) {
                    num++;
                    matrix[j][i] = num ;
                }
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
