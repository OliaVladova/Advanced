package SoftUni.Advanced.MultidimensionalArraysExercises;

import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }
        int max = 0;
        int[][] maxMatrix = new int[3][3];

        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < columns - 2; j++) {
                int sum = matrix[i][j] + matrix[i + 1][j] + matrix[i + 2][j] + matrix[i][j + 1] + matrix[i][j + 2] +
                        matrix[i + 1][j + 1] + matrix[i + 2][j + 2] + matrix[i + 2][j + 1] + matrix[i + 1][j + 2];
                if (sum > max) {
                    max = sum;
                    maxMatrix[0][0] = matrix[i][j];
                    maxMatrix[1][0] = matrix[i + 1][j];
                    maxMatrix[2][0] = matrix[i + 2][j];
                    maxMatrix[0][1] = matrix[i][j + 1];
                    maxMatrix[0][2] = matrix[i][j + 2];
                    maxMatrix[1][1] = matrix[i + 1][j + 1];
                    maxMatrix[2][2] = matrix[i + 2][j + 2];
                    maxMatrix[1][2] = matrix[i + 1][j + 2];
                    maxMatrix[2][1] = matrix[i + 2][j + 1];

                }
            }
        }
        System.out.println("Sum = "+max);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(maxMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
