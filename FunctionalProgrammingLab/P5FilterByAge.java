package SoftUni.Advanced.FunctionalProgrammingLab;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class P5FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> people = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            if (people.containsKey(name)) {
                people.put(name, age);
            } else {
                people.put(name, age);
            }

        }
        String condition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Consumer<Map.Entry<String, Integer>> printing;

        if (format.equals("name")) {
            printing = person -> System.out.println(person.getKey());
        } else if (format.equals("age")) {
            printing = person -> System.out.println(person.getValue());
        } else {
            printing = person -> System.out.println(person.getKey() + " - " + person.getValue());
        }

        BiPredicate<Integer, Integer> filterAge;
        if (condition.equals("younger")) {
            filterAge = (personAge, age) -> personAge <= age;
        } else {
            filterAge = (personAge, age) -> personAge >= age;
        }
        people.entrySet()
                .stream()
                .filter(person -> filterAge.test(person.getValue(), ageLimit))
                .forEach(printing);
    }
}
