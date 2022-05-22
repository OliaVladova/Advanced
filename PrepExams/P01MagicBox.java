package SoftUni.Advanced.PrepExams;

import java.util.*;

public class P01MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstInput = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondInput = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> firstQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondStack = new ArrayDeque<>();
        List<Integer> collected = new ArrayList<>();
        for (int i = 0; i < firstInput.length; i++) {
            firstQueue.offer(firstInput[i]);
        }

        for (int i = 0; i < secondInput.length; i++) {
            secondStack.push(secondInput[i]);
        }
        while (!secondStack.isEmpty() && !firstQueue.isEmpty()) {
            int sum = secondStack.peek() + firstQueue.peek();
            if (sum % 2 == 0){
                collected.add(sum);
                secondStack.pop();
                firstQueue.poll();
            }else {
                int toAdd = secondStack.pop();
                firstQueue.offer(toAdd);
            }
        }
        if (firstQueue.isEmpty()){
            System.out.println("First magic box is empty.");
        }
        if (secondStack.isEmpty()){
            System.out.println("Second magic box is empty.");
        }
        int totalSum = 0;
        for (Integer num:collected ) {
            totalSum+=num;
        }
        if (totalSum>=90){
            System.out.printf("Wow, your prey was epic! Value: %d",totalSum);
        }else {
            System.out.printf("Poor prey... Value: %d",totalSum);
        }
    }
}
