package SoftUni.Advanced.DefiningClassesExercises.Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputPerson = scanner.nextLine();
        Map<String, Person> people = new HashMap<>();
        while (!inputPerson.equals("End")) {
            String[] person = inputPerson.split("\\s+");
            String name = person[0];
            if (!people.containsKey(name)) {
                people.put(name, new Person());
            }
            switch (person[1]) {
                case "company":
                    //{companyName} {department} {salary}"
                    String companyName = person[2];
                    String department = person[3];
                    double salary = Double.parseDouble(person[4]);
                    Company company = new Company(companyName, department, salary);
                    people.get(name).setCompany(company);
                    break;
                case "pokemon":
                    //{pokemonName} {pokemonType}"
                    String pokemonName = person[2];
                    String pokemonType = person[3];
                    Pokemon newPokemon = new Pokemon(pokemonName, pokemonType);
                    people.get(name).getPokemons().add(newPokemon);
                    break;
                case "parents":
                    String parentName = person[2];
                    String parentBirthday = person[3];
                    Parents parent = new Parents(parentName, parentBirthday);
                    people.get(name).getParents().add(parent);
                    break;
                case "children":
                    String childName = person[2];
                    String childBirthday = person[3];
                    Children child = new Children(childName, childBirthday);
                    people.get(name).getChildren().add(child);
                    break;
                case "car":
                    String carModel = person[2];
                    int speed = Integer.parseInt(person[3]);
                    Car car = new Car(carModel, speed);
                    people.get(name).setCar(car);
                    break;
            }


            inputPerson = scanner.nextLine();
        }
        String searchedPerson = scanner.nextLine();
        System.out.println(searchedPerson);

        //данните на човек
        Person personalData = people.get(searchedPerson);
        System.out.println(personalData);
    }
}
