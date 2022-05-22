package SoftUni.Advanced.PrepExams;

import java.util.Scanner;

public class P02CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] pastry = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] input = scanner.nextLine().split("");
            pastry[i] = input;
        }

        int myRow = 0;
        int myCol = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (pastry[i][j].equals("S")) {
                    myRow = i;
                    myCol = j;
                }
            }
        }
        pastry[myRow][myCol] = "-";
        boolean out = false;
        int money = 0;
        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                   myRow--;
                    break;
                case "down":
                    myRow++;
                    break;
                case "left":
                    myCol--;
                    break;
                case "right":
                    myCol++;
                    break;

            }if (myRow >= 0 && myRow < size && myCol >= 0 && myCol < size){

            if (pastry[myRow][myCol].equals("P")) {
                pastry[myRow][myCol] = "-";
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (pastry[i][j].equals("P")) {
                            myRow = i;
                            myCol = j;
                        }
                    }
                }
                pastry[myRow][myCol] = "-";
            } else if (!pastry[myRow][myCol].equals("-")) {
                int clientMoney = Integer.parseInt(pastry[myRow][myCol]);
                money += clientMoney;
                pastry[myRow][myCol] = "-";
            }
            }else {
                out = true;
            }

            if (out) {
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }
            if (money >= 50) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }
        }
        System.out.printf("Money: %d\n", money);
        if (!out) {
            pastry[myRow][myCol] = "S";
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%s",pastry[i][j]);
            }
            System.out.println();
        }
    }
}
