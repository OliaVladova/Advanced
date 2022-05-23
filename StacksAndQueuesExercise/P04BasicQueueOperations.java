package SoftUni.Advanced.StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        String[] inputNum = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> numbersQueue = new ArrayDeque<>();
        int numbersToOffer = Integer.parseInt(input[0]);
        int numbersToPop = Integer.parseInt(input[1]);
        int toCheck = Integer.parseInt(input[2]);
        boolean isHere = false;

        for (int i = 0; i < numbersToOffer; i++) {
            numbersQueue.offer(Integer.valueOf(inputNum[i]));
        }
        for (int i = 0; i <numbersToPop ; i++) {
            numbersQueue.pop();
        }
        if(numbersQueue.size()>0){
            for (int i = 0; i <numbersQueue.size() ; i++) {
                if (numbersQueue.contains(toCheck)){
                    System.out.println("true");
                    isHere = true;
                    break;
                }
            }
            if (!isHere){
                System.out.println(Collections.min(numbersQueue));
            }
        }else {
            System.out.println("0");
        }
    }
}
