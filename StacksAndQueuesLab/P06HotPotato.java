package SoftUni.Advanced.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] kids = scanner.nextLine().split(" ");
        int passes = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> children = new ArrayDeque<>();
        int counter = 0;

        for (int i = 0; i < kids.length ; i++) {
            children.offer(kids[i]);
        }
        while (children.size()>1){
            counter++;
            if (counter%passes!=0){
                children.offer(children.poll());
            }else {
                String removed = children.poll();
                System.out.printf("Removed %s\n",removed);
            }
        }
        System.out.printf("Last is %s",children.peek());
    }
}
