package SoftUni.Advanced.PrepExams;

import java.util.Scanner;

public class P02Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] bakery = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] input = scanner.nextLine().split("");
            bakery[i] = input;
        }
        int myRow = 0;
        int myCol = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (bakery[i][j].equals("S")) {
                    myRow = i;
                    myCol = j;
                }
            }
        }
        bakery[myRow][myCol] = "-";
        int money = 0;
        boolean out = false;
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
            }
            if (myRow >= 0 && myRow < size && myCol >= 0 && myCol < size) {
                if (bakery[myRow][myCol].equals("O")) {
                    bakery[myRow][myCol] = "-";
                    for (int i = 0; i <size ; i++) {
                        for (int j = 0; j < size; j++) {
                            if (bakery[i][j].equals("O")){
                                myRow = i;
                                myCol = j;
                            }
                        }
                    }
                    bakery[myRow][myCol] = "-";
                } else if (!bakery[myRow][myCol].equals("-")) {
                    int customer = Integer.parseInt(bakery[myRow][myCol]);
                    bakery[myRow][myCol] = "-";
                    money += customer;
                }
            } else {
                out = true;
            }
            if (money >= 50) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }
            if (out) {
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }
        }
        if (!out) {
            bakery[myRow][myCol] = "S";
        }
        System.out.printf("Money: %d\n", money);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%s",bakery[i][j]);
            }
            System.out.println();
        }
    }
}
