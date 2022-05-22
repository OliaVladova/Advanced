package SoftUni.Advanced.PrepExams;

import java.util.Scanner;

public class P02Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        String[][] field = new String[size][size];
        for (int i = 0; i < size; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            field[i] = input;
        }
        int bombs = 0;
        int sapperRow = 0;
        int sapperCol = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j].equals("s")) {
                    sapperRow = i;
                    sapperCol = j;
                } else if (field[i][j].equals("B")) {
                    bombs++;
                }
            }
        }
        boolean reachedEnd = false;
        for (int i = 0; i < commands.length; i++) {
//left/right/up/down
            switch (commands[i]) {
                case "up":
                    if (sapperRow - 1 >= 0) {
                        field[sapperRow][sapperCol] = "+";
                        sapperRow--;
                    }
                    break;
                case "down":
                    if (sapperRow + 1 <= size - 1) {
                        field[sapperRow][sapperCol] = "+";
                        sapperRow++;
                    }
                    break;
                case "left":
                    if (sapperCol - 1 >= 0) {
                        field[sapperRow][sapperCol] = "+";
                        sapperCol--;
                    }
                    break;
                case "right":
                    if (sapperCol + 1 < size ) {
                        field[sapperRow][sapperCol] = "+";
                        sapperCol++;
                    }
                    break;
            }
            if (field[sapperRow][sapperCol].equals("e")){
                System.out.printf("END! %d bombs left on the field\n",bombs);
                reachedEnd = true;
                break;
            }else if (field[sapperRow][sapperCol].equals("B")){
                field[sapperRow][sapperCol] = "+";
                bombs--;
                System.out.println( "You found a bomb!");
                if (bombs==0){
                    break;
                }

            }
        }
        if (bombs==0){
            System.out.println("Congratulations! You found all bombs!");
        }else if (bombs>0&&!reachedEnd){
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",bombs,sapperRow,sapperCol);
        }

    }
}
