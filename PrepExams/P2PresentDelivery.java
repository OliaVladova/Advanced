package SoftUni.Advanced.PrepExams;

import java.util.Scanner;

public class P2PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPresents = Integer.parseInt(scanner.nextLine());
        int sizeMatrix = Integer.parseInt(scanner.nextLine());

        String[][] neighborhood = new String[sizeMatrix][sizeMatrix];
        for (int i = 0; i < sizeMatrix; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            neighborhood[i] = input;
        }
        int santaRow = 0;
        int santaColumn = 0;
        int niceKids = 0;
        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                String word = neighborhood[i][j];
                if (word.equals("S")) {
                    santaRow = i;
                    santaColumn = j;
                }
            }
        }
        String inputCom = scanner.nextLine();
        while (!inputCom.equals("Christmas morning")) {
            if (countPresents <= 0) {
                break;
            }
            String direction = inputCom;
            switch (direction) {
                case "up":
                    if (santaRow - 1 >= 0) {
                        neighborhood[santaRow][santaColumn] = "-";
                        santaRow = santaRow - 1;
                    }else {
                        System.out.println("Santa ran out of presents!");
                        break;
                    }
                    break;
                case "down":
                    if (santaRow + 1 < neighborhood.length) {
                        neighborhood[santaRow][santaColumn] = "-";
                        santaRow = santaRow + 1;
                    }else {
                        System.out.println("Santa ran out of presents!");
                        break;
                    }
                    break;
                case "left":
                    if (santaColumn - 1 >= 0) {
                        neighborhood[santaRow][santaColumn] = "-";
                        santaColumn = santaColumn - 1;
                    }else {
                        System.out.println("Santa ran out of presents!");
                        break;
                    }
                    break;
                case "right":
                    if (santaColumn + 1 < neighborhood.length) {
                        neighborhood[santaRow][santaColumn] = "-";
                        santaColumn = santaColumn + 1;
                    }
                    else {
                        System.out.println("Santa ran out of presents!");
                        break;
                    }
                    break;
            }
            if (neighborhood[santaRow][santaColumn].equals("V")) {
                neighborhood[santaRow][santaColumn] = "-";
                countPresents--;
                niceKids++;
            } else if (neighborhood[santaRow][santaColumn].equals("C")) {
                neighborhood[santaRow][santaColumn] = "-";
                if (santaRow - 1 >= 0 && !neighborhood[santaRow][santaColumn - 1].equals("-")) {
                    neighborhood[santaRow - 1][santaColumn] = "-";
                    if (countPresents>0) {
                        countPresents--;
                    }
                }
                if (santaRow + 1 < neighborhood.length && !neighborhood[santaRow][santaColumn + 1].equals("-")) {
                    neighborhood[santaRow][santaColumn + 1] = "-";
                    if (countPresents>0) {
                        countPresents--;
                    }
                }
                if (santaColumn - 1 >= 0 && !neighborhood[santaRow][santaColumn - 1].equals("-")) {
                    neighborhood[santaRow][santaColumn - 1] = "-";
                    if (countPresents>0) {
                        countPresents--;
                    }
                }
                if (santaColumn + 1 < neighborhood.length && !neighborhood[santaRow][santaColumn + 1].equals("-") ) {
                    neighborhood[santaRow][santaColumn + 1] = "-";
                    if (countPresents>0) {
                        countPresents--;
                    }
                }
            }
            if (countPresents <= 0) {
                break;
            }
            inputCom = scanner.nextLine();
        }
        neighborhood[santaRow][santaColumn] = "S";
        if (countPresents<=0){
            System.out.println("Santa ran out of presents!");
        }
        int kidsLeft = 0;
        for (int i = 0; i <sizeMatrix ; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                System.out.printf("%s ", neighborhood[i][j]);
                if (neighborhood[i][j].equals("V")){
                    kidsLeft++;
                }
            }
            System.out.println();
        }
        if (kidsLeft==0){
            System.out.printf("Good job, Santa! %d happy nice kid/s.\n",niceKids);
        }else {
            System.out.printf("No presents for %d nice kid/s.\n",kidsLeft);
        }
    }
}
