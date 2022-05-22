package SoftUni.Advanced.MultidimensionalArraysLab;

import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.valueOf(dimensions[0]);
        int columns = Integer.valueOf(dimensions[1]);
        int[][] matrix = new int[rows][columns];
        boolean isFound = false;
        for (int i = 0; i < rows; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < columns; j++) {

                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int num = matrix[i][j];
                if (num==number){
                    isFound = true;
                    System.out.println(i + " " + j);
                }
            }
        }
        if (!isFound){
            System.out.println("not found");
        }
    }
}
