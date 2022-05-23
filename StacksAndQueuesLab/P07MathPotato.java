package SoftUni.Advanced.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] kids = scanner.nextLine().split(" ");
        int passes = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> children = new ArrayDeque<>();
        int counter = 0;


        for (int i = 0; i < kids.length; i++) {
            children.offer(kids[i]);
        }
        while (children.size() > 1) {
            counter++;
            for (int i = 1; i < passes; i++) {
                String currentChild = children.poll();
                children.offer(currentChild);
            }
            if (isPrimeCycle(counter)) {
                System.out.println("Prime " + children.peek());
            } else {
                System.out.println("Removed " + children.poll());
            }
        }

        System.out.printf("Last is %s", children.peek());

    }

    private static boolean isPrimeCycle(int cycleCount) {

        if (cycleCount == 1) {
            return false;
        } else if (cycleCount == 2) {
            return true;
        }
        for (int i = 2; i <= cycleCount / 2; i++) {
            if (cycleCount % i == 0) {
                return false;
            }
        }
        return true;
    }
}
