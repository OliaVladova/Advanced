package SoftUni.Advanced.MultidimensionalArraysExercises;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);
        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix,rows,columns);
        String input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit")) {
            String[] command = input.split("\\s+");
            int row = Integer.parseInt(command[0]);
            int column = Integer.parseInt(command[1]);
            int radius = Integer.parseInt(command[2]);
            for (int i = row-radius; i <=row+radius ; i++) {
                if (isInMatrix(i,column,matrix)&&i != row){
                    matrix.get(i).remove(column);
                }
            }
            for (int i =column+radius; i >=column-radius ; i--) {
                if (isInMatrix(row,i,matrix)){
                    matrix.get(row).remove(i);
                }
            }
            matrix.removeIf(List::isEmpty);
            input = scanner.nextLine();
        }
        printMatrix(matrix);

    }


    public static void fillMatrix(List<List<Integer>> list, int rows, int columns) {
        int number = 1;
        for (int i = 0; i < rows; i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j < columns; j++) {
                list.get(i).add(number++);
            }
        }
    }
    private static boolean isInMatrix(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }
    private static void printMatrix (List<List<Integer>> matrix){
        for (List<Integer> list :matrix) {
            for (int element:list) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

}
