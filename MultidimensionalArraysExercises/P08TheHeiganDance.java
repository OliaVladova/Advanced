package SoftUni.Advanced.MultidimensionalArraysExercises;

import java.util.Scanner;

public class P08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damage = Double.parseDouble(scanner.nextLine());
        String[][] chamber = new String[15][15];
        double heiganPoints = 3000000;
        int playerPoints = 18500;
        int rows = 7;
        int columns = 7;
        String previousCommand = "";
        String spell = "";
        for (int i = 0; i <15 ; i++) {
            for (int j = 0; j <15 ; j++) {
                chamber[i][j] = "-";
            }
        }

        while (true) {
            String[] input = scanner.nextLine().split("\\s+");
            if (heiganPoints <= 0) {
                System.out.println("Heigan: Defeated!");
                System.out.printf("Player: %d\n", playerPoints);
                System.out.printf("Final position: %d, %d", rows, columns);
                break;
            } else if (playerPoints <= 0) {
                System.out.printf("Heigan: %.2f", heiganPoints);
                System.out.println("Player: Killed by " + spell);
                System.out.printf("Final position: %d, %d", rows, columns);
                break;
            } else if (heiganPoints <= 0 && playerPoints <= 0) {
                break;
            } else {
                heiganPoints -= damage;
                if (previousCommand.equals("Cloud")) {
                    playerPoints -= 3500;
                }
                int row = Integer.parseInt(input[1]);
                int column = Integer.parseInt(input[2]);
                switch (input[0]) {
                    case "Cloud":
                        String text = "Plague cloud";
                        fillMatrix(chamber, row, column, text);
                        String[] playerPos = movePerson(chamber, rows, columns).split(" ");
                        rows = Integer.parseInt(playerPos[1]);
                        columns = Integer.parseInt(playerPos[2]);
                        if (playerPos[0].equals("take")) {
                            playerPoints -= 3500;
                        }
                        fillMatrix(chamber,row,column,null);
                        break;
                    case "Eruption":
                        String textToFill = "Eruption";
                        fillMatrix(chamber, row, column, textToFill);
                        String[] playerPosition = movePerson(chamber, rows, columns).split("");
                        rows = Integer.parseInt(playerPosition[1]);
                        columns = Integer.parseInt(playerPosition[2]);
                        if (playerPosition[0].equals("take")) {
                            playerPoints -= 6000;
                        }
                        fillMatrix(chamber,row,column,null);
                        break;
                }
                previousCommand = input[0];
            }
        }
    }

    private static void fillMatrix(String[][] chamber, int row, int column, String text) {
        if (row > 0 && column > 0) {
            if (row + 1 < 15 && column + 1 < 15) {
                chamber[row][column] = text;
                chamber[row - 1][column] = text;
                chamber[row + 1][column] = text;
                chamber[row][column + 1] = text;
                chamber[row][column - 1] = text;
                chamber[row + 1][column - 1] = text;
                chamber[row - 1][column - 1] = text;
                chamber[row + 1][column + 1] = text;
                chamber[row - 1][column + 1] = text;
            } else {
                chamber[row][column] = text;
                chamber[row - 1][column] = text;
                chamber[row + 1][column] = text;
                chamber[row][column - 1] = text;
                chamber[row + 1][column - 1] = text;
                chamber[row - 1][column - 1] = text;
            }
        } else if (row == 0 && column > 0) {
            if (column + 1 < 15) {
                chamber[row][column] = text;
                chamber[row + 1][column] = text;
                chamber[row][column + 1] = text;
                chamber[row][column - 1] = text;
                chamber[row + 1][column - 1] = text;
                chamber[row + 1][column + 1] = text;
            } else {
                chamber[row][column] = text;
                chamber[row + 1][column] = text;
                chamber[row][column - 1] = text;
                chamber[row + 1][column - 1] = text;
            }
        } else if (row > 0 && column == 0) {
            if (row + 1 < 15) {
                chamber[row][column] = text;
                chamber[row + 1][column] = text;
                chamber[row][column + 1] = text;
                chamber[row + 1][column + 1] = text;
                chamber[row - 1][column + 1] = text;
                chamber[row - 1][column] = text;
            } else {
                chamber[row][column] = text;
                chamber[row - 1][column] = text;
                chamber[row][column + 1] = text;
                chamber[row + 1][column + 1] = text;
            }
        }
    }

    public static String movePerson(String[][] chamber, int row, int column) {
        String damage = "";
        String result = "";
        if (!chamber[row][column].equals("-")) {
            if (row - 1 > 0 && chamber[row - 1][column].equals("-")) {
                row -= 1;
            } else if (column + 1 < 15 && chamber[row][column + 1].equals("-")) {
                column += 1;
            } else if (row + 1 < 15 && chamber[row + 1][column].equals("-")) {
                row += 1;
            } else if (column - 1 > 0 && chamber[row][column - 1].equals("-")) {
                column -= 1;
            } else {
                damage += "take";
            }
        }
        return result = damage + " " + String.valueOf(row) + " " + String.valueOf(column);
    }
}
