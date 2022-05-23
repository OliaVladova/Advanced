package SoftUni.Advanced.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (printerQueue.size() >= 1) {
                  String canceled = printerQueue.poll();
                    System.out.printf("Canceled %s\n",canceled);
                }else {
                    System.out.println("Printer is on standby");
                }
            }else {
                printerQueue.offer(input);
            }

            input = scanner.nextLine();
        }
        for (String el : printerQueue){
            System.out.println(el);
        }
    }
}
