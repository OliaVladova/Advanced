package SoftUni.Advanced.DefiningClassesExercises.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {
            String[] data = input.split("\\s+");

            String trainerName = data[0];
            String pokemonName = data[1];
            String element = data[2];
            int health = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, health);

            trainers.putIfAbsent(trainerName, new Trainer());
            trainers.get(trainerName).addPokemon(pokemon);

            input = scanner.nextLine();
        }


        input = scanner.nextLine();
        while (!input.equals("End")) {

            for (Map.Entry<String, Trainer> trainer : trainers.entrySet()) {
                if (trainer.getValue().pokemonSize() > 0) {
                    boolean havePokemon = false;
                    for (Pokemon pokemon : trainer.getValue().getPokemons()) {
                        if (pokemon.getElement().equals(input)) {
                            havePokemon = true;
                            trainer.getValue().setNumOfBadges();
                            break;
                        }
                    }
                    if (!havePokemon) {
                        trainer.getValue().missingPokemonPenalty();
                    }
                }
            }
            input = scanner.nextLine();
        }

        trainers.entrySet().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getValue().getNumberBadges(), b1.getValue().getNumberBadges()))
                .forEach(t -> {
                    System.out.printf("%s %s %s%n", t.getKey(),
                            t.getValue().getNumberBadges(),
                            t.getValue().pokemonSize());
                });
    }
}
