package SoftUni.Advanced.PrepExams;

import java.util.Scanner;

public class P02Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] input = scanner.nextLine().split("");
            matrix[i] = input;
        }
        int snakeRow = 0;
        int snakeCol = 0;
        boolean outOfBounds = false;
        int foodCount = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j].equals("S")) {
                    snakeRow = i;
                    snakeCol = j;
                }
            }
        }
        String direction = scanner.nextLine();
        matrix[snakeRow][snakeCol] = ".";
        while (!direction.equals("")){
            switch (direction){
                case "up":
                    snakeRow--;
                    break;
                case "down":
                    snakeRow++;
                    break;
                case "left":
                    snakeCol--;
                    break;
                case "right":
                    snakeCol++;
                    break;
            }
            if(snakeRow >= 0 && snakeRow < size && snakeCol >= 0 && snakeCol < size){
                if(matrix[snakeRow][snakeCol].equals("B")){
                    matrix[snakeRow][snakeCol] = ".";
                    for (int row = 0; row < size; row++) {
                        for (int col = 0; col < size; col++) {
                            if(matrix[row][col].equals("B") && row!= snakeRow && col != snakeCol){
                                //the end of the lair
                                snakeRow = row;
                                snakeCol = col;
                                matrix[snakeRow][snakeCol] = ".";
                            }
                        }
                    }
                }else if(matrix[snakeRow][snakeCol].equals("*")){
                    foodCount++;
                    matrix[snakeRow][snakeCol] = ".";
                }else {
                    matrix[snakeRow][snakeCol] = ".";
                }
            }else {
                outOfBounds = true;
            }
            if(outOfBounds || foodCount == 10){
                break;
            }

            direction = scanner.nextLine();
        }
        if(outOfBounds){
            System.out.println("Game over!");
        }else {
            matrix[snakeRow][snakeCol] = "S";
        }
        if(foodCount == 10){
            System.out.println("You won! You fed the snake.");
        }

        System.out.printf("Food eaten: %d\n",foodCount);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%s",matrix[i][j]);
            }
            System.out.println();
        }
    }
}
