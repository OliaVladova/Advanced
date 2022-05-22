package SoftUni.Advanced.PrepExams;

import java.util.Scanner;

public class P02ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeMatrix = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[sizeMatrix][sizeMatrix];
        int commands = Integer.parseInt(scanner.nextLine());
        int playerRow = 0;
        int playerColumn = 0;
        boolean haveFinished = false;

        for (int i = 0; i < sizeMatrix; i++) {
            String[] input = scanner.nextLine().split("");
            for (int j = 0; j < sizeMatrix; j++) {
                matrix[i][j] = input[j];
            }
        }
        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                String field = matrix[i][j];
                if (field.equals("f")) {
                    playerRow = i;
                    playerColumn = j;
                }
            }
        }
        matrix[playerRow][playerColumn] = "-";
        for (int i = 0; i < commands; i++) {
            String command = scanner.nextLine();

            switch (command){
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "left":
                    playerColumn--;
                    break;
                case "right":
                    playerColumn++;
                    break;
            }
            if(playerRow < 0){
                playerRow = sizeMatrix - 1;
            }else if(playerRow >= sizeMatrix){
                playerRow = 0;
            }
            if(playerColumn < 0){
                playerColumn = sizeMatrix - 1;
            }else if(playerColumn >= sizeMatrix){
                playerColumn = 0;
            }
            if(matrix[playerRow][playerColumn].equals("B")){
                if(command.equals("up")) {
                    playerRow--;
                } else if (command.equals("down")) {
                    playerRow++;
                } else if (command.equals("left")) {
                    playerColumn--;
                } else if (command.equals("right")) {
                    playerColumn++;
                }
            } else if (matrix[playerRow][playerColumn].equals("T")) {
                if(command.equals("up")) {
                    playerRow++;
                } else if (command.equals("down")) {
                    playerRow--;
                } else if (command.equals("left")) {
                    playerColumn++;
                } else if (command.equals("right")) {
                    playerColumn--;
                }
            }
            if(playerRow < 0){
                playerRow = sizeMatrix - 1;
            }else if(playerRow >= sizeMatrix){
                playerRow = 0;
            }
            if(playerColumn < 0){
                playerColumn = sizeMatrix - 1;
            }else if(playerColumn >= sizeMatrix){
                playerColumn = 0;
            }
            if(matrix[playerRow][playerColumn].equals("F")){
                matrix[playerRow][playerColumn] = "f";
                haveFinished = true;
                break;
            }
        }
        if (!haveFinished) {
            System.out.println("Player lost!");
        }else {
            System.out.println("Player won!");
        }
        matrix[playerRow][playerColumn] = "f";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%s", matrix[i][j]);
            }
            System.out.println();
        }

    }

    public static int[] movePlayer(String command, int playerRow, int playerColumn, String[][] matrix) {
        int[] returnedPlayer = new int[2];
        switch (command) {
            case "up":
                if (playerRow - 1 >= 0) {
                    matrix[playerRow][playerColumn] = "-";
                    playerRow = playerRow - 1;
                } else {
                    matrix[playerRow][playerColumn] = "-";
                    playerRow = matrix.length - 1;
                }
                break;
            case "down":
                if (playerRow + 1 <= matrix.length - 1) {
                    matrix[playerRow][playerColumn] = "-";
                    playerRow = playerRow + 1;
                } else {
                    matrix[playerRow + 1][playerColumn] = "-";
                    playerRow = 0;
                }
                break;
            case "left":
                if (playerColumn - 1 >= 0) {
                    matrix[playerRow][playerColumn] = "-";
                    playerColumn = playerColumn - 1;
                } else {
                    matrix[playerRow][playerColumn] = "-";
                    playerColumn = matrix.length - 1;
                }
                break;
            case "right":
                if (playerColumn + 1 <= matrix.length - 1) {
                    matrix[playerRow][playerColumn] = "-";
                    playerColumn = playerColumn + 1;
                } else {
                    matrix[playerRow][playerColumn] = "-";
                    playerColumn = 0;
                }
                break;
        }
        returnedPlayer[0] = playerRow;
        returnedPlayer[1] = playerColumn;
        return returnedPlayer;
    }
}
