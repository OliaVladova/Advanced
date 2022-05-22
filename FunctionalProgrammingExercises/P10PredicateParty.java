package SoftUni.Advanced.FunctionalProgrammingExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Party!")) {
            String[] commands = input.split("\\s+");
            input = scanner.nextLine();
            String nextCom = commands[1];
            String next = commands[2];
            Predicate<String> startWith = name -> name.startsWith(next);
            Predicate<String> endWith = name -> name.endsWith(next);

            switch (commands[0]) {
                case "Remove":
                    if (nextCom.equals("StartsWith")) {
                        names.removeIf(startWith);
                    } else if (nextCom.equals("EndsWith")) {
                        names.removeIf(endWith);
                    } else if (nextCom.equals("Length")) {
                        int size = Integer.parseInt(next);
                        Predicate<String> length = name -> name.length() == size;
                        names.removeIf(length);
                    }
                    break;
                case "Double":
                    if (nextCom.equals("StartsWith")) {
                        List<String> toAdd = new ArrayList<>();
                        for (String name : names) {
                            if (startWith.test(name)) {
                                toAdd.add(name);
                            }
                        }
                        names.addAll(toAdd);

                    } else if (nextCom.equals("EndsWith")) {
                        List<String> toAdd = new ArrayList<>();
                        for (String name : names) {
                            if (endWith.test(name)) {
                                toAdd.add(name);
                            }
                        }
                        names.addAll(toAdd);
                    } else if (nextCom.equals("Length")) {
                        List<String> toAdd = new ArrayList<>();
                        int size = Integer.parseInt(next);
                        Predicate<String> length = name -> name.length() == size;
                        for (String name : names) {
                            if (length.test(name)) {
                                toAdd.add(name);
                            }
                        }
                        names.addAll(toAdd);
                    }
                    break;
            }
        }
        names = names.stream().sorted().collect(Collectors.toList());
        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        }else {
            List<String> newGuestList = names.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
            System.out.println(String.join(", ", newGuestList) + " are going to the party!");
        }
    }
}
