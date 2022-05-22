package SoftUni.Advanced.MultidimensionalArraysExercises;

import java.util.Scanner;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        int row = rows-1;
        int column = columns-1;
        while (row!=-1){
            int r = row;
            int c = column;
            while (c<columns&&r>=0){
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            column--;
            if (column==-1){
                column = 0;
                row--;
            }
        }

    }
}
