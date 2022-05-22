package SoftUni.Advanced.PrepExams;

import java.util.*;

public class P01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tulips = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] daffodils = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        for (int i = 0; i < daffodils.length; i++) {
            daffodilsQueue.offer(daffodils[i]);
        }
        for (int i = 0; i < tulips.length; i++) {
            tulipsStack.push(tulips[i]);
        }

        int bouquets = 0;
        List<Integer> stored = new ArrayList<>();
        while (!daffodilsQueue.isEmpty() && !tulipsStack.isEmpty()) {
            int sum = daffodilsQueue.peek() + tulipsStack.peek();
            if (sum == 15) {
                bouquets++;
                daffodilsQueue.poll();
                tulipsStack.pop();
            } else if (sum > 15) {
                int decreased = tulipsStack.pop() - 2;
                tulipsStack.push(decreased);
            }else {
                stored.add(sum);
                daffodilsQueue.poll();
                tulipsStack.pop();
            }
        }
        int total = 0;
        for (Integer flower:stored) {
            total+=flower;
        }
        total/=15;
        bouquets+=total;
        if (bouquets>=5){
            System.out.printf("You made it! You go to the competition with %d bouquets!",bouquets);
        }else {
            System.out.printf("You failed... You need more %d bouquets.",5 - bouquets);
        }
    }
}
