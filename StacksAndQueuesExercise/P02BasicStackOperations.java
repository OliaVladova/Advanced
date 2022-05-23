package SoftUni.Advanced.StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] instructions = scanner.nextLine().split("\\s+");
        String[] numbers = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();
        int toPush = Integer.parseInt(instructions[0]);
        int toPop = Integer.parseInt(instructions[1]);
        int toCheck = Integer.parseInt(instructions[2]);

        for (int i = 0; i <toPush ; i++) {
            numbersStack.push(Integer.valueOf(numbers[i]));
        }
        for (int i = 0; i <toPop ; i++) {
            numbersStack.pop();
        }
        boolean isHere = false;
       if (numbersStack.size()>0){
           for (int i = 0; i <numbersStack.size() ; i++) {
               if (numbersStack.contains(toCheck)){
                   System.out.println("true");
                   isHere = true;
                   break;
               }
           }
           if (!isHere){
               System.out.println(Collections.min(numbersStack));
           }
       }else {
           System.out.println("0");
       }

    }
}
