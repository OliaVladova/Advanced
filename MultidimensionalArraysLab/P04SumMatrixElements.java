package SoftUni.Advanced.MultidimensionalArraysLab;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputForMatrix = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(inputForMatrix[0]);
        int columns = Integer.parseInt(inputForMatrix[1]);
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i <rows ; i++) {
            String[] input = scanner.nextLine().split(", ");
            for (int j = 0; j <columns ; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }
        int sum = 0;
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <columns ; j++) {
                sum +=matrix[i][j];
            }
        }
        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sum);
    }
}
