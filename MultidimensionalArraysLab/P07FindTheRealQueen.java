package SoftUni.Advanced.MultidimensionalArraysLab;

import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];

        for (int i = 0; i < 8; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = input[j];
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean haveMore = false;
                String symbol = matrix[i][j];
                if (symbol.equals("q")) {
                    for (int k = j+1; k < matrix.length; k++) {
                        String symbolNext = matrix[i][k];
                        if (symbolNext.equals("q")) {
                            haveMore = true;
                            break;
                        }else {
                            haveMore = false;
                        }

                    }
                    if (!haveMore) {
                        for (int l = i+1; l < matrix.length; l++) {
                            String symbolNext = matrix[l][j];
                            if (symbolNext.equals("q")) {
                                haveMore = true;
                                break;
                            }else {
                                haveMore = false;
                            }
                        }
                    }
                    if (!haveMore) {
                        for (int l = i+1; l < matrix.length; l++) {
                            String symbolNext = matrix[l][j+1];
                            if (symbolNext.equals("q")) {
                                haveMore = true;
                                break;
                            }else {
                                haveMore = false;
                                break;
                            }
                        }
                    }
                    if (!haveMore) {
                        System.out.print(i + " " + j);
                    }else {
                        break;
                    }
                }
            }
        }
    }
}
