package SoftUni.Advanced.MultidimensionalArraysLab;

import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (i==j){
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
        System.out.println();
        for (int i = dimension-1; i >= 0; i--) {
            for (int j = 0;j < dimension; j++) {
                if (i+j==dimension-1){
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }
}
