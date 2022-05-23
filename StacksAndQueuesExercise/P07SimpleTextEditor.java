package SoftUni.Advanced.StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int operations = Integer.parseInt(scanner.nextLine());
        String text = "";

        ArrayDeque<String> word = new ArrayDeque<>();
        word.push(text);
        for (int i = 0; i < operations; i++) {
            String[] inputCom = scanner.nextLine().split(" ");
            switch (inputCom[0]) {
                case "1":
                    text += inputCom[1];
                    word.push(text);
                    break;
                case "2":
                    int count = Integer.parseInt(inputCom[1]);
                    String subStr = text.substring(text.length() - count);
                    text = text.replace(subStr, "");

                    word.push(text);
                    break;
                case "3":
                    int index = Integer.parseInt(inputCom[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    word.pop();
                    text = word.peek();
                    break;
            }
        }
    }
}
