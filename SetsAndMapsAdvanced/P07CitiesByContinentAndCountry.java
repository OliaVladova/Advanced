package SoftUni.Advanced.SetsAndMapsAdvanced;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numInput = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> continent = new LinkedHashMap<>();

        for (int i = 0; i < numInput; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continentName = input[0];
            String countryName = input[1];
            String townName = input[2];
            if (continent.containsKey(continentName)) {
                LinkedHashMap<String, List<String>> countries = continent.get(continentName);
                if (countries.containsKey(countryName)) {
                    List<String> towns = countries.get(countryName);
                    towns.add(townName);
                    countries.put(countryName, towns);
                    continent.put(continentName, countries);
                }else {
                    List<String> towns = new ArrayList<>();
                    towns.add(townName);
                    countries.put(countryName, towns);
                    continent.put(continentName, countries);
                }
            } else {
                LinkedHashMap<String, List<String>> country = new LinkedHashMap<>();
                List<String> towns = new ArrayList<>();
                towns.add(townName);
                country.put(countryName, towns);
                continent.put(continentName, country);
            }
        }
        continent.forEach((continentN, countries) -> {
            System.out.println(continentN + ":");
            countries.forEach((country, cities) -> {
                System.out.printf("  %s -> %s\n", country, String.join(", ", cities));
            });
        });

    }
}
