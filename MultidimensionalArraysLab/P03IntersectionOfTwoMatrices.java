package SoftUni.Advanced.MultidimensionalArraysLab;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        String[][] matrixA = new String[rows][columns];
        String[][] matrixB = new String[rows][columns];
        String[][] matrixC = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < columns; j++) {
                matrixA[i][j] = input[j];
            }
        }
        for (int i = 0; i < rows; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < columns; j++) {
                matrixB[i][j] = input[j];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrixB[i][j].equals(matrixA[i][j])) {
                    matrixC[i][j] = matrixA[i][j];
                } else {
                    matrixC[i][j] = "*";
                }
            }

        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrixC[i][j] + " ");
            }
            System.out.println();
        }
    }
}
