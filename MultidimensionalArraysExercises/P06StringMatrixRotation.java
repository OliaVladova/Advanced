package SoftUni.Advanced.MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotation = scanner.nextLine();
        String input = scanner.nextLine();
        int angle = Integer.parseInt(rotation.split("[()]+")[1]) % 360;

        List<String> lines = new ArrayList<>();
        int size = 0;
        while (!input.equals("END")) {
            String text = input;
            lines.add(text);
            if (text.length() > size) {
                size = text.length();
            }
            input = scanner.nextLine();
        }
        int rows = lines.size();
        int columns = size;

        char[][] textMatrix = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j < lines.get(i).length()) {
                    textMatrix[i][j] = lines.get(i).charAt(j);
                } else {
                    textMatrix[i][j] = ' ';
                }
            }
        }
        rotateMatrix(textMatrix,angle,rows,columns);
    }

    public static void rotateMatrix(char[][] matrix, int degree, int rows, int columns) {
        if (degree == 90) {
            for (int col = 0; col < columns ; col++) {
                for (int row = rows - 1; row >= 0 ; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }

        } else if (degree == 180) {
            for (int i = rows - 1; i >= 0; i--) {
                for (int j = columns - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        } else if (degree == 270) {

            for (int j = columns - 1; j >= 0; j--) {
                for (int i = 0; i < rows; i++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i<rows; i++) {
                for (int j = 0; j <columns; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
    }
}
