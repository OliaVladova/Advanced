package SoftUni.Advanced.PrepExams;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P01Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        List<Integer> claimedItems = new ArrayList<>();
        String[] first = scanner.nextLine().split("\\s+");

        for (int i = 0; i < first.length; i++) {
            queue.offer(Integer.valueOf(first[i]));
        }

        String[] second = scanner.nextLine().split("\\s+");

        for (int i = 0; i < second.length ; i++) {
            stack.push(Integer.valueOf(second[i]));
        }
        while (!stack.isEmpty() && !queue.isEmpty()) {
            int sum = queue.peek() + stack.peek();
            if (sum % 2 == 0) {
                claimedItems.add(sum);
                queue.poll();
                stack.pop();
            } else {
               int removed = stack.pop();
                queue.offer(removed);
            }
        }
        if (stack.isEmpty()){
            System.out.println("Second lootbox is empty");
        }else if (queue.isEmpty()){
            System.out.println("First lootbox is empty");
        }
        int total = 0;
        for (Integer num:claimedItems) {
            total+=num;
        }
        if (total>=100){
            System.out.printf("Your loot was epic! Value: %d",total);
        }else {
            System.out.printf("Your loot was poor... Value: %d",total);
        }


    }
}
