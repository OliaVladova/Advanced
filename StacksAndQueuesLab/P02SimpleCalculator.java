package SoftUni.Advanced.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> calculator = new ArrayDeque<>();

        for (int i = input.length-1; i >= 0 ; i--) {
            calculator.push(input[i]);
        }

        while (calculator.size()>1){
            int first = Integer.parseInt(calculator.pop());
            String operation = calculator.pop();
            int second = Integer.parseInt(calculator.pop());
            int sum = 0;
            if (operation.equals("+")){
               sum = first+second;
               calculator.push(String.valueOf(sum));
            }else {
                sum = first-second;
                calculator.push(String.valueOf(sum));
            }
        }
        System.out.println(calculator.peek());
    }
}
