package SoftUni.Advanced.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> index = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {

            char currentSymbol = input.charAt(i);

            if (currentSymbol == '(') {
                index.push(i);
            } else if (currentSymbol == ')') {
                int startIndex = index.pop();
                String subExpression = input.substring(startIndex, i + 1);
                System.out.println(subExpression);
            }
        }
    }
}
