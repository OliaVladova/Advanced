package SoftUni.Advanced.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binary = new ArrayDeque<>();
        if (number == 0) {
            System.out.println("0");
        } else {
            while (number != 0) {
                int num = number % 2;
                binary.push(num);
                number /= 2;
            }
            while (binary.size() != 0) {
                System.out.print(binary.pop());
            }
        }
    }
}
