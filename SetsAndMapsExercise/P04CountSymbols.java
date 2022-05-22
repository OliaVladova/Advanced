package SoftUni.Advanced.SetsAndMapsExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Character , Integer> symbols = new TreeMap<>();
        String characters = scanner.nextLine();
        for (int i = 0; i < characters.length() ; i++) {
            char symbol = characters.charAt(i);
            if (symbols.containsKey(symbol)){
                symbols.put(symbol,symbols.get(symbol) + 1);
            }else {
                symbols.put(symbol,1);
            }
        }
        for (Map.Entry<Character, Integer> symbol: symbols.entrySet()) {
            //i: 1 time/s
            System.out.println(symbol.getKey() + ": " + symbol.getValue() + " time/s");
        }
    }
}
