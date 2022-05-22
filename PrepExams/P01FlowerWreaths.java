package SoftUni.Advanced.PrepExams;

import java.util.*;

public class P01FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();

        List<Integer> stored = new ArrayList<>();
        int[] roses = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < roses.length; i++) {
            rosesQueue.offer(roses[i]);
        }
        int[] lilies = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < lilies.length; i++) {
            liliesStack.push(lilies[i]);
        }

        int wreath = 0;
        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
            int flowers = liliesStack.peek() + rosesQueue.peek();
            if (flowers == 15) {
                wreath++;
                liliesStack.pop();
                rosesQueue.poll();
            } else if (flowers > 15) {
                int newLily = liliesStack.pop() - 2;
                liliesStack.push(newLily);
            }else {
                stored.add(flowers);
                liliesStack.pop();
                rosesQueue.poll();
            }
        }
        if (!stored.isEmpty()){
            int sumFlowers =0;
            for (Integer flower:stored) {
                sumFlowers+=flower;
            }
            sumFlowers = sumFlowers/15;
            wreath+=sumFlowers;
        }
        if (wreath>=5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!",wreath);
        }else {
            System.out.printf("You didn't make it, you need %d wreaths more!",5 - wreath);
        }
    }
}
