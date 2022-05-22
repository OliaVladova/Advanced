package SoftUni.Advanced.PrepExams;

import java.util.Scanner;

public class P02Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] territory = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] input = scanner.nextLine().split("");
            territory[i] = input;
        }
        int beeRow = 0;
        int beeCol = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (territory[i][j].equals("B")) {
                    beeRow = i;
                    beeCol = j;
                }
            }
        }
        int flowers = 0;
        territory[beeRow][beeCol] = ".";
        boolean flyAway = false;
        String commands = scanner.nextLine();
        while (!commands.equals("End")) {
            switch (commands) {
                case "up":
                    beeRow--;
                    break;
                case "down":
                    beeRow++;
                    break;
                case "left":
                    beeCol--;
                    break;
                case "right":
                    beeCol++;
                    break;
            }
            if (beeRow >= 0 && beeRow < size && beeCol >= 0 && beeCol < size) {
                if (territory[beeRow][beeCol].equals("f")) {
                    flowers++;
                    territory[beeRow][beeCol] = ".";
                } else if (territory[beeRow][beeCol].equals("O")) {
                    territory[beeRow][beeCol] = ".";
                    switch (commands) {
                        case "up":
                            beeRow--;
                            break;
                        case "down":
                            beeRow++;
                            break;
                        case "left":
                            beeCol--;
                            break;
                        case "right":
                            beeCol++;
                            break;
                    }
                    if (beeRow >= 0 && beeRow < size && beeCol >= 0 && beeCol < size) {
                        if (territory[beeRow][beeCol].equals("f")) {
                            flowers++;
                        }
                        territory[beeRow][beeCol] = ".";
                    } else {
                        flyAway = true;
                    }
                }
                } else {
                    flyAway = true;
                    break;
                }
                commands = scanner.nextLine();
            }


        if (!flyAway) {
            territory[beeRow][beeCol] = "B";
        } else {
            System.out.println("The bee got lost!");
        }
        if (flowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", flowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - flowers);
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%s", territory[i][j]);
            }
            System.out.println();
        }
    }
}
