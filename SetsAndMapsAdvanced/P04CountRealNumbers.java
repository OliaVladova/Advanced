package SoftUni.Advanced.SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Double, Integer> numbers = new LinkedHashMap<>();
        String[] input = scanner.nextLine().split(" ");
        for (int i = 0; i < input.length ; i++) {
            double num = Double.parseDouble(input[i]);
            if (numbers.containsKey(num)){
                numbers.put(num,numbers.get(num)+1);
            }else {
                numbers.put(num,1);
            }
        }
        for (Map.Entry<Double,Integer> number:numbers.entrySet()) {
            System.out.printf("%.1f -> %d\n",number.getKey(),number.getValue());
        }
    }
}
