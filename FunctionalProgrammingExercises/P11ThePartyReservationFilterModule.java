package SoftUni.Advanced.FunctionalProgrammingExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Print")) {
            String[] commands = input.split(";");
            String[] command = commands[0].split("\\s+");
            String filterType = commands[1];
            String filterParameter = commands[2];
            Predicate<String> startWith = name -> name.startsWith(filterParameter);
            Predicate<String> endWith = name -> name.endsWith(filterParameter);
            Predicate<String> contains = name -> name.contains(filterParameter);
            switch (command[0]){
                case "Add":
                    if (filterType.equals("Starts with")){
                        List<String> toAdd = new ArrayList<>();
                        for (String name : names) {
                            if (startWith.test(name)) {
                                toAdd.add(name);
                            }
                        }
                        names.addAll(toAdd);
                    }else if (filterType.equals("Ends with")){
                        List<String> toAdd = new ArrayList<>();
                        for (String name : names) {
                            if (endWith.test(name)) {
                                toAdd.add(name);
                            }
                        }
                        names.addAll(toAdd);
                    }else if (filterType.equals("Length")){
                        List<String> toAdd = new ArrayList<>();
                        int size = Integer.parseInt(filterParameter);
                        Predicate<String> length = name -> name.length() == size;
                        for (String name : names) {
                            if (length.test(name)) {
                                toAdd.add(name);
                            }
                        }
                        names.addAll(toAdd);
                    }else if (filterType.equals("Contains")){
                        List<String> toAdd = new ArrayList<>();
                        for (String name : names) {
                            if (contains.test(name)) {
                                toAdd.add(name);
                            }
                        }
                        names.addAll(toAdd);
                    }
                    break;
                case "Remove":
                    if (filterType.equals("Starts with")){
                        names.removeIf(startWith);
                    }else if (filterType.equals("Ends with")){
                        names.removeIf(endWith);
                    }else if (filterType.equals("Length")){
                        int size = Integer.parseInt(filterParameter);
                        Predicate<String> length = name -> name.length() == size;
                        names.removeIf(length);
                    }else if (filterType.equals("Contains")){
                        names.removeIf(contains);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        names.stream().forEach(name -> System.out.println(name + " "));
    }
}
