package SoftUni.Advanced.StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        ArrayDeque<Integer> reversed = new ArrayDeque<>();

        for (int i = 0; i < numbers.length ; i++) {
            reversed.push(Integer.valueOf(numbers[i]));
        }
        if (reversed.size()>1) {
            while (reversed.size()>=1){
                System.out.print(reversed.pop()+ " ");
            }
        }else {
            System.out.print(reversed.pop());
        }
    }
}
