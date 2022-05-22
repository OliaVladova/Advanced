package SoftUni.Advanced.DefiningClassesExercises.OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name, age);
            people.add(person);
        }

        people.sort(Comparator.comparing(Person::getName));
        people.stream().filter(person -> person.getAge() > 30).forEach(person -> System.out.println(person.getName() + " - " + person.getAge()));
    }
}
